/**
 * Angular JS Module
 */
var app=angular.module("app",['ngRoute','ngCookies'])
app.config(function($routeProvider){
	$routeProvider
	.when('/registration',{
		controller:'UserCtrl',
		templateUrl:'pages/registrationform.html'
	})
	.when('/home',{
		templateUrl:'pages/home.html'
	})
	.when('/login',{
		controller:'UserCtrl',
		templateUrl:'pages/login.html'
	})
	.when('/updateprofile',{
		controller:'UserCtrl',
		templateUrl:'pages/updateprofile.html' //user object in updateprofile.html
	})
	.when('/addjob',{
		controller:'JobCtrl',
		templateUrl:'pages/jobform.html'
	})
	
	.otherwise({
		templateUrl:'pages/home.html'
	})
})
app.run(function($rootScope,$cookieStore,UserService,$location){
	if($rootScope.loggedInUser==undefined)
		$rootScope.loggedInUser=$cookieStore.get('loggedInUser')
		
		$rootScope.logout=function(){
		alert('entering logout')
		UserService.logout().then(function(response){
			$rootScope.message="Loggedout successfully..."
				delete $rootScope.loggedInUser
				$cookieStore.remove('loggedInUser')
			$location.path('/login')
		},function(response){
			$rootScope.error=response.data //ErrorClazz object returned from middleware
			$location.path('/login')
		})
	}	
})

