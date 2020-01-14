package logica.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
/**
 * 
 * @author Ane y Aitor
 *
 */
public class ConfirmacionPedido extends JFrame {

	private JPanel contentPane;



	/**
	 * Create the frame ConfirmacionPedido es la pantalla donde se muestra el mensaje del pedido confirmado con los datos de la factura
	 */
	public ConfirmacionPedido(int importe) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblImporte = new JLabel("IMPORTE " + importe +"€" );
		lblImporte.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblImporte.setBounds(375, 0, 166, 77);
		contentPane.add(lblImporte);
		
		JLabel lblhemosRecibidoTu = new JLabel("\u00A1Hemos recibido tu pedido!");
		lblhemosRecibidoTu.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblhemosRecibidoTu.setBounds(28, 117, 385, 49);
		contentPane.add(lblhemosRecibidoTu);
		
		JLabel lblEnBreveEmpezaremos = new JLabel("En breve empezaremos a preparar tu pedido:");
		lblEnBreveEmpezaremos.setBounds(38, 167, 432, 28);
		contentPane.add(lblEnBreveEmpezaremos);
		
		JLabel label_icono = new JLabel("New label");
		label_icono.setVerticalAlignment(SwingConstants.TOP);
		label_icono.setIcon(new ImageIcon("imagenes/tik.jpg"));
		label_icono.setBounds(15, 16, 120, 95);
		contentPane.add(label_icono);
		
		JLabel label_barra = new JLabel("New label");
		label_barra.setIcon(new ImageIcon("imagenes/pasos.jpg"));
		label_barra.setBounds(28, 211, 411, 49);
		contentPane.add(label_barra);
		
		JLabel label_Tel = new JLabel("New label");
		label_Tel.setIcon(new ImageIcon("imagenes/tel.jpg"));
		label_Tel.setBounds(358, 324, 52, 28);
		contentPane.add(label_Tel);
		
		JLabel label = new JLabel("943 429 445");
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setForeground(new Color(0, 0, 0));
		label.setBounds(425, 324, 134, 28);
		contentPane.add(label);
		
		JLabel label_Confir = new JLabel("New label");
		label_Confir.setIcon(new ImageIcon("imagenes/confirmarPedido.jpg"));
		label_Confir.setBounds(-25, -57, 699, 477);
		contentPane.add(label_Confir);
		
		JLabel lblWwwpizzasaacom = new JLabel("www.PizzasAA.com");
		lblWwwpizzasaacom.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblWwwpizzasaacom.setBounds(15, 328, 203, 24);
		contentPane.add(lblWwwpizzasaacom);
	}
}
