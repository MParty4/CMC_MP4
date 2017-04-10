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
import cmc.mario.interfaces.UserUI;

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

	@Test
	public void testEditPersonalProfile() {
		dbc.editPersonalProfile("yuser", "Amazing", "Zhang", "y4zhang");
		User u = dbc.getSpecificUser("yuser");
		assertEquals("y4zhang",u.getPassword());
	
	}


	@Test
	public void addUserSuccessfully(){
		assertTrue("Add a account Successful", dbc.addUser("Alice", "Guess", "auser", "user", 'u')==true);
		List<Account> myarr = dbc.getAccountList();
		assertEquals("Alice",myarr.get(9).getFirstName());
	}
	@Test
	public void addUserFailedForExistAccount(){
		assertFalse("Add an excist account", dbc.addUser("Alice", "Lynn", "auser", "user", 'u')==true);
	}
	@Test
	public void addUserFailedForInvalidUsername(){
		assertFalse("Add an account with invalid username", dbc.addUser("Alice", "Lynn", "juser", "user", 'u')==true);
	}

	@Test
	public void testEditUser(){
	//	dbc.editUser("Amazing", "Zhang", "yuser", "user", 'u', 'Y');
		dbc.editUser("Jing", "Cool", "lur", "user", 'u', 'Y');
		Account a = dbc.getSpecificUser("yuser");
		assertEquals("Amazing", a.getFirstName());
		assertEquals("Zhang", a.getLastName());
		assertEquals("yuser", a.getUsername());
		assertEquals("y4zhang", a.getPassword());
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
	@Test
	public void testDeactivateUserFailedNotExistName() {
		assertFalse("The account does not exist", dbc.deactivateUser("aaa")==true);
	}
	@Test
	public void testDeactivateUserFailedAlreadyDeactivat(){
		assertFalse("The account has already deactivate", dbc.deactivateUser("kadmin"));
	}

	@Test
	public void addUniversityTest(){
		assertTrue("Add Successfully", dbc.addUniversity("MMM", "NN", "PP", "QQ", -1, -1, -1, -1, -1, 10, -1, -1, -1, -1.0, -1.0, -1.0, new String[]{})==true);
		assertEquals("NN",dbc.viewSpecificSchool("MMM").getState());
	}
	@Test
	public void addUniversityFailedForExistSchool(){
		assertFalse("The school exists", dbc.addUniversity("MMM", "NN", "PP", "QQ", -1, -1, -1, -1, -1, 10, -1, -1, -1, -1.0, -1.0, -1.0, new String[]{})==true);
	}

	
		@Test
		public void EditUniversityTest(){
			dbc.editUniversity("MMM", "NN", "PP", "QQ", 10, 10, -1, -1, -1, 10, -1, -1, -1, -1.0, -1.0, -1.0);
			assertEquals(10, dbc.viewSpecificSchool("MMM").getNumOfStu());
		}
		@Test
		public void EditUniversityFailedNotExist(){
			assertFalse("The school does not exist", dbc.editUniversity("abc", "NN", "PP", "QQ", 10, 10, -1, -1, -1, 10, -1, -1, -1, -1.0, -1.0, -1.0));
		}
		
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

	@Test
	public void testAddSavedSchool() {
		assertTrue("save a school", dbc.addSavedSchool(dbc.getSpecificUser("tuser"), "UNIVERSITY OF MINNESOTA"));
	}
	
	@Test
	public void testGetSavedSchools() {
		assertTrue("Not empty", dbc.getSavedSchools(dbc.getSpecificUser("tuser").getUserName()).isEmpty());
	}


	@Test
	public void testRemoveSavedSchool() {
		assertTrue("save a school", dbc.removeSavedSchool(dbc.getSpecificUser("tuser"), "UNIVERSITY OF MINNESOTA"));
	}

	@Test
	public void testGetEmphasesForUniversity() {
		List<String> list = dbc.getEmphasesForUniversity("COLORADO SCHOOL OF MINES");
		for(int i =0 ; i< list.size();i++){
			//System.out.println(list.get(i));
		}
		assertTrue(list.get(0).equals("COCONUT"));
	}
	
	@Test
	public void testSetEmphasesForUniversity() {
		String[] list = {"HONEY","SUGAR","COCONUT"};
		dbc.setEmphasisForUniversity("COLORADO SCHOOL OF MINES", list);
		List<String> list2 = dbc.getEmphasesForUniversity("COLORADO SCHOOL OF MINES");
		for(int i =0 ; i< list2.size();i++){
			System.out.println(list2.get(i));
		}
		assertTrue(list2.get(0).equals("COCONUT"));
		assertTrue(list2.get(1).equals("ENGINEERING"));
		assertTrue(list2.get(2).equals("HONEY"));
		assertTrue(list2.get(3).equals("SUGAR"));
	
	}

}
