import junit.framework.Test;
import junit.framework.TestSuite; 

public class SuiteTest {
 public static Test suite() { 
	 TestSuite suite = new TestSuite("Test");
       suite.addTestSuite(FuegoTest.class);
       suite.addTestSuite(HieloTest.class);       
       suite.addTestSuite(PlatilloTest.class);       
       suite.addTestSuite(PooglinTest.class);       
       suite.addTestSuite(VacioTest.class);       
       suite.addTestSuite(PuertaTest.class);       
       suite.addTestSuite(CongelamientoTest.class); 
       suite.addTestSuite(VelocidadTest.class);        
       suite.addTestSuite(MorirTest.class);        
       suite.addTestSuite(HabilidadesEnNivelTest.class);        
       suite.addTestSuite(TerrenoEnNivelTest.class);    
       suite.addTestSuite(TaladroTest.class);   
       suite.addTestSuite(RayoLaserTest.class);   
       suite.addTestSuite(NivelTest.class);   
       suite.addTestSuite(AgujeroNegroTest.class);
       suite.addTestSuite(TeletransportarseTest.class);
       suite.addTestSuite(TunelTest.class);
       return suite; 
     }
}



