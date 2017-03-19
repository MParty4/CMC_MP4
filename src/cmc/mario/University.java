package cmc.mario;
/*
 * File: University.java
 */

/**
 * University Class which includes all information about a university
 * 
 * @author Mario Party 4: Jing Thao
 * @Modify by Yidan Zhang
 * @version Feb. 24, 2017
 */
public class University {

	/**
	 * University Attributes
	 */

	/**
	 * schoolName the name of a school
	 */
	private String schoolName;

	/**
	 * state the state of a school
	 */
	private String state;

	/**
	 * location the location of a school
	 */
	private String location;

	/**
	 * control private or public school
	 */
	private String control;

	/**
	 * numOfStu the number of students in a school
	 */
	private int numOfStu;

	/**
	 * perFem the percentage of female in a school
	 */
	private int perFem;

	/**
	 * satVerbal the sat verbal score requirement of a school
	 */
	private int satVerbal;

	/**
	 * satMath the sat math score requirement of a school
	 */
	private int satMath;

	/**
	 * price the expenses of a school
	 */
	private int price;

	/**
	 * finAidthe financial aid a school can provide to a student
	 */
	private int finAid;

	/**
	 * numOfApp the percentage of admitted for a school
	 */

	private int numOfApp;

	/**
	 * perAdmit the name of applicants for a school
	 */
	private int perAdmit;

	/**
	 * perEnroll the percentage of enrolled students in a school
	 */
	private int perEnroll;

	/**
	 * academicScale the scale of acdemic of a school
	 */
	private int academicScale;

	/**
	 * socialScale the social scale of a school
	 * 
	 */
	private int socialScale;

	/**
	 * lifeScale the life scale of a school
	 */
	private int lifeScale;

	/**
	 * popMajors the emphases majors of a school
	 */
	private String popMajors;

	/**
	 * @param schoolName
	 *            name of the school
	 * @param state
	 *            which is searching condition
	 * @param location
	 *            which is searching condition
	 * @param control
	 *            which is searching condition
	 * @param numOfStu
	 *            which is number of students of searching condition
	 * @param perFem
	 *            which is percentage of female of searching condition
	 * @param satVerbal
	 *            which is sat verbal score of searching condition
	 * @param satMath
	 *            which is sat math score of searching condition
	 * @param price
	 *            which is expense of searching condition
	 * @param finAid
	 *            which is financial aid student can get from school of
	 *            searching condition
	 * @param numOfApp
	 *            which is number of applicants of searching condition
	 * @param perAdmit
	 *            which is percentage of admit of searching condition
	 * @param perEnroll
	 *            which is percentage of enroll of searching condition
	 * @param control
	 *            which is new of searching condition
	 * @param academicScale
	 *            which is scale of acedmic of searching condition
	 * @param socialScale
	 *            which is scale of social of searching condition
	 * @param lifeScale
	 *            which is scale of life of searching condition
	 * @param popMajor
	 *            which is the emphases majors of this school of searching
	 *            condition
	 */
	public University(String schoolName, String state, String location, String control, int numOfStu, int perFem,
			int satVerbal, int satMath, int price, int finAid, int numOfApp, int perAdmit, int perEnroll,
			int academicScale, int socialScale, int lifeScale) {
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
		this.popMajors = popMajors;

	}

	/**
	 * A method to get school name
	 *
	 * @return the schoolName
	 */
	public String getSchoolName() {
		return schoolName;
	}

	/**
	 * A method to set school name
	 * 
	 * @param schoolName
	 *            the schoolName to set
	 */
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	/**
	 * 
	 * A method to get state school locates in
	 * 
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * A method to set state school locates in
	 * 
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * A method to get location
	 * 
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * A method to set location
	 * 
	 * @param location
	 *            the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * get control of the school:private or public
	 * 
	 * @return the control
	 */
	public String getControl() {
		return control;
	}

	/**
	 * set control of the school: private or public
	 * 
	 * @param control
	 *            the control to set
	 */
	public void setControl(String control) {
		this.control = control;
	}

	/**
	 * get number of students
	 * 
	 * @return the numOfStu
	 */
	public int getNumOfStu() {
		return numOfStu;
	}

