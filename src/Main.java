import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Menu menu = new Menu();
        while (true) {
            menu.printMenu();
            int userInput = scanner.nextInt();
            if (userInput == 0){
                scanner.close();
                break;
            }
            menu.doWhatUserSay(userInput);
            }
        }
    }


