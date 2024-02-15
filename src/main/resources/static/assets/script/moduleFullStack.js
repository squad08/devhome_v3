//disparando um novo evento DOM
document.addEventListener('DOMContentLoaded', function () {
    const modulo = localStorage.getItem('getPage');

    //pegando id do link de menu, para fazer a substituição para a nova pagina 
    if (modulo) {
        const linkMenu = document.getElementById('linkMenu');//atribunido na variavel apartir do id
        linkMenu.href = '/fullstack';//recebendo a nova pagina apartir do Storege

        // Limpa a informação do localStorage para não afetar os modulos quando estão separados
        localStorage.removeItem('getPage');
    }
});