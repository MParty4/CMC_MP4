package FunctionalityTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cmc.mario.controllers.DBController;
import cmc.mario.interfaces.AccountUI;
import cmc.mario.interfaces.AdminUI;
import cmc.mario.interfaces.UserUI;
import dblibrary.project.csci230.UniversityDBLibrary;

public class FunctionalityTest {
	private AccountUI acct;
	private UserUI usr;
	private AdminUI adm;
	private DBController dbc;
	private UniversityDBLibrary univLib;
	@Before
	public void setUp() {
		acct = new AccountUI();
		
	}

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
	
}
