package logica.presentacion;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.negocios.Cliente;
import logica.negocios.Pizza;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

/**
 * 
 * @author Ane y Aitor
 *
 */
public class MenuCliente extends JFrame {

	private JPanel contentPane;

	private ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
	ArrayList<Cliente>clientesBD=new ArrayList<Cliente>();
	private PantallaInicial papi;

	/**
	 * Create the frame menu cliente, en la que se le muestran todas la pizzas que
	 * puede comprar con sus respectivos precios
	 */
	public MenuCliente(ArrayList<Cliente>clientes,PantallaInicial padre) {
		setResizable(false);
		
		this.papi=padre;
		this.clientesBD=clientes;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 938, 668);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPizzas = new JLabel("PIZZAS");
		lblPizzas.setFont(new Font("Verdana", Font.BOLD, 29));
		lblPizzas.setBounds(378, 16, 125, 43);
		contentPane.add(lblPizzas);

		JLabel lblJamonYQueso = new JLabel("JAMON Y QUESO");
		lblJamonYQueso.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblJamonYQueso.setBounds(179, 124, 139, 20);
		contentPane.add(lblJamonYQueso);

		JLabel label1 = new JLabel("New label");
		label1.setIcon(new ImageIcon("imagenes/JAMONyqueso.jpg"));
		label1.setBounds(15, 113, 149, 101);
		contentPane.add(label1);

		JLabel label2 = new JLabel("New label");
		label2.setIcon(new ImageIcon("imagenes/4quesos.jpg"));
		label2.setBounds(15, 230, 149, 99);
		contentPane.add(label2);

		JLabel label3 = new JLabel("New label");
		label3.setIcon(new ImageIcon("imagenes/barbacoa.jpg"));
		label3.setBounds(15, 345, 155, 99);
		contentPane.add(label3);

		JLabel lblQuesos = new JLabel("4 QUESOS");
		lblQuesos.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblQuesos.setBounds(179, 237, 139, 25);
		contentPane.add(lblQuesos);

		JLabel lblBarbacoa = new JLabel("BARBACOA");
		lblBarbacoa.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBarbacoa.setBounds(185, 350, 108, 20);
		contentPane.add(lblBarbacoa);

		JLabel label4 = new JLabel("New label");
		label4.setIcon(new ImageIcon("imagenes/carbonara.jpg"));
		label4.setBounds(477, 110, 139, 106);
		contentPane.add(label4);

		JLabel label5 = new JLabel("New label");
		label5.setIcon(new ImageIcon("imagenes/Hawaiiana.jpg"));
		label5.setBounds(477, 235, 139, 89);
		contentPane.add(label5);

		JLabel label6 = new JLabel("New label");
		label6.setIcon(new ImageIcon("imagenes/boloñesa.jpg"));
		label6.setBounds(463, 350, 153, 89);
		contentPane.add(label6);

		JLabel lblCarbonara = new JLabel("CARBONARA");
		lblCarbonara.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCarbonara.setBounds(640, 124, 108, 20);
		contentPane.add(lblCarbonara);

		JLabel lblHawaiiana = new JLabel("HAWAIIANA");
		lblHawaiiana.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHawaiiana.setBounds(640, 237, 108, 25);
		contentPane.add(lblHawaiiana);

		JLabel lblBoloesa = new JLabel("BOLO\u00D1ESA");
		lblBoloesa.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBoloesa.setBounds(640, 354, 106, 25);
		contentPane.add(lblBoloesa);

		JLabel lblJQ = new JLabel("7");
		lblJQ.setBounds(228, 153, 18, 20);
		contentPane.add(lblJQ);

		JLabel lbl4Q = new JLabel("7");
		lbl4Q.setBounds(228, 269, 18, 20);
		contentPane.add(lbl4Q);

		JLabel lblB = new JLabel("8");
		lblB.setBounds(228, 384, 18, 20);
		contentPane.add(lblB);

