app.controller('FotoCadastrarController', function ($scope, $http, $stateParams){
	
	$scope.mensagem = '';
	
	var id = $stateParams.fotoId;
	if(id){
		var url = "/fotos//" + id;
		$http({method: 'GET', url:url}).then(function(success){
			
			$scope.foto = success.data;
			
		}, function(error){
			$scope.mensagem = 'Contém error !';
		});
	}
	
	$scope.submeter = function(){				
		if($scope.formulario.$valid){			
			$http({
				method: 'POST',
				url: '/fotos/',
				data: $scope.foto			
			}).then(function(sucess){
				$scope.foto = {};
				$scope.mensagem = 'Foto incluida com sucesso';
			}),function(error){
				$scope.mensagem = 'Não foi possivel incluir';
			};
			
		} 		
	};


});