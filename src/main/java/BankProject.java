import java.io.*;
import java.util.Scanner;

class BankProject {
    public static void main(String args[]) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int chc = 1;
        Action c = new Action(scanner);
        while (chc == 1) {
            System.out.println("*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*");
            System.out.println("*              MENU             *");
            System.out.println("*°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°*");
            System.out.println("*                               *");
            System.out.println("*\t1. CREATE A NEW ACCOUNT     *");
            System.out.println("*\t2. DELETE ACCOUNT           *");
            System.out.println("*\t3. DEPOSIT AMOUNT           *");
            System.out.println("*\t4. WITHDRAW                 *");
            System.out.println("*\t5. DISPLAY INFO             *");
            System.out.println("*\t6. CHANGE PASSWORD          *");
            System.out.println("*\t7. TRANSACTION LOGS         *");
            System.out.println("*                               *");
            System.out.println("*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*");
            System.out.print("ENTER YOUR CHOICE: ");
            String choice = scanner.nextLine();
            int ch = Integer.parseInt(choice);
            System.out.println();
            switch(ch)
            {
                case 1:
                    c.createAccount();
                    break;
                case 2:
                    c.deleteAccount();
                    break;
                case 3:
                    c.deposit();
                    break;
                case 4:
                    c.withdraw();
                    break;
                case 5:
                    c.display();
                    break;
                case 6:
                    c.passwordChange();
                    break;
                case 7:
                    c.logs();
                    break;
                default:
                    System.out.println("INVALID CHOICE!");
            }
            System.out.println("\nENTER 1 TO REPEAT PROCEDURE, ELSE PRESS ANY KEY TO EXIT.\n");
            System.out.print("CHOICE: ");
            chc = Integer.parseInt(scanner.nextLine());
        }
    }
}









