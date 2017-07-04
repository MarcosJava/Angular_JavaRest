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
}).directive('minhaFoto', function(){	
	return {
		restric: "AE",
		scope: {url: '@', titulo: '@'},
		template: '<img class="img-responsive center-block" src="{{url}}"  alt="{{titulo}}">'
	};
	
}).directive('meuFocus', function(){
	return {
		restric: "A",
		scope: {focado: "="},
		link : function(scope, element){
			scope.$watch('focado',function(){
				if(scope.focado){
					element[0].focus();
					scope.focado = false;
				}
			});
		}
	}
});
