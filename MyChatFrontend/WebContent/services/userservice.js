/**
 * UserService
 * 1. Register - call the middleware -> dao -> insert user details in User table
 */
app.factory('UserService',function($http){
	var userService={}
	
	userService.register=function(user){
		return $http.post("http://localhost:8085/MyChatMiddleware/register",user)
	}
	
	userService.login=function(user){
		return $http.post("http://localhost:8085/MyChatMiddleware/login",user)
	}
	
	userService.logout=function(){
		return $http.put("http://localhost:8085/MyChatMiddleware/logout")
	}
     
	userService.updateProfile=function(user){//updated user profile
		return $http.put("http://localhost:8085/MyChatMiddleware/update",user)
	}

	
	
	return userService;
})
