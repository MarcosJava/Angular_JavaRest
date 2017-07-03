app.controller('GrupoController', function($scope, $http){
	
	$scope.grupos = [];
	$http.get('/grupos/').then(function(success){
		$scope.grupos = success.data;
	}, function(error){
		console.log("Teve error", error);
	});
	
});