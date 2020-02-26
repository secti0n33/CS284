package StacksAndQueues;

public class PalindromeChecker {
	// data fields
	private Stack<Character> s;
	private String str;
	
	// Constructor
	PalindromeChecker(String s) {
		fillStack(s);
		this.str=s;
	}
	
	private void fillStack(String s) {
		this.s=new Stack<Character>();
		for(int x=0;x<s.length();x++)
			if(s.charAt(x)!=' ')
				this.s.push(s.toLowerCase().charAt(x));
	}
	
	private String reverseString() {
		String reverse="";
		for(int x=str.length()-1;x>-1;x--)
			if(str.charAt(x)!=' ')
				reverse+=str.charAt(x);
			else
				str=str.substring(0,x)+str.substring(x+1);
		return reverse.toLowerCase();
	}
	
	public Boolean isPalindrome() {
		reverseString();
		return str.toLowerCase().compareTo(reverseString())==0;
	}
	
	public static void main(String[] args)
	{
		PalindromeChecker p=new PalindromeChecker("I saw i was i");

		System.out.println(p.isPalindrome());
	}
}
