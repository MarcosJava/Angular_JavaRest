app.factory('recursoFoto', function($resource) {
	return $resource('/fotos/:fotoId', null, {
		update : {
			method : 'PUT'
		},
		salva : {
			method : 'POST'
		}
	});

}).factory('cadastrarFoto', function(recursoFoto, $q) {
	

	var servico = {};
	servico.cadastrar = function(foto) {
		return $q(function(resolve, reject) {
			
			if (foto.id) { //alterar
				recursoFoto.update(foto, function(sucesso) {
					resolve({
						mensagem : 'Foto ' + foto.titulo + ' atualizada com sucesso',
						inclusao : false
					});
				}, function(erro) {
					reject({mensagem : 'Não foi possivel alterar a foto'});
				});

			} else { //cadastrar
				recursoFoto.salva(foto, function(sucesso) {
					resolve({
						mensagem : 'Foto ' + foto.titulo + ' incluida com sucesso',
						inclusao : true
					});
				}, function(erro) {
					reject({mensagem : 'Não foi possivel salvar a foto'});
				});
			}
			
		});
			
	};		

	return servico;


	
});
