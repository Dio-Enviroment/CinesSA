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
		
		
		lblNewLabel = new JLabel("Gracias por su compra");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		
		lbl_nombreCliente = new JLabel("nombreCliente");
		lbl_nombreCliente.setFont(new Font("Verdana", Font.BOLD, 14));
		
		
		lbl_nombreCliente_1 = new JLabel("Disfrute su pel\u00EDcula");
		lbl_nombreCliente_1.setFont(new Font("Verdana", Font.BOLD, 14));
		
	}

	public void descargardata() {
		showcomponet(false);
	}

	public void cargardata() {
<<<<<<< Upstream, based on origin/master
<<<<<<< Upstream, based on origin/master
<<<<<<< Upstream, based on origin/master
<<<<<<< Upstream, based on origin/master
=======
		//nombre
=======
		//sytout
>>>>>>> 727da41 pop
=======
		//sdfgdg
>>>>>>> 35093e6 jyjy
=======
		
>>>>>>> 7220f5f dedede
		lbl_nombreCliente_1.setText(ctrView.getNombre());
>>>>>>> 346821e nombreeee
		showcomponet(true);
	}

	public void showcomponet(boolean visible){
		lbl_nombreCliente.setVisible(visible);
		pn_agradecimiento.setVisible(visible);
		lblNewLabel.setVisible(visible);
		lbl_nombreCliente_1.setVisible(visible);
	}
}
