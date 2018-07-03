/**
 * FriendController
 */
app.controller('FriendCtrl',function($scope,$location,FriendService){
	function getSuggestedUsers(){
		FriendService.getSuggestedUsers().then(function(response){

			//response.data?List<User> - suggestedUsers
			$scope.suggestedUsers=response.data
		},function(response){
			$scope.error==response.data
			if(response.status==401)
				$location.path('/login')
		})
	}
getSuggestedUsers()
})
