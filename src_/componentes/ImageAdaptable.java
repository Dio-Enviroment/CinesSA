package componentes;

import java.io.IOException;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.AlphaComposite;

public class ImageAdaptable extends JPanel{
    private static final long serialVersionUID = 2L;
    private BufferedImage img;

    public ImageAdaptable(String path) {
        try {                
            img = ImageIO.read(new File(path+""));
         } catch (IOException ex) {
            System.out.println("No funciona la img");  
         }
    }

    public int getWidth() {
        return img.getWidth();
    }

    public int getHeight() {
        return img.getHeight();
    }

    @Override
	public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.drawImage(img, 0, 0, this);   
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0f));       
		super.paintComponent(g);
	}
}