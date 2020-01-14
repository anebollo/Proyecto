package logica.negocios;

import java.util.ArrayList;

import Utilidades.CalculatorGenerico;
import intefaces.ICalculator;

/**
 * 
 * @author aitor y ane Clase Cocinero que extiende de Empleado
 */

public class Cocinero extends Empleado implements ICalculator<Cocinero>{

	private ArrayList<String> recetas;
	private boolean gorro;

	public Cocinero() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Los atributos de Cocinero que extiende de Empleado
	 * 
	 * @param dni
	 *            del Cocinero
	 * @param sueldo
	 *            del Cocinero
	 * @param horario
	 *            del Cocinero
	 * @param recetas
	 *            del Cocinero
	 * @param gorro
	 *            del Cocinero
	 */
	public Cocinero(String dni, int sueldo, int horario, ArrayList<String> recetas, boolean gorro) {
		super(dni, sueldo, horario);
		this.recetas = recetas;
		this.gorro = gorro;
	}

	/**
	 * Obtiene las recetas del cocinero
	 * 
	 * @return las recetas
	 */
	public ArrayList<String> getRecetas() {
		return recetas;
	}

	/**
	 * Establece las recetas del cocinero
	 * 
	 * @param recetas
	 *            del cocinero
	 */
	public void setRecetas(ArrayList<String> recetas) {
		this.recetas = recetas;
	}

	/**
	 * Obtiene si tiene gorro o no el cocinero
	 * 
	 * @return si tiene o no gorro el cocinero
	 */
	public boolean isGorro() {
		return gorro;
	}

	/**
	 * Establece el gorro al cocinero que lo lleva
	 * 
	 * @param gorro
	 *            del cocinero
	 */
	public void setGorro(boolean gorro) {
		this.gorro = gorro;
	}


	@Override
	public ArrayList<Integer> calcular(ArrayList<Cocinero>t) {
		CalculatorGenerico solicitado=new CalculatorGenerico();
		ArrayList<Integer> totalCocineros=solicitado.calcular(t);
		return totalCocineros;
	}

}
