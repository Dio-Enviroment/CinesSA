package vista;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.GridBagLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;
import controlador.ControladorSala;
import controlador.ControladorView;
import modelo.Sala;

import javax.swing.UIManager;

public class SeleccionarAsientos extends JPanel {
	private JLabel lbl_A;
	private JPanel panel;
	public JButton btncomprar;
	public JButton btn_cancelar;
	public JPanel pn_seleccionarAsiento;
	private Sala sala;
	private JButton asientos[][];
	private ControladorView ctrView;
	private JLabel lbl_asientos;
	private JLabel lbl_asiento;
	//String

	// public Prueba fr = new Prueba();
	/**
	 * Create the panel.
	 */
	public SeleccionarAsientos(int width, int height, ControladorSala ctrSala, ControladorView ctrView) {
		this.sala = ctrSala.getSala(0);
		this.ctrView=ctrView;
		setLayout(null);

		pn_asientos = new JPanel();
		pn_asientos.setBounds(12, 13, 661, 505);
		add(pn_asientos);
		pn_asientos.setLayout(null);

		pn_seleccionarAsiento = new JPanel();
		pn_seleccionarAsiento.setBounds(12, 30, 637, 415);
		pn_asientos.add(pn_seleccionarAsiento);
		pn_seleccionarAsiento.setBorder(new LineBorder(Color.MAGENTA, 2, true));
		GridBagLayout gbl_pn_seleccionarAsiento = new GridBagLayout();
		gbl_pn_seleccionarAsiento.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_pn_seleccionarAsiento.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_pn_seleccionarAsiento.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_pn_seleccionarAsiento.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		pn_seleccionarAsiento.setLayout(gbl_pn_seleccionarAsiento);

		panel = new JPanel();
		panel.setBounds(437, 446, 212, 25);
		pn_asientos.add(panel);
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		btn_cancelar = new JButton("CANCELAR");
		btn_cancelar.setFont(new Font("Verdana", Font.BOLD, 13));
		panel.add(btn_cancelar);

		btncomprar = new JButton("COMPRAR");
		btncomprar.setFont(new Font("Verdana", Font.BOLD, 13));
		panel.add(btncomprar);

		lbl_asientos = new JLabel("ASIENTOS:");
		lbl_asientos.setForeground(UIManager.getColor("InternalFrame.inactiveTitleForeground"));
		lbl_asientos.setFont(new Font("Verdana", Font.BOLD, 14));
		lbl_asientos.setBounds(12, 14, 101, 16);

		pn_asientos.add(lbl_asientos);

		lbl_asiento = new JLabel("0");
		lbl_asiento.setFont(new Font("Verdana", Font.BOLD, 14));
		lbl_asiento.setBounds(108, 14, 56, 16);

		pn_asientos.add(lbl_asiento);
		this.btncomprar.setEnabled(false);
		
		Botones();
		/************** NEcesito Numero sala ***////////////////////
		mostrarAsientos(sala.getId());
		generar();
		comprar();
		System.out.println(ctrView.getContador());
		
		cancelar();
		// init();
	}

	public void ini() {
		this.lbl_asiento.setText(ctrView.getContador());
	}

	private ArrayList<JButton[][]> salas = new ArrayList<JButton[][]>();

	public ArrayList<JButton[][]> getSalas() {
		return salas;
	}

	public void Botones() {
		boolean[][] asientos = sala.getAsientos();
		generarBotones(asientos[0].length, asientos.length);
	}

	public void generarBotones(int numFil, int numCol) {

		asientos = new JButton[numFil][numCol];
		for (int i = 0; i < asientos.length; i++) {
			for (int j = 0; j < asientos[i].length; j++) {
				JButton b1 = new JButton();
				b1.setOpaque(false);
				b1.setContentAreaFilled(false);
				b1.setBounds(0, 0, 300, 344);
				b1.setBorderPainted(false);
				b1.setIcon(new ImageIcon(SeleccionarAsientos.class.getResource("/resources/asiento/asiento_disponible.png")));
				b1.setText(".");
				b1.setHorizontalTextPosition(SwingConstants.CENTER);
				b1.setForeground(Color.white);
				asientos[i][j] = b1;
			}
		}
	}

	public String[] letras = { "H", "G", "F", "E", "D", "C", "B", "A" };
	public String[] numeros = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
	public JPanel pn_asientos;

	public void mostrarAsientos(int num_sala) {
		int n = 2, m = 2, ln = 2;
		lbl_A = new JLabel();
		lbl_A.setFont(new Font("Verdana", Font.BOLD, 14));
		int aux = asientos.length;
		int aux2 = asientos[0].length;
		// for (int i = 0; i < salas.size(); i++) {
		// if (i == num_sala) {
		for (int j = 0; j < asientos.length; j++) {
			n = 2;
			for (int j2 = 0; j2 < asientos[j].length; j2++) {
				GridBagConstraints gbc_btn = new GridBagConstraints();
				gbc_btn.insets = new Insets(0, 0, 5, 5);
				gbc_btn.gridx = n;
				gbc_btn.gridy = m;
				pn_seleccionarAsiento.add(asientos[j][j2], gbc_btn);
				n++;
			}
			m++;
		}

		for (int i = letras.length - aux; i < letras.length; i++) {
			GridBagConstraints gbc_lbl = new GridBagConstraints();
			gbc_lbl.insets = new Insets(0, 0, 0, 5);
			gbc_lbl.gridx = 1;
			gbc_lbl.gridy = ln;
			JLabel texto = new JLabel(letras[i]);
			texto.setFont(new Font("Verdana", Font.BOLD, 23));
			pn_seleccionarAsiento.add(texto, gbc_lbl);
			ln++;
		}
		int lm = 2;
		for (int i = 0; i < aux2; i++) {
			GridBagConstraints gbc_lbl = new GridBagConstraints();
			gbc_lbl.insets = new Insets(0, 0, 0, 5);
			gbc_lbl.gridx = lm;
			gbc_lbl.gridy = 1;
			JLabel texto = new JLabel(numeros[i]);
			texto.setFont(new Font("Verdana", Font.BOLD, 23));
			pn_seleccionarAsiento.add(texto, gbc_lbl);
			lm++;
		}
	}

