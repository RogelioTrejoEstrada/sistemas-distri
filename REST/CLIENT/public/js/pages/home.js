// Modulos
import { } from '../class/Api.js';
import { } from '../class/UI.js'

// Elementos HTML
/** @type {HTMLFormElement} Formulario HTML */
const formUser = document.querySelector("#form-user");
/** @type {HTMLTableSectionElement} */
const users = document.querySelector("#users");

// Evento para guardar o actualizar un usurio
formUser.addEventListener('submit', e => {
    e.preventDefault();

    // Obtengo los datos del Formulario
    const userData = Object.fromEntries(new FormData(formUser));

});


users.addEventListener('click', e => {
    // Valido el tipo de boton
    /** @type {HTMLButtonElement} */
    const target = e.target;

    // Accion para eliminar el usuario
    if (target.classList.contains()) {

    }

    // Accion para editar el usuario
    if (target.classList.contains()) {

    }
});

alert("Home")