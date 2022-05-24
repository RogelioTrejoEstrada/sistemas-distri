'use strict'

var mongoose = require('mongoose');
var Schema = mongoose.Schema;

var FormSchema = Schema({
    Nombre: String,
    Apellidos: String,
});

module.exports = mongoose.model('Formulario', FormSchema);
