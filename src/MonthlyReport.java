import java.util.ArrayList;
import java.util.HashMap;


public class MonthlyReport {
    private String[] months = {"Январь", "Февраль", "Март"};
    private final String monthFileName = "m.20210";
    static HashMap<String, ArrayList> monthlyReport = new HashMap<>();

    private HashMap<String, Integer> commonMonthsExpenses = new HashMap<>();
    private HashMap<String, Integer> commonMonthsIncomes = new HashMap<>();

    private Comparison comparison = new Comparison();

    public void countMonthsReport() {

            manipulateFile fileContents = new manipulateFile();
            for (int i = 0; i < months.length; i++) {
                ArrayList<HashMap> itemsInfo = new ArrayList<>();
                HashMap<String, Boolean> isExpense = new HashMap<>();
                HashMap<String, Integer> quantity = new HashMap<>();
                HashMap<String, Integer> sumOfOne = new HashMap<>();

                String openedFile = fileContents.readFile("resources/" + monthFileName + (i + 1) + ".csv");

                fileContents.createMonthlyReport(
                        openedFile.split(System.lineSeparator()),
                        isExpense,
                        quantity,
                        sumOfOne,
                        itemsInfo,
                        monthlyReport,
                        months[i]);

            }
    }

    public void transformData(){
        for (String month : months) {

            int monthIncome = 0;
            int monthExpense = 0;

            ArrayList<HashMap> itemsOfMonth = monthlyReport.get(month);

            HashMap<String, Boolean> is_expense = itemsOfMonth.get(0);
            HashMap<String, Integer> quantity = itemsOfMonth.get(1);
            HashMap<String, Integer> sum_of_one = itemsOfMonth.get(2);

            for (String itemName : is_expense.keySet()) {

                if (!is_expense.get(itemName)){
                    monthIncome += quantity.get(itemName) * sum_of_one.get(itemName);
                } else {
                    monthExpense += quantity.get(itemName) * sum_of_one.get(itemName);
                }

                commonMonthsExpenses.put(month, monthExpense);
                commonMonthsIncomes.put(month, monthIncome);
            }
            comparison.setMonthHashMapsFromMonths(commonMonthsExpenses, commonMonthsIncomes);

        }


    }

    public void printMonthsReportCount() {

        for (String month : months) {
            int maxIncome = 0;
            int maxExpense = 0;
            String maxExpenseItemName = "";
            String maxIncomeItemName = "";

            System.out.println(month);

            ArrayList<HashMap> itemsOfMonth = monthlyReport.get(month);

            HashMap<String, Boolean> is_expense = itemsOfMonth.get(0);
            HashMap<String, Integer> quantity = itemsOfMonth.get(1);
            HashMap<String, Integer> sum_of_one = itemsOfMonth.get(2);

            for (String itemName : is_expense.keySet()) {
                if (quantity.get(itemName) * sum_of_one.get(itemName) > maxIncome && is_expense.get(itemName)) {
                    maxIncome = quantity.get(itemName) * sum_of_one.get(itemName);
                    maxIncomeItemName = itemName;
                }
                if (quantity.get(itemName) * sum_of_one.get(itemName) > maxExpense && !is_expense.get(itemName)) {
                    maxExpense = quantity.get(itemName) * sum_of_one.get(itemName);
                    maxExpenseItemName = itemName;
                }

            }

            System.out.println("Самый прибыльный товар в данном месяце - " + maxIncomeItemName);
            System.out.println("Сумма, которую он принес составила " + maxIncome);
            System.out.println("Самый большой расход в этом месяце - " + maxExpenseItemName);
            System.out.println("На это было потрачено - " + maxExpense);
            System.out.println();


        }
    }
}
