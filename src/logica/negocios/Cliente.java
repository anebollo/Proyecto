package logica.negocios;

import java.util.ArrayList;

/**
 * 
 * @author aitor y ane clase Cliente
 */
public class Cliente {

	private String telefono;
	private String DNI;
	private ArrayList<String> nombrePizzas;
	private ArrayList<Integer> numVeces;

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Los atributos que tiene el cliente de la pizzeria
	 * 
	 * @param telefono
	 *            del Cliente
	 * @param dNI
	 *            del Cliente
	 * @param nombrePizzas
	 *            que pide el Cliente
	 * @param numVeces
	 *            que pide el Cliente
	 */
	public Cliente(String dni, String telefono, ArrayList<String> nombrePizzas, ArrayList<Integer> numVeces) {
		super();
		this.telefono = telefono;
		this.DNI = dni;
		this.nombrePizzas = nombrePizzas;
		this.numVeces = numVeces;
	}

	/**
	 * Obtiene el telefono del Cliente
	 * 
	 * @return el numero de telefono del Cliente
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Establece el numero de telefono del Cliente
	 * 
	 * @param telefono
	 *            del Cliente
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Obtiene el dni del Cliente
	 * 
	 * @return el numero del dni del Cliente
	 */
	public String getDNI() {
		return DNI;
	}

	/**
	 * Establece el dni al cliente
	 * 
	 * @param dNI
	 *            del cliente
	 */
	public void setDNI(String dNI) {
		DNI = dNI;
	}

	/**
	 * Obtiene el nombre de le pizza que ha pedido el Cliente
	 * 
	 * @return nombre de la pizza
	 */
	public ArrayList<String> getNombrePizzas() {
		return nombrePizzas;
	}

	/**
	 * Establece el nombre de las pizzas de los clientes
	 * 
	 * @param nombrePizzas
	 *            del cliente
	 */
	public void setNombrePizzas(ArrayList<String> nombrePizzas) {
		this.nombrePizzas = nombrePizzas;
	}

	/**
	 * Obtiene el numero de veces que pide pizzas el cliente
	 * 
	 * @return numero de veces pedidas
	 */
	public ArrayList<Integer> getNumVeces() {
		return numVeces;
	}

	/**
	 * Establece el numero de veces que pide pizzas el cliente
	 * 
	 * @param numVeces
	 *            pedidas
	 */
	public void setNumVeces(ArrayList<Integer> numVeces) {
		this.numVeces = numVeces;
	}

}
