app.controller('FotoCadastrarController', function ($scope, $stateParams, recursoFoto, cadastrarFoto){
	
	$scope.mensagem = '';
	
	var id = $stateParams.fotoId;
	
	if(id){
		var url = "/fotos/" + id;
		recursoFoto.get({fotoId: $stateParams.fotoId}, function(sucesso){
			$scope.foto = sucesso;
		}, function(erro){
			$scope.mensagem = 'Contém error !';
		});
	}
	
	$scope.submeter = function(){			
		//var foto = angular.toJson($scope.foto);
		//console.log(foto);
		if($scope.formulario.$valid){
			cadastrarFoto.cadastrar($scope.foto).then(function(sucesso){
				$scope.mensagem = sucesso.mensagem;
				if(sucesso.inclusao) $scope.foto = {};				
			}).catch(function(erro){
				$scope.mensagem = erro.mensagem;
			});			
		} 		
	};


});