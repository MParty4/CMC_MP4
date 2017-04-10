package controller;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cmc.mario.controllers.DBController;
import cmc.mario.controllers.UserFuncController;
import cmc.mario.entities.Account;
import cmc.mario.entities.University;
import cmc.mario.entities.User;

public class UserFuncControllerTest {
	private User usr,usr2;
	private UserFuncController usrFC;
	private DBController dbc;
	
	@Before
	public void Setup()
	{
		dbc = new DBController();
		usr = new User("Jtest", "Jdummy", "Jtdummy", "Jtdummy");
		usr2 = new User("Jtezt", "Jdummy", "JTdummy", "Jtdummy");
		usrFC = new UserFuncController(usr);
		dbc.addUser(usr.getFirstName(), usr.getLastName(), usr.getUserName(), usr.getPassword(), usr.getType());
	}

	@Test
	public void testUserFuncController() {
		assertTrue("user Function Controller is set up", usrFC != null);
	}
	
	@Test
	public void testSaveSchool() {
		//assertFalse("user should have succesfully saved a school", usrFC.saveSchool("UNIVERSITY OF MINNESOTA"));
		assertFalse("user should not have succesfully saved a school", usrFC.saveSchool("UNIVERSITY OF CHICAGO"));
	}

	@Test
	public void testViewSavedSchools() {
		assertTrue("user saved list should have some schools", (!(usrFC.viewSavedSchools().isEmpty())));
	}

	@Test
	public void testRemoveSavedSchool() {
		assertTrue("only university of chicago should be left on the list", usrFC.removeSavedSchool("UNIVERSITY OF MINNESOTA"));
	}

	@Test
	public void testSearch() {
		assertTrue("user should have a search result list", !(usrFC.search("", "MINNE", "", "", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1.0, -1.0, -1.0,-1.0, 1.0, -1.0, new String[0]).isEmpty()));
	}

	@Test
	public void testViewSearchResults() {
		assertTrue("user should have a search result list for a university",  Integer.parseInt(usrFC.viewSearchResults(new University("BB", "AA", "MAGIC", "PRIVATE", 100, 50, 100, 100, 200, 90, 200, 10, 10, 1.1, 2.1, 3.1)).get(4))==100);
	}

	@Test
	public void testViewSpecificSchool() {
		assertTrue("View University of Minnesota", usrFC.viewSpecificSchool("UNIVERSITY OF MINNESOTA").getState().equals("MINNESOTA"));
		}
		@Test
		public void testViewSpecificSchoolFailedForInvaildName() {
			assertTrue("View university which does not exist", usrFC.viewSpecificSchool("ZZZ").getState()==null);
		}

	@Test
	public void testViewRecommendation() {
		assertTrue("View Recommendations", !usrFC.viewRecommendation(dbc.viewSpecificSchool("UNIVERSITY OF MINNESOTA")).isEmpty());
	}

	@Test
	public void testViewPersonalProfile() {
		assertTrue("USER PROFILE SHOULD BE RETURNED", usrFC.viewPersonalProfile()!=null);
	}

	@Test
	public void testEditPersonalProfile() {
		assertTrue("profile should be edited", usrFC.editPersonalProfile("Jtdummy", "Jtest", "Jdummy", "Jtd")== true);
	}

	@Test
	public void testGetUser() {
		assertTrue("should get a user", usrFC.getUser().equals(usr));
	}

//	@Test
//	public void testSetUser() {
//		assertTrue("should edit a user", usrFC.setUser(usr2));
//	}

}
