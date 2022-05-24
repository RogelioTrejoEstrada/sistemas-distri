import React, { Component } from 'react';
import { Link, Redirect } from 'react-router-dom';
import axios from 'axios';
import Swal from 'sweetalert2';
import Global from '../Global';
import Moment from 'react-moment';
import 'moment/locale/es';

class Edit extends Component {


    url = Global.url;
    //Recoger datos
    userId = null;
    nombreRef = React.createRef();
    apellidosRef = React.createRef();


    state = {
        user: {},
        status: null
    }


    componentWillMount() {
        this.userId = this.props.match.params.id;
    }









    //Modifica el state de forma dinamica
    changeState = () => {
        this.setState({
            user: {
                Nombre: this.nombreRef.current.value,
                Apellidos: this.apellidosRef.current.value,
            }
        });
    }




    editarUsuario = (e) => {
        //Bloquear que al enviar el formulario se actualice
        e.preventDefault();

        //Llamar al metodo changeState: Rellenara el state con formulario
        this.changeState();

        if (this.nombreRef.current.value && this.apellidosRef.current.value) {
            Swal.fire({
                position: 'center',
                icon: 'success',
                title: 'Se ha editado el usuario correctamente',
                showConfirmButton: false,
                timer: 2000
            })
            //Hacer una peticion HTTP por post para guerdar el usuario
            axios.put(this.url + "editar/"+this.userId, this.state.user)
                .then(res => {//res recibir respuesta del api
                    if (res.data.user) {
                        this.setState({
                            user: res.data.user,
                            status: 'success'
                        });
                        
                    } else {
                        this.setState({
                            status: 'failed'

                        })
                    }

                })
        } else {
            Swal.fire({
                position: 'center',
                icon: 'error',
                title: 'Llena todos los campos',
                showConfirmButton: false,
                timer: 2000
            })

        }



    }






    render() {


        return (


            <div class="container-form">
                <h1>Editar Usuario</h1>
                <form action="" className="formRegister" onSubmit={this.editarUsuario}>


                    <label for="" className="label">Nombre: </label>
                    <input type="text" className="form-control" placeholder="Ingresa tu nombre" ref={this.nombreRef} onChange={this.changeState} />


                    <label for="" className="label">Apellidos:</label>
                    <input type="text" className="form-control" placeholder="Escribe tus apellidos" ref={this.apellidosRef} onChange={this.changeState} />


                    <div id="botones">
                        <input type="submit" className="Boton" value="Editar" />
                        <Link to={"/create"} className="Boton">Regresar a Usuarios</Link>
                    </div>

                </form>
            </div>

        );
    }
}

export default Edit;