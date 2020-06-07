package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import componentes.ChangePos;
import componentes.ChangePosListener;
import componentes.CustomButton;
import componentes.CustomPanel;
import componentes.ImageAdaptable;
import componentes.Slide;
import controlador.ControladorProyeccion;
import controlador.ControladorView;
import modelo.Proyeccion;


public class Cartelera extends CustomPanel {

	private static final long serialVersionUID = 1L;
	private CustomButton btn_comprar;
	private ControladorProyeccion ctrProyeccion;
	private ControladorView ctrView;
	private Slide slide;

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
		slide = new Slide(paths, width, height);
		
		slide.setBounds(0, 0, width, height);
		btn_comprar.setBounds(140, 603, 718, 40);

		File workingDirectory = new File(System.getProperty("user.dir"));

		ImageAdaptable logo=new ImageAdaptable(workingDirectory + "//src//resources//logo.png");
		logo.setLocation(12, 12);	

		slide.add(btn_comprar);
		slide.add(logo);
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
	}


	public void iniComponentEvents() {
		btn_comprar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ctrProyeccion.setActProyeccion(slide.getPos());
				ctrView.changeBoleteria();
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
