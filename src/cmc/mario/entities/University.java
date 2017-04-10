package cmc.mario.entities;
/**
 * File: University.java
 */
import java.util.*;

import cmc.mario.controllers.DBController;
import dblibrary.project.csci230.UniversityDBLibrary;
/**
 * University Class which includes all information about a university
 * @author Mario Party 4: Jing Thao
 * @Modify by Yidan Zhang and Kalila Moua
 * @version 3/26/17
 */
public class University {
	private DBController db;
	/**
	 * the name of a school
	 */
	private String schoolName;
	/**
	 * state of a school
	 */
	private String state;

	/**
	 * the location of a school
	 */
	private String location;

	/**
	 * type of school (e.g. private)
	 */
	private String control;

	/**
	 * the number of students in a school
	 */
	private int numOfStu;

	/**
	 * percentage of female students in a school
	 */
	private int perFem;

	/**
	 * the sat verbal score requirement of a school
	 */
	private int satVerbal;

	/**
	 * the sat math score requirement of a school
	 */
	private int satMath;

	/**
	 * the expenses of a school
	 */
	private int price;

	/**
	 * financial aid percentage a school provides for students
	 */
	private int finAid;

	/**
	 * the percentage of admitted students
	 */

	private int numOfApp;

	/**
	 * the number of admitted students
	 */
	private int perAdmit;

	/**
	 * the percentage of students enrolled
	 */
	private int perEnroll;

	/**
	 * the academic scale of a school
	 */
	private double academicScale;

	/**
	 * the social scale of a school
	 * 
	 */
	private double socialScale;

	/**
	 * the life scale of a school
	 */
	private double lifeScale;

	/**
	 * the popular emphases majors of a school
	 */
	private String[] popMajors;
	
	/**
	 * Default constructor to create university will null and blank fields
	 */
	public University(){
		this.schoolName = null;
		this.state = null;
		this.location = null;
		this.control = null;
		this.numOfStu = -1;
		this.perFem = -1;
		this.satVerbal = -1;
		this.satMath = -1;
		this.price = -1;
		this.finAid = -1;
		this.numOfApp = -1;
		this.perAdmit = -1;
		this.perEnroll = -1;
		this.academicScale = -1;
		this.socialScale = -1;
		this.lifeScale = -1;
	}

	/**
	 * Second Constructor
	 * * @param state the state where the school is located
		   * @param location what type of area is the school located at
		   * @param control the type of school (e.g. private)
		   * @param numOfStu number of students attending school 
		   * @param perFem percentage of females attending 
		   * @param satVerbal average SAT Verbal score 
		   * @param satMath average SAT Math score 
		   * @param priceE total expenses for a year at school 
		   * @param finAid the percentage of students receiving financial aid 
		   * @param numOfApp the number of applications the school receives 
		   * @param perAdmit the percentage of admitted students 
		   * @param perEnroll the percentage of students enrolled after applying 
		   * @param control the control of school amount
		   * @param academicScale the scale of academic life on campus 
		   * @param socialScale the scale of social life on campus 
		   * @param lifeScale the scale of life on campus 
		   * @param popMajor a list of popular majors at university
	 */
	public University(String schoolName, String state, String location, String control, int numOfStu, int perFem,
			int satVerbal, int satMath, int price, int finAid, int numOfApp, int perAdmit, int perEnroll,
			double academicScale, double socialScale, double lifeScale) {
		this.schoolName = schoolName;
		this.state = state;
		this.location = location;
		this.control = control;
		this.numOfStu = numOfStu;
		this.perFem = perFem;
		this.satVerbal = satVerbal;
		this.satMath = satMath;
		this.price = price;
		this.finAid = finAid;
		this.numOfApp = numOfApp;
		this.perAdmit = perAdmit;
		this.perEnroll = perEnroll;
		this.academicScale = academicScale;
		this.socialScale = socialScale;
		this.lifeScale = lifeScale;
	}
	
	public University(String schoolName, String state, String location, String control, int numOfStu, int perFem,
			int satVerbal, int satMath, int price, int finAid, int numOfApp, int perAdmit, int perEnroll,
			double academicScale, double socialScale, double lifeScale,String[] list) {
		this.schoolName = schoolName;
		this.state = state;
		this.location = location;
		this.control = control;
		this.numOfStu = numOfStu;
		this.perFem = perFem;
		this.satVerbal = satVerbal;
		this.satMath = satMath;
		this.price = price;
		this.finAid = finAid;
		this.numOfApp = numOfApp;
		this.perAdmit = perAdmit;
		this.perEnroll = perEnroll;
		this.academicScale = academicScale;
		this.socialScale = socialScale;
		this.lifeScale = lifeScale;
		this.popMajors = list;
	}

	/**
	 * A method to get school name
	 * @return the schoolName
	 */
	public String getSchoolName() {
		return schoolName;
	}

	/**
	 * A method to set school name - Jing
	 * @param schoolName the schoolName to set
	 */
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	/**
	 * 
	 * A method to get state school locates in
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * A method to set state school locates in - Jing
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * A method to get location
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * A method to set location - Jing
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Get control of the school:private or public
	 * @return the control
	 */
	public String getControl() {
		return control;
	}

