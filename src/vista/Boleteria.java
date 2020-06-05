package vista;

import java.io.File;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import componentes.CustomButton;
import componentes.CustomPanel;
import componentes.ImageAdaptable;
import componentes.TransparentPanel;
import controlador.ControladorProyeccion;
import controlador.ControladorSala;
import controlador.ControladorView;
import modelo.Conferencia;
import modelo.Pelicula;
import modelo.Proyeccion;
import modelo.Sala;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import java.awt.Color;

public class Boleteria extends CustomPanel {

	private static final long serialVersionUID = 1L;
	private ControladorProyeccion ctrProyeccion;
	private ControladorView ctrView;
	private ControladorSala ctrSala;
	private ImageAdaptable back, front;
	private TransparentPanel formulary;
	private CustomButton title, compra,cartelera;
	private JLabel lb1, lb2;
	private JComboBox horario;
	private Proyeccion proyeccion;
	private DefaultComboBoxModel horarios = new DefaultComboBoxModel();

	public Boleteria(int width, int height, ControladorProyeccion ctrProyeccion,ControladorSala ctrSala, ControladorView ctrView) {
		this.ctrProyeccion = ctrProyeccion;
		this.ctrView = ctrView;
		this.ctrSala=ctrSala;
		setBounds(0, 0, width, height);

		File workingDirectory = new File(System.getProperty("user.dir"));
		setLayout(null);

		back = new ImageAdaptable(workingDirectory + "//src//img//boleteria//pelicula//peli_0//back.png");
		back.setLocation(0, 0);

		front = new ImageAdaptable(workingDirectory + "//src//img//boleteria//pelicula//peli_0//front.png");
		front.setLocation(0, 0);

		int formularyWidth = 354;

		formulary = new TransparentPanel();
		formulary.setBounds(width - formularyWidth, 0, formularyWidth, height);

		Object[] titleS = { workingDirectory + "//src//img//boleteria//pelicula//peli_0//titulo.png" };
		title = new CustomButton(titleS, 1);
		title.setVisible(false);
		title.setBounds(10, 215, formularyWidth - 20, 78);
		cartelera = new CustomButton("Ver Cartelera");
		cartelera.setBounds(45, 380, formularyWidth - 90, 60);
		cartelera.setVisible(false);

		compra = new CustomButton("Comprar");
		compra.setBounds(45, 450, formularyWidth - 90, 60);
		compra.setVisible(false);

		lb1 = new JLabel("Precione el logo para ver detalles:");
		lb1.setFont(lb1.getFont().deriveFont(20.0f));
		lb1.setForeground(Color.WHITE);
		lb1.setBounds(10, 160, formularyWidth - 10, 60);
		lb2 = new JLabel("Horario:");
		lb2.setFont(lb1.getFont().deriveFont(20.0f));
		lb2.setForeground(Color.WHITE);
		lb2.setBounds(47, 300, formularyWidth - 20, 60);
		
		horario = new JComboBox(horarios);
		horario.setBounds(135, 310, formularyWidth - 170, 40);
		//horario.setEditable(false);
		formulary.add(title);
		formulary.add(lb2);
		formulary.add(horario);
		formulary.add(lb1);
		formulary.add(cartelera);
		formulary.add(compra);

		add(front);
		add(formulary);
		add(back);
		iniComponentEvents();
		showcomponet(false);
	}

	public void cargardata() {
		proyeccion = ctrProyeccion.getActProyeccion();
		

		back.setImage(proyeccion.getBoleteriaBack());
		front.setImage(proyeccion.getBoleteriaFront());
		title.setImg(proyeccion.getBoleteriaTitle());
		horarios.addElement("Seleccione una opcion");

		for (String hora : proyeccion.getHorario()) {
			horarios.addElement(hora);
		}

		if(!(proyeccion instanceof Pelicula) || horario.getSelectedIndex()!=0){
			compra.setEnabled(false);
		}
		if(proyeccion instanceof Conferencia){
			horario.setSelectedIndex(1);
			horario.setEnabled(false);
		}
		else{
			horario.setEnabled(true);
		}
		// if (proyeccion.getHorario().length!=1 || horario.getSelectedIndex()!=0) {
		// 	compra.setEnabled(false);
		// }
		// else{
		// 	horario.setSelectedIndex(1);
		// 	horario.setEnabled(false);
		// }

		
		showcomponet(true);
	}

	public void descargadata() {
		horarios.removeAllElements();
		showcomponet(false);
	}

	public void showcomponet(boolean visible) {
		back.setVisible(visible);
		front.setVisible(visible);
		formulary.setVisible(visible);
		title.setVisible(visible);
		cartelera.setVisible(visible);
		compra.setVisible(visible);
		horario.setVisible(visible);
	}

	public void iniComponentEvents() {
		compra.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(proyeccion instanceof Pelicula){
					Pelicula pelicula=(Pelicula)proyeccion;
					ArrayList<Sala> salas=pelicula.getSalas();
					
					ctrSala.setSala(salas.get(horario.getSelectedIndex()-1));
					proyeccion.setTipoEvent("Pelicula");
				}
				else{
					Conferencia conferencia=(Conferencia)proyeccion;
					ctrSala.setSala(conferencia.getSala());
					proyeccion.setTipoEvent("Conferencia");
				}
				
				if (horario.getSelectedIndex()!=0) {
					proyeccion.setHora((String)horario.getSelectedItem());
				}
				ctrView.changeCompraPrincipal();
			}
		});


		cartelera.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ctrProyeccion.setPreproyeccion(proyeccion);
				if (ctrProyeccion.getActProyeccion() instanceof Pelicula){
					ctrView.setIsPelicula(true);
				}
				else{
					ctrView.setIsPelicula(false);
				}
				ctrView.changeSelectPelicula();
			}
		});

		title.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ctrProyeccion.setPreproyeccion(proyeccion);
				ctrView.changeDetallePelicula();
			}
		});

		horario.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {


				if(horario.getSelectedIndex()!=0){
					compra.setEnabled(true);
				}
				else{
					compra.setEnabled(false);
				}

				if(horarios.getSize()!=0 && horario.getSelectedIndex()!=0){
					if(proyeccion instanceof Pelicula){
						Pelicula p=(Pelicula)proyeccion;
						ArrayList<Sala> ss= p.getSalas();
						Sala sz= ss.get(horario.getSelectedIndex()-1);
						if(sz.verificarNumAsiento()==0){
							compra.setText("Agotado");
							compra.setEnabled(false);
						}
						else{
							compra.setText("Comprar");
						}
					}
					else{
						Conferencia c=(Conferencia)proyeccion;
						Sala s= c.getSala();
						if(s.verificarNumAsiento()==0){
							compra.setText("Agotado");
							compra.setEnabled(false);
						}
						else{
							compra.setText("Comprar");
						}
					}
				}
				else{
					compra.setText("Comprar");
				}
			}
		});
	}
}
