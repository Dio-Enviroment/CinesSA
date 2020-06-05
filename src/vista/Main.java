package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controlador.ControladorPrincipal;
import controlador.ControladorView;

public class Main extends JFrame {
	///s
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		ControladorPrincipal controladorPrincipal = new ControladorPrincipal(contentPane);
		ControladorView controladorView = controladorPrincipal.getCtrView();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1024, 768);

		contentPane.setBounds(0, 0, 1008, 729);

		add(contentPane,BorderLayout.CENTER); 
		
		controladorView.changeCartelera();
	}

}
