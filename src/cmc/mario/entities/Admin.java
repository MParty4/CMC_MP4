/**
 * File: Admin.java
 */
package cmc.mario.entities;

/**
 * Admin Class which includes the basic 
 * information about an Admin extends Account 
 * 
 * @author Mario Party 4: Yidan Zhang
 * @version 03/27/2017
 */
public class Admin extends Account{
  /**
   * Constructor of the class: Inherited from super class: Account
   */
  public Admin(){
    super.setTypeOfUser('a');
  }
  /**
   * Constructor to set first name, last name, user name, and password of created instance
   * @param firstName first name of this administrator
   * @param lastName last name of this administrator
   * @param userName user name of this administrator
   * @param password password of this administrator
   */
  public Admin(String firstName, String lastName, String userName, String password){
	  super.setTypeOfUser('a');
	  super.setFirstName(firstName);
	  super.setLastName(lastName);
	  super.setUsername(userName);
	  super.setPassword(password);
	  }
}