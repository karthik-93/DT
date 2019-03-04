package regularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample1 {
	
		
//		boolean isMatch=matcher.matches();
//		System.out.println(isMatch);
		
//		System.out.println("Number of split string: "+myString.length);
//		String content="we are learning java ";
//		String str="is";
//		Pattern pattern =Pattern.compile(str);
//		Matcher matcher=pattern.matcher(content);
//		while(matcher.find()) {
//			System.out.println("found at: "+matcher.start()+"  "+matcher.end());
//		}
		public static boolean isValidate(String d) {
		String regex="^(1[0-2]|0[1-9])/(3[01]"+"|[12][0-9]|0[1-9])/[0-9]{4}$";
		Pattern pattern =Pattern.compile(regex);
		Matcher matcher=pattern.matcher(d);
		
		return matcher.matches();
		}
		public static boolean validateEmail(String email) {
			String regex="^[A-Za-z0-9]+@+$";
			//String emailId="soumyareddy224@gmail.com";
			Pattern pattern=Pattern.compile(regex);
			Matcher matcher=pattern.matcher(email);
			
			return matcher.matches();
		}
		public static boolean validateUsername(String name) {
			String regex=
			"^(?=.*?[A-Z])(?=.*[a-z])(?=.*?[0-9])(?=.*?[#?!@$%]).{8,}";
			Pattern pattern =Pattern.compile(regex);
			Matcher matcher=pattern.matcher(name);
			return matcher.matches();
		}
		public static void main(String args[]) {
			System.out.println(isValidate("10/12/20"));
			System.out.println(isValidate("12/02/2016"));
			System.out.println(validateEmail("soumyareddy224@"));
			System.out.println(validateEmail("+reddy@gmail.com"));
			System.out.println(validateUsername("sPwmya@384"));
			System.out.println(validateUsername("sai3848"));
			System.out.println(validateUsername("leeladd"));
	}

}
