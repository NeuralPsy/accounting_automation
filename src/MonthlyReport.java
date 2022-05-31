import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;


public class MonthlyReport implements Reports {
    private String[] months = {"Январь", "Февраль", "Март"};
    public void printReport() {

       // обработка файла для дальнейших рассчетов
        for (int i = 0; i < months.length; i++) {
            ArrayList<String> item_name = new ArrayList<>();
            HashMap<String, Boolean> is_expense = new HashMap<>();
            HashMap<String, Integer> quantity = new HashMap<>();
            HashMap<String, Integer> sum_of_one = new HashMap<>();
            ArrayList<HashMap> preparedData = new ArrayList<>();

            int maxSum = 0;
            String nameOfBest = "";
            int maxExpense = 0;
            String maxExpenseItem = "";
            String fileContents = readFileContentsOrNull("resources/m.20210" + (i+1) + ".csv");
            String[] lines = fileContents.split(System.lineSeparator());
            System.out.println(months[i]);

            for (int j = 1; j < lines.length; j++){
                String[] lineContents = lines[j].split(",");
                item_name.add(lineContents[0]);
                is_expense.put(lineContents[0], Boolean.parseBoolean(lineContents[1]));
                quantity.put(lineContents[0], Integer.parseInt(lineContents[2]));
                sum_of_one.put(lineContents[0], Integer.parseInt(lineContents[3]));

                for (String item: item_name){
                    boolean isExpense = is_expense.get(item);
                    int itemQuantity = quantity.get(item);
                    int sumOfOne = sum_of_one.get(item);
                    if (maxSum < itemQuantity*sumOfOne && isExpense) {
                        maxSum = itemQuantity * sumOfOne;
                        nameOfBest = item;
                    }
                    if (maxExpense < sumOfOne) {
                        maxExpense = sumOfOne;
                        maxExpenseItem = item;
                    }

                }

            }
            preparedData.add(is_expense);
            preparedData.add(quantity);
            preparedData.add(sum_of_one);

            System.out.println("Самый прибыльный товар – "+nameOfBest+". Прибыль "+ maxSum);
            System.out.println("Самая большая трата – "+ maxExpenseItem+". Сумма "+ maxExpense);
            System.out.println();






        }
    }
    public String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }
}

