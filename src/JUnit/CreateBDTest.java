package JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import logica.datos.CreateBD;

public class CreateBDTest {
	
	private CreateBD database;

	@Before
	public void setUp() throws Exception {
		
		database=new CreateBD("PizzeriaTest.bd");
		database.createNewDatabase("PizzeriaPrueba.bd");
		database.createLink();
		//INICIALIZAR
	}

	@Test
	public void testCreateBD() {
		
		//llamr a los otro test
		fail("Not yet implemented");
	}
	
	@After
	public void tearDown() throws Exception {
		database.closeLink();
	}
	

}
