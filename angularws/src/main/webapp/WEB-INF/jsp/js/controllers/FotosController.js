app.controller('FotosController', function($scope, recursoFoto){	
	
	$scope.fotos = [];	
	$scope.mensagem = '';
	
	recursoFoto.query(function(fotos){
		$scope.fotos = fotos
	}, function(error){
		console.log(erro);
	});
	
	$scope.remover = function(foto){
		recursoFoto.delete({fotoId: foto.id}, function(success){
			console.log(success.data);
			var index = $scope.fotos.indexOf(foto);
			$scope.fotos.splice(index,1);
			$scope.mensagem = 'Foto ' + foto.titulo + ' removida com sucesso';
		}, function(error){
			console.log(error);
		});
	}
});