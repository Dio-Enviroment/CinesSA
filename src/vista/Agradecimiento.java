package vista;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import componentes.CustomPanel;
import componentes.ImageAdaptable;
import controlador.ControladorBoleto;
import controlador.ControladorSala;
import controlador.ControladorView;
import modelo.Cliente;


public class Agradecimiento extends CustomPanel {
	private static final long serialVersionUID = 1L;
	public JLabel lbl_nombreCliente;
	public JPanel pn_agradecimiento;
	public JLabel lblNewLabel;
	public JLabel lbl_nombreCliente_1;
	private ControladorView ctrView;
	private JTextArea texto;
	private Timer timer = new Timer();
	private TimerTask task;
	private Cliente cliente;
	private ControladorBoleto ctrBoleto;
	
	public Agradecimiento(int width,int height,ControladorSala ctrSala, ControladorBoleto ctrBoleto, ControladorView ctrView) {
		setLayout(null);
		setBounds(0, 0, width, height);
		this.ctrView=ctrView;
		this.ctrBoleto= ctrBoleto;

		File workingDirectory = new File(System.getProperty("user.dir"));
		String[] paths = { workingDirectory + "//src//resources//agradecimiento.png"};

		ImageAdaptable img=new ImageAdaptable(paths[0]);
		pn_agradecimiento = new JPanel();
		pn_agradecimiento.setBounds(200, 230,800,200);
		add(pn_agradecimiento);
		texto = new JTextArea();
		texto.setBounds(0, 0, 800, 20);
		texto.setEditable(false);  
		texto.setCursor(null);  
		texto.setOpaque(false);  
		texto.setFocusable(false);
		texto.setLineWrap(true);
		texto.setWrapStyleWord(true);
		pn_agradecimiento.setBackground(new Color(121,119,119,255));
		pn_agradecimiento.add(texto);
		texto.setFont(new Font("Verdana", Font.PLAIN, 40));
		add(img);
	}
	
	
	public void descargardata() {
		showcomponet(false);
	}
	
	
	public void cargardata() {
		
		texto.setText("GRACIAS POR SU COMPRA \n" 
				+"         "+ctrView.getCliente() +" \n" 
				+ "DISFRUTE DE SU PELICULA");
		showcomponet(true);
		this.initTransition();
	}
	

	public void showcomponet(boolean visible){
	
		texto.setVisible(visible);
		pn_agradecimiento.setVisible(visible);	
	}
	public void initTransition() {
		//
		task=null;
		task=new TimerTask() {

			@Override
			public void run() {
				ctrView.setActivador4(false);
				cliente= ctrBoleto.getCliente();
				cliente.setCedula("");
				cliente.setNombre("");
				cliente.setTelefono("");
				cliente.setDireccion("");
				ctrView.changeCartelera();
				
			}
			
		};
		timer.schedule(task, 2000);
	}
}
