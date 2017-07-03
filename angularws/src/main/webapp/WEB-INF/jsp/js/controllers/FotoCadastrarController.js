app.controller('FotoCadastrarController', function ($scope, $http, $stateParams){
	
	$scope.mensagem = '';
	
	var id = $stateParams.fotoId;
	
	if(id){
		var url = "/fotos/" + id;
		$http({method: 'GET', url:url}).then(function(success){
			$scope.foto = success.data;
		}, function(error){
			$scope.mensagem = 'Contém error !';
		});
	}
	
	$scope.submeter = function(){				
		if($scope.formulario.$valid){
			var method = '';
			var msg = '';
			if($scope.foto.id){
				method = 'PUT';
				msg = 'Foto alterada com sucesso';
			}else{
				method = 'POST';
				msg = 'Foto incluida com sucesso';
			}
			$http({
				method: method,
				url: '/fotos/',
				data: $scope.foto			
			}).then(function(sucess){
				$scope.foto = $scope.foto.id == null ? {} : $scope.foto;
				$scope.mensagem = msg;
			}),function(error){
				$scope.mensagem = 'Não foi possivel concluir a operação';
			};
			
		} 		
	};


});