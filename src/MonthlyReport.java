import java.util.ArrayList;
import java.util.HashMap;


public class MonthlyReport {
    private String[] months = {"Январь", "Февраль", "Март"};
    private final String monthFileName = "m.20210";
    static HashMap<String, ArrayList> monthlyReport = new HashMap<>();

    static private HashMap<String, Integer> monthCmnEx = new HashMap<>();
    static private HashMap<String, Integer> monthCmnIn = new HashMap<>();

    static private boolean isMonthAlreadyChecked = false;

    public void countMonthsReport() {
        if (!isMonthAlreadyChecked) {
            ReadFile fileContents = new ReadFile();
            for (int i = 0; i < months.length; i++) {
                ArrayList<HashMap> itemsInfo = new ArrayList<>();
                HashMap<String, Boolean> isExpense = new HashMap<>();
                HashMap<String, Integer> quantity = new HashMap<>();
                HashMap<String, Integer> sumOfOne = new HashMap<>();


                String openedFile = fileContents.readFile("resources/" + monthFileName + (i + 1) + ".csv");
                String[] lines = openedFile.split(System.lineSeparator());

                for (int j = 1; j < lines.length; j++) {
                    String[] lineContents = lines[j].split(",");

                    isExpense.put(lineContents[0], Boolean.parseBoolean(lineContents[1]));
                    quantity.put(lineContents[0], Integer.parseInt(lineContents[2]));
                    sumOfOne.put(lineContents[0], Integer.parseInt(lineContents[3]));

                }
                itemsInfo.add(isExpense);
                itemsInfo.add(quantity);
                itemsInfo.add(sumOfOne);
                monthlyReport.put(months[i], itemsInfo);

            }
            isMonthAlreadyChecked = true;
        } else {
            System.out.println("Отчеты за все месяцы уже считаны. " +
                    "Вы можете вывести информацию о всех месячных отчетах");
        }
    }

    public void printMonthsReportCount() {


        for (String month : months) {
            int maxIncome = 0;
            int maxExpense = 0;
            String maxExpenseItemName = "";
            String maxIncomeItemName = "";

            int profit = 0;
            int monthIncome = 0;
            int monthExpense = 0;

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

    void getReport(){
        return;
    }
}
