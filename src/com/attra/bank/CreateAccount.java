package com.attra.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CreateAccount {
	
public static void createAccount() throws SQLException{
	Connection  con =null;  
		try {
		//Creating the connection  
		String user="root";
		String password="Teju@123";
		String url="jdbc:mysql://localhost:3306/bank1";
		//loading jdbc driver 
		Class.forName("com.mysql.cj.jdbc.Driver");
		 con =DriverManager.getConnection(url, user, password);
		System.out.println("------------------------------------------------");
		System.out.println("Successfully Connected!");
		System.out.println("-----------------------------------------------");
    } catch (ClassNotFoundException e) {
    	 
    	  System.out.println("Could not find the database driver " + e.getMessage());
    	    } catch (SQLException e) {
    	 
    	  System.out.println("Could not connect to the database " + e.getMessage());
    	    }

		Scanner sc=new Scanner(System.in);
		AccountDetails ad=new AccountDetails();
		
		System.out.print("Enter account type:");
		String type=sc.nextLine();
		ad.setAccountType(type);
	//	ad.setAccountType(Validation.testValidName(type));//to validate user input should be character, passing user input to testValidnName method in Validation class
		
		System.out.print("Enter 16-digit account number: ");
		
        ad.setAccountNumber(Validation.validAccountNumDb()) ;///to validate user input is already present in database or not and input should conatain 10 digits calling validAccountNumDb in Valdation class
		
		System.out.print("Enter the Account Holder Full Name: ");
		String name=sc.nextLine();
		ad.setName(Validation.testValidName(name));//validate user input  should contain character only,here it  call the testValidName method present in Validation class

	
		System.out.print("Enter your balance");
        ad.setBalance(sc.nextDouble());

		System.out.print("Enter your 10  digit  mobile number");
		Long mobile=sc.nextLong();	
     	ad.setMobile(Validation.testValidMobileNum(mobile));
     	
		 System.out.print("Enter the Currency type: ");
		ad.setCurrency(sc.next());
		
		 
		String sql="insert into bank_details values(?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setString(1, ad.getAccountType());
		ps.setLong(2,ad.getAccountNumber());
		ps.setString(3, ad.getName());
		ps.setDouble(4,ad.getBalance());
		ps.setLong(5, ad.getMobile());
		ps.setString(6,ad.getCurrency());
		ps.executeUpdate(); 
		
		System.out.println();
		System.out.println("-----------------------------------------------------------");
		System.out.println("Account created successfully");
		System.out.println("-----------------------------------------------------------");
			
		String sql2 = "select * from bank_details where AccountNumber=" +ad.getAccountNumber();//sql query to fetch data for particular account. 

			
		PreparedStatement ps3=con.prepareStatement(sql2);
		
		 ResultSet rs3=ps3.executeQuery();
		 while(rs3.next()){//STEP 5: Extract data from result set
			  //Retrieve by column name
			 System.out.println();
		 System.out.println("AccountType :"+ rs3.getString("AccountType"));
 	 System.out.println("AccountNumber :"+ rs3.getLong("AccountNumber"));
 	 System.out.println("Name :"+ rs3.getString("Name"));
 	 System.out.println("Mobile :"+ rs3.getLong("Mobile"));
 	 System.out.println("Balance :"+ rs3.getDouble("Balance"));
 	 System.out.println("CurrencyType :"+ rs3.getString("Currency"));
 	 System.out.println("------------------------------------------------------------------------------");
		 }
		 
	}
public static void main(String argc[]) throws SQLException{
	createAccount();
}

}
