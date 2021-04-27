package com.attra.bank;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Validation {
	
	//method to valid name
	public static boolean  validName(String name){
	/*by using pattern matching
	 * Pattern class contains matcher() method 
	 *it return the name if it contains only character.
	 */
		return Pattern.matches("[a-zA-z]+",name);
	}
	
	//method to validate name, it call the validName method  until user enter valid name
	public static String testValidName(String name){
		Scanner sc=new Scanner(System.in);
		AccountDetails ad=new AccountDetails();
	
	    while(! validName(name)){
	    	if(!validName(name)){
	    		//System.out.print("The C  you entered is invalid!");          
	    		System.out.println("Enter the Account Holder Full Name: ");
                name = sc.nextLine();               
	    	}
	    } 
	    return name;
	}
	
	
	public static Long validAccountNum(Long num){
		Scanner sc=new Scanner(System.in);
		AccountDetails ad=new AccountDetails();	
	
		String ac = String.valueOf(num);
	    while(ac.length() != 10) //until user entered input contain 10 digits it loop.
	    {
	        if(ac.length() != 10)
	        {
	            System.out.print("The Account number  you entered is invalid!");       
	                    System.out.print("Enter the Account number(Must be 16 digits): ");
	                    num = sc.nextLong(); 
	                    ac = String.valueOf(num);
	          }
	        
	    }
	    return num;
	}
	
	
	public static Long validAccountNumDb() throws SQLException{
		Connection  con =null;  
		try {
		String user="root";	
		String password="Teju@123";
		String url="jdbc:mysql://localhost:3306/bank1";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		 con =DriverManager.getConnection(url, user, password);
		
	//	System.out.println("Successfully Connected to the database!");
	} catch (ClassNotFoundException e) {
		 
		  System.out.println("Could not find the database driver " + e.getMessage());
		    } catch (SQLException e) {
		 
		  System.out.println("Could not connect to the database " + e.getMessage());
		    }
		
		Scanner sc=new Scanner(System.in);
		AccountDetails ad=new AccountDetails();
		 ResultSet rs;
		 Long acc_Num = null;
		 int count=0;
		 //System.out.println("enter account number");
	do{
		if(count>0){
		System.out.println("Already exists. Please try a different  account number");}
		count++;
		Long acountNum=sc.nextLong();
		 acc_Num=  Validation.validAccountNum(acountNum);//changes
		
		String sql = "select * from bank_details where AccountNumber=" +acc_Num;
		PreparedStatement ps=con.prepareStatement(sql);
		// ps.setLong(1, ad.getAccountNumber());
		  rs=ps.executeQuery();
	}

	while(rs.next());//untile user entered account number is not present in the database it will loop
	return acc_Num;

	}
	
	//method to check user entered phone number is valid or not 
	public static boolean validMobileNum(Long Mobile){
		Scanner sc=new Scanner(System.in);
		AccountDetails ad=new AccountDetails();
		String ac = String.valueOf(Mobile);
		Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}"); 
		  
	    // Pattern class contains matcher() method 
	    // to find matching between given number  
	    // and regular expression 
	    Matcher m = p.matcher(ac); 
	    return (m.find() && m.group().equals(ac)); 
		
	}
	
	
	//method to loop untile user entered valid mobile number
	public static Long testValidMobileNum(Long Mobile){
		Scanner sc=new Scanner(System.in);
		AccountDetails ad=new AccountDetails();	
		String ac = String.valueOf(Mobile);
	    while(! validMobileNum(Mobile)){
	    	if(!validMobileNum(Mobile)){
	    		System.out.print("The Contact number  you entered is invalid!");
                System.out.print("Enter the valid Contact number ");
                Mobile = sc.nextLong(); 
                ac = String.valueOf(Mobile);
	    	}
	    }
	  
	    return Mobile; 
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		//Long num=s.nextLong();
		//Long Mobile=s.nextLong();
		//String name=s.nextLine();
		//System.out.println(testValidName(name));
	//Double	Balance=s.nextDouble();
		//Double num = s.nextDouble(); 
		//System.out.println(testValidMobileNum(Mobile));
	
	}
}
