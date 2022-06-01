import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;


public class MonthlyReport {
    private String[] months = {"Январь", "Февраль", "Март"};
    private final String  monthFileName= "m.20210";
    static HashMap<String, ArrayList> monthlyReport = new HashMap<>();

    static private boolean isAlreadyChecked = false;

    public void countReport() {
        if (!isAlreadyChecked) {

            System.out.println(monthlyReport);

            for (int i = 0; i < months.length; i++) {
                ArrayList<HashMap> itemsInfo = new ArrayList<>();
                HashMap<String, Boolean> isExpense = new HashMap<>();
                HashMap<String, Integer> quantity = new HashMap<>();
                HashMap<String, Integer> sumOfOne = new HashMap<>();

                String fileContents = readFileContentsOrNull("resources/" + monthFileName + (i + 1) + ".csv");
                String[] lines = fileContents.split(System.lineSeparator());

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
                System.out.println(monthlyReport);

            } isAlreadyChecked = true;
        } else {
            System.out.println("Отчеты за все месяцы уже считаны. " +
                    "Вы можете вывести информацию о всех месячных отчетах");
        }
    }
    public void printReport(){
        for (String month: months){
            int maxMoneyMonth = 0;
            String maxMoneyItemName = "";

            System.out.println(month);

            ArrayList<HashMap> itemsOfMonth = monthlyReport.get(month);

            HashMap<String, Boolean> is_expense = itemsOfMonth.get(0);
            HashMap<String, Integer> quantity = itemsOfMonth.get(1);
            HashMap<String, Integer> sum_of_one = itemsOfMonth.get(2);

            for (String itemName: is_expense.keySet()){
                if (quantity.get(itemName)*sum_of_one.get(itemName) > maxMoneyMonth && is_expense.get(itemName)) {
                    maxMoneyMonth = quantity.get(itemName)*sum_of_one.get(itemName);
                    maxMoneyItemName = itemName;
                }
            }
            System.out.println("Самый прибыльный товар в данном месяце - "+maxMoneyItemName);
            System.out.println("Сумма, которую он принес составила "+ maxMoneyMonth);
            System.out.println();

        }
    }




    public String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. " +
                    "Возможно, файл не находится в нужной директории.");
            return null;
        }
    }
}

