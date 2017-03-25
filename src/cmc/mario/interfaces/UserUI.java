package cmc.mario.interfaces;
/*
 * File: UserUI.java
 */

import java.util.*;

import cmc.mario.controllers.AdminFuncController;
import cmc.mario.controllers.UserFuncController;
import cmc.mario.entities.Admin;
import cmc.mario.entities.University;
import cmc.mario.entities.User;

/** 
 * UserUI is an class for Users
 * 
 * @author Tre Vazquez | Mario Party 4
 * @version 03/20/2017
 */

public class UserUI extends AccountUI{ 
	/**
	 * User controller created for class
	 */
	public UserFuncController userContr;
	
	public UserUI(){
		this.userContr = new UserFuncController();
	 }
	  /**
	   * Constructor of the class
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
	   */ 
	  public void removeSavedSchool(University schoolName){
		  this.userContr.removeSavedSchool(schoolName);
	  }
		/**
		 * Searches for schools with the conditions given -Kalila
		 * 
		 * @param schoolName
		 *            the school name of the university
		 * @param state
		 *            the state of the university
		 * @param location
		 *            the location of the university
		 * @param control
		 *            the type of school (e.g. private)
		 * @param numOfStuStart
		 *            the number of students starting range number
		 * @param numOfStuEnd
		 *            the number of students ending range number
		 * @param perFemStart
		 *            the percentage of students who are female starting range
		 *            number
		 * @param perFemEnd
		 *            the percentage of students who are female ending range number
		 * @param satVerbalStart
		 *            the starting range for SAT verbal score
		 * @param satVerbalEnd
		 *            the ending range for SAT verbal score
		 * @param satMathStart
		 *            the starting range for SAT math score
		 * @param satMathEnd
		 *            the ending range for SAT math score
		 * @param priceStart
		 *            the starting range for price/expenses
		 * @param priceEnd
		 *            the ending range for price/expenses
		 * @param finAidStart
		 *            the starting range for financial aid percentage
		 * @param finAidEnd
		 *            the ending range for financial aid percentage
		 * @param numOfAppStart
		 *            the user gives
		 * @param perAdmitStart
		 *            the starting range for admitted students percentage
		 * @param perAdmitEnd
		 *            the ending range for admitted students percentage
		 * @param perEnrollStart
		 *            the starting range for enrolled students percentage
		 * @param perEnrollEnd
		 *            the ending range for enrolled students percentage
		 * @param academicScaleStart
		 *            the starting range for quality of academics
		 * @param academicScaleEnd
		 *            the ending range for quality of academics
		 * @param socialScaleStart
		 *            the starting range for quality of social
		 * @param socialScaleEnd
		 *            the ending range for quality of social scale
		 * @param lifeScaleStart
		 *            the starting range for quality of life scale
		 * @param lifeScaleEnd
		 *            the ending range for quality of life scale
		 * @param popMajor
		 *            an list of popular major or emphases at the university
		 */
	  public List<University> search(String schoolName, String state, String location, String control, Integer numOfStuStart, Integer numOfStuEnd, 
			  Integer perFemStart,Integer perFemEnd, Integer satVerbalStart, Integer satVerbalEnd, Integer satMathStart, Integer satMathEnd, Integer priceStart, Integer priceEnd,
			  Integer finAidStart,Integer finAidEnd, Integer numOfAppStart, Integer numOfAppEnd, Integer perAdmitStart, Integer perAdmitEnd, Integer perEnrollStart, 
			  Integer perEnrollEnd, Integer academicScaleStart, Integer academicScaleEnd, Integer socialScaleStart, Integer socialScaleEnd, Integer lifeScaleStart,
			  Integer lifeScaleEnd, List<String> popMajor){
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
	   */
	  public boolean saveSchool(String schoolName){
		 return this.userContr.saveSchool(schoolName);
	  }
	  
	  /**
	   * displays the user profile to the user.
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
	   */   
	  public void editPersonalProfile(String userName, String firstName, String lastName, String password){
		  this.userContr.editPersonalProfile(userName, firstName, lastName, password);
	  }
}