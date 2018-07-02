package com.org.Dao;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.models.BlogPost;
import com.org.models.BlogPostLikes;
import com.org.models.User;
@Repository
@Transactional
public class BlogPostLikesDaoImpl implements BlogPostLikesDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public BlogPostLikes hasUserLikedBlogPost(int blogpostId, String email) {
			
	Session session=sessionFactory.getCurrentSession();
	Query query=session.createQuery("from BlogPostLikes where blogpost.id=? and user.email=?");
	query.setInteger(0,blogpostId);
	query.setString(1, email);
	BlogPostLikes blogPostLikes=(BlogPostLikes)query.uniqueResult();
	return blogPostLikes;//either or null or 1 blogpostlikes object
	
	}

	public BlogPost updateBlogPostLikes(int blogPostId, String email) {
		//1.insert a record in blogpostlikes and increment the num of likes
		//or
	    //2.delete a record in blogpostlikes and decrement the num of likes
		Session session=sessionFactory.getCurrentSession();
		BlogPostLikes blogPostLikes=hasUserLikedBlogPost(blogPostId,email);
		BlogPost blogPost=(BlogPost) session.get(BlogPost.class,blogPostId);
		if(blogPostLikes==null){//glyphicon in black ,user has clicked the glyphicon [liked the post]
			//insert and increment 
			 blogPostLikes=new BlogPostLikes();
			 User user=(User)session.get(User.class,email);
			 blogPostLikes.setBlogpost(blogPost);
			 blogPostLikes.setUser(user);//insert into blogpostlikes
			 session.save(blogPostLikes);
			 blogPost.setLikes(blogPost.getLikes() + 1);//set likes=likes+1
			 //update blogpost set likes=likes+1 where id=?
			 session.update(blogPost);
		}else{//delete record from the blogpostlikes and decrement the count
			session.delete(blogPostLikes);
			blogPost.setLikes(blogPost.getLikes() - 1);
			session.update(blogPost);
		
		}
		return blogPost;
	}
	
	

}