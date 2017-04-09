/**
 * File: DBController.java
 */
package cmc.mario.controllers;
import dblibrary.project.csci230.*;
import java.util.*;
import cmc.mario.entities.Account;
import cmc.mario.entities.University;
import cmc.mario.entities.User;
/**
 * Database Controller to get data from DBLibrary for all controller
 * @author Kalila Moua, Tre Vazquez, Jing Thao, Yidan Zhang
 * @version 03/27/2017
 */
public class DBController {
	
	/**
	 * Database library is been using
	 */
	private UniversityDBLibrary univLib;
  /**
   * Create a new univeresityDBLibrary with user name and password
   */
  public DBController(){
    this.univLib = new UniversityDBLibrary("mariop4","mariop4","csci230");
  }
  
  public UniversityDBLibrary getUniversityLibrary(){
	  return this.univLib;
  }
  /**
   * This method allows the user to edit their own personal profile information. - Yidan 
   * @param firstName the first name to change the old first name to 
   * @param lastName the last name to change the old last name to
   * @param password the password to change the old password to
   * @param username the user's userName
   * @throws IllegalArgumentException if account cannot be found
   * @return true if edit successfully
   */ 
  public boolean editPersonalProfile(String userName, String firstName, String lastName, String password){ 
	  Account x = this.getSpecificUser(userName);
	  if(x==null)
	  {
		 return false;
	  }
	  else
	  {
		  char type = x.getTypeOfUser();
		  char status = x.getStatus();
		  
		  int i = univLib.user_editUser(userName, firstName, lastName, password, type, status);
		  if (i ==1)
			  {return true;}
	  }
	  return false;
  }


/**
 * This method adds the user into the database -admin only. - Tre
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
   * This method allows the admin to edit user information. - Kalila
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
   * @param username the username of the user to be deleted - Yidan
   * @throws IllegalArgumentException if the account has already deactivated or it does not exist
   * @return true if deactivate successfully
   */
  public boolean deactivateUser(String username){
	  Account a = this.getSpecificUser(username);
	  if(a.getFirstName()==null||a.getStatus()=='N'){
		  return false;
	  }
	  a.setStatus('N');
	  return this.editUser(a.getFirstName(), a.getLastName(), a.getUsername(), a.getPassword(), a.getTypeOfUser(), a.getStatus());
	 
  }
  
  /**
   * This method add a specific university - admin only. - Yidan
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
		  double academicsScale, double socialScale, double qualityOfLifeScale, String[] popMajors){
	  University u = this.viewSpecificSchool(school);
	  if(u.getSchoolName()!=null){
		  return false;
	  }
	  int i =univLib.university_addUniversity(school, state, location, control, 
			  numberOfStudents, percentFemales, SATVerbal, SATMath, expenses, percentFinancialAid, 
			  numberOfApplicants, percentAdmitted, percentEnrolled, (int)academicsScale, (int)socialScale, (int)qualityOfLifeScale);
	  if(!(i==1)){
		  return false;
		  
	  }
	  String pop ="";
	  for(int k=0; k<popMajors.length; k++){
		  pop +=popMajors[k]+", ";
	  }
	  System.out.println(pop);
	  int j =univLib.university_addUniversityEmphasis(school, pop);
	  if(j!=1){
		  System.out.println("e");
		  return false;
	  }
    return true;
  }
  
  /**
   * This method edits a specific university - admin only. - Yidan
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
    * @return true if edit successfully
   */
  public boolean editUniversity(String school, String state, String location, String control, int numberOfStudents, int percentFemales, int SATVerbal, int SATMath, 
		  int expenses, int percentFinancialAid, int numberOfApplicants, int percentAdmitted, int percentEnrolled, 
		  double academicsScale, double socialScale, double qualityOfLifeScale){
	  University u = this.viewSpecificSchool(school);
	  
	  if(u==null){
		  return false;
	  }
	  int i = univLib.university_editUniversity(school, state, location, control, 
			  numberOfStudents, percentFemales, SATVerbal, SATMath, expenses, percentFinancialAid, 
			  numberOfApplicants, percentAdmitted, percentEnrolled, (int)academicsScale, (int)socialScale, (int)qualityOfLifeScale);
	  if(!(i==1)){
		  return false;
	  }
	  return true;

  }
  
  /**
   * Gets the list of accounts. - Kalila
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
   * @param username of the user need to view - Yidan
   * @return account to return
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
   * @return list of universities in database. -Tre
   */
  public List<University> getUniversities(){
    String[][] univList =univLib.university_getUniversities();
    List<University> list = new ArrayList<University>();
    for(String[] schoolC : univList){
    	University u = new University(schoolC[0],schoolC[1],schoolC[2],schoolC[3],
				Integer.parseInt(schoolC[4]),Integer.parseInt(schoolC[5]),Integer.parseInt(schoolC[6]),Integer.parseInt(schoolC[7]),
				Integer.parseInt(schoolC[8]),Integer.parseInt(schoolC[9]),Integer.parseInt(schoolC[10]),Integer.parseInt(schoolC[11]),
				Integer.parseInt(schoolC[12]),Double.parseDouble(schoolC[13]),Double.parseDouble(schoolC[14]),Double.parseDouble(schoolC[15]));
		list.add(u);
    }
    return list;
  }

