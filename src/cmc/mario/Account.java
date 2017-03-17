package cmc.mario;
/*
 * File: Account.java
 */
/**
 * Account - Account home/entity to create an instance of an account in CMC system for a user.
 * @authors Mario Party 4 - Kalila Moua
 * @version 3/16/17
 */
public class Account{
	/**
	   * First name of user
	   */
	  public String firstName;
	  /**
	   * Last name of user
	   */
	  public String lastName;
	  /**
	   * Password of user
	   */
	  private String password;
	  /**
	   * Username of user
	   */
	  public String username;
	  /**
	   * Type of user
	   */
	  public char type;
	  /**
	   * if user is active or not, true if active, otherwise false
	   */
	  public boolean isActive;
	  
	  /**
	   * Default constructor
	   */
	  public Account(){
		  this.username = null;
		  this.password = null;
	  }
	  
	  /*
	   * Second Constructor which sets user name and password for object
	   */
	  public Account(String username, String password){
	    this.username=username;
	    this.password=password;
	  }
	  
	  /**
	   * Method gets the password from the user input.
	   * @return password is returned
	   */
	  public String getPassword(){
	    return this.password;
	  }
	  
	  /**
	   * Method gets the username from the user input.
	   * @return username is returned
	   */
	  public String getUsername(){
	    return this.username;
	  }
	  
	  /**
	   * Method gets the first name from the user input.
	   * @return first name is returned
	   */
	  public String getFirstName(){
	    return this.firstName;
	  }
	  
	  /**
	   * Method gets the last name from the user input.
	   * @return last name is returned
	   */
	  public String getLastName(){
	    return this.lastName;
	  }
	  
	  /**
	   * Method gets the type of user from the user input.
	   * @return type of user is returned
	   */
	  public char getTypeOfUser(){
	    return this.type;
	  }
	  
	  /**
	   * gets account active status
	   * @return true if isActive
	   */
	  public boolean isActive(){
		  return isActive;
	  }
	  
	  /**
	   * sets account status
	   */
	  public void setStatus(boolean newStatus){
		  this.isActive =newStatus;
	  }
}