
/*
 * File: DBController.java
 */
package cmc.mario;
import dblibrary.project.csci230.*;
import java.io.*;
import java.util.*;
/**
 * DBController - Database controller for CMC system. This controller connects to all classes.
 * @authors Mario Party 4 - Kalila Moua, Yidan Zhang
 * @version 3/19/2017
 */
public class DBController {
	
	private UniversityDBLibrary univLib;
  
  public DBController(){
    this.univLib = new UniversityDBLibrary("mariop4","mariop4","csci230");
  }
  
  /**
   * This method allows the user to edit their own personal profile information.
   * @param firstName the first name to change the old first name to 
   * @param lastName the last name to change the old last name to
   * @param password the password to change the old password to
   */ 
  public void editPersonalProfile(String firstName, String lastName, String password){
  
  }

  /**
   * This method adds the user into the database -admin only.
   * @param password the password to change the old password to
   * @param username the username of the account of new added user
   * @param type the character of which represents the type of user
   */
  public boolean addUser(String firstName, String lastName, String username, String password, char type){
	  Account a = this.getSpecificUser(username);
	  
	  if(!(a==null)){
		  return false;
	  }
	  else{
		  int i;
		  if(type=='a'){
			i=  univLib.user_addUser(firstName, lastName, username, password, 'a');
		  }
		  else{
			i=  univLib.user_addUser(firstName, lastName, username, password, 'a');
		  }
		  if(!(i==1)){
			  return false;
		  }
		  return true;
	  }
  }
  
  /**
   * This method allows the admin to edit user information.
   * @param firstName the first name to change the old first name to
   * @param lastName the last name to change the old last name to
   * @param password the password to change the old password to
   * @param type the character of which represents the type of user
   * @param status the status of the user, if active or not
   */
  public boolean editUser(String firstName, String lastName, String username, String password, char type, char status){
	  Account a = this.getSpecificUser(username);
	  if(a==null){
		  return false;
	  }
	  int i = univLib.user_editUser(username, firstName, lastName, password, type, status);
	  if(!(i==1)){
		  return false;
	  }
	  return true;
  }
  
  /**
   * To deactivate user-admin only.
   */
  public void deactivateUser(String username){
  
  }
  
  /**
   * To add university to database.
   * @param u the university to add
   * 
   * @return true if add successfully
   */ 
  public boolean addUniversity(String school, String state, String location, String control, int numberOfStudents, int percentFemales, int SATVerbal, int SATMath, 
		  int expenses, int percentFinancialAid, int numberOfApplicants, int percentAdmitted, int percentEnrolled, 
		  int academicsScale, int socialScale, int qualityOfLifeScale){
	  University u = this.findSpecificUniversity(school, state, location, control, numberOfStudents, percentFemales, SATVerbal, SATMath, 
			  expenses, percentFinancialAid, numberOfApplicants, percentAdmitted, percentEnrolled, 
			  academicsScale, socialScale, qualityOfLifeScale);
	  
	  if(!(u==null)){
		  return false;
	  }
	  int i = univLib.university_addUniversity(school, state, location, control, 
			  numberOfStudents, percentFemales, SATVerbal, SATMath, expenses, percentFinancialAid, 
			  numberOfApplicants, percentAdmitted, percentEnrolled, academicsScale, socialScale, qualityOfLifeScale);
	  if(!(i==1)){
		  return false;
	  }
    return true;
  }
  
  /**
   * This method edits a specific university - admin only.
    * @param schoolName university to update
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
   */
  public boolean editUniversity(String school, String state, String location, String control, int numOfStu, int perFem, int satVerbal
                       , int satMath, int price, int finAid, int numOfApp, int perAdmit, int perEnroll, int academicScale
                       , int socialScale, int lifeScale){
	  University u = this.findSpecificUniversity(school, state, location, control, numOfStu, perFem, satVerbal, satMath, 
			  price, finAid, numOfApp, perAdmit, perEnroll, 
			  academicScale, socialScale, lifeScale);
	  
	  if(u==null){
		  return false;
	  }
	  int i = univLib.university_editUniversity(school, state, location, control, numOfStu, perFem, satVerbal, satMath, 
			  price, finAid, numOfApp, perAdmit, perEnroll, academicScale, socialScale, lifeScale);
	  if(!(i==1)){
		  return false;
	  }
	  return true;

  }
  
  /**
   * Gets the list of accounts.
   * @return returns a list accounts
   */
  public List<Account> getAccountList(){
	    String[][] userList = univLib.user_getUsers();
	    List<Account> userListConvert = new ArrayList<Account>();
	    for(String[] arr : userList){
	    	Account a = new Account(arr[0],arr[1],arr[2],arr[3],arr[4].charAt(0),arr[5].charAt(0));	
	    	userListConvert.add(a);
	    }
	    return userListConvert;
	  }

  
  /**
   * Gets a specific user.
   * @return user to return
   */
  public User getSpecificUser(String username){
    return null;
  }
  
  /**
   * Get universities list.
   * @return list of universities in database.
   */
  public List<University> getUniversities(){
    String[][] univList = univLib.university_getUniversities();
    List<University> list = new ArrayList<University>();
    for(String[] schoolC : univList){
    	University u = new University(schoolC[0],schoolC[1],schoolC[2],schoolC[3],
				Integer.parseInt(schoolC[4]),Integer.parseInt(schoolC[5]),Integer.parseInt(schoolC[6]),Integer.parseInt(schoolC[7]),
				Integer.parseInt(schoolC[8]),Integer.parseInt(schoolC[9]),Integer.parseInt(schoolC[10]),Integer.parseInt(schoolC[11]),
				Integer.parseInt(schoolC[12]),Integer.parseInt(schoolC[13]),Integer.parseInt(schoolC[14]),Integer.parseInt(schoolC[15]));
		list.add(u);
    }
    return list;
  }
  
