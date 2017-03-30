package cmc.mario.controllers;
/**
 * File: UserFuncController.java 
 */

import java.util.*;

import cmc.mario.entities.Account;
import cmc.mario.entities.University;
import cmc.mario.entities.User;

/** 
 * UserFuncController is an implementation for the UserUI and an extension
 * of the account controller
 * @author Tre Vazquez | Mario Party 4
 * @version 03/27/2017
 */

public class UserFuncController {
	/**
	 * User instance 
	 */
	private User user;
	
	/**
	 * DatabaseController instance
	 */
	private DBController dbc;
	
	/**
	 * SeachController instance
	 */
	private SearchController sc;
	

	/**
   	  * Constructor of the class: Inherited from super class: AccountController
   	  * @param u the user object to be used 
   	  */
	 public UserFuncController(User u){
		 this.setUser(u);
		 dbc = new DBController();
		 sc = new SearchController();
	 }
  
  /**
   * Displays list of the Users Saved Schools
   * @return list of saved schools/universities
   */
  public List<University> viewSavedSchools()
  { 
    return this.dbc.getSavedSchools(this.user.getUserName());
  }
  
  /**
   * Removes desired school from the User's saved school list
   * @param schoolName the name of the school to be removed 
   * @return true if the school is removed, otherwise false
   */
  public boolean removeSavedSchool(String schoolName)
  {
    return this.dbc.removeSavedSchool(this.user, schoolName);
  }
  
  
  /**
   * The search method which finds matching universities depending on 
   * the user's search criteria. 
   * @param schoolName name of the school
   * @param state the state where the school is located
   * @param location what type of area is the school located at
   * @param control the type of school (e.g. private)
   * @param numOfStuStart number of students attending school starting amount
   * @param numOfStuEnd number of students attending school ending amount
   * @param perFemStart percentage of females attending starting amount
   * @param perFemEnd percentage of females attending ending amount
   * @param satVerbalStart average SAT Verbal score starting amount
   * @param satVerbalEnd average SAT Verbal score ending amount
   * @param satMathStart average SAT Math score starting amount
   * @param satMathEnd average SAT Math score ending amount
   * @param priceStart total expenses for a year at school starting amount
   * @param priceEnd total expenses for a year at school ending amount
   * @param finAidStart the percentage of students receiving financial aid starting amount
   * @param finAidEnd the percentage of students receiving financial aid ending amount
   * @param numOfAppStart the number of applications the school receives starting amount
   * @param numOfAppEnd the number of applications the school receives ending amount
   * @param perAdmitStart the percentage of admitted students condition starting amount
   * @param perAdmitEnd the percentage of admitted students ending amount
   * @param perEnrollStart the percentage of students enrolled starting amount
   * @param perEnrollEnd the percentage of students enrolled after applying ending amount
   * @param controlStart the control of school amount
   * @param controlEnd the control of school ending amount
   * @param academicScaleStart the scale of academic life on campus starting amount
   * @param academicScaleEnd the scale of academic life on campus ending amount
   * @param socialScaleStart the scale of social life on campus starting amount
   * @param socialScaleEnd the scale of social life on campus ending amount
   * @param lifeScaleStart the scale of life on campus starting amount
   * @param lifeScaleEnd the scale of life on campus ending amount
   * @param popMajor a list of popular majors at university
   * @return list of schools matching search
   */
  public List<University> search(String schoolName, String state, String location, String control, int numOfStuStart, int numOfStuEnd, 
			 int perFemStart,int perFemEnd, int satVerbalStart, int satVerbalEnd, int satMathStart, int satMathEnd, int priceStart, int priceEnd,
			 int finAidStart,int finAidEnd, int numOfAppStart, int numOfAppEnd, int perAdmitStart, int perAdmitEnd, int perEnrollStart, 
			 int perEnrollEnd, double academicScaleStart, double academicScaleEnd, double socialScaleStart, double socialScaleEnd, double lifeScaleStart,
			 double lifeScaleEnd, String[] popMajor){
   return this.sc.search(schoolName, state,location,control, numOfStuStart, numOfStuEnd, perFemStart, perFemEnd, satVerbalStart, satVerbalEnd, satMathStart, 
		   
		   satMathEnd, priceStart, priceEnd, finAidStart, finAidEnd, numOfAppStart, numOfAppEnd, perAdmitStart, perAdmitEnd, perEnrollStart, 
		   perEnrollEnd, academicScaleStart, academicScaleEnd, socialScaleStart,socialScaleEnd, lifeScaleStart, lifeScaleEnd, popMajor);
  }
  
  /**
   * Displays a specific list of universities meeting the search criteria for the user.
   * @param u the university to search results for
   * @return list of universities in string format
   */
  public List<String> viewSearchResults(University u) 
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
    dis.addAll(this.dbc.getEmphasesForUniversity(u.getSchoolName()));
    
    return dis;
  }
  
  /**
   * Displays specific school selected to user.
   * @param schoolName the name which will serve as the selected university
   * @return university object containing university details
   */
  public University viewSpecificSchool(String schoolName)
  {
    return this.dbc.viewSpecificSchool(schoolName);
  }
  
  /**
   * Displays recommendations based upon university being viewed by a user
   * @param u a university object to be used as criteria for recommendations
   * @return list of universities with partial info
   */
  public List<University> viewRecommendation(University u){
    return sc.viewRecommendation(u);
  }
  
  /**
   * Grants user the ability to save a school to their saved school lists
   * @param schoolName the name of the school to be saved 
   * @return true if the school is successfully saved, otherwise false
   */
  public boolean saveSchool(String schoolName)
  {
    return this.dbc.addSavedSchool(this.user, schoolName);
  }
  
  /**
   * Displays the user profile to the user.
   * @return user object to preview user details
   */
  public Account viewPersonalProfile()
  {
    return this.dbc.getSpecificUser(this.user.getUserName()); 
  }
  
  /**
   * Grants user the ability to edit their personal profile
   * @param username the user name of user
   * @param firstName the user's firstName
   * @param lastName the user's lastName
   * @param password the user's password
   * @return true if the user has ability to edit personal profile, otherwise false
   */
  public boolean editPersonalProfile(String userName, String firstName, String lastName, String password)
  {
    return this.dbc.editPersonalProfile(userName, firstName, lastName, password);
  }
  /**
	 * Method to return user object
	 * @return the user
	 */
	public User getUser() {
		return user;
	}


	/**
	 * Method to set user object
	 * @param usr the usr to set
	 */
	public void setUser(User usr) {
		this.user = usr;
	}
}
