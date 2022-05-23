/**
 * Funcion principal para cargar los modulos de la aplicacion
 */
(async () => {
    const BASE_URL = new URL(window.location.href);
    const IS_ROOT = BASE_URL.pathname === '/';
    if (IS_ROOT)
        await import('./pages/home.js');
    else
        await import('./pages/login.js');
})();