  /**
   * To view specific university.
   * @param university name
   * @return the university
   */
  public University viewSpecificSchool(String schoolName){
    return null;
  }
  
  /**
   * Finds the specific university and returns it.
   * @param schoolName of university
   * @param state the state in which the university is in
   * @param location to find the city of university
   * @param control the type of control
   * @param numOfStu number of students to find
   * @param perFem percentage of female to find
   * @param satVerbal sat verbal score to find
   * @param satMath sat math score to find
   * @param price expense to find
   * @param finAid financial aid student can get from school to find
   * @param numOfApp number of applicants to find
   * @param perAdmit percentage of admit to find
   * @param perEnroll percentage of enroll to find
   * @param control control to find
   * @param academicScale scale of academic to find
   * @param socialScale scale of social to find
   * @param lifeScale scale of life to find
   * @param popMajor the emphases majors of this school to find
   * @return university which needs to be found
   */ 
  public University findSpecificUniversity(String schoolName, String state, String location, String control, int numOfStu, double perFem, int satVerbal
                      , int satMath, int price, int finAid, int numOfApp, double perAdmit, double perEnroll, int academicScale
                                    , int socialScale, int lifeScale){
    return null;
  }

  /**
   * Method to retrieve list of saved schools for a specified user
   * @param user the user whose saved schools are being retrieved
   * @return list of saved schools
   */
 
	  public List<University> getSavedSchools(String username) {
			// TODO Auto-generated method stub
			  String[][] userList = univLib.user_getUsernamesWithSavedSchools();
			  String[][] schoolList = univLib.university_getUniversities();
			  List<University> list = new ArrayList<University>();
			    for(String[] userC : userList){
			    	if(userC[0].equals(username)){
			    		for(String[] schoolC: schoolList){
			    			if(userC[1].equals(schoolC[0])){
			    				University u = new University(schoolC[0],schoolC[1],schoolC[2],schoolC[3],
			    						Integer.parseInt(schoolC[4]),Integer.parseInt(schoolC[5]),Integer.parseInt(schoolC[6]),Integer.parseInt(schoolC[7]),
			    						Integer.parseInt(schoolC[8]),Integer.parseInt(schoolC[9]),Integer.parseInt(schoolC[10]),Integer.parseInt(schoolC[11]),
			    						Integer.parseInt(schoolC[12]),Integer.parseInt(schoolC[13]),Integer.parseInt(schoolC[14]),Integer.parseInt(schoolC[15]));
			    				list.add(u);
			    			}
			    		}
			    	}
			    } 
			    return list;
		
}

  /**
   * method to remove a selected school from a user's saved school list
   * @param user the user who is removing a school from their list
   * @param schoolName the name of the school to be removed
   */
  public void removeSavedSchool(User user, String schoolName) {
	// TODO Auto-generated method stub
	  String[][] userList = univLib.user_getUsernamesWithSavedSchools();
	  for(String[] myUser: userList)
	  {
		  if()
	  }
	
}
/**
 * method that will add a selected school to a specified user's saved school list
 * @param user user who will be adding to their list
 * @param schoolName name of school to be added to the saved school list
 */
public void addSavedSchool(User user, String schoolName) {
	String[][] schoolList = univLib.university_getUniversities();
	String saveS="";
	for(String[] schoolC: schoolList){
		if(schoolC[0].equals(schoolName)){
			saveS=saveS+schoolC[0]+
			schoolC[1] +
			schoolC[2] +
			schoolC[3] +
			schoolC[4] +
			schoolC[5] +
			schoolC[6] +
			schoolC[7] +
			schoolC[8] +
			schoolC[9] +
			schoolC[10] +
			schoolC[11] +
			schoolC[12] +
			schoolC[13] +
			schoolC[14] +
			schoolC[15];
		}
		}
	univLib.user_saveSchool(user.getUsername(), saveS);
	
}

	/**
	 * Method to return a list of universities that fit in the criteria entered by user
	 * @param 
	 */
	public List<University> searchResults(String schoolName, String state, String location, String control, int numOfStuStart, int numOfStuEnd, 
		  double perFemStart,double perFemEnd, int satVerbalStart, int satVerbalEnd, int satMathStart, int satMathEnd, int priceStart, int priceEnd,
		  int finAidStart,int finAidEnd, int numOfAppStart, int numOfAppEnd, double perAdmitStart, double perAdmitEnd, double perEnrollStart, 
		  double perEnrollEnd, int academicScaleStart, int academicScaleEnd, int socialScaleStart, int socialScaleEnd, int lifeScaleStart,
		  int lifeScaleEnd, String[] popMajor){
		List<University> listOfMatchingUniversities = new ArrayList<University>();
		String[][] univList = univLib.university_getUniversities();
		for(int i = 0; i < univList.length; i++){
			for(int j = 0; j < univList.length; j++){
				if(univList[i][j].contains(schoolName)){
					listOfMatchingUniversities.addAll(i);
				}
			}
		}
		return listOfMatchingUniversities;
		
	}
	

}
