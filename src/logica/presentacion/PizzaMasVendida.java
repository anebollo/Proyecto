package logica.presentacion;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import logica.negocios.Cliente;

public class PizzaMasVendida extends JFrame {

	private JPanel contentPane;
	private ArrayList<Cliente> listaClientes;
	private MenuAdmi papi;
	// private ArrayList<String>pizzas;
	// private ArrayList<Integer>numVeces;

	/**
	 * Create the frame.
	 */
	public PizzaMasVendida(ArrayList<Cliente> clientesBD, MenuAdmi padre) {

		listaClientes = clientesBD;
		papi = padre;

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPizzaMasVendida = new JLabel("PIZZA MAS VENDIDA");
		lblPizzaMasVendida.setFont(new Font("Tahoma", Font.PLAIN, 38));
		lblPizzaMasVendida.setForeground(Color.BLACK);
		lblPizzaMasVendida.setBounds(117, 36, 367, 52);
		contentPane.add(lblPizzaMasVendida);

		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Tahoma", Font.BOLD, 29));
		textPane.setBounds(93, 126, 419, 90);
		contentPane.add(textPane);
		// añadir contenido

		LinkedList<String> pizza = calcular();
		String contenido = null;
		for (int i = 0; i < pizza.size(); i++) {
			contenido = pizza.get(i) + "\n";
		}
		textPane.setText(contenido);

		JButton btnAtras = new JButton("ATRAS");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Accion atras

				PizzaMasVendida.this.dispose();
				papi.setVisible(true);
			}
		});
		btnAtras.setBounds(462, 354, 115, 29);
		contentPane.add(btnAtras);

		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// aCCION SALIR
				PizzaMasVendida.this.dispose();
			}
		});
		btnSalir.setBounds(49, 354, 115, 29);
		contentPane.add(btnSalir);

		JLabel lblFoto = new JLabel("New label");
		lblFoto.setIcon(new ImageIcon("imagenes/pizzaMas.jpg"));
		lblFoto.setBounds(-13, 0, 699, 480);
		contentPane.add(lblFoto);
	}

	public LinkedList<String> calcular() {

		LinkedList<String> pizzas = new LinkedList<String>();
		pizzas.add("Jamon y queso");
		pizzas.add("4 quesos");
		pizzas.add("Barbacoa");
		pizzas.add("Carbonara");
		pizzas.add("Hawaiiana");
		pizzas.add("Boloñesa");

		LinkedList<Integer> numVeces = new LinkedList<Integer>();

		int countJQ = 0;
		int count4Q = 0;
		int countB = 0;
		int countC = 0;
		int countH = 0;
		int countBo = 0;

		for (Cliente a : listaClientes) {

			for (int i = 0; i < a.getNombrePizzas().size(); i++) {

				if (a.getNombrePizzas().get(i).equals("Jamon y queso")) {

					countJQ += a.getNumVeces().get(i);

				}

				else if (a.getNombrePizzas().equals("4 quesos")) {

					count4Q += a.getNumVeces().get(i);

				}

				else if (a.getNombrePizzas().get(i).equals("Barbacoa")) {

					countB += a.getNumVeces().get(i);
				}

				else if (a.getNombrePizzas().get(i).equals("Carbonara")) {

					countC += a.getNumVeces().get(i);
				}

				else if (a.getNombrePizzas().get(i).equals("Hawaiiana")) {

					countH += a.getNumVeces().get(i);
				}

				else if (a.getNombrePizzas().get(i).equals("Boloñesa")) {

					countBo += a.getNumVeces().get(i);
				}

			}
		}

		numVeces.add(countJQ);
		numVeces.add(count4Q);
		numVeces.add(countB);
		numVeces.add(countC);
		numVeces.add(countH);
		numVeces.add(countBo);

		int pizzaMas = numVeces.stream().mapToInt(i -> i).max().getAsInt();
		int position = 0;
		// para ver si hay mas de una pizza con max
		LinkedList<Integer> masDeUno = new LinkedList<Integer>();
		LinkedList<String> masDeUna = new LinkedList<String>();
		String pizza = null;
		for (int i = 0; i < numVeces.size(); i++) {

			if (numVeces.get(i) == pizzaMas) {

				position = i + 1;
				masDeUno.add(position);
			}

		}

		for (int i = 0; i < masDeUno.size(); i++) {

			if (masDeUno.get(i) == 1) {
				pizza = "Jamon y queso";
				masDeUna.add(pizza);
			} else if (masDeUno.get(i) == 2) {
				pizza = "4 quesos";
				masDeUna.add(pizza);
			} else if (masDeUno.get(i) == 3) {
				pizza = "Barbacoa";
				masDeUna.add(pizza);
			} else if (masDeUno.get(i) == 4) {
				pizza = "Carbonara";
				masDeUna.add(pizza);
			} else if (masDeUno.get(i) == 5) {
				pizza = "Hawaiiana";
				masDeUna.add(pizza);
			} else if (masDeUno.get(i) == 6) {
				pizza = "Boloñesa";
				masDeUna.add(pizza);
			}

		}

		return masDeUna;

	}
}
