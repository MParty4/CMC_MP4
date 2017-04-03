package junitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import cmc.mario.entities.Admin;

public class AdminTest {

private Admin adm1, adm2;
	
	@Before
	public void setUp() throws Exception {
		String firstName = "Kalila";
		String lastName = "Moua";
		String username = "k1moua";
		String password = "k1moua";
		char type = 'a';
		char status = 'Y';
	    adm2 = new Account(firstName, lastName, username, password, type, status);
	    adm2.setFirstName("Kalila");
	    adm2.setLastName("Moua");
	    adm2.setUsername("k1moua");
	    adm2.setPassword("k1moua");
	    adm2.setTypeOfUser('a');
	    adm2.setStatus('Y');
	    adm2.setActive(true);
	    adm1 = new Account();
	    adm1.setFirstName("A");
	    adm1.setLastName("A");
	    adm1.setUsername("A");
	    adm1.setPassword("A");
	    adm1.setTypeOfUser('a');
	    adm1.setStatus('N');
	    adm1.setActive(false);
	  }
	@Test
	public void testAdmin() {
		String firstname = "A";
		String lastname = "A";
		String username = "A";
		String password = "A";
		String f = adm1.getFirstName();
		String l = adm1.getLastName();
		String u = adm1.getUsername();
		String p = adm1.getPassword();
		char type =adm1.getTypeOfUser();
		assertEquals(firstname, f);
		assertEquals(lastname, l);
		assertEquals(username, u);
		assertEquals(password, p);
		assertEquals('a', type);
	}

	@Test
	public void testAdminStringStringStringString() {
		String orgFirstName = "Kalila";
		String orgLastName = "Moua";
		String orgUsername =  "k1moua";
		String orgPassword = "k1moua";
		char status = 'Y';
		String name = adm2.getFirstName();
		String lastName = adm2.getLastName();
		String username = adm2.getUsername();
		String password = adm2.getPassword();
		char t = adm2.getTypeOfUser();
		char st = adm2.getStatus();
		assertEquals(orgFirstName, name);
		assertEquals(orgLastName, lastName);
		assertEquals(orgUsername, username);
		assertEquals(orgPassword, password);
		assertEquals('a', t);
		assertEquals(status, st);
	}

}
