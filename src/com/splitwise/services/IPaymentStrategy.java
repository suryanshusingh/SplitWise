package com.splitwise.services;

import com.splitwise.model.expense.Expense;

public interface IPaymentStrategy {
    public void calculatePaidAmount(Expense expense);
}
