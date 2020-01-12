package logica.negocios;

import java.util.ArrayList;

/**
 * 
 * @author aitor y ane Clase pizza
 */
public class Pizza {

	private String nombre;
	private String tamaño;
	private int precio;

	public Pizza() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Los atributos de la clase Pizza
	 * 
	 * @param nombre
	 *            de la pizza
	 * @param tamaño
	 *            de la pizza
	 * @param precio
	 *            de la pizza
	 */

	public Pizza(String nombre, String tamaño, int precio) {
		super();
		this.nombre = nombre;
		this.tamaño = tamaño;
		this.precio = precio;

	}

	/**
	 * Obtiene el nombre de la pizza
	 * 
	 * @return nombre pizza
	 */

	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre a la pizza
	 * 
	 * @param nombre
	 *            de la pizza
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el tamaño de la pizza
	 * 
	 * @return tamaño pizza
	 */
	public String getTamaño() {
		return tamaño;
	}

	/**
	 * Establece el tamaño a la pizza
	 * 
	 * @param tamaño
	 *            de la pizza
	 */
	public void setTamaño(String tamaño) {
		this.tamaño = tamaño;
	}

	/**
	 * Obtiene el precio de la pizza
	 * 
	 * @return precio pizza
	 */
	public int getPrecio() {
		return precio;
	}

	/**
	 * Establece el precio a la pizza
	 * 
	 * @param precio
	 *            de la pizza
	 */
	public void setPrecio(int precio) {
		this.precio = precio;
	}

}