  /**
   * To view specific university. - Tre
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
	    	u.setAcademicScale(Double.parseDouble(arr[13]));
	    	u.setSocialScale(Double.parseDouble(arr[14]));
	    	u.setLifeScale(Double.parseDouble(arr[15]));
    	 }
    }
    return u;
  }

  /**
   * Method to retrieve list of saved schools for a specified user - Tre
   * @param user the user whose saved schools are being retrieved
   * @return list of saved schools
   */
 
	  public List<University> getSavedSchools(String username){
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
			    						Integer.parseInt(schoolC[12]),Double.parseDouble(schoolC[13]),Double.parseDouble(schoolC[14]),Double.parseDouble(schoolC[15]));
			    				list.add(u);
			    			}
			    		}
			    	}
			    } 
			    return list;
		
}

  /**
   * Method to remove a selected school from a user's saved school list - Tre
   * @param user the user who is removing a school from their list
   * @param schoolName the school object to be removed
   * @param school the name of the school to be removed
   * @throws NoSuchElementException if the user's saved list is empty
   * @return true if successfully
   */
	  public boolean removeSavedSchool(User user, String schoolName) { 
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
					  //userList.remove(u);
					  return true;
				  }
			  }
				int i = univLib.user_removeSchool(user.getUsername(),schoolName);
				//System.out.println(i);
				if(i==1){
					return true;
				}
				return false;
			  
			  //univLib.user_removeSchool(user.getUsername(),schoolName.getSchoolName());
		}
