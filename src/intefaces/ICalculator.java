package intefaces;

import java.util.ArrayList;

import logica.negocios.Empleado;

public interface ICalculator<T extends Empleado> {
	
	public abstract ArrayList<Integer> calcular(ArrayList<T> t);
	

}
