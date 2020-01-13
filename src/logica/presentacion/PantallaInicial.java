package logica.presentacion;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.datos.CreateBD;
import logica.negocios.Administrador;
import logica.negocios.Cliente;
import logica.negocios.Factura;
import logica.negocios.Repartidor;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Ane y Aitor
 *
 */
public class PantallaInicial extends JFrame {

	private JPanel contentPane;
	private ArrayList<Cliente> clientes;
	private ArrayList<Administrador> admi;
	private ArrayList<Factura> facturas;
	private ArrayList<Repartidor> repartidores;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaInicial frame = new PantallaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame pantalla inicial, en la que se le pide al usuario que en
	 * caso de ser un administrador pulse ese boton, y en el caso de ser un cliente,
	 * pulse el otro. Si pulsa el boton administrador le mostrara la pantalla login
	 * y en el caso de pulsar el boton cliente, le mostrara el menu cliente
	 */
	public PantallaInicial() {
		setResizable(false);
		CreateBD mydb = new CreateBD("Pizzeria.db");
		//CreateBD bd=new CreateBD("PizzeriaPrueba.db");
		//bd.createNewDatabase("PizzeriaPrueba.db");
		mydb.createLink();
		mydb.inicializarBD();

		admi = logica.datos.AdministradorBD.selectAllAdministrador(mydb.getConn());
		facturas = logica.datos.FacturaBD.selectAllFactura(mydb.getConn());
		repartidores = logica.datos.RepartidorBD.selectAllRepartidor(mydb.getConn());
		clientes = logica.datos.ClienteBD.selectAllCliente(mydb.getConn());
		

		mydb.closeLink();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 732, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAdministrador = new JButton("ADMINISTRADOR");
		btnAdministrador.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// ABRIR VENTANA LOGIN

				Login login = new Login(clientes, facturas, admi, repartidores,PantallaInicial.this);
				login.setVisible(true);
				PantallaInicial.this.dispose();

			}
		});
		btnAdministrador.setBounds(434, 208, 188, 48);
		contentPane.add(btnAdministrador);

		JButton btnCliente = new JButton("CLIENTE");
		btnCliente.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// ABRIR VENTANA CLIENTE
				MenuCliente menuCliente = new MenuCliente(clientes,PantallaInicial.this);
				menuCliente.setVisible(true);
				PantallaInicial.this.dispose();

			}
		});
		btnCliente.setBounds(155, 208, 127, 48);
		contentPane.add(btnCliente);

		JLabel lblPizzeriaAa = new JLabel("PIZZERIA  AA");
		lblPizzeriaAa.setForeground(Color.BLUE);
		lblPizzeriaAa.setFont(new Font("Times New Roman", Font.BOLD, 38));
		lblPizzeriaAa.setBounds(215, 70, 257, 48);
		contentPane.add(lblPizzeriaAa);

		JButton btnSalir = new JButton("SALIR");
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PantallaInicial.this.dispose();

			}
		});
		btnSalir.setBounds(317, 323, 127, 42);
		contentPane.add(btnSalir);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(
				"C:\\Users\\PC\\Pictures\\as-pizzerias-no-decaen-modelo-franquicia-estable-rentable.jpg"));
		lblNewLabel.setBounds(-83, -165, 1344, 794);
		contentPane.add(lblNewLabel);
	}
}
