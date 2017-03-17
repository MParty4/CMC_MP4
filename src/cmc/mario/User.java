package cmc.mario;
/*
 * File: User.java
 */

import java.io.*;
import java.util.*;

/** 
 * User is an object class for the Users extends Account
 * 
 * @author Tre Vazquez | Mario Party 4
 * @version March 16, 2017
 */

public class User extends Account{
	
	/*
	   * Constructor of the class: Inherited from super class: Account
	   */
	  public User(){
	    super();
	  }
	  
	  /**
	   * sets the user's firstname
	   * @param password the user's password
	   */
	  public void setPassword(String password)
	  {
	    String p = super.getPassword();
	    p= password;
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