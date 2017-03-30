package assignment4;

/**
 * Created by joshuasander on 2/17/17.
 */
public class Transaction {
    public Transaction(String aDescription, double value)
    {
        number = totalNumber++;
        description = aDescription;

        if (value > 0)
        {
            credit = value;
            debit = 0;
        }

        else
        {
            debit = value;
            credit = 0;
        }
    }

    public int getNumber()
    {
        return number;
    }

    public String getDescription()
    {
        return description;
    }

    public double getDebit()
    {
        return debit;
    }

    public double getCredit()
    {
        return credit;
    }

    public void printValues()
    {
        System.out.format("%-8d%-24s%-16.2f%.2f%n", number, description, debit, credit);
    }

    private static int totalNumber = 0;
    private int number;
    private String description;
    private double debit;
    private double credit;

}
