package com.splitwise.controller;

import com.splitwise.model.User;
import com.splitwise.model.expense.Expense;
import com.splitwise.repository.IExpenseRepository;
import com.splitwise.repository.IUserRepo;
import com.splitwise.services.IPaymentStrategy;
import com.splitwise.services.ISplitStrategy;

import java.util.Date;

public class ExpenseController {
    IExpenseRepository expenseRepository;
    IUserRepo userRepository;
    public ExpenseController(IExpenseRepository expenseRepository, IUserRepo userRepo){
        this.userRepository = userRepo;
        this.expenseRepository = expenseRepository;
    }

    public Expense createExpenseWithUsers(String expenseName, String expenseDesc, long expenseCreatedById,
                                       int totalAmount, ISplitStrategy splitStrategy, IPaymentStrategy paymentStrategy) {
        User user = userRepository.findById(expenseCreatedById);
        Expense expense = new Expense(expenseName, new Date(), user, totalAmount);

        splitStrategy.calculateOwnedAmount(expense);
        return expense;
    }

    /*public createExpenseWithGroup(){

    }*/


}
