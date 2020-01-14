package logica.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

/**
 * 
 * @author Ane y Aitor
 *
 */
public class VisualizacionCliente extends JFrame {

	private JPanel contentPane = new JPanel();
	private JTextPane textPane;
	private MenuAdmi padre;
	private String contenidoCliente;
	private String dniCliente;
	private int opcion;
	private String dniAdmin;
	private HashMap<String, String> adminInfo;

	/**
	 * Create the frame VisualizacionCliente sirve para visualizar la informacion
	 * del cliente seleccionado, es decir, las pizzas que ha comprado hasta ahora y
	 * el numero de veces cada una
	 */

	public VisualizacionCliente(String dni, String contenido, MenuAdmi papi, int option) {

		this.padre = papi;
		this.contenidoCliente = contenido;
		this.dniCliente = dni;
		this.opcion = option;

		cargarVentana();

	}

	/**
	 * @wbp.parser.constructor
	 */
	public VisualizacionCliente(MenuAdmi papi, int option, HashMap<String, String> leido, String dni) {
		this.padre = papi;
		this.opcion = option;
		this.dniAdmin = dni;
		this.adminInfo = leido;

		cargarVentana();
	}

	public void cargarVentana() {

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			JTextPane textPane = new JTextPane();
			textPane.setBounds(30, 63, 433, 195);
			contentPane.add(textPane);

			// añadir scroll al textpane
			JScrollPane scrollPane = new JScrollPane(textPane);
			scrollPane.setBounds(30, 63, 433, 195);
			contentPane.add(scrollPane);
			// mostrar string en el panel
			if(opcion==1) {
				textPane.setText(contenidoCliente);
			}
			else if(opcion==2) {
				
				String nombre=adminInfo.get(dniAdmin);
				textPane.setText(nombre);
			}
			

		}

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// accion cancel
				VisualizacionCliente.this.dispose();
				padre.setVisible(true);
			}
		});
		btnCancel.setBounds(428, 312, 115, 29);
		contentPane.add(btnCancel);

		JLabel lblCliente = null;
		if (opcion == 1) {
			lblCliente = new JLabel("CLIENTE:");
		} else if (opcion == 2) {
			lblCliente = new JLabel("ADMINISTRADOR:");
		}

		lblCliente.setFont(new Font("Wide Latin", Font.BOLD, 18));
		lblCliente.setBounds(55, 28, 195, 20);
		contentPane.add(lblCliente);

		JLabel lblDni = null;
		if (opcion == 1) {
			lblDni = new JLabel(dniCliente);
		} else if (opcion == 2) {
			lblDni = new JLabel(dniAdmin);
		}

		lblDni.setBounds(244, 28, 150, 20);
		contentPane.add(lblDni);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(
				"C:\\Users\\PC\\Desktop\\DEUSTO\\3.CURSO\\1.SEMESTRE\\Program III\\pizza-su-caja-vector_42788-52.jpg"));
		lblNewLabel.setBounds(244, 0, 335, 260);
		contentPane.add(lblNewLabel);
	}
}
