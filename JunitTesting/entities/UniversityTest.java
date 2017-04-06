package controller;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import cmc.mario.controllers.SearchController;
import cmc.mario.entities.University;

public class UniversityTest {
	private University uni1;
	@Before
	public void setUp() throws Exception{
		List<String> popMajors = new ArrayList<String>();
		SearchController seCon = new SearchController();
		String m1 = "Biology";
		String m2 = "Computer Science";
		popMajors.add(m1);
		popMajors.add(m2);
		University uni1 = new University("ABILENE CHRISTIAN UNIVERSITY","TEXAS","SUBURBAN","PRIVATE",
				10000, 50 , -1,-1 ,12088, 70 ,4000,90 , 80 , 2,3,3,popMajors);
		
	
	}
	
	@Test
	public void testUniversity() {
		University uni2 = new University();
		uni2.setSchoolName("ABILENE CHRISTIAN UNIVERSITY");
		uni2.setState("TEXAS");
		uni2.setLocation("SUBURBAN");
		uni2.setControl("PRIVATE");
		uni2.setNumOfStu(10000);
		uni2.setPerFem(50);
		uni2.setSatVerbal(-1);
		uni2.setSatMath(-1);
		uni2.setPrice(12088);
		uni2.setFinAid(70);
		uni2.setNumOfApp(4000);
		uni2.setPerAdmit(90);
		uni2.setPerEnroll(80);
		uni2.setAcademicScale(2);
		uni2.setLifeScale(3);
		uni2.setSocialScale(3);
		//Wrong type of list, it wants [] not <String>
		List<String> popMajors1 = new ArrayList<String>();
		String m1 = "Biology";
		String m2 = "Computer Science";
		popMajors1.add(m1);
		popMajors1.add(m2);
		uni2.setPopMajors(popMajors1);
		assertTrue("Uni1 should be equal to Uni2", uni1.equals(uni2));
	}

	@Test
	public void testUniversity1() {
		University uni3 = new University("ABILENE CHRISTIAN UNIVERSITY","TEXAS","SUBURBAN","PRIVATE",
				10000, 50 , -1,-1 ,12088, 70 ,4000,90 , 80 , 2,3,3,popMajors);
		assertTrue("Uni1 should be equal to Uni2", uni1.equals(uni3));
	}

	@Test
	public void testGetSchoolName() {
		assertTrue("Name should be ABILENE CHRISTIAN UNIVERSITY", uni1.getSchoolName()=="ABILENE CHRISTIAN UNIVERSITY");
		
	}

	@Test
	public void testSetSchoolName() {
		uni1.setSchoolName("AUGSBURG");
		assertTrue("Name should be AUGSBURG",uni1.getSchoolName()=="AUGSBURG");
		
	}

	@Test
	public void testGetState() {
		assertTrue("Name should be TEXAS",uni1.getState()=="TEXAS");
	}

	@Test
	public void testSetState() {
		uni1.setState("MINNESOTA");
		assertTrue("Name should be MINNESOTA",uni1.getState()=="MINNESOTA");
	}

	@Test
	public void testGetLocation() {
		assertTrue("Location should be SUBURBAN", uni1.getLocation()=="SUBURBAN");
	}

	@Test
	public void testSetLocation() {
		uni1.setLocation("CITY");
		assertTrue("Location should be CITY", uni1.getLocation() == "CITY");
	}

	@Test
	public void testGetControl() {
		assertTrue("Control should be PRIVATE",uni1.getControl() == "PRIVATE" );
	}

	@Test
	public void testSetControl() {
		uni1.setControl("PUBLIC");
		assertTrue("Control should be PUBLIC", uni1.getControl() == "PUBLIC");
	}

	@Test
	public void testGetNumOfStu() {
		assertTrue("Number of student should be 10000",uni1.getNumOfStu() == 10000);
	}

	@Test
	public void testSetNumOfStu() {
		uni1.setNumOfStu(15000);
		assertTrue("Number of student should be 15000",uni1.getNumOfStu() == 15000);
	}

