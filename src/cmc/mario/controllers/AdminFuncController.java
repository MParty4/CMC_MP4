
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
 * @modift Kalila Moua
 * @version 03/20/2017
 */

public class AdminFuncController{
	 /**
	   * Admin object for admin controller to communicate to
	   */
	  public Admin adm;
	  /**
	   * DBController object for admin controller to search data
	   */
	  public DBController dbContr;
	
  /**
   * @param a current admin who is using program
   */
  public AdminFuncController(Admin a){
    this.adm = a;
    dbContr = new DBController();
  }
  /**
 * @param adm a current admin who is using program
 * @param dbContr a current dbContr which is been using
 */
public AdminFuncController(Admin adm, DBController dbContr) {
	super();
	this.adm = adm;
	this.dbContr = dbContr;
}
  /**
   * view the list of users
   * 
   * @return list of users
   */ 
  public List<Account> viewAccount(){
    return this.dbContr.getAccountList();
  }
  /**
   * add a new user to database
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
   * view a specific user profile including first name, last name, username, password, type, status
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
   * edit a specific user profile including first name, last name, username, password, type, status
   * 
   * @param firstName which is new to update
   * @param lastName which is new to update
   * @param password which is new to update
   * @param type which is new to update
   * @param status which is new to update
   * 
   */ 
  public boolean editUser(String firstName, String lastName, String username, String password, char type, char status){
    return this.dbContr.editUser(firstName, lastName,username, password, type, status);
  }
  /**
   * view a specific user profile including first name, last name, username, password, type, status
   * 
   * @param userName of the user
   * @return true if deactivate successfully
   */ 
  public boolean deactivateUser(String username){
	  return this.dbContr.deactivateUser(username);
  }
  
  /**
   * view the list of universities
   * 
   * @return list of universities
   */    
  public List<University> viewUniversities(){
    return this.dbContr.getUniversities();
  }
  /**
	 * @param schoolName
	 *            name of the school
	 * @param state
	 *            which is searching condition
	 * @param location
	 *            which is searching condition
	 * @param control
	 *            which is searching condition
	 * @param numOfStu
	 *            which is number of students of searching condition
	 * @param perFem
	 *            which is percentage of female of searching condition
	 * @param satVerbal
	 *            which is sat verbal score of searching condition
	 * @param satMath
	 *            which is sat math score of searching condition
	 * @param price
	 *            which is expense of searching condition
	 * @param finAid
	 *            which is financial aid student can get from school of
	 *            searching condition
	 * @param numOfApp
	 *            which is number of applicants of searching condition
	 * @param perAdmit
	 *            which is percentage of admit of searching condition
	 * @param perEnroll
	 *            which is percentage of enroll of searching condition
	 * @param control
	 *            which is new of searching condition
	 * @param academicScale
	 *            which is scale of academic of searching condition
	 * @param socialScale
	 *            which is scale of social of searching condition
	 * @param lifeScale
	 *            which is scale of life of searching condition
	 * @param popMajor
	 *            which is the emphases majors of this school of searching
	 *            condition
	 * @return true if add successfully
	 */
  public boolean addUniversity(String school, String state, String location, String control, int numberOfStudents, int percentFemales, int SATVerbal, int SATMath, 
		  int expenses, int percentFinancialAid, int numberOfApplicants, int percentAdmitted, int percentEnrolled, 
		  int academicsScale, int socialScale, int qualityOfLifeScale, String popMajors){
    return this.dbContr.addUniversity(school, state, location, control, 
			  numberOfStudents, percentFemales, SATVerbal, SATMath, expenses, percentFinancialAid, 
			  numberOfApplicants, percentAdmitted, percentEnrolled, academicsScale, socialScale, qualityOfLifeScale,popMajors);
  }
  
  /**
   * view a specific university information 
   * 
   * @param universityName which admin wants to view
   * 
   * @return university including its detailed information
   */    
  public University viewSpecificUniversity(String univeristyname){
    
    return this.dbContr.viewSpecificSchool(univeristyname);
  }
  
  /**
   * edit a specific university information including 
   * @param state which is new to update
   * @param location which is new to update
   * @param control which is new to update
   * @param numOfStu which is number of students to update
   * @param perFem which is percentage of female to update
   * @param satVerbal which is sat verbal score to update
   * @param satMath which is sat math score to update
   * @param price which is expense to update
   * @param finAid which is financial aid student can get from school to update
   * @param numOfApp which is number of applicants to update
   * @param perAdmit which is percentage of admit to update
   * @param perEnroll which is percentage of enroll to update
   * @param control which is new to update
   * @param academicScale which is scale of acedmic to update
   * @param socialScale which is scale of social to update
   * @param lifeScale which is scale of life to update
   */    
  public boolean editUniversity(String school, String state, String location, String control, int numOfStu, int perFem, int satVerbal
                               , int satMath, int price, int finAid, int numOfApp, int perAdmit, int perEnroll, int academicScale
                               , int socialScale, int lifeScale){
    return this.dbContr.editUniversity(school, state, location, control, numOfStu, perFem, satVerbal, satMath, 
			  price, finAid, numOfApp, perAdmit, perEnroll, academicScale, socialScale, lifeScale);
  }
  
}