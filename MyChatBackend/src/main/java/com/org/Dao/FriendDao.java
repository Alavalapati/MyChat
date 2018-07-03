package com.org.Dao;

import java.util.List;

import com.org.models.User;

public interface FriendDao {
List<User>getSuggestedUsers(String email);

}
