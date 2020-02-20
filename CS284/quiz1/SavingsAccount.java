package quiz1;
//Michael Sanchez and Bryant Truong
//I pledge my honor that I have abided by the Stevens Honor System
public class SavingsAccount extends BankAccount
{
    private double interest;
    SavingsAccount()
    {
        super();
    }

    SavingsAccount(double rate)
    {
        super();
        interest=rate;
    }

    void addInterest()
    {
        deposit(interest*getBalance());
    }
}