package com.org.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.org.models.BlogPost;
@Repository
@Transactional
public class BlogPostDaoImpl implements BlogPostDao {
     @Autowired
     private SessionFactory sessionFactory;
	public void saveBlogPost(BlogPost blogPost) {
		Session session=sessionFactory.getCurrentSession();
		session.save(blogPost);
		
	}
	public List<BlogPost> approvedBlogs() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from BlogPost where approved=true");
		return query.list();//List of BLogPost objects which are approved
	}
	public List<BlogPost> blogsWaitingForApproval() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from BlogPost where approved=false");
		return query.list();//List of BlogPost objetcs are not approved

		
			}
	public BlogPost getBlogPost(int id) {
		Session session=sessionFactory.getCurrentSession();
        BlogPost blogPost=(BlogPost)session.get(BlogPost.class,id);
        return blogPost;
	}
		public void updateApprovalStatus(BlogPost blogPost) {

		//if blogPost is approved by admin,update approve value as true
	    //if blogpost is rejected by admin,delete the blogpost
		//blogPost.approved=?, if it is approved by admin
		//blogPost.approved=?, if it is rejected by admin
			Session session=sessionFactory.getCurrentSession();
			if(blogPost.isApproved()){
				session.update(blogPost);//update blogPost set approved=true where id=?
			}
						
			else{
				session.delete(blogPost);
				
			}
		}
}

		
	