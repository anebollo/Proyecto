package logica.datos;

import java.sql.Statement;

import java.util.ArrayList;
import java.util.Arrays;

import logica.negocios.Administrador;
import logica.negocios.Cliente;
import logica.negocios.Pizza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Esta clase es todo lo que corresponde para la tabla de los clientes de la
 * base de datos
 * 
 * @author Ane y Aitor
 *
 */
public class ClienteBD {

	/**
	 * Este metodo sirve para crear la tabla de los clientes
	 * 
	 * @param conn
	 *            es la conexion de la base de datos
	 */
	public static void createClienteTable(Connection conn) {

		// SQL statement for creating a new table
		String sql = "CREATE TABLE IF NOT EXISTS cliente (\n" 
				+ "    DNI text PRIMARY KEY,\n"
				+ "    telefono text NOT NULL,\n" 
				+ "    nombrePizzas text NOT NULL,\n" 
				+ "    numVeces text NOT NULL\n"
				+ ");";

		try (Statement stmt = conn.createStatement()) {
			// create a new table

			stmt.execute(sql);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Este metodo sirve para insertar los clientes en la base de datos
	 * 
	 * @param conn
	 *            es la conexion de la base de datos
	 * @param DNI
	 *            es el dni del cliente
	 * @param telefono
	 *            es el telefono del cliente
	 * @param nombrePizzas
	 *            es una lista de todas las pizzas que pide el cliente
	 * @param numVeces
	 *            si no se puede realizar salta la excepción sqlexception
	 */
	public static void insertCliente(Connection conn, String DNI, String telefono, ArrayList<String> nombrePizzas,
			ArrayList<Integer> numVeces) {
		String sql = "INSERT INTO cliente(DNI,telefono,pizzas,contadorVeces) VALUES(?,?,?,?)";
		String pizzas = null;
		String contadorVeces = null;

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			for (int i = 0; i < nombrePizzas.size(); i++) {

				if (i == nombrePizzas.size() - 1) {
					pizzas += nombrePizzas.get(i);
				}
				pizzas += nombrePizzas.get(i) + ",";

			}

			for (int i = 0; i < numVeces.size(); i++) {

				if (i == numVeces.get(i) - 1) {
					contadorVeces += numVeces.get(i);
				}

				contadorVeces += numVeces.get(i) + ",";

			}
			pstmt.setString(1, DNI);
			pstmt.setString(2, telefono);
			pstmt.setNString(3, pizzas);
			pstmt.setString(4, contadorVeces);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Este metodo sirve para seleccionar todos los clientes de la base de datos
	 * 
	 * @param conn
	 *            es la conexion de la base de datos
	 * @return devuelve todos los clientes de la base de datos
	 */
	public static ArrayList<Cliente> selectAllCliente(Connection conn) {
		String sql = "SELECT DNI, telefono, nombrePizzas, numVeces FROM cliente";
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			while (rs.next()) {

				String dni = rs.getString("DNI");
				String tlf = rs.getString("telefono");

				// COMO LEER LOS STRING CON , DE LAS PIZZAS Y VECES
				String[] pizzas = rs.getString("nombrePizzas").split(",");
				ArrayList<String> listaPizzas = new ArrayList<String>(Arrays.asList(pizzas));

				// COMO LEER LOS STRING CON , DE LAS PIZZAS Y VECES
				String[] veces = rs.getString("numVeces").split(",");
				ArrayList<Integer> listaVeces = new ArrayList<Integer>();

				for (int i = 0; i < veces.length; i++) {
					String recogido = veces[i];
					int vez = Integer.parseInt(recogido);
					listaVeces.add(vez);

				}

				Cliente seleccionado = new Cliente(dni, tlf, listaPizzas, listaVeces);
				lista.add(seleccionado);

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return lista;
	}

	/**
	 * Este metodo sirve para eliminar un cliente de la base de datos
	 * 
	 * @param conn
	 *            es la conexion de la base de datos
	 * @param dni
	 *            es el dni del cliente
	 */
	public static void delete(Connection conn, String dni) {
		String sql = "DELETE FROM cliente WHERE dni = ?";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			// set the corresponding param
			pstmt.setString(1, dni);

			// execute the delete statement
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
