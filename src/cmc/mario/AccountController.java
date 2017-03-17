package cmc.mario;
/*
 * File: AccountController.java
 */
import java.io.*;
/**
 * AccountController - Controller to control account functionality.
 * 
 * @authors Mario Party 4 - Kalila Moua
 * @version 2/24/17
 */
public class AccountController {
	/**
	   * Account object for acct controller to communicate to
	   */
	  public Account acct;
	  /**
	   * DBController object for acc controller to search data
	   */
	  public DBController database;
	  //true if user is logged on
	  public boolean isLoggedOn;
	  //username of user
	  //public String username;
	  //password of user
	 // private String password;
	  
	  /*
	   * default constructor
	   */
	  public AccountController(Account acct){
		this.acct = acc;
//	    this.username=acct.getUsername();
//	    this.password=acct.getPassword();
//	    this.isLoggedOn = true;
		this.database = new DBController();
	  }
	  
	  /*
	   * second constructor which sets username and password for object
	   */
	//  public AccountController(String username, String password){
//	    this.username=username;
//	    this.password=password;
//	    this.isLoggedOn = true;
	//  }
	//  
	  /**
	   * This method is to test if the user is logged off or not. //update in class diagram
	   * @return true if user is logged off, false otherwise
	   */ 
	  public boolean logOff(){
		if (acct.isActive==false){
			return true;
	    }
		return false;
	  }
	  
	  /**
	   * This method is to logon to the cmc system.
	   * @param username the username the user puts in
	   * @param password the password the user enters in
	   * @return true if the user is logged on and authentication is confirmed, otherwise return false
	   */
	  public boolean logOn(String username, String password){
//		if(acct.isActive==true && acct.getUsername()==username && acct.getPassword()==password){
//			return true;
//		}	
//		return false;
		  Account thisPerson = database.getSpecificUser(username);
		  if(!(thisPerson==null)){
			  if(password.equals(thisPerson.getpassword())){
				 if(thisPerson.isActive()){
					 if(thisPerson.type.equals("a")){
						 return new AdminUI((Admin)thisPerson);
					 }
					 else{
						 return new UserUI((UerUI)thisPerson);
					 }
				 }
				 else{
					 throw new IllegalArgumentException("Person is deactived");
				 }
			  }
			  else{
				  throw new IllegalArgumentException("Password is not correct");
			  }
		  }
		  else{
			  throw new IllegalArgumentException("Account does not exist");
		  }
	  }
	  
	  /**
	   * This method identifies the type of user the user is: 'a' or 'u'.
	   * @param username the username the user puts in
	   * @return the character 'a' for admin, or 'u' for user
	   */
	  public char typeOfUser(String username){
		if(acct.getTypeOfUser()=='a'){
			return 'a';
		}
	    return 'u';
	  }
	  
	  /**
	   * This method resets the logging in fields for the user.
	   */    
	//  public void reset(){ 
//		  acct.removeAll();
	//  }    DO RESET LASTLY
}