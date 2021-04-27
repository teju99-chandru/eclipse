package com.attra.bank;
import java.sql.SQLException;
import java.util.*;
public class BankOperation {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		
		boolean quit = false;
		do{
			System.out.println("=====================MOCK BANK APPPLICATION========================");
			System.out.println();
			System.out.println("Please select the option:");
			System.out.println("Y: For creating a new Account");
			System.out.println("E: Update the details for an Existing account");
			System.out.println("V: View the Account details");
			System.out.println("D: Delete an account");
			System.out.println("N: Close this Screen");
			System.out.println();
			System.out.println("====================================================================");
			
			
			
			String choice =s.next();
			//// Outer Switch for bank operation
		switch(choice.toUpperCase()){
		//if choice==Y
		
		case "Y" :System.out.println();
		          System.out.println("---------------------------------------------------------------------------");
		          System.out.println();
			      System.out.println("Enter the type of account:");
		          System.out.println("1.SAVINGS");
		          System.out.println("2.Current");
		          System.out.println();
		          System.out.println("---------------------------------------------------------------------------");
		       
		          int select=s.nextInt();
		         
		        	  // Nested Switch  for create account
		          switch(select){
		          //IF Choice==1 CALL the method  createAccount from CreateAccount class 
		          case 1:CreateAccount.createAccount();         
		          break;
		        //IF Choice==2 CALL the method  createAccount from CreateAccount class 
		          case 2:CreateAccount.createAccount();	          
		          break;
		       
		         
			    
			      default:System.out.println("-------------------------------------------------------------");
			    	  System.out.println("Please enter the valid input");
			    	  System.out.println("----------------------------------------------------------------");
		          }
		
		      
		
		break;
		
		//if choice==Y
		case "E":System.out.println();
                 System.out.println("---------------------------------------------------------------------------");
                 System.out.println();
			      System.out.println("choose what you want to undate");
		          System.out.println("1.To Update Mobile Number");
		          System.out.println("2.To delete account");
		          System.out.println("3.To credit amount");
		          System.out.println("4.To debit amount");
		          System.out.println();
		          System.out.println("---------------------------------------------------------------------------");
		          
		         
		          int select1=s.nextInt();	          
		          switch(select1){
		          case 1:UpdatingAccountDetails.updatingMobileNumber();
		          break;
		          case 2:UpdatingAccountDetails.deleteAccount();
		          break;
		          case 3:UpdatingAccountDetails.creditBalanceUpdate();
		          break;
		          case 4:UpdatingAccountDetails.debitBalanceUpdate();
		          break;
		     
		          
		          default: System.out.println("-------------------------------------------------------------");
		    	  System.out.println("Please enter the valid input");
		    	  System.out.println("----------------------------------------------------------------");
		          } 
		        
		break;
		
		//if choice==V  class the methd viewBankDetails from ViewDetails
		case "V":    ViewDetails.viewBankDetails();
        	
		break;
        
		//if choice==Y class the methd deleteAccount from  UpdatingAccountDetails
		case"D":UpdatingAccountDetails.deleteAccount();
		break;
		
		//if choice==Y return outer loop
		 case "N":System.out.println("****************************THANK YOU***************************************");
		      quit = true;
		      break;
		      
		 default:System.out.println("-------------------------------------------------------------");
   	  System.out.println("Please enter the valid input");
   	  System.out.println("----------------------------------------------------------------");
		      
		}
	
		}while(!quit);
	
		//to retrive data from arraylist
		System.out.println(" ArrayList data:");
		BankCollection bd = new BankCollection(); //object of BankCollection class  to class method getAllDetails
	    ArrayList<AccountDetails> details = bd. getAllDetails();
	   
	    for (int i = 0; i < details.size(); i++) {//for loop to retrive all data .

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
