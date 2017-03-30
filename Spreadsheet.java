package assignment4;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

/**
 * Created by joshuasander on 2/17/17.
 */
abstract class Spreadsheet {
    public Spreadsheet(String fileName)
    {
        Scanner scanned = null;
        String textLine = null;
        double value = 0;
        accounts = new ArrayList<Transaction>();

        try
        {
            InputStream in = Spreadsheet.class.getResourceAsStream(fileName);
            BufferedReader readBuffer = new BufferedReader(new InputStreamReader(in));
            while ((textLine = readBuffer.readLine()) != null)
            {

                scanned = new Scanner(textLine);

                value = scanned.nextDouble();
                String descrip = scanned.nextLine();
                descrip = descrip.trim();

                Transaction one = new Transaction(descrip, value);
                accounts.add(one);
            }

            readBuffer.close();
        }

        catch(FileNotFoundException caught)
        {
            System.out.println("Unable to open " + fileName);
        }

        catch(IOException caught)
        {
            System.out.println("Error reading " + fileName);
        }
    }

    public void menu()
    {
        Scanner scanned = new Scanner(System.in);
        char choice = 'k';
        while (choice != 'e' && choice != 'E')
        {
            System.out.println("Please enter from one of the following options:");
            System.out.println("A: Add Item\nB: Remove Item\nC: Display selected item/s\nD: Display Table\nE: Exit program\n");

            String choiceString = scanned.next();
            choice = choiceString.charAt(0);

            if (choice =='A' || choice == 'a')
                addToTable();

            if (choice == 'B' || choice == 'b')
                removeFromTable();

            if (choice == 'C' || choice == 'c')
                displayChosen();

            if (choice == 'D' || choice == 'd')
                displayTable();
        }

    }

    public int addToTable()
    {
        Scanner userInput = new Scanner(System.in);
        String newDescription;
        double value = 0;
        Transaction toAdd;

        System.out.println("Please enter the description of your item");
        newDescription = userInput.nextLine();
        System.out.println("Please enter the value of the transaction");
        value = userInput.nextDouble();

        toAdd = new Transaction(newDescription, value);
        accounts.add(toAdd);

        return 1;
    }

    public int removeFromTable()
    {
        Scanner userInput = new Scanner(System.in);
        String oldDescription;
        int choice = 0;
        int size = accounts.size();
        Transaction toRemove;
        boolean result = false;

        System.out.println("Please enter the description of the item you want to remove");
        oldDescription = userInput.nextLine();

        System.out.println("This is what we found with your description:\n\n");

        for (Transaction x : accounts)
        {
            String toCompare = x.getDescription();

            if (oldDescription.equalsIgnoreCase(toCompare) == true)
            {
                x.printValues();
            }
        }

        System.out.println("\nPlease enter the number for the field you want to remove:\n");
        choice = userInput.nextInt();

        for (int x = 0; x < size; x++)
        {
            toRemove = (Transaction)accounts.get(x);
            if (toRemove.getNumber() == choice)
            {
                accounts.remove(x);
                System.out.println("\nEntry removed!\n");
                result = true;
                break;
            }
        }

        if (result == false)
            System.out.println("\nThis entry does not exist!\n");

        return 1;
    }

    public void displayChosen()
    {
        Scanner userInput = new Scanner(System.in);
        String myDescription;

        System.out.println("Please enter the description of the item you want to find");
        myDescription = userInput.nextLine();

        System.out.println("This is what we found with your description:\n\n");

        for (Transaction x : accounts)
        {
            String toCompare = x.getDescription();

            if (myDescription.equalsIgnoreCase(toCompare) == true)
            {
                x.printValues();
            }
        }

        System.out.println();
    }

    abstract void displayTable();

    protected List<Transaction> accounts;
    private int totalSize;
}
