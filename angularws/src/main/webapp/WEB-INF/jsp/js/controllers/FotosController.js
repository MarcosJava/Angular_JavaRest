angular.module('alurapic').controller('FotosController', function($scope, $http){	
	
	$scope.fotos = [];
	$scope.filtro = '';
	
	$http({
	      method: 'GET',
	      url: '/fotos/'
	   }).then(function (success){
		   console.log(success);
		   $scope.fotos = success.data;
	   },function (error){
		   console.log(erro);
	   });

});