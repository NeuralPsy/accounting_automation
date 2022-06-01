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
        YearlyReport yearlyReport = new YearlyReport();

        switch (userInput){
            case 1:
                monthlyReport.countMonthsReport();
                break;
            case 2:
                yearlyReport.countYearlyReport();
                break;
            case 3:
                System.out.println(yearlyReport.getExFromYR());;
                break;
            case 4:
                monthlyReport.printMonthsReportCount();
                break;
            case 5:
                yearlyReport.printYearlyReportCount();
                break;

            }

        }
    }





