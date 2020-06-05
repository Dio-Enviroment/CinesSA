package vista;

import java.io.File;
import java.util.ArrayList;

import componentes.CustomButton;
import componentes.CustomPanel;
import componentes.ImageAdaptable;
import componentes.TransparentPanel;
import controlador.ControladorProyeccion;
import controlador.ControladorView;
import modelo.Pelicula;
import modelo.Proyeccion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectPelicula extends CustomPanel {
	private TransparentPanel back1;
	private ImageAdaptable back0;
	private SelectItem[] selectItem;
	private CustomButton regresar, ver;
	private ControladorProyeccion ctrProyeccion;
	private ControladorView ctrView;
	private Proyeccion proyeccion;
	private ArrayList<Proyeccion> proyecciones;
	private boolean isPelicula;

	public SelectPelicula(int width, int height, ControladorProyeccion ctrProyeccion, ControladorView ctrView) {
		this.ctrProyeccion = ctrProyeccion;
		this.ctrView = ctrView;
		setLayout(null);
		setBounds(0, 0, width, height);
		File workingDirectory = new File(System.getProperty("user.dir"));
		String[] rawback = { workingDirectory + "//src//img//boleteria//pelicula//peli_0//back.png" };

		String[] rawitem = { workingDirectory + "//src//img//detalle//pelicula//peli_0//min.png",
				workingDirectory + "//src//img//detalle//pelicula//peli_1//min.png",
				workingDirectory + "//src//img//detalle//pelicula//peli_2//min.png",
				workingDirectory + "//src//img//detalle//pelicula//peli_3//min.png",
				workingDirectory + "//src//img//detalle//pelicula//peli_4//min.png",
				workingDirectory + "//src//img//detalle//pelicula//peli_5//min.png",
				workingDirectory + "//src//img//detalle//pelicula//peli_6//min.png",
				workingDirectory + "//src//img//detalle//pelicula//peli_7//min.png" };

		generateGrid(rawitem);

		ver = new CustomButton("Ver");
		ver.setBounds(547, 635, 188, 40);
		add(ver);

		regresar = new CustomButton("Regresar");
		regresar.setBounds(745, 635, 178, 40);
		add(regresar);

		back1 = new TransparentPanel();
		back1.setBounds(0, 0, width, height);
		add(back1);

		back0 = new ImageAdaptable(rawback[0]);
		back0.setLocation(0, 0);
		add(back0);
		iniComponentEvents();
		showcomponet(false);
		this.setVisible(false);
	}

	public void iniComponentEvents() {
		regresar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				ctrView.changeBoleteria();
			}

		});

		ver.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if (isPelicula) {
					isPelicula=false;
					ver.setText("Ver Peliculas");
				}
				else{
					isPelicula=true;
					ver.setText("Ver Conferencias");
				}
				refreshButtons(true);
			}

		});
	}

	private void generateGrid(String[] items) {
		int itemWidth = 178, itemHeight = 254;
		int iniX = 60, iniY = 50, spaceX = 50, spaceY = 50;
		int itemOnly4 = 0;
		int x = iniX, y = iniY;
		selectItem = new SelectItem[items.length];
		for (int i = 0; i < items.length; i++) {
			selectItem[i] = new SelectItem(items[i], itemWidth, itemHeight, 37);
			selectItem[i].setLocation(x, y);
			add(selectItem[i]);
			x += itemWidth + spaceX;
			itemOnly4++;
			if (itemOnly4 == 4) {
				itemOnly4 = 0;
				y += itemHeight + spaceY;
				x = iniX;
			}
		}
	}

	private void refreshButtons(boolean interno) {
		int cont = 0;
		int ini, end;
		proyecciones = ctrProyeccion.getProyeccions();

		if (isPelicula) {
			ini = 0;
			end = 7;
		} else {
			ini = 8;
			end = 15;
		}

		for (int i = ini; i <= end; i++) {
			Proyeccion p = proyecciones.get(i);
			selectItem[cont].setProyeccion(p);
			selectItem[cont].setImg(p.getMin());
			cont++;
		}
	}

	public void descargardata() {
		showcomponet(false);
	}

	public void cargardata() {
		proyeccion = ctrProyeccion.getPreproyeccion();
		back0.setImage(ctrProyeccion.getActProyeccion().getCarteleraFront());
		if (proyeccion instanceof Pelicula) {
			ver.setText("Ver Conferencias");
			isPelicula = true;
		} else {
			ver.setText("Ver Peliculas");
			isPelicula = false;
		}
		refreshButtons(false);
		showcomponet(true);
	}

	public void showcomponet(boolean visible) {
		back0.setVisible(visible);
		back1.setVisible(visible);
	}

	class SelectItem extends CustomPanel {
		CustomButton img, btn_comprar;

		public SelectItem(String path, int width, int height, int buttonHeight) {
			setLayout(null);
			Object[] p = { path };
			setSize(width, height);

			img = new CustomButton(p, 1);
			img.setBounds(0, 0, width, height - buttonHeight);
			add(img);

			Object[] customParameters = { 0 };
			btn_comprar = new CustomButton("Ver detalles", customParameters);
			btn_comprar.setBounds(0, height - buttonHeight, width, buttonHeight);
			add(btn_comprar);

			btn_comprar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					ctrProyeccion.setPreproyeccion((Proyeccion) btn_comprar.getCustomParameter(0));
					ctrView.changeDetallePelicula();
				}
			});
		}

		public void setImg(String path) {
			img.setImg(path);
		}

		public void setProyeccion(Proyeccion proyecciont) {
			btn_comprar.setCustomParameter(0, proyecciont);
		}
	}
}
