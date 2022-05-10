package com.splitwise.model.expense;

import com.splitwise.model.User;
import com.splitwise.util.Util;

import java.util.*;

public class Expense {
    private long expenseId;
    private String name;
    private Date date;
    private User addedBy;
    private Set<User> participants;
    private double totalAmount;
    private HashMap<User, Double> amountPaid;
    private HashMap<User, Double> amountOwed;

    //private Map<User, Double> split;
    //Few questions here related to split when we are using map:
    // What if different participants are paying in diff currencies
    // Where are we keeping the %?
    // If new type of splitting comes up, then how to accomodate that in this map? So instead of Map of user and amount,
    // we will have new data type - lets call that split, and split is of three types - equal, percent and equal amount.
    //So split will be abstract and equal, exact and percent will inherit it.


    //This is not required now
    //private List<Split> splits;

    //Better to have an enum for category
    //private String category;
    //private Image image;
    //private Location location;

    private static long NEW_ID = 0;

    public Expense(String name, Date date, User addedBy, double totalAmount){
        // We can have builder pattern here to set the items as some items are not required like location and image
        this.expenseId = NEW_ID++;
    }

/*    boolean validate(){
        //common logic for all expense
        //The sum of amounts should be equal to the total amount
        double sum = 0;
        for(Split s : splits){
            sum += s.getAmount();
        }
        //if sum == totalAmount return true else return false
        //WE need to have a method which checks for comparison between double, just doing sum == totalAmount will fail.
        //Always ask the interviewer, about the precision, till how many digits he wants precision
        return Util.isApproxEqual(sum,totalAmount);
    }

    public void setSplits(List<Split> splits) {
        this.splits = splits;
        //validate the split
    }

    public List<Split> getSplits(){
        return splits;
    }
    public void removeSplit(Split s){
        splits.remove(s);
    }*/

    public long getId(){
        return this.expenseId;
    }
    public User getAddedBy() {
        return addedBy;
    }
    public void setAddedBy(User addedBy) {
        this.addedBy = addedBy;
    }
    public void setParticipants(Set<User> participants){
        this.participants = participants;
        for(User participant : participants){
            participant.addExpense(this);
        }
    }
    public Set<User> getParticipants() {
        return participants;
    }

    public HashMap<User, Double> getAmountPaid() {
        return amountPaid;
    }
    public void setAmountPaid(HashMap<User, Double> amountPaid) {
        this.amountPaid = amountPaid;
    }
    public HashMap<User, Double> getAmountOwned() {
        return amountOwed;
    }
    public double getTotalAmount(){
        return this.totalAmount;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: "+this.name+"\n");
        sb.append("CreatedBy: "+this.addedBy.getName()+"\n");
        sb.append("Paid amount:\n");
        for(User user : this.amountPaid.keySet()) {
            sb.append(user.getName()+"::"+this.amountPaid.get(user)+"\n");
        }
        sb.append("Owned amount:\n");
        for(User user : this.amountOwed.keySet()) {
            sb.append(user.getName()+"::"+this.amountOwed.get(user)+"\n");
        }
        return sb.toString();
    }

}
