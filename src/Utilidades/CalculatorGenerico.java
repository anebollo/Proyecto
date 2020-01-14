package Utilidades;

import java.util.ArrayList;

import logica.negocios.Empleado;

public class CalculatorGenerico<T extends Empleado> {

	 
	
	public ArrayList<Integer> calcular(ArrayList<T> solicitado) {

		// recorrer soliticado y sumar el numero de personas y su sueldo
		// luego devolver las dos cosas calculadas y recogerla en cada metodo en las
		// clases

		ArrayList<Integer>infoTotal=new ArrayList<Integer>();
		int totalEmpleados = (int) solicitado.stream().count();
		int sueldoTotal=0;

		// ArrayList<Integer>sueldos=new ArrayList<>();
		for (T a : solicitado) {

			sueldoTotal += a.getSueldo();
		}

		// mediante expresiones lambda asumar los sueldos.
		
		infoTotal.add(totalEmpleados);
		infoTotal.add(sueldoTotal);
		

		return infoTotal;
	}

	

}
