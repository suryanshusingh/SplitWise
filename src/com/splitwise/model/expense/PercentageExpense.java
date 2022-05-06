package com.splitwise.model.expense;

import com.splitwise.model.User;

import java.util.Date;

public class PercentageExpense extends Expense{
    public PercentageExpense(String name, Date date, User addedBy, User paidBy, String category, double totalAmount) {
        super(name, date, addedBy, paidBy, category, totalAmount);
    }

    @Override
    void updateBalance() {

    }
}
