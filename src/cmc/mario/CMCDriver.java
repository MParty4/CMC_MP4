package cmc.mario;
import cmc.mario.entities.*;
import cmc.mario.interfaces.*;
import cmc.mario.controllers.*;
import java.util.*;

public class CMCDriver {
	private AccountUI acct;
	private UserUI usr;
	private AdminUI adm;
	/**
	 * @param acct
	 */
	public CMCDriver() {
		acct = new AccountUI();
		
	}

	public void run() throws NullPointerException{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your username:");
		String username = sc.next();
		System.out.println("Please enter your password:");
		String password = sc.next();
		System.out.println(acct.typeOfUser(username));
		
		//usr testing except search -Tre
		//U2 saveSchool
		//usr = (UserUI)acct.logOn(username, password);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//admin-Yidan
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Recommendation --Jing
		System.out.println("START OF RECOMMENDATION CLASS");
		List<University> uniList = new ArrayList<University>();
		List<String> popMajors = new ArrayList<String>();
		SearchController seCon = new SearchController();
		String m1 = "Biology";
		String m2 = "Computer Science";
		popMajors.add(m1);
		popMajors.add(m2);
		University bitch = new University("ABILENE CHRISTIAN UNIVERSITY","TEXAS","SUBURBAN","PRIVATE",
				10000, 50 , -1,-1 ,12088, 70 ,4000,90 , 80 , 2,3,3,popMajors);
		University bitch1 = new University("AUBURN","NEW YORK","SMALL-CITY","STATE",35000
				,21,480,545,12468,50,5500,90,60,2,4,4,popMajors);
		University bitch2 = new University("ARIZONA STATE","ARIZONA","-1","STATE",40000
				,59,450,500,16181,50,17000,80,60,3,4,5, popMajors);
		University bitch3 = new University("BARD","NEW YORK","SMALL-CITY","PRIVATE",10000,55
				,560,520,32239,80,4000,70,30,3,4,4,popMajors);
		University bitch4 = new University("AUGSBURG","MINNESOTA","SMALL-CITY","PRIVATE",10000
				,43,420,490,29991,80,4000,85,50,1,3,4,popMajors);
		University bitch5 = new University("BARNARD","NEW YORK","URBAN","PRIVATE",10000
				,100,630,610,31009,60,4000,60,20,4,3,4,popMajors);
		University bitch6 = new University("BAYLOR UNIVERSITY", "TEXAS","URBAN","PRIVATE",15000
				,55,485,521,21658,65,11500,65,75,4,4,3,popMajors);
		uniList.add(bitch);
		uniList.add(bitch1);
		uniList.add(bitch2);
		uniList.add(bitch3);
		uniList.add(bitch4);
		uniList.add(bitch5);
		uniList.add(bitch6);
		seCon.viewRecommendation(bitch);
		System.out.println("END OF RECOMMENDATION CLASS");
		
		
		
		
		
//		Search and Account UI - Kalila
//		U5: Search for Schools
//		U6: View Search Results
//		U7: View Specific School
//		U21: Logout
		List<String> popMajor = new ArrayList<String>(5);
		String s1 = "Biology";
		String s2 = "Art-history";
		popMajor.add(s1);
		popMajor.add(s2);
		List<University> uni = new ArrayList<University>(10);
		String school = "Arizona State";
		String loc = "Ari";
		String state = null;
		String cont = "st";
		int numOfStuStart = 35000;
		Integer numOfStuSt = numOfStuStart;
		int numOfStuEnd = 45000;
		Integer numOfStuEn = numOfStuEnd;
		int perFemStart = (Integer) null;
		Integer perFemSt = perFemStart;
	    int perFemEnd = (Integer) null;
	    Integer perFemEn = perFemEnd;		
	    int satVerbalStart = (Integer) null;
	    		Integer satVerbalSt = satVerbalStart;
	    int satVerbalEnd= (Integer) null;
	    		Integer satVerbalEn = satVerbalEnd;
	    int satMathStart=(Integer) null;
	    		Integer satMathSt = satMathStart;
	    int satMathEnd=(Integer) null;
	    		Integer satMathEn = satMathEnd;
	    int priceStart=(Integer) null;
	    		Integer priceSt = priceStart;
	    int priceEnd=(Integer) null;
	    		Integer priceEn = priceEnd;
	    int finAidStart=(Integer) null;
	    		Integer finAidSt = finAidStart;
	    int finAidEnd=(Integer) null;
	    		Integer finAidEn = finAidEnd;
	    int numOfAppStart=(Integer) null;
	    		Integer numOfAppSt = numOfAppStart;
	    int numOfAppEnd= (Integer) null;
	    		Integer numOfAppEn = numOfAppEnd;
	    int perAdmitStart=(Integer) null;
	    		Integer perAdmitSt = perAdmitStart;
	    int perAdmitEnd=(Integer) null;
	    		Integer perAdmitEn = perAdmitEnd;
	    int perEnrollStart=(Integer) null;
	    		Integer perEnrollSt = perEnrollStart;
	    int perEnrollEnd=(Integer) null;
	    		Integer perEnrollEn = perEnrollEnd;
	    int academicScaleStart=(Integer) null;
	    		Integer academicScaleSt = academicScaleStart;
	    int academicScaleEnd=(Integer) null;
	    		Integer academicScaleEn = academicScaleEnd;
	    int socialScaleStart=(Integer) null;
	    		Integer socialScaleSt = socialScaleStart;
	    int socialScaleEnd=(Integer) null;
	    		Integer socialScaleEn = socialScaleEnd;
	    int lifeScaleStart=(Integer) null;
	    		Integer lifeScaleSt = lifeScaleStart;
	    int lifeScaleEnd= (Integer) null;
	    		Integer lifeScaleEn = lifeScaleEnd;
	    
		uni = usr.search(school, state, loc, cont, numOfStuSt, numOfStuEn, perFemSt, perFemEn, satVerbalSt, satVerbalEn, satMathSt, satMathEn, priceSt, priceEn, finAidSt, finAidEn, numOfAppSt, numOfAppEn, perAdmitSt, perAdmitEn, perEnrollSt, perEnrollEn, academicScaleSt, academicScaleEn, socialScaleSt, socialScaleEn, lifeScaleSt, lifeScaleEn, popMajor);
		for(int i = 0; i < uni.size(); i++){
			System.out.println(i);
		}

	}
	public static void main(String[] args){
		CMCDriver cd = new CMCDriver();
		cd.run();
	}
}
