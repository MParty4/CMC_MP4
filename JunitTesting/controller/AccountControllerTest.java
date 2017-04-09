package controller;

import static org.junit.Assert.*;

import cmc.mario.controllers.AccountController;
import cmc.mario.controllers.DBController;
import cmc.mario.entities.Account;
import org.junit.Test;
import org.junit.Before;

public class AccountControllerTest {
	private AccountController acctCtr;
	private Account acct;
	
	@Before
	public void setUp() throws Exception {
		acct = new Account();
		acctCtr = new AccountController(acct);
	  }

	@Test
	public void testAccountControllerAccount() {
		assertTrue("Controller constructor is not null", acctCtr != null);
	}

	@Test
	public void testLogOff() {
		assertTrue("Acct controller is logged off", acctCtr.logOff()==true);
		assertFalse("Acct controller is not logged off", acctCtr.logOff()==false);
	}

	@Test
	public void testLogOnForUserCase1() {
		String username = "juser";
		String password = "user";
		assertTrue("User is logged on", acctCtr.logOn(username, password).typeOfUser("juser")=='u');
	}
	
	@Test
	public void testLogOnForAdminCase2(){
		String username = "nadmin";
		String password = "admin";
		assertTrue("Admin is logged on", acctCtr.logOn(username, password).typeOfUser("nadmin")=='a');
	}

	@Test
	public void testLogOnFailUsernameCase3() {
		String username = "nadmi";
		String password = "admin";
		assertTrue("Admin username is not correct.", acctCtr.logOn(username, password)==null);
	}
	
	@Test
	public void testLogOnFailPasswordCase4() {
		String username = "nadmin";
		String password = "adm";
		assertTrue("Admin pasword is not correct.", acctCtr.logOn(username, password)==null);
	}

	@Test
	public void testLogOnDeactivatedAccountCase5() {
		String username = "luser";
		String password = "user";
		assertTrue("Account is deactivated.", acctCtr.logOn(username, password)==null);
	}
	
	@Test
	public void testTypeOfUserCase1() {
		char typeu = acctCtr.typeOfUser("luser");
		char type1 = 'u';
		assertEquals("Type of this user is a user:", type1, typeu);
	}
	
	@Test
	public void testTypeOfUserCase2() {
		char typea = acctCtr.typeOfUser("nadmin");
		char type2 = 'a';
		assertEquals("Type of this user is a admin:", type2, typea);
	}

	@Test
	public void testGetAcct() {
		assertTrue("Get account is not null", acctCtr.getAcct()!=null);
	}

	@Test
	public void testSetAcct() {
		acctCtr.setAcct(acct);
		assertTrue("The account is set in Account controller", acctCtr.getAcct()!=null);
	}

}
