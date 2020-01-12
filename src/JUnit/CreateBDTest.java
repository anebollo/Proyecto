package JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import logica.datos.CreateBD;

public class CreateBDTest {
	
	private CreateBD ane;

	@Before
	public void setUp() throws Exception {
		
		ane=new CreateBD("ANE.bd");
		ane.createNewDatabase("ANE.bd");
		ane.createLink();
		//CREAR LINK
		//INICIALIZAR
	}

	@Test
	public void testCreateBD() {
		
		//llamr a los otro test
		fail("Not yet implemented");
	}
	
	@After
	public void tearDown() throws Exception {
		ane.closeLink();
	}
	

}
