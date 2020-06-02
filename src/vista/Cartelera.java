package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JPanel;

import componentes.ChangePos;
import componentes.ChangePosListener;
import componentes.CustomButton;
import componentes.CustomPanel;
import componentes.Slide;
import controlador.ControladorProyeccion;
import controlador.ControladorView;
import java.awt.Graphics;

public class Cartelera extends CustomPanel {
	private CustomButton btn_comprar;
	private ControladorProyeccion ctrProyeccion;
	private ControladorView ctrView;
	private Slide slide;
	private JButton j;

	public Cartelera(int width, int height, ControladorProyeccion ctrProyeccion, ControladorView ctrView) {
		this.ctrProyeccion=ctrProyeccion;
		this.ctrView=ctrView;
		setLayout(null);
		setBounds(0, 0, width, height);

		btn_comprar = new CustomButton("Comprar");
		
		File workingDirectory = new File(System.getProperty("user.dir"));
		String[] paths = { 
			workingDirectory + "//src//img//peli_0_carteleta_back.png",
			workingDirectory + "//src//img//fondoPrueba2.png",
			workingDirectory + "//src//img//peli_0_carteleta_back.png", 
		};
		slide = new Slide(paths, 1008, 729);
		
		slide.setBounds(0, 0, 1008, 729);
		btn_comprar.setBounds(140, 603, 718, 40);

		j=new JButton("sd");
		j.setBounds(10, 50, 50, 50);

		add(j);
		
		slide.add(btn_comprar);
		add(slide);
		iniComponentEvents();
		showcomponet(false);
	}

	public void cargardata() {
		slide.setPos(0);
		slide.initTransition();
		showcomponet(true);
	}

	public void descargadata() {
		slide.endTransition();
		showcomponet(false);
	}

	public void showcomponet(boolean visible){
		slide.setVisible(visible);
		btn_comprar.setVisible(visible);
		j.setVisible(visible);
	}


	public void iniComponentEvents() {
		btn_comprar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ctrProyeccion.setActProyeccion(slide.getPos());
				ctrView.changeBoleteria();
			}
		});

		j.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				slide.setPos(1);
				btn_comprar.repaint();
			}

		});

		slide.addChangePos(new ChangePosListener(){
			@Override
			public void ChangePosEvent(ChangePos evt) {
				ctrProyeccion.setActProyeccion(slide.getPos());
			}
		});
	}
}
