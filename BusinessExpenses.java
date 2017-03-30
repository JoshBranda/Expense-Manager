package assignment4;

/**
 * Created by joshuasander on 2/17/17.
 */
public class BusinessExpenses extends Spreadsheet {
    public BusinessExpenses(String fileInput, int rate)
    {
        super(fileInput);
        taxRate = rate;
    }

    @Override
    public void displayTable()
    {
        double total = 0;
        double taxDeduct = 0;

        System.out.format("%-8s%-24s%-16s%s%n", "Number", "Description", "Payments", "Charges");

        for (Transaction x : accounts)
        {
            x.printValues();
            total = total + x.getDebit() + x.getCredit();
        }

        taxDeduct = total * taxRate / 100;

        System.out.printf("%nYour taxable expenses so far are: %.2f%n", total);
        System.out.printf("At a tax rate of %d percent, you will will bet back %.2f for businesss expenses%n%n", taxRate, taxDeduct);
    }

    private int taxRate;
}
