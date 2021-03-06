angular.module('minhasDiretivas',[]).directive('meuPainel', function() {

	//Directives Definition Object = ddo
	var ddo = {};

	ddo.restric = "AE"; //A = atributo , E= element

	ddo.scope = {
		titulo:'@'
	};
	ddo.transclude = true; //transclude: inseri no meio do conteudo da diretiva, mas no meu-painel tem a area onde o meio vai ser posto na directiva
	ddo.templateUrl = 'js/directives/meu-painel.html';

	return ddo;
}).directive('minhaFoto', function(){	
	return {
		restric: "AE",		
		scope: {url: '@', titulo: '@'},
		template: '<img class="img-responsive center-block" src="{{url}}"  alt="{{titulo}}"></img>'
	};
	
}).directive('meuFocus', function(){
	return {
		restric: "A",
		scope: {focado: "="},
		link : function(scope, element){
			scope.$on('fotoCadastrada', function(){
				element[0].focus();
				
			});
		}
	}
});
