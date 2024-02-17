//Evento que dispara a abertura do menu dos modulos
document.addEventListener('DOMContentLoaded', function() {
	const menuToggle = document.querySelector('.menu-toggle');
	const body = document.querySelector('body');
	const container = document.querySelector('.menuUser');

	menuToggle.addEventListener('click', function() {
		body.classList.toggle('menu-open');
		container.classList.toggle('menu-open');
	});
});

//Evento que dispara a animação do botão do menu quando for dado o click
document.addEventListener('DOMContentLoaded', function() {
	const menuToggle = document.querySelector('.menu-toggle');

	menuToggle.addEventListener('click', function() {

		this.classList.toggle('active');
		
	});
});


//module-front-end
function mudarModuloFrontEnd(modulo) {
	//atribunido na variavel apartir do id através do onclick
	const tituloModulo = document.getElementById('tituloModulo');
	const conteudoModulo = document.getElementById('conteudoModulo');
	const imagemModulo = document.querySelector('.imagem img');
	const linkModulo = document.getElementById('playlist')

	//deixando o menu do modulo interativo, e fazendo a mudança de conteudos
	switch (modulo) {
		case 'CSS':
			tituloModulo.textContent = 'Módulo de CSS: Desenhando com Estilo';
			conteudoModulo.textContent = 'Bem-vindo ao Módulo de CSS! Aqui, vamos mergulhar no mundo da estilização web e transformar suas páginas HTML em obras-primas visuais.';
			imagemModulo.src = '/assets/img/other/css.jpg';
			linkModulo.href = "https://www.youtube.com/watch?v=HtVRRHoASes&list=PL2Fdisxwzt_f5C7Mv0kg1EAHhy2VJLf1c";
			break;

		case 'JavaScript':
			tituloModulo.textContent = 'Módulo de JavaScript: Programação Interativa';
			conteudoModulo.textContent = 'Neste envolvente Módulo de JavaScript, embarcaremos em uma jornada fascinante pelo coração dinâmico e interativo da web. JavaScript é a linguagem de programação que capacita os sites modernos com funcionalidades envolventes e dinâmicas.';
			imagemModulo.src = '/assets/img/other/js.jpg';
			linkModulo.href = "https://www.youtube.com/watch?v=vEwPnjqWQ-g&list=PL2Fdisxwzt_d590u3uad46W-kHA0PTjjw";
			break;

		case 'React':
			tituloModulo.textContent = 'Módulo de React: Construindo Interfaces Modernas';
			conteudoModulo.textContent = 'Bem-vindo ao empolgante Módulo de React, onde você mergulhará nas águas revolucionárias dessa biblioteca JavaScript para construção de interfaces de usuário. React oferece uma abordagem declarativa e eficiente para o desenvolvimento de componentes reutilizáveis e interativos.';
			imagemModulo.src = '/assets/img/other/react.jpg';
			linkModulo.href = "https://www.youtube.com/watch?v=FXqX7oof0I4&list=PLnDvRpP8BneyVA0SZ2okm-QBojomniQVO";
			break;

		case 'HTML':
			tituloModulo.textContent = 'Bem-vindo ao Módulo de HTML!';
			conteudoModulo.textContent = 'Preparado para explorar o mundo fascinante do HTML, a linguagem que forma a espinha dorsal da web? Este módulo irá guiá-lo desde o básico até os truques avançados para criar páginas web impressionantes. Desvende as tags, mergulhe nas estruturas e domine as práticas recomendadas para desenvolvimento web.';
			imagemModulo.src = '/assets/img/other/html.jpg';
			linkModulo.href = "https://www.youtube.com/watch?v=sj0p9O85AIg&list=PL2Fdisxwzt_cajoGVWTx44wM6Ht09QJ3A";
			break;

		case 'Bootstrap':
			tituloModulo.textContent = 'Bem-vindo ao Módulo de Bootstrap: Estilizando com Facilidade';
			conteudoModulo.textContent = 'No emocionante Módulo de Bootstrap, mergulharemos no mundo da estilização web simplificada e responsiva. Bootstrap é uma biblioteca front-end poderosa que permite criar designs modernos com facilidade, independentemente do seu nível de experiência.';
			imagemModulo.src = '/assets/img/other/bootstrap.jpg';
			linkModulo.href = "https://www.youtube.com/watch?v=pW-qbaw3OQw&list=PLjS7DS1TxzJIkIgR8AR6Lu0deOOs0AQuv";
			break;
			
		default:
			break;
	}
}

//module-back-end
function mudarModuloBackEnd(modulo) {
	//atribunido na variavel apartir do id através do onclick
	const tituloModulo = document.getElementById('tituloModulo');
	const conteudoModulo = document.getElementById('conteudoModulo');
	const imagemModulo = document.querySelector('.imagem img');
	const linkModulo = document.getElementById('playlist')

	//deixando o menu do modulo interativo, e fazendo a mudança de conteudos
	switch (modulo) {
		case 'nodejs':
			tituloModulo.textContent = 'Bem-vindo ao Módulo de Node.js: Desenvolvimento do Lado do Servidor!';
			conteudoModulo.textContent = 'Neste módulo, exploraremos o incrível mundo do Node.js, uma plataforma que permite usar JavaScript para criar servidores robustos e eficientes. Vamos aprender a construir APIs, manipular arquivos, e compreender os conceitos fundamentais do desenvolvimento do lado do servidor.';
			imagemModulo.src = '/assets/img/other/nodejs.jpg';
			linkModulo.href = "https://www.youtube.com/watch?v=LLqq6FemMNQ&list=PLJ_KhUnlXUPtbtLwaxxUxHqvcNQndmI4B";
			break;

		case 'expressjs':
			tituloModulo.textContent = 'Bem-vindo ao Módulo de Express.js: Construindo Aplicações Web Robustas!';
			conteudoModulo.textContent = 'No universo do desenvolvimento web, o Express.js é uma ferramenta poderosa que simplifica a criação de aplicações web e APIs de forma elegante. Neste módulo, mergulharemos nas maravilhas do Express.js, aprendendo a rotear, lidar com solicitações e respostas, gerenciar middleware e criar aplicativos web eficientes.';
			imagemModulo.src = '/assets/img/other/expressjs.jpg';
			linkModulo.href = "https://expressjs.com/pt-br/";
			break;

		case 'mysql':
			tituloModulo.textContent = 'Módulo MySQL: Explorando o Poder dos Bancos de Dados Relacionais';
			conteudoModulo.textContent = 'Bem-vindo ao módulo MySQL! Aqui, embarcaremos em uma jornada fascinante pelo mundo dos bancos de dados relacionais com o MySQL, um dos sistemas de gerenciamento de banco de dados mais populares.';
			imagemModulo.src = '/assets/img/other/mysql.jpg';
			linkModulo.href = "https://www.youtube.com/watch?v=Ofktsne-utM&list=PLHz_AreHm4dkBs-795Dsgvau_ekxg8g1r";
			break;

		default:
			break;
	}
}
