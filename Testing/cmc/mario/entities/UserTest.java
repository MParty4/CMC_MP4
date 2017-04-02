package cmc.mario.entities;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
private User user;

	@Before
	  public void setUp() throws Exception {
	    user = new User();
	    user.setFirstName("tree");
	    user.setLastName("mendous");
	    user.setUsername("t1mendous");
	    user.setPassword("look!@me");
	    user.setTypeOfUser('u');
	  }
	@Test
	public void testGetPassword() {
		String expResult = "look!@me";
		String result = user.getPassword();
		assertEquals("Password is " + expResult,expResult, result);
	}

	@Test
	public void testGetFirstName() {
		String expResult = "tree";
		String result = user.getUserName();
		assertEquals("Username is " + expResult,expResult, result);
	}

	@Test
	public void testGetLastName() {
		String expResult = "mendous";
		String result = user.getLastName();
		assertEquals("last name is " + expResult,expResult, result);		
	}

	@Test
	public void testGetUserName() {
		String expResult = "t1mendous";
		String result = user.getUserName();
		assertEquals("username is " + expResult,expResult, result);
	}

	@Test
	public void testGetType() {
		char expResult = 'u';
		char result = user.getType();
		assertEquals("Type is " + expResult,expResult, result);		
	}

}
