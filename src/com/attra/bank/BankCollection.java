package com.attra.bank;
import java.util.*;
import java.sql.*;
public class BankCollection {
	public static ArrayList<AccountDetails> getAllDetails() {
	    ArrayList<AccountDetails> BankDetails = new ArrayList<AccountDetails>();//craeting object
	    Connection  con =null;  

	    try {
	    	////Creating the connection  
	    	String user="root";		
			String password="Teju@123";
			String url="jdbc:mysql://localhost:3306/bank1";
			 //loading jdbc driver 
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			 con =DriverManager.getConnection(url, user, password);
	    	String sql = "SELECT * from bank_Details";
	       
	        Statement st = con.createStatement();

	        ResultSet rs=st.executeQuery(sql);
	        while (rs.next()) {
	        	AccountDetails   Account = new AccountDetails();//create new object everytime

	        	 Account.setAccountType(rs.getString("AccountType"));
	        	 Account.setAccountNumber(rs.getLong("AccountNumber"));
	        	 Account.setName(rs.getString("Name"));	
	        	 Account.setBalance(rs.getDouble("Balance"));
	        	 Account.setMobile(rs.getLong("Mobile"));
	        	 Account.setCurrency(rs.getString("Currency"));
	            

				BankDetails.add( Account);//adding  object to arraylist

	        }

	    } catch (Exception e) {
	        System.out.println("getAllDocters()");
	        e.printStackTrace();
	    }

	    return (BankDetails);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BankCollection bd = new BankCollection();
		    ArrayList<AccountDetails> details = bd. getAllDetails();//calling getAlldetails method 
		  //  String s[] = null;
		    for (int i = 0; i < details.size(); i++) {//retrive the data from arraylist

		        System.out.println(details.get(i).getAccountType());
		        System.out.println(details.get(i).getAccountNumber());
		        System.out.println(details.get(i).getName());
		        System.out.println(details.get(i).getBalance());
		        System.out.println(details.get(i).getMobile());
		        System.out.println(details.get(i).getCurrency());
		        System.out.println();
		        System.out.println("----------------------------------------");
		        System.out.println();
		        
		    }

		

	}

}
