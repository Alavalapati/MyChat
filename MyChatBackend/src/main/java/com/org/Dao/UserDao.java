package com.org.Dao;

import java.util.List;

import com.org.models.User;

public interface UserDao {
void registration(User user);
boolean isEmailUnique(String email);
User login(User user);
void update(User validUser);
User getUser(String email);
void updateUser(User user);


}
