import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Menu{
    void printMenu(){
        System.out.println("Какое действие Вы хотите Выполнить?");
        System.out.println("1 – Считать все месячные отчёты");
        System.out.println("2 – Считать годовой отчёт");
        System.out.println("3 – Сверить отчёты");
        System.out.println("4 – Вывести информацию о всех месячных отчётах");
        System.out.println("5 – Вывести информацию о годовом отчёте");
        System.out.println("0 – Завершить работу программы");
    }

    void doWhatUserSay(int userInput){
        MonthlyReport monthlyReport = new MonthlyReport();
        switch (userInput){
            case 1:
                monthlyReport.printReport();
                break;
            }

        }
    }





