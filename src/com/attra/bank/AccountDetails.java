package com.attra.bank;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.mysql.cj.xdevapi.Statement;
public class AccountDetails {
	// // Member variables of the class.
	private String accountType;
	private Long accountNumber;
	private String name;
	private Long mobile;
	private Double balance;
	private String currency;
	
	
	//getter and setter method to set and get values to the variables of the class
	
	public void setAccountType(String accountType){
		this.accountType= accountType;		
	}
	public String getAccountType(){
		return accountType;
	}
	
	public void setAccountNumber(Long accountNumber){
	this.accountNumber= accountNumber;
	}
	public Long getAccountNumber(){
		return accountNumber;
	}
	
	public void setName(String name){
		this.name= name;
	}
	public String getName(){
		return name;
	}
	
	public void setBalance(double  balance){
		this. balance= balance;
	}
	public double getBalance(){
		return  balance;
	}
	
	public void setMobile(Long mobile){
		this.mobile= mobile;
	}
	public Long getMobile(){
		return mobile;
	}
	
	public void setCurrency(String currency){
		this.currency= currency;
	}
	public String getCurrency(){
		return currency;
	}
	
}
