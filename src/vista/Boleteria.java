package vista;

import java.io.File;

import javax.swing.JLabel;
import javax.swing.JPanel;

import componentes.CustomButton;
import componentes.ImageAdaptable;
import componentes.TransparentPanel;
import controlador.ControladorProyeccion;
import controlador.ControladorView;
import java.awt.Graphics;
import java.awt.Component;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Boleteria extends JPanel{
	private ControladorProyeccion ctrProyeccion;
	private ControladorView ctrView;

	public Boleteria(int width,int height,ControladorProyeccion ctrProyeccion, ControladorView ctrView) {
		this.ctrProyeccion=ctrProyeccion;
		this.ctrView=ctrView;
		//String[] back0,String[] back1, String[] title ,
		File workingDirectory = new File(System.getProperty("user.dir"));
		String[] rawback={
			workingDirectory+"//src//img//peli_0_boleteria_back.png"
		};

		String[] rawfront={
			workingDirectory+"//src//img//peli_0_boleteria_front.png"
		};

		String[] rawtitle={
			workingDirectory+"//src//img//peli_0_boleteria_titulo.png"
		};
		setLayout(null);
		
		ImageAdaptable back = new ImageAdaptable(rawback[0]);
		back.setLocation(0, 0);

		ImageAdaptable front = new ImageAdaptable(rawfront[0]);
		front.setLocation(0, 0);

		int formularyWidth=354;
		Component[] sendComponets={front};
		TransparentPanel formulary=new TransparentPanel();
		formulary.setBounds(width-formularyWidth, 0, formularyWidth, height);
		
		Object titleS=rawtitle[0];
		CustomButton title=new CustomButton(titleS);
		title.setBounds(10, 100, formularyWidth-20, 60);
		CustomButton title2=new CustomButton("titleS");
		title2.setBounds(10, 450, formularyWidth-50, 60);

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
		
	}
}
