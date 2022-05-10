package com.splitwise.model.expense;

import com.splitwise.model.User;

import java.util.Date;

public class ExpenseFactory {
    public static Expense createExpense(String name, User createdBy, double totalAmount, String type) throws Exception {
        throw new Exception("Expense type not found: "+type);
    }
}
