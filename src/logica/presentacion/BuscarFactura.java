package logica.presentacion;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import exception.UsuarioNoExiste;
import logica.negocios.Factura;
import logica.negocios.Repartidor;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.stream.Collectors;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class BuscarFactura extends JFrame {

	private JPanel contentPane;
	private JTextField txtFecha;
	private ArrayList<Factura> listaFacturas = new ArrayList<Factura>();
	private MenuAdmi padre;
	private ArrayList<Repartidor> listaRepartidores = new ArrayList<Repartidor>();
	private int opcion;
	private JLabel lblBusquedaFactura;

	public MenuAdmi getPadre() {
		return padre;
	}

	public void setPadre(MenuAdmi padre) {
		this.padre = padre;
	}

	public int getOpcion() {
		return opcion;
	}

	public void setOpcion(int opcion) {
		this.opcion = opcion;
	}

	/**
	 * Create the frame.
	 */

	// buscar factura por fecha
	public BuscarFactura(ArrayList<Factura> facturasBD, MenuAdmi padre, String dato, int option) {
		this.listaFacturas = facturasBD;
		this.padre = padre;
		lblBusquedaFactura = new JLabel(dato);
		opcion = option;
		cargarVentana();
	}

	// buscar repartiores por fecha cad 
	/**
	 * @wbp.parser.constructor
	 */
	public BuscarFactura(ArrayList<Repartidor> repartidoresBD, String dato, MenuAdmi padre, int option) {
		setResizable(false);
		this.listaRepartidores = repartidoresBD;
		this.padre = padre;
		lblBusquedaFactura = new JLabel(dato);
		opcion = option;

		cargarVentana();
	}

	public void cargarVentana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 644, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblBusquedaFactura.setForeground(Color.WHITE);
		lblBusquedaFactura.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblBusquedaFactura.setBounds(15, 16, 434, 57);
		contentPane.add(lblBusquedaFactura);

		txtFecha = new JTextField();
		txtFecha.setBounds(188, 159, 209, 31);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Accion OK buscar por fecha FACTURAS

				String fecha = txtFecha.getText();
				DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

				if (opcion == 1) {

					ArrayList<Factura> seleccion = listaFacturas.stream()
							.filter(w -> (formatter.format(w.getFecha())).equals(fecha))
							.collect(Collectors.toCollection(() -> new ArrayList<Factura>()));

					if (!seleccion.isEmpty()) {

						BuscarFactura.this.dispose();
						VisualizacionFactura nuevo = new VisualizacionFactura(BuscarFactura.this, fecha, seleccion);
						nuevo.setVisible(true);

					} else {
						JOptionPane.showMessageDialog(BuscarFactura.this, "No hay facturas con esa fecha");

					}
				}

				// Accion OK buscar POR FECHA CAD repartidor
				else if (opcion == 2) {
					Date finali = null;
					ArrayList<Repartidor> seleccion = new ArrayList<Repartidor>();

					try {
						finali = formatter.parse(fecha);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					Date finali2 = variarFecha(finali, Calendar.MONTH, 3);

					for (Repartidor a : listaRepartidores) {

						if (a.getCadCarne().before(finali2) && a.getCadCarne().after(finali)) {

							seleccion.add(a);
						}
					}
					if (!seleccion.isEmpty()) {

						BuscarFactura.this.dispose();
						VisualizacionFactura nuevo = new VisualizacionFactura(BuscarFactura.this, seleccion, fecha);
						nuevo.setVisible(true);

					} else {
						JOptionPane.showMessageDialog(BuscarFactura.this, "NO existe ninguna fecha asi");

					}

				}

			}

		});
		btnOk.setBounds(429, 160, 115, 29);
		contentPane.add(btnOk);

		JLabel lblFecha = new JLabel("FECHA: ");
		lblFecha.setForeground(Color.WHITE);
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblFecha.setBounds(105, 158, 78, 31);
		contentPane.add(lblFecha);

		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// ACCION SALIR
				BuscarFactura.this.dispose();
				padre.setVisible(true);

			}
		});
		btnSalir.setBounds(470, 329, 115, 29);
		contentPane.add(btnSalir);

		JLabel lblDdmmyyyy = new JLabel("dd-MM-yyyy");
		lblDdmmyyyy.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDdmmyyyy.setBounds(246, 123, 115, 20);
		contentPane.add(lblDdmmyyyy);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("imagenes/BuscarFactura.jpg"));
		lblNewLabel.setBounds(0, 0, 638, 387);
		contentPane.add(lblNewLabel);
		
		
	}

	public static Date variarFecha(Date fecha, int campo, int valor) {
		if (valor == 0)
			return fecha;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.add(campo, valor);
		return calendar.getTime();
	}
}
