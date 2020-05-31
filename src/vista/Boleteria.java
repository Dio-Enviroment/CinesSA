package vista;

import java.io.File;

import javax.swing.JLabel;
import javax.swing.JPanel;

import componentes.CustomButton;
import componentes.CustomPanel;
import componentes.ImageAdaptable;
import componentes.TransparentPanel;
import controlador.ControladorProyeccion;
import controlador.ControladorView;
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
	private CustomButton title,title2;

	public Boleteria(int width, int height, ControladorProyeccion ctrProyeccion, ControladorView ctrView) {
		this.ctrProyeccion = ctrProyeccion;
		this.ctrView = ctrView;
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

		Object titleS = rawtitle[0];
		title = new CustomButton(titleS);
		title.setBounds(10, 100, formularyWidth - 20, 60);
		title2 = new CustomButton("titleS");
		title2.setBounds(10, 450, formularyWidth - 50, 60);
		title2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ctrView.changeCompraPrincipal();
				//ctrView.changeCartelera();
			}
			
		});

		JLabel lb1=new JLabel("Tipo");
		lb1.setForeground(Color.WHITE);
		lb1.setBounds(10, 250, formularyWidth-20, 60);
		JLabel lb2=new JLabel("Horario");
		lb2.setForeground(Color.WHITE);
		lb2.setBounds(10, 270, formularyWidth-20, 60);
		
		formulary.add(title);
		formulary.add(title2);
		formulary.add(lb2);
		formulary.add(lb1);
		
		add(front);
		add(formulary);
		add(back);
		//ss
		
	}

	public void cargardata() {}

	public void descargadata() {}

	public void showcomponet(boolean visible){
		back.setVisible(visible);
		front.setVisible(visible);
		formulary.setVisible(visible);
		title.setVisible(visible);
		title2.setVisible(visible);
	}
}
