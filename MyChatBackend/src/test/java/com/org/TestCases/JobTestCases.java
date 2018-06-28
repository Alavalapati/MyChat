package com.org.TestCases;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
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
	static JobDao jobDao;


	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.app");
		context.refresh();

		// get the productDAO from context
		jobDao = (JobDao) context.getBean("jobDao");

	}

	@Ignore
	@Test
	public void CreateJobTestCase() {
		Job job = new Job();

		job.setJobTitle("Web Application Developer");
		job.setJobDescription("Web applications");
		job.setLocation("Hyderabad");
		job.setSalary("15k-22k");
		job.setSkillsRequired("basic knowledge of HTML");
		job.setYrsOfExp("0-2 yrs");
		jobDao.saveJob(job);
		assertEquals(job.getId(), job.getId());

	}
}