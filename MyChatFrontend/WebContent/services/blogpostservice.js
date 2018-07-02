/**
 * BlogService
 */
app.factory('BlogService',function($http){
	var blogService={}
	blogService.addBlog=function(blog){
		return $http.post("http://localhost:8085/MyChatMiddleware/addblogpost",blog)
		
	}
	blogService.blogsApproved=function(){
		return $http.get("http://localhost:8085/MyChatMiddleware/blogsapproved")
		
	}
	blogService.blogsWaitingForApproval=function(){
		return $http.get("http://localhost:8085/MyChatMiddleware/blogswaitingforapproval")
		
	}
	blogService.getBlogPost=function(id){
		return $http.get("http://localhost:8085/MyChatMiddleware/getblogpost/"+id)
	}
	blogService.updateApprovalStatus=function(blogPost){
		return $http.put("http://localhost:8085/MyChatMiddleware/updatestatusapproval",blogPost)
		//if admin approves the blogpost,blogpost.approved=?
		//if admin rejects the blogpost,blogpost.approved=?
	}
	blogService.hasUserLikedBlog=function(blogpostId){
		return $http.get("http://localhost:8085/MyChatMiddleware/hasuserlikedblog/"+blogpostId)
	}
	blogService.updateBlogPostLikes=function(blogPostId){
		return $http.put("http://localhost:8085/MyChatMiddleware/updateblogpostlikes/"+blogPostId)
	}
	//blogpost id and commenttxt
	//id is the id of the blogpost
	//if commentTxt=good,well expalined
	//id=27
	//http://......../addcomment/

	blogService.addComment=function(commentTxt,id){
		return $http.post("http://localhost:8085/MyChatMiddleware/addcomment/"+commentTxt+"/"+id)
	}
	blogService.getAllBlogComments=function(blogPostId){
		return $http.get("http://localhost:8085/MyChatMiddleware/getblogcomments/"+blogPostId)
	}
	

	return blogService;
}) 

