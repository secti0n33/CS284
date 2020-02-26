package StacksAndQueues;


public class Stack<E> implements StackInt<E>
{
    private class Node<F>
    {
        public F data;
        public Node<F> next;
        public Node(F data)
        {
            this.data=data;
            next=null;
        }

        public Node(F data, Node<F> n)
        {
            this.data=data;
            next=n;
        }
    }

    private int size;
    private Node<E> top;

    public Stack()
    {
        top=null;
        size=0;
    }

    public E pop()
    {
        if(top==null)
        throw new IllegalStateException("Cannot Pop Top if Stack is Empty");
        Node<E> temp=top;
        top=top.next;
        size--;
        return temp.data;
    }

    public E peek()
    {
        if(top==null)
            throw new IllegalStateException("Cannot Peek Top if Stack is Empty");
        return top.data;
    }

    public E push(E obj)
    {
        if(top==null)
            top=new Node<E>(obj);
        else
            top = new Node<E>(obj,top);
        size++;
        return obj;
    }

    public boolean empty()
    {
        return top==null;
    }

    public String toString()
    {
        String t="";
        Node<E> traversal=top;
        for(int x=0;x<size-1;x++)
        {
            t+=traversal.data+",";
            traversal=traversal.next;
        }
        t+=traversal.data+"";
        return t;
    }

    public static void main(String[]args)
    {
        Stack<Integer>s=new Stack<Integer>();
        System.out.println(s.empty());
        for(int x=0;x<10;x++)
            s.push(x);
        System.out.println(s);
        System.out.println(s.peek());
        System.out.println(s);
        System.out.println(s.pop());
        System.out.println(s);
    }
}