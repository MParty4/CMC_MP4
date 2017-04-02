package CMCTestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import cmc.mario.controllersTest.*;
import cmc.mario.entitiesTest.*;
@RunWith(Suite.class)
@SuiteClasses({AccountTest.class,AdminTest.class, UserTest.class})

public class AllTests {

}
