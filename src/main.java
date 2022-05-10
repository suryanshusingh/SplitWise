import com.splitwise.controller.ExpenseController;
import com.splitwise.controller.UserController;
import com.splitwise.model.User;
import com.splitwise.repository.ExpenseRepo;
import com.splitwise.repository.IExpenseRepository;
import com.splitwise.repository.IUserRepo;
import com.splitwise.repository.UserRepo;
import com.splitwise.services.IPaymentStrategy;
import com.splitwise.services.ISplitStrategy;
import com.splitwise.services.OnePayIPaymentStrategy;
import com.splitwise.services.PercentageSplitStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class main {
    public static void main(String[] args){
        System.out.println("Hello");
        //Create user repository
        IUserRepo userRepo = new UserRepo();
        UserController userController = new UserController(userRepo);
        //create users
        User u1 = userController.registerUser("u1","abc","9876543210");
        User u2 = userController.registerUser("u2","abc","9876543210");
        User u3 = userController.registerUser("u3","abc","9876543210");

        //Create list of users among which expense has to be done - it depends whether we want to
        // create list of username or users
        List<Long> expenseParticipants = new ArrayList<>();
        expenseParticipants.add(u1.getId());
        expenseParticipants.add(u2.getId());
        expenseParticipants.add(u2.getId());

        // define splitting strategy
        HashMap<Long, Double> splitPercentage = new HashMap<>();
        splitPercentage.put(u1.getId(), 20.0);
        splitPercentage.put(u2.getId(), 30.0);
        splitPercentage.put(u3.getId(), 50.0);
        ISplitStrategy splitStrategy = new PercentageSplitStrategy(splitPercentage);

        //Define payment strategy
        IPaymentStrategy paymentStrategy = new OnePayIPaymentStrategy();

        // Create expense
        IExpenseRepository expenseRepo = new ExpenseRepo();
        ExpenseController expenseController = new ExpenseController(expenseRepo, userRepo);
        long expenseCreatedById = u1.getId();
        int totalAmount = 5000;
        expenseController.createExpenseWithUsers("ExpenseName", "ExpenseDesc",
                expenseCreatedById, totalAmount, splitStrategy, paymentStrategy);
    }
}
