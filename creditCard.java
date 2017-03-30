package assignment4;

import java.io.BufferedReader;

/**
 * Created by joshuasander on 2/17/17.
 */
public class creditCard extends Spreadsheet {
    public creditCard(String fileInput, double toLimit, int toInterest)
    //public creditCard(BufferedReader toRead, double toLimit, int toInterest)
    {
        super(fileInput);
        limit = toLimit;
        interest = toInterest;
    }

    @Override
    public void displayTable()
    {
        double total = 0;
        double penalty = 0;

        System.out.format("%-8s%-24s%-16s%s%n", "Number", "Description", "Charged", "Payments");
        for (Transaction x : accounts)
        {
            x.printValues();
            total = total + x.getDebit() + x.getCredit();
        }

        total = 0 - total;

        System.out.printf("%nYour have a balance of: %.2f", total);
        System.out.printf(" out of a %.2f limit%n", limit);

        if (total > 0)
            penalty = total * interest / 100;

        if (total > limit)
        {
            System.out.println("You have exceeded your limit!  You will have to pay 1 million dollars!!!");
        }

        System.out.print("Your interest if not paid by the end of the month is: ");
        System.out.format("%.2f%n%n", penalty);
    }


    private double limit;
    private int interest;
}
