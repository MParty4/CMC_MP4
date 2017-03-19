package cmc.mario;
/*
 * File: SearchController.java
 */

import java.io.*;
import java.util.*;

/**
 * SearchController Class which helps search universities 
 * which meet the requirements from user extends userFuncController
 * 
 * @author Mario Party 4: Jing Thao 
 * @version Feb. 24, 2017
 */
public class SearchController extends UserFuncController {
  private DBController dbControl;
  /*
   * Constructor of the class: Inherited from super class: AccountController
   */
  public SearchController() {
    University fire = null;
  }
  /**
   * Searches for a school with the conditions given
   * 
   * @param schoolName the user gives   
   * @param state the user gives 
   * @param location the user gives 
   * @param control the user gives 
   * @param numOfStu the user gives 
   * @param perFem the user gives 
   * @param satVerbal the user gives 
   * @param satMath the user gives 
   * @param price the user gives 
   * @param finAid the user gives 
   * @param numOfApp the user gives 
   * @param perAdmit the user gives 
   * @param perEnroll the user gives 
   * @param control the user gives 
   * @param academicScale the user gives 
   * @param socialScale the user gives 
   * @param lifeScale the user gives 
   * @param popMajor the user gives 
   */
  public List<University> search(String schoolName, String state, String location, String control, int numOfStu, double perFem, int satVerbal
                       , int satMath, int price, int finAid, int numOfApp, double perAdmit, double perEnroll, int academicScale
                       , int socialScale, int lifeScale, String popMajor){
	  List<University> list = dbControl.getUniversities();
	  List<University> searchList = null;
	  while(!list.isEmpty()){                                           
		  
		  
	  }
	  
    return searchList;
  }
  /**
   * Gives a list of recommendations for the school that was chosen
   * 
   * @param u the university to be compared to.
   * @return A list of universities
   */
  @SuppressWarnings("null")
public List<University> viewRecommendation(University u){
	  List<University> uniList = dbControl.getUniversities();//dbControl.getUniversities();
	  List<University> uniRecommendList = new ArrayList<University>();
	  while (!(uniList.isEmpty())){
		  for(int i = 0; i < uniList.size(); i++ ){
			University uni = uniList.get(i); 
			
			if(uni.getSatMath() > u.getSatMath()-100 && uni.getSatMath() < u.getSatMath() +100){
				if(uni.getSatVerbal() > u.getSatVerbal()-100 && uni.getSatVerbal() < u.getSatVerbal() +100){
					if(uni.getLifeScale() > u.getLifeScale() -1 && uni.getLifeScale() <uni.getLifeScale() +1){
						if(uni.getSocialScale() > u.getSocialScale() -1 && uni.getSocialScale() <uni.getSocialScale() +1){
							if(uni.getAcademicScale() > u.getAcademicScale() -1 && uni.getAcademicScale() <uni.getAcademicScale() +1){
								
								uniRecommendList.add(uni);
							}
						}
					}
				
			
	
				}
			}
		  
    
		  
  
		  }
	  }
	return uniRecommendList;  
  }
}
