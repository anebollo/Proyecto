package logica.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.awt.event.ActionEvent;

public class EnviarCorreo extends JFrame {

	private JPanel contentPane;
	private JTextField txtRemitente;
	private JTextField txtDestinatario;
	private JTextField txtCuerpo;
	private JLabel lblEmisor;
	private JLabel lblReceptor;
	private JLabel lblCuerpo;
	

	/**
	 * Create the frame.
	 */
	public EnviarCorreo(MenuAdmi padre, String user, String passW) {


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEnviarCorreo = new JLabel("ENVIAR CORREO");
		lblEnviarCorreo.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblEnviarCorreo.setForeground(new Color(0, 0, 0));
		lblEnviarCorreo.setBounds(105, 16, 348, 49);
		contentPane.add(lblEnviarCorreo);

		txtRemitente = new JTextField();
		txtRemitente.setBounds(133, 112, 289, 33);
		contentPane.add(txtRemitente);
		txtRemitente.setColumns(10);

		txtDestinatario = new JTextField();
		txtDestinatario.setBounds(133, 166, 289, 33);
		contentPane.add(txtDestinatario);
		txtDestinatario.setColumns(10);

		txtCuerpo = new JTextField();
		txtCuerpo.setBounds(132, 215, 290, 113);
		//contentPane.add(txtCuerpo);
		txtCuerpo.setColumns(10);
	

		// PONER EL SCROLLPANE EN UN txt
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(txtCuerpo);
		scroll.setBounds(132, 215, 290, 113);
		contentPane.add(scroll);

		JButton btnEnviar = new JButton("ENVIAR");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// aCCION ENVIAR

				String remi = txtRemitente.getText();
				String dest = txtDestinatario.getText();
				String cuerpo = txtCuerpo.getText();

				if (remi != null || dest != null || cuerpo != null) {

					JOptionPane.showMessageDialog(null, "Uno de los campos esta vacio");

				} else {
					
					if(EnviarCorreo.enviarGmail(user, passW, dest, cuerpo)==true) {
						
						JOptionPane.showMessageDialog(null, "enviado");
						int opcion=JOptionPane.showConfirmDialog(contentPane, "Quieres volver al menu?");
						if(opcion==0) {
							
							padre.setVisible(true);
							EnviarCorreo.this.dispose();
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "No se ha podido enviar");
					}

				}

			}
		});
		btnEnviar.setBounds(407, 366, 115, 29);
		contentPane.add(btnEnviar);

		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// ACCION CANCEL

				padre.setVisible(true);
				EnviarCorreo.this.dispose();
			}
		});
		btnCancel.setBounds(42, 366, 115, 29);
		contentPane.add(btnCancel);
		
		JLabel lblFoto = new JLabel("New label");
		lblFoto.setIcon(new ImageIcon("imagenes/correo.jpg"));
		lblFoto.setBounds(-27, -35, 662, 540);
		contentPane.add(lblFoto);
		
		lblEmisor = new JLabel("Emisor");
		lblEmisor.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEmisor.setBounds(27, 118, 69, 20);
		contentPane.add(lblEmisor);
		
		lblReceptor = new JLabel("Receptor");
		lblReceptor.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblReceptor.setBounds(27, 171, 91, 20);
		contentPane.add(lblReceptor);
		
		lblCuerpo = new JLabel("Cuerpo");
		lblCuerpo.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCuerpo.setBounds(27, 215, 69, 20);
		contentPane.add(lblCuerpo);
	}

	public static boolean enviarGmail(String user, String contra, String destinatario, String cuerpo) {

		Properties emailProperties = new Properties();
		emailProperties.put("mail.smtp.host", "smtp.gmail.com");
		emailProperties.put("mail.smtp.auth", "true");
		emailProperties.put("mail.smtp.port", "465");
		emailProperties.put("mail.smtp.socketFactory.port", "465");
		emailProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		emailProperties.put("mail.debug", "true");
		emailProperties.put("mail.smtp.user", user);
		emailProperties.put("mail.smtp.clave", contra);

		Session session = Session.getDefaultInstance(emailProperties);
		MimeMessage message = new MimeMessage(session);
		try {
			BodyPart texto = new MimeBodyPart();
			texto.setText(cuerpo);

			MimeMultipart m = new MimeMultipart();
			m.addBodyPart(texto);

			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
			message.setContent(m);

			Transport transport = session.getTransport("smtp");
			transport.connect("smtp.gmail.com", user, contra);
			transport.sendMessage(message, message.getAllRecipients());

			transport.close();
			return true;

		} catch (MessagingException me) {

			return false;
		}

	}
}
