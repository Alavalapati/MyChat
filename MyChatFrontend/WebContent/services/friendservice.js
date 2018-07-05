/**
 * FriendService
 */
app.factory('FriendService',function($http){
	var friendService={}
	
	
	friendService.getSuggestedUsers=function(){
		return $http.get("http://localhost:8085/MyChatMiddleware/suggestedusers")
		
	}	
	friendService.sendFriendRequest=function(toIdValue){// toIdValue is User object
		return $http.post("http://localhost:8085/MyChatMiddleware/addfriend",toIdValue)
		
	}	
	friendService.getPendingRequests=function(){
		return $http.get("http://localhost:8085/MyChatMiddleware/pendingrequests")
		
	}	
	friendService.updateStatus=function(updatedFriendRequest){
		return $http.put("http://localhost:8085/MyChatMiddleware/updatestatus",updatedFriendRequest)
		
	}	
	friendService.getAllFriends=function(){
		return $http.get("http://localhost:8085/MyChatMiddleware/friends")
		
	}	

	return friendService;
})