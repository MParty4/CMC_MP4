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
  
  /*
   * Constructor of the class: Inherited from super class: AccountController
   */
  public SearchController() {
    super();
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
  public void search(String schoolName, String state, String location, String control, int numOfStu, double perFem, int satVerbal
                       , int satMath, int price, int finAid, int numOfApp, double perAdmit, double perEnroll, int academicScale
                       , int socialScale, int lifeScale, String popMajor){
    
  }
  /**
   * Gives a list of recommendations for the school that was chosen
   * 
   * @param u the university to be compared to.
   * @return A list of universities
   */
  public List<University> viewRecommendation(University u){
    return null;
  }
}
