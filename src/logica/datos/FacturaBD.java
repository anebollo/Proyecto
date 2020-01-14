package logica.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

import logica.negocios.Administrador;
import logica.negocios.Factura;
import logica.negocios.Pizza;

/**
 * Es la clase donde estan los diferentes metodos que corresponden a la tabla de
 * los administradores que estan en la base de datos
 * 
 * @author Ane y aitor
 *
 */
public class FacturaBD {

	/**
	 * Este metodo crea la tabla de las facturas
	 * 
	 * @param conn
	 *            es la conexion de la base de datos
	 */
	public static void createFacturaTable(Connection conn) {
		;

		// SQL statement for creating a new table
		String sql = "CREATE TABLE IF NOT EXISTS factura (\n" + "    numFac integer PRIMARY KEY,\n"
				+ "    fecha text NOT NULL,\n" + "    coste integer NOT NULL,\n" + "    nombrePizzas text NOT NULL \n"
				+ ");";

		try (Statement stmt = conn.createStatement()) {
			// create a new table
			stmt.execute(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Es para insertar los datos de las facturas
	 * 
	 * @param conn
	 *            es la conexion de la base de datos
	 * 
	 * @param numFac
	 *            el numero de la factura que sirve para identificarla
	 * @param fecha
	 *            es la fecha de la factura
	 * @param coste
	 *            es el coste total de la factura
	 * @param pizzas
	 *            es el nombre de las pizzas compradas
	 */
	public static void insertFactura(Connection conn, int numFac, String fecha, int coste, ArrayList<String> pizzas) {
		String sql = "INSERT INTO factura(numFac,fecha,coste,nombrePizzas) VALUES(?,?,?,?)";
		String nombrePizzas = "";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			for (int i = 0; i < pizzas.size(); i++) {

				if (i == pizzas.size() - 1) {
					nombrePizzas += pizzas.get(i);
				} else if(i<pizzas.size()-1) {
					nombrePizzas += pizzas.get(i) + ",";

				}

			}

			pstmt.setInt(1, numFac);
			pstmt.setString(2, fecha);
			pstmt.setInt(3, coste);
			pstmt.setString(4, nombrePizzas);
			pstmt.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * selecciona todas las facturas
	 * 
	 * @param conn
	 *            es la conexion de la base de datos
	 * 
	 * @return devuelve las facturas de la base de datos en un array list
	 */
	public static ArrayList<Factura> selectAllFactura(Connection conn) {
		String sql = "SELECT numFac, fecha, coste, nombrePizzas FROM factura";
		ArrayList<Factura> lista = new ArrayList<Factura>();
		String fecha = null;
		int numfac = 0;
		int coste = 0;
		ArrayList<String> listaPizzas = new ArrayList<String>();

		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			while (rs.next()) {

				numfac = rs.getInt("numFac");
				fecha = rs.getString("fecha");
				coste = rs.getInt("coste");

				// COMO LEER LOS STRING CON , DE LAS PIZZAS Y VECES
				Collections.addAll(listaPizzas, rs.getString("nombrePizzas").split("\\s*,\\s*"));

				Date fechaFac = null;
				try {
					fechaFac = (Date) new SimpleDateFormat("dd-MM-yyyy").parse(fecha);

				} catch (ParseException e) {

					e.printStackTrace();
				}

				// pasar a arraylist

				Factura seleccionada = new Factura(numfac, fechaFac, coste, listaPizzas);
				lista.add(seleccionada);

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return lista;
	}

	/**
	 * este metood sirve para borrar facturas por su numero de factura
	 * @param conn la conexion de la base de datos	
	 * @param numFac el numero de la factura que se quiere borrar
	 */
	public static void delete(Connection conn, int numFac) {
		String sql = "DELETE FROM factura WHERE numFac = ?";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			// set the corresponding param
			pstmt.setInt(1, numFac);

			// execute the delete statement
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
