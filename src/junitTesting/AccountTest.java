package junitTesting;

import static org.junit.Assert.*;


import org.junit.Test;

import cmc.mario.entities.Account;

import org.junit.Before;

public class AccountTest {
	private Account acct1, acct2;
	
	@Before
	public void setUp() throws Exception {
		String firstName = "Kalila";
		String lastName = "Moua";
		String username = "k1moua";
		String password = "k1moua";
		char type = 'u';
		char status = 'Y';
	    acct2 = new Account(firstName, lastName, username, password, type, status);
	    acct2.setFirstName("Kalila");
	    acct2.setLastName("Moua");
	    acct2.setUsername("k1moua");
	    acct2.setPassword("k1moua");
	    acct2.setTypeOfUser('u');
	    acct2.setStatus('Y');
	    acct2.setActive(true);
	    acct1 = new Account();
	    acct1.setFirstName("A");
	    acct1.setLastName("A");
	    acct1.setUsername("A");
	    acct1.setPassword("A");
	    acct1.setTypeOfUser('a');
	    acct1.setStatus('N');
	    acct1.setActive(false);
	  }
	
	@Test
	public void testAccountConstructor1() {
		String firstname = "A";
		String lastname = "A";
		String username = "A";
		String password = "A";
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
		String name = acct2.getFirstName();
		String lastName = acct2.getLastName();
		String username = acct2.getUsername();
		String password = acct2.getPassword();
		char t = acct2.getTypeOfUser();
		char st = acct2.getStatus();
		assertEquals(orgFirstName, name);
		assertEquals(orgLastName, lastName);
		assertEquals(orgUsername, username);
		assertEquals(orgPassword, password);
		assertEquals(type, t);
		assertEquals(status, st);
	}


	@Test
	public void testGetPassword() {
		String expResult = "A";
		String expResult2 = "k1moua";
		String result1 = acct1.getPassword();
		String result2 = acct2.getPassword();
		assertEquals("Password for constructor 1 is " + expResult,expResult, result1);
		assertEquals("Password for constructor 2 is " + expResult,expResult2, result2);
	}

	@Test
	public void testGetUsername() {
		String expResult = "A";
		String expResult2 = "k1moua";
		String result1 = acct1.getUsername();
		String result2 = acct2.getUsername();
		assertEquals("Username for constructor 1 is " + expResult,expResult, result1);
		assertEquals("Username for constructor 2 is " + expResult,expResult2, result2);
	}

	@Test
	public void testGetFirstName() {
		String expResult = "A";
		String expResult2 = "Kalila";
		String result1 = acct1.getFirstName();
		String result2 = acct2.getFirstName();
		assertEquals("First name for constructor 1 is " + expResult,expResult, result1);
		assertEquals("First name  for constructor 2 is " + expResult,expResult2, result2);
	}

	@Test
	public void testGetLastName() {
		String expResult = "A";
		String expResult2 = "Moua";
		String result1 = acct1.getLastName();
		String result2 = acct2.getLastName();
		assertEquals("Last name for constructor 1 is " + expResult,expResult, result1);
		assertEquals("Last name for constructor 2 is " + expResult,expResult2, result2);
	}

	@Test
	public void testGetTypeOfUser() {
		char expResult = 'a';
		char expResult2 = 'u';
		char result1 = acct1.getTypeOfUser();
		char result2 = acct2.getTypeOfUser();
		assertEquals("Type of user for constructor 1 is " + expResult,expResult, result1);
		assertEquals("Type of user for constructor 2 is " + expResult,expResult2, result2);
	}

	@Test
	public void testGetStatus() {
		char expResult = 'Y';
		char expResult2 = 'N';
		char result1 = acct1.getStatus();
		char result2 = acct2.getStatus();
		assertEquals("Status for constructor 1 is " + expResult,expResult, result1);
		assertEquals("Status for constructor 2 is " + expResult,expResult2, result2);
	}

	@Test
	public void testIsActive() {
		boolean expResult =  false;
		boolean expResult2 = true;
		boolean result1 = acct1.isActive();
		boolean result2 = acct2.isActive();
		assertEquals("Status for constructor 1 is " + expResult,expResult, result1);
		assertEquals("Status for constructor 2 is " + expResult,expResult2, result2);
	}

	@Test
	public void testSetActive() {
		 acct1.setLastName("A");
		 acct1.setUsername("A");
		 acct1.setPassword("A");
		 acct1.setTypeOfUser('a');
		 acct1.setStatus('N');
		 acct1.setActive(false);
	}

	@Test
	public void testSetTypeOfUser() {
		char original = 'a';
		acct2.setTypeOfUser(original);
		char type = acct2.getTypeOfUser();
		assertEquals("Type of user is now: " + original, original, type);
	}

	@Test
	public void testSetStatus() {
		char original = 'N';
		acct2.setStatus(original);
		char status = acct2.getStatus();
		assertEquals("Status of user is now: " + original, original, status);
	}

	@Test
	public void testSetPassword() {
		String original = "hello";
		acct2.setPassword(original);
		String pw = acct2.getPassword();
		assertEquals("Password of user is now: " + original, original, pw);
	}

	@Test
	public void testSetFirstName() {
		String original = "Tre";
		acct2.setFirstName(original);
		String name = acct2.getFirstName();
		assertEquals("First Name is now: " + original, original, name);
	}

	@Test
	public void testSetLastName() {
		String original = "Vasquez";
		acct2.setLastName(original);
		String lastname = acct2.getLastName();
		assertEquals("last name is now: " + original, original, lastname);
	}

	@Test
	public void testSetUsername() {
		String original = "trev";
		acct2.setUsername(original);
		String username = acct2.getUsername();
		assertEquals("Username of user is now: " + original, original, username);
	}

}
