package vista;

import java.io.File;

import javax.swing.JPanel;

import componentes.CustomPanel;
import componentes.ImageAdaptable;
import componentes.TransparentPanel;
import controlador.ControladorProyeccion;
import controlador.ControladorView;

public class DetallePelicula extends CustomPanel {

	public DetallePelicula(int width,int height,ControladorProyeccion ctrProyeccion, ControladorView ctrView) {
		setLayout(null);
		setBounds(0, 0, width, height);
		File workingDirectory = new File(System.getProperty("user.dir"));
		String[] rawback={
			workingDirectory+"//src//img//peli2.png"
		};

		String[] rawitem={
			workingDirectory+"//src//img//item0.png"
		};


		TransparentPanel back1=new TransparentPanel();
		back1.setBounds(0, 0, width, height);
		add(back1);
		

		ImageAdaptable back0 = new ImageAdaptable(rawback[0]);
		back0.setLocation(0, 0);
		add(back0);
	}

}
