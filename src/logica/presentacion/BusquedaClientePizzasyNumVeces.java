package logica.presentacion;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import logica.negocios.Cliente;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import exception.UsuarioNoExiste;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

/**
 * 
 * @author Ane y Aitor
 *
 */
public class BusquedaClientePizzasyNumVeces extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private Cliente elegido = new Cliente();
	private static ArrayList<String> pizzas = new ArrayList<>();
	private MenuAdmi papi;

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	

	/**
	 * Create the frame BusquedaClientePizzasyNumVeces sirve para que el
	 * administrador pueda buscar segun el dni del cliente las pizzas que ha
	 * comprado y el numero de vez cada una de ellas.
	 */
	public BusquedaClientePizzasyNumVeces(MenuAdmi padre,ArrayList<Cliente> clientes) {
		setResizable(false);

		this.clientes = clientes;
		this.papi=padre;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDniCliente = new JLabel("DNI:");
		lblDniCliente.setForeground(Color.BLACK);
		lblDniCliente.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblDniCliente.setBounds(104, 121, 72, 20);
		contentPane.add(lblDniCliente);

		textField = new JTextField();
		textField.setBounds(176, 121, 192, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblBusquedaCliente = new JLabel("BUSQUEDA CLIENTE");
		lblBusquedaCliente.setFont(new Font("Tw Cen MT", Font.BOLD, 25));
		lblBusquedaCliente.setBounds(190, 27, 246, 26);
		contentPane.add(lblBusquedaCliente);

		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// ACCION OK

				String dni = textField.getText();
				ArrayList<String> pizzas = new ArrayList<String>();
				ArrayList<Integer> numVeces = new ArrayList<Integer>();
				try {
					boolean encontrado = comprobarCliente(dni);
					pizzas = elegido.getNombrePizzas();
					numVeces = elegido.getNumVeces();

					// ordenar el array numveces
					numVeces = mergeSort(numVeces, pizzas);

					// abrir otra ventana mostrando la info
					String contenido = null;
					for (int i = 0; i < pizzas.size(); i++) {
						for (int j = 0; j < numVeces.size(); j++) {

							contenido += "- " + pizzas.get(i) + " " + numVeces.get(j) + " veces\n";

						}
					}
					BusquedaClientePizzasyNumVeces.this.dispose();
					VisualizacionCliente nueva = new VisualizacionCliente(dni, contenido, papi);
					nueva.setVisible(true);

				} catch (UsuarioNoExiste e) {

					JOptionPane.showMessageDialog(BusquedaClientePizzasyNumVeces.this, e.getMessage());
				}

			}
		});
		btnOk.setBounds(388, 120, 67, 29);
		contentPane.add(btnOk);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setIcon(new ImageIcon(
				"C:\\Users\\PC\\Desktop\\DEUSTO\\3.CURSO\\1.SEMESTRE\\Program III\\pizzeria-clientes-felices-ilustracion-dibujos-animados_82574-1812.jpg"));
		lblNewLabel.setBounds(0, 57, 661, 344);
		contentPane.add(lblNewLabel);
		
		JButton btnAtras = new JButton("ATRAS");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//ACCION ATRAS
				papi.setVisible(true);
				BusquedaClientePizzasyNumVeces.this.dispose();
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAtras.setBounds(492, 16, 121, 37);
		contentPane.add(btnAtras);
	}

	/**
	 * Sirve para comprobar si existe o no el dni que ha introducido para hacer la
	 * busqueda
	 * 
	 * @param dni
	 *            es el dni del ciente
	 * @return false si no existe y true si existe
	 * @throws UsuarioNoExiste
	 *             es la clase en la que se implementa la excepcion del usuario no
	 *             existente
	 */
	public boolean comprobarCliente(String dni) throws UsuarioNoExiste {

		boolean existencia = false;

		for (Cliente a : clientes) {

			if (a.getDNI().equals(dni)) {
				existencia = true;
				elegido = a;

			}

		}

		if (existencia == true) {

			return true;

		} else {

			throw new UsuarioNoExiste("DNI no Existente");

		}

	}
/**
 * Este metodo sirve para ordenar de menor a mayor el arraylist de las pizzas de los clientes y el numero de veces que las compra
 * @param Input un arraylist del numero de veces que las compra
 * @param pizzas un arraylist de las pizzas de los clientes
 * @return devuelve el arraylist del numero de veces ordenado
 */
	public static ArrayList<Integer> mergeSort(ArrayList<Integer> Input, ArrayList<String> pizzas) {

		if (Input.size() == 1) {
			return Input;
		} else {
			int mid = Input.size() / 2;
			ArrayList<Integer> left = new ArrayList<Integer>(mid);
			ArrayList<Integer> right = new ArrayList<Integer>(Input.size() - mid);
			ArrayList<String> leftP = new ArrayList<String>(mid);
			ArrayList<String> rightP = new ArrayList<String>(Input.size() - mid);

			for (int i = 0; i < mid; i++) {
				left.add(Input.get(i));
				leftP.add(pizzas.get(i));
			}

			for (int i = mid; i < Input.size(); i++) {
				right.add(Input.get(i));
				rightP.add(pizzas.get(i));
			}

			left = mergeSort(left, leftP);
			right = mergeSort(right, rightP);
			return merge(left, right, leftP, rightP);

		}

	}
/**
 * Este metodo sirve para ordenar de menor a mayor el arraylist de las pizzas de los clientes y el numero de veces que las compra
 * @param left es la parte izquierda del arraylist del numero de veces de los clientes
 * @param right es la parte derecha del arraylist del numero de veces de los clientes
 * @param leftP es la parte izquierda del arraylist de las pizzas de los clientes
 * @param rightP es la parte derecha del arraylist del numero de veces de los clientes
 * @return devuelve el arraylist del numero de veces ordenado
 */
	public static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right, ArrayList<String> leftP,
			ArrayList<String> rightP) {

		ArrayList<Integer> aux = new ArrayList<>();
		ArrayList<String> auxPizzas = new ArrayList<>();

		while (!left.isEmpty() && !right.isEmpty()) {

			if (left.get(0) > right.get(0)) {
				aux.add(right.get(0));
				right.remove(0);
				auxPizzas.add(rightP.get(0));
				rightP.remove(0);
			} else {
				aux.add(left.get(0));
				left.remove(0);
				auxPizzas.add(leftP.get(0));
				leftP.remove(0);
			}

		}

		while (!left.isEmpty()) {

			aux.add(left.get(0));
			left.remove(0);
			auxPizzas.add(leftP.get(0));
			leftP.remove(0);
		}
		while (!right.isEmpty()) {

			aux.add(right.get(0));
			right.remove(0);
			auxPizzas.add(rightP.get(0));
			rightP.remove(0);
		}

		pizzas = auxPizzas;
		return aux;

	}
}
