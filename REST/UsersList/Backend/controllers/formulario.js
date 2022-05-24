'use strict'

var validator = require('validator');

var Formulario = require('../models/formulario');

var controller = {

    
    guardar: (req, res) => {
        // Recoger parametros por post
        var params = req.body;

        // Validar datos (validator)
        try{
            var validate_Nombre = !validator.isEmpty(params.Nombre);
            var validate_Apellidos = !validator.isEmpty(params.Apellidos);

        }catch(err){
            return res.status(200).send({
                status: 'error',
                message: 'Faltan datos por enviar !!!'
            });
        }

        if(validate_Nombre && validate_Apellidos){
            
            //Crear el objeto a guardar
            var form = new Formulario();

            // Asignar valores
            form.Nombre = params.Nombre;
            form.Apellidos = params.Apellidos;

           
            // Guardar el articulo
            form.save((err, formStored) => {

                if(err || !formStored){
                    return res.status(404).send({
                        status: 'error',
                        message: 'El articulo no se ha guardado !!!'
                    });
                }

                // Devolver una respuesta 
                return res.status(200).send({
                    status: 'success',
                    usuario: formStored
                });

            });

        }else{
            return res.status(200).send({
                status: 'error',
                message: 'Los datos no son válidos !!!'
            });
        }
       
    },

    obtener: (req, res) => {

        var query = Formulario.find({});

        var last = req.params.last;
        if(last || last != undefined){
            query.limit(5);
        }

        // Find
        query.sort('-_id').exec((err, datos) => {

            if(err){
                return res.status(500).send({
                    status: 'error',
                    message: 'Error al devolver los articulos !!!'
                });
            }

            if(!datos){
                return res.status(404).send({
                    status: 'error',
                    message: 'No hay articulos para mostrar !!!'
                });
            }

            return res.status(200).send({
                status: 'success',
                datos
            });

        });
    },

    borrar: (req, res) => {
        // Recoger el id de la url
        var formularioId = req.params.id;

        // Find and delete
        Formulario.findOneAndDelete({_id: formularioId}, (err, formRemoved) => {
            if(err){
                return res.status(500).send({
                    status: 'error',
                    message: 'Error al borrar !!!'
                });
            }

            if(!formRemoved){
                return res.status(404).send({
                    status: 'error',
                    message: 'No se ha borrado el formulario, posiblemente no exista !!!'
                });
            }

            return res.status(200).send({
                status: 'success',
                article: formRemoved
            });

        }); 
    },

    editar: (req, res) => {
        //Recojer el id del articulo por la url
        var usuarioID = req.params.id;

        //Recoger los datos que llegan por put
        var params = req.body;

        //Validar los datos
        try {
            //Cuando no este vacio será true
            var validate_Nombre = !validator.isEmpty(params.Nombre);
            var validate_Apellidos = !validator.isEmpty(params.Apellidos);
        } catch (err) {
            return res.status(200).send({
                status: 'error',
                message: 'Faltan datos por enviar'
            });

        }

        if (validate_Nombre && validate_Apellidos) {
            //Find and update
            Formulario.findOneAndUpdate({ _id: usuarioID }, params, { new: true }, (err, userUpdated) => {
                if (err) {
                    return res.status(500).send({
                        status: 'error',
                        message: 'Error al actualizar'
                    });
                }

                if (!userUpdated) {
                    return res.status(404).send({
                        status: 'error',
                        message: 'No existe el articulo'
                    });

                }

                //Find and update
                return res.status(200).send({
                    status: 'success',
                    article: userUpdated
                });


            });

        } else {
            //Devolvolver respuesta
            return res.status(200).send({
                status: 'error',
                message: 'Validacion no es correcta'
            });

        }



    }








};

module.exports = controller;