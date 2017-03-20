package cmc.mario.interfaces;

import cmc.mario.controllers.AccountController;
import cmc.mario.entities.Account;

/*
 * File: AccountUI.java
 */
/**
 * AccountUI - account user class for cmc system. 
 * This class creates the methods that account, userUI, and adminUI must include.
 * 
 * @authors Mario Party 4 - Kalila Moua
 * @modify Yidan Zhang
 * @version 3/20/2017
 */
public class AccountUI{
  
	  /**
	   * Account controller created for class
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
	   * @param username the user name the user puts in
	   * @param password the password the user enters in
	   * @return true if the user is logged on and authentication is confirmed, otherwise return false
	   */
	  public AccountUI logOn(String username, String password){
		return acctCtr.logOn(username, password);
	  }
	  
	  
}