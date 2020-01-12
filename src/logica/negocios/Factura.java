package logica.negocios;

import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * @author aitor y ane Clase Factura
 */
public class Factura {

	private ArrayList<String> nombrePizzas;
	private Date fecha;
	private int coste;
	private int numFac;

	public Factura() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Los atributos de la clase Factura
	 * 
	 * @param nombrePizzas
	 *            que aparecen en la factura
	 * @param fecha
	 *            de la factura
	 * @param coste
	 *            de la factura
	 * @param numFac
	 *            numero de facturas
	 */
	public Factura(int numFac,Date fecha, int coste,ArrayList<String> nombrePizzas) {
		super();
		this.nombrePizzas = nombrePizzas;
		this.fecha = fecha;
		this.coste = coste;
		this.numFac = numFac;
	}

	/**
	 * Obtiene el nombre de las pizzas facturadas
	 * 
	 * @return nombre de pizzas
	 */
	public ArrayList<String> getNombrePizzas() {
		return nombrePizzas;
	}

	/**
	 * Establece el nombre de las pizzas
	 * 
	 * @param nombrePizzas
	 */
	public void setNombrePizzas(ArrayList<String> nombrePizzas) {
		this.nombrePizzas = nombrePizzas;
	}

	/**
	 * Obtiene la fecha cuando se hace la factura
	 * 
	 * @return fecha de la factura
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * Establece la fecha a la factura
	 * 
	 * @param fecha
	 *            de la factura
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * Obtiene el coste de la factura
	 * 
	 * @return el costes de la factura
	 */
	public int getCoste() {
		return coste;
	}

	/**
	 * Establece el coste de la factura
	 * 
	 * @param coste
	 */
	public void setCoste(int coste) {
		this.coste = coste;
	}

	/**
	 * Obtiene el numero de facturas generadas
	 * 
	 * @return numero de facturas
	 */
	public int getNumFac() {
		return numFac;
	}

	/**
	 * Establece el numero de facturas
	 * 
	 * @param numFac
	 */
	public void setNumFac(int numFac) {
		this.numFac = numFac;
	}

}
