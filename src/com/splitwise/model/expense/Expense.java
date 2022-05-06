package com.splitwise.model.expense;

import com.splitwise.model.User;
import com.splitwise.model.split.Split;

import java.util.Date;
import java.util.List;
import java.util.Map;

public abstract class Expense {
    private long expenseId;
    private String name;
    private Date date;
    private User addedBy;
    private User paidBy;
    private double totalAmount;

    //private Map<User, Double> split;
    //Few questions here related to split when we are using map:
    // What if different participants are paying in diff currencies
    // Where are we keeping the %?
    // If new type of splitting comes up, then how to accomodate that in this map? So instead of Map of user and amount,
    // we will have new data type - lets call that split, and split is of three types - equal, percent and equal amount.
    //So split will be abstract and equal, exact and percent will inherit it.

    private List<Split> splits;

    //Better to have an enum for category
    private String category;
    //private Image image;
    //private Location location;

    private static long NEW_ID = 0;

    public Expense(String name, Date date, User addedBy, User paidBy, String category, double totalAmount){
        // We can have builder pattern here to set the items as some items are not required like location and image
        this.expenseId = NEW_ID++;
    }

    boolean validate(){
        //common logic for all expense
        //The sum of amounts should be equal to the total amount
        double sum = 0;
        for(Split s : splits){
            sum += s.getAmount();
        }
        //if sum == totalAmount return true else return false
        //WE need to have a method which checks for comparison between double, just doing sum == totalAmount will fail.
        //Always ask the interviewer, about the precision, till how many digits he wants precision
        //Todo : return Util.isApproxEqual(sum,totalAmount);
        return sum == totalAmount;
    }

    abstract void updateBalance();

    public void setSplits(List<Split> splits) {
        this.splits = splits;
        //validate the split
    }

}
