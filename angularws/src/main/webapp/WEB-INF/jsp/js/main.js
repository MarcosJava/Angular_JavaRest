//Modulo nao tem dependencia , o array ta vazio.
//O modulo ta sendo carregado assim que o load do html for carregado, isso se faz na tag <html ng-app="alurapic"
var app =  angular.module('alurapic',['ngAnimate','ui.router','minhasDiretivas']);



app.config(function($stateProvider) {
	var home = {
		name : 'home',
		url : '/home',
		templateUrl : 'partials/principal.html',
		controller: 'FotosController'
	}
	$stateProvider.state(home);
});