/**
 * Method that will add a selected school to a specified user's saved school list - JING
 * @param user user who will be adding to their list
 * @param schoolName name of school to be added to the saved school list
 * @return true add successfully
 */
	  public boolean addSavedSchool(User user, String schoolName) {
			List<University> list = this.getSavedSchools(user.getUsername());
			for(University u: list){
				if(u.getSchoolName().equals(schoolName)){
				return false;
				}
			}
			int i = univLib.user_saveSchool(user.getUsername(), schoolName);
			if(i==1){
				return true;
			}
			return false;
			
		}

	/**
	 * Method to get emphases for specific university - helper method - JING
	 * @param universityName the name of university
	 * @return list of strings of emphases for university
	 */
	public List<String> getEmphasesForUniversity(String universityName){
		String[][] uniE = univLib.university_getNamesWithEmphases();
		List<String> emphasesList = new ArrayList<String>();
		for(String[] em: uniE){
			if(em[0].equals(universityName)){
				for(int i =1; i<em.length; i++){
					emphasesList.add(em[i]);
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
	 * @return list of universities meet search conditions
	 */

	public List<University> searchResults(String schoolName, String state, String location, String control, int numOfStuStart, int numOfStuEnd, 
			 int perFemStart,int perFemEnd, int satVerbalStart, int satVerbalEnd, int satMathStart, int satMathEnd, int priceStart, int priceEnd,
			 int finAidStart,int finAidEnd, int numOfAppStart, int numOfAppEnd, int perAdmitStart, int perAdmitEnd, int perEnrollStart, 
			 int perEnrollEnd, double academicScaleStart, double academicScaleEnd, double socialScaleStart, double socialScaleEnd, double lifeScaleStart,
			 double lifeScaleEnd, String[] popMajor){
			List<University> results = new ArrayList<University>();
			String[][] univList = univLib.university_getUniversities();
			List<University> resultT = new ArrayList<University>();

			 for(String[] arr: univList){
				 if((arr[0].contains(schoolName)|| (schoolName == "")) 
							&& ((arr[1] .contains(state)) ||(state == "")) 
							&& ((arr[2] .contains(location)) ||(location == "")) 
							&& ((arr[3] .contains(control)) ||(control == "")) 
							&& (((numOfStuStart<=Integer.parseInt(arr[4]))&&(Integer.parseInt(arr[4])<= numOfStuEnd)) || ((numOfStuStart<=Integer.parseInt(arr[4]))&&(numOfStuEnd==-1))||((numOfStuStart==-1)&&(Integer.parseInt(arr[4])<= numOfStuEnd))||((numOfStuStart==-1)&&(numOfStuEnd==-1)))
							&& (((perFemStart<=Integer.parseInt(arr[5]))&&(Integer.parseInt(arr[5])<= perFemEnd)) || ((perFemStart<=Integer.parseInt(arr[5]))&&(perFemEnd==-1))||((perFemStart==-1)&&(Integer.parseInt(arr[5])<= perFemEnd))||((perFemStart==-1)&&(perFemEnd==-1)))
							&& (((satVerbalStart<=Integer.parseInt(arr[6]))&&(Integer.parseInt(arr[6])<= satVerbalEnd)) || ((satVerbalStart<=Integer.parseInt(arr[6]))&&(satVerbalEnd==-1))||((satVerbalStart==-1)&&(Integer.parseInt(arr[6])<= satVerbalEnd))||((satVerbalStart==-1)&&(satVerbalEnd==-1)))
							&& (((satMathStart<=Integer.parseInt(arr[7]))&&(Integer.parseInt(arr[7])<= satMathEnd)) || ((satMathStart<=Integer.parseInt(arr[7]))&&(satMathEnd==-1))||((satMathStart==-1)&&(Integer.parseInt(arr[7])<= satMathEnd))||((satMathStart==-1)&&(satMathEnd==-1)))
							&& (((priceStart<=Integer.parseInt(arr[8]))&&(Integer.parseInt(arr[8])<= priceEnd)) ||((priceStart<=Integer.parseInt(arr[8]))&&(priceEnd==-1))||((priceStart==-1)&&(Integer.parseInt(arr[8])<= priceEnd))||((priceStart==-1)&&(priceEnd==-1)))
							&& (((finAidStart<=Integer.parseInt(arr[9]))&&(Integer.parseInt(arr[9])<= finAidEnd)) || ((finAidStart<=Integer.parseInt(arr[9]))&&( finAidEnd==-1))||((finAidStart==-1)&&(Integer.parseInt(arr[9])<= finAidEnd))||((finAidStart==-1)&&(finAidEnd==-1)))
							&& (((numOfAppStart<=Integer.parseInt(arr[10]))&&(Integer.parseInt(arr[10])<= numOfAppEnd)) || ((numOfAppStart<=Integer.parseInt(arr[10]))&&(numOfAppEnd==-1))||((numOfAppStart==-1)&&(Integer.parseInt(arr[10])<= numOfAppEnd))||((numOfAppStart==-1)&&(numOfAppEnd==-1)))
							&& (((perAdmitStart<=Integer.parseInt(arr[11]))&&(Integer.parseInt(arr[11])<= perAdmitEnd)) || ((perAdmitStart<=Integer.parseInt(arr[11]))&&(perAdmitEnd==-1))||((perAdmitStart==-1)&&(Integer.parseInt(arr[11])<= perAdmitEnd))||((perAdmitStart==-1)&&(perAdmitEnd==-1)))
							&& (((perEnrollStart<=Integer.parseInt(arr[12]))&&(Integer.parseInt(arr[12])<= perEnrollEnd)) || ((perEnrollStart<=Integer.parseInt(arr[12]))&&(perEnrollEnd==-1))||((perEnrollStart==-1)&&(Integer.parseInt(arr[12])<= perEnrollEnd))||((perEnrollStart==-1)&&(perEnrollEnd==-1)))
							&& (((academicScaleStart<=Double.parseDouble(arr[13]))&&(Double.parseDouble(arr[13])<= academicScaleEnd)) || ((academicScaleStart<=Double.parseDouble(arr[13]))&&(academicScaleEnd==-1))||((academicScaleStart==-1)&&(Double.parseDouble(arr[13])<= academicScaleEnd))||((academicScaleStart==-1)&&(academicScaleEnd==-1)))
							&& (((socialScaleStart<=Double.parseDouble(arr[14]))&&(Integer.parseInt(arr[14])<= socialScaleEnd)) || ((socialScaleStart<=Double.parseDouble(arr[14]))&&(socialScaleEnd==-1))||((socialScaleStart==-1)&&(Integer.parseInt(arr[14])<= socialScaleEnd))||((socialScaleStart==-1)&&(socialScaleEnd==-1)))
							&& (((lifeScaleStart<=Double.parseDouble(arr[15]))&&(Integer.parseInt(arr[15])<= lifeScaleEnd)) || ((lifeScaleStart<=Double.parseDouble(arr[15]))&&(lifeScaleEnd==-1))||((lifeScaleStart==-1)&&(Integer.parseInt(arr[15])<= lifeScaleEnd))||((lifeScaleStart==-1)&&(Integer.parseInt(arr[15])<= lifeScaleEnd))||((lifeScaleStart==-1)&&(lifeScaleEnd==-1)))
							){
			
						University u = new University(arr[0],arr[1],arr[2],arr[3],
	    						Integer.parseInt(arr[4]),Integer.parseInt(arr[5]),Integer.parseInt(arr[6]),Integer.parseInt(arr[7]),
	    						Integer.parseInt(arr[8]),Integer.parseInt(arr[9]),Integer.parseInt(arr[10]),Integer.parseInt(arr[11]),
	    						Integer.parseInt(arr[12]),Double.parseDouble(arr[13]),Double.parseDouble(arr[14]),Double.parseDouble(arr[15]));
						if(!resultT.contains(u))
							resultT.add(u); //if list does not have school then add to list
					}	
				}
			 
			 String[][] emphases = univLib.university_getNamesWithEmphases();
			 if(popMajor.length==0){
				 return resultT;
			 }
				for(String[] em : emphases){
					for(int i =0;i<resultT.size();i++){
					if(em[0].equals(resultT.get(i).getSchoolName())){
						for(int j =1; j<em.length; j++){
							for(String s:popMajor){
							 if(em[j].equals(s)){
								 if(!results.contains(resultT.get(i)))
										results.add(resultT.get(i)); 
							 }
							}
					}
					}
				}
			}
			
			System.out.println(results);
			return results; // returns the list of matching universities with its attributes
		}
	
}
