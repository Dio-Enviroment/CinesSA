package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JPanel;

import componentes.CustomButton;
import componentes.CustomPanel;
import componentes.Slider;
import controlador.ControladorProyeccion;
import controlador.ControladorView;

public class Cartelera extends CustomPanel {
	private CustomButton btn_comprar;
	private ControladorProyeccion ctrProyeccion;
	private ControladorView ctrView;
	private Slider slider;
	private JButton j;

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
		
		j=new JButton("sd");
		j.setBounds(10, 50, 50, 50);

		add(j);
		
		add(btn_comprar);
		add(slider);

		iniComponentEvents();
	}

	public void cargardata() {
		System.out.println("x");
	}

	public void descargadata() {}

	public void showcomponet(boolean visible){
		btn_comprar.setVisible(visible);
		slider.setVisible(visible);
		j.setVisible(visible);
	}


	public void iniComponentEvents() {
		btn_comprar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ctrProyeccion.setActProyeccion(slider.getPos());
				ctrView.changeBoleteria();
			}
		});

		j.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				slider.setPos(1);
				btn_comprar.repaint();
			}

		});
	}
}
