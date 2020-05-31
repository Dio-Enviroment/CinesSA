package componentes;

import java.io.File;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Graphics;

public class Slide extends JPanel {

	private static final long serialVersionUID = 1L;
	private SlideItem[] slideItems;
	private SlideContainer slideContainer;
	private int width,pos;

	private Timer timer=new Timer();
	private TimerTask task;


	public Slide(String[] paths,int width,int height) {
		this.width=width;
		slideItems=new SlideItem[paths.length];
		
		for (int i = 0; i < paths.length; i++) {
			slideItems[i]=new SlideItem(paths[i]);
		}

		slideContainer=new SlideContainer(slideItems,height,width);

		setLayout(null);

		slideContainer.setBounds(0, 0, width*paths.length, height);
		add(slideContainer);

		setPos(0);
	}

	private void initTransition(){
		// task = new TimerTask(){
		
		// 	@Override
		// 	public void run() {
				
		// 	}
		// };
	}

	public void setPos(int pos) {
		
		this.pos=pos;
		slideContainer.setLocation(pos*width*-1, 0);
	}

	public int getPos() {
		return this.pos;
	}

	class SlideContainer extends JPanel{
	
		private static final long serialVersionUID = 1L;

		public SlideContainer(SlideItem[] slideItems, int height, int width) {
			setLayout(null);

			for (int i = 0; i < slideItems.length; i++) {
				slideItems[i].setBounds(width*i, 0, width, height);
				add(slideItems[i]);
			}
		}
	}

	class SlideItem extends JPanel {

		private static final long serialVersionUID = 1L;
		private BufferedImage img;
	
		public SlideItem(String path) {
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
