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
 * @author Mario Party 4: Kalila Moua
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
	   * error reason for login
	   */
	  private int error;
	  
//	  /**
//	   * Default constructor
//	   */
//	  public AccountController(){
//	
//	  }
	  
	  /**
	   * constructor
	   * @param acct the account who is using currently 
	   */
	  public AccountController(Account acct){
		this.setAcct(acct);
		this.database = new DBController();
	  }
	  
	  /**
	   * This method is to test if the user is logged off or not. //update in class diagram - Yidan
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
	   * This method is to logon to the cmc system. - Kalila (White box)
	   * @param username the username the user puts in
	   * @param password the password the user enters in
	   * @throws IllegalArgumentException if username or password is wrong 
	   * @return true if the user is logged on and authentication is confirmed, otherwise return false
	   */
	  public AccountUI logOn(String username, String password){
	  
      Account thisPerson = database.getSpecificUser(username);	
      if(username.equals(thisPerson.getUsername())){
      	if(password.equals(thisPerson.getPassword())){
			if(thisPerson.getStatus()=='Y'){
				if(thisPerson.getTypeOfUser()=='a'){
					thisPerson.setActive(true);
					this.error=0;
					return new AdminUI(new Admin(thisPerson.getFirstName(),thisPerson.getLastName(),thisPerson.getUsername(),thisPerson.getPassword()));
				}
				else{
					thisPerson.setActive(true);
					this.error=1;
					//return null;
					return new UserUI(new User(thisPerson.getFirstName(),thisPerson.getLastName(),thisPerson.getUsername(),thisPerson.getPassword()));
				}
			}
			else{
				this.error=2;
				return new AccountUI();
				//throw new IllegalArgumentException("Person is deactivated");
			}
		}
		else{
			this.error=3;
			return new AccountUI();
				//throw new IllegalArgumentException("Password is not correct");
		}
      }
      	else{
      		this.error=4;
      		return new AccountUI();
      		}
      	}

		/**
		 * get error reason for log in
		 * @return error num  
		 */
	  public int getError(){
		//  System.out.println("r");
		  return this.error;
	  }
	  
	  /**
	   * This method identifies the type of user the user is: 'a' or 'u'. -  Tre
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