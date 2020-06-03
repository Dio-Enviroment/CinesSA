package vista;

import java.awt.Color;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JPanel;

import componentes.CustomPanel;
import componentes.ImageAdaptable;
import componentes.TransparentPanel;
import controlador.ControladorProyeccion;
import controlador.ControladorView;
import modelo.Proyeccion;

public class DetallePelicula extends CustomPanel {
	private TransparentPanel back1;
	private ImageAdaptable back0;
	private ControladorProyeccion ctrProyeccion; 
	private ControladorView ctrView;
	private Proyeccion proyeccion;
	private JButton j;

	public DetallePelicula(int width,int height,ControladorProyeccion ctrProyeccion, ControladorView ctrView) {
		setLayout(null);
		this.ctrProyeccion=ctrProyeccion;
		this.ctrView=ctrView;
		setBounds(0, 0, width, height);
		setBackground(Color.RED);
		File workingDirectory = new File(System.getProperty("user.dir"));
		String[] rawback={
			workingDirectory+"//src//img//boleteria//pelicula//peli_0//back.png"
		};

		String[] rawitem={
			workingDirectory+"//src//img//boleteria//conferecia//confe_0//back.png"
		};

		j=new JButton();
		j.setBounds(0, 0, 100, 100);
		add(j);

		back1=new TransparentPanel();
		back1.setBounds(0, 0, width, height);
		add(back1);
		

		back0 = new ImageAdaptable(rawback[0]);
		back0.setLocation(0, 0);
		add(back0);
		
		showcomponet(false);
		this.setVisible(false);
	}

	public void descargardata() {
		showcomponet(false);
	}

	public void cargardata() {
		proyeccion=ctrProyeccion.getActProyeccion();
		back0.setImage(proyeccion.getBoleteriaBack());
		showcomponet(true);
	}

	public void showcomponet(boolean visible) {
		j.setVisible(visible);
		back0.setVisible(visible);
		back1.setVisible(visible);
	}

}
