package vista;

import javax.swing.JPanel;

import javax.swing.border.LineBorder;
import java.awt.Color;

import javax.swing.border.TitledBorder;

import componentes.CustomButton;
import componentes.CustomPanel;
import componentes.ImageAdaptable;

import javax.swing.JLabel;

import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;

import controlador.ControladorBoleto;
import controlador.ControladorSala;
import controlador.ControladorView;
import modelo.Asiento;
import modelo.Sala;

import javax.swing.UIManager;

public class SeleccionarAsientos extends CustomPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private CustomButton btncomprar;
	private CustomButton btn_cancelar;
	private JPanel pn_seleccionarAsiento;
	private Sala sala;
	private CustomButton botones[][] = new CustomButton[8][8];
	private boolean[][] asientos;
	private ControladorView ctrView;
	private ControladorSala ctrSala;
	private JLabel lbl_asientos;
	private JLabel lbl_asiento;
	private String[] letras = new String[8];
	private String[] numeros = new String[8];
	private JPanel pn_asientos;
	private String puestos;
	private ControladorBoleto ctrBoleto;

	private JLabel[] num = new JLabel[8];
	private JLabel[] let = new JLabel[8];
	private ArrayList<Asiento> salaPre;
	
	private JPanel pn_letras;
	File workingDirectory = new File(System.getProperty("user.dir"));
	String[] paths = { workingDirectory + "//src//resources//sala_5_5.png",workingDirectory + "//src//resources//sala_5_6.png",
			workingDirectory + "//src//resources//sala_5_7.png",workingDirectory + "//src//resources//sala_6_5.png"
			,workingDirectory + "//src//resources//sala_6_6.png",workingDirectory + "//src//resources//sala_6_7.png"
			,workingDirectory + "//src//resources//sala_7_5.png",workingDirectory + "//src//resources//sala_7_6.png"
			,workingDirectory + "//src//resources//sala_7_7.png",workingDirectory + "//src//resources//fondo_s.png"};
	ImageAdaptable img1=new ImageAdaptable(paths[0]);

	public SeleccionarAsientos(int width, int height, ControladorSala ctrSala, ControladorBoleto ctrBoleto, ControladorView ctrView) {
		this.ctrSala = ctrSala;
		this.ctrView = ctrView;
		this.ctrBoleto= ctrBoleto;
		setBounds(0, 0, width, height);
		setLayout(null);
		pn_asientos = new JPanel();
		pn_asientos.setBounds(0, 0, 1008, 729);
		add(pn_asientos);
		pn_letras = new JPanel();
		pn_letras.setLayout(null);
		pn_asientos.setLayout(null);
		pn_asientos.add(pn_letras);
		pn_seleccionarAsiento = new JPanel();
		

		btn_cancelar = new CustomButton("CANCELAR");
		btn_cancelar.setFont(new Font("Verdana", Font.BOLD, 13));
		btn_cancelar.setBounds(570, 650, 125, 50);
		pn_asientos.add(btn_cancelar);
		

		btncomprar = new CustomButton("COMPRAR");
		btncomprar.setFont(new Font("Verdana", Font.BOLD, 13));
		btncomprar.setBounds(700, 650, 125, 50);
		pn_asientos.add(btncomprar);
		

		lbl_asientos = new JLabel("ASIENTOS:");
		lbl_asientos.setForeground(UIManager.getColor("InternalFrame.inactiveTitleForeground"));
		lbl_asientos.setFont(new Font("Verdana", Font.BOLD, 14));
		lbl_asientos.setBounds(12, 14, 101, 16);

		pn_asientos.add(lbl_asientos);

		lbl_asiento = new JLabel("0");
		lbl_asiento.setFont(new Font("Verdana", Font.BOLD, 14));
		lbl_asiento.setBounds(108, 14, 56, 16);

		pn_asientos.add(lbl_asiento);
		pn_asientos.add(pn_seleccionarAsiento);
		
		
		lbl_asiento.setForeground(Color.white);
		lbl_asientos.setForeground(Color.white);
		
		
	
		
		
		pn_seleccionarAsiento.setLayout(null);
		pn_seleccionarAsiento.setOpaque(false);
		pn_letras.setOpaque(false);
		this.btncomprar.setEnabled(false);
		
		
		generarBotones();
		Jlabels();
		pn_asientos.add(img1);
		ImageAdaptable img2=new ImageAdaptable(paths[9]);
		img2.setLocation(0, 0);
		pn_asientos.add(img2);
		
		invisibleL();
		invisibleN();
		invisible();
		
		iniComponentEvents();
		showcomponet(false);
	}

	public void ini() {
		this.lbl_asiento.setText(ctrBoleto.getContador());
	}

	public void iniComponentEvents() {
		btncomprar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				ctrView.setActivador4(true);
				ctrView.setActivador2(true);
				ctrView.changeCompraPrincipal();
				
			}

		});
		btn_cancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ctrView.setActivador4(false);
				ctrBoleto.setPuestos("0");
				ctrBoleto.setTotal("0");
				ctrBoleto.setIva("0");
				ctrBoleto.setSubtotal("0");
				
				ctrSala.vaciarTodos();
				ctrView.setActivador2(false);
				ctrView.changeCompraPrincipal();
			}

		});

	}

	public void descargardata() {
		numeros = null;
		letras = null;
		this.lbl_asiento.setText("0");
		invisibleL();
		invisibleN();
		invisible();
		showcomponet(false);
	}

	public void cargardata() {
		
		numeros[0] = "1";
		numeros[1] = "2";
		numeros[2] = "3";
		numeros[3] = "4";
		numeros[4] = "5";
		numeros[5] = "6";
		numeros[6] = "7";
		numeros[7] = "8";
		letras[0] = "A";
		letras[1] = "B";
		letras[2] = "C";
		letras[3] = "D";
		letras[4] = "E";
		letras[5] = "F";
		letras[6] = "G";
		letras[7] = "H";
		sala = ctrSala.getSala(0);
		asientos = sala.getAsientos();
		pn_letras.setBounds(155, 120, 40, 70 * asientos.length);
		pn_seleccionarAsiento.setBounds(200, 120, 90 * asientos[0].length, 70 * asientos.length);
		invisibleL();
		invisibleN();
		for (int i = 0; i < asientos[0].length; i++) {
			num[i].setText(numeros[i]);
			num[i].setVisible(true);
		}
		for (int i = 0; i < asientos.length; i++) {
			let[i].setText(letras[i]);
			let[i].setVisible(true);
		}
	
		if( asientos.length == 5 && asientos[0].length ==5) {
			 img1.setImage(paths[0]);
			img1.setLocation(100, 90);
			
		}
		if( asientos.length == 5 && asientos[0].length ==6) {
			 img1.setImage(paths[1]);
			img1.setLocation(100, 90);
			
		}
		if( asientos.length == 5 && asientos[0].length ==7) {
			 img1.setImage(paths[2]);
			img1.setLocation(100, 90);
			
		}
		if( asientos.length == 6 && asientos[0].length ==5) {
			 img1.setImage(paths[3]);
			img1.setLocation(124, 90);
			
		}
		if( asientos.length == 6 && asientos[0].length ==6) {
			 img1.setImage(paths[4]);
			img1.setLocation(100, 90);
			
		}
		if( asientos.length == 6 && asientos[0].length ==7) {
			 img1.setImage(paths[5]);
			img1.setLocation(100, 90);
			
		}
		if( asientos.length == 7 && asientos[0].length ==5) {
			 img1.setImage(paths[6]);
			img1.setLocation(115, 80);
			
		}
		if( asientos.length == 7 && asientos[0].length ==6) {
			 img1.setImage(paths[7]);
			img1.setLocation(140, 80);
			
		}
		if( asientos.length == 7 && asientos[0].length ==7) {
			 img1.setImage(paths[8]);
			img1.setLocation(130, 85);
			
		}
		
		
		
		this.lbl_asiento.setText(ctrBoleto.getContador());
		this.btncomprar.setEnabled(false);
		salaPre = ctrSala.getSalaPre();
		
		refreshBotones(asientos);

		showcomponet(true);
	}

	public void Jlabels() {
		int x = 234;
		int y = 80;
		for (int i = 0; i < num.length; i++) {
			JLabel l1 = new JLabel();
			l1.setFont(new Font("Verdana", Font.BOLD, 18));
			l1.setForeground(Color.white);
			l1.setBounds(x, y, 40, 40);
			x += 90;
			num[i] = l1;
			pn_asientos.add(num[i]);
		}

		int w = 10;
		int z = 14;

		for (int i = 0; i < let.length; i++) {
			JLabel l = new JLabel();
			l.setFont(new Font("Verdana", Font.BOLD, 18));
			l.setForeground(Color.white);
			l.setBounds(w, z, 15, 40);
			z += 68;
			let[i] = l;
			pn_letras.add(let[i]);
		}
	}

	public void showcomponet(boolean visible) {
		btncomprar.setVisible(visible);
		btn_cancelar.setVisible(visible);
		pn_seleccionarAsiento.setVisible(visible);
		lbl_asientos.setVisible(visible);
		lbl_asiento.setVisible(visible);
		pn_asientos.setVisible(visible);
		pn_letras.setVisible(visible);
	}

	private void refreshBotones(boolean[][] dim) {
		int x = dim.length;
		int y = dim[0].length;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				
					if (asientos[i][j]) {
						botones[i][j].changeIcon(2);
						botones[i][j].setEnabled(false);
						botones[i][j].setCustomParameter(2, false);
						botones[i][j].setBackground(new Color(127,126,126,255));
					} else {
						botones[i][j].changeIcon(0);
						botones[i][j].setEnabled(true);
						botones[i][j].setCustomParameter(2, true);
						botones[i][j].setBackground(new Color(127,126,126,255));
					}
					botones[i][j].setVisible(true);
					botones[i][j].setBackground(new Color(127,126,126,255));
			
			}
		}
	}

	/*
	 * private void valorIni(boolean[][] dim) { int x = dim.length; int y =
	 * dim[0].length; for (int i = 0; i < x; i++) { for (int j = 0; j < y; j++) { if
	 * (botones[i][j].isEnabled()) { botones[i][j].changeIcon(0);
	 * botones[i][j].setEnabled(true); } } } }
	 */
	private void invisibleN() {
		for (int i = 0; i < num.length; i++) {
			num[i].setVisible(false);
		}
	}

	private void invisibleL() {
		for (int i = 0; i < let.length; i++) {
			let[i].setVisible(false);
		}
	}

	private void invisible() {
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				botones[i][j].setVisible(false);
			}
		}
	}

	/*
	 * public void validarAsiento() { if(this.lbl_asiento.getText().equals("0")) {
	 * this.btncomprar.setEnabled(true); } else { this.btncomprar.setEnabled(false);
	 * } }
	 */

	private void generarBotones() {
		int itemWidth = 75, itemHeight = 55;
		int iniX = 5, iniY = 5, spaceX = 15, spaceY = 15;
		int itemOnly7 = 0;
		int x = iniX, y = iniY;

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				File workingDirectory = new File(System.getProperty("user.dir"));
				Object[] paths = { workingDirectory + "//src//resources//asiento//asiento_disponible.png",
						workingDirectory + "//src//resources//asiento//asiento_seleccionado.png",
						workingDirectory + "//src//resources//asiento//asiento_desabilitado.png", i, j, true };
				CustomButton b1 = new CustomButton(paths, 3);

				b1.addActionListener(new ActionListener() {
					@Override

					public void actionPerformed(ActionEvent e) {
						int aux = Integer.parseInt(lbl_asiento.getText());
						CustomButton btn = (CustomButton) e.getSource();
						int x = (int) btn.getCustomParameter(0);
						int y = (int) btn.getCustomParameter(1);
						boolean interuptor = (boolean) btn.getCustomParameter(2);

						if (aux == 0) {

							if (!interuptor) {
								btn.changeIcon(0);
								btn.setBackground(new Color(127,126,126,255));
								btn.setCustomParameter(2, true);
								//sala.vaciarAsiento(x, y);
								ctrSala.vaciarSeleccionados(x,y);
								
								aux++;
								lbl_asiento.setText(aux + "");
								btncomprar.setEnabled(false);
							}

						} else {
							if (interuptor) {
								btn.changeIcon(1);
								btn.setCustomParameter(2, false);
								btn.setBackground(new Color(127,126,126,255));
								//sala.ocuparAsiento(x, y);
								ctrSala.anadirSalaPre(x, y);
								
								aux--;
								lbl_asiento.setText(aux + "");
								if (aux == 0) {
									btncomprar.setEnabled(true);
								}
							} else {

								btn.changeIcon(0);
								btn.setCustomParameter(2, true);
								btn.setBackground(new Color(127,126,126,255));
								//sala.vaciarAsiento(x, y);
								ctrSala.vaciarSeleccionados(x,y);
								aux++;
								lbl_asiento.setText(aux + "");
							}
						}

					}
				});

				b1.setBounds(x, y, itemWidth, itemHeight);
				x += itemWidth + spaceX;
				itemOnly7++;
				if (itemOnly7 == 7) {
					itemOnly7 = 0;
					y += itemHeight + spaceY;
					x = iniX;
				}
				botones[i][j] = b1;
				pn_seleccionarAsiento.add(b1);
			}
		}
	}
}
