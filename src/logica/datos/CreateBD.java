package logica.datos;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import logica.negocios.Administrador;
import logica.negocios.Factura;
import logica.negocios.Repartidor;

/**
 * Es el gestor de la base de datos
 * 
 * @author Ane y Aitor
 */
public class CreateBD {

	private Connection conn;
	private String BDname;
	private final String URL = "jdbc:sqlite:";

	/**
	 * Es el constructor
	 * 
	 * @param BDname
	 *            el nombre de la base de datos
	 */
	

	public CreateBD(String BDname) {
		this.BDname = this.URL + BDname;

	}


	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	/**
	 * Lanza el gestor
	 */
	public void inicializarBD() {


		try {
			
			// crear las tablas cliente, administrador y repartidor y factura
			ClienteBD.createClienteTable(this.conn);
			AdministradorBD.createAdministradorTable(this.conn);
			RepartidorBD.createRepartidorTable(this.conn);
			FacturaBD.createFacturaTable(this.conn);

			// insertar datos en la tabla cliente
			ArrayList<String> pizzas = new ArrayList<String>();
			pizzas.add("Jamon y queso");
			pizzas.add("Barbacoa");
			ArrayList<Integer> numVeces = new ArrayList<Integer>();
			numVeces.add(2);
			numVeces.add(3);
			ClienteBD.insertCliente(this.conn,"12345679A","943429440", pizzas, numVeces);

			ArrayList<String> pizzas1 = new ArrayList<String>();
			pizzas1.add("Jamon y queso");
			pizzas1.add("Barbacoa");
			pizzas1.add("Carbonara");
			ArrayList<Integer> numVeces1 = new ArrayList<Integer>();
			numVeces1.add(1);
			numVeces1.add(3);
			numVeces1.add(2);
			ClienteBD.insertCliente(this.conn,"31425345G","674782688", pizzas1, numVeces1);

			// insertar datos en la tabla administrador
			AdministradorBD.insertAdministrador(this.conn,"73036696N", 3000, 7, "anebo", "deusto9");
			AdministradorBD.insertAdministrador(this.conn,"73036696F", 4000, 8, "marino", "deusto90");
			AdministradorBD.insertAdministrador(this.conn,"74739274G", 3500, 7, "aitor", "1999E");
			AdministradorBD.insertAdministrador(this.conn,"12345678H", 3000, 5, "mati", "deusto999");
			AdministradorBD.insertAdministrador(this.conn,"98765432G", 6000, 4, "olatz", "deusto779");

//			// insertar datos en la tabla repartidor
			
			
			RepartidorBD.insertRepartidor(this.conn,"73036678F", 2000, 9, "07-03-2020");
			RepartidorBD.insertRepartidor(this.conn,"73035485K", 1000, 4, "07-09-2020");
			RepartidorBD.insertRepartidor(this.conn,"73554333F", 2000, 9, "07-09-2029");

//			// insertar datos en la tabla factura
			ArrayList<String> pizzas2 = new ArrayList<String>();
			pizzas2.add("Jamon y queso");
			pizzas2.add("Barbacoa");
			pizzas2.add("Carbonara");
			FacturaBD.insertFactura(this.conn,1, "25-11-2019", 23, pizzas2);

			ArrayList<String> pizzas3 = new ArrayList<String>();
			pizzas3.add("Jamon y queso");
			pizzas3.add("Barbacoa");
			FacturaBD.insertFactura(this.conn,2, "07-11-2019", 15, pizzas3);
			
		
//			// Last step - Close connection
			//this.closeLink();

		} catch (SQLException e) {
			
			System.out.println("Process terminated with errors");
		} 

	}

	/**
	 * Sirve para crear la conexion con la base de datos
	 * 
	 */
	public void createLink(){
		try {
			this.conn = DriverManager.getConnection(this.BDname);
	
		} catch (SQLException e) {
			System.out.println("BadAss error creating connection. " + e.getMessage());
		}
	}

	/**
	 * Connect to a sample database
	 *
	 * @param fileName
	 *            the database file name
	 */
	public static void createNewDatabase(String fileName) {

		String url = "jdbc:sqlite:" + fileName;

		try (Connection conn = DriverManager.getConnection(url)) {
			if (conn != null) {
				DatabaseMetaData meta = conn.getMetaData();
				System.out.println("The driver name is " + meta.getDriverName());
				System.out.println("A new database has been created.");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}



	/**
	 * Sirve para cerrar la conexion
	 * 
	 */

	public void closeLink(){

		try {

			if (this.conn != null) {

				this.conn.close();
			}
		} catch (SQLException ex) {

			System.out.println("BadAss error closing connection" + ex.getMessage());

		}

	}
}