	@Test
	public void testGetPerFem() {
		assertTrue("Female percent should be 50", uni1.getPerFem() == 50);
	}

	@Test
	public void testSetPerFem() {
		uni1.setPerFem(56);
		assertTrue("Female percent should be 56",uni1.getPerFem() == 56);
	}

	@Test
	public void testGetSatVerbal() {
		assertTrue("SAT Verbal should be -1", uni1.getSatVerbal()==-1);
	}

	@Test
	public void testSetSatVerbal() {
		uni1.setSatVerbal(600);
		assertTrue("SAT Verbal should be 600",uni1.getSatVerbal() == 600);
	}

	@Test
	public void testGetSatMath() {
		assertTrue("SAT Math should be -1",uni1.getSatMath() == -1);
	}

	@Test
	public void testSetSatMath() {
		uni1.setSatMath(600);
		assertTrue("SAT Math should be 600",uni1.getSatMath() == 600);
	}

	@Test
	public void testGetPrice() {
		assertTrue("Price should be 12088",uni1.getPrice() == 12088);
	}

	@Test
	public void testSetPrice() {
		uni1.setPrice(1);
		assertTrue("Price should be 1", uni1.getPrice() ==1);
	}

	@Test
	public void testGetFinAid() {
		assertTrue("Fin Aid should be 70", uni1.getFinAid() == 70);
	}

	@Test
	public void testSetFinAid() {
		
		uni1.setFinAid(60);
		assertTrue("Fin aid should be 60", uni1.getFinAid() == 60);
	}

	@Test
	public void testGetNumOfApp() {
		assertTrue("Number of app should be 4000",uni1.getNumOfApp() == 4000);
	}

	@Test
	public void testSetNumOfApp() {
		uni1.setNumOfApp(50);
		assertTrue("Number of app should be 50", uni1.getNumOfApp() == 50);
	}

	@Test
	public void testGetPerAdmit() {
		assertTrue("Percentage Admitted should be 90", uni1.getPerAdmit() ==90);
	}

	@Test
	public void testSetPerAdmit() {
		uni1.setPerAdmit(50);
		assertTrue("Percentage Admitted should be 50", uni1.getPerAdmit() == 50);
	}

	@Test
	public void testGetPerEnroll() {
		assertTrue("Percentage  Enrolled should be 80 ", uni1.getPerEnroll() == 80);
	}

	@Test
	public void testSetPerEnroll() {
		uni1.setPerEnroll(50);
		assertTrue("Percentage Enrolled should be 50", uni1.getPerEnroll() == 50);
	}

	@Test
	public void testGetAcademicScale() {
		assertTrue("Academic Scale should be 2", uni1.getAcademicScale() == 2);
	}

	@Test
	public void testSetAcademicScale() {
		uni1.setAcademicScale(1);
		assertTrue("Academic Scale should 1", uni1.getAcademicScale() ==1);
	}

	@Test
	public void testGetSocialScale() {
		assertTrue("Social Scale should be 3", uni1.getSocialScale() == 3);
		
	}

	@Test
	public void testSetSocialScale() {
		uni1.setSocialScale(1);
		assertTrue("Social Scale should be 1", uni1.getSocialScale() == 1);
	
	}

	@Test
	public void testGetLifeScale() {
		assertTrue("Life Scale should be 3", uni1.getLifeScale() == 3);
	}

	@Test
	public void testSetLifeScale() {
		uni1.setLifeScale(1);
		assertTrue("Life Scale should be 1", uni1.getLifeScale() ==1);
	}

	@Test
	public void testGetPopMajors() {
		assertTrue("Popular Majors should be Biology and Computer Science", uni1.getPopMajors().get(0)=="Biology"&&
				uni1.getPopMajors().get(1) == "Computer Science");
	}

	@Test
	public void testSetPopMajors() {
		List<String> majors = new ArrayList<String>();
		majors.add("Food");
		majors.add("Candy");
		uni1.setPopMajors(majors);
		assertTrue("Popular Majors should be Food and Candy", uni1.getPopMajors().get(0)=="Food"&&
				uni1.getPopMajors().get(1) == "Candy");
	}

}
