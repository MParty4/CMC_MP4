package cmc.mario;
import cmc.mario.entities.*;
import cmc.mario.interfaces.*;
import cmc.mario.controllers.*;
import java.util.*;
/**
 * Test driver for all functionalities
 * @author Kalila Moua,  Tre Vazquez, Jing Thao, Yidan Zhang
 * @version 03/27/2017
 */
public class CMCDriver {
	private AccountUI acct;
	private UserUI usr;
	private AdminUI adm;
	private Scanner sc;
	/**
	 * 
	 */
	public CMCDriver() {
		acct = new AccountUI();
		sc= new Scanner(System.in);
	}
	
	/**
	 * Admin && User: run login method for U1:Log in
	 * get username and password from user and log in as admin or user
	 */
	public void login (){
		System.out.println("---------------------------------Log In (U1)--------------------------------------");
		sc= new Scanner(System.in);
		//get username from user
		System.out.println("Please enter your username:");
		String username = sc.nextLine();
		
		//get password from user
		System.out.println("Please enter your password:");
		String password = sc.nextLine();
		
		//call log on method
		int i =acct.logOn(username, password);
		
		//assign it to a user
		if(i==1){
			usr =(UserUI)acct;
			System.out.println("Functionalities: Search for Schools, Manage My Saved Schools, and Manage My Profile");
		}
		//assign it to a admin
		else if(i==0){
			adm=(AdminUI)acct;
			System.out.println("Functionalities: Manage Universities and Manage Users");
		}
		//not exist
		else{
			System.out.println(i);
		}
	}
	
	/**
	 * User: View save school list of a specific user for U2: View Saved Schools
	 */
	public void viewSaveSchools(){
		System.out.println("---------------------------------Saved School List (U2)--------------------------------------");
		List<University> un=usr.viewSavedSchools();
		for(University a1:un){
		System.out.println(a1.getSchoolName());
		}
	}
	
	/**
	 * User: remove a school the user saved before for U3: Remove School
	 */
	public void removeSchool(){
		System.out.println("---------------------------------Remove a School from save list (U3)--------------------------------------");
		sc= new Scanner(System.in);
		System.out.println("Which school you want to remove?");
		String schoolname = sc.nextLine();
		System.out.println("If it is removed? "+usr.removeSavedSchool(schoolname.toUpperCase()));
		System.out.println("Show Save School List After Removing" );
		this.viewSaveSchools();
	}
	
	/**
	 * User: View details of a school from save list for U4: View Saved School Details
	 */
	public void viewSavedDetails(){
		System.out.println("----------------------------------View a specific university from save list (U4)-----------------------------");
		sc= new Scanner(System.in);
		System.out.println("Which school you want to view?");
		String schoolname = sc.nextLine();
		University u = usr.viewSpecificSchool(schoolname.toUpperCase());
		List<String> info = usr.viewSearchResults(u);
		for(String s : info){
			System.out.print(s+" ");
		}
		System.out.println();
	}
	
	/**
	 * User: Search for Schools with different conditions for U5 and U6: Search for Schools and print them out with school names.
	 */
	public void search(){
		System.out.println("----------------------------------Search with conditions (U5 & U6)-----------------------------");
		 List<University> uni = usr.search("", "MINNE", "", "", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1.0, -1.0, -1.0,-1.0, 1.0, -1.0, new String[0]);
			for(University u : uni){
				System.out.println(u.getSchoolName());
			}
	}
	/**
	 * User: View Specific School with Recommendations for U7 and U8: View Specific School and view Recommendation
	 */
	public void recommendation(){
				System.out.println("----------------------------------Recommendation (U7 & U8)-----------------------------");
				sc= new Scanner(System.in);
				System.out.println("Which School you hope to view?");
				String schoolname = sc.nextLine();
				University uni5 = usr.viewSpecificSchool(schoolname.toUpperCase());
				List<University> list2 =usr.viewRecommendation(uni5);
				List<String> info = usr.viewSearchResults(uni5);
				for(String s : info){
					System.out.print(s+" ");
				}
				System.out.println();
				System.out.println("************Recommadation List*****************");
				for(int i = 0 ; i<5; i++){
					System.out.println("IN LIST: "+list2.get(i).getSchoolName()+"||"+ 
							"\n STUDENTS:"+list2.get(i).getNumOfStu()+
							" FEM:"+list2.get(i).getPerFem()+" SAT MATH:"+list2.get(i).getSatMath()+" SAT VERBAL:"+list2.get(i).getSatVerbal()+
							" PRICE:"+list2.get(i).getPrice()+" FINAID:"+list2.get(i).getFinAid()+" NUM APP:"+list2.get(i).getNumOfApp()+
							" ADMITTED:"+list2.get(i).getPerAdmit()+" ENROLLED:"+list2.get(i).getPerEnroll()+" ACADEMIC SCALE:"+list2.get(i).getAcademicScale()+
							" SOCIAL SCALE:"+list2.get(i).getSocialScale()+" LIFE SCALE"+list2.get(i).getLifeScale()
					);
					
				}
	}
	
