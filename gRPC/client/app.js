// Dependencias
const path = require("path");
const express = require("express");

// Rutas de la aplicación
const routes = require("./routes/routes");

// Inicializaciones
const app = express();

// Configuraciones
app.set('port', process.env.PORT || 3000);
app.set("views", path.join(__dirname, "views"));
app.set("view engine", "hbs");

// Middlewares
app.use(express.json());
app.use(express.urlencoded({ extended: false }));

// Rutas
app.use(routes);

// Exporto la aplicación
module.exports = app;