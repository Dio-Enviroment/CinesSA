package vista;

import java.awt.CardLayout;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorPrincipal;
import controlador.ControladorView;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}//s
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		contentPane = new JPanel();
		contentPane.setLayout(null);
		ControladorPrincipal controladorPrincipal = new ControladorPrincipal(contentPane);
		ControladorView controladorView = controladorPrincipal.getCtrView();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1024, 768);

		contentPane.setBounds(0, 0, 1008, 729);

		add(contentPane,BorderLayout.CENTER); 
		
		controladorView.changeCartelera();
		
<<<<<<< Upstream, based on origin/master
=======
	
>>>>>>> bbb677f compraprin
	}

	

}
