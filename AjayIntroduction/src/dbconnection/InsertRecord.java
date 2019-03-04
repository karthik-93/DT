package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertRecord {
	static final String jdbcDriver="com.mysql.jdbc.Driver";
	static final String url="jdbc:mysql://localhost/shikhajaiswaljdbc";
	
	static final String usrname="root";
	static final String pwd="ss";
	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		int id=1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("connecting to the databse");
			conn=DriverManager.getConnection(url, usrname,pwd);
			System.out.println("connected to selected database");
			stmt=conn.createStatement();
			String sql="delete from shikharecords where name='abc'";
			stmt.executeUpdate(sql);
			System.out.println("inserted records successfullly");
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
				
			}catch(Exception e) {
				
			}
			try {
				if(conn!=null) {
					conn.close();
				}
			}
			catch(Exception e) {
				
			}
		}
		System.out.println("insertion of records done");
	}

}
