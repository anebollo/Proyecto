package logica.presentacion;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hilos.MaquinaAutomatica;
import hilos.ProveedorClientes;
import logica.negocios.Cliente;
import logica.negocios.Factura;
import logica.negocios.Pizzeria;
import logica.negocios.Repartidor;
import logica.datos.CreateBD;
import logica.negocios.Administrador;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import java.awt.Font;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

/**
 * 
 * @author Alumno Ane y aitor
 *
 */
public class MenuAdmi extends JFrame {

	private JPanel contentPane;
	private JList list;
	private ArrayList<Cliente> clientesBD = new ArrayList<Cliente>();
	private ArrayList<Administrador> admiBD = new ArrayList<Administrador>();
	private ArrayList<Factura> facturasBD = new ArrayList<Factura>();
	private ArrayList<Repartidor> repartidoresBD = new ArrayList<Repartidor>();
	private String user;
	private String passW;
	private PantallaInicial papi;

	public ArrayList<Repartidor> getRepartidoresBD() {
		return repartidoresBD;
	}

	public void setRepartidoresBD(ArrayList<Repartidor> repartidoresBD) {
		this.repartidoresBD = repartidoresBD;
	}

	/**
	 * Create the frame menu administrador, en la que se le muestran todas las
	 * consultas que tiene posibles el administrador
	 */
	public MenuAdmi(String nombre,String pass, ArrayList<Cliente> clientes, ArrayList<Factura> facturas,
			ArrayList<Administrador> administradores, ArrayList<Repartidor> repartidores, PantallaInicial padre) {
		setResizable(false);

		this.clientesBD = clientes;
		this.admiBD = administradores;
		this.facturasBD = facturas;
		this.repartidoresBD = repartidores;
		user=nombre;
		passW=pass;
		this.papi=padre;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 813, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox cbxOpcion = new JComboBox();
		cbxOpcion.setModel(new DefaultComboBoxModel(new String[] {"Dar de alta Repartidor", "Dar de baja Repartidor", "Modificar Repartidor", "Pizza y numero de veces pedidas de un cliente especifico", "Pizza mas pedida", "Buscar facturas por fecha determinada", "Numero de repartidores y el coste que emplea en ellos", "Repartidores que se les caduca el carnet EN 3 meses de una fecha ", "Cual es el mes que mas gana la pizzeria", "Enviar correo", "Ver las maquinas automaticas"}));
		cbxOpcion.setBounds(62, 152, 431, 44);
		contentPane.add(cbxOpcion);

		JLabel lblBienvenido = new JLabel("BIENVENIDO " + nombre);
		lblBienvenido.setForeground(Color.WHITE);
		lblBienvenido.setFont(new Font("Stencil", Font.PLAIN, 25));
		lblBienvenido.setBounds(193, 0, 325, 56);
		contentPane.add(lblBienvenido);

		list = new JList();
		list.setBounds(276, 234, 216, 168);
		// contentPane.add(list);

		// PONER EL SCROLLPANE EN UN JLIST
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(list);
		scroll.setBounds(205, 234, 288, 223);
		contentPane.add(scroll);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// ACCION OK

				String opcion = (String) cbxOpcion.getSelectedItem();

				if (opcion.equals("Dar de alta Repartidor")) {

					int opcion1 = 1;
					NuevoRepartidor ventana = new NuevoRepartidor(MenuAdmi.this, opcion1);
					ventana.setVisible(true);

				} else if (opcion.equals("Dar de baja Repartidor")) {

					eliminar();

				} else if (opcion.equals("Modificar Repartidor")) {

					String dni = null;
					dni = (String) list.getSelectedValue();

					int sueldo = 0;
					int horasDia = 0;
					Date fechaCad = null;
					int opcion1 = 2;

					if (dni != null) {

						for (Repartidor a : repartidoresBD) {

							if (a.getDni().equals(dni)) {

								sueldo = a.getSueldo();
								horasDia = a.getHorasDia();
								fechaCad = a.getCadCarne();
							}
						}

						NuevoRepartidor ventana = new NuevoRepartidor(MenuAdmi.this, dni, sueldo, horasDia, fechaCad,
								opcion1);
						ventana.setVisible(true);

					}

				} else if (opcion.equals("Pizza y numero de veces pedidas de un cliente especifico")) {

					BusquedaClientePizzasyNumVeces busqueda = new BusquedaClientePizzasyNumVeces(MenuAdmi.this,clientesBD);
					busqueda.setVisible(true);
					MenuAdmi.this.dispose();

				} else if (opcion.equals("Pizza mas pedida")) {
					
					//PizzaMasVendida abrir=new PizzaMasVendida(clientesBD,MenuAdmi.this);
					//abrir.setVisible(true);
					MenuAdmi.this.dispose();

				} else if (opcion.equals("Buscar facturas por fecha determinada")) {

					int num=1;
					String dato="BUSQUEDA FACTURA";
					BuscarFactura busqueda = new BuscarFactura(facturasBD, MenuAdmi.this,dato,num);
					busqueda.setVisible(true);
					MenuAdmi.this.dispose();

				} else if (opcion.equals("Numero de repartidores y el coste que emplea en ellos")) {
					
					
					InfoRepartidores abrir=new InfoRepartidores(repartidoresBD, MenuAdmi.this);
					abrir.setVisible(true);

				} else if (opcion.equals("Repartidores que se les caduca el carnet EN 3 meses de una fecha ")) {
					
					int num=2;
					String dato="BUSQUEDA CADUCADOS";
					BuscarFactura busqueda=new BuscarFactura(repartidoresBD,dato,MenuAdmi.this,num);
					busqueda.setVisible(true);
					MenuAdmi.this.dispose();
					

				} else if (opcion.equals("Cual es el mes que mas gana la pizzeria")) {

					
					//VisualizacionMasGana abrir=new VisualizacionMasGana(MenuAdmi.this,facturasBD);
					//abrir.setVisible(true);
					MenuAdmi.this.dispose();

				}
				else if(opcion.equals("Enviar correo")) {
					
					EnviarCorreo abrir=new EnviarCorreo(MenuAdmi.this,user,passW);
					abrir.setVisible(true);
					MenuAdmi.this.dispose();
				}
				else if(opcion.equals("Ver las maquinas automaticas")) {
					
					Pizzeria.getInstancia().setEnServicio(true);
					
					ProveedorClientes proveedorCliente=new ProveedorClientes();
					
					MaquinaAutomatica maquina1=new MaquinaAutomatica();
					maquina1.setNombre("1");
					MaquinaAutomatica maquina2=new MaquinaAutomatica();
					maquina2.setNombre("2");
					
					maquina1.start();
					maquina2.start();
					proveedorCliente.start();
					
				}

			}

		});
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnOk.setBounds(542, 160, 61, 29);
		contentPane.add(btnOk);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// accion salir

				 MenuAdmi.this.dispose();
				 papi.setVisible(true);
				// tendremos que guardar los correspondientes cambios hechos en la BD

			}
		});
		btnSalir.setBounds(640, 451, 115, 29);
		contentPane.add(btnSalir);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(
				"C:\\Users\\PC\\Desktop\\DEUSTO\\3.CURSO\\1.SEMESTRE\\Program III\\software-3663509_1280-1280x856.jpg"));
		lblNewLabel.setBounds(-235, -76, 1292, 678);
		contentPane.add(lblNewLabel);

		cargarLista();

	}

	/**
	 * este metodo sirve para cargar la lista de los repartidores en el Jlist
	 */
	public void cargarLista() {

		DefaultListModel model = new DefaultListModel<>();
		list.setModel(model);

		for (Repartidor a : repartidoresBD) {

			String DNI = a.getDni();
			model.addElement(DNI);
		}

	}

	public void eliminar() {

		String dni = null;
		dni = (String) list.getSelectedValue();

		if (dni != null) {

			for (Repartidor a : repartidoresBD) {

				if (a.getDni().equals(dni)) {

					CreateBD mybd1 = new CreateBD("Pizzeria.db");
					mybd1.createLink();
					logica.datos.RepartidorBD.delete(mybd1.getConn(), a.getDni());
					repartidoresBD.remove(a);
					break;
				}
			}

			cargarLista();
		}

	}
}
