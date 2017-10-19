app
.factory('recursoFoto', function($resource) {
	return $resource('/fotos/:fotoId', null, {
		update : {
			method : 'PUT'
		},
		salva : {
			method : 'POST'
		}
	});

}).factory('cadastrarFoto', function(recursoFoto, $q, $rootScope) {
	
	var evento = 'fotoCadastrada';
	var servico = {};
	
	servico.merge = function(foto) {
		return $q(function(resolve, reject) {
			
			if (foto.id) { //alterar
				recursoFoto.update(foto, function(sucesso) {
					$rootScope.$broadcast(evento);					
					resolve({
						mensagem : 'Foto ' + foto.titulo + ' atualizada com sucesso',
						inclusao : false
					});
				}, function(erro) {
					reject({mensagem : 'Não foi possivel alterar a foto'});
				});

			} else { //cadastrar
				recursoFoto.salva(foto, function(sucesso) {
					$rootScope.$broadcast(evento);
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
}).factory('listaGrupos', function($resource) {
	return $resource('/grupos/:fotoId', null);

}).factory('dbGruposSelected', function(){
	var grupo = {id: 0, nome: ""};
	return {
        getGrupo : function () { 
            return grupo; 
        },
        setGrupo:function(mgrupo){
            grupo = mgrupo;
        }
    }      
});
