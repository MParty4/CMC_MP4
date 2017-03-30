/**
 * File: AdminFuncController.java
 */

package cmc.mario.controllers;
import java.io.*;
import java.util.*;

import cmc.mario.entities.Account;
import cmc.mario.entities.Admin;
import cmc.mario.entities.University;
/**
 * AdminFuncController Class which includes all functionalities 
 * an Admin is able to do extends AccountController and implements AdminUI.
 * 
 * @author Mario Party 4: Yidan Zhang
 * @modify Kalila Moua
 * @version 03/27/2017
 */

public class AdminFuncController{
	 /**
	   * Admin object for admin controller to communicate to
	   */
	  private Admin adm;
	  /**
	   * DBController object for admin controller to search data
	   */
	  private DBController dbContr;
	
  /**
   * First constructor
   * @param a current admin who is using program
   */
  public AdminFuncController(Admin a){
	  this.setAdmin(a);
    dbContr = new DBController();
  }
  /**
   * Second constructor which sets admin and database controller instances
 * @param adm a current admin who is using program
 * @param dbContr a current dbContr which is been using
 */
public AdminFuncController(Admin adm, DBController dbContr) {
	super();
	this.setAdmin(adm);
	this.dbContr = dbContr;
}
  /**
   * View the list of users
   * @return list of users
   */ 
  public List<Account> viewAccount(){
    return this.dbContr.getAccountList();
  }
  /**
   * Add a new user to database
   * @param firstName the first name of the user added
   * @param lastName the last name of the user added
   * @param username the user name of the user added
   * @param password the password of the user set
   * @param type the type of the user
   * @return true if add successful
   */
  public boolean addUser(String firstName, String lastName, String username, String password,char type){
	  return dbContr.addUser(firstName, lastName, username, password, type);
  }
  
  /**
   * View a specific user profile including first name, last name, username, password, type, status
   * 
   * @param userName of the user
   * @param password of the user
   * 
   * @return user including personal profile
   */ 
  public Account viewSpecificUser(String username){
    return this.dbContr.getSpecificUser(username);
  }
  /**
   * Edit a specific user profile including first name, last name, username, password, type, status
   * 
   * @param firstName which is new to update
   * @param lastName which is new to update
   * @param password which is new to update
   * @param type which is new to update
   * @param status which is new to update
   * @return true if edit user is successful, otherwise false
   */ 
  public boolean editUser(String firstName, String lastName, String username, String password, char type, char status){
    return this.dbContr.editUser(firstName, lastName,username, password, type, status);
  }
  /**
   * View a specific user profile including first name, last name, username, password, type, status
   * @param userName of the user
   * @return true if deactivate successfully, otherwise false
   */ 
  public boolean deactivateUser(String username){
	  return this.dbContr.deactivateUser(username);
  }
  
  /**
   * To view the list of universities
   * @return list of universities
   */    
  public List<University> viewUniversities(){
    return this.dbContr.getUniversities();
  }
  /**
   * Method to add university
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
    return this.dbContr.addUniversity(school, state, location, control, 
			  numberOfStudents, percentFemales, SATVerbal, SATMath, expenses, percentFinancialAid, 
			  numberOfApplicants, percentAdmitted, percentEnrolled, academicsScale, socialScale, qualityOfLifeScale,popMajors);
  }
  
  /**
   * View a specific university information 
   * @param universityName which admin wants to view
   * @return university including its detailed information
   */    
  public University viewSpecificUniversity(String univeristyname){
    
    return this.dbContr.viewSpecificSchool(univeristyname);
  }
  /**
   * Displays a specific list of universities meeting the search criteria for the admin.
   * @param u the university to search results for
   * @return list of universities in string format
   */
  public List<String> viewResults(University u) 
  {
    List<String> dis = new ArrayList<String>();
    
    dis.add(u.getSchoolName());
    dis.add(u.getState());
    dis.add(u.getLocation());
    dis.add(u.getControl());
    dis.add(Integer.toString(u.getNumOfStu()));
    dis.add(Integer.toString(u.getPerFem()));
    dis.add(Integer.toString(u.getSatVerbal()));
    dis.add(Integer.toString(u.getSatMath()));
    dis.add(Integer.toString(u.getPrice()));
    dis.add(Integer.toString(u.getFinAid()));
    dis.add(Integer.toString(u.getNumOfApp()));
    dis.add(Integer.toString(u.getPerAdmit()));
    dis.add(Integer.toString(u.getPerEnroll()));
    dis.add(Double.toString(u.getAcademicScale()));
    dis.add(Double.toString(u.getSocialScale()));
    dis.add(Double.toString(u.getLifeScale()));
    dis.addAll(this.dbContr.getEmphasesForUniversity(u.getSchoolName()));
    
    return dis;
  }
  
  /**
   * Edit a specific university information
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
		   * @return true if the university is edited, otherwise false
   */    
  public boolean editUniversity(String school, String state, String location, String control, int numberOfStudents, int percentFemales, int SATVerbal, int SATMath, 
		  int expenses, int percentFinancialAid, int numberOfApplicants, int percentAdmitted, int percentEnrolled, 
		  double academicsScale, double socialScale, double qualityOfLifeScale){
    return this.dbContr.editUniversity(school, state, location, control, 
			  numberOfStudents, percentFemales, SATVerbal, SATMath, expenses, percentFinancialAid, 
			  numberOfApplicants, percentAdmitted, percentEnrolled, academicsScale, socialScale, qualityOfLifeScale);
  }
  /**
	 * Method to return admin object
	 * @return the adm
	 */
	public Admin getAdmin() {
		return adm;
	}


	/**
	 * Method to set admin object
	 * @param adm the adm to set
	 */
	public void setAdmin(Admin adm) {
		this.adm = adm;
	}
  
}