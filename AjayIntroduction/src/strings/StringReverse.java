package strings;

import java.util.Scanner;

public class StringReverse {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		String rev="";
		for(int i=str.length()-1;i>=0;i--) {
			rev=rev+str.charAt(i);
			
		}
		
		System.out.println("reverse of string is "+rev);
		
		
		
	}

}
