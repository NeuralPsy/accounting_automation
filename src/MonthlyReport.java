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
            ArrayList<HashMap> itemsInfo = new ArrayList<>();

            for (int i = 0; i < months.length; i++) {
                HashMap<String, Boolean> is_expense = new HashMap<>();
                HashMap<String, Integer> quantity = new HashMap<>();
                HashMap<String, Integer> sum_of_one = new HashMap<>();

                String fileContents = readFileContentsOrNull("resources/" + monthFileName + (i + 1) + ".csv");
                String[] lines = fileContents.split(System.lineSeparator());

                for (int j = 1; j < lines.length; j++) {
                    String[] lineContents = lines[j].split(",");

                    is_expense.put(lineContents[0], Boolean.parseBoolean(lineContents[1]));
                    quantity.put(lineContents[0], Integer.parseInt(lineContents[2]));
                    sum_of_one.put(lineContents[0], Integer.parseInt(lineContents[3]));

                }
                itemsInfo.add(is_expense);
                itemsInfo.add(quantity);
                itemsInfo.add(sum_of_one);
                monthlyReport.put(months[i], itemsInfo);

            } isAlreadyChecked = true;
        } else {
            System.out.println("Отчеты за все месяцы уже считаны. " +
                    "Вы можете вывести информацию о всех месячных отчетах");
        }
    }
    public void printReport(){
        for (String month: months){
            System.out.println(month);
            ArrayList<HashMap> itemsOfMonth = monthlyReport.get(month);
            System.out.println(itemsOfMonth);
            for (HashMap item: itemsOfMonth){
               for (HashMap innerItem: itemsOfMonth){
                   for (Object innerItemName: innerItem.keySet()){

                   }
               }
            }
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

