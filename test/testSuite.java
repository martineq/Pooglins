import junit.framework.Test;
import junit.framework.TestSuite; 

public class testSuite {
 public static Test suite() { 
	 TestSuite suite = new TestSuite("Test");
       suite.addTestSuite(FuegoTest.class);
       suite.addTestSuite(HieloTest.class);       
       suite.addTestSuite(PlatilloTest.class);       
       suite.addTestSuite(PooglinTest.class);       
       suite.addTestSuite(VacioTest.class);       
       suite.addTestSuite(NivelTest.class);       
      return suite; 
     }
}



