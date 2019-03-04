package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DropDatabase {
	static final String jdbcDriver="com.mysql.jdbc.Driver";
	static final String url="jdbc:mysql://localhost/";
	
	static final String usrname="root";
	static final String pwd="ss";
	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("connecting to the databse");
			conn=DriverManager.getConnection(url, usrname,pwd);
			System.out.println("creating database");
			stmt=conn.createStatement();
			String sql="drop database students";
			stmt.executeUpdate(sql);
			System.out.println("database created successfully");
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

