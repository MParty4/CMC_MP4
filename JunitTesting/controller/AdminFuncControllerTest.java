package controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cmc.mario.controllers.AdminFuncController;
import cmc.mario.entities.Account;
import cmc.mario.entities.Admin;
import cmc.mario.entities.University;

public class AdminFuncControllerTest {
	private AdminFuncController admf;
	private Admin adm;
	@Before
	public void setUp(){
		 adm = new Admin();
		admf = new AdminFuncController(adm);		
	}
	@Test
	public void testAdminFuncControllerAdmin() {
		assertTrue("Admin Function Controller is set up", admf!=null);
	}
//
//	@Test
//	public void testAdminFuncControllerAdminDBController() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testViewAccountIsNotEmpty() {
		assertTrue("Account List is not empty", (!(admf.viewAccount().isEmpty())));
	}
	@Test
	public void testViewAccountIsValid() {
		assertTrue("Account List is valid", !(admf.viewSpecificUser(admf.viewAccount().get(0).getUsername())==null));
	}
	
	
	@Test
	public void testAddUserSuccessful() {
		assertTrue("Add a account Successful", admf.addUser("Greg", "Lynn", "muser", "user", 'u')==true);
	}
	@Test
	public void testAddUserFailedForExistAccount() {
		assertTrue("Cannot add an existed account", admf.addUser("John", "Cool", "juser", "user", 'u')==false);
	}
	
	@Test
	public void testAddUserFailedWithInvalidUserName() {
		assertTrue("Cannot add an account with an existed username", admf.addUser("Grace", "Cool", "juser", "user", 'u')==false);
	}

	
	@Test
	public void testViewSpecificUserSuccessful() {
		assertTrue("View yuser account", admf.viewSpecificUser("yuser").getFirstName().equals("Yidan"));
	}
	@Test
	public void testViewSpecificUserFailedForInvalidUsername() {
		assertTrue("View zuser account which does not exist in databse", admf.viewSpecificUser("zuser").getFirstName()==null);
	}

	
	@Test
	public void testEditUser() {
		assertTrue("Edit Successfully",admf.editUser("Kalila", "Moua", "kadmin", "admin", 'a', 'Y')==true);
	}

	
	@Test
	public void testDeactivateUser() {
		assertTrue("Deactivate an excisted and active account", admf.deactivateUser("kadmin")==true);
	}
	@Test
	public void testDeactivateUserFailedForDeactiveAccount() {
		assertTrue("Deactivate an excisted but not active account", admf.deactivateUser("kadmin")==false);
	}
	@Test
	public void testDeactivateUserFailedForInvalidAccount() {
		assertTrue("Deactivate an account which does not exist", admf.deactivateUser("zadmin")==false);
	}
	
	
	@Test
	public void testViewUniversitiesIsNotEmpty() {
		assertTrue("University List is not empty", (!(admf.viewUniversities().isEmpty())));
	}
	@Test
	public void testViewUniversitiesIsValid() {
		assertTrue("University List is valid",(!(admf.viewUniversities().get(0).getSchoolName()==null)));
	}
	
	
	@Test
	public void testAddUniversity() {
		assertTrue("Add a University", admf.addUniversity("BB", "AA", "MAGIC", "PRIVATE", 100, 50, 100, 100, 200, 90, 200, 10, 10, 1.1, 2.1, 3.1, new String[]{"ART-HISTORY","FINANCE"})==true);
	}
	@Test
	public void testAddUniversityFailedForExisted() {
		assertTrue("Add a University", admf.addUniversity("AAAAA", "BBBB", "CCC", "PRIVATE", 1000, 43, 460, 460, 12000, 23, 500, 30, 15, 2.5, 1.5, 3.0, new String[]{"ART-HISTORY","FINANCE"})==false);
	}
		
	
	@Test
	public void testViewSpecificUniversity() {
		assertTrue("View University of Minnesota", admf.viewSpecificUniversity("UNIVERSITY OF MINNESOTA").getState().equals("MINNESOTA"));
	}
	@Test
	public void testViewSpecificUniversityFailedForInvaildName() {
		assertTrue("View university which does not exist", admf.viewSpecificUniversity("ZZZ").getState()==null);
	}	

	
	@Test
	public void testViewResults() {
		assertTrue("View Result", Integer.parseInt(admf.viewResults(new University("BB", "AA", "MAGIC", "PRIVATE", 100, 50, 100, 100, 200, 90, 200, 10, 10, 1.1, 2.1, 3.1)).get(4))==100);
	}

	@Test
	public void testEditUniversity() {
		assertTrue("Edit Successfullt",admf.editUniversity("AAAAA", "BBBB", "CCC", "PRIVATE", 1000, 43, 460, 460, 12000, 23, 500, 30, 15, 2.5, 1.5, 3.0)==true);
	}

	@Test
	public void testGetAdmin() {
		assertTrue("Get This Admin", admf.getAdmin()==adm);
	}

//	@Test
//	public void testSetAdmin() {
//		fail("Not yet implemented");
//	}

}
