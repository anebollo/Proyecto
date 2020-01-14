package JUnit;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import logica.datos.CreateBD;
import logica.negocios.Factura;
/**
 * esta es la clase donde se teste todo lo de la BD de las facturas
 * @author Alumno
 *
 */
public class FacturaBDTest {

	private CreateBD bd;

	@Before
	/**
	 * este es el metodo donde se inicializan los valores
	 * @throws Exception
	 */
	public void setUp() throws Exception {

		bd = new CreateBD("PizzeriaPrueba.bd");
		bd.createLink();
	}

	@After
	/**
	 * este es el metodo donde se cierra al conexion despues de testear
	 * @throws Exception
	 */
	public void tearDown() throws Exception {
		bd.closeLink();

	}

	@Test
	/**
	 * este es el metodo donde se testea si se ha creado o no la tabla
	 * @throws SQLException
	 */
	public void testFail() throws SQLException {

		logica.datos.AdministradorBD.insertAdministrador(bd.getConn(), "12345678G", 200, 5, "anetxu", "anebo9");

		fail("Tabla no creada");
	}

	@Test
	/**
	 * este es el metodo donde se testea el insert de facturas
	 */
	public void testInsert() {

		logica.datos.FacturaBD.createFacturaTable(bd.getConn());
		ArrayList<String> pizzas = new ArrayList<>();
		pizzas.add("Carbonara");
		pizzas.add("Jamon y queso");
		pizzas.add("Hawaiiana");

		logica.datos.FacturaBD.insertFactura(bd.getConn(), 12, "02-12-2019", 24, pizzas);

		ArrayList<Factura> leido = logica.datos.FacturaBD.selectAllFactura(bd.getConn());

		for (Factura a : leido) {

			if (a.getNumFac() == 12) {

				SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
				String fechaS = format.format(a.getFecha());
				assertEquals(fechaS, "02-12-2019");
				assertNotEquals(fechaS,"21-10-2019");
				
				assertEquals(a.getCoste(), 24);
				assertNotEquals(a.getCoste(),0);

				for (int i = 0; i < pizzas.size(); i++) {

					assertEquals(pizzas.get(0), "Carbonara");
					assertEquals(pizzas.get(1), "Jamon y queso");
					assertEquals(pizzas.get(2), "Hawaiiana");
					
					assertNotEquals(pizzas.get(0), "Jamon y queso");
					assertNotEquals(pizzas.get(1), "Hawaiiana");
					assertNotEquals(pizzas.get(2), "Carbonara");

				}
			}
		}

	}

	@Test
	/**
	 * este es el metodo donde se testea el select de facturas
	 */
	public void select() {
		

		logica.datos.FacturaBD.createFacturaTable(bd.getConn());
		ArrayList<String> pizzas = new ArrayList<>();
		pizzas.add("4 quesos");
		pizzas.add("Jamon y queso");
		pizzas.add("Barbacoa");

		logica.datos.FacturaBD.insertFactura(bd.getConn(), 13, "03-01-2020", 24, pizzas);

		ArrayList<Factura> leido = logica.datos.FacturaBD.selectAllFactura(bd.getConn());

		for (Factura a : leido) {

			if (a.getNumFac() == 13) {

				SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
				String fechaS = format.format(a.getFecha());
				assertEquals(fechaS, "03-01-2020");
				assertNotEquals(fechaS,"22-01-2021");
				
				assertEquals(a.getCoste(), 24);
				assertNotEquals(a.getCoste(),22);

				for (int i = 0; i < pizzas.size(); i++) {

					assertEquals(pizzas.get(0), "4 quesos");
					assertEquals(pizzas.get(1), "Jamon y queso");
					assertEquals(pizzas.get(2), "Barbacoa");
					
					assertNotEquals(pizzas.get(0), "Jamon y queso");
					assertNotEquals(pizzas.get(1), "Barbacoa");
					assertNotEquals(pizzas.get(2), "4 quesos");
					

				}
			}
		}

	}

}
