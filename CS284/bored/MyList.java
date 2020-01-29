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
            for(int x=0;x<data.length;x++)
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
            s+=data[x]+", ";
        return s+"]";
    }
}