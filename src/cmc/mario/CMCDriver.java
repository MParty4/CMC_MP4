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
		
		
		
		
		
		//Search and Account UI - Kalila
		//U5: Search for Schools
		//U6: View Search Results
		//U7: View Specific School
		//U21: Logout
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
