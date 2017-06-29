angular.module('alurapic').controller('FotosController', function($scope, $http){	
	
	$scope.fotos = [
		titulo: "maria",
		url: "http://pt.seaicons.com/wp-content/uploads/2015/07/Young-Lion-icon.png"
	];
	$scope.filtro = '';
/*

$http.get('http://localhost:8080/fotos/')
		.success(function(fotos) {
			$scope.fotos = fotos;
		})
		.error(function(erro){
			console.log(erro);
		});
		


var promise = $http.get('http://localhost:8080/fotos/');
	promise.then(function(retorno){
		$scope.fotos = retorno.data;
		console.log(retorno.data);
	}).catch(function(error){
		console.log(error);
	});	
	
	*/


});