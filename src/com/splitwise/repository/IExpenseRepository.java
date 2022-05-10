package com.splitwise.repository;

import com.splitwise.model.expense.Expense;

public interface IExpenseRepository {
    void saveExpense(Expense expense);
}
