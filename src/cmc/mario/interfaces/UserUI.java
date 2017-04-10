package cmc.mario.interfaces;
/**
 * File: UserUI.java
 */

import java.util.*;

import cmc.mario.controllers.AdminFuncController;
import cmc.mario.controllers.UserFuncController;
import cmc.mario.entities.Account;
import cmc.mario.entities.Admin;
import cmc.mario.entities.University;
import cmc.mario.entities.User;

/** 
 * UserUI is an class for Users
 * 
 * @author Tre Vazquez | Mario Party 4
 * @version 03/27/2017
 */

public class UserUI extends AccountUI{ 
	/**
	 * User controller created for class
	 */
	private UserFuncController userContr;
	
	  /**
	   * Constructor of the class
	   * @param user the User object
	   */
	public UserUI(User user){
	    this.userContr = new UserFuncController(user);
	  }
	  
	  
	  /**
	   * Displays list of the Users Saved Schools
	   * @return list of saved schools
	   */
	  public List<University> viewSavedSchools(){
	    return this.userContr.viewSavedSchools();
	  }
	  
	  /**
	   * Removes desired school from the User's saved school list
	   * @param schoolName the name of the school to be removed 
	   * @return true if the school was successfully removed, otherwise false
	   */ 
	  public boolean removeSavedSchool(String schoolName){
		 return this.userContr.removeSavedSchool(schoolName);
	  }
		/**
		 * Searches for schools with the conditions given
		 * 
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
		   * @return list of university which matches criteria entered by user
		 */
	  public List<University> search(String schoolName, String state, String location, String control, int numOfStuStart, int numOfStuEnd, 
				 int perFemStart,int perFemEnd, int satVerbalStart, int satVerbalEnd, int satMathStart, int satMathEnd, int priceStart, int priceEnd,
				 int finAidStart,int finAidEnd, int numOfAppStart, int numOfAppEnd, int perAdmitStart, int perAdmitEnd, int perEnrollStart, 
				 int perEnrollEnd, double academicScaleStart, double academicScaleEnd, double socialScaleStart, double socialScaleEnd, double lifeScaleStart,
				 double lifeScaleEnd, String[] popMajor){
	    return this.userContr.search(schoolName, state,location,control, numOfStuStart, numOfStuEnd, perFemStart, perFemEnd, satVerbalStart, satVerbalEnd, satMathStart, 
	 		   
	 		   satMathEnd, priceStart, priceEnd, finAidStart, finAidEnd, numOfAppStart, numOfAppEnd, perAdmitStart, perAdmitEnd, perEnrollStart, 
	 		   perEnrollEnd, academicScaleStart, academicScaleEnd, socialScaleStart,socialScaleEnd, lifeScaleStart, lifeScaleEnd, popMajor);
	  }
	  
	  /**
	   * Displays a list of universities meeting the search criteria for the user. 
	   * @param u university object to be used 
	   * @return list of universities.
	   */
	  public List<String> viewSearchResults(University u){
	  return this.userContr.viewSearchResults(u);
	  }
	  
	  /**
	   * Displays specific school selected to user.
	   * @param schoolName the school name of the university
	   * @return university object containing university details
	   */
	  public University viewSpecificSchool(String schoolName){
	  return this.userContr.viewSpecificSchool(schoolName);
	  }
	  
	  /**
	   * Displays 5 different schools as recommendations to a user viewing 
	   * a specific school
	   * @param u the university object used as criteria for recommendations
	   * @return list of universities to be previewed as recommendations
	   */
	  public List<University> viewRecommendation(University u){
	    return this.userContr.viewRecommendation(u);
	  }
	  
	  /**
	   * Grants user the ability to save a school to their saved school lists
	   * @param schoolName the name of the school to be saved
	   * @return true if school is saved successfully, otherwise false
	   */
	  public boolean saveSchool(String schoolName){
		 return this.userContr.saveSchool(schoolName);
	  }
	  
	  /**
	   * Displays the user profile to the user.
	   * @return user object to preview user details
	   */
	  public User viewPersonalProfile(){
	    return this.userContr.viewPersonalProfile();
	  }
	  
	  /**
	   * Grants user the ability to edit their personal profile
	   * @param firstName the user's firstName
	   * @param lastName the user's lastName
	   * @param password the user's password
	   * @return true if user can edit personal profile, otherwise false
	   */   
	  public boolean editPersonalProfile(String userName, String firstName, String lastName, String password){
		  return this.userContr.editPersonalProfile(userName, firstName, lastName, password);
	  }
}