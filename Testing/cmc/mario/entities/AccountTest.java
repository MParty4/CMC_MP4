package cmc.mario.entities;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.Test;
public class AccountTest {
	private Account acct, acct1;
	
	@Before
	public void setUp() throws Exception {
		String firstName = "Kalila";
		String lastName = "Moua";
		String username = "k1moua";
		String password = "k1moua";
		char type = 'u';
		char status = 'Y';
	    acct = new Account(firstName, lastName, username, password, type, status);
	    acct.setFirstName("Kalila");
	    acct.setLastName("Moua");
	    acct.setUsername("k1moua");
	    acct.setPassword("k1moua");
	    acct.setTypeOfUser('u');
	    acct.setStatus('Y');
	    acct.setActive(true);
	    acct1 = new Account();
	    acct1.setFirstName("null");
	    acct1.setLastName("null");
	    acct1.setUsername("null");
	    acct1.setPassword("null");
	  }
	
	@Test
	public void testAccountConstructor1() {
		String firstname = "null";
		String lastname = "null";
		String username = "null";
		String password = "null";
		String f = acct1.getFirstName();
		String l = acct1.getLastName();
		String u = acct1.getUsername();
		String p = acct1.getPassword();
		assertEquals(firstname, f);
		assertEquals(lastname, l);
		assertEquals(username, u);
		assertEquals(password, p);
	}
	
	@Test
	public void testAccountConstructor2() {
		String orgFirstName = "Kalila";
		String orgLastName = "Moua";
		String orgUsername =  "k1moua";
		String orgPassword = "k1moua";
		char type = 'u';
		char status = 'Y';
		String name = acct.getFirstName();
		String lastName = acct.getLastName();
		String username = acct.getUsername();
		String password = acct.getPassword();
		char t = acct.getTypeOfUser();
		char st = acct.getStatus();
		assertEquals(orgFirstName, name);
		assertEquals(orgLastName, lastName);
		assertEquals(orgUsername, username);
		assertEquals(orgPassword, password);
		assertEquals(type, t);
		assertEquals(status, st);
	}


	@Test
	public void testGetPassword() {
		String expResult = "k1moua";
		String result = acct.getPassword();
		assertEquals("Password is " + expResult,expResult, result);
	}

	@Test
	public void testGetUsername() {
		String expResult = "k1moua";
		String result = acct.getUsername();
		assertEquals("Username is " + expResult,expResult, result);
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
