package cmc.mario.interfaces;
/**
 * File: AccountUI.java
 */
import cmc.mario.controllers.AccountController;
import cmc.mario.entities.Account;

/**
 * AccountUI - account user class for cmc system. 
 * This class creates the methods that account, userUI, and adminUI must include.
 * 
 * @author Mario Party 4: Kalila Moua
 * @modify Yidan Zhang
 * @version 3/26/2017
 */
public class AccountUI{
  
	  /**
	   * Account controller created for class
	   */
	  private AccountController acctCtr;
	  
	   /**
	   * Default constructor
	   */
	  public AccountUI()
	  {
		this.acctCtr = new AccountController(new Account());
	  }
	  
	  /**
	   * This method is to test if the user is logged off or not. 
	   * @return true if user is logged off, false otherwise
	   */ 
	  public boolean logOff(){
		if (acctCtr.logOff()==true){
			return true;
		}
		return false;
	  }
	  
	  /**
	   * This method is to log on and return account UI to user
	   * @param username the user name the user puts in
	   * @param password the password the user enters in
	   * @return user is brought to accountUI if the user is logged on and authentication is confirmed	   
	   */
	  public int logOn(String username, String password){
		return this.acctCtr.logOn(username, password);
	  }
	  /**
	   * This method to get type of user with username
	   * @param username the name the user hope to check the the type
	   * @return 'u' if it's a user account; 'a' if it is an admin account
	   */
	  public char typeOfUser(String username){
		  return this.acctCtr.typeOfUser(username);
	  }
	  
}