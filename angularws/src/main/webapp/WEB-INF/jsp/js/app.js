//Modulo nao tem dependencia , o array ta vazio.
//O modulo ta sendo carregado assim que o load do html for carregado, isso se faz na tag <html ng-app="alurapic"
var app =  angular.module('poczinha',['ui.mask', 'ngAnimate','ui.router','minhasDiretivas','ngResource']);


app.directive("limitTo", [function() {
    return {
        restrict: "A",
        link: function(scope, elem, attrs) {
            var limit = parseInt(attrs.limitTo);
            angular.element(elem).on("keypress", function(e) {
                if (this.value.length == limit) e.preventDefault();
            });
        }
    }
}]);