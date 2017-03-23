package cmc.mario.controllers;

import java.lang.reflect.Array;
import java.util.*;

import cmc.mario.entities.University;

/**
 * File: SearchController.java
 *
 * SearchController class which helps search universities which meet the
 * requirements from user extends userFuncController
 * 
 * @author Mario Party 4: Jing Thao and Kalila Moua
 * @version March 19, 2017
 */
public class SearchController {
	private DBController dbControl;

	//
	/*
	 * Constructor of the class: Inherited from super class: AccountController
	 */
	public SearchController() {
		this.dbControl = new DBController();
	}

	/**
	 * Searches for schools with the conditions given -Kalila
	 * 
	 * @param schoolName
	 *            the school name of the university
	 * @param state
	 *            the state of the university
	 * @param location
	 *            the location of the university
	 * @param control
	 *            the type of school (e.g. private)
	 * @param numOfStuStart
	 *            the number of students starting range number
	 * @param numOfStuEnd
	 *            the number of students ending range number
	 * @param perFemStart
	 *            the percentage of students who are female starting range
	 *            number
	 * @param perFemEnd
	 *            the percentage of students who are female ending range number
	 * @param satVerbalStart
	 *            the starting range for SAT verbal score
	 * @param satVerbalEnd
	 *            the ending range for SAT verbal score
	 * @param satMathStart
	 *            the starting range for SAT math score
	 * @param satMathEnd
	 *            the ending range for SAT math score
	 * @param priceStart
	 *            the starting range for price/expenses
	 * @param priceEnd
	 *            the ending range for price/expenses
	 * @param finAidStart
	 *            the starting range for financial aid percentage
	 * @param finAidEnd
	 *            the ending range for financial aid percentage
	 * @param numOfAppStart
	 *            the user gives
	 * @param perAdmitStart
	 *            the starting range for admitted students percentage
	 * @param perAdmitEnd
	 *            the ending range for admitted students percentage
	 * @param perEnrollStart
	 *            the starting range for enrolled students percentage
	 * @param perEnrollEnd
	 *            the ending range for enrolled students percentage
	 * @param academicScaleStart
	 *            the starting range for quality of academics
	 * @param academicScaleEnd
	 *            the ending range for quality of academics
	 * @param socialScaleStart
	 *            the starting range for quality of social
	 * @param socialScaleEnd
	 *            the ending range for quality of social scale
	 * @param lifeScaleStart
	 *            the starting range for quality of life scale
	 * @param lifeScaleEnd
	 *            the ending range for quality of life scale
	 * @param popMajor
	 *            an list of popular major or emphases at the university
	 */
	public List<University> search(String schoolName, String state, String location, String control,
			Integer numOfStuStart, Integer numOfStuEnd, Integer perFemStart, Integer perFemEnd, Integer satVerbalStart,
			Integer satVerbalEnd, Integer satMathStart, Integer satMathEnd, Integer priceStart, Integer priceEnd,
			Integer finAidStart, Integer finAidEnd, Integer numOfAppStart, Integer numOfAppEnd, Integer perAdmitStart,
			Integer perAdmitEnd, Integer perEnrollStart, Integer perEnrollEnd, Integer academicScaleStart,
			Integer academicScaleEnd, Integer socialScaleStart, Integer socialScaleEnd, Integer lifeScaleStart,
			Integer lifeScaleEnd, List<String> popMajor) {
		return dbControl.searchResults(schoolName, state, location, control, numOfStuStart, numOfStuEnd, perFemStart,
				perFemEnd, satVerbalStart, satVerbalEnd, satMathStart, satMathEnd, priceStart, priceEnd, finAidStart,
				finAidEnd, numOfAppStart, numOfAppEnd, perAdmitStart, perAdmitEnd, perEnrollStart, perEnrollEnd,
				academicScaleStart, academicScaleEnd, socialScaleStart, socialScaleEnd, lifeScaleStart, lifeScaleEnd,
				popMajor);
	}

	/**
	 * Gives a list of recommendations for the school that was chosen
	 * 
	 * @param u
	 *            the university to be compared to.
	 * @return A list of universities
	 */
	public List<University> viewRecommendation(University u) {
		List<University> uniList = dbControl.getUniversities();// dbControl.getUniversities();
		String[][] listRecommend = new String[uniList.size()][1];
		double[] listRecommend2 = new double[uniList.size()];
		List<University> uniRecommendList = new ArrayList<University>();

		int uStudents = u.getNumOfStu();
		double uFemale = u.getPerFem();
		double uSatMath = u.getSatMath();
		double uSatVerbal = u.getSatVerbal();
		double uPrice = u.getPrice();
		double uFinAid = u.getFinAid();
		int uApp = u.getNumOfApp();
		double uAdmit = u.getPerAdmit();
		double uEnroll = u.getPerEnroll();
		int uAcademic = u.getAcademicScale();
		int uSocial = u.getSocialScale();
		int uLife = u.getLifeScale();

		if (!(uniList.isEmpty())) {
			for (int i = 0; i < uniList.size() - 1; i++) {
				double percentStudents = Math.abs(1 - (uStudents / uniList.get(i).getNumOfStu()));
				double percentFemale = Math.abs(1 - (uFemale / uniList.get(i).getPerFem()));
				double percentSatMath = Math.abs(1 - (uSatMath / uniList.get(i).getSatMath()));
				double percentSatVerbal = Math.abs(1 - (uSatVerbal / uniList.get(i).getSatVerbal()));
				double percentPrice = Math.abs(1 - (uPrice / uniList.get(i).getPrice()));
				double percentFinAid = Math.abs(1 - (uFinAid / uniList.get(i).getFinAid()));
				double percentApp = Math.abs(1 - (uApp / uniList.get(i).getNumOfApp()));
				double percentAdmit = Math.abs(1 - (uAdmit / uniList.get(i).getPerAdmit()));
				double percentEnroll = Math.abs(1 - (uEnroll / uniList.get(i).getPerEnroll()));
				double percentAcademic = Math.abs(1 - (uAcademic / uniList.get(i).getAcademicScale()));
				double percentSocial = Math.abs(1 - (uSocial / uniList.get(i).getSocialScale()));
				double percentLife = Math.abs(1 - (uLife / uniList.get(i).getLifeScale()));
				double totalPer = (percentStudents + percentFemale + percentSatMath + percentSatVerbal + percentPrice
						+ percentFinAid + percentApp + percentAdmit + percentEnroll + percentAcademic + percentSocial
						+ percentLife) / 12;
				listRecommend[i][0] = uniList.get(i).getSchoolName();
				listRecommend[i][1] = Double.toString(totalPer);
				listRecommend2[i] = Double.parseDouble(listRecommend[i][1]);
				Arrays.sort(listRecommend2);
			}

		}
		while (uniRecommendList.size() < 5) {
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < uniList.size() - 1; k++) {
					if (listRecommend2[j] == Double.parseDouble(listRecommend[k][1])) {
						for (int l = 0; l < uniList.size() - 1; l++) {
							if (listRecommend[k][0] == uniList.get(l).getSchoolName())
								uniRecommendList.add(uniList.get(l));
						}

					}

				}
			}

		}
		return uniRecommendList;
	}

}
