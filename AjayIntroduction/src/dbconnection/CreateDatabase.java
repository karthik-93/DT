package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

class Students{
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}

public class CreateDatabase {
	static final String jdbcDriver="com.mysql.jdbc.Driver";
	static final String url="jdbc:mysql://localhost/ajaydb";
	//jdbc:h2:tcp://localhost/~/karthikdb
	
	static final String usrname="root";
	static final String pwd="ss";
	public static void main(String[] args) {
		Students st=new Students();
		
		System.out.println("enter username and pasword");
		Scanner sc=new Scanner(System.in);
		String username=sc.next();
		String password=sc.next();
		st.setPassword(password);
		st.setUsername(username);
		
		Connection conn=null;
		Statement stmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");//this is to register the driver
			System.out.println("connecting to the databse");
			conn=DriverManager.getConnection(url, usrname,pwd);//creating a connection
			System.out.println("creating database");
			stmt=conn.createStatement();
			//String sql="create table ajaydb.students(sid int primary key auto_increment,sname varchar(255),pwd varchar(255))";
			String sql="insert into students(sname,pwd) values(s,password)";
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
