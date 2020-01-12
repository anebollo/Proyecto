package logica.negocios;

import java.util.ArrayList;

/**
 * 
 * @author aitor y ane Clase pizza
 */
public class Pizza {

	private String nombre;
	private String tama�o;
	private int precio;

	public Pizza() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Los atributos de la clase Pizza
	 * 
	 * @param nombre
	 *            de la pizza
	 * @param tama�o
	 *            de la pizza
	 * @param precio
	 *            de la pizza
	 */

	public Pizza(String nombre, String tama�o, int precio) {
		super();
		this.nombre = nombre;
		this.tama�o = tama�o;
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
	 * Obtiene el tama�o de la pizza
	 * 
	 * @return tama�o pizza
	 */
	public String getTama�o() {
		return tama�o;
	}

	/**
	 * Establece el tama�o a la pizza
	 * 
	 * @param tama�o
	 *            de la pizza
	 */
	public void setTama�o(String tama�o) {
		this.tama�o = tama�o;
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
