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

	public SelectPelicula(int width,int height,ControladorProyeccion ctrProyeccion,ControladorView ctrView) {
		setLayout(null);
		File workingDirectory = new File(System.getProperty("user.dir"));
		String[] rawback={
			workingDirectory+"//src//img//peli_0_boleteria_back.png"
		};

		String[] rawitem={
			workingDirectory+"//src//img//item0.png",
			workingDirectory+"//src//img//item1.png",
			workingDirectory+"//src//img//item0.png",
			workingDirectory+"//src//img//item1.png",
			workingDirectory+"//src//img//item0.png",
			workingDirectory+"//src//img//item1.png",
			workingDirectory+"//src//img//item0.png",
			workingDirectory+"//src//img//item1.png"
		};

		generateGrid(rawitem);

		TransparentPanel back1=new TransparentPanel();
		back1.setBounds(0, 0, width, height);
		add(back1);
		

		ImageAdaptable back0 = new ImageAdaptable(rawback[0]);
		back0.setLocation(0, 0);
		add(back0);		
	}

	private void generateGrid(String[] items){
		int itemWidth=178, itemHeight=254;
		int iniX=50,iniY=70, spaceX=65,spaceY=70;
		int itemOnly4=0;
		int x=iniX,y=iniY;
		
		for (int i = 0; i < items.length; i++) {
			SelectItem SelectItem=new SelectItem(items[i],itemWidth,itemHeight,37);
			

			SelectItem.setLocation(x, y);
			add(SelectItem);
			x+=itemWidth+spaceX;
			itemOnly4++;
			if (itemOnly4==4) {
				itemOnly4=0;
				y+=itemHeight+spaceY;
				x=iniX;
			}
		}
	}

	class SelectItem extends JPanel{

		public SelectItem(String path,int width,int height,int buttonHeight) {
			setLayout(null);
			Object p=path;
			setSize(width, height);

			CustomButton img=new CustomButton(p);
			img.setBounds(0, 0, width, height-buttonHeight);
			add(img);

			CustomButton btn_comprar=new CustomButton("Comprar");
			btn_comprar.setBounds(0, height-buttonHeight, width, buttonHeight);
			add(btn_comprar);
		}
	} 
}
