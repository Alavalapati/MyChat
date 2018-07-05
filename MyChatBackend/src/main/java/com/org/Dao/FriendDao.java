package com.org.Dao;

import java.util.List;

import com.org.models.Friend;
import com.org.models.User;

public interface FriendDao {
List<User>getSuggestedUsers(String email);

void addFriend(Friend friend);
List<Friend> pendingRequests(String email);

void upadateStatus(Friend friendRequest);
List<Friend> getAllFriends(String email);

}
