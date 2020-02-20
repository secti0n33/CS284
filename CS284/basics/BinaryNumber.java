package basics;
/**@author Michael Sanchez
 * Pledge: I pledge my honor that I have abided by the Stevens Honor System
 * Section:284-A
 */
public class BinaryNumber
{
    private int[]data;
    private int length;
    BinaryNumber(int length)
    {
        this.length=length;
        data=new int[length];
        for(int x=0;x<length;x++)
            data[x]=0;
    }

    BinaryNumber(String str)
    {
        length=str.length();
        data=new int[length];
        for(int x=str.length()-1;x>=0;x--)
            data[x]=Integer.parseInt(str.substring(x,x+1));
    }

    int getLength(){return length;}

    int[] getInnerArray(){return data;}

    int getDigit(int index)
    {
        try{return data[index];}
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Invalid input returns '-1'");
            return -1;
        }
    }

    int toDecimal()
    {
        int temp=0;
        for(int x=0;x<data.length;x++)
            temp+=data[x]*Math.pow(2,data.length-x-1);
        return temp;
    }

    void bitShift(int direction,int amount)
    {
        if(Math.abs(direction)!=1)
            System.out.println("Invalid direction");
        else
        {
            if(direction==-1)
            {
                if(amount>length)
                {
                    length=0;
                    data=new int[0];
                }
                else
                {
                    length-=amount;
                    int[]t=new int[length];
                    for(int x=0;x<length;x++)
                    t[x]=data[x];
                    data=t;
                }
            }
            else
            {
                length+=amount;
                int[]t=new int[length+amount];
                for(int x=0;x<length;x++)
                    if(x<data.length)
                        t[x]=data[x];
                    else
                        t[x]=0;
                data=t;
            }
        }
    }

    static int bwand(BinaryNumber bn1, BinaryNumber bn2)
    {
        if(bn1.getLength()!=bn2.getLength())
        {
            System.out.println("Invalis input returns '-1'");
            return -1;
        }
        int t=0;
        int[]b1=bn1.getInnerArray();
        int[]b2=bn2.getInnerArray();
        int mult=(int)Math.pow(10,b2.length-1);
        for(int x=0;x<bn1.getLength();x++)
        {
            t+=(b1[x]==b2[x]&&b2[x]==1)?1*mult:0;
            mult/=10;
        }
        return t;
    }

    static int bwor(BinaryNumber bn1, BinaryNumber bn2)
    {
        if(bn1.getLength()!=bn2.getLength())
        {
            System.out.println("Invalis input returns '-1'");
            return -1;
        }
        int t=0;
        int[]b1=bn1.getInnerArray();
        int[]b2=bn2.getInnerArray();
        int mult=(int)Math.pow(10,b2.length-1);
        for(int x=0;x<bn1.getLength();x++)
        {
            t+=(b1[x]==1||b2[x]==1)?1*mult:0;
            mult/=10;
        }
        return t;
    }

    void add(BinaryNumber aBinaryNumber)
    {
        int carry=0;
        int[] d2=aBinaryNumber.getInnerArray();
        for(int x=length-1;x>=0;x--)
        {
            int t1=data[x];
            int t2=d2[x];
            int i=(t1==1||t2==1)&&t1!=t2?1:0;
            data[x]=(i==1||carry==1)&i!=carry?1:0;
            carry=(t1==1&&t2==1)?1:0;
        }
        if(carry==1)
        {
            BinaryNumber t=new BinaryNumber(1+toString());
            data=t.getInnerArray();
            length=t.getLength();
        }
    }

    public String toString()
    {
        String t="";
        for(int x=0;x<length;x++)
            t+=data[x];
        return t;
    }
}