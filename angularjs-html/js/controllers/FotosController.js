angular.module('alurapic').controller('FotosController', function($scope, $http){	
	
	$scope.fotos = [];
/*
	$http.get('/localhost:8080/fotos/')
		.success(function(fotos){
			$scope.fotos = fotos;
		}).error(function(erro){
			console.log(erro);
		});

	console.log($scope.fotos);
*/
	
	var promise = $http.get('http://localhost:8080/fotos/');
	promise.then(function(retorno){
		$scope.fotos = retorno.data;
		console.log(retorno.data);
	}).catch(function(error){
		console.log(error);
	});	
	
});