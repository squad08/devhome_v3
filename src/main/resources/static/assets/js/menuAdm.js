/* global bootstrap: false */
(() => {
	'use strict'
	const tooltipTriggerList = Array.from(document.querySelectorAll('[data-bs-toggle="tooltip"]'))
	tooltipTriggerList.forEach(tooltipTriggerEl => {
		new bootstrap.Tooltip(tooltipTriggerEl)
	})
})()

document.getElementById('open-sidebar').addEventListener('click', function() {
	var sidebar = document.querySelector('.sidebarAdm');
	sidebar.classList.toggle('visivel');
});