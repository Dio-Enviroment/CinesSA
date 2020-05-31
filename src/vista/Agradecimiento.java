package vista;

import javax.swing.JPanel;
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

	public Agradecimiento(int width,int height,ControladorSala ctrSala, ControladorView ctrView) {
		setLayout(null);
		setBounds(0, 0, width, height);
		pn_agradecimiento = new JPanel();
		pn_agradecimiento.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		pn_agradecimiento.setBounds(29, 29, 238, 76);
		add(pn_agradecimiento);
		GridBagLayout gbl_pn_agradecimiento = new GridBagLayout();
		gbl_pn_agradecimiento.columnWidths = new int[]{0, 254, 0, 0, 0, 0};
		gbl_pn_agradecimiento.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_pn_agradecimiento.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pn_agradecimiento.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pn_agradecimiento.setLayout(gbl_pn_agradecimiento);
		
		lblNewLabel = new JLabel("Gracias por su compra");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		pn_agradecimiento.add(lblNewLabel, gbc_lblNewLabel);
		
		lbl_nombreCliente = new JLabel("nombreCliente");
		lbl_nombreCliente.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lbl_nombreCliente = new GridBagConstraints();
		gbc_lbl_nombreCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_nombreCliente.gridx = 1;
		gbc_lbl_nombreCliente.gridy = 1;
		pn_agradecimiento.add(lbl_nombreCliente, gbc_lbl_nombreCliente);
		
		lbl_nombreCliente_1 = new JLabel("Disfrute su pel\u00EDcula");
		lbl_nombreCliente_1.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lbl_nombreCliente_1 = new GridBagConstraints();
		gbc_lbl_nombreCliente_1.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_nombreCliente_1.gridx = 1;
		gbc_lbl_nombreCliente_1.gridy = 2;
		pn_agradecimiento.add(lbl_nombreCliente_1, gbc_lbl_nombreCliente_1);

	}

	public void descargardata() {
		showcomponet(false);
	}

	public void cargardata() {
		showcomponet(true);
	}

	public void showcomponet(boolean visible){
		lbl_nombreCliente.setVisible(visible);
		pn_agradecimiento.setVisible(visible);
		lblNewLabel.setVisible(visible);
		lbl_nombreCliente_1.setVisible(visible);
	}
}
