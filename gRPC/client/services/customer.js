// Dependencias
const grpc = require("grpc");
const path = require("path");
const protoLoader = require("@grpc/proto-loader");

// Configuracion de la ruta del archivo de proto
const PROTO_PATH = path.resolve(__dirname, "..", "..", "customers.proto");
const packageDefinition = protoLoader.loadSync(PROTO_PATH, {
    keepCase: true,
    longs: String,
    enums: String,
    arrays: true
});

// Consumo del servicio grpc
const CustomerService = grpc.loadPackageDefinition(packageDefinition).CustomerService;
const client = new CustomerService(
    "localhost:30043",
    grpc.credentials.createInsecure()
);

module.exports = {
    getAll: () => {
        return new Promise((resolve, reject) => {
            client.getAll(null, (err, response) => {
                if (err) reject(err);
                else resolve(response);
            });
        });
    },
    insert: (newCustomer) => {
        return new Promise((resolve, reject) => {
            client.insert(newCustomer, (err, response) => {
                if (err) reject(err);
                else resolve(response);
            });
        });
    },
    update: (updateCustomer) => {
        return new Promise((resolve, reject) => {
            client.update(updateCustomer, (err, response) => {
                if (err) reject(err);
                else resolve(response);
            });
        });
    },
    remove: (id) => {
        return new Promise((resolve, reject) => {
            client.remove({ id }, (err, response) => {
                if (err) reject(err);
                else resolve(response);
            });
        });
    }
};