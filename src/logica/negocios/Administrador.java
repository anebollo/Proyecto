package logica.negocios;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Utilidades.CalculatorGenerico;
import intefaces.ICalculator;

/**
 * @author aitor y ane Clase Administrador que extiende de Empleado
 *
 */

public class Administrador extends Empleado implements ICalculator<Administrador> {

	private String nombre;
	private String contrase�a;

	public Administrador() {
		super();
		// TODO Auto-generated constructor stub

	}

	/**
	 * Los atributos de la clase Administrador que extiende de Empleado
	 * 
	 * @param nombre
	 *            del Administrador
	 * @param contrase�a
	 *            del Administrador
	 * @param dni
	 *            del Administrador
	 * @param sueldo
	 *            del Administrador
	 * @param horasDia
	 *            que trabaja el Administrador
	 */
	public Administrador(String dni, int sueldo, int horasDia, String nombre, String contrase�a) {
		super(dni, sueldo, horasDia);

		this.nombre = nombre;
		this.contrase�a = contrase�a;
	}

	/**
	 * Sirve para obtener el nombre del Administrador
	 * 
	 * @return el nombre del Administrador
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del Administrador
	 * 
	 * @param nombre
	 *            del Administrador
	 */

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Sirve para obtener la contrase�a del Administrador
	 * 
	 * @return la contrase�a del Administrador
	 */
	public String getContrase�a() {
		return contrase�a;
	}

	/**
	 * Establece la contrase�a del Administrador
	 * 
	 * @param contrase�a
	 *            del Administrador
	 */
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	@Override
	public ArrayList<Integer> calcular(ArrayList<Administrador> t) {
		
		CalculatorGenerico solicitado=new CalculatorGenerico();
		ArrayList<Integer> totalAdmins=solicitado.calcular(t);
		return totalAdmins;
		
	}

}
