
 package cmc.mario;
import java.io.*;
import java.util.*;
/**
 * AdminFuncController Class which includes all functionalities 
 * an Admin is able to do extends AccountController and implements AdminUI.
 * 
 * @author Mario Party 4: Yidan Zhang
 * @version Feb. 24, 2017
 */

public class AdminFuncController{
	private Admin ad;
	private DBController dbContr;
  /*
   * Constructor of the class: Inherited from super class: AccountController
   */
  public AdminFuncController(Admin a){
    this.ad = a;
    //super();
    dbContr = new DBController();
  }
  /*
   * view the list of users
   * 
   * @return list of users
   */ 
  public List<String> viewAccount(){
    return this.dbContr.getAccountList();
  }
  /*
   * Add a new user to database
   * 
   * @param username the username of new user
   * @param password which is created by the new user
   * 
   * @return true if add successfully
   */
  public boolean addUser(String firstName, String lastName, String username, String password,char type){
	  return dbContr.addUser(firstName, lastName, username, password, type);
  }
  
  /*
   * view a specific user profile including first name, last name, username, password, type, status
   * 
   * @param userName of the user
   * @param password of the user
   * 
   * @return user including personal profile
   */ 
  public User viewSpecificUser(String username){
    return this.dbContr.getSpecificUser(username);
  }
  /*
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
  /*
   * view a specific user profile including first name, last name, username, password, type, status
   * 
   * @param userName of the user
   * 
   */ 
  public void deactivateUser(String username){
	  if( dbContr.getSpecificUser(username).isActive==true){
		  dbContr.getSpecificUser(username).isActive=false;
		  dbContr.deactivateUser(username);
		  
	  }
  }
  
  /*
   * view the list of universities
   * 
   * @return list of universities
   */    
  public List<String> viewUniversities(){
    return this.dbContr.getUniversities();
  }
  /*
   * add a university
   * 
   * @param u the instance of University which will be added to database
   * 
   * @return true if add successfully
   * 
   */   
  public boolean addUniversity(String school, String state, String location, String control, int numberOfStudents, int percentFemales, int SATVerbal, int SATMath, 
		  int expenses, int percentFinancialAid, int numberOfApplicants, int percentAdmitted, int percentEnrolled, 
		  int academicsScale, int socialScale, int qualityOfLifeScale){
    return this.dbContr.addUniversity(school, state, location, control, 
			  numberOfStudents, percentFemales, SATVerbal, SATMath, expenses, percentFinancialAid, 
			  numberOfApplicants, percentAdmitted, percentEnrolled, academicsScale, socialScale, qualityOfLifeScale);
  }
  
  /*
   * view a specific university information 
   * 
   * @param universityName which admin wants to view
   * 
   * @return university including its detailed information
   */    
  public University viewSpecificUniversity(String univeristyname){
    
    return this.dbContr.viewSpecificSchool(univeristyname);
  }
  
  /*
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
   * @param popMajor which is the emphases majors of this school to update
   * 
   */    
  public boolean editUniversity(String school, String state, String location, String control, int numOfStu, int perFem, int satVerbal
                               , int satMath, int price, int finAid, int numOfApp, int perAdmit, int perEnroll, int academicScale
                               , int socialScale, int lifeScale){
    return this.dbContr.editUniversity(school, state, location, control, numOfStu, perFem, satVerbal, satMath, 
			  price, finAid, numOfApp, perAdmit, perEnroll, academicScale, socialScale, lifeScale);
  }
  
}