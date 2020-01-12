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
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\PC\\Desktop\\DEUSTO\\3.CURSO\\1.SEMESTRE\\Program III\\depositphotos_124334428-stock-illustration-green-tick-check-mark-icon.jpg"));
		lblNewLabel.setBounds(15, 16, 120, 95);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\PC\\Desktop\\DEUSTO\\3.CURSO\\1.SEMESTRE\\Program III\\pasos.jpg"));
		lblNewLabel_1.setBounds(28, 211, 411, 49);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\PC\\Desktop\\DEUSTO\\3.CURSO\\1.SEMESTRE\\Program III\\telefono-perfiles.jpg"));
		lblNewLabel_2.setBounds(358, 324, 52, 28);
		contentPane.add(lblNewLabel_2);
		
		JLabel label = new JLabel("943 429 445");
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setForeground(new Color(0, 0, 0));
		label.setBounds(425, 324, 134, 28);
		contentPane.add(label);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\PC\\Desktop\\DEUSTO\\3.CURSO\\1.SEMESTRE\\Program III\\baker-amasando-masa-mostrador_13339-87243.jpg"));
		lblNewLabel_3.setBounds(-25, -57, 699, 477);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblWwwpizzasaacom = new JLabel("www.PizzasAA.com");
		lblWwwpizzasaacom.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblWwwpizzasaacom.setBounds(15, 328, 120, 24);
		contentPane.add(lblWwwpizzasaacom);
	}
}
