package bored;

public class MyList<E>
{
    private E[] data;
    private int free;

    MyList()
    {
        data=(E[])(new Object[10]);
        free=0;
    }

    MyList(int size)
    {
        data=(E[])(new Object[size]);
        free=0;
    }

    public E addLast(E elem)
    {
        if(free>=data.length)
        {
            E[]d=(E[])(new Object[data.length*2]);
            for(int x=0;x<data.length;x++)
                d[x]=data[x];
            d[free]=elem;
            data=d;
        }
        else
            data[free]=elem;
        free++;
        return elem;
    }

    public E addFirst(E elem)
    {
        if(free>=data.length)
        {
            E[]d=(E[])(new Object[data.length*2]);
            for(int x=0;x<data.length;x++)
                d[x+1]=data[x];
            d[0]=elem;
            data=d;
        }
        else
        {
            E[]d=(E[])(new Object[data.length]);
            for(int x=0;x<data.length-1;x++)
                d[x+1]=data[x];
            d[0]=elem;
            data=d;
        }
        free++;
        return elem;
    }

    public E add(int index,E elem)
    {
        if(free>=data.length)
        {
            E[]d=(E[])(new Object[data.length*2]);
            for(int x=0;x<data.length;x++)
                if(x<index)
                    d[x]=data[x];
                else
                    d[x+1]=data[x];
            d[index]=elem;
            data=d;
        }
        else
        {
            E[]d=(E[])(new Object[data.length]);
            for(int x=0;x<data.length;x++)
                if(x<index)
                    d[x]=data[x];
                else
                    d[x+1]=data[x];
            d[index]=elem;
            data=d;
        }
        return elem;
    }

    public E remove(int index)
    {
        free--;
        E t=data[index];
        for(int x=index;x<data.length;x++)
            data[x]=data[x+1];
        return t;
    }
    
    public E removeLast()
    {
        return remove(free-1);
    }

    public E removeFirst()
    {
        return remove(0);
    }

    public E get(int index)
    {
        return data[index];
    }

    public String toString()
    {
        String s="[";
        for(int x=0;x<free;x++)
        {
            s+=data[x];
            if(x+1<free)
            s+=", ";
        }
        return s+"]";
    }

    public int size()
    {
        return free;
    }

    public boolean member(E elem)
    {
        int i=0;
        while(i<free && !data[i].equals(elem))
            i++;
        return i<free;
    }

    public int indexOf(E elem)
    {
        for(int x=0;x<free;x++)
            if(data[x].equals(elem))
                return x;
        return -1;
    }

    public boolean included_in(MyList<E> l)
    {
        for(int i=0;i<size();i++)
        {
            if(!l.member(get(i)))
                return false;
        }
        return true;
    }

    public MyList<Pair<E,E>> zip(MyList<E> l)
    {

        return null;
    }

    public boolean sublist(MyList<E> l)
    {
        int i=-1;
        for(int r=0;r<size();r++)
        {
            int t=i;
            i=l.indexOf(get(r));
            if(i==-1 || i < t)
                return false;
        }
        return true;
    }

    public static void main(String[]args)
    {
        MyList<Double> i=new MyList<Double>();
        MyList<Double> j=new MyList<Double>();
        i.addLast(1.0);
        i.addLast(2.0);
        j.addLast(1.0);
        j.addLast(2.0);
        j.addLast(3.0);
        System.out.println("i"+i);
        System.out.println("j"+j);
        System.out.println(i.included_in(j));
        System.out.println(j.included_in(i));
        System.out.println(i.sublist(j));
    }
}