		JLabel lblC = new JLabel("8");
		lblC.setBounds(687, 153, 18, 20);
		contentPane.add(lblC);

		JLabel lblBo = new JLabel("8");
		lblBo.setBounds(687, 384, 18, 20);
		contentPane.add(lblBo);

		JLabel lblH = new JLabel("9");
		lblH.setBounds(687, 269, 18, 20);
		contentPane.add(lblH);

		JComboBox cbxC = new JComboBox();
		cbxC.setModel(new DefaultComboBoxModel(new String[] {"Pequeno", "Mediano", "Grande"}));
		cbxC.setBounds(786, 169, 93, 23);
		contentPane.add(cbxC);

		JLabel lblTamao = new JLabel("Tama\u00F1o:");
		lblTamao.setBounds(799, 134, 69, 20);
		contentPane.add(lblTamao);

		JComboBox cbxJQ = new JComboBox();
		cbxJQ.setModel(new DefaultComboBoxModel(new String[] {"Pequeno", "Mediano", "Grande"}));
		cbxJQ.setBounds(339, 159, 93, 23);
		contentPane.add(cbxJQ);

		JLabel label_6 = new JLabel("Tama\u00F1o:");
		label_6.setBounds(352, 124, 69, 20);
		contentPane.add(label_6);

		JComboBox cbx4Q = new JComboBox();
		cbx4Q.setModel(new DefaultComboBoxModel(new String[] {"Pequeno", "Mediano", "Grande"}));
		cbx4Q.setBounds(339, 272, 93, 23);
		contentPane.add(cbx4Q);

		JLabel label_7 = new JLabel("Tama\u00F1o:");
		label_7.setBounds(352, 237, 69, 20);
		contentPane.add(label_7);

		JComboBox cbxB = new JComboBox();
		cbxB.setModel(new DefaultComboBoxModel(new String[] {"Pequeno", "Mediano", "Grande"}));
		cbxB.setBounds(339, 381, 93, 23);
		contentPane.add(cbxB);

		JLabel label_8 = new JLabel("Tama\u00F1o:");
		label_8.setBounds(352, 346, 69, 20);
		contentPane.add(label_8);

		JComboBox cbxH = new JComboBox();
		cbxH.setModel(new DefaultComboBoxModel(new String[] {"Pequeno", "Mediano", "Grande"}));
		cbxH.setBounds(799, 272, 93, 23);
		contentPane.add(cbxH);

		JLabel label_9 = new JLabel("Tama\u00F1o:");
		label_9.setBounds(799, 230, 69, 20);
		contentPane.add(label_9);

		JComboBox cbxBo = new JComboBox();
		cbxBo.setModel(new DefaultComboBoxModel(new String[] {"Pequeno", "Mediano", "Grande"}));
		cbxBo.setBounds(799, 398, 93, 23);
		contentPane.add(cbxBo);

		JLabel label_10 = new JLabel("Tama\u00F1o:");
		label_10.setBounds(799, 345, 69, 20);
		contentPane.add(label_10);

		JButton btnJQ = new JButton("A\u00D1ADIR");
		btnJQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// JQ

				String tamaño = (String) cbxJQ.getSelectedItem();
				String precio = lblJQ.getText();
				int precioInt = Integer.parseInt(precio);

