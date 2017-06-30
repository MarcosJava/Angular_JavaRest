app.controller('FotosController', function($scope, $http){	
	
	$scope.fotos = [];	
	$scope.mensagem = '';
	$http({
	      method: 'GET',
	      url: '/restApi/fotos/'
	   }).then(function (success){
		   console.log(success);
		   $scope.fotos = success.data;
	   },function (error){
		   console.log(erro);
	   });
	
	$scope.submeter = function(){				
		if($scope.formulario.$valid){			
			$http({
				method: 'POST',
				url: '/restApi/fotos/',
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