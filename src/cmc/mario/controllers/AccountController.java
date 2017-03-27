package cmc.mario.controllers;
/**
 * File: AccountController.java
 */
import cmc.mario.entities.Account;
import cmc.mario.entities.Admin;
import cmc.mario.entities.User;
import cmc.mario.interfaces.AccountUI;
import cmc.mario.interfaces.AdminUI;
import cmc.mario.interfaces.UserUI;

/**
 * AccountController - Controller to control account functionality.
 * 
 * @authors Mario Party 4 - Kalila Moua
 * @modify Yidan Zhang
 * @version 3/26/2017
 */
public class AccountController {
	  /**
	   * Account object for account controller to communicate to
	   */
	  private Account acct;
	  /**
	   * DBController object for account controller to search data
	   */
	  private DBController database;
	  
	  /**
	   * Default constructor
	   */
	  public AccountController(){
		  
	  }
	  
	  /**
	   * constructor
	   * @param acct the account who is using currently 
	   */
	  public AccountController(Account acct){
		this.setAcct(acct);
		this.database = new DBController();
	  }
	  
	   
	  /**
	   * This method is to test if the user is logged off or not. //update in class diagram
	   * @return true if user is logged off, false otherwise
	   */ 
	  public boolean logOff(){
		  if (this.getAcct()==null){
			  return false;
		  }
		this.getAcct().setActive(false);
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
			  if(password.equals(thisPerson.getPassword())){
				 if(thisPerson.getStatus()=='Y'){
					 if(thisPerson.getTypeOfUser()=='a'){
						 thisPerson.setActive(true);
						 return new AdminUI(new Admin(thisPerson.getFirstName(),thisPerson.getLastName(),thisPerson.getUsername(),thisPerson.getPassword()));
					 }
					 else{
						 thisPerson.setActive(true);
						 return new UserUI(new User(thisPerson.getFirstName(),thisPerson.getLastName(),thisPerson.getUsername(),thisPerson.getPassword()));
					 }
				 }
				 else{
					 throw new IllegalArgumentException("Person is deactivated");
				 }
			  }
			  else{
				  throw new IllegalArgumentException("Password is not correct");
			  }
		  }
		  
	  
	  
	  /**
	   * This method identifies the type of user the user is: 'a' or 'u'.
	   * @param username the username the user puts in
	   * @return the character 'a' for admin, or 'u' for user
	   */
	  public char typeOfUser(String username){
		  Account person = database.getSpecificUser(username);
		  if(person==null){
			  throw new IllegalArgumentException("The account does not exist");
		  }
		if(person.getTypeOfUser()=='u'){
			return 'u';
		}
		else{
	    return 'a';
		}
	  }


	/**
	 * Method to return account object
	 * @return the acct
	 */
	public Account getAcct() {
		return acct;
	}


	/**
	 * Method to set account object
	 * @param acct the acct to set
	 */
	public void setAcct(Account acct) {
		this.acct = acct;
	}
}