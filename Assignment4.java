package assignment4;
import java.util.Scanner;

/**
 * Created by joshuasander on 2/17/17.
 */
public class Assignment4 {
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanned = new Scanner(System.in);
        String fileName;
        char choice = 'k';
        double one;
        int two;
        int three;


        System.out.println("CS261 - Project 4/5 - Joshua Sander");

        while (choice != 'e' && choice != 'E')
        {
            System.out.println("Please choose an account:");
            System.out.println("A:Credit card\tB:Business expenses\tC:Savings\tE:Exit");

            String choiceString = scanned.next();
            choice = choiceString.charAt(0);

            Spreadsheet mySpreadsheet;

            if (choice == 'a' || choice == 'A')
            {
                fileName = "Credit.txt";
                System.out.println("Please enter your current credit limit");
                one = scanned.nextDouble();
                System.out.println("Please enter your card's interest rate");
                two = scanned.nextInt();
                mySpreadsheet = new creditCard(fileName, one, two);
            }

            else if (choice == 'b' || choice == 'B')
            {
                fileName = "Business.txt";
                System.out.println("Please enter this year's business tax rate");
                two = scanned.nextInt();
                mySpreadsheet = new BusinessExpenses(fileName, two);
            }

            else if (choice == 'c' || choice == 'C')
            {
                fileName = "Savings.txt";
                System.out.println("Please enter your savings' interest rate");
                two = scanned.nextInt();
                System.out.println("Please enter the current tax rate on interest");
                three = scanned.nextInt();
                mySpreadsheet = new SavingsAccount(fileName, two, three);
            }

            else
                break;

            while (choice != 'f' && choice != 'F')
            {
                System.out.println("Please enter from one of the following options:");
                System.out.println("A: Add Item\nB: Remove Item\nC: Display selected item/s\nD: Display Table\nF: Return to Main Menu\n");

                choiceString = scanned.next();
                choice = choiceString.charAt(0);

                if (choice =='A' || choice == 'a')
                    mySpreadsheet.addToTable();

                if (choice == 'B' || choice == 'b')
                    mySpreadsheet.removeFromTable();

                if (choice == 'C' || choice == 'c')
                    mySpreadsheet.displayChosen();

                if (choice == 'D' || choice == 'd')
                    mySpreadsheet.displayTable();
            }
        }
    }
}
