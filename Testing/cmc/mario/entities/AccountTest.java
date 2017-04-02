package cmc.mario.entities;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.Test;
public class AccountTest {
	private Account acct;
	
	@Before
	public void setUp() throws Exception {
	    acct = new Account();
	    acct.setActive(true);
	    acct.setTypeOfUser('u');
	    acct.setStatus('Y');
	    acct.setPassword("look!@me");
	    acct.setTypeOfUser('u');
	    acct.setFirstName("kalila");
	    acct.setLastName("moua");
	    acct.setUsername("k1moua");
	  }
	@Before
	public void testAccountConstructor1() {
		String orgFirstName = acct.firstName = null;
		String orgLastName = acct.lastName = null;
		String orgUsername = acct.username = null;
		String orgPassword = acct.password = null;
		String name = acct.getFirstName();
		String lastName = acct.getLastName();
		String username = acct.getUsername();
		String password = acct.getPassword();
		assertEquals(orgFirstName, name);
		assertEquals(orgLastName, lastName);
		assertEquals(orgUsername, username);
		assertEquals(orgPassword, password);
	}

	@Test
	public void testAccountConstructor2() {
		
	}

	@Test
	public void testGetPassword() {
		String expResult = "look!@me";
		String result = acct.getPassword();
		assertEquals("Password is " + expResult,expResult, result);
	}

	@Test
	public void testGetUsername() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFirstName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLastName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTypeOfUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetStatus() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsActive() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetActive() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetTypeOfUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetStatus() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPassword() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetFirstName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetLastName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetUsername() {
		fail("Not yet implemented");
	}

}
