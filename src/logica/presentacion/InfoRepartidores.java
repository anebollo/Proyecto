package logica.presentacion;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Utilidades.CalculatorGenerico;

import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextPane;

import logica.negocios.Repartidor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InfoRepartidores extends JFrame {

	private JPanel contentPane;
	private MenuAdmi padre;

	/**
	 * Create the frame.
	 */
	public InfoRepartidores(ArrayList<Repartidor>leido, MenuAdmi papi) {
		
		padre=papi;
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 517, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRepartidores = new JLabel("REPARTIDORES");
		lblRepartidores.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRepartidores.setBounds(15, 16, 183, 48);
		contentPane.add(lblRepartidores);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(15, 66, 174, 141);
		//contentPane.add(textPane);
		
		//añadir contenido al textPane
		Repartidor todos=new Repartidor();
		ArrayList<Integer> infoRepartidores=todos.calcular(leido);
		String mostrar="La pizzeria tiene " + infoRepartidores.get(0) +" repartidores \n" +"y gasta " + 
						infoRepartidores.get(1) + "€ en ellos";
		textPane.setText(mostrar);
		

		// PONER EL SCROLLPANE EN UN JLIST
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(textPane);
		scroll.setBounds(15, 66, 174, 141);
		contentPane.add(scroll);
		
		JButton btnAtras = new JButton("ATRAS");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//ACCION ATRAS
				InfoRepartidores.this.dispose();
				padre.setVisible(true);
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAtras.setBounds(365, 284, 115, 29);
		contentPane.add(btnAtras);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//aCCION SALIR
				
				InfoRepartidores.this.dispose();
				
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSalir.setBounds(27, 284, 115, 29);
		contentPane.add(btnSalir);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\PC\\Desktop\\DEUSTO\\3.CURSO\\1.SEMESTRE\\Program III\\repartidor-feliz-estilo-dibujo-mano_23-2147673144.jpg"));
		lblNewLabel.setBounds(0, -52, 637, 591);
		contentPane.add(lblNewLabel);
		
		
		
	}
}
