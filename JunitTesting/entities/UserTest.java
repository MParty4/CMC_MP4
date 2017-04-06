package entities;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import cmc.mario.entities.User;

public class UserTest {
private User user,user2;

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
	public void testDefaultConstructor(){
		user = new User();
	    user.setFirstName("jing");
	    user.setLastName("thao");
	    user.setUsername("j1thao");
	    user.setPassword("look!@you");
	    user.setTypeOfUser('u');
	    String expResult = "jing";
	    String expResult2 = "thao";
	    String expResult3 = "j1thao";
	    String expResult4 = "look!@you";
	    char expResult5 = 'u';
		String result = user.getFirstName();
		String result2 = user.getLastName();
		String result3 = user.getUserName();
		String result4 = user.getPassword();
		char result5 = user.getType();
		assertEquals("firstname is " + expResult,expResult, result);
		assertEquals("lastname is " + expResult2,expResult2, result2);
		assertEquals("username is " + expResult3,expResult3, result3);
		assertEquals("password is " + expResult4,expResult4, result4);
		assertEquals("type is " + expResult5,expResult5, result5);
	    
	}
	
	@Test
	public void testSecondConstructor(){
		 user2 = new User("kalila","Moua", "k1moua", "k3$ha");
		 String expResult = "kalila";
	     String expResult2 = "Moua";
	     String expResult3 = "k1moua";
    	 String expResult4 = "k3$ha";
		 char expResult5 = 'u';
		 String result = user2.getFirstName();
		 String result2 = user2.getLastName();
		 String result3 = user2.getUserName();
		 String result4 = user2.getPassword();
		 char result5 = user2.getType();
		 assertEquals("firstname is " + expResult,expResult, result);
		 assertEquals("lastname is " + expResult2,expResult2, result2);
		 assertEquals("username is " + expResult3,expResult3, result3);
		 assertEquals("password is " + expResult4,expResult4, result4);
		 assertEquals("type is " + expResult5,expResult5, result5);
	}
	
	@Test
	public void testGetFirstName() {
		String expResult = "tree";
		String result = user.getFirstName();
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
