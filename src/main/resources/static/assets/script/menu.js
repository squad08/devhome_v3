//Evento que dispara a abertura do menu dos modulos
document.addEventListener('DOMContentLoaded', function() {
	const menuToggle = document.querySelector('.menu-toggle');
	const body = document.querySelector('body');
	const container = document.querySelector('.menu');

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
