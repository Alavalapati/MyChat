/**
 * FriendService
 */
app.factory('FriendService',function($http){
	var friendService={}
	
	
	friendService.getSuggestedUsers=function(){
		return $http.get("http://localhost:8085/MyChatMiddleware/suggestedusers")
		
	}	
	return friendService;
})