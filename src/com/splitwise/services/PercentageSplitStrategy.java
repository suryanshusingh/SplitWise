package com.splitwise.services;

import com.splitwise.model.expense.Expense;

import java.util.HashMap;

public class PercentageSplitStrategy implements ISplitStrategy{
    HashMap<Long, Double> userToPercentMap;
    public PercentageSplitStrategy(HashMap<Long, Double> userToPercentMapping){
        this.userToPercentMap = userToPercentMapping;
    }
    @Override
    public void calculateOwnedAmount(Expense expense) {

    }
}
