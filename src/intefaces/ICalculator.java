package intefaces;

import java.util.ArrayList;

import logica.negocios.Empleado;

/**
 * 
 * @author Ane y Aitor
 *
 * @param <T> es el tio de dato que se la pasa 
 */
public interface ICalculator<T extends Empleado> {
	
	/**
	 * este metodo sirve para calcular el numero de repartidores y su coste
	 * @param t array de diferentes tipos
	 * @return array con los datos deseados
	 */
	public abstract ArrayList<Integer> calcular(ArrayList<T> t);
	

}
