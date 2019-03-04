package regularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex1 {
	public static void main(String[] args) {
		System.out.println(Pattern.matches("[a-z]","s"));
		System.out.println(Pattern.matches("[a-z0-9]{5,}","sowmyareddy6876"));
		System.out.println(Pattern.matches("[a-zA-Z+,]",","));
		System.out.println(Pattern.matches("\\D", "*"));
		System.out.println(Pattern.matches("[7]{1}[8]{1}[9]{1}[0-9]{7}","7891008182"));
		Pattern pattern =Pattern.compile("geeks");
		Matcher m=pattern.matcher("geeksforgeeks.orggeeks");
		while(m.find()) {
			System.out.println("pattern found from "+m.start()+"to "+(m.end()-1));
		}
		Pattern ptrn=Pattern.compile(".*ge");
		Matcher matcher=ptrn.matcher("geeksforgeeks");
		while(matcher.find()) {
			System.out.println("Pattern1 found from "+matcher.start()+"to "+(matcher.end()-1));
		}
		String content="This is sowmya";
		String ptrn2="is";
		//boolean isMatch=Pattern.matches(pattern,content);
		Pattern ptten=Pattern.compile(ptrn2);
Matcher match=ptten.matcher(content);
		String[] myString=ptten.split(content);
		for(String temp:myString) {
			System.out.println(temp);
		}
	}

}
