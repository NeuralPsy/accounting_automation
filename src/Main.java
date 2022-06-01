import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// Я точно знаю, что код в классах можно написать намного короче и буду очень признателен,
// если ты сможешь порекомендовать мне какую-нибудь литературу по рефакторингу и оптимизации кода

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


