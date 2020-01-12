package hilos;

import logica.negocios.Cliente;
import logica.negocios.Pizzeria;

public class ProveedorClientes extends Thread {

	@Override
	public void run() {

		while (Pizzeria.getInstancia().isEnServicio()) {

			try {
				Thread.sleep(2000);
			} catch (InterruptedException ex) {
				System.out.println("Error al pausar el hilo");
			}

			Cliente usuarioParaEntrarPizzeria = new Cliente();
			usuarioParaEntrarPizzeria.setDNI(crearDni());

			System.out.println(
					"El cliente con DNI: " + usuarioParaEntrarPizzeria.getDNI() + " esta entrando a la pizzeria");
			
			Pizzeria.getInstancia().agregarClienteFila(usuarioParaEntrarPizzeria);

		}
	}

	public String crearDni() {
		char[] elementos = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q',
				'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		char[] numeros = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		char[] conjunto = new char[8];

		for (int i = 0; i < 8; i++) {

			if (i < 7) {
				int e1 = (int) (Math.random() * 10);
				conjunto[i] = (char) numeros[e1];

			} else {
				int e2 = (int) (Math.random() * 27);
				conjunto[i] = (char) elementos[e2];
			}

		}
		String dni = new String(conjunto);
		return dni;
	}
}
