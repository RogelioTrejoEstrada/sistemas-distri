// Dependencias
const server = require('./server');

const main = () => {
    console.log("Server running at http://127.0.0.1:30043");
    server.start();
};

// Ejecuto el archivo solo si es el archivo principal
if (require.main === module)
    main();