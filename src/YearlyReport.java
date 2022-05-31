import java.util.ArrayList;
import java.util.HashMap;

public class YearlyReport implements Reports{
    private String[] months = {"Январь", "Февраль", "Март"};
    private int[] years = {2021};

    public String readFileContentsOrNull(String path){

        for (int i = 0; i < years.length; i++) {
            ArrayList<String> item_name = new ArrayList<>();
            HashMap<String, Boolean> is_expense = new HashMap<>();
            HashMap<String, Integer> quantity = new HashMap<>();
            HashMap<String, Integer> sum_of_one = new HashMap<>();

            //тестовый коммент для проверки работы гита

            String fileContents = readFileContentsOrNull("resources/y."+years[i]+".csv");
            String[] lines = fileContents.split(System.lineSeparator());
            System.out.println(months[i]);

        return;
    }
}
