package logica.presentacion;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.datos.CreateBD;
import logica.negocios.Repartidor;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

/**
 * 
 * @author Ane y Aitor
 *
 */
public class NuevoRepartidor extends JFrame {

	private JPanel contentPane;
	private JTextField txtDni;
	private JTextField txtSueldo;
	private JTextField txtHorasDia;
	private JTextField txtFechaCad;
	private int modo;
	private MenuAdmi padre;
	ArrayList<Repartidor> listaRepartidor=new ArrayList<Repartidor>();



	//nuevo repartidor
	/**
	 * este constructor es para el caso de que sea un nuevo repartidor la opcion seleccionada por el administrador
	 * @param ventanaPadre es la ventana de MenuAdmi	
	 * @param opcion es la opcion que se selecciona en la MenuAdmi y determina que la opcion es el nuevo repartidor
	 * @wbp.parser.constructor
	 */
	public NuevoRepartidor(MenuAdmi ventanaPadre, int opcion) {
		setResizable(false);
		this.padre = ventanaPadre;
		this.listaRepartidor = padre.getRepartidoresBD();
		this.modo = opcion;
		cargarVentana();

	}
	/**
	 * este es el constructor para el caso de que sea la modificacion del repartidor la opcion seleccionada por el administrador
	 * @param ventanaPadre es la ventana de MenuAdmi
	 * @param dni es el deni del repartidor
	 * @param sueldo es el sueldo del repartidor
	 * @param horasDia son las horas que trabaja al dia el repartidor
	 * @param fechaCad es la fecha en la que se le caduca el carnet de conducir al repartidor
	 * @param opcion  es la opcion que se selecciona en la MenuAdmi y determina que la opcion es modificar el repartidor
	 */
	
	//modificar repartidor
	public NuevoRepartidor(MenuAdmi ventanaPadre, String dni, int sueldo, int horasDia, Date fechaCad, int opcion) {

		this.padre = ventanaPadre;
		this.listaRepartidor = padre.getRepartidoresBD();
		this.modo = opcion;
		
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String fechaString = formatter.format(fechaCad);
		
		cargarVentana();

		txtDni.setText(dni);
		txtSueldo.setText(sueldo+"");
		txtHorasDia.setText(horasDia+"");
		txtFechaCad.setText(fechaString);
		//porque el dni no se puede cambiar, es unico para cada persona
		txtDni.setEditable(false);

	}
	
	/**
	 * este metodo sirve para cargar los datos de cada constructor en la ventana 
	 */
	public void cargarVentana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRepartidor = new JLabel("REPARTIDOR");
		lblRepartidor.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblRepartidor.setBackground(Color.BLACK);
		lblRepartidor.setBounds(354, 16, 190, 35);
		contentPane.add(lblRepartidor);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDni.setBounds(15, 93, 69, 20);
		contentPane.add(lblDni);
		
		JLabel lblSueldo = new JLabel("Sueldo:");
		lblSueldo.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblSueldo.setBounds(15, 140, 101, 20);
		contentPane.add(lblSueldo);
		
		JLabel lblHorasDia = new JLabel("Horas Dia:");
		lblHorasDia.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblHorasDia.setBounds(15, 192, 124, 20);
		contentPane.add(lblHorasDia);
		
		JLabel lblFechaCaducidadCarnet = new JLabel("Caducidad carnet:");
		lblFechaCaducidadCarnet.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFechaCaducidadCarnet.setBounds(15, 242, 157, 20);
		contentPane.add(lblFechaCaducidadCarnet);
		
		txtDni = new JTextField();
		txtDni.setBounds(171, 90, 291, 26);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		
		txtSueldo = new JTextField();
		txtSueldo.setBounds(171, 137, 291, 26);
		contentPane.add(txtSueldo);
		txtSueldo.setColumns(10);
		
		txtHorasDia = new JTextField();
		txtHorasDia.setBounds(171, 189, 291, 26);
		contentPane.add(txtHorasDia);
		txtHorasDia.setColumns(10);
		
		txtFechaCad = new JTextField();
		txtFechaCad.setBounds(171, 239, 291, 26);
		contentPane.add(txtFechaCad);
		txtFechaCad.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//aCCION OK
				
				//nuevo repartidor
				if(modo==1) {
					
					String dni=txtDni.getText();
					int sueldo=Integer.parseInt(txtSueldo.getText());
					int horasDia=Integer.parseInt(txtHorasDia.getText());
					String fechaString=txtFechaCad.getText();
					Date fechaCad = null;
					try {
						fechaCad = (Date) new SimpleDateFormat("dd-MM-yyyy").parse(fechaString);

					} catch (ParseException a) {

						a.printStackTrace();
					}
					
					boolean existencia=false;
					
					for(Repartidor a: listaRepartidor) {
						
						if(a.getDni().equals(dni)) {
							existencia=true;
						}
					}
					
					if(existencia==true) {
						JOptionPane.showMessageDialog(NuevoRepartidor.this, "Este dni del repartidor ya existe");
					}
					else {
						
						Repartidor nuevo=new Repartidor(dni,sueldo,horasDia,fechaCad);
						listaRepartidor.add(nuevo);
						padre.setRepartidoresBD(listaRepartidor);
						padre.cargarLista();
						
						CreateBD mybd=new CreateBD("Pizzeria.db");
						mybd.createLink();
						logica.datos.RepartidorBD.insertRepartidor(mybd.getConn(), dni, sueldo, horasDia, fechaString);
						mybd.closeLink();
						NuevoRepartidor.this.dispose();
						padre.setVisible(true);
						
					}
					
				}
				
				else if(modo==2) {
					
					String dni=txtDni.getText();
					int sueldo=Integer.parseInt(txtSueldo.getText());
					int horasDia=Integer.parseInt(txtHorasDia.getText());
					String fechaString=txtFechaCad.getText();
					Date fechaCad = null;
					
					Repartidor borrar=null;
					Repartidor modificado=null;
					
					try {
						fechaCad = (Date) new SimpleDateFormat("dd-MM-yyyy").parse(fechaString);

					} catch (ParseException a) {

						a.printStackTrace();
					}
					
					boolean existencia=false;
					
					for(Repartidor a:listaRepartidor) {
						
						if(a.getDni().equals(dni)) {
							existencia=true;
							borrar=a;
							break;
						}
					}
					
					if(existencia==true) {
						
						listaRepartidor.remove(borrar);
						modificado=new Repartidor(dni,sueldo,horasDia,fechaCad);
						listaRepartidor.add(modificado);
						padre.setRepartidoresBD(listaRepartidor);
						padre.cargarLista();
						
						CreateBD mybd=new CreateBD("Pizzeria.db");
						mybd.createLink();
						logica.datos.RepartidorBD.delete(mybd.getConn(), dni);
						logica.datos.RepartidorBD.insertRepartidor(mybd.getConn(), dni, sueldo, horasDia, fechaString);
						mybd.closeLink();
						NuevoRepartidor.this.dispose();
						padre.setVisible(true);
						
						
						
					}
					
					
					
				}
			}
		});
		btnOk.setBounds(376, 294, 115, 29);
		contentPane.add(btnOk);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//ACCION CANCEL
				
				NuevoRepartidor.this.dispose();
				padre.setVisible(true);
			}
		});
		btnCancel.setBounds(118, 294, 115, 29);
		contentPane.add(btnCancel);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("imagenes/nuevoReparrtidor.jpg"));
		lblNewLabel.setBounds(0, -22, 615, 448);
		contentPane.add(lblNewLabel);
	}

}
