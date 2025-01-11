package org.test2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class JDBC {

	public static void main(String[] args) throws SQLException {
		
		//How to start the sql connection
		String db = "jdbc:mysql://localhost:3306";
		String user ="root";
		String pw= "root";
		
		Connection connection = DriverManager.getConnection(db,user,pw);
		
		
		if(connection == null) {
			System.out.println("JDBC not connected ");
		}
		else {
			System.out.println("JDBC connected");
		}
		
		//Create statement
		Statement stmt = connection.createStatement();
		
		//create database
		String createDatabase = "create database db_sample"; //db name
		String useDB = "use db_sample"; 
		String createTable = "create table Emp_class (Empid int, Empname varchar(20),EmpSalary int)"; //with the help of useDB im ready to create table name
		String insert = "insert into Emp_class values (123,'Vignesh',25000),(456,'Dilip',53000),(789,'Abishek',30000)";
		String select = "Select *from Emp_class where Empname ='Abishek'";
		
		//Executing the statement
		stmt.execute(createDatabase);
		stmt.execute(useDB);
		stmt.execute(createTable);
		stmt.execute(insert);
		
		//Retrive the data from database
		
		ResultSet rs = stmt.executeQuery(select);
		
		
		//iterating the result
		
	    while(rs.next()) {
	    	
	    	System.out.println(rs.getInt("Empid")+ " " +rs.getString("Empname")+ " "+rs.getInt("EmpSalary"));
	    	
	    }
	    
	    //close the connection
	    connection.close();
	   
	}

}
