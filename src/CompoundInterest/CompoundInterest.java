package CompoundInterest;

/**
 * Ten program demonstruje przechowywanie danych tabelarycznych w tablicy dwuwymiarowej.
 * This program demonstrates storing tabular data in a two-dimensional array.
 * @author Tomek
 *
 */
public class CompoundInterest
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        final double STARTRATE = 10;
        final int NRATES = 6;
        final int NYEARS = 10;

        //Ustawienie stóp oprocentowania na wartości w przedziale 10 - 15%.
        //Setting interest rates to values in the range of 10 - 15%.
        double[] interestRate = new double[NRATES];

        for (int i = 0; i < interestRate.length; i++)
            interestRate[i] = (STARTRATE + i) / 100;

        double[][] balances = new double[NYEARS][NRATES];

        //Ustawienie sald początkowych na 10000.
        //Set initial balances to 10000.
        for (int j = 0; j < balances[0].length; j++)
            balances[0][j] = 10000;

        //Obliczanie odsetek dla przyszłych lat.
        //Calculating interest for future years.
        for (int i = 1; i < balances.length; i++)
        {
            for (int j = 0; j < balances[i].length; j++)
            {
                //Pobieranie sald z minionego roku z poprzedniego wiersza.
                //Retrieve past year balances from the previous row.
                double oldBalance = balances[i-1][j];

                //Obliczanie odsetek.
                //Interest calculation.
                double interest = oldBalance * interestRate[j];

                //Oblicznie tegorocznego salda.
                //Calculation of this year's balance.
                balances[i][j] = oldBalance + interest;
            }

        }

        //Wydruk jednego wiersza stóp oprocentowania.
        //Printout of one line of interest rates.
        for(int i = 0; i < interestRate.length; i++)
            System.out.printf("%9.0f%%", 100 * interestRate[i]);

        System.out.println();

        //Wydruk tabeli sald.
        //Balance table printout.
        for (double[] row : balances)
        {
            //Wydruk wiersza tabeli.
            //Table row printout.
            for(double b : row)
                System.out.printf("%10.2f", b);

            System.out.println();
        }
    }

}
