package com.attra.bank;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


public class UpdatingAccountDetails {
	//method to update Mobile Number
	public static void updatingMobileNumber() throws SQLException{
		Connection  con =null;  
		try {
		//Creating the connection  
		String user="root";
		String password="Teju@123";
		String url="jdbc:mysql://localhost:3306/bank1";
		//loading jdbc driver 
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 con =DriverManager.getConnection(url, user, password);
		
		//System.out.println("Successfully Connected to the database!");
	} catch (ClassNotFoundException e) {	 
		  System.out.println("Could not find the database driver " + e.getMessage());
		    } catch (SQLException e) {	 
		  System.out.println("Could not connect to the database " + e.getMessage());
		    }
		
		 Scanner sc=new Scanner(System.in);//scanner class object
		 AccountDetails ad=new AccountDetails();//object of  AccountDetails  to class getter setter method
		 ResultSet rs;
		 int count=0;
		 System.out.println();
		 System.out.println("Enter your Account Number ");
	do{
		if(count>0){ //to avoid 1st time exicution.
		      System.out.println(" Account doesn't exist ! Please enter valid account  number");
		      }
		  count++;
		Long acountNum=sc.nextLong();//to get input from user
		Long acc_Num=  Validation.validAccountNum(acountNum);//passing user entered input to validationAccountNum method in Validation class
		
		String sql = "select * from bank_details where AccountNumber=" +acc_Num;///To check enterd account number is present in database or not  using SQL query 
		PreparedStatement ps=con.prepareStatement(sql);
		// ps.setLong(1, ad.getAccountNumber());
		  rs=ps.executeQuery();
   }while(!(rs.next()));//to loop until  user entered account number exist in databse .
	
			

	 System.out.println("Enter your new mobile number");
	 Long mobile= sc.nextLong();
	 Long Mob=Validation.testValidMobileNum(mobile);//to validate the mobile number passing user entered mobile number to testValidMobileNum in Validation class.

	 String query = "update bank_details set Mobile = ?  where AccountNumber = ?";//update the mobile number using sql query.
	 PreparedStatement ps1=con.prepareStatement(query);

		//PreparedStatement ps=con.prepareStatement(query);
		ps1.setLong(1, Mob);
		ps1.setLong(2, rs.getLong("AccountNumber"));
		ps1.executeUpdate(); 
		
		System.out.println("database get updated");
		System.out.println();
		System.out.println("-----------------------------------------------------------");
		
		UpdatingAccountDetails.viewUpdate(rs.getLong("AccountNumber")); //to view updated details calling viewUpdate method in UpdatingAccountDetails
		
		System.out.println();

	}
		
	public static void deleteAccount() throws SQLException{
		Connection  con =null;  
		try {
		//Creating the connection  
		String user="root";	
		String password="Teju@123";
		String url="jdbc:mysql://localhost:3306/bank1";
		// //loading jdbc driver 
		Class.forName("com.mysql.cj.jdbc.Driver");
		con =DriverManager.getConnection(url, user, password);
		System.out.println("---------------------------------------------------");
		System.out.println("Successfully Connected !");
		System.out.println("---------------------------------------------------");
	} catch (ClassNotFoundException e) {
		 
		  System.out.println("Could not find the database driver " + e.getMessage());
		    } catch (SQLException e) {
		 
		  System.out.println("Could not connect to the database " + e.getMessage());
		    }
		
		Scanner sc=new Scanner(System.in);
		AccountDetails ad=new AccountDetails();
		 ResultSet rs;
		 int count=0;
		 System.out.println();
		 System.out.println("Enter your Account Number ");
		 System.out.println();
	do{
		if(count>0){
		System.out.println(" Account doesn't exist ! Please enter valid account  number");
		}
		count++;
		Long acountNum=sc.nextLong();
		Long acc_Num= Validation.validAccountNum(acountNum);
		
		String sql = "select * from bank_details where AccountNumber=" +acc_Num;
		PreparedStatement ps=con.prepareStatement(sql);
		// ps.setLong(1, ad.getAccountNumber());
		  rs=ps.executeQuery();
	}while(!(rs.next()));
	//if(rs.next()){
	String sql1 = "delete from bank_details where AccountNumber=" +rs.getLong("AccountNumber");//deleting  the account using  sql query.
	PreparedStatement ps1=con.prepareStatement(sql1);
	// ps.setLong(1, ad.getAccountNumber());
	ps1.executeUpdate(sql1);
	System.out.println("------------------------------------------------------");
	System.out.println(" You have successfully deleted your account");
	System.out.println("-------------------------------------------------------");
	}
	
