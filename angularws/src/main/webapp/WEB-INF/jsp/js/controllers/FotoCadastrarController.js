app.controller('FotoCadastrarController', function ($scope, $stateParams, recursoFoto, cadastrarFoto, dbGruposSelected){
	
	$scope.mensagem = '';
	
	var id = $stateParams.fotoId;		
	if(id){		
		recursoFoto.get({fotoId: $stateParams.fotoId}, function(sucesso){
			console.log(sucesso);
			$scope.foto = sucesso;
			if(sucesso.grupo != undefined)
				dbGruposSelected.setGrupo(sucesso.grupo);
			
		}, function(erro){
			$scope.mensagem = 'Contém error !';
		});
	}
	
	$scope.submeter = function(){			
		var foto = angular.toJson($scope.foto);
		console.log(foto);
		console.log("valido ? ", $scope.formulario.$valid);
		if($scope.formulario.$valid){
			cadastrarFoto.merge($scope.foto).then(function(sucesso){
				$scope.mensagem = sucesso.mensagem;				
				if(sucesso.inclusao) $scope.foto = {};				
			}).catch(function(erro){
				$scope.mensagem = erro.mensagem;
			});			
		} 		
	};


});