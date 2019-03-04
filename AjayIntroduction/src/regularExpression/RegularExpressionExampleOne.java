package regularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionExampleOne {
	public static void main(String[] args) {
		String ptrn=".*sowmya.*";
		String str=" from  sowmya niit ecity";
//		Pattern pan=Pattern.compile(ptrn);
//		Matcher matcher=pan.matcher(str);
		 //boolean res =Pattern.matches(ptrn,str);//one way to 
		Matcher matcher =Pattern.compile(ptrn).matcher(str);
		boolean res=matcher.matches();
		System.out.println(res);
		
	}

}
