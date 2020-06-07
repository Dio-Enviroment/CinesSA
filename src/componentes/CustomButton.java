package componentes;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.image.BufferedImage;
import java.awt.*;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;

public class CustomButton extends JButton{

    private static final long serialVersionUID = 1L;
    private int mode = 0;
    private Color idle, press,enable;
    private Object[] customParameter;
    private String [] paths;

    public CustomButton(String txt) {
        super(txt);
        ini();
    }

    public CustomButton(String txt,Object[] customParameter) {
        super(txt);
        this.customParameter=customParameter;
        ini();
    }

    private void ini(){
        this.setForeground(Color.white);
        this.setFont(new Font("Tahoma", Font.PLAIN, 20));
        this.setUI(new CustomButtonUI(mode));
        this.setBorder(new EmptyBorder(5, 15, 5, 15));
        this.idle=new Color(148, 48, 42, 255);
        this.press=new Color(101, 35, 34, 255);
        this.enable=new Color(68, 22, 20, 255);
    }

    public CustomButton(Object[] path,int num_img) {
        int cont=0;
        this.mode = 1;
        this.setUI(new CustomButtonUI(mode,path[0].toString()));
        this.setBorder(new EmptyBorder(5, 15, 5, 15));

        paths=new String[num_img];
        for (int i = 0; i < num_img; i++) {
            paths[i]=(String)path[i];
        }

        customParameter=new Object[path.length-num_img];
        if (path.length>num_img) {
            for (int i = num_img; i < path.length; i++) {
                customParameter[cont]=path[i];
                cont++;
            }
        }

    }

    public void setImg(String path) {
        this.setUI(new CustomButtonUI(mode,path));
        
    }

    public void changeIcon(int pos){
        setImg(paths[pos].toString());
    }

    public Object getCustomParameter(int pos){
        return customParameter[pos];
    }

    public void setCustomParameter(int pos,Object value){
        customParameter[pos]=value;
    }

    @Override
    public void addActionListener(ActionListener event){
        super.addActionListener(event);
    }


    class CustomButtonUI extends BasicButtonUI {
        private int mode;
        private BufferedImage img;

        public CustomButtonUI(int mode) {
            this.mode = mode;
        }

        public CustomButtonUI(int mode, String path) {
            this.mode = mode;

            try {
                img = ImageIO.read(new File(path + ""));
            } catch (IOException ex) {
                System.out.println(new File(path + ""));
            }
        }

        @Override
        public void paint(Graphics g, JComponent c) {
            AbstractButton b = (AbstractButton) c;
            Dimension d = c.getSize();
            if (mode == 1) {
                img(g,c);
            } else {
                normal(g, b, d);
            }
            super.paint(g, c);
        }

        private void img(Graphics g,JComponent c) {
            Graphics2D g2d = (Graphics2D) g;
            g.drawImage(img, 0, 0, c);   
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0f)); 
        }

        private void normal(Graphics g, AbstractButton b, Dimension d) {
            if (!b.getModel().isPressed()) {
                g.setColor(idle);
            } else {
                g.setColor(press);
            }
            if(!b.getModel().isEnabled()){
                g.setColor(enable);
            }
            g.fillRect(0, 0, d.width, d.height);
        }
    }
}