				Pizza compra = new Pizza("Jamon y Queso", tamaño, precioInt);
				pizzas.add(compra);

			}
		});
		btnJQ.setBounds(186, 185, 107, 29);
		contentPane.add(btnJQ);

		JButton btn4Q = new JButton("A\u00D1ADIR");
		btn4Q.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// 4QUESOS
				String tamaño = (String) cbx4Q.getSelectedItem();
				String precio = lbl4Q.getText();
				int precioInt = Integer.parseInt(precio);

				Pizza compra = new Pizza("4 Quesos", tamaño, precioInt);
				pizzas.add(compra);

			}
		});
		btn4Q.setBounds(189, 290, 107, 29);
		contentPane.add(btn4Q);

		JButton btnB = new JButton("A\u00D1ADIR");
		btnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// BARBACOA
				String tamaño = (String) cbxB.getSelectedItem();
				String precio = lblB.getText();
				int precioInt = Integer.parseInt(precio);

				Pizza compra = new Pizza("Barbacoa", tamaño, precioInt);
				pizzas.add(compra);

			}
		});
		btnB.setBounds(189, 415, 107, 29);
		contentPane.add(btnB);

		JButton btnC = new JButton("A\u00D1ADIR	");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// CARBONARA
				String tamaño = (String) cbxC.getSelectedItem();
				String precio = lblC.getText();
				int precioInt = Integer.parseInt(precio);

				Pizza compra = new Pizza("Carbonara", tamaño, precioInt);
				pizzas.add(compra);
			}
		});
		btnC.setBounds(655, 194, 93, 29);
		contentPane.add(btnC);

		JButton btnH = new JButton("A\u00D1ADIR");
		btnH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// HAWAIANA

				String tamaño = (String) cbxH.getSelectedItem();
				String precio = lblH.getText();
				int precioInt = Integer.parseInt(precio);

				Pizza compra = new Pizza("Hawaiiana", tamaño, precioInt);
				pizzas.add(compra);
			}
		});
		btnH.setBounds(641, 300, 107, 29);
		contentPane.add(btnH);

		JButton btnBo = new JButton("A\u00D1ADIR");
		btnBo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// BOLOÑESA

				String tamaño = (String) cbxB.getSelectedItem();
				String precio = lblBo.getText();
				int precioInt = Integer.parseInt(precio);

				Pizza compra = new Pizza("Boloñesa", tamaño, precioInt);
				pizzas.add(compra);
			}
		});
		btnBo.setBounds(641, 415, 107, 29);
		contentPane.add(btnBo);

		JButton btnComprar = new JButton("COMPRAR");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// ACCION COMPRAR
				if(!pizzas.isEmpty()) {
					
				int totalPrecio = 0;
				for(int i=0;i<pizzas.size();i++) {
					
					totalPrecio+=pizzas.get(i).getPrecio();
				
				}
			
				// AQUI FALTA ABRIR LA PANTALLA FACTURA HABIENDO CREADO LAS PIZZAS COMPRADAS
				
				PantallaFactura mostrar=new PantallaFactura(papi,totalPrecio,pizzas,clientesBD);
				mostrar.setVisible(true);
				MenuCliente.this.dispose();
				}
				else {
					JOptionPane.showMessageDialog(MenuCliente.this, "No has seleccionado nada");
				}

			}
		});
		btnComprar.setBounds(477, 510, 139, 43);
		contentPane.add(btnComprar);

		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// ACCION CANCELAR
				MenuCliente.this.dispose();
				papi.setVisible(true);
				

			}
		});
		btnCancelar.setBounds(270, 510, 122, 43);
		contentPane.add(btnCancelar);

		JLabel label = new JLabel("\u20AC");
		label.setBounds(249, 153, 25, 20);
		contentPane.add(label);

		JLabel label_1 = new JLabel("\u20AC");
		label_1.setBounds(249, 269, 25, 20);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("\u20AC");
		label_2.setBounds(249, 384, 25, 20);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("\u20AC");
		label_3.setBounds(702, 153, 25, 20);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("\u20AC");
		label_4.setBounds(702, 269, 25, 20);
		contentPane.add(label_4);

		JLabel label_5 = new JLabel("\u20AC");
		label_5.setBounds(702, 384, 25, 20);
		contentPane.add(label_5);

		this.setLocationRelativeTo(null);
		// rsscalelabel.RSScaLeLabel.setScaleLabel(label1,"C:\\Users\\PC\\Pictures\\pizza_jamonyqueso_sinlactosa_730x470.jpg");
		// rsscalelabel.RSScaLeLabel.setScaleLabel(label2,"C:\\Users\\PC\\Pictures\\234-c.jpg");

	}
}