	/**
	 * Set the control of the school: private or public - Jing
	 * @param control the control to set
	 */
	public void setControl(String control) {
		this.control = control;
	}

	/**
	 * Get the number of students
	 * @return the number of students
	 */
	public int getNumOfStu() {
		return numOfStu;
	}

	/**
	 * Set number of students
	 * @param numOfStu the number of students to set field to - Jing
	 */
	public void setNumOfStu(int numOfStu) {
		this.numOfStu = numOfStu;
	}

	/**
	 * Get percentage of female in the school
	 * @return the perFem
	 */
	public int getPerFem() {
		return perFem;
	}

	/**
	 * Set percentage of female in the school - Jing
	 * @param perFem the perFem to set
	 */
	public void setPerFem(int perFem) {
		this.perFem = perFem;
	}

	/**
	 * Get sat verbal score requirement of a school
	 * @return the satVerbal
	 */
	public int getSatVerbal() {
		return satVerbal;
	}

	/**
	 * Set sat verbal score requirement of a school - Jing
	 * @param satVerbal the satVerbal to set
	 */
	public void setSatVerbal(int satVerbal) {
		this.satVerbal = satVerbal;
	}

	/**
	 * Get sat math score requirement of a school
	 * @return the satMath
	 */
	public int getSatMath() {
		return satMath;
	}

	/**
	 * Set sat math score requirement of a school - Jing
	 * @param satMath the satMath to set
	 */
	public void setSatMath(int satMath) {
		this.satMath = satMath;
	}

	/**
	 * Get expense of a school
	 * @return the price of the school
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Get expense of a school - Tre
	 * @return the price of the school
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * Get financial aid a school provides
	 * @return the price of the school
	 */
	public int getFinAid() {
		return finAid;
	}

	/**
	 * Set financial aid a school provides - Tre
	 * @param finAid
	 *            to set
	 */
	public void setFinAid(int finAid) {
		this.finAid = finAid;
	}

	/**
	 * Get number of applicants
	 * @return number of applicants
	 */
	public int getNumOfApp() {
		return numOfApp;
	}

	/**
	 * Set number of applicants - Tre
	 * @param numOfApp the number of applicants to set
	 */
	public void setNumOfApp(int numOfApp) {
		this.numOfApp = numOfApp;
	}

	/**
	 * Get percentage of Admitted of a school
	 * @return the percentage of admitted students
	 */
	public int getPerAdmit() {
		return perAdmit;
	}

	/**
	 * Set percentage of Admitted of a school - Tre
	 * @param perAdmit the percentage of admitted students to set
	 */
	public void setPerAdmit(int perAdmit) {
		this.perAdmit = perAdmit;
	}

	/**
	 * Get percentage of enrolled students of a school
	 * @return the pecentage of students enrolled
	 */
	public int getPerEnroll() {
		return perEnroll;
	}

	/**
	 * Set percentage of enrolled students of a school -Tre
	 * @param perEnroll the percentage of enrolled students to set
	 */
	public void setPerEnroll(int perEnroll) {
		this.perEnroll = perEnroll;
	}

	/**
	 * Get academic scale of a school
	 * @return the academic scale
	 */
	public double getAcademicScale() {
		return academicScale;
	}

	/**
	 * Set academic scale of a school -Yidan
	 * @param academicScale the academic scale to set 
	 */
	public void setAcademicScale(double academicScale) {
		this.academicScale = academicScale;
	}

	/**
	 * Get social scale of a school
	 * @return the social scale
	 */
	public double getSocialScale() {
		return socialScale;
	}

	/**
	 * Set social scale of a school -Yidan
	 * @param socialScale the socialScale to set
	 */
	public void setSocialScale(double socialScale) {
		this.socialScale = socialScale;
	}

	/**
	 * Get life scale of a school
	 * @return the lifeScale
	 */
	public double getLifeScale() {
		return lifeScale;
	}

	/** 
	 * Set life scale of a school -Yidan
	 * @param lifeScale the lifeScale to set
	 */
	public void setLifeScale(double lifeScale) {
		this.lifeScale = lifeScale;
	}

	/**
	 * Get emphases majors of a school
	 * @return a list of popular majors the school offers
	 */
	public List<String> getPopMajors() {
		UniversityDBLibrary u = new UniversityDBLibrary("mariop4", "mariop4", "csci230");
		String[][] uniE = u.university_getNamesWithEmphases();
		List<String> emphasesList = new ArrayList<String>();
		for(String[] em: uniE){
			if(em[0].equals(schoolName)){
				for(int i =1; i<em.length; i++){
					emphasesList.add(em[i]);
				}
			}
		}
		return emphasesList;
	}

	/**
	 * Set emphases/popular majors of a school -Yidan
	 * @param popMajors a string array of popMajors to set for a university
	 */
	public void setPopMajors(String[] popMajors) {
		DBController db1 = new DBController();
		 db1.setEmphasisForUniversity(schoolName, popMajors);
		
	}

}
