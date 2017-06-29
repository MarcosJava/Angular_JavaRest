angular.module('minhasDiretivas',[]).directive('meuPainel', function() {

	//Directives Definition Object = ddo
	var ddo = {};

	ddo.restric = "AE"; //A = atributo , E= element

	ddo.scope = {
		titulo:'@'
	};
	ddo.transclude = true;
	ddo.templateUrl = 'js/directives/meu-painel.html';

	return ddo;
});