package assignment4;

/**
 * Created by joshuasander on 2/17/17.
 */
public class SavingsAccount extends Spreadsheet{
    public SavingsAccount(String inputFile, int intRate, int tRate)
    {
        super(inputFile);
        interestRate = intRate;
        taxRate = tRate;
    }

    @Override
    public void displayTable()
    {
        double total = 0;
        double interestEarned = 0;
        double taxableInterest = 0;

        System.out.format("%-8s%-24s%-16s%s%n", "Number", "Date", "Withdraw", "Deposit");
        for (Transaction x : accounts)
        {
            x.printValues();
            total = total + x.getDebit() + x.getCredit();
        }

        interestEarned = total * interestRate / 100;
        taxableInterest = interestEarned * taxRate / 100;

        System.out.printf("%nYour account balance is: %.2f", total);
        System.out.printf("%nYour earned interest is: %.2f%nThe tax you owe on your earnings is: %.2f%n", interestEarned, taxableInterest);

    }

    private int interestRate;
    private int taxRate;
}