	public void generar() {
		
		
		for (int j = 0; j < asientos.length; j++) {
			for (int j2 = 0; j2 < asientos[j].length; j2++) {
				asientos[j][j2].addActionListener(new ActionListener() {
					int cont = 0;
					int p = 0;

					@Override
					public void actionPerformed(ActionEvent e) {
						JButton b = (JButton) e.getSource();
						p = Integer.parseInt(lbl_asiento.getText());

						if (p != 0) {
							if (cont == 0) {
								b.setIcon(new ImageIcon(SeleccionarAsientos.class.getResource("/resources/asiento/asiento_seleccionado.png")));
								b.setText("");
								p--;
								lbl_asiento.setText(p + "");

								cont++;

							} else {
								b.setIcon(new ImageIcon(SeleccionarAsientos.class.getResource("/resources/asiento/asiento_disponible.png")));
								b.setText(".");
								p++;
								lbl_asiento.setText(p + "");

								cont--;

							}
						} else {
							if (b.getText().equals("")) {
								b.setIcon(new ImageIcon(SeleccionarAsientos.class.getResource("/resources/asiento/asiento_disponible.png")));
								b.setText(".");
								p++;
								lbl_asiento.setText(p + "");

							} else {
								System.out.println("No puede seleccionar mas asientos");
							}

						}
						if (lbl_asiento.getText().equals("0")) {
							btncomprar.setEnabled(true);
						} else {
							btncomprar.setEnabled(false);
						}
					}

				});
			}
		}
		// }
		// }

	}

	
	private String puestos = "";

	public void comprar() {

		btncomprar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent er) {

				// ArrayList<JButton[][]> asientos = new ArrayList<JButton[][]>();
				// asientos = getSalas();
				// for (int i = 0; i < asientos.size(); i++) {
				puestos = "";
				// if (i == num_sala) {
				for (int j = 0; j < asientos.length; j++) {
					for (int k = 0; k < asientos[j].length; k++) {
						if (asientos[j][k].getText().equals("")) {
							asientos[j][k].setIcon(new ImageIcon(SeleccionarAsientos.class.getResource("/resources/asiento/asiento_desabilitado.png")));
							asientos[j][k].setEnabled(false);
							asientos[j][k].setText("..");
							asientos[j][k].setHorizontalTextPosition(SwingConstants.CENTER);
							asientos[j][k].setForeground(Color.white);
							sala.ocuparAsiento(j, k);
							puestos = puestos + letras[j] + (k + 1) + " ";

						}
					}
				}
				// }
				// }
				ctrView.changeCompraPrincipal();
			}

		});

	}

	public void cancelar() {

		this.btn_cancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// ArrayList<JButton[][]> asientos = new ArrayList<JButton[][]>();
				// asientos = getSalas();
				// for (int i = 0; i < asientos.size(); i++) {
				// if (i == num_sala) {
				for (int j = 0; j < asientos.length; j++) {
					for (int k = 0; k < asientos[j].length; k++) {
						if (asientos[j][k].getText().equals("")) {
							asientos[j][k].setIcon(new ImageIcon(SeleccionarAsientos.class.getResource("/resources/asiento/asiento_disponible.png")));
							asientos[j][k].setText(".");
							asientos[j][k].setHorizontalTextPosition(SwingConstants.CENTER);
							asientos[j][k].setForeground(Color.white);
							sala.vaciarAsiento(j, k);
						}
					}
				}
				// }
				// }
			}

		});
	}

	public void limpiarValore(int num_sala) {

		// ArrayList<JButton[][]> asientos = new ArrayList<JButton[][]>();
		// asientos = getSalas();
		// for (int i = 0; i < asientos.size(); i++) {
		// if (i == num_sala) {
		for (int j = 0; j < asientos.length; j++) {
			for (int k = 0; k < asientos[j].length; k++) {
				if (asientos[j][k].getText().equals("..")) {
					asientos[j][k].setIcon(new ImageIcon(SeleccionarAsientos.class.getResource("/resources/asiento/asiento_disponible.png")));
					asientos[j][k].setText(".");
					asientos[j][k].setHorizontalTextPosition(SwingConstants.CENTER);
					asientos[j][k].setForeground(Color.white);
					asientos[j][k].setEnabled(true);
					this.btncomprar.setEnabled(false);
					sala.vaciarAsiento(j, k);
				}
			}
		}
		// }
		// }
	}
}
