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

	public void run() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your username:");
		String username = sc.next();
		System.out.println("Please enter your password:");
		String password = sc.next();
		System.out.println(acct.typeOfUser(username));
		
		//usr testing except search -Tre
		//U2 saveSchool
		usr = (UserUI)acct.logOn(username, password);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//admin-Yidan
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Recommandetion --Jing

	}
	public static void main(String[] args){
		CMCDriver cd = new CMCDriver();
		cd.run();
	}
}
