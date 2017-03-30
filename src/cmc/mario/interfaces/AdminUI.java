/**
 * File: AdminUI.java
 */
package cmc.mario.interfaces;
import java.util.*;

import cmc.mario.controllers.AdminFuncController;
import cmc.mario.entities.Account;
import cmc.mario.entities.Admin;
import cmc.mario.entities.University;
/**
 * Class for a Administrator and extends AccountUI
 * @author Yidan Zhang
 * @modify Kalila Moua
 * @version 03/27/2017
 */

public class AdminUI extends AccountUI{
/**
 * admin function controller created to apply functions of admin
 */
private AdminFuncController adContr;

  /**
   * Constructor of the class
   * 
   * @param a which user is logging in
   */
  public AdminUI(Admin a){
    this.adContr = new AdminFuncController(a);
  }
  
  /**
   * To view the list of users
   * @return list of users
   */  
  public List<Account> viewAccount(){
    return this.adContr.viewAccount();
  }
  
 
 /**
 * Add a new user to the database library
 * @param firstName the first name of the user added
 * @param lastName the last name of the user added
 * @param username the user name of the user added
 * @param password the password of the user set
 * @param type the type of the user
 * @return true if add successful, otherwise false
 */
public boolean addUser(String firstName, String lastName, String username, String password, char type){
  return this.adContr.addUser(firstName, lastName, username, password, type);
  }
  
  /**
   * View a specific user profile including first name, last name, username, password, type, status
   * @param userName of the user
   * @return user including personal profile
   */   
  public Account viewSpecificUser(String username){
  return this.adContr .viewSpecificUser(username);
  }
  /**
   * Edit a specific user profile including first name, last name, username, password, type, status
   * @param firstName which is new to update
   * @param lastName which is new to update
   * @param password which is new to update
   * @param type which is new to update
   * @param status which is new to update
   * @return true if administrator edit user information, othewise false
   */  
  public boolean editUser(String firstName, String lastName, String username, String password, char type, char status){
	  return this.adContr.editUser(firstName, lastName,username, password, type, status);
	  }
  /**
   * View a specific user profile including first name, last name, username, password, type, status
   * @param userName of the user
   * @return true if username is a deactivated user, otherwise false
   */ 
  public boolean deactivateUser(String username){
	 return this.adContr.deactivateUser(username);
  }
  /**
   * View a list of all university containing all info of these universities
   * @return list of university with all info
   */
  public List<University> viewUniversities(){
  return this.adContr.viewUniversities();
  }
  
	/**
	 * To add a new university into the database library - administrator rights only
	 	   * @param state the state where the school is located
		   * @param location what type of area is the school located at
		   * @param control the type of school (e.g. private)
		   * @param numOfStu number of students attending school 
		   * @param perFem percentage of females attending 
		   * @param satVerbal average SAT Verbal score 
		   * @param satMath average SAT Math score 
		   * @param priceE total expenses for a year at school 
		   * @param finAid the percentage of students receiving financial aid 
		   * @param numOfApp the number of applications the school receives 
		   * @param perAdmit the percentage of admitted students 
		   * @param perEnroll the percentage of students enrolled after applying 
		   * @param control the control of school amount
		   * @param academicScale the scale of academic life on campus 
		   * @param socialScale the scale of social life on campus 
		   * @param lifeScale the scale of life on campus 
		   * @param popMajor a list of popular majors at university
		   * @return true if add successfully, otherwise false
		   */
public boolean addUniversity(String school, String state, String location, String control, int numberOfStudents, int percentFemales, int SATVerbal, int SATMath, 
		  int expenses, int percentFinancialAid, int numberOfApplicants, int percentAdmitted, int percentEnrolled, 
		  double academicsScale, double socialScale, double qualityOfLifeScale, String[] popMajors){
	  return this.adContr.addUniversity(school, state, location, control, 
			  numberOfStudents, percentFemales, SATVerbal, SATMath, expenses, percentFinancialAid, 
			  numberOfApplicants, percentAdmitted, percentEnrolled, academicsScale, socialScale, qualityOfLifeScale, popMajors);
  }
  
  /**
   * View a specific university's and its information 
   * @param universityName which administrator wants to view
   * @return university including its detailed information
   */    
  public University viewSpecificUniversity(String universityName){
	  return this.adContr.viewSpecificUniversity(universityName);
  }
  /**
   * Displays a list of universities meeting the search criteria for the admin. 
   * @param u university object to be used 
   * @return list of universities.
   */
  public List<String> viewResults(University u){
  return this.adContr.viewResults(u);
  }
  /**
   * To edit a specific university's attributes
   *@param state the state where the school is located
   * @param location what type of area is the school located at
   * @param control the type of school (e.g. private)
   * @param numOfStu number of students attending school 
   * @param perFem percentage of females attending 
   * @param satVerbal average SAT Verbal score 
   * @param satMath average SAT Math score 	
   * @param priceE total expenses for a year at school 
   * @param finAid the percentage of students receiving financial aid 
   * @param numOfApp the number of applications the school receives 
   * @param perAdmit the percentage of admitted students 
   * @param perEnroll the percentage of students enrolled after applying 
   * @param control the control of school amount
   * @param academicScale the scale of academic life on campus 
   * @param socialScale the scale of social life on campus 
   * @param lifeScale the scale of life on campus 
   * @return true if edit successfully
   */   
  public boolean editUniversity(String school, String state, String location, String control, int numberOfStudents, int percentFemales, int SATVerbal, int SATMath, 
		  int expenses, int percentFinancialAid, int numberOfApplicants, int percentAdmitted, int percentEnrolled, 
		  double academicsScale, double socialScale, double qualityOfLifeScale){
	 return this.adContr.editUniversity(school, state, location, control, 
			  numberOfStudents, percentFemales, SATVerbal, SATMath, expenses, percentFinancialAid, 
			  numberOfApplicants, percentAdmitted, percentEnrolled, academicsScale, socialScale, qualityOfLifeScale);
  }
  
}