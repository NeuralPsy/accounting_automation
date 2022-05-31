import java.util.ArrayList;
import java.util.HashMap;

public class YearlyReport {
    private String[] months = {"Январь", "Февраль", "Март"};
    private int[] years = {2021}; // на случай, если еще придется добавлять отчеты за другой год

    public String readFileContentsOrNull(String path) {

        for (int i = 0; i < years.length; i++) {

            HashMap<String, Integer> amount = new HashMap<>();
            HashMap<String, Integer> is_expense = new HashMap<>();
            HashMap<String, Integer> sum_of_one = new HashMap<>();

            //тестовый коммент для проверки работы гита

            String fileContents = readFileContentsOrNull("resources/y." + years[i] + ".csv");
            String[] lines = fileContents.split(System.lineSeparator());
            System.out.println(months[i]);



        }
        return "qwerty";
    }

}
