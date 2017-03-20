package cmc.mario;
/*
 * File: AccountController.java
 */
/**
 * AccountController - Controller to control account functionality.
 * 
 * @authors Mario Party 4 - Kalila Moua
 * @modify Yidan Zhang
 * @version 3/20/2017
 */
public class AccountController {
	  /**
	   * Account object for acct controller to communicate to
	   */
	  public Account acct;
	  /**
	   * DBController object for acct controller to search data
	   */
	  public DBController database;
	  /**
	   * true if user is logged on
	   */
	  public boolean isLoggedOn;
	  
	  /**
	   * default constructor
	   * @param acct the account who is using currently 
	   */
	  public AccountController(Account acct){
		this.acct = acct;
		this.database = new DBController();
	  }
	  
	   
	  /**
	   * This method is to test if the user is logged off or not. //update in class diagram
	   * @return true if user is logged off, false otherwise
	   */ 
	  public boolean logOff(){
		  if (this.acct==null){
			  return false;
		  }
		this.acct.setActive(false);
		return true;
	  }
	  
	  /**
	   * This method is to logon to the cmc system.
	   * @param username the username the user puts in
	   * @param password the password the user enters in
	   * @return true if the user is logged on and authentication is confirmed, otherwise return false
	   */
	  public AccountUI logOn(String username, String password){
		  Account thisPerson = database.getSpecificUser(username);
		  if(!(thisPerson==null)){
			  if(password.equals(thisPerson.getPassword())){
				 if(thisPerson.isActive()){
					 if(thisPerson.getTypeOfUser()=='a'){
						 thisPerson.isActive=true;
						 return new AdminUI((Admin)thisPerson);
					 }
					 else{
						 thisPerson.isActive=true;
						 return new UserUI((User)thisPerson);
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
		if(this.acct.getTypeOfUser()=='a'){
			return 'a';
		}
	    return 'u';
	  }
}