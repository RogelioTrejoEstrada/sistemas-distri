'use strict'

var express = require('express');
var FormController = require('../controllers/formulario');

var router = express.Router();


// Rutas útiles
router.post('/guardar', FormController.guardar);
router.get('/usuario', FormController.obtener);
router.delete('/borrar/:id', FormController.borrar);
router.put('/editar/:id', FormController.editar);

module.exports = router;