import java.util.ArrayList;
import java.util.HashMap;

public class ExpensesManager {
    HashMap<String, ArrayList<Double>> expensesByCategories;
    ArrayList<Double> newExpense;

    ExpensesManager() {
        expensesByCategories = new HashMap<>();
        newExpense = new ArrayList<>();
    }

    double saveExpense(double moneyBeforeSalary, double expense, String category) {
        moneyBeforeSalary = moneyBeforeSalary - expense;
        System.out.println("Значение сохранено! Ваш текущий баланс в рублях: " + moneyBeforeSalary);
        if (expensesByCategories.containsKey(category)) {
            newExpense.add(expense);
        } else {
            newExpense = new ArrayList<>();
            newExpense.add(expense);
            expensesByCategories.put(category, newExpense);
        }
        if (moneyBeforeSalary < 1000) {
            System.out.println("На вашем счету осталось совсем немного. Стоит начать экономить!");
        }
        return moneyBeforeSalary;
    }

    void printAllExpensesByCategories() {
        for (String category : expensesByCategories.keySet()) {
            System.out.println(category);
            for (Double expense : expensesByCategories.get(category)) {
                System.out.println(expense);
            }
        }
    }

    double findMaxExpenseInCategory(String category) {
        double maxExpense = 0;
        if (!expensesByCategories.containsKey(category)) {
            System.out.println("Такой категории пока нет.");
        } else {
            for (Double exp : expensesByCategories.get(category)) {
                if (exp > maxExpense) {
                    maxExpense = exp;
                }
            }
            System.out.println("Самая большая трата в категории " + category + " составила "
                    + maxExpense + " руб.");
        }
        return maxExpense;
    }

    void removeAllExpenses() {
        expensesByCategories.clear();
        System.out.println("Траты удалены.");
    }
}