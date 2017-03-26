package cmc.mario;
import cmc.mario.entities.*;
import cmc.mario.interfaces.*;
import cmc.mario.controllers.*;
import java.util.*;
/**
 * Test driver for all functionalities
 * @author Kalila Moua,  Tre Vazquez, Jing Thao, Yidan Zhang
 * @version 03/25/2017
 */
public class CMCDriver {
	private AccountUI acct;
	private UserUI usr;
	private AdminUI adm;
	/**
	 * @param acct
	 */
	public CMCDriver() {
		acct = new AccountUI();
	//	adm = new AdminUI();

		usr = new UserUI (new User("John", "User","juser","user"));

	

	}
	/**
	 * Admin && User: run login method for U1:Log in
	 * get username and password from user and log in as admin or user
	 */
	public void login (){
		System.out.println("---------------------------------Log In--------------------------------------");
		Scanner sc = new Scanner(System.in);
		
		//get username from user
		System.out.println("Please enter your username:");
		String username = sc.next();
		
		//get password from user
		System.out.println("Please enter your password:");
		String password = sc.next();
		
		//call log on method
		acct=acct.logOn(username, password);
		
		//assign it to a user
		if(acct instanceof UserUI){
			usr =(UserUI)acct;
		}
		//assign it to a admin
		else if(acct instanceof AdminUI){
			adm=(AdminUI)acct;
		}
		//not exist
		else{
			throw new IllegalArgumentException("The acct does  not exist");
		}
	}
	
	public void logOff(){
		System.out.println("---------------------------------Log Off--------------------------------------");
		
		acct = (AccountUI) acct;
		System.out.println(acct.logOff());

		}
	
	/**
	 * Admin: view all accounts for U12: View Users(View Accounts)
	 * print them out
	 */
	public void viewUsers(){
		List<Account> acctList = adm.viewAccount();
		System.out.println("-------------------------------------------Account Lists------------------------------------------------");
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
		System.out.println("--------------------------------------------Add a specific user--------------------------------------------");
		System.out.println("Add an admin: First Name: Kalila, Last Name Kadmin, User Name: kadmin, Password: admin, Type: a");
	//	System.out.println("If Successful? "+adm.addUser("Kalila", "kadmin", "kadmin", "admin", 'a'));
		System.out.println("Show Accounts List After Adding");
		this.viewUsers();
		System.out.println("Add an user: First Name: Tre, Last Name tuser, User Name: tuser, Password: user, u");
	//	System.out.println(adm.addUser("Tre", "tuser", "tuser", "user", 'u'));
		System.out.println("Show Accounts List After Adding");
		this.viewUsers();
	}
	/**
	 * Admin: view specific user profile for U14: View Specific User (Account)
	 * 
	 */
	public void viewSpecificUser(){
		System.out.println("--------------------------------------------View a specific account--------------------------------------------");
		System.out.println("View profile of kadmin");
		Account a = adm.viewSpecificUser("kadmin");
		System.out.println(a.getFirstName()+" "+a.getLastName()+" "+a.getUsername()+" "+a.getPassword()+" "+a.getTypeOfUser()+
				" "+a.getStatus());
	}
	
	/**
	 * Admin: Edit an account for U15
	 */
	public void editUser(){
		System.out.println("--------------------------------------------Edit a specific account--------------------------------------------");
		System.out.println("Change Yidan Zhang Account to: First Name: Yidan, Last Name: yuser, User Name: yuser, Password: user, Type: u, Status: Y");
	//	System.out.println("If Successful?"+ adm.editUser("Yidan", "yuser", "yuser", "user", 'u', 'Y'));
		System.out.println("Show Accounts List After Editing");
		this.viewUsers();
	}
	
	/**
	 * Admin: Deactivate a specific Account for U16: Deactivate User (Account)
	 */
	public void deactivateUser(){
		System.out.println("--------------------------------------------Deactivate a specific account--------------------------------------------");
		System.out.println("Deactivate: yuser");
		System.out.println(adm.deactivateUser("yuser"));
		System.out.println("Show Accounts List After Deactivating");
		this.viewUsers();
	}
	
