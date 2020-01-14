package hilos;

import logica.negocios.Cliente;

import logica.negocios.Pizzeria;

/**
 * 
 * @author Ane y Aitor
 *
 */

public class MaquinaAutomatica extends Thread{
	
	private String nombre;
	
	/**
	 * Este metodo sirve para obtener el nombre de la maquina automatica
	 * @return el nombre de la maquina automatica
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * este metodo sirve para establecer el nombre de la maquina automatica
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	/**
	 * este metodo sirve para pausar la maquina automatica
	 * @param tiempo es el tiempo que se quiere pausar
	 */
	private void pausar(long tiempo) {
		
		try {
			Thread.sleep(tiempo);
		}catch(InterruptedException ex) {
			System.out.println("Error al pausar el hilo");
		}
	}
	
	/**
	 * este metodo sirve para indicar lo que hace la maquina cuando se ejecuta
	 */
	public void run() {
		
		while(Pizzeria.getInstancia().isEnServicio()) {
			
			Cliente clienteAtender=Pizzeria.getInstancia().pasarClienteAlCajero();
			
			if(clienteAtender==null) {
				
				System.out.println(this + " MAQUINA " + nombre +": esperando usuarios");
				pausar(1000);
				continue;
			}
			
			System.out.println("MAQUINA " + nombre + ": atendiendo al usuario con" + "DNI " + clienteAtender.getDNI());
			pausar(5000);
		}
	}
	
}
