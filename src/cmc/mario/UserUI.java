package cmc.mario;
/*
 * File: UserUI.java
 */

import java.io.*;
import java.util.*;

/** 
 * UserUI is an class for Users
 * 
 * @author Tre Vazquez | Mario Party 4
 * @version February 25, 2017
 */

public class UserUI extends AccountUI{ 
	public UserFuncController userContr;
  /*
   * Constructor of the class: Inherited from super class: AccountUI
   */
  public UserUI(){
    super();
  }
  
  /**
   * Displays list of the Users Saved Schools
   * @return list of saved schools
   */
  public List<String> viewSavedSchools(){
    return this.userContr.viewSavedSchools().;
  }
  
  /**
   * Removes desired school from the User's saved school list
   * @param schoolName the name of the school to be removed 
   */ 
  public void removeSavedSchool(String schoolName){
	  this.userContr.removeSavedSchool(schoolName);
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
   * @param academicScale which is scale of acedmic of searching condition
   * @param socialScale which is scale of social of searching condition
   * @param lifeScale which is scale of life of searching condition
   * @param popMajor which is the emphases majors of this school of searching condition
   * @return list of schools matching search
   */ 
  public void search(String schoolName, String state, String location, String control, int numOfStu, double perFem, int satVerbal
                       , int satMath, int price, int finAid, int numOfApp, double perAdmit, double perEnroll, int academicScale
                       , int socialScale, int lifeScale, String popMajor){
    this.userContr.search(schoolName, state, location, control, numOfStu, perFem, satVerbal, satMath, price, finAid, numOfApp, perAdmit, perEnroll, academicScale, socialScale, lifeScale, popMajor);
  }
  
  /**
   * Displays a list of universities meeting the search criteria for the user. 
   * @return list of universities.
   */
  public List<University> viewSearchResults(){
  return this.userContr.viewSearchResults();
  }
  
  /**
   * Displays specific school selected to user.
   * @return university object containing university details
   */
  public University viewSpecificSchool(){
  return this.userContr.viewSpecificSchool();
  }
  
  /**
   * Displays 5 different schools as reccomendations to a user viewing 
   * a specific school
   * @param u the university object used as criteria for reccomendtions
   * @return list of universities to be previewed as reccomendations
   */
  public List<University> viewRecommendation(University u){
    return this.userContr.viewReccomendation(u);
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
  public void editPersonalProfile(String firstName, String lastName, String password){
	  this.userContr.editPersonalProfile(firstName, lastName, password);
  }
}