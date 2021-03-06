package com.org.Dao;

import java.util.List;

import com.org.models.BlogComment;
import com.org.models.BlogPost;

public interface BlogPostDao {
	void saveBlogPost(BlogPost blogPost);
List<BlogPost> approvedBlogs();
List<BlogPost> blogsWaitingForApproval();
BlogPost getBlogPost(int id);
void updateApprovalStatus(BlogPost blogPost);
void addBlogComment(BlogComment blogComment);
List<BlogComment> getAllBlogComments(int blogPostId);


}
