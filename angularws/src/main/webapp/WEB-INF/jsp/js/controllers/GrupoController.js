app.controller('GrupoController', function($scope, $http, listaGrupos, dbGruposSelected){
	
	$scope.grupos = [];
	
	$scope.foto.grupo = dbGruposSelected.getGrupo;
	
	listaGrupos.query(function(sucesso){
		$scope.grupos = sucesso;
		}, function(erro){
			console.log("Teve error", erro);
			$scope.mensagem = 'Contém error !';
	});
});