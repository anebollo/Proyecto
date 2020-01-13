package JUnit;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import logica.datos.CreateBD;
import logica.negocios.Administrador;

public class AdministradorBDTest {

	private CreateBD bd = null;

	@Before
	public void setUp() throws Exception {

		bd = new CreateBD("PizzeriaPrueba.bd");
		bd.createLink();

	}

	@After
	public void tearDown() throws Exception {
		bd.closeLink();

	}

	@Test
	public void testFail() throws SQLException {

		logica.datos.AdministradorBD.insertAdministrador(bd.getConn(), "12345678G", 200, 5,"anetxu", "anebo9");


		fail("Tabla no creada");
	}

	@Test
	public void testInsert() throws SQLException {

		logica.datos.AdministradorBD.createAdministradorTable(bd.getConn());
		logica.datos.AdministradorBD.insertAdministrador(bd.getConn(), "73036697N", 300, 4, "olatz99", "jelou");
		ArrayList<Administrador> leido = logica.datos.AdministradorBD.selectAllAdministrador(bd.getConn());

		for (Administrador a : leido) {

			if (a.getDni().equals("73036697N")) {

				assertEquals(a.getSueldo(), 300);
				assertEquals(a.getHorasDia(), 4);
				assertEquals(a.getNombre(), "olatz99");
				assertEquals(a.getContraseña(), "jelou");

				assertNotEquals(a.getSueldo(), 200);
				assertNotEquals(a.getHorasDia(), 5);
				assertNotEquals(a.getNombre(), "olatz");
				assertNotEquals(a.getContraseña(), "je");
			}
		}

		
	}

	@Test
	public void select() throws SQLException {

		logica.datos.AdministradorBD.createAdministradorTable(bd.getConn());
		logica.datos.AdministradorBD.insertAdministrador(bd.getConn(), "73036697N", 300, 4, "olatz99", "jelou");
		ArrayList<Administrador> leido = logica.datos.AdministradorBD.selectAllAdministrador(bd.getConn());

		for (Administrador a : leido) {

			if (a.getDni().equals("73036697N")) {

				assertEquals(a.getSueldo(), 300);
				assertEquals(a.getHorasDia(), 4);
				assertEquals(a.getNombre(), "olatz99");
				assertEquals(a.getContraseña(), "jelou");

				assertNotEquals(a.getSueldo(), 200);
				assertNotEquals(a.getHorasDia(), 5);
				assertNotEquals(a.getNombre(), "olatz9");
				assertNotEquals(a.getContraseña(), "je");
				
		
				
			}
		}
		
		logica.datos.AdministradorBD.insertAdministrador(bd.getConn(), "73036697N", 300, 4, null, "jelou");
		ArrayList<Administrador> leido2 = logica.datos.AdministradorBD.selectAllAdministrador(bd.getConn());

		for (Administrador a : leido) {

			if (a.getDni().equals("73036697N")) {

				assertEquals(a.getSueldo(), 300);
				assertEquals(a.getHorasDia(), 4);
				assertEquals(a.getNombre(), "olatz99");
				assertEquals(a.getContraseña(), "jelou");

				assertNotEquals(a.getSueldo(), 200);
				assertNotEquals(a.getHorasDia(), 5);
				assertNotEquals(a.getNombre(), "olatz9");
				assertNotEquals(a.getContraseña(), "je");
				
				assertNull(a.getNombre());
				
			}
		}

	}

}
