package vista;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.border.TitledBorder;

import componentes.CustomPanel;
// import controlador.Registro_asiento;
// import Modelo.DatosCliente;
import controlador.ControladorBoleto;
import controlador.ControladorSala;
import controlador.ControladorView;
import modelo.Asiento;
import modelo.Sala;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ResumenCompra extends CustomPanel {
	private JPanel pn_resumenCompra;
	private JLabel lbl_salaR;
	private JLabel lbl_peliculaR;
	private JLabel lbl_boletosR;
	private JLabel lbl_totalR;
	private JLabel lbl_asientosR;
	public JLabel lbl_numSalaR;
	public JLabel lbl_numAsiemtosR;
	public JLabel lbl_numBoletasR;
	public JLabel lbl_numTotalR;
	private JPanel panel;
	public JButton btn_cancelar;
	public JButton btn_comprar;
	public JPanel pn_resumen;
	public JLabel lbl_tituloPeliculaR;
	private ControladorSala ctrSala;
	private ControladorView ctrView;
	private Sala sala;
	private ArrayList<Asiento> salaPre;
	private boolean [][]salaAct;
	/**
	 * Create the panel.
	 */
	public ResumenCompra(int width,int height, ControladorSala ctrSala, ControladorView ctrView) {
		this.ctrSala = ctrSala;
		this.ctrView = ctrView;
		setLayout(null);
		setBounds(0, 0, width, height);
		pn_resumen = new JPanel();
		pn_resumen.setBounds(26, 30, 386, 285);
		add(pn_resumen);
		pn_resumen.setLayout(null);

		pn_resumenCompra = new JPanel();
		pn_resumenCompra.setBounds(12, 13, 343, 178);
		pn_resumen.add(pn_resumenCompra);
		pn_resumenCompra.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "RESUMEN DE LA COMPRA",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gbl_pn_resumenCompra = new GridBagLayout();
		gbl_pn_resumenCompra.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_pn_resumenCompra.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_pn_resumenCompra.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_pn_resumenCompra.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		pn_resumenCompra.setLayout(gbl_pn_resumenCompra);

		lbl_peliculaR = new JLabel("PEL\u00CDCULA:");
		lbl_peliculaR.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lbl_peliculaR = new GridBagConstraints();
		gbc_lbl_peliculaR.anchor = GridBagConstraints.WEST;
		gbc_lbl_peliculaR.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_peliculaR.gridx = 1;
		gbc_lbl_peliculaR.gridy = 1;
		pn_resumenCompra.add(lbl_peliculaR, gbc_lbl_peliculaR);

		lbl_tituloPeliculaR = new JLabel("t\u00EDtulo de la pel\u00EDcula");
		lbl_tituloPeliculaR.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_lbl_tituloPeliculaR = new GridBagConstraints();
		gbc_lbl_tituloPeliculaR.insets = new Insets(0, 0, 5, 0);
		gbc_lbl_tituloPeliculaR.gridx = 2;
		gbc_lbl_tituloPeliculaR.gridy = 1;
		pn_resumenCompra.add(lbl_tituloPeliculaR, gbc_lbl_tituloPeliculaR);

		lbl_salaR = new JLabel("SALA:");
		lbl_salaR.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lbl_salaR = new GridBagConstraints();
		gbc_lbl_salaR.anchor = GridBagConstraints.WEST;
		gbc_lbl_salaR.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_salaR.gridx = 1;
		gbc_lbl_salaR.gridy = 2;
		pn_resumenCompra.add(lbl_salaR, gbc_lbl_salaR);

		lbl_numSalaR = new JLabel("1");
		lbl_numSalaR.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_lbl_numSalaR = new GridBagConstraints();
		gbc_lbl_numSalaR.anchor = GridBagConstraints.WEST;
		gbc_lbl_numSalaR.insets = new Insets(0, 0, 5, 0);
		gbc_lbl_numSalaR.gridx = 2;
		gbc_lbl_numSalaR.gridy = 2;
		pn_resumenCompra.add(lbl_numSalaR, gbc_lbl_numSalaR);

		lbl_boletosR = new JLabel("BOLETOS:");
		lbl_boletosR.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lbl_boletosR = new GridBagConstraints();
		gbc_lbl_boletosR.anchor = GridBagConstraints.WEST;
		gbc_lbl_boletosR.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_boletosR.gridx = 1;
		gbc_lbl_boletosR.gridy = 3;
		pn_resumenCompra.add(lbl_boletosR, gbc_lbl_boletosR);

		lbl_numBoletasR = new JLabel("1");
		lbl_numBoletasR.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_lbl_numBoletasR = new GridBagConstraints();
		gbc_lbl_numBoletasR.anchor = GridBagConstraints.WEST;
		gbc_lbl_numBoletasR.insets = new Insets(0, 0, 5, 0);
		gbc_lbl_numBoletasR.gridx = 2;
		gbc_lbl_numBoletasR.gridy = 3;
		pn_resumenCompra.add(lbl_numBoletasR, gbc_lbl_numBoletasR);

		lbl_asientosR = new JLabel("ASIENTOS:");
		lbl_asientosR.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lbl_asientosR = new GridBagConstraints();
		gbc_lbl_asientosR.anchor = GridBagConstraints.WEST;
		gbc_lbl_asientosR.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_asientosR.gridx = 1;
		gbc_lbl_asientosR.gridy = 4;
		pn_resumenCompra.add(lbl_asientosR, gbc_lbl_asientosR);

		lbl_numAsiemtosR = new JLabel("{ A3 - B5 -B6 }");
		lbl_numAsiemtosR.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_lbl_numAsiemtosR = new GridBagConstraints();
		gbc_lbl_numAsiemtosR.anchor = GridBagConstraints.WEST;
		gbc_lbl_numAsiemtosR.insets = new Insets(0, 0, 5, 0);
		gbc_lbl_numAsiemtosR.gridx = 2;
		gbc_lbl_numAsiemtosR.gridy = 4;
		pn_resumenCompra.add(lbl_numAsiemtosR, gbc_lbl_numAsiemtosR);

		lbl_totalR = new JLabel("TOTAL:");
		lbl_totalR.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lbl_totalR = new GridBagConstraints();
		gbc_lbl_totalR.anchor = GridBagConstraints.WEST;
		gbc_lbl_totalR.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_totalR.gridx = 1;
		gbc_lbl_totalR.gridy = 5;
		pn_resumenCompra.add(lbl_totalR, gbc_lbl_totalR);

		lbl_numTotalR = new JLabel("1");
		lbl_numTotalR.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_lbl_numTotalR = new GridBagConstraints();
		gbc_lbl_numTotalR.anchor = GridBagConstraints.WEST;
		gbc_lbl_numTotalR.insets = new Insets(0, 0, 5, 0);
		gbc_lbl_numTotalR.gridx = 2;
		gbc_lbl_numTotalR.gridy = 5;
		pn_resumenCompra.add(lbl_numTotalR, gbc_lbl_numTotalR);

		panel = new JPanel();
		panel.setBounds(57, 204, 250, 40);
		pn_resumen.add(panel);
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		btn_cancelar = new JButton("CANCELAR");
		btn_cancelar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				ctrView.setPuestos("0");
				ctrView.setTotal("0");
				ctrView.setIva("0");
				ctrView.setSubtotal("0");
				//setAsientos();
				ctrView.setActivador(false);
				ctrView.setActivador2(false);
				ctrView.changeCartelera();
			}

		});
		btn_cancelar.setFont(new Font("Verdana", Font.BOLD, 14));
		panel.add(btn_cancelar);

		btn_comprar = new JButton("COMPRAR");
		btn_comprar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ctrView.setPuestos("0");
				ctrView.setTotal("0");
				ctrView.setIva("0");
				ctrView.setSubtotal("0");
				setAsientos();
				
				ctrView.setActivador(false);
				ctrView.setActivador2(false);
				
				ctrView.changeCartelera();
				//ctrView.changeAgradecimiento();
			}

		});
		btn_comprar.setFont(new Font("Verdana", Font.BOLD, 14));
		panel.add(btn_comprar);
		sala = ctrSala.getSala(0);
		salaAct =  sala.getAsientos();
		salaPre = ctrSala.getSalaPre();
		
		
		showcomponet(false);
	}

	public void descargardata() {
		
		// maxA=0;//
		// asientos="";
		// estado=false;
		showcomponet(false);
		// this.lbl_contador.setText("0");
		// this.lbl_tituloPelicula.setText("");
		// this.lbl_tiiposala.setText("");
		// this.lbl_valor_iva.setText("0");
		// this.lbl_valor_Subtotal.setText("0");
		// this.lbl_valor_total.setText("0");
	}
	public void cargardata() {
		
		showcomponet(true);
	}

	public void showcomponet(boolean visible){
		pn_resumenCompra.setVisible(visible);
		lbl_salaR.setVisible(visible);
		lbl_peliculaR.setVisible(visible);
		lbl_boletosR.setVisible(visible);
		lbl_totalR.setVisible(visible);
		lbl_asientosR.setVisible(visible);
		lbl_numSalaR.setVisible(visible);
		lbl_numAsiemtosR.setVisible(visible);
		lbl_numBoletasR.setVisible(visible);
		lbl_numTotalR.setVisible(visible);
		panel.setVisible(visible);
		btn_cancelar.setVisible(visible);
		btn_comprar.setVisible(visible);
		pn_resumen.setVisible(visible);
		lbl_tituloPeliculaR.setVisible(visible);
	}
	public void setAsientos() {
		for (Asiento asiento: salaPre) {
			salaAct[asiento.getFila()][asiento.getColumna()]=true;	
		}
	}
}