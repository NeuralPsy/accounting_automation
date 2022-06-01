import java.util.HashMap;

public class Comparison {
    static private HashMap<String, Integer> expensesFromYearReport;
    static private HashMap<String, Integer> incomesFromYearReport;

    static private HashMap<String, Integer> expensesFromMonthReport;
    static private HashMap<String, Integer> incomesFromMonthReport;


    void setMonthHashMapsFromYear(HashMap monthCmnExFromYear, HashMap monthCmnInFromYear){
        this.expensesFromYearReport = monthCmnExFromYear;
        this.incomesFromYearReport = monthCmnInFromYear;
    }

    void setMonthHashMapsFromMonths(HashMap monthCmnExFromMonths, HashMap monthCmnInFromMonths){
        this.expensesFromMonthReport = monthCmnExFromMonths;
        this.incomesFromMonthReport = monthCmnInFromMonths;
    }

    void startComparing(){
        boolean issues = false;
        for (String month: expensesFromMonthReport.keySet()){
            if (!expensesFromYearReport.get(month).equals(expensesFromMonthReport.get(month))) {
                System.out.println("Обнаружено несоответствие показателей в расходах за " + month);
                issues = true;
            } else if (!incomesFromYearReport.get(month).equals(incomesFromMonthReport.get(month))){
                System.out.println("Обнаружено несоответствие показателей в доходах за " + month);
                issues = true;
            }
        }
        System.out.println("Проверка завершена");
        if (!issues) System.out.println("Ошибки не обнаружены");
        System.out.println();
    }

}
