package vista;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import componentes.CustomButton;
import componentes.CustomPanel;
import componentes.ImageAdaptable;
import componentes.TransparentPanel;
import controlador.ControladorProyeccion;
import controlador.ControladorView;
import modelo.Pelicula;
import modelo.Proyeccion;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.AlphaComposite;

public class SelectPelicula extends CustomPanel {
	private TransparentPanel back1;
	private ImageAdaptable back0;
	private SelectItem[] selectItem;
	private CustomButton regresar;
	private ControladorProyeccion ctrProyeccion;
	private Proyeccion proyeccion;

	public SelectPelicula(int width,int height,ControladorProyeccion ctrProyeccion,ControladorView ctrView) {
		this.ctrProyeccion=ctrProyeccion;
		setLayout(null);
		setBounds(0, 0, width, height);
		File workingDirectory = new File(System.getProperty("user.dir"));
		String[] rawback={
			workingDirectory+"//src//img//boleteria//pelicula//peli_0//back.png"
		};

		String[] rawitem={
			workingDirectory+"//src//img//detalle//pelicula//peli_0//min.png",
			workingDirectory+"//src//img//detalle//pelicula//peli_1//min.png",
			workingDirectory+"//src//img//detalle//pelicula//peli_2//min.png",
			workingDirectory+"//src//img//detalle//pelicula//peli_3//min.png",
			workingDirectory+"//src//img//detalle//pelicula//peli_4//min.png",
			workingDirectory+"//src//img//detalle//pelicula//peli_5//min.png",
			workingDirectory+"//src//img//detalle//pelicula//peli_6//min.png",
			workingDirectory+"//src//img//detalle//pelicula//peli_7//min.png"
		};
		
		generateGrid(rawitem);

		regresar=new CustomButton("Regresar");
		regresar.setBounds(745,635, 178, 40);
		add(regresar);

		back1=new TransparentPanel();
		back1.setBounds(0, 0, width, height);
		add(back1);
		
		back0 = new ImageAdaptable(rawback[0]);
		back0.setLocation(0, 0);
		add(back0);	
		
		showcomponet(false);
		this.setVisible(false);
	}

	private void generateGrid(String[] items){
		int itemWidth=178, itemHeight=254;
		int iniX=60,iniY=50, spaceX=50,spaceY=50;
		int itemOnly4=0;
		int x=iniX,y=iniY;
		selectItem=new SelectItem[items.length];
		for (int i = 0; i < items.length; i++) {
			selectItem[i]=new SelectItem(items[i],itemWidth,itemHeight,37);
			
			selectItem[i].setLocation(x, y);
			add(selectItem[i]);
			x+=itemWidth+spaceX;
			itemOnly4++;
			if (itemOnly4==4) {
				itemOnly4=0;
				y+=itemHeight+spaceY;
				x=iniX;
			}
		}
	}


	private void refreshButtons(){
		int cont=0;
		ArrayList<Proyeccion> proyecciones=ctrProyeccion.getProyeccions();
		int ini,end;
		if (proyeccion instanceof Pelicula) {
			ini=0;
			end=7;
		}
		else{
			ini=8;
			end=15;
		}

		for (int i = ini; i < end; i++) {
			Proyeccion p=proyecciones.get(i);
		
			selectItem[cont].setImg(p.getMin());
			cont++;
		}
	}

	public void descargardata() {
		showcomponet(false);
	}

	public void cargardata() {
		proyeccion=ctrProyeccion.getActProyeccion();
		refreshButtons();
		showcomponet(true);
	}

	public void showcomponet(boolean visible) {
		back0.setVisible(visible);
		back1.setVisible(visible);
	}

	class SelectItem extends CustomPanel{
		CustomButton img,btn_comprar;

		public SelectItem(String path,int width,int height,int buttonHeight) {
			setLayout(null);
			Object[] p={path};
			setSize(width, height);

			img=new CustomButton(p,1);
			img.setBounds(0, 0, width, height-buttonHeight);
			add(img);

			btn_comprar=new CustomButton("Comprar");
			btn_comprar.setBounds(0, height-buttonHeight, width, buttonHeight);
			add(btn_comprar);

			//showcomponet(false);
		}

		public void setImg(String path){
			img.setImg(path);
		}

		// public void descargardata() {
		// 	showcomponet(false);
		// }
	
		// public void cargardata() {
		// 	showcomponet(true);
		// }

		// public void showcomponet(boolean visible) {
		// 	img.setVisible(visible);
		// 	btn_comprar.setVisible(visible);;
		// }
	} 
}
