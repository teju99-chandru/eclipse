package com.attra.bank;
import java.sql.*;
import java.util.Scanner;
public class ViewDetails {
public static void viewBankDetails() throws SQLException{
	Connection  con =null;  
	try {
	String user="root";
	
	String password="Teju@123";
	String url="jdbc:mysql://localhost:3306/bank1";
	
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
do{
	System.out.println("enter account number");
	Long acountNum=sc.nextLong();
	Long acc_Num=   Validation.validAccountNum(acountNum);
	
	String sql = "select * from bank_details where AccountNumber=" +acc_Num;
	PreparedStatement ps=con.prepareStatement(sql);
	// ps.setLong(1, ad.getAccountNumber());
	  rs=ps.executeQuery();
}while(!(rs.next()));
//if(rs.next()){
		
			 System.out.println();
			 System.out.println("------------------------------------------------------------------------------");
		 System.out.println("AccountType :"+ rs.getString("AccountType"));
 	 System.out.println("AccountNumber :"+ rs.getLong("AccountNumber"));
 	 System.out.println("Name :"+ rs.getString("Name"));
 	 System.out.println("Mobile :"+ rs.getLong("Mobile"));
 	 System.out.println("Balance :"+ rs.getDouble("Balance"));
 	 System.out.println("CurrencyType :"+ rs.getString("Currency"));
 	 System.out.println("------------------------------------------------------------------------------");
 	 System.out.println();
	//	ps.executeUpdate(); 
}

//}
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
	//	viewBankDetails();

	}

}
