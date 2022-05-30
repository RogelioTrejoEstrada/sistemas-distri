// Dependencias
const pool = require('../config/database');
const { v4: uuidv4 } = require("uuid");
const { status } = require("grpc");

const getAll = async (_, callback) => {
    // BObtengo a todos los clientes
    const SQL = "SELECT * FROM customers";
    const [customers] = await pool.query(SQL);

    // Devuelvo los clientes
    return callback(null, { customers });
}

const get = async (call, callback) => {
    // Busco a un cliente por su id
    const SQL = "SELECT * FROM customers WHERE id = ?";
    const [customer] = await pool.query(SQL, [call.request.id])

    // Si no lo encuentra devuelvo un error
    if (!customer)
        return callback({
            code: status.NOT_FOUND,
            details: "Not found"
        });

    // Devuelvo el cliente
    return callback(null, customer);
}

const insert = async (call, callback) => {
    // Obtengo el request de la petición
    const customer = call.request;
    customer.id = uuidv4();

    // Inserto un nuevo cliente
    const SQL = "INSERT INTO customers SET ?";
    await pool.query(SQL, customer);

    // Devuelvo el cliente insertado
    return callback(null, customer);
};

const update = async (call, callback) => {
    // Busco a un cliente por su id
    const SQL_SEARCH = "SELECT * FROM customers WHERE id = ?";
    const [customer_searched] = await pool.query(SQL_SEARCH, [call.request.id]);

    if (customer_searched.length < 1)
        return callback({
            code: status.NOT_FOUND,
            details: "Not found"
        });

    // Realizo una copia del cliente de la base de datos
    const customer = { ...customer_searched[0] };

    // Actualizo el cliente
    const SQL_UPDATE = "UPDATE customers SET ? WHERE id = ?";
    customer.name = call.request.name;
    customer.age = call.request.age;
    customer.address = call.request.address;

    await pool.query(SQL_UPDATE, [customer, call.request.id]);

    callback(null, customer);

}

const remove = async (call, callback) => {
    // Busco a un cliente por su id
    const SQL_SEARCH = "SELECT * FROM customers WHERE id = ?";
    const [customer] = await pool.query(SQL_SEARCH, [call.request.id]);

    if (customer.length < 1)
        return callback({
            code: status.NOT_FOUND,
            details: "Not found"
        });

    // Elimino el cliente
    const SQL_DELETE = "DELETE FROM customers WHERE id = ?";
    await pool.query(SQL_DELETE, [call.request.id]);

    // Devuelvo la respuesta al cliente
    return callback(null, {});
}

module.exports = {
    getAll,
    get,
    insert,
    update,
    remove
};
