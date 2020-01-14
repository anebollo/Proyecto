package logica.presentacion;

import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import exception.UsuarioNoExiste;
import logica.negocios.Administrador;
import logica.negocios.Cliente;
import logica.negocios.Factura;
import logica.negocios.Repartidor;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

/**
 * 
 * @author Alumno ANE Y AITOR
 *
 */
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField adminText;
	private JPasswordField passText;

	private ArrayList<Cliente> clientesBD = new ArrayList<Cliente>();
	private ArrayList<Administrador> admiBD = new ArrayList<Administrador>();
	private ArrayList<Factura> facturasBD = new ArrayList<Factura>();
	private ArrayList<Repartidor> repartidoresBD = new ArrayList<Repartidor>();
	private PantallaInicial padre;
	

	/**
	 * Create the frame Login que es donde introduce el administrador el nombre de
	 * usuario y contraseña y le da acceso al menu del administrador
	 */
	public Login(ArrayList<Cliente> clientes,ArrayList<Factura> facturas,ArrayList<Administrador> administradores,ArrayList<Repartidor> repartidores, PantallaInicial papi) {
		setResizable(false);
		
		this.clientesBD=clientes;
		this.admiBD=administradores;
		this.facturasBD=facturas;
		this.repartidoresBD=repartidores;
		this.padre=papi;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		adminText = new JTextField();
		adminText.setBounds(227, 156, 317, 40);
		contentPane.add(adminText);
		adminText.setColumns(10);

		passText = new JPasswordField();
		passText.setBounds(227, 237, 317, 40);
		contentPane.add(passText);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(108, 161, 74, 30);
		contentPane.add(lblName);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(97, 242, 103, 30);
		contentPane.add(lblPassword);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				// FUNCION OK
				String usuario = adminText.getText();
				String password = passText.getText();

				try {
					boolean encontrado = comprobarAdministrador(usuario, password);
					if (encontrado) {

						MenuAdmi menuAdmi = new MenuAdmi(usuario,password,clientesBD,facturasBD,admiBD,repartidoresBD,padre);
						menuAdmi.setVisible(true);
						Login.this.dispose();
					}

				} catch (UsuarioNoExiste e1) {
					JOptionPane.showMessageDialog(Login.this, e1.getMessage());

				}
			}
		});
		btnOk.setBounds(163, 334, 103, 53);
		contentPane.add(btnOk);

		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// FUNCION CANCEL

				Login.this.dispose();
				padre.setVisible(true);

			}
		});
		btnCancel.setBounds(404, 334, 119, 53);
		contentPane.add(btnCancel);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("imagenes/usuarios.png"));
		lblNewLabel.setBounds(427, -152, 894, 576);
		contentPane.add(lblNewLabel);
	}

	/**
	 * Este metodo sirve para comprobar si existe el nombre usuario y contraseña
	 * introducido por pantalla para ello mirara en la base de datos en el caso de
	 * existir, le dara acceso a la pantalla adminstrador, y en el caso de que no,
	 * le monstrara un mensaje indicandole que el usuario o contraseña no existe.
	 * 
	 * @param usuario
	 *            el nombre usuario introducido por pantalla
	 * @param password
	 *            la contraseña introducida por pantalla
	 * @return devolvera un true en caso de existir y un false en caso de que no
	 * @throws UsuarioNoExiste
	 *             es la clase en la que se implementa la excepcion del usuario no
	 *             existente
	 */
	public boolean comprobarAdministrador(String usuario, String password) throws UsuarioNoExiste {

		boolean existencia = false;

		for (Administrador a : admiBD) {

			if (a.getNombre().equals(usuario)) {
				existencia = true;
				break;

			} else {
				if (a.getContraseña().equals(password)) {

					existencia = true;
					break;
				}

			}
		}

		if (existencia == true) {

			return true;

		} else {

			throw new UsuarioNoExiste("Usuario o contrasenya no Existente");

		}

	}
}
