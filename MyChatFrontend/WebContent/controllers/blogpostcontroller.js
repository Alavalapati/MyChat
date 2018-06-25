/**
 * BlogCtrl
 */
app.controller('BlogCtrl',function($scope,BlogService,$location,$rootScope){
	
	$scope.addBlog=function(blog){
		BlogService.addBlog(blog).then(function(response){
			alert('Blogpost inserted successfully...It is waiting for approval')
			$location.path('/home')
		},function(response){
		
		if(response.status==401)//not logged in
			$scope.error=response.data
			$location.path('/login')
		})
	}
   function blogsApproved(){
	   BlogService.blogsApproved().then(function(response){
		   //response.data -> []List<BlogPost> which are approved
		   //response.data -> select * from blogpost where approved=true
		   $scope.blogsApproved=response.data
		},function(response){
		$rootScope.error=response.data
		if(response.status==401)//not logged in
			$location.path('/login')
		})		
	}
   
   function blogsWaitingForApproval(){
	   BlogService.blogsWaitingForApproval().then(function(response){
		   //response.data -> []List<BlogPost> which are waiting for approved
		   //response.data -> select * from blogpost where approved=false
		   $scope.blogsWaitingForApproval=response.data
		   },function(response){
		$rootScope.error=response.data
		if(response.status==401)//not logged in
			$location.path('/login')
		})		
	}
    blogsApproved()
    if($rootScope.loggedInUser.role=='ADMIN')
    blogsWaitingForApproval()

})
	
	
	
	
