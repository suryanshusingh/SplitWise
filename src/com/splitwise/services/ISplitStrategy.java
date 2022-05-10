package com.splitwise.services;

import com.splitwise.model.expense.Expense;

public interface ISplitStrategy {

    public void calculateOwnedAmount(Expense expense);
}
