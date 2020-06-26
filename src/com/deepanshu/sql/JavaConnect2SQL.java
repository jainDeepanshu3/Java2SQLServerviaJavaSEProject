package com.deepanshu.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JavaConnect2SQL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:sqlserver://DEEPANSHU_ADMIN;databaseName=students";
		String username = "sa";
		String password= "root";
		
		try {
			Connection con= DriverManager.getConnection(url, username, password);
			System.out.println("Connection to DB was successfull");
			
			/*
			 * String query= "INSERT INTO student_details (name, mark)"+
			 * "VALUES ('AMIT',96)";
			 * 
			 * Statement st= con.createStatement();
			 * int rownumber= st.executeUpdate(query);
			 */
			
			/*============ ==================*/
			
			/*Via Prepared statement as well*/
			/*
			 * String query= "INSERT INTO student_details (name, mark)"+"VALUES (?,?)";
			 * 
			 * PreparedStatement prstmt = con.prepareStatement(query);
			 * 
			 * prstmt.setString(1, "MOHAN"); prstmt.setInt(2, 89);
			 * 
			 * 
			 * int rownumber= prstmt.executeUpdate();
			 * 
			 * if(rownumber >0) { System.out.println("Row Inserted successfully"); }
			 */
			/*================ =================*/
			
			
			/*fetch results from database and iterate results*/
			String fetch = "SELECT * FROM student_details";
			Statement st= con.createStatement();
			ResultSet  result=  st.executeQuery(fetch);
			
			int count=0;
			while(result.next()) {
				count++;
				String name= result.getString("name");
				int mark= result.getInt("mark");
				System.out.printf("Student details %d %s - %d\n",count,name,mark);
			}
			
			
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Ooops Connection Failed");
		}
		

	}

}
