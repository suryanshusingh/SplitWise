package com.splitwise.model;

public class User {
    private String name;
    private String email;
    private String phoneNumber;
    private long userId;

    private static long NEW_USERID = 0;

    public User(String name, String email, String phNum){
        this.userId = NEW_USERID++;
        //user methods here to set, because we can have validators in setName method.
        setName(name);
        setEmail(email);
        setPhoneNumber(phNum);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
