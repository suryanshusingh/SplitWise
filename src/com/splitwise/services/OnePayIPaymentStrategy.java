package com.splitwise.services;

import com.splitwise.model.User;
import com.splitwise.model.expense.Expense;

import java.util.Set;

public class OnePayIPaymentStrategy implements IPaymentStrategy {
    @Override
    public void calculatePaidAmount(Expense expense) {
        User payer = expense.getAddedBy();
        Set<User> participants = expense.getParticipants();
        Double amountPaid = expense.getTotalAmount();
        for(User participant : participants) {
            if(participant.equals(payer)) {
                System.out.println("Payer is :"+payer.getName()+" "+amountPaid);

                expense.getAmountPaid().put(participant, amountPaid);
                System.out.println("Amount === "+expense.getAmountPaid().get(payer));
            }else {
                expense.getAmountPaid().put(participant, 0.0);
            }
        }
    }
}
