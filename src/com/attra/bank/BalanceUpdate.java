package com.attra.bank;
import java.sql.*;
import java.util.Scanner;
public class BalanceUpdate {
public static void creditAmount() throws SQLException{
	Connection  con =null;  
	try {
	String user="root";
	
	String password="Teju@123";
	String url="jdbc:mysql://localhost:3306/bank";
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	 con =DriverManager.getConnection(url, user, password);
	
	System.out.println("Successfully Connected to the database!");
} catch (ClassNotFoundException e) {
	 
	  System.out.println("Could not find the database driver " + e.getMessage());
	    } catch (SQLException e) {
	 
	  System.out.println("Could not connect to the database " + e.getMessage());
	    }
	
	
	
	Scanner sc=new Scanner(System.in);

	System.out.println("enter your account number");
        Long accountNum = sc.nextLong();
	System.out.println("enter your creatid amount");
	Double amount=sc.nextDouble();
	

	 String preBalance = "select Balance  from account_details  where AccountNumber = ?";
	 PreparedStatement ps=con.prepareStatement(preBalance);
		ps.setLong(1,accountNum);
		ResultSet results= ps.executeQuery(preBalance);
		

		 String query = "update account_details set Balance = ?  where AccountNumber = ?";
		PreparedStatement ps1=con.prepareStatement(query);
		//ps1.setDouble(1,(amount+(results);
		ps1.setLong(2,accountNum);
		ps.executeUpdate(); 
		
		System.out.println("database get updated");
	 
	
}
	public static void main(String[] args) throws SQLException {
		System.out.println("feature branch");
		// TODO Auto-generated method stub
		creditAmount();

	}

}
