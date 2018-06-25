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
	.when('/addjob',{ //V to C
		controller:'JobCtrl',
		templateUrl:'pages/jobform.html'
	})
	.when('/activejobs',{ //C to V,  $scope.activeJobs=[{},{}]
		controller:'JobCtrl',
		templateUrl:'pages/activejobslist.html'
	})
	.when('/inactivejobs',{
		controller:'JobCtrl',
		templateUrl:'pages/inactivejobslist.html'
	})
	.when('/addblog',{
		controller:'BlogCtrl',
		templateUrl:'pages/blogform.html'
	})
	.when('/blogsapproved',{
		controller:'BlogCtrl',
		templateUrl:'pages/blogsapproved.html'
	})
	.when('/blogswaitingforapproval',{
		controller:'BlogCtrl',
		templateUrl:'pages/blogswaitingforapproval.html'
	})

		.when('/getblogapproved',{
		controller:'BlogInDetailCtrl',
		templateUrl:'pages/blogindetail.html'//blog which approved[likes,comments...]
	})
	.when('/getblogwaitingforapproval/:id',{//C->V,$scope.blogPost=[Http Response] select * from blogPost where id=?
		controller:'BlogInDetailCtrl',
		templateUrl:'pages/blogapprovalform.html'//select * from blogpost where id=?,approve /reject buttoon 
	})

	.otherwise({
		templateUrl:'pages/home.html'
	})
})
app.run(function($rootScope,$cookieStore,UserService,$location){
	if($rootScope.loggedInUser==undefined)
		$rootScope.loggedInUser=$cookieStore.get('loggedInUser')
		
		$rootScope.logout=function(){
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



