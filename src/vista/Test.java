package vista;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class Test extends JFrame {
  public Test() {
    super("LayeredPane Demonstration");
    setSize(200, 150);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    JLayeredPane lp = getLayeredPane();

    // Create 3 buttons
    JButton top = new JButton();
    top.setBackground(Color.white);
    top.setBounds(20, 20, 50, 50);
    JButton middle = new JButton();
    middle.setBackground(Color.gray);
    middle.setBounds(40, 40, 50, 50);
    JButton bottom = new JButton();
    bottom.setBackground(Color.black);
    bottom.setBounds(60, 60, 50, 50);

    // Place the buttons in different layers
    lp.add(middle, 2);
    lp.add(top, 3);
    lp.add(bottom, 1);
  }

  public static void main(String[] args) {
    Test sl = new Test();
    sl.setVisible(true);
  }
}