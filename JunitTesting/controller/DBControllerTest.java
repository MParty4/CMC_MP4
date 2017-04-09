package controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cmc.mario.controllers.DBController;
import cmc.mario.entities.Account;
import cmc.mario.entities.User;

public class DBControllerTest {
	private DBController dbc;
	
	@Before
	public void setUp(){
		dbc = new DBController();
	}
	
//	@Test
//	public void testDBController() {
//		
//	}
//
//	@Test
//	public void testEditPersonalProfile() {
////		String password = "yzhang";
////		User u = dbc.getSpecificUser("yuser");
////		dbc.editPersonalProfile("yuser", "Yidan", "Zhang", password);
////		String newpass = u.getPassword();
////		assertEquals("password after editing should be "+password, password, newpass);
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testAddUser() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testEditUser(){
		Account acct = new Account();
		String firstName = "Yidannnn";
		String lastName = "Zhang";
		String username = "yzhang";
		String password = "yzhang";
		char type = 'u';
		char status = 'Y';
		assertTrue("User's first name is edited: ", dbc.editUser(firstName, lastName, username, password, type, status)==false);
	}

//	@Test
//	public void testDeactivateUser() {
////		User u = dbc.getSpecificUser("yuser");
////		dbc.deactivateUser("yuser")
////		String status = u.getStatus();
////		assertTrue("status after editing should be N"+password,'N'== status);
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testAddUniversity() {
//		
//	}
//
//	@Test
//	public void testEditUniversity() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetAccountList() {
//		fail("Not yet implemented");
//		//Kalila
//	}
//
//	@Test
//	public void testGetSpecificUser() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetUniversities() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testViewSpecificSchool() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetSavedSchools() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testRemoveSavedSchool() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testAddSavedSchool() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetEmphasesForUniversity() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSearchResults() {
//		fail("Not yet implemented"); /kalila
//	}

}
