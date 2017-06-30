app.controller('FotosController', function($scope, $http){	
	
	$scope.fotos = [];	
	$scope.mensagem = '';
	$http({
	      method: 'GET',
	      url: '/fotos/'
	   }).then(function (success){
		   console.log(success);
		   $scope.fotos = success.data;
	   },function (error){
		   console.log(erro);
	   });
	
	
	$scope.remover = function(foto){
		//foto = angular.toJson(foto);
		console.log(foto);
		var url = '/fotos/'+ foto.id;
		
		$http({url: url, method: 'DELETE'}).then(function (success){
			console.log(success.data);
			var index = $scope.fotos.indexOf(foto);
			$scope.fotos.splice(index,1);
			$scope.mensagem = 'Foto ' + foto.titulo + ' removida com sucesso';
		}, function (error){
			console.log(error);
		});
	}
});