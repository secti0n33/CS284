package LinkedListStuff;

import bored.Pair;

public class SLList<E>
{
    public static class Node<F>
    {
        private F data;
        private Node<F> next;
        Node(F dataa, Node<F> nextt)
        {
            data=dataa;
            next=nextt;
        }

        Node(F dataa)
        {
            super();
            data=dataa;
        }
    }

    private Node<E> head;
    private int size;
    SLList()
    {
        head=null;
        size=0;
    }

    public E addFirst(E item)
    {
        head=new Node<E>(item,head);
        size++;
        return item;
    }

    public E addLast(E item)
    {
        if(head==null)
            return addFirst(item);
        Node<E> traversal=head;
        while(traversal.next!=null)
            traversal=traversal.next;
        traversal.next=new Node<E>(item);
        size++;
        return item;
    }

    public E add(int index, E item)
    {
        if(index==0)
            return addFirst(item);
        if(index>size || index<0)
            throw new IllegalArgumentException("Index Out of Bounds");
        Node<E> traversal=head;
        for(int x=0;x<index-1;x++)
            traversal=traversal.next;
        traversal.next=new Node<E>(item, traversal.next);
        size++;
        return item;
    }

    public E removeFirst()
    {
        E data=head.data;
        head=head.next;
        size--;
        return data;
    }

    public E removeLast()
    {
        if(size==1)
            return removeFirst();
        Node<E>traversal = head;
        while(traversal.next.next!=null)
            traversal=traversal.next;
        E data=traversal.next.data;
        traversal.next=null;
        size--;
        return data;
    }

    public E remove(int index)
    {
        if(index==0)
            return removeFirst();
        if(index>size||index<0)
            throw new IllegalArgumentException("Index Out of Bounds");
            Node<E> traversal=head;
        for(int x=0;x<index-1;x++)
            traversal=traversal.next;
        E data=traversal.next.data;
        traversal.next=traversal.next.next;
        size--;
        return data;
    }

    public String toString()
    {
        String t="";
        Node<E> traversal=head;
        for(int x=0;x<size;x++)
        {
            t+=traversal.data;
            traversal=traversal.next;
        }
        return t;
    }

    public SLList<E> clone()
    {
        SLList<E> temp=new SLList<E>();
        Node<E> t=head;
        for(int x=1;x<size;x++)
        {
            temp.addLast(t.data);
            t=t.next;
        }
        return temp;
    }


    /**
     * Keeps all elements up to but not including n, and drops the rest
     * @param n: index of element we drop
     */
    public void take(int n)
    {
        if(n<0)
            throw new IllegalArgumentException();
        if(n<size)
        {
            Node<E> t=head;
            for(int x=0;x<n;x++)
            {
                if(x<n-1)
                    t=t.next;
                else
                    t.next=null;
            }
            size=n;
        }
    }
    /**
     * Drops all elements up to but not including n, and keeps the rest
     * @param n: Amount of elements we drop. If n > size, list is made empty
     */
    public void drop(int n)
    {
        if(n>=size)
        {
            head=null;
            size=0;
        }
        if(n>0)
        {
            head=head.next;
            size--;
            drop(n-1);
        }
    }

    public Pair<SLList<E>,SLList<E>> splitAt(int n)
    {
        Pair<SLList<E>,SLList<E>>t=new Pair<SLList<E>,SLList<E>>(new SLList<E>(), new SLList<E>());
        Node<E> traversal=head;
        if(n>size||n<0)
            throw new IllegalArgumentException();
        for(int x=0;x<size;x++)
        {
            if(x<n)
                t.getX().addLast(traversal.data);
            else   
                t.getY().addLast(traversal.data);
                traversal=traversal.next;
        }
        return t;
    }

    public int find(E data)
    {

        return -1;
    }

    public static void main(String[]args)
    {
        SLList<Integer>l=new SLList<Integer>();
        for(int x=0;x<10;x++)
            l.addLast(x);
        SLList<Integer>l2=l.clone();
        l2.remove(5);
        System.out.println(l);
        System.out.println(l2);
        l.take(5);
        System.out.println(l);
        l2.drop(5);
        System.out.println(l2);
        Pair<SLList<Integer>,SLList<Integer>> l3=l.splitAt(2);
        System.out.println("<"+l3.getX()+","+l3.getY()+">");
    }
}