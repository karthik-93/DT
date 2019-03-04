package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectDatabase {
	static final String jdbcDriver="com.mysql.jdbc.Driver";
	static final String url="jdbc:mysql://localhost/shikhajaiswaljdbc";
	
	static final String usrname="root";
	static final String pwd="ss";
	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("connecting to the databse");
			conn=DriverManager.getConnection(url, usrname,pwd);
			System.out.println("connected to selected database");
			
		}
		catch(SQLException se) {
			se.printStackTrace();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(stmt!=null) {
					stmt.close();
				}
			}catch(SQLException se1) {
				
			}
			try {
				if(conn!=null) {
					conn.close();
				}
			}
			catch(SQLException se2) {
				se2.printStackTrace();
			}
			
		}
		System.out.println("database example done");
	}
}

