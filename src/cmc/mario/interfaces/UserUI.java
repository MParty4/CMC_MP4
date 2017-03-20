package cmc.mario.interfaces;
/*
 * File: UserUI.java
 */

import java.util.*;

import cmc.mario.controllers.UserFuncController;
import cmc.mario.entities.University;
import cmc.mario.entities.User;

/** 
 * UserUI is an class for Users
 * 
 * @author Tre Vazquez | Mario Party 4
 * @version March 19, 2017
 */

public class UserUI extends AccountUI{ 
	public UserFuncController userContr;
	  /*
	   * Constructor of the class: Inherited from super class: AccountUI
	   * @param u user object to be used 
	   */
	  public UserUI(User u){
	    this.userContr = new UserFuncController(u);
	    
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
	  //
	  /**
	   * The search method which sorts known universities depending in 
	   * the user's search criteria. 
	   * @param schoolName name of the school
	   * @param state which is searching condition
	   * @param location which is searching condition
	   * @param control which is searching condition
	   * @param numOfStu which is number of students of searching condition
	   * @param perFem which is percentage of female of searching condition
	   * @param satVerbal which is sat verbal score of searching condition
	   * @param satMath which is sat math score of searching condition
	   * @param price which is expense of searching condition
	   * @param finAid which is financial aid student can get from school of searching condition
	   * @param numOfApp which is number of applicants of searching condition
	   * @param perAdmit which is percentage of admit of searching condition
	   * @param perEnroll which is percentage of enroll of searching condition
	   * @param control which is new of searching condition
	   * @param academicScale which is scale of academic of searching condition
	   * @param socialScale which is scale of social of searching condition
	   * @param lifeScale which is scale of life of searching condition
	   * @param popMajor which is the emphases majors of this school of searching condition
	   * @return list of schools matching search
	   */
	  public List<University> search(String schoolName, String state, String location, String control, Integer numOfStuStart, Integer numOfStuEnd, 
			  Double perFemStart,Double perFemEnd, Integer satVerbalStart, Integer satVerbalEnd, Integer satMathStart, Integer satMathEnd, Integer priceStart, Integer priceEnd,
			  Integer finAidStart,Integer finAidEnd, Integer numOfAppStart, Integer numOfAppEnd, Double perAdmitStart, Double perAdmitEnd, Double perEnrollStart, 
			  Double perEnrollEnd, Integer academicScaleStart, Integer academicScaleEnd, Integer socialScaleStart, Integer socialScaleEnd, Integer lifeScaleStart,
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
	  public void saveSchool(String schoolName){
		  this.userContr.saveSchool(schoolName);
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