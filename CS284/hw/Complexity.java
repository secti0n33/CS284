package hw;
//Michael Sanchez
//I pledge my honor that I have abided by the Stevens Honor System
public class Complexity
{
    public void method1(int n)
    {
        int ct=0;
        for(int i=0;i<n;i++)
            for(int x=0;x<n;x++)
            {
                System.out.println("Operation: "+ct);
                ct++;
            }
    }

    public void method2(int n)
    {
        int ct=0;
        for(int i=0;i<n;i++)
            for(int l=0;l<n;l++)
                for(int x=0;x<n;x++)
                {
                    System.out.println("Operation: "+ct);
                    ct++;
                }
    }

    public void method3(int n)
    {
        int ct=0;
        for(int x=0;x<n;x*=2)
        {
            System.out.println("Operation: "+ct);
            ct++;
        }
    }

    public void method4(int n)
    {
        int ct=0;
        for(int i=0;i<n;i++)
            for(int x=0;x<n;x*=2)
            {
                System.out.println("Operation: "+ct);
                ct++;
            }
    }

    public void method5(int n)
    {
        int ct=0;
        for(int i=0;i<n;i*=2)
            for(int x=0;x<n;x*=2)
            {
                System.out.println("Operation: "+ct);
                ct++;
            }
    }

    public void method6(int n)
    {
        int ct=0;
        for(double x=1;x<n;x=(Math.log(x)/Math.log(2)))
        {
            System.out.println("Operation: "+ct);
            ct++;
        }
    }
}