// Elementos HTML
/** @type {HTMLFormElement} Formulario HTML */
const formUser = document.querySelector("#form-user");

formUser.addEventListener('submit', e => {
    e.preventDefault();

    // Obtengo los datos del Formulario
    const userData = Object.fromEntries(new FormData(formUser));


});
