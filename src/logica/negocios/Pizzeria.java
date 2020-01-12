package logica.negocios;

import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Pizzeria {
	
	private static Pizzeria instancia;
	private ConcurrentLinkedQueue<Cliente> clientes;
	
	//Indica si la maquina esta ocupada o no
	private boolean enServicio;
	
	private Pizzeria() {
		
		clientes=new ConcurrentLinkedQueue<>();
	}
	
	public static Pizzeria getInstancia() {
		
		if(instancia==null) {
			instancia=new Pizzeria();
		}
		
		return instancia;
	}
	
	public boolean isEnServicio() {
		return enServicio;
	}

	public void setEnServicio(boolean enServicio) {
		this.enServicio = enServicio;
	}

	public Cliente pasarClienteAlCajero() {
		
		Cliente usuario=null;
		
		try {
			System.out.println("La longitud de la fila es de: " + clientes.size() + " clientes");
			usuario=clientes.remove();
		}catch(NoSuchElementException e) {
			System.out.println("La fila se encuentra vacia");
		}
		
		return usuario;
		
	}
	
	public void agregarClienteFila(Cliente cliente) {
		
		System.out.println("Ha llegado un cliente a la pizzeria");
		clientes.add(cliente);
	}
	
	
}
