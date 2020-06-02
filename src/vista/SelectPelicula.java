package vista;

import java.awt.Color;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JPanel;

import componentes.CustomButton;
import componentes.CustomPanel;
import componentes.ImageAdaptable;
import componentes.TransparentPanel;
import controlador.ControladorProyeccion;
import controlador.ControladorView;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.AlphaComposite;

public class SelectPelicula extends CustomPanel {
	private TransparentPanel back1;
	private ImageAdaptable back0;
	private SelectItem[] selectItem;
	private CustomButton regresar;

	public SelectPelicula(int width,int height,ControladorProyeccion ctrProyeccion,ControladorView ctrView) {
		setLayout(null);
		setBounds(0, 0, width, height);
		File workingDirectory = new File(System.getProperty("user.dir"));
		String[] rawback={
			workingDirectory+"//src//img//peli_0_boleteria_back.png"
		};

		String[] rawitem={
			workingDirectory+"//src//img//item0.jpg",
			workingDirectory+"//src//img//item0.jpg",
			workingDirectory+"//src//img//item0.jpg",
			workingDirectory+"//src//img//item0.jpg",
			workingDirectory+"//src//img//item0.jpg",
			workingDirectory+"//src//img//item0.jpg",
			workingDirectory+"//src//img//item0.jpg",
			workingDirectory+"//src//img//item0.jpg"
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

	public void descargardata() {
		showcomponet(false);
	}

	public void cargardata() {
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
