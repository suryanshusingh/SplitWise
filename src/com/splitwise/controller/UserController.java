package com.splitwise.controller;

import com.splitwise.model.User;
import com.splitwise.repository.IUserRepo;

public class UserController {
    //We can also have a user service here
    //But time constraint led me to just create userRepo
    private IUserRepo userRepo;
    public UserController(IUserRepo ur) {
        this.userRepo = ur;
    }
    public User registerUser(String userName, String password, String phNo) {
        User u = userRepo.saveUser(userName, password, phNo);
        return u;
    }

}
