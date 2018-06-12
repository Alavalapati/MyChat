package com.org.Controllers;

import java.sql.Date;

import javax.servlet.http.HttpSession;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.org.Dao.UserDao;
import com.org.Dao.EmpDao;
import com.org.models.Emp;
import com.org.models.ErrorClazz;

@RestController
public class EmpController{
   @Autowired
   private EmpDao empDao;
   @Autowired
   private UserDao userDao;
   @RequestMapping(value="/addemp",method=RequestMethod.POST)
   
   public ResponseEntity<?> saveEmp(@RequestBody Emp emp,HttpSession session){
   //Authentication and Authorization
   //Authentication - who are you?
   //Autherization - role?
   String email="surya.teja@xyz.com";//(String)session.getAttribute("email");
   if(email==null){//not logged in
	   ErrorClazz errorClazz=new ErrorClazz(7,"Unauthorized access...please login");
	   return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.UNAUTHORIZED);
	   
         }
	   //if email !=null,user is authenticated user
       //check user is authorized to insert a new job or not.Check the role of the user
       //check if the logged in user is admin or not
       User user=(User) userDao.getUser(email);
       if(!user.getRoles().equals ("ADMIN")){
    	   
    	   ErrorClazz errorClazz=new ErrorClazz(8,"Access Denied......");
    	   return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.UNAUTHORIZED);
    	   }
       // Authenticated and Authorized to insert new job details
       try{
    	   emp.setPostedOn(new Date(0));
    	   emp.setActive(true);//job position is still available
       empDao.saveEmp(emp);
       return new ResponseEntity<Void>(HttpStatus.OK);//first call back function
       }catch (Exception e){
    	   ErrorClazz errorClazz=new ErrorClazz(4,"Unable to insert job details"+e.getMessage());
    	   return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.INTERNAL_SERVER_ERROR);
    	   
       }
       
   }
}
       
       
   
    	   
       
   

	   
	   



   
   
   
   

   
   
   


   

 	  

