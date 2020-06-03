package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;

import componentes.ChangePos;
import componentes.ChangePosListener;
import componentes.CustomButton;
import componentes.CustomPanel;
import componentes.Slide;
import controlador.ControladorProyeccion;
import controlador.ControladorView;
import modelo.Proyeccion;


public class Cartelera extends CustomPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private CustomButton btn_comprar;
	private ControladorProyeccion ctrProyeccion;
	private ControladorView ctrView;
	private Slide slide;
	private JButton j;

	public Cartelera(int width, int height, ControladorProyeccion ctrProyeccion, ControladorView ctrView) {
		this.ctrProyeccion=ctrProyeccion;
		this.ctrView=ctrView;
		int cont=0;
		setLayout(null);
		setBounds(0, 0, width, height);
		
		btn_comprar = new CustomButton("Comprar");
		

		String[] paths=new String[ctrProyeccion.getProyeccions().size()]; 
		for (Proyeccion proyeccion : ctrProyeccion.getProyeccions()) {
			paths[cont]=proyeccion.getCarteleraBack();
			cont++;
		}
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
