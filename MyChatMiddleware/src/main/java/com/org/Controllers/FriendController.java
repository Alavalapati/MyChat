package com.org.Controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.org.Dao.FriendDao;
import com.org.Dao.UserDao;
import com.org.models.ErrorClazz;
import com.org.models.User;


@RestController
public class FriendController {
	@Autowired
	private FriendDao friendDao;
	@Autowired
	private UserDao userDao;
	
@RequestMapping(value="/suggestedusers",method=RequestMethod.GET)
    public ResponseEntity<?> getSuggestedUsers(HttpSession session){
	String email=(String)session.getAttribute("email"); 
	if(email==null){
		ErrorClazz errorClazz=new ErrorClazz(7,"Unauthorized access..please login");
	return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.UNAUTHORIZED);
	}
		
	List<User> suggestedUsers=friendDao.getSuggestedUsers(email);
return new ResponseEntity<List<User>>(suggestedUsers,HttpStatus.OK);
}
}
