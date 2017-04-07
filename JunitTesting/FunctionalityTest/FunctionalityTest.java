package FunctionalityTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cmc.mario.interfaces.AccountUI;
import cmc.mario.interfaces.AdminUI;
import cmc.mario.interfaces.UserUI;

public class FunctionalityTest {
	private AccountUI acct;
	private UserUI usr;
	private AdminUI adm;

	@Before
	public void setUp() {
		acct= new AccountUI();
	}

	@Test
	public void LoginSuccessfullyAsUser() {
		assertTrue("Log in as an User successfully", acct.logOn("juser", "user").getError()==1);
	}
	@Test
	public void LoginSuccessfullyAsAdmin() {
		assertTrue("Log in as an admin successfully", acct.logOn("nadmin", "admin").getError()==0);
	}
	@Test
	public void LoginFailedForWrongUsername() {
		assertTrue("Log in fail becasue of username", acct.logOn("shdu", "admin").getError()==4);
	}
	@Test
	public void LoginFailedForWrongPassword() {
		assertTrue("Log in fail becasue of password", acct.logOn("juser", "admin").getError()==3);
	}
	@Test
	public void LoginFailedForDeactiveAccount() {
		assertTrue("Log in fail becasue of deactive account", acct.logOn("luser", "user").getError()==2);
	}
	
}
