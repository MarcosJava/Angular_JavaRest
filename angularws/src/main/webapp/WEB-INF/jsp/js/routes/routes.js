app.config(function($stateProvider, $urlRouterProvider){
	
	$stateProvider
		.state({
			name : 'home',
			url : '/home',
			templateUrl : 'partials/principal.html',
			controller: 'FotosController'
		}).state({
			name : 'empty',
			url : '/',
			templateUrl : 'partials/principal.html',
			controller: 'FotosController'
		}).state({
			name : 'cadastrarFoto',
			url : '/fotos/new',
			templateUrl : 'partials/foto.html',
			controller: 'FotoCadastrarController'
		}).state({
			name : 'editarFoto',
			url : '/fotos/edit/:fotoId',
			templateUrl : 'partials/foto.html',
			controller: 'FotoCadastrarController'
		});
	
	
	$urlRouterProvider.otherwise('/');
});






//app.config(function($routeProvider) {
//    $routeProvider
//    .when("/", {
//    	templateUrl : 'partials/principal.html',
//		controller: 'FotosController'
//    })
//    .when("/home", {
//    	templateUrl : 'partials/principal.html',
//		controller: 'FotosController'
//    })
//.when("/home/:usuarioID", {
//templateUrl : 'partials/principal.html',
//controller: 'FotosController'
//})
//	  .otherwise({redirectTo: '/'});
//});

//http://localhost:8080/restApi/index.html#!/home