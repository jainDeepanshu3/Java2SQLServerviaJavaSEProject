package com.deepanshu.sql;

import java.sql.CallableStatement;
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
			/*
			 * String fetch = "SELECT * FROM student_details"; Statement st=
			 * con.createStatement(); ResultSet result= st.executeQuery(fetch);
			 */
			
			/*
			 * int count=0; while(result.next()) { count++; String name=
			 * result.getString("name"); int mark= result.getInt("mark");
			 * System.out.printf("Student details %d %s - %d\n",count,name,mark); }
			 */
			
			
			/*Calling Strore Procedure with Select Query, In parameter, Out Parameter
			 * INOUT Parameter
			 * */
			//CallableStatement callstmt=null;
			//callstmt=con.prepareCall("{call GetAllStudentDetails}");
			 
			/*
			 * int count=0; if(callstmt.execute()) { ResultSet result=
			 * callstmt.getResultSet(); count++; while(result.next()) { String name=
			 * result.getString("name"); int mark= result.getInt("mark");
			 * 
			 * System.out.printf("Student details %d %s - %d\n",count,name,mark); } }
			 */
			
			/*
			 * Store procedure call with IN parameter
			 * */
			/*
			 * CallableStatement callstmt1=null;
			 * callstmt1=con.prepareCall("{call sp_GetSpecificStudentDetail(?)}");
			 * callstmt1.setString(1, "DEEPANSHU"); int count1=0; if(callstmt1.execute()) {
			 * ResultSet result= callstmt1.getResultSet(); count1++; while(result.next()) {
			 * String name= result.getString("name"); int mark= result.getInt("mark");
			 * 
			 * System.out.printf("Specific Student details %d %s - %d\n",count,name,mark); }
			 * }
			 */
			
			
			/*
			 * Below one is IN and OUTPUT parameter store procedure in SQL Server 
			 * called via java
			 * */
			CallableStatement callstmt2=null;
			callstmt2=con.prepareCall("{call sp_GetSpecificStudentDetail(?,?)}");
			callstmt2.setString(1, "MOHAN");
			callstmt2.registerOutParameter(2, java.sql.Types.INTEGER);
			callstmt2.execute();
			int mark= callstmt2.getInt(2);
			System.out.printf("Specific Student marks are %d",mark);
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Ooops Connection Failed");
		}
		

	}

}