	/**
	 * User: save a school the user like for U9: Save School
	 */
	public void saveSchool(){
		System.out.println("----------------------------------Save a school (U9)-----------------------------");
		sc= new Scanner(System.in);
		System.out.println("Which School you want to save?");
		String schoolname = sc.nextLine();
		System.out.println(usr.saveSchool(schoolname.toUpperCase()));
		System.out.println("Save School List After Saving");
		this.viewSaveSchools();
	}
	
	/**
	 * User: View personal profile for U10: View Personal Profile
	 */
	public void viewPersonalProfile(){
		System.out.println("----------------------------------View Personal Profile (U10)-----------------------------");
		Account u = usr.viewPersonalProfile();
		System.out.println(u.getFirstName()+" "+u.getLastName()+" "+u.getUsername()+" "+u.getPassword()+" "+u.getTypeOfUser());
	}
	/**
	 * User: Edit personal profile for U11: Edit Personal Profile
	 */
	public void editProfile(){
		System.out.println("----------------------------------Edit Personal Profile (U11)-----------------------------");
		System.out.println("Change to user to FirstName: John, LastName:Cool, Username: juser,Password: user");
		System.out.println(usr.editPersonalProfile("juser", "John", "Cool", "user"));
		System.out.println("View Personal Profile After Editing");
		this.viewPersonalProfile();
	}
	/**
	 * Admin: view all accounts for U12: View Users(View Accounts)
	 * print them out
	 */
	public void viewUsers(){
		List<Account> acctList = adm.viewAccount();
		System.out.println("-------------------------------------------Account Lists (U12)---------------------------------");
		System.out.println("First    Last   Username   Password   Type   Status");
		for(Account a:acctList){
			System.out.println(a.getFirstName()+"     "+a.getLastName()+"    "+a.getUsername()+"     "+a.getPassword()+"       "+a.getTypeOfUser()+
					"       "+a.getStatus());
		}
	}
	
	/**
	 * Admin: add a user to database for U13: Add User(Add Account) 
	 * 
	 */
	public void addUser(){
		System.out.println("--------------------------------------------Add a specific user (U13)---------------------------");
	//	System.out.println("Add an admin: First Name: Kalila, Last Name Kadmin, User Name: kadmin, Password: aduser", "user");
		adm.addUser("Jing", "Cool", "lur", "user", 'u');
		System.out.println("Show Accounts List After Adding");
		this.viewUsers();
	}
	/**
	 * Admin: view specific user profile for U14: View Specific User (Account)
	 * 
	 */
	public void viewSpecificUser(){
		System.out.println("--------------------------------------------View a specific account (U14)-------------------------");
		System.out.println("View profile of kadmin");
		Account a = adm.viewSpecificUser("kadmin");
		System.out.println(a.getFirstName()+" "+a.getLastName()+" "+a.getUsername()+" "+a.getPassword()+" "+a.getTypeOfUser()+
				" "+a.getStatus());
	}
	
	/**
	 * Admin: Edit an account for U15: Edit User
	 */
	public void editUser(){
		System.out.println("--------------------------------------------Edit a specific account (U15)------------------------------");
		System.out.println("Change Yidan Zhang Account to: First Name: Yidan, Last Name: yuser, User Name: yuser, Password: user, Type: u, Status: Y");
		System.out.println("If Successful?"+ adm.editUser("Yidan", "Zhang", "yuser", "user", 'u', 'Y'));
		System.out.println("Show Accounts List After Editing");
		this.viewUsers();
	}
	
