package org.test2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Task1 {

	public static void main(String[] args) throws SQLException {
		
		String db ="jdbc:mysql://localhost:3306/sample";
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
		
		String CreateDatabase = "create database db_new16";
		String useDB = "use db_new16";
		String CreateTable = "Create table Empl (empno int ,ename varchar(20),job varchar(10),mgr int ,hiredate DATE,sal int,comm int ,deptno int)";
		String insert = "insert into Empl values "
				+ "(8369,'Smith','CLERK',8902,'1990-12-18',800,NULL,20),"
				+ "(8499,'Anya','SALESMAN',8698,'1991-02-20',1600,300,30),"
				+ "(8521,'Seth','SALESMAN',8698,'1991-02-22',1250,500,30),"
				+ "(8566,'Mahadevan','MANAGER',8839,'1991-04-02',2985,NULL,20),"
				+ "(8564,'Momin','SALESMAN',8698,'1991-09-28',1250,1400,30),"
				+ "(8698,'Bina','MANAGER',8839,'1991-05-01',2850,NULL,30),"
				+ "(8882,'Shivansh','MANAGER',8839,'1991-06-09',2450,NULL,10),"
				+ "(8888,'Scott','ANALYST',8566,'1991-12-09',3000,NULL,20),"
				+ "(8839,'Amir','PRESIDENT',NULL,'1991-11-18',5000,NULL,10),"
				+ "(8844,'Kuldeep','SALESMAN',8698,'1991-09-08',1500,0,30)";
		
		
		stmt.execute(CreateDatabase);
		stmt.execute(useDB);
		stmt.execute(CreateTable);
		stmt.execute(insert);
		
		String select = "select * from Empl";
		stmt.execute(select);
	
		ResultSet rs = stmt.executeQuery(select);
		
		while(rs.next()) {
			System.out.println(rs.getInt("empno") +" "+rs.getString("ename")+ " "+rs.getString("job")+" "+rs.getInt("mgr")+" "+rs.getDate("hiredate")+" "+rs.getInt("sal")+" "+rs.getInt("comm")+" "+rs.getInt("deptno"));
		}
		
		connection.close();
		
	}
}
