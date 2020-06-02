package vista;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.border.LineBorder;

import componentes.CustomPanel;
import controlador.ControladorBoleto;
import controlador.ControladorSala;
import controlador.ControladorView;

import java.awt.Color;

public class Agradecimiento extends CustomPanel {
	public JLabel lbl_nombreCliente;
	public JPanel pn_agradecimiento;
	public JLabel lblNewLabel;
	public JLabel lbl_nombreCliente_1;
	private ControladorView ctrView;
	private JTextArea texto;
	public Agradecimiento(int width,int height,ControladorSala ctrSala, ControladorView ctrView) {
		setLayout(null);
		setBounds(0, 0, width, height);
		this.ctrView=ctrView;
		pn_agradecimiento = new JPanel();
		pn_agradecimiento.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		pn_agradecimiento.setBounds(29, 29, 238, 76);
		add(pn_agradecimiento);
		texto = new JTextArea();
		texto.setBounds(0, 0, 238, 76);
		texto.setEditable(false);  
		texto.setCursor(null);  
		texto.setOpaque(false);  
		texto.setFocusable(false);
		texto.setLineWrap(true);
		texto.setWrapStyleWord(true);
		pn_agradecimiento.add(texto);
		
		
		
	}

	public void descargardata() {
		showcomponet(false);
	}

	public void cargardata() {
		
		texto.setText("              GRACIAS POR SU COMPRA \n" 
				+"                     "+ctrView.getCliente() +" \n" 
				+ "            DISFRUTE DE SU PELICULA");
		showcomponet(true);
	}

	public void showcomponet(boolean visible){
	
		texto.setVisible(visible);
		pn_agradecimiento.setVisible(visible);	
	}
}