	/**
	 * Admin: Deactivate a specific Account for U16: Deactivate User (Account)
	 */
	public void deactivateUser(){
		System.out.println("--------------------------------------------Deactivate a specific account (U16)------------------------");
		System.out.println("Deactivate: yuser");
		System.out.println(adm.deactivateUser("yuser"));
		System.out.println("Show Accounts List After Deactivating");
		this.viewUsers();
	}
	
	/**
	 * Admin: View all universities for U17: View Universities
	 */
	public void viewUniversities(){
		System.out.println("--------------------------------------------University List (U17)---------------------------------");
		List<University> univList = adm.viewUniversities();
		for(University a1:univList){
			System.out.println(a1.getSchoolName()+"     "+a1.getLocation()+"    "+a1.getState()+"     "+a1.getControl()+"      "+a1.getNumOfStu()+
					"       "+a1.getPerFem()+"   "+a1.getSatVerbal()+"   "+a1.getSatVerbal()+"   "+a1.getPrice()+"   "+a1.getFinAid()+"   "+a1.getNumOfApp()+
					"   "+a1.getPerAdmit()+"   "+a1.getPerEnroll()+"   "+a1.getAcademicScale()+"   "+a1.getSocialScale()+"   "+a1.getLifeScale());
		}
	}
	
	/**
	 * Admin: Add a specific university for U18: Add a university
	 */
	public void addUniversity(){
		System.out.println("--------------------------------------------Add A University (U18)---------------------------------");
		System.out.println("Add a Unviersity: School Name: AAAAA");
		System.out.println(adm.addUniversity("AAAAA", "BBBB", "CCC", "PRIVATE", 1000, 43, 400, 400, 12000, 23, 500, 30, 15, 2.5, 1.5, 2.0, new String[]{"ART-HISTORY","FINANCE"}));
		System.out.println("University List After Adding");
		this.viewUniversities();
	}
	/**
	 * Admin: View a specific university for U19: View specific University
	 */
	public void viewSpecificUniversity(){
		System.out.println("--------------------------------------------View a specific university (U19)------------------------");
		sc= new Scanner(System.in);
		University uni5 = adm.viewSpecificUniversity("ST JOHNS UNIVERSITY");
		List<String> info = adm.viewResults(uni5);
		for(String s : info){
			System.out.print(s+" ");
		}
		System.out.println();
		
	}
	/**
	 * Admin: Edit University for U20: Edit University
	 */
	public void editUniversity(){
		System.out.println("--------------------------------------------Edit A University (U20)---------------------------------");
		System.out.println("Edit the University, AAAAA: Edit Sat Verbal: 460 && Lift Scale: 3.0");
		System.out.println(adm.editUniversity("AAAAA", "BBBB", "CCC", "PRIVATE", 1000, 43, 460, 460, 12000, 23, 500, 30, 15, 2.5, 1.5, 3.0));
		System.out.println("University List After Editing");
		this.viewUniversities();
	}
	/**
	 * Admin && User: log off the account for U20: Log Off
	 */
	public void logOff(){
		System.out.println("---------------------------------Log Off (U21)----------------------------------");
		
		acct = (AccountUI) acct;
		System.out.println(acct.logOff());
		}
	
	public void run(){
		//First Time Login as a user
		this.login();
		this.viewSaveSchools();
		this.removeSchool();
		this.viewSavedDetails();
		this.search();
		this.recommendation();
		this.saveSchool();
		this.viewPersonalProfile();
		this.editProfile();
		this.logOff();
		//Second Time login as an admin
		this.login();
		this.viewUsers();
		this.addUser();
		this.viewSpecificUser();
		this.editUser();
		this.deactivateUser();
		this.viewUniversities();
		this.addUniversity();
		this.viewSpecificUniversity();
		this.editUniversity();
		this.logOff();
			
	}
	private char[] addUser(String string, String string2, String string3, char c) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args){
		CMCDriver cd = new CMCDriver();
		cd.run();
	}
}