	public static Double creditBalanceUpdate() throws SQLException{
		Double balance;
		Connection  con =null;  
		try {
		//Creating the connection  
		String user="root";	
		String password="Teju@123";
		String url="jdbc:mysql://localhost:3306/bank1";
		// //loading jdbc driver 
		Class.forName("com.mysql.cj.jdbc.Driver");
		con =DriverManager.getConnection(url, user, password);
		
		System.out.println("Successfully Connected to the database!");
	} catch (ClassNotFoundException e) {
		 
		  System.out.println("Could not find the database driver " + e.getMessage());
		    } catch (SQLException e) {
		 
		  System.out.println("Could not connect to the database " + e.getMessage());
		    }
		
		Scanner sc=new Scanner(System.in);
		AccountDetails ad=new AccountDetails();
		 ResultSet rs;
		 int count=0;
		 System.out.println("Enter your Account Number ");
	do{
		if(count>0){
		System.out.println(" Account doesn't exist ! Please enter valid account  number");
		}
		count++;
		Long acountNum=sc.nextLong();
		Long acc_Num=Validation.validAccountNum(acountNum);
		
		String sql = "select * from bank_details where AccountNumber=" +acc_Num;
		PreparedStatement ps=con.prepareStatement(sql);
		// ps.setLong(1, ad.getAccountNumber());
		  rs=ps.executeQuery();
	}while(!(rs.next()));
	 Double bal=rs.getDouble("Balance");
	 System.out.println("enter amount to be credit ");
	 balance=sc.nextDouble();
	 bal=bal+balance;
	 
	 String query = "update bank_details set  Balance = ?  where AccountNumber = ?";//update the mobile number using sql query.
	 PreparedStatement ps1=con.prepareStatement(query);

		//PreparedStatement ps=con.prepareStatement(query);
		ps1.setDouble(1, bal);
		ps1.setLong(2, rs.getLong("AccountNumber"));
		ps1.executeUpdate(); 
		
		System.out.println(" Updated successfully");
		System.out.println();
		System.out.println("-----------------------------------------------------------");
		
		UpdatingAccountDetails.viewUpdate(rs.getLong("AccountNumber")); //to view updated details calling viewUpdate method in UpdatingAccountDetails
		
		System.out.println();
		
		
		return balance;
	}

	public static Double debitBalanceUpdate() throws SQLException{
		Double balance;
		Connection  con =null;  
		try {
		//Creating the connection  
		String user="root";	
		String password="Teju@123";
		String url="jdbc:mysql://localhost:3306/bank1";
		// //loading jdbc driver 
		Class.forName("com.mysql.cj.jdbc.Driver");
		con =DriverManager.getConnection(url, user, password);
		
		//System.out.println("Successfully Connected to the database!");
	} catch (ClassNotFoundException e) {
		 
		  System.out.println("Could not find the database driver " + e.getMessage());
		    } catch (SQLException e) {
		 
		  System.out.println("Could not connect to the database " + e.getMessage());
		    }
		
		Scanner sc=new Scanner(System.in);
		AccountDetails ad=new AccountDetails();
		 ResultSet rs;
		 int count=0;
		 System.out.println("Enter your Account Number ");
	do{
		if(count>0){
		System.out.println(" Account doesn't exist ! Please enter valid account  number");
		}
		count++;
		Long acountNum=sc.nextLong();
		Long acc_Num=   Validation.validAccountNum(acountNum);
		
		String sql = "select * from bank_details where AccountNumber=" +acc_Num;
		PreparedStatement ps=con.prepareStatement(sql);
		// ps.setLong(1, ad.getAccountNumber());
		  rs=ps.executeQuery();
	}while(!(rs.next()));
	 Double bal=rs.getDouble("Balance");
	 System.out.println("Enter an amount to be debit ");
	 balance=sc.nextDouble();
	 bal=bal-balance;
	 
	 String query = "update bank_details set  Balance = ?  where AccountNumber = ?";//update the mobile number using sql query.
	 PreparedStatement ps1=con.prepareStatement(query);

		//PreparedStatement ps=con.prepareStatement(query);
		ps1.setDouble(1, bal);
		ps1.setLong(2, rs.getLong("AccountNumber"));
		ps1.executeUpdate(); 
		
		System.out.println("Updated successfully");
		System.out.println();
		System.out.println("----------------------------------------------------------------------");
		
		UpdatingAccountDetails.viewUpdate(rs.getLong("AccountNumber")); //to view updated details calling viewUpdate method in UpdatingAccountDetails
		
		System.out.println();
		
		
		return balance;
	}

public static void viewUpdate(Long accountNum) throws SQLException{
		
		Connection  con =null;  
		try {
		String user="root";		
		String password="Teju@123";
		String url="jdbc:mysql://localhost:3306/bank1";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		 con =DriverManager.getConnection(url, user, password);
		
		//System.out.println("Successfully Connected to the database!");
         } catch (ClassNotFoundException e) {
    	 
    	  System.out.println("Could not find the database driver " + e.getMessage());
    	    } catch (SQLException e) {
    	 
    	  System.out.println("Could not connect to the database " + e.getMessage());
    	    }
		
		Statement st = con.createStatement();
		String sql = "select * from bank_details where AccountNumber=" +accountNum; //sql query to fetch data for particular account. 
        ResultSet rs=st.executeQuery(sql);
     while(rs.next()){////STEP 5: Extract data from result set
    	 // //Retrieve by column name
    	 System.out.println("AccountType :"+ rs.getString("AccountType"));
    	 System.out.println("AccountNumber :"+ rs.getLong("AccountNumber"));
    	 System.out.println("Name :"+ rs.getString("Name"));
    	 System.out.println("Mobile :"+ rs.getLong("Mobile"));
    	 System.out.println("Balance :"+ rs.getDouble("Balance"));
    	 System.out.println("CurrencyType :"+ rs.getString("Currency"));
    	 System.out.println("------------------------------------------------------------------------------");
    	 System.out.println();
     }
}
	
}
