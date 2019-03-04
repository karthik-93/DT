package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectRecords {
	static final String jdbcDriver="com.mysql.jdbc.Driver";
	static final String url="jdbc:mysql://localhost/ajaydb";
	
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
			stmt=conn.createStatement();
			//String sql="update students set sname='sowmya' where sname='abc'"; 
			//String sql="delete from students where sname='praneeth'";
			//stmt.execute(sql);
			//System.out.println("deleted succeefully");
			String str="select *from students";
			ResultSet rs=stmt.executeQuery(str);
			while(rs.next()) {
				
				
				
				System.out.println("id is : "+rs.getString(1));
				System.out.println("Name is "+rs.getString(2));
				//System.out.println("password is : "+spwd);
			}
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
	}

}
