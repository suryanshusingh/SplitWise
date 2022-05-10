package com.splitwise.model;

import com.splitwise.model.expense.Expense;

import java.util.List;

public class User {
    private String name;

    private String password;
    private String phoneNumber;
    private long userId;
    private List<Expense> expenses;

    private static long NEW_USERID = 0;

    public User(String name, String password, String phNum){
        this.userId = NEW_USERID++;
        //user methods here to set, because we can have validators in setName method.
        setName(name);
        setPassword(password);
        setPhoneNumber(phNum);
    }
    public Long getId() {
        return this.userId;
    }

    public void addExpense(Expense expense){
        this.expenses.add(expense);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
