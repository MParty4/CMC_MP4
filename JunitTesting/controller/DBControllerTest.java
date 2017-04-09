package controller;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cmc.mario.controllers.DBController;
import cmc.mario.entities.Account;
import cmc.mario.entities.University;
import cmc.mario.entities.User;

public class DBControllerTest {
	private DBController dbc;
	
	@Before
	public void setUp(){
		dbc = new DBController();
	}
	
	@Test
	public void testDBControllerConstructor() {
		assertTrue("Admin Function Controller is set up", dbc!=null);
		assertTrue("Database library is set up", dbc.getUniversityLibrary()!=null);
	}

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
//	public void addUserSuccessfully(){
//		assertTrue("Add a account Successful", adm.addUser("Alice", "Guess", "auser", "user", 'u')==true);
//		List<Account> myarr = adm.viewAccount();
//		assertEquals("Alice",myarr.get(9).getFirstName());
//	}
//	@Test
//	public void addUserFailedForExistAccount(){
//		assertFalse("Add an excist account", adm.addUser("Alice", "Lynn", "auser", "user", 'u')==true);
//	}
	@Test
	public void addUserFailedForInvalidUsername(){
		assertFalse("Add an account with invalid username", dbc.addUser("Alice", "Lynn", "juser", "user", 'u')==true);
	}

	@Test
	public void testEditUser(){
		dbc.editUser("Amazing", "Zhang", "yuser", "user", 'u', 'Y');
		dbc.editUser("Jing", "Cool", "lur", "user", 'u', 'Y');
		Account a = dbc.getSpecificUser("yuser");
		assertEquals("Amazing", a.getFirstName());
		assertEquals("Zhang", a.getLastName());
		assertEquals("yuser", a.getUsername());
		assertEquals("user", a.getPassword());
		assertTrue("The type is user", a.getTypeOfUser()=='u');
		assertTrue("The status is active", a.getStatus()=='Y');
	}

	@Test
	public void testDeactivateUser() {
		Account a = dbc.getSpecificUser("lur");
		assertTrue("lur is active now",a.getStatus()=='Y');
		dbc.deactivateUser("lur");	
		assertTrue("lur is deactive now",dbc.getSpecificUser("lur").getStatus()=='N');
	}
		
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
	@Test
	public void testGetAccountList() {
		List<Account> myarr = dbc.getAccountList();
		Assert.assertNotNull("List should not be null", myarr);
		assertEquals("guser", myarr.get(0).getUsername());
		assertEquals("juser", myarr.get(1).getUsername());
		assertEquals("kadmin", myarr.get(2).getUsername());
		assertEquals("lur", myarr.get(3).getUsername());
		assertEquals("luser", myarr.get(4).getUsername());
		assertEquals("muser", myarr.get(5).getUsername());
		assertEquals("nadmin", myarr.get(6).getUsername());
	}

	@Test
	public void testGetSpecificUser() {
		Account a = dbc.getSpecificUser("juser");
		Assert.assertNotNull("Account should not be null", a);
		assertEquals("Yidan", a.getFirstName());
		assertEquals("Zhang", a.getLastName());
		assertEquals("juser", a.getUsername());
		assertEquals("user", a.getPassword());
		assertTrue("The type is user", a.getTypeOfUser()=='u');
		assertTrue("The status is active", a.getStatus()=='Y');
	}

	@Test
	public void testGetUniversities() {
		List<University> myarr = dbc.getUniversities();
		Assert.assertNotNull("List should not be null", myarr);
		assertTrue("List is not empty", !(myarr.isEmpty()));
		assertTrue("The fourth university in the list", myarr.get(3).getSchoolName().equals("AMERICAN UNIVERSITY OF BEIRUT"));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testViewSpecificSchool() {
		University u = dbc.viewSpecificSchool("BARNARD");
		Assert.assertNotNull("University should not be null", u);
		assertEquals("BARNARD", u.getSchoolName());
		assertEquals("URBAN", u.getLocation());
		assertEquals("NEW YORK", u.getState());
		assertEquals("PRIVATE", u.getControl());
		assertEquals(10000, u.getNumOfStu());
		assertEquals(100, u.getPerFem());
		assertEquals(630, u.getSatVerbal());
		assertEquals(610, u.getSatMath());
		assertEquals(31009, u.getPrice());
		assertEquals(60, u.getFinAid());
		assertEquals(4000, u.getNumOfApp());
		assertEquals(60, u.getPerAdmit());
		assertEquals(20, u.getPerEnroll());
		assertEquals((Object)4.0, u.getAcademicScale());
		assertEquals((Object)3.0, u.getSocialScale());
		assertEquals((Object)4.0, u.getLifeScale());
	}
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
