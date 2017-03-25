package cmc.mario.entities;
/*
 * File: User.java
 */

/** 
 * User is an object class for the Users extends Account
 * 
 * @author Tre Vazquez | Mario Party 4
 * @version 03/20/2017
 */

public class User extends Account{
	
	/*
	   * default Constructor
	   */
	  public User(){
		  super.setTypeOfUser('a');
	  }
	 
	  public User(String firstName, String lastName, String username, String password){
		  super.setTypeOfUser('a');
		  super.setFirstName(firstName);
		  super.setLastName(lastName);
		  super.setUsername(username);
		  super.setPassword(password);
	  }
	 
	  /**
	   * Method to return the user's firstName
	   * @return user firstname
	   */
	  public String getFirstName()
	  {
	    return this.firstName;
	  }
	  
	  /**
	   * Method to return the user's lastname
	   * @return user lastname
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
	   * Method to return the user's username
	   * @return user's username
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