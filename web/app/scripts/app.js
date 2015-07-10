'use strict';

/**
 * @ngdoc overview
 * @name yoApp
 * @description
 * # yoApp
 *
 * Main module of the application.
 */
angular
  .module('yoApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'restangular'
  ])
  .config(function ($routeProvider, RestangularProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl',
        controllerAs: 'about'
      })
      .otherwise({
        redirectTo: '/'
      });



    RestangularProvider.setBaseUrl('http://192.168.178.32:8080/');
    // RestangularProvider.setExtraFields(['name']);
    RestangularProvider.setResponseExtractor(function (response) {
     /* if (response.error) {
        alert(response.error);
        return null;
      }
      return response.data;
      */
      return response;
    });

    RestangularProvider.setDefaultHttpFields({cache:false});
//    RestangularProvider.setMethodOverriders(["put", "patch"]);

    RestangularProvider.setRequestSuffix('');




  })

  .factory('products', ['Restangular', function (Restangular) {
    var products = [];

    function load() {
      Restangular.all('/products').getList()
        .then(function (data) {
          angular.copy(data, products);
        });

    }

    load();

    return {
      products: products
    };

  }])

;

