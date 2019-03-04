package stringsjanani;

public class StringsExample {
	public static void main(String[] args) {
		String s1="sowmya";//
		String s2="sowmya";//for the s1 and s2 object is same
		
		String str1=new String("sowmya");//one object 
		String str2=new String("JANANI");//another object
		System.out.println(s1.equals(s2));//will check the content
		System.out.println(s1==s2);//== will check the object
		System.out.println(str1.equals(str2));
		System.out.println(str1==str2);
		System.out.println(str1.charAt(2));
		System.out.println(str1.substring(2, 5));
		System.out.println(str1.substring(2));
		String str3=str1.concat(str2);
		str1=str1.concat(str2);
		
		System.out.println(str1+" "+str3+" "+str1.equals(str3));
		System.out.println(str1.endsWith("JANANI"));
		
	}

}
