package quiz1;
//Michael Sanchez and Bryant Truong
//I pledge my honor that I have abided by the Stevens Honor System
public class CheckingAccount extends BankAccount
{
    private int numTransactions;
    CheckingAccount(double initialBalance)
    {
        super(initialBalance);
        numTransactions=0;
    }

    void withdraw(double amount)
    {
        super.withdraw(amount);
        numTransactions++;
    }

    void deposit(double amount)
    {
        super.deposit(amount);
        numTransactions++;
    }
}