import java.util.ArrayList;

public class Menu{

    private Comparison comparison = new Comparison();
    private MonthlyReport monthlyReport = new MonthlyReport();
    private YearlyReport yearlyReport = new YearlyReport();
    private ArrayList<Integer> userCommands = new ArrayList<>();
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

        switch (userInput){
            case 1:
                if (userCommands.contains(userInput))
                    System.out.println("Месячные отчеты уже считаны");// Здесь я предусмотрел вывод ошибки,
                                                                    // если данные уже были обработаны
                else {
                    userCommands.add(userInput);
                    monthlyReport.countMonthsReport();
                    System.out.println("Считывание прошло успешно");
                }
                break;
            case 2:
                if (userCommands.contains(userInput))
                    System.out.println("Годовой отчет уже считан");// Здесь провел проверку
                                                                    // на наличие считанного отчета
                else {
                    userCommands.add(userInput);
                    yearlyReport.countYearlyReport();
                    System.out.println("Считывание прошло успешно");
                }
                break;
            case 3:
                if (userCommands.contains(1) && userCommands.contains(2)) {     // аналогично и здесь. Операция
                                                                // не будет выполнена пока не загрузятся отчеты
                    monthlyReport.transformData();
                    yearlyReport.transformData();
                    comparison.startComparing();
                }
                else System.out.println("Необходимо считать месячные и годовые отчеты вместе перед сверкой");
                break;
            case 4:
                if (userCommands.contains(1)) monthlyReport.printMonthsReportCount();
                else System.out.println("Необходимо считать месячные отчеты");      //здесь тоже
                break;
            case 5:
                if (userCommands.contains(2)) yearlyReport.printYearlyReportCount();
                else System.out.println("Необходимо считать годовой отчет");       // и здесь
                break;

            }

        }
    }





