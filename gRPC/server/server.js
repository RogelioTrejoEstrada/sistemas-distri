// Dependencias
const grpc = require("grpc");
const path = require("path");
const protoLoader = require("@grpc/proto-loader");

// Controladores
const { get, getAll, insert, remove, update } = require("./controllers/customers.controller");

// Configuracion de la ruta del archivo de proto
const PROTO_PATH = path.resolve(__dirname, "..", "customers.proto");
const packageDefinition = protoLoader.loadSync(PROTO_PATH, {
    keepCase: true,
    longs: String,
    enums: String,
    arrays: true
});
const customersProto = grpc.loadPackageDefinition(packageDefinition);

// Instacia del servidor grpc
const server = new grpc.Server();
server.addService(customersProto.CustomerService.service, {
    getAll,
    get,
    insert,
    remove,
    update
});

// Publicación de la rura del servidor
server.bind("127.0.0.1:30043", grpc.ServerCredentials.createInsecure());

module.exports = server;