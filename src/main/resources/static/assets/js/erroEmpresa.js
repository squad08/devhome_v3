window.onload = function() {
    const urlParams = new URLSearchParams(window.location.search);
    const erro = urlParams.get('erro');
    if (erro === 'true') {
        const mensagemErro = "Não é possível excluir a empresa no momento, pois existem vagas associadas a ela.";
        const h2Erro = document.getElementById('mensagemErro');
        h2Erro.textContent = mensagemErro;
        h2Erro.style.opacity = '0'; 
        h2Erro.style.display = 'block';
        h2Erro.style.textAlign = 'center'; 
        h2Erro.style.color = 'hsl(336, 100%, 50%)'; 
        h2Erro.style.marginTop = '40px';
         
        // Animação de aparecer suavemente
        let opacity = 0;
        const fadeInInterval = setInterval(function() {
            opacity += 0.05; 
            h2Erro.style.opacity = opacity;
            if (opacity >= 1) {
                clearInterval(fadeInInterval); 
            }
        }, 50); 

        // Ocultar a mensagem após 5 segundos (5000 milissegundos)
        setTimeout(function() {
            // Animação de desaparecer suavemente
            let opacity = 1;
            const fadeOutInterval = setInterval(function() {
                opacity -= 0.05; 
                h2Erro.style.opacity = opacity;
                if (opacity <= 0) {
                    clearInterval(fadeOutInterval); 
                    h2Erro.style.display = 'none'; 
                }
            }, 50);
        }, 5000); 
    }
};
