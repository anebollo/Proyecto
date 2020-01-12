package logica.datos;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import logica.negocios.Repartidor;

/**
 * Es la clase donde estan los diferentes metodos que corresponden a la tabla de
 * los repartidores que estan en la base de datos
 * 
 * @author Ane y Aitor
 *
 */

public class RepartidorBD {

	/**
	 * Este metodo crea la tabla de los repartidores
	 * 
	 * @throws SQLException
	 *             si no se puede realizar salta la excepción sqlexception
	 */

	public static void createRepartidorTable(Connection conn) throws SQLException {

		// SQL statement for creating a new table
		String sql = "CREATE TABLE IF NOT EXISTS repartidor (\n" 
				+ "    DNI text PRIMARY KEY,\n"
				+ "    sueldo integer NOT NULL,\n" 
				+ "    horasDia integer NOT NULL,\n" 
				+ " cadCarne text NOT NULL\n"
				+ " );";

		try (Statement stmt = conn.createStatement()) {
			// create a new table
			stmt.execute(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Este metodo sirve para insertar los repartidores en la base de datos
	 * 
	 * @param DNI
	 *            es el dni del repartidor
	 * @param sueldo
	 *            es el sueldo del repartidor
	 * @param horasDia
	 *            es las horas qe trabaja al dia el repartidor
	 * @param cadCarne
	 *            es la fecha de caducidad del carnet de conducir del repartidor
	 * @throws SQLException
	 *             si no se puede realizar salta la excepción sqlexception
	 */
	public static void insertRepartidor(Connection conn,String DNI, int sueldo, int horasDia, String cadCarne){
		String sql = "INSERT INTO repartidor(DNI,sueldo, horasDia,cadCarne) VALUES(?,?,?,?)";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, DNI);
			pstmt.setInt(2, sueldo);
			pstmt.setInt(3, horasDia);
			pstmt.setString(4, cadCarne);
			pstmt.execute();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Es el metodo que selecciona todos los repartidores de la base de datos
	 * 
	 * @param conn es la conexion de la base de datos
	 *  
	 * @return devuelve todos los repartidores de la base de datos en un array
	 */
	public static ArrayList<Repartidor> selectAllRepartidor(Connection conn) {
		String sql = "SELECT DNI, sueldo, horasDia,cadCarne FROM repartidor";
		ArrayList<Repartidor> lista = new ArrayList<Repartidor>();

		try (Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			while (rs.next()) {

				String dni = rs.getString("DNI");
				int sueldo = rs.getInt("sueldo");
				int horas = rs.getInt("horasDia");
				String date = rs.getString("cadCarne");

				Date caducidadCar = null;
				try {
					caducidadCar = (Date) new SimpleDateFormat("dd-MM-yyyy").parse(date);

				} catch (ParseException e) {

					e.printStackTrace();
				}

				Repartidor seleccionado = new Repartidor(dni, sueldo, horas, caducidadCar);
				lista.add(seleccionado);

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return lista;
	}

	/**
	 * Es el metodo que modifica los repartidores de la base de datos
	 * 
	 * @param conn es la conexion de la base de datos
	 *  
	 * @param conn es la conexion de la base de datos
	 *  
	 * @param DNI
	 *            es el dni del repartidor
	 * @param sueldo
	 *            es el sueldo del repartidor
	 * @param horasDia
	 *            es las horas qe trabaja al dia el repartidor
	 * @param cadCarne
	 *            es la fecha de caducidad del carnet de conducir del repartidor
	 */
	public static void updateRepartidor(Connection conn,String DNI, int sueldo, int horasDia, String cadCarne){
		String sql = "UPDATE repartidor SET sueldo = ? , horasDia = ? , cadCarne= ? WHERE id = ?";


		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			// set the corresponding param
			pstmt.setString(1, DNI);
			pstmt.setDouble(2, sueldo);
			pstmt.setInt(3, horasDia);
			pstmt.setString(4, cadCarne);

			// update
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * elimina el estudiante
	 * 
	 * @param conn es la conexion de la base de datos
	 * 
	 * @param dni
	 *            el dni del repartidor
	 */

	public static void delete(Connection conn,String dni) {
		String sql = "DELETE FROM repartidor WHERE dni = ?";

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
