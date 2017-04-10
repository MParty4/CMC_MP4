package cmc.mario.test.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import FunctionalityTest.FunctionalityTest;
import controller.*;
import entities.*;

@RunWith(Suite.class)
@SuiteClasses({AccountControllerTest.class, AdminFuncControllerTest.class, DBControllerTest.class
	,SearchControllerTest.class, UserFuncControllerTest.class, AccountTest.class, AdminTest.class, UniversityTest.class
	,UserTest.class, FunctionalityTest.class})
public class AllTests {

}
