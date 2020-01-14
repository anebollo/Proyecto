package JUnit;

import static org.junit.Assert.*;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import logica.datos.CreateBD;
import logica.negocios.Repartidor;

/**
 * este es la clase donde se testea todo lo de la BD de repartidores
 * @author Alumno
 *
 */
public class RepartidorBDTest {

	private CreateBD bd;
	
	@Before
	/**
	 * este es el metodo dodne se inicializan los valores
	 * @throws Exception
	 */
	public void setUp() throws Exception {
		
		bd = new CreateBD("PizzeriaPrueba.bd");
		bd.createLink();
	}
	
	@After
	/**
	 * este es el metodo donde se cierra la conexion despues de testear
	 * @throws Exception
	 */
	public void tearDown() throws Exception {
		bd.closeLink();

	}
	
	@Test
	/**
	 * este es el metodo donde se testea si se a creado o no la tabla
	 * @throws SQLException
	 */
	public void testFail() throws SQLException {

		logica.datos.AdministradorBD.insertAdministrador(bd.getConn(), "12345678G", 200, 5,"anetxu", "anebo9");


		fail("Tabla no creada");
	}

	@Test
	/**
	 * este es el metodo donde se testea el insert
	 * @throws SQLException
	 */
	public void testInsert() throws SQLException {
		
		logica.datos.RepartidorBD.createRepartidorTable(bd.getConn());
		logica.datos.RepartidorBD.insertRepartidor(bd.getConn(), "12345689K", 250, 8, "03-01-2022");
		ArrayList<Repartidor>leido=logica.datos.RepartidorBD.selectAllRepartidor(bd.getConn());
		
		for(Repartidor a:leido) {
			
			if(a.getDni().equals("12345689K")) {
				
				assertEquals(a.getSueldo(),250);
				assertEquals(a.getHorasDia(),8);
				
				SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
				String fechaS = format.format(a.getCadCarne());
				assertEquals(fechaS,"03-01-2022");
			}
		}
		
		logica.datos.RepartidorBD.insertRepartidor(bd.getConn(), "12345633P", 250, 8, null);
		ArrayList<Repartidor>leido1=logica.datos.RepartidorBD.selectAllRepartidor(bd.getConn());
		
		for(Repartidor a:leido1) {
			
			if(a.getDni().equals("12345633P")) {
				
				assertNotEquals(a.getSueldo(),300);
				assertNotEquals(a.getHorasDia(),7);
				
				SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
				String fechaS = format.format(a.getCadCarne());
				assertNotEquals(fechaS,"11-01-2022");
				assertNull(a.getCadCarne());
			}
		}
		
	}
	
	@Test
	/**
	 * este es el metodo donde se testea el select
	 * @throws SQLException
	 */
	public void testSelect() throws SQLException {
		
		logica.datos.RepartidorBD.createRepartidorTable(bd.getConn());
		logica.datos.RepartidorBD.insertRepartidor(bd.getConn(), "12345689K", 250, 8, "03-01-2022");
		ArrayList<Repartidor>leido=logica.datos.RepartidorBD.selectAllRepartidor(bd.getConn());
		
		for(Repartidor a:leido) {
			
			if(a.getDni().equals("12345689K")) {
				
				assertEquals(a.getSueldo(),250);
				assertEquals(a.getHorasDia(),8);
				
				SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
				String fechaS = format.format(a.getCadCarne());
				assertEquals(fechaS,"03-01-2022");
			}
		}
		
		logica.datos.RepartidorBD.insertRepartidor(bd.getConn(), "12345699A", 340, 10, "11-02-2023");
		ArrayList<Repartidor>leido1=logica.datos.RepartidorBD.selectAllRepartidor(bd.getConn());
		
		for(Repartidor a:leido1) {
			
			if(a.getDni().equals("12345699A")) {
				
				assertNotEquals(a.getSueldo(),250);
				assertNotEquals(a.getHorasDia(),8);
				
				SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
				String fechaS = format.format(a.getCadCarne());
				assertNotEquals(fechaS,"03-01-2022");
			}
		}
		
	}
	

	@Test
	/**
	 * este es el metodo donde se testea el update
	 * @throws SQLException
	 */
	public void testUpdate() throws SQLException {
		
		logica.datos.RepartidorBD.createRepartidorTable(bd.getConn());
		logica.datos.RepartidorBD.insertRepartidor(bd.getConn(), "12345611L", 280, 9, "11-01-2021");
		logica.datos.RepartidorBD.updateRepartidor(bd.getConn(), "12345611L", 300, 8, "11-01-2021");
		ArrayList<Repartidor>leido=logica.datos.RepartidorBD.selectAllRepartidor(bd.getConn());
		
		for(Repartidor a:leido) {
			
			if(a.getDni().equals("12345611L")) {
				
				assertEquals(a.getSueldo(),300);
				assertEquals(a.getHorasDia(),8);
				
				SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
				String fechaS = format.format(a.getCadCarne());
				assertEquals(fechaS,"11-01-2021");
				
				assertNotEquals(a.getSueldo(),280);
				assertNotEquals(a.getHorasDia(),9);
			}
		}
		
		
		
	}
	

	@Test
	/**
	 * este es el metodo donde se testea el delete
	 * @throws SQLException
	 */
	public void testDelete() throws SQLException {
		

		logica.datos.RepartidorBD.createRepartidorTable(bd.getConn());
		logica.datos.RepartidorBD.insertRepartidor(bd.getConn(), "12345622A", 280, 7, "11-11-2020");
		logica.datos.RepartidorBD.delete(bd.getConn(), "12345622A");
		ArrayList<Repartidor>leido=logica.datos.RepartidorBD.selectAllRepartidor(bd.getConn());
		
		for(Repartidor a:leido) {
			
			assertNotEquals(a.getDni(),"12345622A");
			
		}
		
	}

}
