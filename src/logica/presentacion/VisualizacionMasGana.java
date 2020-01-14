package logica.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.negocios.Factura;

import javax.swing.JTextPane;
import java.awt.Font;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisualizacionMasGana extends JFrame {

	private JPanel contentPane;
	private ArrayList<Factura> listaFacturas;
	private MenuAdmi atras;

	/**
	 * Create the frame.
	 */
	public VisualizacionMasGana(MenuAdmi padre, ArrayList<Factura> listaFacturasBD) {

		listaFacturas = listaFacturasBD;
		atras=padre;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Verdana", Font.BOLD, 30));
		textPane.setBounds(66, 149, 434, 109);
		contentPane.add(textPane);
		// añadir contenido al textPane
		ArrayList<String> mes=ordenar();
		String contenido="";
		for(int i=0;i<mes.size();i++) {
			contenido=mes.get(i)+"\n";
		}
		textPane.setText(contenido);

		JLabel lblMesQueMas = new JLabel("MES QUE MAS GANA");
		lblMesQueMas.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 38));
		lblMesQueMas.setBounds(147, 31, 297, 76);
		contentPane.add(lblMesQueMas);

		JLabel lblfoto = new JLabel("New label");
		lblfoto.setIcon(new ImageIcon("imagenes/empresario.jpg"));
		lblfoto.setBounds(391, 391, 217, 48);
		contentPane.add(lblfoto);
		
		JButton btnCancel = new JButton("ATRAS");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//ACCION ATRAS
				
				atras.setVisible(true);
				VisualizacionMasGana.this.dispose();
				
			}
		});
		btnCancel.setBounds(456, 309, 115, 29);
		contentPane.add(btnCancel);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//aCCION SALIR
				
				VisualizacionMasGana.this.dispose();
			}
		});
		btnSalir.setBounds(27, 309, 115, 29);
		contentPane.add(btnSalir);
	}

	public ArrayList<String> ordenar() {

		SimpleDateFormat objSDF = new SimpleDateFormat("MM");
		ArrayList<Integer> numMeses = new ArrayList<>();

		int enero = (int) listaFacturas.stream().filter(w -> objSDF.format(w.getFecha()).equals("01")).count();
		int febrero = (int) listaFacturas.stream().filter(w -> objSDF.format(w.getFecha()).equals("02")).count();
		int marzo = (int) listaFacturas.stream().filter(w -> objSDF.format(w.getFecha()).equals("03")).count();
		int abril = (int) listaFacturas.stream().filter(w -> objSDF.format(w.getFecha()).equals("04")).count();
		int mayo = (int) listaFacturas.stream().filter(w -> objSDF.format(w.getFecha()).equals("05")).count();
		int junio = (int) listaFacturas.stream().filter(w -> objSDF.format(w.getFecha()).equals("06")).count();
		int julio = (int) listaFacturas.stream().filter(w -> objSDF.format(w.getFecha()).equals("07")).count();
		int agosto = (int) listaFacturas.stream().filter(w -> objSDF.format(w.getFecha()).equals("08")).count();
		int septiembre = (int) listaFacturas.stream().filter(w -> objSDF.format(w.getFecha()).equals("09")).count();
		int octubre = (int) listaFacturas.stream().filter(w -> objSDF.format(w.getFecha()).equals("10")).count();
		int noviembre = (int) listaFacturas.stream().filter(w -> objSDF.format(w.getFecha()).equals("11")).count();
		int diciembre = (int) listaFacturas.stream().filter(w -> objSDF.format(w.getFecha()).equals("12")).count();

		numMeses.add(enero);
		numMeses.add(febrero);
		numMeses.add(marzo);
		numMeses.add(abril);
		numMeses.add(mayo);
		numMeses.add(junio);
		numMeses.add(julio);
		numMeses.add(agosto);
		numMeses.add(septiembre);
		numMeses.add(octubre);
		numMeses.add(noviembre);
		numMeses.add(diciembre);

		int mesMas = numMeses.stream().mapToInt(i -> i).max().getAsInt();
		int position = 0;
		ArrayList<Integer> masDeUno = new ArrayList<Integer>();
		ArrayList<String> masDeUnMes = new ArrayList<String>();
		String mes = null;
		for (int i = 0; i < numMeses.size(); i++) {

			if (numMeses.get(i) == mesMas) {

				position = i + 1;
				masDeUno.add(position);
			}

		}

		for(int i=0;i<masDeUno.size();i++) {

		if (masDeUno.get(i) == 1) {
			mes = "ENERO";
			masDeUnMes.add(mes);
		} else if (masDeUno.get(i) == 2) {
			mes = "FEBRERO";
			masDeUnMes.add(mes);
		} else if (masDeUno.get(i) == 3) {
			mes = "MARZO";
			masDeUnMes.add(mes);
		} else if (masDeUno.get(i) == 4) {
			mes = "ABRIL";
			masDeUnMes.add(mes);
		} else if (masDeUno.get(i) == 5) {
			mes = "MAYO";
			masDeUnMes.add(mes);
		} else if (masDeUno.get(i) == 6) {
			mes = "JUNIO";
			masDeUnMes.add(mes);
		} else if (masDeUno.get(i) == 7) {
			mes = "JULIO";
			masDeUnMes.add(mes);
		} else if (masDeUno.get(i) == 8) {
			mes = "AGOSTO";
			masDeUnMes.add(mes);
		} else if (masDeUno.get(i) == 9) {
			mes = "SEPTIEMBRE";
			masDeUnMes.add(mes);
		} else if (masDeUno.get(i) == 10) {
			mes = "0CTUBRE";
			masDeUnMes.add(mes);
		} else if (masDeUno.get(i) == 11) {
			mes = "NOVIEMBRE";
			masDeUnMes.add(mes);
		} else if (masDeUno.get(i) == 12) {
			mes = "DICIEMBRE";
			masDeUnMes.add(mes);
		}
		
		}

		return masDeUnMes;
	}
}
