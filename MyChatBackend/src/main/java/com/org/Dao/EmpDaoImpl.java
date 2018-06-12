package com.org.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import com.org.models.Emp;
@RestController
@Transactional

public class EmpDaoImpl implements EmpDao {
   @Autowired
	private SessionFactory sessionFactory;
	public void saveEmp(Emp emp) {
	Session session=sessionFactory.getCurrentSession();	
	session.save(emp);
		
		
	}

}
