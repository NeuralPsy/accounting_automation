import java.util.ArrayList;
import java.util.HashMap;

public class YearlyReport {
    private String[] months = {"Январь", "Февраль", "Март"};
    private int[] years = {2021}; // на случай, если еще придется добавлять отчеты за другой год
    private final String  yearFileName= "y.";
    static private HashMap<Integer, ArrayList<ArrayList>> yearlyReport = new HashMap<>();

    public static HashMap<String, Integer> monthCmnEx = new HashMap<>();
    public static HashMap<String, Integer> monthCmnIn = new HashMap<>();

    static private boolean isYearAlreadyChecked = false;
    public void countYearlyReport() {
        if (!isYearAlreadyChecked) {
            ReadFile fileContents = new ReadFile();

            for (int i = 0; i < years.length; i++) {
                ArrayList<Boolean> isExpense = new ArrayList<>();
                ArrayList<Integer> amount = new ArrayList<>();
                ArrayList<String> monthsOfYearReport = new ArrayList<>();
                ArrayList<ArrayList> convertedToListReport = new ArrayList<>();

                String openedFile = fileContents.readFile("resources/" + yearFileName + years[i] + ".csv");
                String[] lines = openedFile.split(System.lineSeparator());

                for (int j = 1; j < lines.length; j++) {
                    String[] lineContents = lines[j].split(",");
                    if (Boolean.parseBoolean(lineContents[2]));

                    isExpense.add(Boolean.parseBoolean(lineContents[2]));
                    amount.add(Integer.parseInt(lineContents[1]));
                    monthsOfYearReport.add(months[Integer.parseInt(lineContents[0])-1]);

                }
                convertedToListReport.add(isExpense);
                convertedToListReport.add(amount);
                convertedToListReport.add(monthsOfYearReport);
                yearlyReport.put(years[i], convertedToListReport);

            } isYearAlreadyChecked = true;
        } else {
            System.out.println("Отчет за год уже считан. " +
                    "Вы можете вывести информацию о годовом отчете");
        }
    }


    public void printYearlyReportCount() {
        for (int year: years) {
            int commonYearIncome = 0;
            int commonYearExpense = 0;
            boolean is_expense = false;
            int amountValue = 0;
            String monthName = "";

            int expensesNum = 0;
            int incomesNum = 0;

            int profit = 0;
            int monthIncome = 0;
            int monthExpense = 0;

            System.out.println(year);


            ArrayList<Boolean> isExpense = yearlyReport.get(year).get(0);
            ArrayList<Integer> amount = yearlyReport.get(year).get(1);
            ArrayList<String> monthsOfYearReport = yearlyReport.get(year).get(2);


            for (int i = 0; i < isExpense.size(); i++){
                is_expense = isExpense.get(i);
                amountValue = amount.get(i);
                monthName = monthsOfYearReport.get(i);


                if (is_expense){
                    commonYearIncome += amountValue;
                    incomesNum++;
                    monthExpense = amountValue;
                } else {
                    commonYearExpense += amountValue;
                    expensesNum++;
                    monthIncome = amountValue;
                }

                profit = monthIncome - monthExpense;

                if (i % 2 == 0){
                    System.out.println(monthName);
                    System.out.println("Прибыль в этом месяце составила "+(profit));
                    System.out.println();

                }
                ArrayList<HashMap> dataToPutIside = new ArrayList<>();

                monthCmnEx.put(monthName, monthExpense);
                monthCmnIn.put(monthName, monthIncome);

            }

            //dataToCompare.put(year, )



            double averageYearIncome = commonYearIncome/incomesNum;
            double averageYearExpense = commonYearExpense/expensesNum;

            System.out.println("Средний расход за все месяцы в году "+averageYearExpense);
            System.out.println("Средний доход за все месяцы в году "+averageYearIncome);
            System.out.println();


            }

    }

    HashMap getExFromYR(){
        return monthCmnEx;
    }

    HashMap getInFromYR(){
        return monthCmnIn;
    }


}
