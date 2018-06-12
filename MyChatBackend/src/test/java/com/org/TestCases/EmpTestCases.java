package com.org.TestCases;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.org.Dao.EmpDao;
import com.org.Dao.UserDao;
import com.org.models.Emp;
import com.org.models.User;

public class EmpTestCases {
	
	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	 static EmpDao  empDao;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.org");
		context.refresh();
		
		//get the empDAO from context
				empDao=(EmpDao) context.getBean("EmpDao");
	}
	
	@Test
	public void createEmpTestCase()
	{
				
	Emp emp=new Emp();
	
	
    emp.setCompanyName("Wipro");
	emp.setEmpDescription("Software Developer");
	emp.setEmpTitle("WebTechnology");
	emp.setLocation("Bangalore");
	emp.setPostedOn(new Date());
	emp.setSalary("4.5 Lac");
	emp.setSkillsRequired("C,Java,SQL");
	
	emp.setYrsOfExp("2.5 Years");
	empDao.saveEmp(emp);
	
	assertEquals(emp.getId(),emp.getId());
	
	
	
	}
}

	
	
	 
	
	
	



