package vista;

import java.io.File;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import componentes.CustomButton;
import componentes.CustomPanel;
import componentes.ImageAdaptable;
import componentes.TransparentPanel;
import controlador.ControladorProyeccion;
import controlador.ControladorView;
import modelo.Proyeccion;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Boleteria extends CustomPanel {
	private ControladorProyeccion ctrProyeccion;
	private ControladorView ctrView;
	private ImageAdaptable back,front;
	private TransparentPanel formulary;
	private CustomButton title,compra;
	private JLabel lb1,lb2;
	private JComboBox tipo,horario;
	private Proyeccion proyeccion;

	public Boleteria(int width, int height, ControladorProyeccion ctrProyeccion, ControladorView ctrView) {
		this.ctrProyeccion = ctrProyeccion;
		this.ctrView = ctrView;
		setBounds(0, 0, width, height);
		// String[] back0,String[] back1, String[] title ,
		File workingDirectory = new File(System.getProperty("user.dir"));
		String[] rawback = { workingDirectory + "//src//img//peli_0_boleteria_back.png" };

		String[] rawfront = { workingDirectory + "//src//img//peli_0_boleteria_front.png" };

		String[] rawtitle = { workingDirectory + "//src//img//peli_0_boleteria_titulo.png" };
		setLayout(null);

		back = new ImageAdaptable(rawback[0]);
		back.setLocation(0, 0);

		front = new ImageAdaptable(rawfront[0]);
		front.setLocation(0, 0);

		int formularyWidth = 354;

		formulary = new TransparentPanel();
		formulary.setBounds(width - formularyWidth, 0, formularyWidth, height);

		Object[] titleS ={ rawtitle[0]};
		title = new CustomButton(titleS,1);
		title.setVisible(false);
		title.setBounds(10, 150, formularyWidth - 20, 78);
		compra = new CustomButton("Comprar");
		compra.setBounds(45, 450, formularyWidth - 90, 60);
		compra.setVisible(false);
		compra.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ctrView.changeCompraPrincipal();
			}
			
		});

		lb1=new JLabel("Tipo:");
		lb1.setFont (lb1.getFont ().deriveFont (20.0f));
		lb1.setForeground(Color.WHITE);
		lb1.setBounds(75, 240, formularyWidth-20, 60);
		lb2=new JLabel("Horario:");
		lb2.setFont (lb1.getFont ().deriveFont (20.0f));
		lb2.setForeground(Color.WHITE);
		lb2.setBounds(47, 300, formularyWidth-20, 60);
		tipo=new JComboBox<>();
		tipo.setBounds(135, 250, formularyWidth-170, 40);
		horario=new JComboBox<>();
		horario.setBounds(135, 310, formularyWidth-170, 40);

		formulary.add(title);
		formulary.add(lb2);
		formulary.add(tipo);
		formulary.add(horario);
		formulary.add(lb1);
		formulary.add(compra);
	
		add(front);
		add(formulary);
		add(back);
		showcomponet(false);
	}

	

	public void cargardata() {
		File workingDirectory = new File(System.getProperty("user.dir"));
		String[] rawback = { workingDirectory + "//src//img//peli_0_boleteria_back.png" };

		String[] rawfront = { workingDirectory + "//src//img//peli_0_boleteria_front.png" };

		String[] rawtitle = { workingDirectory + "//src//img//peli_0_boleteria_titulo.png" };

		proyeccion=ctrProyeccion.getActProyeccion();
		back.setImage(rawback[0]);
		front.setImage(rawfront[0]);
		showcomponet(true);
	}

	public void descargadata() {
		showcomponet(false);
	}

	public void showcomponet(boolean visible){
		back.setVisible(visible);
		front.setVisible(visible);
		formulary.setVisible(visible);
		title.setVisible(visible);
		compra.setVisible(visible);
		tipo.setVisible(visible);
		horario.setVisible(visible);;
	}
}
