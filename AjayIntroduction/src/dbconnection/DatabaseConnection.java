package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;



public class DatabaseConnection {
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost/ajaydb";
		String user="root";
		String pass="ss";
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter the name");
		String name=sc.next();
		System.out.println("enter the password");
		String pwd=sc.next();
		
		String sql = "insert into students(sname,pwd) values('"+name+"','"+pwd+"')";
	        Connection con=null;
	        try
	        {
	            DriverManager.registerDriver(new com.mysql.jdbc.Driver() );
	 
	            //Reference to connection interface
	            con = DriverManager.getConnection(url,user,pass);
	 
	            Statement st = (Statement) con.createStatement();
	            int m = st.executeUpdate(sql);
	            System.out.println("m value is"+m);
	            if (m == 1)
	                System.out.println("inserted successfully : "+sql);
	            else
	                System.out.println("insertion failed");
	            con.close();
	        }
	        catch(Exception ex)
	        {
	            System.err.println(ex);
	        }
	    }
	
	}

