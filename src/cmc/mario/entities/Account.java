package cmc.mario.entities;
/**
 * File: Account.java
 */
/**
 * Account - Account home/entity to create an instance of an account in CMC system for a user.
 * @author Mario Party 4: Kalila Moua
 * @version 3/27/17
 */
public class Account{
	/**
	   * First name of user
	   */
	   protected String firstName;
	  /**
	   * Last name of user
	   */
	   protected String lastName;
	  /**
	   * Password of user
	   */
	 protected String password;
	  /**
	   * User name of user
	   */
	 protected String username;
	  /**
	   * Type of user
	   */
	 protected char type;
	  /**
	   * "Y" for active account, "N" for inactive account
	   */
	 protected char status;
	  /**
	   * if user is active or not, true if active, otherwise false
	   */
	 protected boolean isActive;
	  
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
	 * Second constructor with parameter first name, last name, password, user name, type, status
	 * @param firstName the first name of this user
	 * @param lastName the last name of this user
	 * @param password the password the user sets
	 * @param username the user name the user uses
	 * @param type user is regular user or an administrator
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
	   * @return password of user
	   */
	  public String getPassword(){
	    return this.password;
	  }
	  
	  /**
	   * Method gets the user name from the user input.
	   * @return user name of user
	   */
	  public String getUsername(){
	    return this.username;
	  }
	  
	  /**
	   * Method gets the first name from the user input.
	   * @return first name of user
	   */
	  public String getFirstName(){
	    return this.firstName;
	  }
	  
	  /**
	   * Method gets the last name from the user input.
	   * @return last name of user
	   */
	  public String getLastName(){
	    return this.lastName;
	  }
	  
	  /**
	   * Method gets the type of user from the user input.
	   * @return type of user of user
	   */
	  public char getTypeOfUser(){
	    return this.type;
	  }
	  /**
	   * Get status of this account if "Y" is active account, otherwise is inactive
	   * @return status of the user
	   */
	  public char getStatus(){
		return this.status;
	  }
	  
	  /**
	   * Gets account status based on user
	   * @return true if user is active or not
	   */
	  public boolean isActive(){
		  return this.isActive;
		  
	  }
	  /**
	   * Sets account active status - Kalila (Black-box)
	   * @param isAcitve if the user is logged on currently
	   */
	  public void setActive(boolean isActive){
		  this.isActive=isActive;
		  
	  }
	  
	  /**
	   * Set type of user - Kalila (Black-box)
	   * @param type of user
	   */
	  public void setTypeOfUser(char typeOfUser){ 
		  this.type = typeOfUser;
	  }
	  
	  /**
	   * Sets account status of user - Kalila  (Black-box)
	   * @param current status of this account(active or inactive)
	   */
	  public void setStatus(char status){
		  this.status = status;
	  }
	  
	  /**
	   * Allows the user to set their own password - Kalila (Black-box)
	   * @param password the user's password
	   */
	  public void setPassword(String password)
	  {
	    this.password = password;
	  }
	  
	  /**
	   * Allows the user to set their own first name - Kalila (Black-box)
	   * @param firstName the user's first name
	   */
	  public void setFirstName(String firstName)
	  {
	    this.firstName = firstName;
	  }
	  
	  /**
	   * Allows the user to set their own last name - Kalila  (Black-box)
	   * @param lastname the user's last name
	   */
	  public void setLastName(String lastName)
	  {
	    this.lastName = lastName;
	  }
	  
	  /**
	   * Sets the users user name
	   * @param username the user's user name - Kalila (Black-box)
	   */
	  public void setUsername(String username){
		  this.username = username;
	  }
	  
}