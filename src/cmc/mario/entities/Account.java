package cmc.mario.entities;
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
	   String firstName;
	  /**
	   * Last name of user
	   */
	   String lastName;
	  /**
	   * Password of user
	   */
	 String password;
	  /**
	   * Username of user
	   */
	  public String username;
	  /**
	   * Type of user
	   */
	  public char type;
	  /**
	   * "Y" for active account, "N" for inactive account
	   */
	  public char status;
	  /**
	   * if user is active or not, true if active, otherwise false
	   */
	   boolean isActive;
	  
	  /**
	   * Default constructor
	   */
	  public Account(){
		  this.firstName=null;
		  this.lastName=null;
		  this.username = null;
		  this.password = null;
	   
	  }


	/**
	 * Second constructor with param first name, last name, password, user name, type, status
	 * @param firstName the first name of this user
	 * @param lastName the last name of this user
	 * @param password the password the user sets
	 * @param username the user name the user uses
	 * @param type user is regular user or an admin
	 * @param status if is account is active
	 */
	public Account(String firstName, String lastName, String username, String password, char type, char status) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.type = type;
		this.status = status;
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
	   * Get status of this account if "Y" is active account, otherwise is inactive
	   * @return
	   */
	  public char getStatus(){
		return this.status;
	  }
	  
	  /**
	   * gets account active status
	   * @return true if isActive
	   */
	  public boolean isActive(){
		  return this.isActive;
		  
	  }
	  /**
	   * sets account active status
	   * @param isAcitve if is log on currently
	   */
	  public void setActive(boolean isActive){
		  this.isActive=isActive;
		  
	  }
	  /**
	   * Set type of user
	   * @param type of user
	   */
	  public void setTypeOfUser(char typeOfUser){
		  this.type = typeOfUser;
	  }
	  
	  /**
	   * sets account status
	   * @param  current status of this account(active or inactive)
	   */
	  public void setStatus(char status){
		  this.status = status;
	  }
	  
	  /**
	   * sets the user's firstname
	   * @param password the user's password
	   */
	  public void setPassword(String password)
	  {
	    this.password = password;
	  }
	  
	  /**
	   * sets the user's firstname
	   * @param firstName the user's firstname
	   */
	  public void setFirstName(String firstName)
	  {
	    this.firstName = firstName;
	  }
	  
	  /**
	   * sets the user's lastname
	   * @param lastname the user's lastname
	   */
	  public void setLastName(String lastName)
	  {
	    this.lastName = lastName;
	  }
	  
	  /**
	   * Sets the users username
	   * @param username the user's username
	   */
	  public void setUsername(String username){
		  this.username = username;
	  }
	  
}