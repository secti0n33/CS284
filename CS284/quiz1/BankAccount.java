package quiz1;
//Michael Sanchez and Bryant Truong
//I pledge my honor that I have abided by the Stevens Honor System
public class BankAccount
{
    private double balance;
    BankAccount()
    {
        balance=0;
    }

    BankAccount(double initialBalance)
    {
        balance=initialBalance;
    }

    void deposit(double amount)
    {
        if(amount>0)
            balance+=amount;
    }

    void withdraw(double amount)
    {
        if(amount<=0 || amount>balance)
            System.out.println("Insufficient funds");
        else
            balance-=amount;
    }

    double getBalance()
    {
        return balance;
    }

    void transfer(double amount, BankAccount destination)
    {
        if(amount<=0||amount>balance)
            System.out.println("Insufficient funds");
        else
        {
            balance-=amount;
            destination.deposit(amount);
        }
    }
}