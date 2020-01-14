package logica.presentacion;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import logica.datos.CreateBD;
import logica.negocios.Cliente;
import logica.negocios.Factura;
import logica.negocios.Pizza;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

/**
 * 
 * @author Ane y Aitor
 *
 */
public class PantallaFactura extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumFac;
	private JTextField txtFecha;
	private JTextField txtCoste;
	private JTextField txtDNI;
	private JTextField txtTlf;

	private static ArrayList<Cliente> clientesBD = new ArrayList<Cliente>();
	private static ArrayList<Pizza> compraCliente = new ArrayList<Pizza>();
	private static ArrayList<String> nombrePizzas = new ArrayList<String>();
	private static ArrayList<Integer> numVeces = new ArrayList<Integer>();
	private static String dniComprador;
	private static int countJQ = 0;
	private static int count4Q = 0;
	private static int countB = 0;
	private static int countC = 0;
	private static int countH = 0;
	private static int countBo = 0;
	private PantallaInicial papi;

	/**
	 * Create the frame factura, en la que una vez finalizado la compra, se le
	 * muestra al cliente la factura de su compra, con su precio, pizzas
	 * compradas...
	 */
	public PantallaFactura(PantallaInicial padre,int total, ArrayList<Pizza> compra, ArrayList<Cliente> clientes) {
		setResizable(false);

		this.clientesBD = clientes;
		this.compraCliente = compra;
		this.papi=padre;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 699);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblFactura = new JLabel("FACTURA");
		lblFactura.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFactura.setBounds(208, 33, 117, 38);
		contentPane.add(lblFactura);

		JLabel lblNumeroFactura = new JLabel("N\u00BA Factura:");
		lblNumeroFactura.setBounds(77, 211, 93, 20);
		contentPane.add(lblNumeroFactura);

		txtNumFac = new JTextField();
		txtNumFac.setBounds(208, 208, 144, 26);
		contentPane.add(txtNumFac);
		txtNumFac.setColumns(10);
		// añadir un numero de factura aleatorio
		int n = 1000;
		int numero = (int) (Math.random() * n) + 1;
		txtNumFac.setText("" + numero);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(79, 273, 69, 20);
		contentPane.add(lblFecha);

		txtFecha = new JTextField();
		txtFecha.setBounds(206, 270, 146, 26);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);
		Date fecha = new Date();
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String fechaFac = formatter.format(fecha);
		// Añadir la fecha actual
		txtFecha.setText(fechaFac);

		JLabel lblPedido = new JLabel("Pedido:");
		lblPedido.setBounds(79, 346, 69, 20);
		contentPane.add(lblPedido);

		JLabel lblCosteTotal = new JLabel("Coste total:");
		lblCosteTotal.setBounds(79, 523, 93, 20);
		contentPane.add(lblCosteTotal);

		txtCoste = new JTextField();
		txtCoste.setBounds(208, 520, 69, 26);
		contentPane.add(txtCoste);
		txtCoste.setColumns(10);
		// añadir el coste total
		String totalString = " " + total;
		txtCoste.setText(totalString);

		JLabel label = new JLabel("\u20AC");
		label.setBounds(292, 526, 18, 20);
		contentPane.add(label);

		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(77, 114, 69, 20);
		contentPane.add(lblDni);

		txtDNI = new JTextField();
		txtDNI.setBounds(206, 111, 146, 26);
		contentPane.add(txtDNI);
		txtDNI.setColumns(10);
		// pedir que introduzca el dni

		JLabel lblTlf = new JLabel("TLF:");
		lblTlf.setBounds(77, 168, 69, 20);
		contentPane.add(lblTlf);

		txtTlf = new JTextField();
		txtTlf.setBounds(206, 165, 146, 26);
		contentPane.add(txtTlf);
		txtTlf.setColumns(10);
		// pedir que introduzca eL TELEFONO

		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Tahoma", Font.BOLD, 16));
		textPane.setBounds(208, 346, 327, 158);

		// PONER EL SCROLLPANE EN UN JLIST
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(textPane);
		scroll.setBounds(208, 346, 327, 158);
		contentPane.add(scroll);

		// añadir la infor de las pizzas
		String contenido = "";
		for (int i = 0; i < compra.size(); i++) {

			contenido += "- " + compra.get(i).getNombre() + ", tamaño: " + compra.get(i).getTamaño() + " --> "
					+ compra.get(i).getPrecio() + "€\n";

		}
		textPane.setText(contenido);

		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// CERRAR VENTANA

				PantallaFactura.this.dispose();
				papi.setVisible(true);
			}
		});
		btnCancelar.setBounds(103, 576, 115, 29);
		contentPane.add(btnCancelar);

		JButton btnConfirmarPedido = new JButton("CONFIRMAR PEDIDO");
		btnConfirmarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// FUNCION CONFIRMAR

				// crear el cliente y la factura

				String dni = null;
				String tlf = null;
				dni = txtDNI.getText();
				tlf = txtTlf.getText();
				
				dniComprador = dni;
				
				boolean rellenado=false;

				if (dni != null && tlf != null) {
					rellenado=true;
				}
					
				if(rellenado==false) {
					JOptionPane.showMessageDialog(PantallaFactura.this, "DNI o telefono sin rellenar");
				}
				else if(rellenado==true) {

					desglosar();

					for (Cliente a : clientesBD) {
						

						if (a.getDNI().equals(dniComprador)) {

							ArrayList<String> pizzasAntes = a.getNombrePizzas();
							ArrayList<Integer> numAntes = a.getNumVeces();
							CreateBD mybd1 = new CreateBD("Pizzeria.db");
							mybd1.createLink();
							logica.datos.ClienteBD.delete(mybd1.getConn(), dniComprador);
							mybd1.closeLink();

							juntar(pizzasAntes, numAntes);
							break;

						}

					}
					// INTRODUCIR EN LA BD EL NUEVO CLIENTE

					CreateBD mybd = new CreateBD("Pizzeria.db");
					mybd.createLink();
					logica.datos.ClienteBD.insertCliente(mybd.getConn(), dni, tlf, nombrePizzas, numVeces);

					// INTRODUCIR EN LA BD LA NUEVA FACTURA

					logica.datos.FacturaBD.insertFactura(mybd.getConn(), numero, fechaFac, total, nombrePizzas);
					mybd.closeLink();

					PantallaFactura.this.dispose();
					ConfirmacionPedido nueva = new ConfirmacionPedido(total);
					nueva.setVisible(true);
					
					

				}

			}
		});
		btnConfirmarPedido.setBounds(276, 576, 196, 29);
		contentPane.add(btnConfirmarPedido);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setIcon(new ImageIcon(
				"imagenes/AA.jpg"));
		lblNewLabel.setBounds(392, 44, 157, 125);
		contentPane.add(lblNewLabel);

	}

	/**
	 * este metodo sirve para contar el numero de veces que compra cada pizza el
	 * cliente
	 */
	public static void desglosar() {
		countJQ = (int) compraCliente.stream().filter(w -> w.getNombre().equals("Jamon y queso")).count();
		count4Q = (int) compraCliente.stream().filter(w -> w.getNombre().equals("4 quesos")).count();
		countB = (int) compraCliente.stream().filter(w -> w.getNombre().equals("Barbacoa")).count();
		countC = (int) compraCliente.stream().filter(w -> w.getNombre().equals("Carbonara")).count();
		countH = (int) compraCliente.stream().filter(w -> w.getNombre().equals("Hawaiiana")).count();
		countBo = (int) compraCliente.stream().filter(w -> w.getNombre().equals("Boloñesa")).count();

		// COMPROBAR QUE NINGUN COUNT SEA 0

		if (countJQ != 0) {
			nombrePizzas.add("Jamon y queso");
			numVeces.add(countJQ);

		}
		if (count4Q != 0) {
			nombrePizzas.add("4 quesos");
			numVeces.add(count4Q);

		}

		if (countB != 0) {
			nombrePizzas.add("Barbacoa");
			numVeces.add(countB);

		}

		if (countC != 0) {
			nombrePizzas.add("Carbonara");
			numVeces.add(countC);

		}

		if (countH != 0) {
			nombrePizzas.add("Hawaiiana");
			numVeces.add(countH);

		}

		if (countBo != 0) {
			nombrePizzas.add("Boloñesa");
			numVeces.add(countBo);

		}

		

	}

	/**
	 * este metodo sirve para ,en el caso de que el cliente ya haya hecho una compra
	 * anteriormente, juntar el numero de veces que ha comprado cada pizza
	 * 
	 * @param pizzasAntes
	 *            el nombre de las pizzas que habia comprado antes el cliente
	 * @param numAntes
	 *            el numero de veces que habia comprado cada pizza el cliente
	 */
	public static void juntar(ArrayList<String> pizzasAntes, ArrayList<Integer> numAntes) {

		for (int i = 0; i < pizzasAntes.size(); i++) {

			// como hacer que no se repitan los nombre y contar en num de veces
			if (pizzasAntes.get(i).equals("Jamon y queso")) {

				countJQ += numAntes.get(i);
			}
			if (pizzasAntes.get(i).equals("4 quesos")) {

				count4Q += numAntes.get(i);
			}
			if (pizzasAntes.get(i).equals("Barbacoa")) {

				countB += numAntes.get(i);
			}

			if (pizzasAntes.get(i).equals("Carbonara")) {

				countC += numAntes.get(i);
			}

			if (pizzasAntes.get(i).equals("Hawaiiana")) {

				countH += numAntes.get(i);
			}

			if (pizzasAntes.get(i).equals("Boloñesa")) {

				countBo += numAntes.get(i);
			}

		}

		if (countJQ != 0) {
			nombrePizzas.add("Jamon y queso");
			numVeces.add(countJQ);

		}
		if (count4Q != 0) {
			nombrePizzas.add("4 quesos");
			numVeces.add(count4Q);

		}

		if (countB != 0) {
			nombrePizzas.add("Barbacoa");
			numVeces.add(countB);

		}

		if (countC != 0) {
			nombrePizzas.add("Carbonara");
			numVeces.add(countC);

		}

		if (countH != 0) {
			nombrePizzas.add("Hawaiiana");
			numVeces.add(countH);

		}

		if (countBo != 0) {
			nombrePizzas.add("Boloñesa");
			numVeces.add(countBo);

		}

	}

}