	/**
	 * Admin: View all universities for U17: View Universities
	 */
	public void viewUniversities(){
		System.out.println("--------------------------------------------University List--------------------------------------------");
		List<University> univList = adm.viewUniversities();
		System.out.println("University Lists");
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
		
	}
	/**
	 * Admin: View a specific university for U19: View specific University
	 */
	public void viewSpecificUniversity(){
		System.out.println("--------------------------------------------View a specific university--------------------------------------------");
		University u = adm.viewSpecificUniversity("ST JOHNS UNIVERSITY");
		System.out.println(u.getSchoolName()+"     "+u.getLocation()+"    "+u.getState()+"     "+u.getControl()+"      "+u.getNumOfStu()+
				"       "+u.getPerFem()+"   "+u.getSatVerbal()+"   "+u.getSatVerbal()+"   "+u.getPrice()+"   "+u.getFinAid()+"   "+u.getNumOfApp()+
				"   "+u.getPerAdmit()+"   "+u.getPerEnroll()+"   "+u.getAcademicScale()+"   "+u.getSocialScale()+"   "+u.getLifeScale());
		
	}
	/**
	 * Admin: Edit University for U20: Edit University
	 */
	public void editUniversity(){
		
	}
	public void run() throws NullPointerException{
		this.logOff();
	//  Use case U2 and U9 Save school and view saved school
			System.out.println("START OF ADD SAVED SCHOOL U9" + "\n" + "**************************************");
			System.out.println(usr.saveSchool("BOSTON COLLEGE"));
			System.out.println(usr.saveSchool("AUGSBURG"));
			System.out.println(usr.saveSchool("BARD"));
			System.out.println("END OF ADD SAVED SCHOOL U9" + "\n" + "**************************************"+ "\n");
			
			System.out.println("START OF VIEW SAVED SCHOOL U2" + "\n" + "**************************************" );
			System.out.println("Should display Boston , augsburg, and bard"+ "\n");
			List<University> un=usr.viewSavedSchools();
			for(University a1:un){
			System.out.println(a1.getSchoolName()+"     "+a1.getLocation()+"    "+a1.getState()+"     "+a1.getControl()+"      "+a1.getNumOfStu()+
					"       "+a1.getPerFem()+"   "+a1.getSatVerbal()+"   "+a1.getSatVerbal()+"   "+a1.getPrice()+"   "+a1.getFinAid()+"   "+a1.getNumOfApp()+
					"   "+a1.getPerAdmit()+"   "+a1.getPerEnroll()+"   "+a1.getAcademicScale()+"   "+a1.getSocialScale()+"   "+a1.getLifeScale());
		}
			System.out.println("END OF VIEW SAVED SCHOOL U2" + "\n" + "**************************************"+ "\n" );
//		Use case U3 remove saved school		
			System.out.println("START OF REMOVE SAVED SCHOOL U3" + "\n" + "**************************************" );
			System.out.println("Should only display Boston and Bard"+ "\n");
			System.out.println(usr.removeSavedSchool("AUGSBURG"));
			List<University> uno=usr.viewSavedSchools();
			for(University a1:uno){
			System.out.println(a1.getSchoolName()+"     "+a1.getLocation()+"    "+a1.getState()+"     "+a1.getControl()+"      "+a1.getNumOfStu()+
					"       "+a1.getPerFem()+"   "+a1.getSatVerbal()+"   "+a1.getSatVerbal()+"   "+a1.getPrice()+"   "+a1.getFinAid()+"   "+a1.getNumOfApp()+
					"   "+a1.getPerAdmit()+"   "+a1.getPerEnroll()+"   "+a1.getAcademicScale()+"   "+a1.getSocialScale()+"   "+a1.getLifeScale());
			
			}
			System.out.println("END OF REMOVE SAVED SCHOOL U3" + "\n" + "**************************************" );
	// USE CASE U10 EDIT PERSONAL PROFILE
			System.out.println("START OF EDIT PROFILE U" + "\n" + "**************************************" );
			System.out.println(usr.viewPersonalProfile().getLastName());
			System.out.println(usr.editPersonalProfile("juser", "John", "Diller", "user"));
			System.out.println(usr.viewPersonalProfile().getLastName());
		
			System.out.println("END OF EDIT PROFILE U" + "\n" + "**************************************" );
		
//////		Recommendation --Jing
System.out.println("START OF RECOMMENDATION CLASS");
List<University> uniList = new ArrayList<University>();
//String[] popMajors;
SearchController seCon = new SearchController();
//String m1 = "Biology";
//String m2 = "Computer Science";
//popMajors[0]=(m1);
//popMajors[1]=(m2);
University uni1 = new University("ABILENE CHRISTIAN UNIVERSITY","TEXAS","SUBURBAN","PRIVATE",
10000, 50 , -1,-1 ,12088, 70 ,4000,90 , 80 , 2.0,3.0,3.0);
University uni2 = new University("AUBURN","NEW YORK","SMALL-CITY","STATE",35000
,21,480,545,12468,50,5500,90,60,2.0,4.0,4.0);
University uni3 = new University("ARIZONA STATE","ARIZONA","-1","STATE",40000
,59,450,500,16181,50,17000,80,60,3.0,4.0,5.0);
University uni4 = new University("BARD","NEW YORK","SMALL-CITY","PRIVATE",10000,55
,560,520,32239,80,4000,70,30,3.0,4.0,4.0);
University uni5 = new University("AUGSBURG","MINNESOTA","SMALL-CITY","PRIVATE",10000
,43,420,490,29991,80,4000,85,50,1,3,4);
University uni6 = new University("BARNARD","NEW YORK","URBAN","PRIVATE",10000
,100,630,610,31009,60,4000,60,20,4,3,4);
University uni7 = new University("BAYLOR UNIVERSITY", "TEXAS","URBAN","PRIVATE",15000
,55,485,521,21658,65,11500,65,75,4,4,3);

////		uniList.add(bitch1);
////		uniList.add(bitch2);
////		uniList.add(bitch3);
////		uniList.add(bitch4);
////		uniList.add(bitch5);
////		uniList.add(bitch6);
		List<University> list2 =seCon.viewRecommendation(uni5);
		System.out.println("START UNIVERSITY: "+uni5.getSchoolName()+"||"+ 
				"\n STUDENTS:"+uni5.getNumOfStu()+
			" FEM:"+uni5.getPerFem()+" SAT MATH:"+uni5.getSatMath()+" SAT VERBAL:"+uni5.getSatVerbal()+
				" PRICE:"+uni5.getPrice()+" FINAID:"+uni5.getFinAid()+" NUM APP:"+uni5.getNumOfApp()+
				" ADMITTED:"+uni5.getPerAdmit()+" ENROLLED:"+uni5.getPerEnroll()+" ACADEMIC SCALE:"+uni5.getAcademicScale()+
				" SOCIAL SCALE:"+uni5.getSocialScale()+" LIFE SCALE"+uni5.getLifeScale()
		);
		for(int i = 0 ; i<5; i++){
			System.out.println("IN LIST: "+list2.get(i).getSchoolName()+"||"+ 
					"\n STUDENTS:"+list2.get(i).getNumOfStu()+
					" FEM:"+list2.get(i).getPerFem()+" SAT MATH:"+list2.get(i).getSatMath()+" SAT VERBAL:"+list2.get(i).getSatVerbal()+
					" PRICE:"+list2.get(i).getPrice()+" FINAID:"+list2.get(i).getFinAid()+" NUM APP:"+list2.get(i).getNumOfApp()+
					" ADMITTED:"+list2.get(i).getPerAdmit()+" ENROLLED:"+list2.get(i).getPerEnroll()+" ACADEMIC SCALE:"+list2.get(i).getAcademicScale()+
					" SOCIAL SCALE:"+list2.get(i).getSocialScale()+" LIFE SCALE"+list2.get(i).getLifeScale()
			);
			
		}
		

		System.out.println("END OF RECOMMENDATION CLASS");
			
		
		

		
	    List<University> uni = usr.search("", "", "", "", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1.2, 4.5, -1.0,-1.0, 1.0, -1.0, new String[0]);
		for(University u : uni){
			System.out.println(u.getSchoolName());
		}
	}
	private char[] addUser(String string, String string2, String string3, char c) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args)throws NullPointerException{
		CMCDriver cd = new CMCDriver();
		cd.run();
	}
}
