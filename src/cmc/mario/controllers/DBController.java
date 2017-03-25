package cmc.mario.controllers;
import dblibrary.project.csci230.*;
import java.util.*;

import cmc.mario.entities.Account;
import cmc.mario.entities.University;
import cmc.mario.entities.User;
/**
 * File: DBController.java
 * DBController - Database controller for CMC system. This controller connects to all classes.
 * @authors Mario Party 4 - Kalila Moua, Yidan Zhang, and Tre Vasquez 
 * @version March 19, 2017
 */
/**
 * @author y4zhang
 *
 */
public class DBController {
	
	/**
	 * Database library is been using
	 */
	private UniversityDBLibrary univLib;
  /**
   * create a new univeresityDBLibrary with user name and password
   */
  public DBController(){
    this.univLib = new UniversityDBLibrary("mariop4","mariop4","csci230");
  }
  
  /**
   * This method allows the user to edit their own personal profile information.
   * @param firstName the first name to change the old first name to 
   * @param lastName the last name to change the old last name to
   * @param password the password to change the old password to
   * @param username the user's userName
   * @throws IllegalArgumentException if account cannot be found
   */ 
  public void editPersonalProfile(String userName, String firstName, String lastName, String password){
	  Account x = this.getSpecificUser(userName);
	  if(x==null)
	  {
		  throw new IllegalArgumentException("Account is either invalid or is non-existant");
	  }
	  else
	  {
		  char type = x.getTypeOfUser();
		  char status = x.status;
		  univLib.user_editUser(userName, firstName, lastName, password, type, status);
	  }
  }


/**
 * This method adds the user into the database -admin only.
 * @param firstName first name to add
 * @param lastName last name to change
 * @param password the password to change the old password to
 * @param username the username of the account of new added user
 * @param type the character of which represents the type of user
 * @return true if add successfully
 */
public boolean addUser(String firstName, String lastName, String username, String password, char type){
	  Account a = this.getSpecificUser(username);
	  if(a.getUsername()!=null){
		  return false;
	  }
	  else{
		  int i;
		  if(type=='a'){
			i=  univLib.user_addUser(firstName, lastName, username, password, 'a');
		  }
		  else{
			i=  univLib.user_addUser(firstName, lastName, username, password, 'u');
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
   * @return true if edit successfully
   */
  public boolean editUser(String firstName, String lastName, String username, String password, char type, char status){
	  Account a = this.getSpecificUser(username);
	  if(a.getUsername()==null){
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
   * @param username the username of the user to be deleted
   * @return true if deactivate successfully
   */
  public boolean deactivateUser(String username){
	  Account a = this.getSpecificUser(username);
	  if(a.getUsername()==null||a.getStatus()=='N'){
		  throw new IllegalArgumentException("The account has already deactived or it does not exist");
	  }
	  a.setStatus('N');
	  return this.editUser(a.getFirstName(), a.getLastName(), a.getUsername(), a.getPassword(), a.getTypeOfUser(), a.getStatus());
	 
  }
  
  /**
   * This method add a specific university - admin only.
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
    * @return true if it successfully
   */
  public boolean addUniversity(String school, String state, String location, String control, int numberOfStudents, int percentFemales, int SATVerbal, int SATMath, 
		  int expenses, int percentFinancialAid, int numberOfApplicants, int percentAdmitted, int percentEnrolled, 
		  int academicsScale, int socialScale, int qualityOfLifeScale,String popMajors){
	  University u = this.viewSpecificSchool(school);
	  if(!(u==null)){
		  return false;
	  }
	  int i =univLib.university_addUniversity(school, state, location, control, 
			  numberOfStudents, percentFemales, SATVerbal, SATMath, expenses, percentFinancialAid, 
			  numberOfApplicants, percentAdmitted, percentEnrolled, academicsScale, socialScale, qualityOfLifeScale);
	  if(!(i==1)){
		  return false;
	  }
	  int j =univLib.university_addUniversityEmphasis(school, popMajors);
	  if(j!=1){
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
	  University u = this.viewSpecificSchool(school);
	  
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
	    String[][] userList =univLib.user_getUsers();
	    List<Account> userListConvert = new ArrayList<Account>();
	    for(String[] arr : userList){
	    	Account a = new Account(arr[0],arr[1],arr[2],arr[3],arr[4].charAt(0),arr[5].charAt(0));	
	    	userListConvert.add(a);
	    }
	    return userListConvert;
	  }

  
  /**
   * Gets a specific user.
   * @param username of the user need to view
   * @return user to return
   */
  public Account getSpecificUser(String username){
	  String[][] userList =univLib.user_getUsers();
	  Account a = new Account();
	  for(String[] arr : userList){
		  if(arr[2].equals(username)){
	    	a.setFirstName(arr[0]);
	    	a.setLastName(arr[1]);
	    	a.setUsername(arr[2]);
	    	a.setPassword(arr[3]);
	    	a.setTypeOfUser(arr[4].charAt(0));
	    	a.setStatus(arr[5].charAt(0));
	  }
	  }
	  return a;
  }
  
  /**
   * Get universities list.
   * @return list of universities in database.
   */
  public List<University> getUniversities(){
    String[][] univList =univLib.university_getUniversities();
    List<University> list = new ArrayList<University>();
    for(String[] schoolC : univList){
    	University u = new University(schoolC[0],schoolC[1],schoolC[2],schoolC[3],
				Integer.parseInt(schoolC[4]),Integer.parseInt(schoolC[5]),Integer.parseInt(schoolC[6]),Integer.parseInt(schoolC[7]),
				Integer.parseInt(schoolC[8]),Integer.parseInt(schoolC[9]),Integer.parseInt(schoolC[10]),Integer.parseInt(schoolC[11]),
				Integer.parseInt(schoolC[12]),Integer.parseInt(schoolC[13]),Integer.parseInt(schoolC[14]),Integer.parseInt(schoolC[15]), this.getEmphasesForUniversity(schoolC[0]));
		list.add(u);
    }
    return list;
  }
//  public List<String> getEmphasis(String schoolName){
//	  String[][] em = univLib.university_getNamesWithEmphases();
//	  String emph="";
//	  for(String[] school :em){
//		  if (school[0].equals(schoolName)){
//			  for(String s : school){
//				  emph = emph+s;
//			  }
//			 
//		  }
//	  }
//	  return emph;
//  } 
  /**
   * To view specific university.
   * @param university name
   * @return the university
   */
  public University viewSpecificSchool(String schoolName){
    String[][] univList =univLib.university_getUniversities();
    University u = new University();
    for(String[] arr: univList){
    	 if(arr[0].equals(schoolName)){
    	u.setSchoolName(arr[0]);
    	u.setState(arr[1]);
    	u.setLocation(arr[2]);
    	u.setControl(arr[3]);
    	u.setNumOfStu(Integer.parseInt(arr[4]));
    	u.setPerFem(Integer.parseInt(arr[5]));
    	u.setSatVerbal(Integer.parseInt(arr[6]));
    	u.setSatMath(Integer.parseInt(arr[7]));
    	u.setPrice(Integer.parseInt(arr[8]));
    	u.setFinAid(Integer.parseInt(arr[9]));
    	u.setNumOfApp(Integer.parseInt(arr[10]));
    	u.setPerAdmit(Integer.parseInt(arr[11]));
    	u.setPerEnroll(Integer.parseInt(arr[12]));
    	u.setAcademicScale(Integer.parseInt(arr[13]));
    	u.setSocialScale(Integer.parseInt(arr[14]));
    	u.setLifeScale(Integer.parseInt(arr[15]));
    	 }
    }
    return u;
  }
//  
//  /**
//   * Finds the specific university and returns it.
//   * @param schoolName of university
//   * @param state the state in which the university is in
//   * @param location to find the city of university
//   * @param control the type of control
//   * @param numOfStu number of students to find
//   * @param perFem percentage of female to find
//   * @param satVerbal sat verbal score to find
//   * @param satMath sat math score to find
//   * @param price expense to find
//   * @param finAid financial aid student can get from school to find
//   * @param numOfApp number of applicants to find
//   * @param perAdmit percentage of admit to find
//   * @param perEnroll percentage of enroll to find
//   * @param control control to find
//   * @param academicScale scale of academic to find
//   * @param socialScale scale of social to find
//   * @param lifeScale scale of life to find
//   * @param popMajor the emphases majors of this school to find
//   * @return university which needs to be found
//   */ 
//  public University findSpecificUniversity(String schoolName, String state, String location, String control, int numOfStu, double perFem, int satVerbal
//                      , int satMath, int price, int finAid, int numOfApp, double perAdmit, double perEnroll, int academicScale
//                                    , int socialScale, int lifeScale){
//	  return null;
//  }

  /**
   * Method to retrieve list of saved schools for a specified user
   * @param user the user whose saved schools are being retrieved
   * @return list of saved schools
   */
 
	  public List<University> getSavedSchools(String username) {
			// TODO Auto-generated method stub
			  String[][] userList =univLib.user_getUsernamesWithSavedSchools();
			  String[][] schoolList =univLib.university_getUniversities();
			  List<University> list = new ArrayList<University>();
			    for(String[] userC : userList){
			    	if(userC[0].equals(username)){
			    		for(String[] schoolC: schoolList){
			    			if(userC[1].equals(schoolC[0])){
			    				University u = new University(schoolC[0],schoolC[1],schoolC[2],schoolC[3],
			    						Integer.parseInt(schoolC[4]),Integer.parseInt(schoolC[5]),Integer.parseInt(schoolC[6]),Integer.parseInt(schoolC[7]),
			    						Integer.parseInt(schoolC[8]),Integer.parseInt(schoolC[9]),Integer.parseInt(schoolC[10]),Integer.parseInt(schoolC[11]),
			    						Integer.parseInt(schoolC[12]),Integer.parseInt(schoolC[13]),Integer.parseInt(schoolC[14]),Integer.parseInt(schoolC[15]),this.getEmphasesForUniversity(schoolC[0]));
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
   * @param schoolName the school object to be removed
   * @param school the name of the school to be removed
   * @throws NoSuchElementException if the user's saved list is empty
   */
  public void removeSavedSchool(User user, University schoolName) {
	// TODO Auto-generated method stub
	  List<University> userList =this.getSavedSchools(user.getUserName());
	  if(userList.isEmpty())
	  {
		  throw new NoSuchElementException("The User's saved list is empty, you cannot remove from an empty list");
	  }
	  for(University u: userList)
	  {
		  if(u.equals(schoolName))
		  { 
			  userList.remove(u);
		  }
	  }
	  
	  //univLib.user_removeSchool(user.getUsername(),schoolName.getSchoolName());
}
/**
 * method that will add a selected school to a specified user's saved school list
 * @param user user who will be adding to their list
 * @param schoolName name of school to be added to the saved school list
 */
public void addSavedSchool(User user, String schoolName) {
	String[][] schoolList =univLib.university_getUniversities();
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
	 * Method to get emphases for specific university - helper method
	 * @param universityName the name of university
	 * @return list of strings of emphases for university
	 */
	public List<String> getEmphasesForUniversity(String universityName){
		String[][] uni = univLib.university_getNamesWithEmphases();
		List<String> emphasesList = new ArrayList<String>();
		for(int i = 0; i < uni.length; i++){
			for(int j = 0; j <= 1; j++){
				if(uni[i][1] == null){
					return emphasesList;
				}
				else if(uni[i][0] == universityName){
					String emphasis = uni[i][1];
					emphasesList.add(emphasis);
				}
			}
		}
		return emphasesList;
	}
	
	/**
	 * Method to return a list of universities with attributes that fit in the criteria entered by user - Kalila
	 * @param schoolName
	 *            name of the school
	 * @param state
	 *            state of school
	 * @param location
	 *            location of school
	 * @param control
	 *            control of school
	 * @param numOfStu
	 *            number of students
	 * @param perFem
	 *            percentage of female
	 * @param satVerbal
	 *            sat verbal score
	 * @param satMath
	 *            sat math score
	 * @param price
	 *            expenses for university
	 * @param finAid
	 *            financial aid percentage 
	 * @param numOfApp
	 *            number of applicants
	 * @param perAdmit
	 *            percentage of admitted students
	 * @param perEnroll
	 *            percentage of enroll
	 * @param academicScale
	 *            scale of academic life
	 * @param socialScale
	 *            scale of social life
	 * @param lifeScale
	 *            scale of life quality
	 * @param popMajor
	 *            the list of emphases for a specific school
	 */

	public List<University> searchResults(String schoolName, String state, String location, String control, Integer numOfStuStart, Integer numOfStuEnd, 
			 Integer perFemStart,Integer perFemEnd, Integer satVerbalStart, Integer satVerbalEnd, Integer satMathStart, Integer satMathEnd, Integer priceStart, Integer priceEnd,
			 Integer finAidStart,Integer finAidEnd, Integer numOfAppStart, Integer numOfAppEnd, Integer perAdmitStart, Integer perAdmitEnd, Integer perEnrollStart, 
			 Integer perEnrollEnd, Integer academicScaleStart, Integer academicScaleEnd, Integer socialScaleStart, Integer socialScaleEnd, Integer lifeScaleStart,
			 Integer lifeScaleEnd, List<String> popMajor){
			List<University> listOfMatchingUniversities = new ArrayList<University>();
			List<University> results = new ArrayList<University>();
			String[][] univList = univLib.university_getUniversities();
			 for(String[] arr: univList){
//					University uni = new University(univList[i][0], univList[i][1], univList[i][2], univList[i][3], Integer.parseInt(univList[i][4]),
//					Integer.parseInt(univList[i][5]), Integer.parseInt(univList[i][6]), Integer.parseInt(univList[i][7]), Integer.parseInt(univList[i][8]), 
//					Integer.parseInt(univList[i][9]), Integer.parseInt(univList[i][10]), Integer.parseInt(univList[i][11]), Integer.parseInt(univList[i][12]),
//					Integer.parseInt(univList[i][13]), Integer.parseInt(univList[i][14]), Integer.parseInt(univList[i][15]), this.getEmphasesForUniversity(univList[i][0]));
					if((arr[0] .contains(schoolName)|| (schoolName == "")) 
							&& ((arr[1] .contains(state)) ||(state == "")) 
							&& ((arr[2] .contains(location)) ||(location == "")) 
							&& ((arr[3] .contains(control)) ||(control == "")) 
							&& (((numOfStuStart<=Integer.parseInt(arr[4]))&&(Integer.parseInt(arr[4])<= numOfStuEnd)) || numOfStuEnd==-1)
							&& (((perFemStart<=Integer.parseInt(arr[5]))&&(Integer.parseInt(arr[5])<= perFemEnd)) || perFemEnd==-1)
							&& (((satVerbalStart<=Integer.parseInt(arr[6]))&&(Integer.parseInt(arr[6])<= satVerbalEnd)) || satVerbalEnd==-1)
							&& (((satMathStart<=Integer.parseInt(arr[7]))&&(Integer.parseInt(arr[7])<= satMathEnd)) || satMathEnd==-1)
							&& (((priceStart<=Integer.parseInt(arr[8]))&&(Integer.parseInt(arr[8])<= priceEnd)) || priceEnd==-1)
							&& (((finAidStart<=Integer.parseInt(arr[9]))&&(Integer.parseInt(arr[9])<= finAidEnd)) || finAidEnd==-1)
							&&(((numOfAppStart<=Integer.parseInt(arr[10]))&&(Integer.parseInt(arr[10])<= numOfAppEnd)) || numOfAppEnd==-1)
							&& (((perAdmitStart<=Integer.parseInt(arr[11]))&&(Integer.parseInt(arr[11])<= perAdmitEnd)) || perAdmitEnd==-1)
							&&  (((perEnrollStart<=Integer.parseInt(arr[12]))&&(Integer.parseInt(arr[12])<= perEnrollEnd)) || perEnrollEnd==-1)
							&& (((academicScaleStart<=Integer.parseInt(arr[13]))&&(Integer.parseInt(arr[13])<= academicScaleEnd)) || academicScaleEnd==-1)
							&&  (((socialScaleStart<=Integer.parseInt(arr[14]))&&(Integer.parseInt(arr[14])<= socialScaleEnd)) || socialScaleEnd==-1)
							&& (((lifeScaleStart<=Integer.parseInt(arr[15]))&&(Integer.parseInt(arr[15])<= lifeScaleEnd)) || lifeScaleEnd==-1)
							){
			
						University u = new University(arr[0],arr[1],arr[2],arr[3],
	    						Integer.parseInt(arr[4]),Integer.parseInt(arr[5]),Integer.parseInt(arr[6]),Integer.parseInt(arr[7]),
	    						Integer.parseInt(arr[8]),Integer.parseInt(arr[9]),Integer.parseInt(arr[10]),Integer.parseInt(arr[11]),
	    						Integer.parseInt(arr[12]),Integer.parseInt(arr[13]),Integer.parseInt(arr[14]),Integer.parseInt(arr[15]),this.getEmphasesForUniversity(arr[0]));
						if(!listOfMatchingUniversities.contains(u))
							listOfMatchingUniversities.add(u); //if list does not have school then add to list
					}	
				}
			 System.out.println("r");
			 System.out.println(listOfMatchingUniversities);
			 System.out.println(listOfMatchingUniversities.size());
			 String s = "";
			 for(String t: popMajor){
				 s+= t+", ";
			 }
			 String[][] emphases = univLib.university_getNamesWithEmphases();
			 int i =0;
			 for(String[] em: emphases){
				 if(em[0].equals(listOfMatchingUniversities.get(i).getSchoolName())){
					 for(int j =1; j<em.length; j++){
						 if(s.contains(em[j])){
							 results.add(listOfMatchingUniversities.get(i));
						 }
						 i++;
					 }
				 }
			 }
			
			return results; // returns the list of matching universities with its attributes
		}
	
}
