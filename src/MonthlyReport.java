import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;


public class MonthlyReport {
    private String[] months = {"Январь", "Февраль", "Март"};
    private final String  monthFileName= "m.20210";
    static HashMap<String, ArrayList<HashMap>> preparedData = new HashMap<>();

    public void countReport() {

        for (int i = 0; i < months.length; i++) {
            ArrayList<HashMap> monthData = new ArrayList<>();

            HashMap<String, ArrayList<String>> item_nameMap = new HashMap<>();
            HashMap<String, ArrayList<Boolean>> is_expenseMap = new HashMap<>();
            HashMap<String, ArrayList<Integer>> quantityMap = new HashMap<>();
            HashMap<String, ArrayList<Integer>> sum_of_oneMap = new HashMap<>();

            ArrayList<String> item_name = new ArrayList<>();
            ArrayList<Boolean> is_expense = new ArrayList<>();
            ArrayList<Integer> quantity = new ArrayList<>();
            ArrayList<Integer> sum_of_one = new ArrayList<>();

            String fileContents = readFileContentsOrNull("resources/"+monthFileName + (i+1) + ".csv");
            String[] lines = fileContents.split(System.lineSeparator());

            for (int j = 1; j < lines.length; j++){
                String[] lineContents = lines[j].split(",");
                item_name.add(lineContents[0]);
                is_expense.add(Boolean.parseBoolean(lineContents[1]));
                quantity.add(Integer.parseInt(lineContents[2]));
                sum_of_one.add(Integer.parseInt(lineContents[3]));
            }
            item_nameMap.put("item_name", item_name);
            is_expenseMap.put("is_expense", is_expense);
            quantityMap.put("quantity", quantity);
            sum_of_oneMap.put("sum_of_one", sum_of_one);

            monthData.add(item_nameMap);
            monthData.add(is_expenseMap);
            monthData.add(quantityMap);
            monthData.add(sum_of_oneMap);


            preparedData.put(months[i],monthData);

        }
    }
    public void printReport(){
        String maxItemName = "";
        int maxMoney = 0;
        for (String month: preparedData.keySet()){
            System.out.println(month);
            for (int i = 0; i < preparedData.get(month).size(); i++){
                HashMap<String, ArrayList<HashMap>> monthInfo = preparedData.get(month).get(i);
                for (String column: monthInfo.keySet()){
                    for (int j = 0; j < monthInfo.get(column).size(); j++){
                        System.out.println(monthInfo.get(column).get(j));
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

