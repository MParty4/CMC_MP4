package cmc.mario;
/*
 * File: AccountUI.java
 */
/**
 * AccountUI - account user class for cmc system. 
 * This class creates the methods that account, userUI, and adminUI must include.
 * 
 * @authors Mario Party 4 - Kalila Moua
 * @version 3/16/17
 */
public class AccountUI{
  
	  /**
	   * Accountcontroller created for class
	   */
	  public AccountController acctCtr;
	  
	   /**
	   * default constructor
	   */
	  public AccountUI()
	  {
		this.acctCtr = new AccountController(new Account());
	  }
	  
	  /**
	   * This method is to test if the user is logged off or not. //update in class diagram
	   * @return true if user is logged off, false otherwise
	   */ 
	  public boolean logOff(){
		if (acctCtr.logOff()==true){
			return true;
		}
		return false;
	  }
	  
	  /**
	   * This method is to verify whether the user is logged on to the cmc system.
	   * @param username the username the user puts in
	   * @param password the password the user enters in
	   * @return true if the user is logged on and authentication is confirmed, otherwise return false
	   */
	  public boolean logOn(String username, String password){
		if(acctCtr.logOn(username, password).equals(true)){
			return true;
		}
	    return false;
	  }
	  
	  /**
	   * This method resets the logging in fields for the user.
	   */
	//  public void reset(){
//		  acctCtr.removeAll();
	//  }    RESET LATER
}