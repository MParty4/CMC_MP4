/*
 * File: Admin.java
 */
package cmc.mario;
/**
 * Admin Class which includes the basic 
 * information about an Admin extends Account 
 * 
 * @author Mario Party 4: Yidan Zhang
 * @version Feb. 24, 2017
 */
public class Admin extends Account{
  /*
   * Constructor of the class: Inherited from super class: Account
   */
  public Admin(){
    super();
  }
  public Admin(String firstName, String lastName, String userName, String password){
	  super.setFirstName(firstName);
	  super.setLastName(lastName);
	  super.setUsername(userName);
	  super.setPassword(password);
	  }
}