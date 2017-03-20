package cmc.mario.controllers;
/**
 * File: UserFuncController.java 
 * @author Tre Vazquez | Mario Party 4
 * @version March 18, 2017
 */

import java.util.*;

import cmc.mario.entities.University;
import cmc.mario.entities.User;

/** 
 * UserFuncController is an implementation for the UserUI and an extension
 * of the account controller
 * @author Tre Vazquez | Mario Party 4
 * @version 03/20/2017
 */

public class UserFuncController {
	/**
	 * user instance  
	 */
	private User user;
	
	/**
	 * database controller instance
	 */
	private DBController dbc;
	
	/**
	 * SeachController instance
	 */
	private SearchController sc;
	
	
  /*
   * Constructor of the class: Inherited from super class: AccountController
   * @param u the user object to be used 
   */
  public UserFuncController(User u){
    this.user = u;
    dbc = new DBController();
    sc = new SearchController();
  }
  
  /**
   * Displays list of the Users Saved Schools
   * @return list of saved schools
   */
  public List<University> viewSavedSchools()
  { 
    return this.dbc.getSavedSchools(this.user.getUserName());
  }
  
  /**
   * Removes desired school from the User's saved school list
   * @param schoolName the name of the school to be removed 
   */
  public void removeSavedSchool(University schoolName)
  {
    this.dbc.removeSavedSchool(this.user, schoolName);
  }
  
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
   return this.sc.search(schoolName, state,location,control, numOfStuStart, numOfStuEnd, perFemStart, perFemEnd, satVerbalStart, satVerbalEnd, satMathStart, 
		   
		   satMathEnd, priceStart, priceEnd, finAidStart, finAidEnd, numOfAppStart, numOfAppEnd, perAdmitStart, perAdmitEnd, perEnrollStart, 
		   perEnrollEnd, academicScaleStart, academicScaleEnd, socialScaleStart,socialScaleEnd, lifeScaleStart, lifeScaleEnd, popMajor);
  }
  
  /**
   * Displays a list of universities meeting the search criteria for the user. 
   * @return list of universities.
   */
  public List<String> viewSearchResults(University u) 
  {
    List<String> dis = new ArrayList<String>();
    
    dis.add(u.getSchoolName());
    dis.add(u.getState());
    dis.add(u.getLocation());
    dis.add(u.getControl());
    dis.add(Double.toString(u.getNumOfStu()));
    dis.add(Double.toString(u.getPerFem()));
    dis.add(Double.toString(u.getSatVerbal()));
    dis.add(Double.toString(u.getSatMath()));
    dis.add(Double.toString(u.getPrice()));
    dis.add(Double.toString(u.getFinAid()));
    dis.add(Double.toString(u.getNumOfApp()));
    dis.add(Double.toString(u.getPerAdmit()));
    dis.add(Double.toString(u.getPerEnroll()));
    dis.add(Integer.toString(u.getAcademicScale()));
    dis.add(Integer.toString(u.getSocialScale()));
    dis.add(Integer.toString(u.getLifeScale()));
    dis.addAll(u.getPopMajors());
    
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
   * displays recommendations based upon university being viewed by a user
   * @param u a university object to be used as criteria for recommendations
   * @return list of universities with partial info
   */
  public List<University> viewRecommendation(University u){
    return sc.viewRecommendation(u);
  }
  
  /**
   * Grants user the ability to save a school to their saved school lists
   * @param schoolName the name of the school to be saved 
   */
  public void saveSchool(String schoolName)
  {
    this.dbc.addSavedSchool(this.user, schoolName);
  }
  
  /**
   * displays the user profile to the user.
   * @return user object to preview user details
   */
  public User viewPersonalProfile()
  {
    return (User) this.dbc.getSpecificUser(this.user.getUserName()); 
  }
  
  /**
   * Grants user the ability to edit their personal profile
   * @param firstName the user's firstName
   * @param lastName the user's lastName
   * @param password the user's password
   */
  public void editPersonalProfile(String userName, String firstName, String lastName, String password)
  {
    this.dbc.editPersonalProfile(userName, firstName, lastName, password);
  }
}
