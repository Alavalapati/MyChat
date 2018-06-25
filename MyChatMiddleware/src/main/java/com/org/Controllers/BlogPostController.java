package com.org.Controllers;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.org.Dao.BlogPostDao;
import com.org.Dao.UserDao;
import com.org.models.BlogPost;
import com.org.models.ErrorClazz;
import com.org.models.User;

@RestController
public class BlogPostController {
	 @Autowired
	private BlogPostDao blogPostDao;
	 @Autowired
	 private UserDao userDao;
	 
	 //{blogTitle:'Introduction to DBMS',blogContent:'......................'}
	 @RequestMapping(value="/addblogpost",method=RequestMethod.POST)
	 public ResponseEntity<?> saveBlogPost(HttpSession session,@RequestBody BlogPost blogPost){//Authentication and data
		//Check for Authentication
	   String email=(String)session.getAttribute("email");
	   if(email==null){
	   ErrorClazz errorClazz=new ErrorClazz(7,"Unauthorized access.. please login");
       return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.UNAUTHORIZED);
   }
		
		blogPost.setPostedOn(new Date());
		 //postedBy-author,logged in user
	    User postedBy=userDao.getUser(email);//user is postedBy,user is not author of the blogPost
	    blogPost.setPostedBy(postedBy);
	    blogPostDao.saveBlogPost(blogPost);
	    return new ResponseEntity<BlogPost>(blogPost,HttpStatus.OK);
	 }
	 @RequestMapping(value="/blogsapproved",method=RequestMethod.GET)
	 public ResponseEntity<?> getBlogsApproved(HttpSession session){
		//Check for Authentication
		   String email=(String)session.getAttribute("email");
		   if(email==null){
		   ErrorClazz errorClazz=new ErrorClazz(7,"Unauthorized access.. please login");
	       return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.UNAUTHORIZED); 
		   }
		   List<BlogPost> blogsApproved=blogPostDao.approvedBlogs();
		   return new ResponseEntity<List<BlogPost>>(blogsApproved,HttpStatus.OK);
	 
	 }
	 @RequestMapping(value="/blogswaitingforapproval",method=RequestMethod.GET)

	 public ResponseEntity<?> getBlogsWaitingForApproval(HttpSession session){
			//Check for Authentication
			   String email=(String)session.getAttribute("email");
			   if(email==null){
			   ErrorClazz errorClazz=new ErrorClazz(7,"Unauthorized access.. please login");
		       return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.UNAUTHORIZED); 
			   }
			   //Check for authorization
			   User user=userDao.getUser(email);
			   if(!user.getRole().equals("ADMIN")){
				   ErrorClazz errorClazz=new ErrorClazz(8,"Access Denied..");
			       return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.UNAUTHORIZED); 
			   }
			   List<BlogPost> blogsWaitingForApproval=blogPostDao.blogsWaitingForApproval();
			   return new ResponseEntity<List<BlogPost>>(blogsWaitingForApproval,HttpStatus.OK);

			   }
	 @RequestMapping(value="/getblogpost{id}",method=RequestMethod.GET)

	 public ResponseEntity<?> getBlogPost(@PathVariable int id,HttpSession session){
		//Check for Authentication
		   String email=(String)session.getAttribute("email");
		   if(email==null){
		   ErrorClazz errorClazz=new ErrorClazz(7,"Unauthorized access.. please login");
	       return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.UNAUTHORIZED); 
		   }
		  BlogPost blogPost=blogPostDao.getBlogPost(id);
		  return new ResponseEntity<BlogPost>(blogPost,HttpStatus.OK);
 }
	 @RequestMapping(value="/updateapprovalstatus",method=RequestMethod.PUT)

	 
	 public ResponseEntity<?>updateApprovalStatus(@RequestBody BlogPost blogPost,HttpSession session){
		 //Authentication and Autherization
		 String email=(String)session.getAttribute("email");
		   if(email==null){
		   ErrorClazz errorClazz=new ErrorClazz(7,"Unauthorized access.. please login");
	       return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.UNAUTHORIZED); 
		   }
		   //Check for authorization
		   User user=userDao.getUser(email);
		   if(!user.getRole().equals("ADMIN")){
			   ErrorClazz errorClazz=new ErrorClazz(8,"Access Denied..");
		       return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.UNAUTHORIZED); 
		   }
		   try{
		   blogPostDao.updateApprovalStatus(blogPost);
		   }catch(Exception e){
			   ErrorClazz errorClazz=new ErrorClazz(10,"Unable to approve/reject the blogpost"+e.getMessage());
			   return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.INTERNAL_SERVER_ERROR); 

		   }
		   return new ResponseEntity<Void>(HttpStatus.OK); 
		 
	 }
	 
}
	 




