package com.splitwise.repository;

import com.splitwise.model.expense.Expense;

import java.util.HashMap;

public class ExpenseRepo  implements IExpenseRepository{
    HashMap<Long, Expense> idToExpenseMap;
    public ExpenseRepo(){
        this.idToExpenseMap = new HashMap<>();
    }
    @Override
    public void saveExpense(Expense expense) {
        idToExpenseMap.put(expense.getId(), expense);
    }
}
