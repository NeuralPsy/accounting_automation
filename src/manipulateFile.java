import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class manipulateFile {

    public String readFile(String path){
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. " +
                    "Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

    //Добавил методы создания удобного для программы формата отчета
    public void createMonthlyReport(String[] openedFile,
                               HashMap map1,
                               HashMap map2,
                               HashMap map3,
                               ArrayList whereToAdd,
                               HashMap monthlyReport, String month){
        for (int j = 1; j < openedFile.length; j++) {
            String[] lineContents = openedFile[j].split(",");

            map1.put(lineContents[0], Boolean.parseBoolean(lineContents[1]));
            map2.put(lineContents[0], Integer.parseInt(lineContents[2]));
            map3.put(lineContents[0], Integer.parseInt(lineContents[3]));
        }

        whereToAdd.add(map1);
        whereToAdd.add(map2);
        whereToAdd.add(map3);
        monthlyReport.put(month, whereToAdd);
    }

    public void createYearReport(String[] openedFile,
                                 ArrayList isExpense,
                                 ArrayList amount,
                                 ArrayList monthsOfYearReport,
                                 ArrayList convertedToListReport,
                                 HashMap yearlyReport,
                                 int year,
                                 String[] months){
        for (int j = 1; j < openedFile.length; j++) {
            String[] lineContents = openedFile[j].split(",");
            if (Boolean.parseBoolean(lineContents[2]));

            isExpense.add(Boolean.parseBoolean(lineContents[2]));
            amount.add(Integer.parseInt(lineContents[1]));
            monthsOfYearReport.add(months[Integer.parseInt(lineContents[0])-1]);

        }
        convertedToListReport.add(isExpense);
        convertedToListReport.add(amount);
        convertedToListReport.add(monthsOfYearReport);
        yearlyReport.put(year, convertedToListReport);
    }

}
