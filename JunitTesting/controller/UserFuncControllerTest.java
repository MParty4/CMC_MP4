package controller;

import static org.junit.Assert.*;

import org.junit.Test;

import cmc.mario.controllers.DBController;
import cmc.mario.controllers.UserFuncController;
import cmc.mario.entities.User;

public class UserFuncControllerTest {
	private User user;
	private UserFuncController usrFC;
	private DBController dbc;
	
	public void Setup()
	{
		dbc.addUser(firstName, lastName, username, password, type);
		user = (User) dbc.getSpecificUser("whatever name of user we decide");
		usrFC = new UserFuncController(user);
	}

	@Test
	public void testUserFuncController() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewSavedSchools() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveSavedSchool() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearch() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewSearchResults() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewSpecificSchool() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewRecommendation() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveSchool() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewPersonalProfile() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditPersonalProfile() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetUser() {
		fail("Not yet implemented");
	}

}
