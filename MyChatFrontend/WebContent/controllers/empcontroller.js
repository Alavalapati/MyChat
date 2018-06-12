/**
 * EmpCtrl
 */
app.controller('EmpCtrl',function($scope,Empsrvice,$location){
	$scope.addEmp=function(emp){
		EmpService.addEmp(emp).then(
				function(response){
					alert('Emp details inserted successfully..')
					$location.path('/home')
					},function(response){
						//3 return statement for error in middleware
						$scope.error=response.data
						(if$scope.error.errorcode==7)//not logged in
						$rootScope.error=response.data
						 $location.path('/login')
				})
	}
})
				
		
			
		
	
	
