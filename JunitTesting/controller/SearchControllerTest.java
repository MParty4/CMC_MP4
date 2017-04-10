package controller;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cmc.mario.controllers.SearchController;
import cmc.mario.entities.University;

public class SearchControllerTest {
	private SearchController sc;
	@Test
	public void testSearchController() {
		sc = new SearchController();
		assertTrue("Controller constructor is not null", sc != null);
	}

	@Test
	public void testSearch() {
		SearchController sc = new SearchController();
		List<University> list = sc.search("", "", "", "", -1, 15000,
				-1, 50, -1, 600, -1, 
				600, -1, 15000, -1, 70, -1, 
				4000, -1, 80, -1, 80, -1, 
				3, -1, 3, -1, 3, new String[0]);
		assertTrue("First college should be AAAAA",list.get(0).getSchoolName().equals("AAAAA"));
		
	}

	@Test
	public void testViewRecommendation() {
		SearchController sc = new SearchController();
		List<University> list = sc.search("", "", "", "", -1, 15000,
				-1, 50, -1, 600, -1, 
				600, -1, 15000, -1, 70, -1, 
				4000, -1, 80, -1, 80, -1, 
				3, -1, 3, -1, 3, new String[0]);
		University u = list.get(1);
		System.out.println(u.getSchoolName());
		List<University> list2 = sc.viewRecommendation(u);
		for(int i = 0; i<list2.size();i++){
		System.out.println(list2.get(i).getSchoolName());
		}
		assertTrue("First College should be Florida Tech",list2.get(0).getSchoolName().equals("FLORIDA TECH"));
	}

}
