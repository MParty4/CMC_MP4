package junitTesting;

import static org.junit.Assert.*;

import cmc.mario.controllers.AccountController;
import cmc.mario.controllers.DBController;
import cmc.mario.entities.Account;
import org.junit.Test;
import org.junit.Before;

public class AccountControllerTest {
	private AccountController acctCtr;
	private Account acct;
	private DBController database;
	
	@Before
	public void setUp() throws Exception {
		acct = new Account();
		acct.setUsername("k1moua");
		
	  }

	@Test
	public void testAccountControllerAccount() {
		acctCtr = new AccountController(acct);
		database = new DBController();
	}

	@Test
	public void testLogOff() {
		fail("Not yet implemented");
	}

	@Test
	public void testLogOn() {
		fail("Not yet implemented");
	}

	@Test
	public void testTypeOfUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAcct() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetAcct() {
		fail("Not yet implemented");
	}

}
