package hilos;

import logica.negocios.Cliente;
import logica.negocios.Pizzeria;

public class MaquinaAutomatica extends Thread{
	
	private String nombre;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	private void pausar(long tiempo) {
		
		try {
			Thread.sleep(tiempo);
		}catch(InterruptedException ex) {
			System.out.println("Error al pausar el hilo");
		}
	}
	
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
