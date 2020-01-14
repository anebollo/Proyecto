package logica.negocios;

import java.util.ArrayList;
import java.util.Date;

import Utilidades.CalculatorGenerico;
import intefaces.ICalculator;

/**
 * 
 * @author aitor y ane Clase repartiro
 */
public class Repartidor extends Empleado implements ICalculator<Repartidor> {

	private Date cadCarne;

	/**
	 * Es el constructor vacio
	 */
	public Repartidor() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Es el constructor con los parametros que se le pasan
	 * 
	 * @param dni
	 *            es el dni del repartidor
	 * @param sueldo
	 *            es el sueldo que tiene que repartidor
	 * @param horario
	 *            es las horas que trabaja un repartidor al dia
	 * @param cadCarne
	 *            es la fecha en la que se le caduca el carnet de conducir al
	 *            repartidor
	 */
	public Repartidor(String dni, int sueldo, int horario, Date cadCarne) {
		super(dni, sueldo, horario);

		this.cadCarne = cadCarne;
	}

	/**
	 * sirve para obtener la fecha de caducidad de carnet
	 * 
	 * @return fecha de caducidad carnet conducir
	 */
	public Date getCadCarne() {
		return cadCarne;
	}

	/**
	 * Sirve para establecer la fecha de caducidad del carnet
	 * 
	 * @param cadCarne
	 *            la fecha de caducidad de carnet
	 */
	public void setCadCarne(Date cadCarne) {
		this.cadCarne = cadCarne;
	}

	@Override
	public ArrayList<Integer> calcular(ArrayList<Repartidor>t) {
		// TODO Auto-generated method stub
		
		CalculatorGenerico solicitado=new CalculatorGenerico();
		ArrayList<Integer> totalRepartidores=solicitado.calcular(t);
		return totalRepartidores;
	}

	
}