	/**
	 * set number of students
	 * 
	 * @param numOfStu
	 *            the numOfStu to set
	 */
	public void setNumOfStu(int numOfStu) {
		this.numOfStu = numOfStu;
	}

	/**
	 * get percentage of female in the school
	 * 
	 * @return the perFem
	 */
	public Integer getPerFem() {
		return perFem;
	}

	/**
	 * set percentage of female in the school
	 * 
	 * @param perFem
	 *            the perFem to set
	 */
	public void setPerFem(int perFem) {
		this.perFem = perFem;
	}

	/**
	 * get sat verbal score requirement of a school
	 * 
	 * @return the satVerbal
	 */
	public int getSatVerbal() {
		return satVerbal;
	}

	/**
	 * set sat verbal score requirement of a school
	 * 
	 * @param satVerbal
	 *            the satVerbal to set
	 */
	public void setSatVerbal(int satVerbal) {
		this.satVerbal = satVerbal;
	}

	/**
	 * get sat math score requirement of a school
	 * 
	 * @return the satMath
	 */
	public int getSatMath() {
		return satMath;
	}

	/**
	 * set sat math score requirement of a school
	 * 
	 * @param satMath
	 *            the satMath to set
	 */
	public void setSatMath(int satMath) {
		this.satMath = satMath;
	}

	/**
	 * get expense of a school
	 * 
	 * @return the price of the school
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * get expense of a school
	 * 
	 * @return the price of the school
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * get financial aid a school provides
	 * 
	 * @return the price of the school
	 */
	public int getFinAid() {
		return finAid;
	}

	/**
	 * set financial aid a school provides
	 * 
	 * @param finAid
	 *            to set
	 */
	public void setFinAid(int finAid) {
		this.finAid = finAid;
	}

	/**
	 * get number of applicants
	 * 
	 * @return number of applicants
	 */
	public int getNumOfApp() {
		return numOfApp;
	}

	/**
	 * set number of applicants
	 * 
	 * @param numOfApp
	 *            to set
	 */
	public void setNumOfApp(int numOfApp) {
		this.numOfApp = numOfApp;
	}

	/**
	 * get percentage of Amitted of a school
	 * 
	 * @return the perAdmit
	 */
	public Integer getPerAdmit() {
		return perAdmit;
	}

	/**
	 * set percentage of Amitted of a school
	 * 
	 * @param perAdmit
	 *            the perAdmit to set
	 */
	public void setPerAdmit(int perAdmit) {
		this.perAdmit = perAdmit;
	}

	/**
	 * get percentage of enrolled students of a school
	 * 
	 * @return the perEnroll
	 */
	public Integer getPerEnroll() {
		return perEnroll;
	}

	/**
	 * set percentage of enrolled students of a school
	 * 
	 * @param perEnroll
	 *            the perEnroll to set
	 */
	public void setPerEnroll(int perEnroll) {
		this.perEnroll = perEnroll;
	}

	/**
	 * get academic scale of a school
	 * 
	 * @return the academicScale
	 */
	public int getAcademicScale() {
		return academicScale;
	}

	/**
	 * set academic scale of a school
	 * 
	 * @param academicScale
	 *            the academicScale to set
	 */
	public void setAcademicScale(int academicScale) {
		this.academicScale = academicScale;
	}

	/**
	 * get social scale of a school
	 * 
	 * @return the socialScale
	 */
	public int getSocialScale() {
		return socialScale;
	}

	/**
	 * set social scale of a school
	 * 
	 * @param socialScale
	 *            the socialScale to set
	 */
	public void setSocialScale(int socialScale) {
		this.socialScale = socialScale;
	}

	/**
	 * get life scale of a school
	 * 
	 * @return the lifeScale
	 */
	public int getLifeScale() {
		return lifeScale;
	}

	/**
	 * set life scale of a school
	 * 
	 * @param lifeScale
	 *            the lifeScale to set
	 */
	public void setLifeScale(int lifeScale) {
		this.lifeScale = lifeScale;
	}

	/**
	 * get emphases majors of a school
	 * 
	 * @return the popMajors
	 */
	public String getPopMajors() {
		return popMajors;
	}

	/**
	 * set emphases majors of a school
	 * 
	 * @param popMajors
	 *            the popMajors to set
	 */
	public void setPopMajors(String popMajors) {
		this.popMajors = popMajors;
	}

}
