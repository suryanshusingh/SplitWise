package com.splitwise.repository;

import com.splitwise.model.User;

import java.util.List;
import java.util.Set;

public interface IUserRepo {
    User findById(Long id);
    User findByUserName(String userName);
    boolean isUserPresent(String userName);
    void saveUser(User u);
    User saveUser(String userName, String password, String phNo);
    Set<User> getUsers(List<String> participants);
}
