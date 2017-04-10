package cmc.mario.entities;
/**
 * File: User.java
 */

/** 
 * User is an object class for the Users extends Account
 * first
 * @author Tre Vazquez | Mario Party 4
 * @version 03/26/2017
 */

public class User extends Account{
	
	/**
	   * Default Constructor
	   */
	  public User(){
		  super.setTypeOfUser('u');
	  }
	 
	  /**
		  * Constructor of the class: sets firstname, lastname, username, and password
		  * @param firstName the first name of the user
		  * @param lastName the last name of the user
		  * @param username the username of the user
		  * @param password the password of the user
		  */
	  public User(String firstName, String lastName, String username, String password){
		  super.setTypeOfUser('u');
		  super.setFirstName(firstName);
		  super.setLastName(lastName);
		  super.setUsername(username);
		  super.setPassword(password);
	  }
	 
	  /**
	   * Method to return the user's firstName
	   * @return user first name
	   */
	  public String getFirstName()
	  {
	    return this.firstName;
	  }
	  
	  /**
	   * Method to return the user's lastname
	   * @return user last name
	   */
	  public String getLastName()
	  {
	    return this.lastName;
	  }
	  
	  /**
	   * Method to return the user's password
	   * @return user's password
	   */
	  public String getPassword()
	  {
	    return this.password;
	  }
	  
	  /**
	   * Method to return the user's user name
	   * @return user's user name
	   */
	  public String getUserName()
	  {
	    return this.username;
	  }
	  
	  /**
	   * Method to return the user's account type
	   * @return user Type
	   */
	  public char getType()
	  {
	    return this.type;
	  }


	  
}