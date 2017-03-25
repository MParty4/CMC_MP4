/*
 * File: Admin.java
 */
package cmc.mario.entities;

/**
 * Admin Class which includes the basic 
 * information about an Admin extends Account 
 * 
 * @author Mario Party 4: Yidan Zhang
 * @version 03/20/2017
 */
public class Admin extends Account{
  /**
   * Constructor of the class: Inherited from super class: Account
   */
  public Admin(){
    super.setTypeOfUser('a');
  }
  /**
   * 
   * @param firstName first name of this admin
   * @param lastName last name of this admin
   * @param userName user name of this admin
   * @param password password of this admin
   */
  public Admin(String firstName, String lastName, String userName, String password){
	  super.setTypeOfUser('a');
	  super.setFirstName(firstName);
	  super.setLastName(lastName);
	  super.setUsername(userName);
	  super.setPassword(password);
	  }
}