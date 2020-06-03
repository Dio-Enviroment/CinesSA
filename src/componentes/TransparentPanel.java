package componentes;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.awt.AlphaComposite;
import java.awt.Component;

public class TransparentPanel extends JPanel {

	public TransparentPanel(boolean none) {
		setLayout(null);
	}

	public TransparentPanel() {
		setBackground(Color.BLACK);
		setLayout(null);
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f));
		super.paintComponent(g);
		refresh();
	}


	public void refresh() {
		for (Component component : this.getComponents()) {
			if (component instanceof JLabel) {
				component.getIgnoreRepaint();
			} else {
				component.repaint();
			}
		}
	}
}
