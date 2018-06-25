/**
 * BlogService
 */
app.factory('BlogService',function($http){
	var blogService={}
	blogService.addBlog=function(blog){
	return	$http.post("http://localhost:8081/MyChatMiddleware/addblogpost",blog)
		
	}
	blogService.blogsApproved=function(){
		return	$http.get("http://localhost:8081/MyChatMiddleware/blogsapproved")
			
		}
	blogService.blogsWaitingForApproval=function(){
		return	$http.get("http://localhost:8081/MyChatMiddleware/blogswaitingforapproval")

		}
	blogService.getBlogPost=function(id){
		return	$http.get("http://localhost:8081/MyChatMiddleware/getblogpost/"+id)
	}
	blogService.updateApprovalStatus=function(blogPost){
		//if admin approves the blogPost,blogPost.approved=?
		//if admin reject the blogPost,blogPost.approved=?
		return	$http.put("http://localhost:8081/MyChatMiddleware/updateapprovalstatus",blogPost)
	}

	
	
	return blogService;
})