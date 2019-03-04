package dbconnection;

import java.sql.*;
import java.util.*;


public class JDBCStoredProcedureWrite {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost/ajaydb";
		String user="root";
		String pass="ss";
		Connection con = null;
		CallableStatement stmt = null;
		
		//Read User Inputs
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the details ");
		String name=sc.next();
		String passwd =sc.next();
		
		
		try{
			Class.forName("com.mysql.jdbc.Driver");//this is to register the driver
			System.out.println("connecting to the databse");
			con=DriverManager.getConnection(url, user,pass);//creating a connection
			System.out.println("creating database");
			stmt = con.prepareCall("{call insertStudentsInfo('ajay','ajay@123')}");
			//String str=insert into students values('"+name+"',
//			stmt.setString(1, name);
//			
//			stmt.setString(2, passwd);
			//register the OUT parameter before calling the stored procedure
			//stmt.registerOutParameter(6, java.sql.Types.VARCHAR);
			
			stmt.executeUpdate();
			
			//read the OUT parameter now
			//String result = stmt.getString(6);
			
			//System.out.println("Employee Record Save Success::"+result);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				stmt.close();
				con.close();
				sc.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}