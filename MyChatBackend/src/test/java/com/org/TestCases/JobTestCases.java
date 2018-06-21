package com.org.TestCases;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.org.Dao.JobDao;
import com.org.Dao.UserDao;
import com.org.models.Job;
import com.org.models.User;

public class JobTestCases {
	
	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	 static JobDao  jobDao;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		//get the userDAO from context
				jobDao =  (JobDao) context.getBean("jobDao");
	}
	
	@Test
	public void createJobTestCase()
	{
				
	Job job=new Job();

	job.setCompanyName("Wipro");
	job.setJobDescription("Software Developer");
	job.setJobTitle("WebTechnology");
	job.setLocation("Bangalore");
	job.setPostedOn(new Date());
	job.setSalary("4.5 Lac");
	job.setSkillsRequired("C,Java,SQL");
	job.setActive(false);
	job.setYrsOfExp("2.5 Years");
	jobDao.saveJob(job);
	
	assertEquals(job.getId(),job.getId());
	
	
	
	}
}

	
	
	
