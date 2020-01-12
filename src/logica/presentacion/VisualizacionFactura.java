package logica.presentacion;

import java.awt.BorderLayout;
import logica.presentacion.MenuAdmi;

import java.awt.EventQueue;
import logica.negocios.Factura;
import logica.negocios.Repartidor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.List;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class VisualizacionFactura extends JFrame {

	private JPanel contentPane;
	
	private int opcion;
	private MenuAdmi padre1;
	private BuscarFactura padre2;
	private String fecha;
	private ArrayList<Factura> seleccionado;
	private ArrayList<Repartidor>seleccionadoR;
	private JLabel lblFactura;

	/**
	 * Create the frame.
	 */
	
	public VisualizacionFactura(BuscarFactura padre,String fechaS,ArrayList<Factura> seleccionadoS) {
		
		//mostrar facturas por fecha determinada
		opcion=padre.getOpcion();
		padre2=padre;
		padre1=padre.getPadre();
		fechaS=fecha;
		seleccionado=seleccionadoS;
		lblFactura = new JLabel("FACTURAS: ");
		
		cargarVentana();
	}
	

	/**
	 * @wbp.parser.constructor
	 */
	public VisualizacionFactura(BuscarFactura padre,ArrayList<Repartidor> seleccionadoS,String fechaS) {
		
		//mOSTRAR numero de facturas de un repartidor concreto
		opcion=padre.getOpcion();
		padre2=padre;
		padre1=padre.getPadre();
		fecha=fechaS;
		seleccionadoR=seleccionadoS;
		lblFactura = new JLabel("REPARTIDORES: ");
		
		cargarVentana();
		
	}
	public void cargarVentana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		lblFactura.setForeground(new Color(0, 0, 0));
		lblFactura.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 24));
		lblFactura.setBounds(25, 33, 258, 57);
		contentPane.add(lblFactura);

		//poner la fecha de la busqueda
		JLabel lblFecha = new JLabel(fecha);
		lblFecha.setBounds(313, 39, 132, 51);
		contentPane.add(lblFecha);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(48, 103, 421, 222);
		//contentPane.add(textPane);
		
		//añadir scroll al textPane
		JScrollPane scrollPane = new JScrollPane(textPane);
		scrollPane.setBounds(48, 103, 421, 222);
		contentPane.add(scrollPane);
		
		
		// mostrar contenido
		
		if(opcion==1) {
			
			//todas las facturas de esa fecha
		String contenido = null;

		for (Factura a : seleccionado) {

			contenido = a.getNumFac() + " ->" + a.getCoste() + "\n";
		}
		textPane.setText(contenido);
		}
		else if(opcion==2) {
			
			//el numero de facturas de un concreto repartidor
			DateFormat formatter=new SimpleDateFormat("dd-MM-yyyy");
			String contenido = "LOS REPARTIDORES QUE SE LES CADUCA EL CARNET DESDE EL " + fecha + " HASTA 3 MESES DESPUES" + "\n" + "SON: ";

			for (Repartidor a : seleccionadoR) {

				contenido += "- "+ a.getDni() + " , " + (formatter.format(a.getCadCarne()));
			}
			textPane.setText(contenido);
			
		}
		
		

		//accion salir
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				VisualizacionFactura.this.dispose();
				padre1.setVisible(true);
			}
		});
		btnSalir.setBounds(438, 364, 115, 29);
		contentPane.add(btnSalir);
		
		JLabel lblFoto = new JLabel("New label");
		lblFoto.setIcon(new ImageIcon("imagenes/factura1.jpg"));
		lblFoto.setBounds(0, 0, 713, 531);
		contentPane.add(lblFoto);
	}
}
