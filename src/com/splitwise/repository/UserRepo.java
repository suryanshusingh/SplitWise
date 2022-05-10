package com.splitwise.repository;

import com.splitwise.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class UserRepo implements IUserRepo{
    HashMap<Long, User> userMap;
    public UserRepo(){
        userMap = new HashMap<>();
    }
    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public User findByUserName(String userName) {
        return null;
    }

    @Override
    public boolean isUserPresent(String userName) {
        return false;
    }

    @Override
    public void saveUser(User u) {

    }

    @Override
    public User saveUser(String userName, String password, String phNo) {
        if(isUserPresent(userName)){
            // throw new Exception("UserName already exists");
        }
        User user = new User(userName,password,phNo);
        userMap.put(user.getId(),user);
        return user;
    }

    @Override
    public Set<User> getUsers(List<String> participants) {
        return null;
    }
}
