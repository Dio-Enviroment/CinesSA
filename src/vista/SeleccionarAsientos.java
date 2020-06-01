package vista;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.GridBagLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

import componentes.CustomButton;
import componentes.CustomPanel;

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

public class SeleccionarAsientos extends CustomPanel {
	private JPanel panel;
	private JButton btncomprar;
	private JButton btn_cancelar;
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
	
	private JLabel[] num = new JLabel[8];
	private JLabel[] let = new JLabel[8];

	public SeleccionarAsientos(int width, int height, ControladorSala ctrSala, ControladorView ctrView) {
		this.ctrSala = ctrSala;
		this.ctrView = ctrView;
		setBounds(0, 0, width, height);
		setLayout(null);

		pn_asientos = new JPanel();
		pn_asientos.setBounds(12, 13, 1000, 1000);
		add(pn_asientos);
		pn_asientos.setLayout(null);

		pn_seleccionarAsiento = new JPanel();
		panel = new JPanel();
		panel.setBounds(645, 645, 212, 25);
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
		pn_asientos.add(pn_seleccionarAsiento);
		// pn_seleccionarAsiento.setBackground(Color.red);
		
		pn_seleccionarAsiento.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3), null, TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pn_seleccionarAsiento.setLayout(null);
		
		generarBotones();
		Jlabels();
		invisibleL();
		invisibleN();
		invisible();
		iniComponentEvents();
		showcomponet(false);
	}

	public void ini() {
		this.lbl_asiento.setText(ctrView.getContador());
	}

	public void iniComponentEvents() {
		btncomprar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ctrView.setActivador2(true);
				ctrView.changeCompraPrincipal();
			}

		});
		btn_cancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
		
				ctrView.setActivador2(false);
				ctrView.changeCompraPrincipal();
			}

		});
	}

	public void descargardata() {
		numeros=null;
		letras=null;
		invisible();
		invisibleL();
		invisibleN() ;
		showcomponet(false);
	}
	
	public void cargardata() {
		numeros[0]="1";
		numeros[1]="2";
		numeros[2]="3";
		numeros[3]="4";
		numeros[4]="5";
		numeros[5]="6";
		numeros[6]="7";
		numeros[7]="8";
		 letras[0]="H";
		 letras[1]="G";
		 letras[2]="F";
		 letras[3]="E";
		 letras[4]="D";
		 letras[5]="C";
		 letras[6]="B";
		 letras[7]="A";
		sala = ctrSala.getSala(0);
		asientos = sala.getAsientos();
		pn_seleccionarAsiento.setBounds(200, 120, 77*asientos[0].length , 62* asientos.length);
		for (int i = 0; i < asientos[0].length; i++) {
			num[i].setText(numeros[i]);
			num[i].setVisible(true);
		}
		for (int i = 8-asientos.length; i < 8 ; i++) {
			let[i].setText(letras[i]);
			let[i].setVisible(true);
		}
		refreshBotones(asientos);
		
		showcomponet(true);
	}
	
	
	public void Jlabels() {
		int x =230;
		int y=80;
		for (int i = 0; i < num.length; i++) {
			JLabel l1 = new JLabel();
			l1.setFont(new Font("Verdana", Font.BOLD, 18));
			l1.setBounds(x,y, 40, 40);
			x+=77;
			num[i]=l1;
			pn_asientos.add(num[i]);
		}
		
		int w =160;
		int z =20;
		for (int i = 0; i < let.length; i++) {
			JLabel l = new JLabel();
			l.setFont(new Font("Verdana", Font.BOLD, 18));
			l.setBounds(w,z, 15, 18);
			z+=65;
			let[i]=l;
			pn_asientos.add(let[i]);
		}
	}
	
	//pn_seleccionarAsiento.setBounds(200, 120, 77*asientos[0].length , 62* asientos.length);
	public void showcomponet(boolean visible) {
		panel.setVisible(visible);
		btncomprar.setVisible(visible);
		btn_cancelar.setVisible(visible);
		pn_seleccionarAsiento.setVisible(visible);
		lbl_asientos.setVisible(visible);
		lbl_asiento.setVisible(visible);
		pn_asientos.setVisible(visible);
	}

	private void refreshBotones(boolean[][] dim) {
		int x = dim.length;
		int y = dim[0].length;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (asientos[i][j]) {
					botones[i][j].changeIcon(2);
					botones[i][j].setEnabled(false);
				} else {
					botones[i][j].changeIcon(0);
				}
				botones[i][j].setVisible(true);
			}
		}
	}

	/*private void valorIni(boolean[][] dim) {
		int x = dim.length;
		int y = dim[0].length;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (botones[i][j].isEnabled()) {
					botones[i][j].changeIcon(0);
					botones[i][j].setEnabled(true);
				}
			}
		}
	}*/
	private void invisibleL() {
		for (int i = 0; i < num.length; i++) {
			num[i].setVisible(false);
		}
	}
	private void invisibleN() {
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
	
	private void generarBotones() {
		int itemWidth = 62, itemHeight = 47;
		int iniX = 5, iniY =5, spaceX = 15, spaceY = 15;
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
						CustomButton btn = (CustomButton) e.getSource();
						int x = (int) btn.getCustomParameter(0);
						int y = (int) btn.getCustomParameter(1);
						boolean interuptor = (boolean) btn.getCustomParameter(2);
						if (interuptor) {
							
							btn.changeIcon(1);
							btn.setCustomParameter(2, false);
							sala.ocuparAsiento(x, y);
						} else {
							btn.changeIcon(0);
							btn.setCustomParameter(2, true);
							sala.vaciarAsiento(x, y);
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
