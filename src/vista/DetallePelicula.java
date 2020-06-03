package vista;

import java.awt.Color;
import java.awt.Font;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import componentes.CustomButton;
import componentes.CustomPanel;
import componentes.ImageAdaptable;
import componentes.TransparentPanel;
import controlador.ControladorProyeccion;
import controlador.ControladorView;
import modelo.Conferencia;
import modelo.Pelicula;
import modelo.Proyeccion;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;

public class DetallePelicula extends CustomPanel {
	private TransparentPanel back1;
	private ImageAdaptable back0, img;
	private ControladorProyeccion ctrProyeccion;
	private ControladorView ctrView;
	private Proyeccion proyeccion,actProyeccion;
	private JLabel title, l2, l5, l3, l4;
	private JPanel datos;
	private JLabel l1;
	private JTextPane sinopsis;
	private JTextPane generos;
	private JTextPane salaTipo;
	private JTextPane censura;
	private JTextPane horarios;
	private JButton j;
	private JPanel panel;
	private CustomButton salir;
	private CustomButton continuar;
	private CustomButton selecionar;

	public DetallePelicula(int width, int height, ControladorProyeccion ctrProyeccion, ControladorView ctrView) {
		setLayout(null);
		this.ctrProyeccion = ctrProyeccion;
		this.ctrView = ctrView;
		setBounds(0, 0, width, height);
		setBackground(Color.RED);
		File workingDirectory = new File(System.getProperty("user.dir"));
		String[] rawback = { workingDirectory + "//src//img//detalle//pelicula//peli_0//max.png" };

		String[] rawitem = { workingDirectory + "//src//img//boleteria//conferecia//confe_0//back.png" };

		datos = new JPanel();
		datos.setBounds(497, 99, 458, 510);
		datos.setBackground(new Color(37, 36, 37, 255));
		GridBagLayout gbl_datos = new GridBagLayout();
		gbl_datos.columnWidths = new int[] { 120, 276 };
		gbl_datos.rowHeights = new int[] { 25, 32, 0, 0, 0, 0, 0, 0 };
		gbl_datos.columnWeights = new double[] { 1.0, 1.0 };
		gbl_datos.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		datos.setLayout(gbl_datos);

		title = new JLabel("  IROM MAN 3");
		title.setFont(new Font("Tahoma", Font.PLAIN, 20));
		title.setLocation(0, 12);
		// title.setBounds(0, 10, 50, 115);
		title.setForeground(Color.white);
		GridBagConstraints gbc_title = new GridBagConstraints();
		gbc_title.gridwidth = 2;
		gbc_title.anchor = GridBagConstraints.NORTHWEST;
		gbc_title.insets = new Insets(0, 0, 5, 0);
		gbc_title.gridx = 0;
		gbc_title.gridy = 0;
		datos.add(title, gbc_title);

		l1 = new JLabel("  SINOPSIS:");
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_l1 = new GridBagConstraints();
		gbc_l1.anchor = GridBagConstraints.NORTHWEST;
		gbc_l1.insets = new Insets(0, 0, 5, 5);
		gbc_l1.gridx = 0;
		gbc_l1.gridy = 1;
		datos.add(l1, gbc_l1);

		sinopsis = new JTextPane();
		sinopsis.setFont(new Font("Tahoma", Font.PLAIN, 20));
		sinopsis.setForeground(Color.WHITE);
		sinopsis.setText("asdas qweq  qweqw qwe  asdasda dvfvfd sdwqq qweqw asdasz zxczx  asdas  qweq como sera");
		sinopsis.setBackground(new Color(37, 36, 37, 255));
		GridBagConstraints gbc_sinopsis = new GridBagConstraints();
		gbc_sinopsis.anchor = GridBagConstraints.NORTH;
		gbc_sinopsis.insets = new Insets(0, 0, 5, 0);
		gbc_sinopsis.fill = GridBagConstraints.HORIZONTAL;
		gbc_sinopsis.gridx = 1;
		gbc_sinopsis.gridy = 1;
		datos.add(sinopsis, gbc_sinopsis);

		l2 = new JLabel("  GENEROS:");
		l2.setBounds(0, 10, 50, 50);
		l2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		l2.setForeground(Color.white);
		GridBagConstraints gbc_l2 = new GridBagConstraints();
		gbc_l2.anchor = GridBagConstraints.NORTHWEST;
		gbc_l2.insets = new Insets(0, 0, 5, 5);
		gbc_l2.gridx = 0;
		gbc_l2.gridy = 2;
		datos.add(l2, gbc_l2);

		generos = new JTextPane();
		generos.setText("123");
		generos.setForeground(Color.WHITE);
		generos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		generos.setBackground(new Color(37, 36, 37));
		GridBagConstraints gbc_generos = new GridBagConstraints();
		gbc_generos.insets = new Insets(0, 0, 5, 0);
		gbc_generos.fill = GridBagConstraints.BOTH;
		gbc_generos.gridx = 1;
		gbc_generos.gridy = 2;
		datos.add(generos, gbc_generos);

		l3 = new JLabel("  DISPONIBILIDAD:");
		l3.setBounds(0, 10, 50, 50);
		l3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		l3.setForeground(Color.white);
		GridBagConstraints gbc_l3 = new GridBagConstraints();
		gbc_l3.anchor = GridBagConstraints.NORTHWEST;
		gbc_l3.insets = new Insets(0, 0, 5, 5);
		gbc_l3.gridx = 0;
		gbc_l3.gridy = 3;
		datos.add(l3, gbc_l3);

		salaTipo = new JTextPane();
		salaTipo.setText("123");
		salaTipo.setForeground(Color.WHITE);
		salaTipo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		salaTipo.setBackground(new Color(37, 36, 37));
		GridBagConstraints gbc_salaTipo = new GridBagConstraints();
		gbc_salaTipo.insets = new Insets(0, 0, 5, 0);
		gbc_salaTipo.fill = GridBagConstraints.BOTH;
		gbc_salaTipo.gridx = 1;
		gbc_salaTipo.gridy = 3;
		datos.add(salaTipo, gbc_salaTipo);

		l4 = new JLabel("  CENSURA:");
		l4.setBounds(0, 10, 50, 50);
		l4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		l4.setForeground(Color.white);
		GridBagConstraints gbc_l4 = new GridBagConstraints();
		gbc_l4.insets = new Insets(0, 0, 5, 5);
		gbc_l4.anchor = GridBagConstraints.NORTHWEST;
		gbc_l4.gridx = 0;
		gbc_l4.gridy = 4;
		datos.add(l4, gbc_l4);

		censura = new JTextPane();
		censura.setText("123");
		censura.setForeground(Color.WHITE);
		censura.setFont(new Font("Tahoma", Font.PLAIN, 20));
		censura.setBackground(new Color(37, 36, 37));
		GridBagConstraints gbc_censura = new GridBagConstraints();
		gbc_censura.insets = new Insets(0, 0, 5, 0);
		gbc_censura.fill = GridBagConstraints.BOTH;
		gbc_censura.gridx = 1;
		gbc_censura.gridy = 4;
		datos.add(censura, gbc_censura);

		l5 = new JLabel("  HORARIOS:");
		l5.setBounds(0, 10, 50, 50);
		l5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		l5.setForeground(Color.white);
		GridBagConstraints gbc_l5 = new GridBagConstraints();
		gbc_l5.anchor = GridBagConstraints.NORTHWEST;
		gbc_l5.insets = new Insets(0, 0, 5, 5);
		gbc_l5.gridx = 0;
		gbc_l5.gridy = 5;
		datos.add(l5, gbc_l5);

		horarios = new JTextPane();
		horarios.setText("123");
		horarios.setForeground(Color.WHITE);
		horarios.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horarios.setBackground(new Color(37, 36, 37));
		GridBagConstraints gbc_horarios = new GridBagConstraints();
		gbc_horarios.insets = new Insets(0, 0, 5, 0);
		gbc_horarios.fill = GridBagConstraints.BOTH;
		gbc_horarios.gridx = 1;
		gbc_horarios.gridy = 5;
		datos.add(horarios, gbc_horarios);

		sinopsis.setEditable(false);
		generos.setEditable(false);
		salaTipo.setEditable(false);
		censura.setEditable(false);
		horarios.setEditable(false);

		panel = new JPanel();
		panel.setBackground(new Color(37, 36, 37, 255));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.SOUTHEAST;
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 6;
		datos.add(panel, gbc_panel);

		add(datos);

		salir = new CustomButton("Salir");
		panel.add(salir);

		continuar = new CustomButton("Continuar viendo");
		panel.add(continuar);

		selecionar = new CustomButton("Seleccionar");
		panel.add(selecionar);

		img = new ImageAdaptable(rawback[0]);
		img.setLocation(54, 95);
		add(img);

		back1 = new TransparentPanel();
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
		String hora="";
		String[] horas;
		actProyeccion= ctrProyeccion.getActProyeccion();
		proyeccion = ctrProyeccion.getPreproyeccion();
		back0.setImage(actProyeccion.getBoleteriaBack());
		img.setImage(actProyeccion.getMax());
		title.setText(proyeccion.getTitulo());
		if(proyeccion instanceof Pelicula){
			Pelicula pel=(Pelicula)proyeccion;
			l1.setText("  SINOPSIS:");
			l2.setText("  GENEROS:");
			l3.setText("  DISPONIBILIDAD:");
			l4.setText("  CENSURA:");
			l5.setText("  HORARIOS:");
			sinopsis.setText(pel.getSinapsis());
			generos.setText(pel.getGenero());
			salaTipo.setText(pel.getSalaTipo());
			censura.setText(pel.getEdad()+"");
			horas= pel.getHorario();
			for (int i = 0; i < horas.length; i++) {
				hora+=horas[i];
				if(i<horas.length-1){
					hora+=" - ";
				}
			}
			
			horarios.setText(hora);
		}
		else{
			Conferencia con=(Conferencia)proyeccion;
			l1.setText("  Tematica:");
			l2.setText("  Presentador:");
			sinopsis.setText(con.getTematica());
			generos.setText(con.getPresentador());
		}
		
		showcomponet(true);
	}

	public void showcomponet(boolean visible) {
		back1.setVisible(visible);
		back0.setVisible(visible);
		img.setVisible(visible);
		title.setVisible(visible);
		
		if(proyeccion instanceof Pelicula){
			l1.setVisible(visible);
			l2.setVisible(visible);
			l3.setVisible(visible);
			l4.setVisible(visible);
			l5.setVisible(visible);
			sinopsis.setVisible(visible);
			generos.setVisible(visible);
			salaTipo.setVisible(visible);
			censura.setVisible(visible);
			horarios.setVisible(visible);
		}
		else{
			l1.setVisible(visible);
			l2.setVisible(visible);
			l3.setVisible(false);
			l4.setVisible(false);
			l5.setVisible(false);
			sinopsis.setVisible(visible);
			generos.setVisible(visible);
			salaTipo.setVisible(false);
			censura.setVisible(false);
			horarios.setVisible(false);
		}
		
		datos.setVisible(visible);
		panel.setVisible(visible);
		salir.setVisible(visible);
		continuar.setVisible(visible);
		selecionar.setVisible(visible);
	}

}
