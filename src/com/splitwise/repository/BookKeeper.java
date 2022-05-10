package com.splitwise.repository;

import com.splitwise.model.User;
import com.splitwise.model.expense.Expense;
import com.splitwise.model.expense.ExpenseFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookKeeper {

    public Map<Long, User> users;
    public Map<Long, Expense> expenses;
    private static BookKeeper instance;

    private BookKeeper() {
        this.users = new HashMap<>();
        this.expenses = new HashMap<>();
    }

    public static BookKeeper getInstance(){
        if(instance == null) {
            instance = new BookKeeper();
        }
        return instance;
    }

    //AddUser
    void addUser(User user){
        //users.add(user);
    }

    //AddExpense
    void addExpense(String name, User createdBy, double totalAmount, String type) throws Exception {
        //Use factory pattern
        Expense e = ExpenseFactory.createExpense(name, createdBy, totalAmount, type);
    }

    //ShowBalances
    public void ShowBalances() {
        //Map<User,Double> m
        // loop over all the expenses
        // for each expense loop over splits
        //update the balances for users in m
        //not-optimized
    }

    //SHowBalance(User)
    //Simplify

    public User getUser(long id) throws Exception {
        if(!users.containsKey(id)){
            throw new Exception("User with userId: "+ id +" not found");
        }
        return users.get(id);
    }
}
