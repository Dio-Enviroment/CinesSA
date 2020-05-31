package componentes;

import java.io.File;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Graphics;

public class Slider extends JPanel {

	private static final long serialVersionUID = 1L;
	private SliderItem[] sliderItems;
	private SliderContainer sliderContainer;
	private int width,pos;

	public Slider(String[] paths,int width,int height) {
		this.width=width;
		sliderItems=new SliderItem[paths.length];
		
		for (int i = 0; i < paths.length; i++) {
			sliderItems[i]=new SliderItem(paths[i]);
		}

		sliderContainer=new SliderContainer(sliderItems,height,width);

		setLayout(null);

		sliderContainer.setBounds(0, 0, width*paths.length, height);
		add(sliderContainer);

		setPos(0);
	}

	public void setPos(int pos) {
		this.pos=pos;
		sliderContainer.setLocation(pos*width*-1, 0);
	}

	public int getPos() {
		return this.pos;
	}

	class SliderContainer extends JPanel{
	
		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		public SliderContainer(SliderItem[] sliderItems, int height, int width) {
			setLayout(null);

			for (int i = 0; i < sliderItems.length; i++) {
				sliderItems[i].setBounds(width*i, 0, width, height);
				add(sliderItems[i]);
			}
		}
	}

	class SliderItem extends JPanel {

		private static final long serialVersionUID = 1L;
		private BufferedImage img;
	
		public SliderItem(String path) {
			try {                
				img = ImageIO.read(new File(path+""));
			 } catch (IOException ex) {
				System.out.println("No funciona la img");  
			 }
		}
	
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, this);          
		}
	
	}

}
