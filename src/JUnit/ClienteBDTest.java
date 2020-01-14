package JUnit;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.Messaging.SyncScopeHelper;

import junit.framework.Assert;
import logica.datos.CreateBD;
import logica.negocios.Cliente;

/**
 * esta es la clase para testear todo lo de la BD de los clientes
 * @author Alumno
 *
 */
public class ClienteBDTest {

	private CreateBD bd;

	@Before
	/**
	 * este es el metodo para inicializar los valores
	 * @throws Exception
	 */
	public void setUp() throws Exception {

		bd = new CreateBD("PizzeriaPrueba.db");
		// bd.createNewDatabase("PizzeriaPrueba.db");
		bd.createLink();
	}

	@After
	/**
	 * este es el metodo para cerrar la conexion al finalziar de testear
	 * @throws Exception
	 */
	public void tearDown() throws Exception {
		bd.closeLink();

	}

	@Test
	/**
	 * este es el metodo para ver si al tabla no se crea
	 * @throws SQLException
	 */
	public void testFail() throws SQLException {

		logica.datos.ClienteBD.createClienteTable(bd.getConn());
		fail("Tabla no creada");
	}

	@Test
	/**
	 * este es el metodo para testear el insert de clientes
	 */
	public void testInsert() {

		logica.datos.ClienteBD.createClienteTable(bd.getConn());

		ArrayList<String> pizzas = new ArrayList<>();
		pizzas.add("Jamon y queso");
		pizzas.add("4 quesos");
		ArrayList<Integer> veces = new ArrayList<>();
		veces.add(2);
		veces.add(1);
		logica.datos.ClienteBD.insertCliente(bd.getConn(), "71234567N", "943429440", pizzas, veces);
		ArrayList<Cliente> leido = logica.datos.ClienteBD.selectAllCliente(bd.getConn());

		for (Cliente a : leido) {

			if (a.getDNI().equals("71234567N")) {

				assertEquals(a.getTelefono(), "943429440");
				ArrayList<String> pizzaLeida = a.getNombrePizzas();
				ArrayList<Integer> vecesLeida = a.getNumVeces();

				assertEquals(pizzaLeida.get(0), "Jamon y queso");
				assertEquals(pizzaLeida.get(1), "4 quesos");

				int vez1 = vecesLeida.get(0);
				int vez2 = vecesLeida.get(1);

				assertEquals(vez1, 2);
				assertEquals(vez2, 1);

			}

			logica.datos.ClienteBD.insertCliente(bd.getConn(), "71234567N", null, pizzas, veces);
			ArrayList<Cliente> leido2 = logica.datos.ClienteBD.selectAllCliente(bd.getConn());

		}

		for (Cliente a : leido) {

			if (a.getDNI().equals("71234567N")) {

				assertNull(a.getTelefono());
				ArrayList<String> pizzaLeida = a.getNombrePizzas();
				ArrayList<Integer> vecesLeida = a.getNumVeces();

				assertNotEquals(pizzaLeida.get(0), "4 quesos");
				assertNotEquals(pizzaLeida.get(1), "Jamon y queso");

				int vez1 = vecesLeida.get(0);
				int vez2 = vecesLeida.get(1);

				assertNotEquals(vez1, 0);
				assertNotEquals(vez2, 2);

			}
		}
	}

	@Test
	/**
	 * este es el metodo para seleccionar el select de los clientes
	 */
	public void select() {

		logica.datos.ClienteBD.createClienteTable(bd.getConn());

		ArrayList<String> pizzas = new ArrayList<>();
		pizzas.add("Jamon y queso");
		pizzas.add("4 quesos");
		ArrayList<Integer> veces = new ArrayList<>();
		veces.add(2);
		veces.add(1);
		logica.datos.ClienteBD.insertCliente(bd.getConn(), "71234567N", "943429440", pizzas, veces);
		ArrayList<Cliente> leido = logica.datos.ClienteBD.selectAllCliente(bd.getConn());

		for (Cliente a : leido) {

			if (a.getDNI().equals("71234567N")) {

				assertEquals(a.getTelefono(), "943429440");
				ArrayList<String> pizzaLeida = a.getNombrePizzas();
				ArrayList<Integer> vecesLeida = a.getNumVeces();

				assertEquals(pizzaLeida.get(0), "Jamon y queso");
				assertEquals(pizzaLeida.get(1), "4 quesos");

				int vez1 = vecesLeida.get(0);
				int vez2 = vecesLeida.get(1);

				assertEquals(vez1, 2);
				assertEquals(vez2, 1);

			}

		}
		logica.datos.ClienteBD.insertCliente(bd.getConn(), "71234567N", null, pizzas, veces);
		ArrayList<Cliente> leido2 = logica.datos.ClienteBD.selectAllCliente(bd.getConn());

		for (Cliente a : leido) {

			if (a.getDNI().equals("71234567N")) {

				assertNull(a.getTelefono());
				ArrayList<String> pizzaLeida = a.getNombrePizzas();
				ArrayList<Integer> vecesLeida = a.getNumVeces();

				assertNotEquals(pizzaLeida.get(0), "4 quesos");
				assertNotEquals(pizzaLeida.get(1), "Jamon y queso");

				int vez1 = vecesLeida.get(0);
				int vez2 = vecesLeida.get(1);

				assertNotEquals(vez1, 0);
				assertNotEquals(vez2, 2);

			}
		}
	}

	@Test
	/**
	 * este es el metodo para testear el delete de los clientes
	 */
	public void delete() {

		logica.datos.ClienteBD.createClienteTable(bd.getConn());

		ArrayList<String> pizzas = new ArrayList<>();
		pizzas.add("Jamon y queso");
		pizzas.add("4 quesos");
		ArrayList<Integer> veces = new ArrayList<>();
		veces.add(2);
		veces.add(1);
		logica.datos.ClienteBD.insertCliente(bd.getConn(), "71234567N", "943429440", pizzas, veces);
		logica.datos.ClienteBD.delete(bd.getConn(), "71234567N");
		ArrayList<Cliente> leido = logica.datos.ClienteBD.selectAllCliente(bd.getConn());

		for (Cliente a : leido) {

			assertNotEquals(a.getDNI(), "71234567N");

		}

	}

}
