package com.sow.template2.util;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample {

  public static void main(String[] argv) {

	System.out.println("-------- JDBC Connection Testing ------------");

//	try {
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//	} catch (ClassNotFoundException e) {
//		System.out.println("Where is your ORacle JDBC Driver?");
//		e.printStackTrace();
//		return;
//	}
//	System.out.println("Oracle JDBC Driver Registered!");
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		System.out.println("MySQL Driver is Missing");
		e.printStackTrace();
		return;
	}
	System.out.println("MySQL JDBC Driver Registered!");
	
	
	
	Connection connection = null;

	try {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample?characterEncoding=utf8","root", "password");
		//connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","cms", "cms-pass");
		//connection = DriverManager.getConnection("jdbc:mysql://dotcms01.rsp.shoebuy.com:3306/cms","dotcms", "dotcms");
		//connection = DriverManager.getConnection("jdbc:oracle:thin:@odb01.qa2.rsp.shoebuy.com:7501:SHOEBUY", "app", "miAn7ekoej");
		
		//connection = DriverManager.getConnection("jdbc:oracle:thin:@//db01.prod.iad.shoebuy.com:7501/SHOEBUY", "admin", "plan3kamp2");
		
		//connection = DriverManager.getConnection("jdbc:oracle:thin:@tpcdb01.shoebuy.com:1521:SHOEBUY", "LIQUIBASE", "Liquibase1");
		
		//connection = DriverManager.getConnection("jdbc:mysql://dotcms01.qa2.rsp.shoebuy.com:3306/cms","dotcms", "cms");
		//connection = DriverManager.getConnection("jdbc:mysql://cmsdb01:3306/cms","dotcms", "cms");

		
	} catch (SQLException e) {
		System.out.println("Connection Failed! Check output console");
		e.printStackTrace();
		return;
	}

	if (connection != null) {
		System.out.println("You made it, take control your database now!");
	} else {
		System.out.println("Failed to make connection!");
	}
	
	
	readDataFromDB(connection);
	
	writeDataToDB(connection);
	
  }
  
  public static void readDataFromDB(Connection connection) {
	  Statement statement = null;
	try {
		statement = connection.createStatement();
		ResultSet resultSet = statement
	              .executeQuery("select * from sample.employee");
		
		while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            long empId = resultSet.getLong("emp_id");
            String empName = resultSet.getString("emp_name");
            double salary = resultSet.getDouble("salary");
            String city = resultSet.getString("city");
            long deptId = resultSet.getLong("dept_id");
            
            System.out.println("\nId: " + empId);
            System.out.println("Name: " + empName);
            System.out.println("Salary: " + salary);
            System.out.println("City: " + city);
            System.out.println("DeptId: " + deptId);
            
            System.out.println("\n");
        }
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			statement.close();
		} catch (SQLException e) {
			//e.printStackTrace();
		}
	}
  }
	
	public static void writeDataToDB(Connection connection) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection
			        .prepareStatement("insert into  sample.employee values (?, ?, ?, ?, ?)");
			
			    preparedStatement.setLong(1, 6);
		        preparedStatement.setString(2, "Dimpy");
		        preparedStatement.setLong(3, 7000l);
		        preparedStatement.setString(4, "Atlanta");
		        preparedStatement.setLong(5, 100);
		        preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				//e.printStackTrace();
			}
		}
	}

  
}