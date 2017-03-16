package cmc.mario;
/*
 * File: AccountUI.java
 */
import java.io.*;
/**
 * AccountUI - account user class for cmc system. 
 * This class creates the methods that account, userUI, and adminUI must include.
 * 
 * @authors Mario Party 4 - Kalila Moua
 * @version 2/24/17
 */
public class AccountUI{
  
  /**
   * accountcontroller created for class
   */
  public AccountController acctCtr;
  /**username of the user
   */
  String username;
  /**password of the user
   */
  String password;
  
   /**
   * default constructor
   */
  public AccountUI(Account acct){
	this.acctCtr = new AccountController(acct);
	this.username = acct.getUsername();
	this.password = acct.getPassword();
  }
  
  /*
   * Constructor which sets username and password for object
   */
  public AccountUI(String username, String password){
    this.username = username;
    this.password = password;
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
	if(acctCtr.logOn()==true){
		return true;
	}
    return false;
  }
  
  /**
   * This method resets the logging in fields for the user.
   */
  public void reset(){
	  acctCtr.removeAll();
  }
}