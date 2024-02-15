//armazenando as informações na mémoria Storege, para poder fazer manipulado em outra pagina
function mudarModuloFullStack(modulo) {
    localStorage.setItem('getPage', modulo);

 //pegando as informações do onclick, para fazer o armazenamento da manipulação no Storege
    switch (modulo) {
        case 'front':
            window.location.href = '/assets/html/module-fullstack.html';
            break;
            
        case 'back':
            window.location.href = '/assets/html/module-fullstack.html';
            break;
            
        default:
            break;
    }
}