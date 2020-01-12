package logica.presentacion;

import java.awt.BorderLayout;
import logica.negocios.Administrador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class BuscarNombreAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField txtDni;
	private MenuAdmi papi;
	private ArrayList<Administrador>listaAdministradores;


	/**
	 * Create the frame.
	 */
	public BuscarNombreAdmin(MenuAdmi padre, ArrayList<Administrador>listaAdmin) {
		
		this.papi=padre;
		this.listaAdministradores=listaAdmin;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBuscarAdministradorPor = new JLabel("BUSCAR ADMINISTRADOR POR DNI");
		lblBuscarAdministradorPor.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblBuscarAdministradorPor.setBounds(45, 46, 510, 20);
		contentPane.add(lblBuscarAdministradorPor);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDni.setBounds(72, 140, 69, 20);
		contentPane.add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setBounds(133, 137, 259, 26);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//aCCION OK
				
				String dniIntroducido=txtDni.getText();
				HashMap<String,String>datoAdmin=new HashMap<String,String>();
				boolean existencia=false;
				if(dniIntroducido!=null) {
					
					for(Administrador a: listaAdministradores) {
						
						if(a.getDni().equals(dniIntroducido)) {
							existencia=true;
							datoAdmin.put(dniIntroducido,a.getNombre());
							break;
						}
					}
					
					if(existencia==false) {
						JOptionPane.showMessageDialog(BuscarNombreAdmin.this, "ERROR! No existe administrador con ese dni.");
					}
					
					else if(existencia==true) {
						//abrir pantalla visualizacion enviandole el hashmap y el dni introducido
						VisualizacionCliente abrir=new VisualizacionCliente(papi,2,datoAdmin,dniIntroducido);
						abrir.setVisible(true);
						BuscarNombreAdmin.this.dispose();
					}
				}
			}
		});
		btnOk.setBounds(407, 136, 115, 29);
		contentPane.add(btnOk);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//ACCION CANCEL
				BuscarNombreAdmin.this.dispose();
				papi.setVisible(true);
			}
		});
		btnCancel.setBounds(417, 290, 115, 29);
		contentPane.add(btnCancel);
	}
}
