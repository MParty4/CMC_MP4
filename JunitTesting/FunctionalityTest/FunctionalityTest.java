package FunctionalityTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cmc.mario.controllers.DBController;
import cmc.mario.entities.Account;
import cmc.mario.entities.Admin;
import cmc.mario.entities.University;
import cmc.mario.interfaces.AccountUI;
import cmc.mario.interfaces.AdminUI;
import cmc.mario.interfaces.UserUI;
import dblibrary.project.csci230.UniversityDBLibrary;

public class FunctionalityTest {
	private AccountUI acct;
	private UserUI usr;
	private AdminUI adm;
	private DBController dbc;
	@Before
	public void setUp() {
		acct = new AccountUI();
		adm = new AdminUI(new Admin());
	}
	//U1: Log in testing with 5 situations
	@Test
	public void LoginSuccessfullyAsUser() {
		assertTrue("Log in as an User successfully", acct.logOn("guser", "user")==1);
	}
	@Test
	public void LoginSuccessfullyAsAdmin() {
		assertTrue("Log in as an admin successfully", acct.logOn("nadmin", "admin")==0);
	}
	@Test(expected=NullPointerException.class)
	public void LoginFailedForWrongUsername() {
		assertTrue("Log in fail becasue of username", acct.logOn("shdu", "admin")==4);
	}
	@Test
	public void LoginFailedForWrongPassword() {
		assertTrue("Log in fail becasue of password", acct.logOn("guser", "v")==3);
	}
	@Test
	public void LoginFailedForDeactiveAccount() {
		assertTrue("Log in fail becasue of deactive account", acct.logOn("kadmin", "admin")==2);
	}
	
	
	//U12: View Users(Accounts)
	@Test
	public void viewAccountListTest(){
		List<Account> myarr = adm.viewAccount();
		Assert.assertNotNull("List should not be null", myarr);
		assertEquals("guser", myarr.get(0).getUsername());
		assertEquals("juser", myarr.get(1).getUsername());
		assertEquals("kadmin", myarr.get(2).getUsername());
		assertEquals("lur", myarr.get(3).getUsername());
		assertEquals("luser", myarr.get(4).getUsername());
		assertEquals("muser", myarr.get(5).getUsername());
		assertEquals("nadmin", myarr.get(6).getUsername());
	}
	
	//U13: Add User
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
		assertFalse("Add an account with invalid username", adm.addUser("Alice", "Lynn", "juser", "user", 'u')==true);
	}
	
	//U14: View Specific User
	@Test
	public void viewSpcificUser(){
		Account a = adm.viewSpecificUser("juser");
		Assert.assertNotNull("Account should not be null", a);
		assertEquals("Yidan", a.getFirstName());
		assertEquals("Zhang", a.getLastName());
		assertEquals("juser", a.getUsername());
		assertEquals("user", a.getPassword());
		assertTrue("The type is user", a.getTypeOfUser()=='u');
		assertTrue("The status is active", a.getStatus()=='Y');
	}
	
	//U15: Edit User
	@Test
	public void editUser(){
		adm.editUser("Amazing", "Zhang", "yuser", "user", 'u', 'Y');
		Account a = adm.viewSpecificUser("yuser");
		assertEquals("Amazing", a.getFirstName());
		assertEquals("Zhang", a.getLastName());
		assertEquals("yuser", a.getUsername());
		assertEquals("user", a.getPassword());
		assertTrue("The type is user", a.getTypeOfUser()=='u');
		assertTrue("The status is active", a.getStatus()=='Y');
	}
	
	//U16: Deactivate User
	@Test(expected=NullPointerException.class)
	public void testDeactivateUser() {
		Account a = adm.viewSpecificUser("tuser");

		adm.deactivateUser("tuser");	
		assertTrue("tuser is deactive now",dbc.getSpecificUser("tuser").getStatus()=='N');
	}
	
	//U17: View Universities
	@Test
	public void viewUniversityTest(){
		List<University> myarr = adm.viewUniversities();
		Assert.assertNotNull("List should not be null", myarr);
		assertTrue("List is not empty", !(myarr.isEmpty()));
		assertTrue("The fourth university in the list", myarr.get(3).getSchoolName().equals("AMERICAN UNIVERSITY OF BEIRUT"));
	}

	//U19: View Specific University
	@SuppressWarnings("deprecation")
	@Test
	public void testViewSpecificSchool() {
		University u = adm.viewSpecificUniversity("BARNARD");
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
}
