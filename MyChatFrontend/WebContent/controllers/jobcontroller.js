/**
 * JobCtrl
 */
app.controller('JobCtrl',function($scope,JobService,$location,$rootScope){
	$scope.addJob=function(job){
		$scope.isClicked=false
		JobService.addJob(job).then(
				function(response){
					alert('Job details inserted successfully')
					$location.path('/home')
				},function(response){
					//3 return statement for error in middleware
					$scope.error=response.data
					if($scope.error.errorCode==7){//not logged in
						$rootScope.error=response.data
						$location.path('/login')
					}
					
				})
	}
	
})