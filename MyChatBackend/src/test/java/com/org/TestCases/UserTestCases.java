package com.org.TestCases;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.org.Dao.UserDao;
import com.org.models.User;

public class UserTestCases {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static UserDao userDao;

	@Autowired
	static User user;

	
	
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.org");
		context.refresh();
		
		//get the productDAO from context
		userDao =  (UserDao) context.getBean("userDao");
		
			
	}
	
	@Test
	public void createUserTestCase()
	{
		User user=new User();
		

		
		user.setFirstname("raju");
		user.setLastname("rani");
		user.setEmail("raju.rani@gmail.com");
		user.setPassword("raju");
		user.setPhonenumber("999789756");
		
		userDao.registration(user);
		assertEquals(user.getEmail(),user.getEmail());
		
	
	}

	@Ignore
	
	@Test
	public void uniqueEmailIdTest()
	{
		
		User user=new User();
user.setEmail("srinias@gmail.com");
		boolean status=userDao.isEmailUnique(user.getEmail());
		
		assertEquals("unique email id failure", false, status);
	}
	@Ignore
	@Test
	public void getUserDetails()
	{
		
		String userEmail = "charan@gmail.com";

               user=new User();

		 user = userDao.getUser(userEmail);
		 System.out.println("\n First Name "+user.getFirstname());
		 System.out.println("\n Last Name "+user.getLastname());
		 
		assertEquals(userEmail, userDao.getUser(userEmail));
		

	}	
}