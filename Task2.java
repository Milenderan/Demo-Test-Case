package org.test2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Task2 {
	
	public static void main(String[] args) throws SQLException {
		
		 	String db= "jdbc:mysql://localhost:3306";
		 	String uname = "root";
		 	String pw = "root";
		 	
		 	Connection connection = DriverManager.getConnection(db,uname,pw);
		 	
		 	
		 	if(connection == null) {
				System.out.println("JDBC not connected ");
			}
			else {
				System.out.println("JDBC connected");
			}
			
			Statement stmt = connection.createStatement();
			
			String CreateDatabase = "Create database db_offic";
			String UseDB = "use db_offic";
			String CreateTable ="create table offic(empcode int,empname varchar(20),empage int,esalary int)";
			String insert = "insert into offic values(101,'Jenny',25,10000),"
					+ "(102,'Jacky',30,20000),"
					+ "(103,'Joe',20,40000),"
					+ "(104,'John',40,80000),"
					+ "(105,'Shameer',25,90000)";
			
			stmt.execute(CreateDatabase);
			stmt.execute(UseDB);
			stmt.execute(CreateTable);
			stmt.execute(insert);
			
			String select = "select * from offic";
			
			ResultSet rs = stmt.executeQuery(select);
			
			while(rs.next()) {
				System.out.println(rs.getInt("empcode") +" "+rs.getString("empname")+" "+rs.getString("empage")+" "+rs.getInt("esalary"));
			}
			
			connection.close();

	}

	
}
