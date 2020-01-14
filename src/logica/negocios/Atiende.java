package logica.negocios;

import java.util.ArrayList;

import Utilidades.CalculatorGenerico;
import intefaces.ICalculator;

/**
 * 
 * @author aitor y ane clase Atiende que extiende de Empleado
 */
public class Atiende extends Empleado implements ICalculator<Atiende> {

	private int numFac;

	public Atiende() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Los atributos de la clase Atiende que extiende de Empleado
	 * 
	 * @param dni
	 *            del que Atiende
	 * @param sueldo
	 *            del que Atiende
	 * @param horario
	 *            que tiene el que Atiende
	 * @param numFac
	 *            que realiza el que Atiende
	 */
	public Atiende(String dni, int sueldo, int horario, int numFac) {
		super(dni, sueldo, horario);
		this.numFac = numFac;
	}

	/**
	 * Sirve para obtener el numero de facturas realizadas por la persona que
	 * atiende
	 * 
	 * @return el numero de facturas
	 */

	public int getNumFac() {
		return numFac;
	}

	/**
	 * Establece el numero de facturas
	 * 
	 * @param numFac
	 *            que realiza el que atiende
	 */
	public void setNumFac(int numFac) {
		this.numFac = numFac;
	}

	

	@Override
	public ArrayList<Integer> calcular(ArrayList<Atiende>t) {
		CalculatorGenerico solicitado=new CalculatorGenerico();
		ArrayList<Integer> totalAtiende=solicitado.calcular(t);
		return totalAtiende;
	}

}
