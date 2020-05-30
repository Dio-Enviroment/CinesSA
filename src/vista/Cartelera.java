package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JPanel;

import componentes.CustomButton;
import componentes.Slider;
import controlador.ControladorProyeccion;
import controlador.ControladorView;

public class Cartelera extends JPanel {
	CustomButton btn_comprar;
	ControladorProyeccion ctrProyeccion;
	ControladorView ctrView;
	Slider slider;

	public Cartelera(int width, int height, ControladorProyeccion ctrProyeccion, ControladorView ctrView) {
		this.ctrProyeccion=ctrProyeccion;
		this.ctrView=ctrView;
		setLayout(null);

		btn_comprar = new CustomButton("Comprar");
		
		File workingDirectory = new File(System.getProperty("user.dir"));
		String[] paths = { workingDirectory + "//src//img//peli_0_carteleta_back.png",
		workingDirectory + "//src//img//fondoPrueba2.png" };
		slider = new Slider(paths, 1008, 729);
		
		slider.setBounds(0, 0, 1008, 729);
		btn_comprar.setBounds(140, 603, 718, 40);
		
		JButton j=new JButton("sd");
		j.setBounds(10, 50, 50, 50);
		j.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				slider.setPos(1);
				btn_comprar.repaint();
			}

		});

		add(j);
		
		add(btn_comprar);
		add(slider);

		iniComponentEvents();
	}

	public void iniComponentEvents() {
		btn_comprar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ctrProyeccion.setActProyeccion(slider.getPos());
				ctrView.changeBoleteria();
			}
		});
	}
}
