package vista;

import javax.swing.JPanel;
import java.awt.GridBagLayout;

import componentes.CustomButton;
import componentes.CustomPanel;
import componentes.ImageAdaptable;
import controlador.ControladorBoleto;
import controlador.ControladorProyeccion;
import controlador.ControladorSala;
import controlador.ControladorView;
import modelo.Asiento;
import modelo.Cliente;
import modelo.Sala;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;


public class ResumenCompra extends CustomPanel {

	private static final long serialVersionUID = 1L;

	private JLabel lbl_salaR;
	private JLabel lbl_peliculaR;
	private JLabel lbl_boletosR;
	private JLabel lbl_totalR;
	private JLabel lbl_asientosR;
	private JLabel lbl_numSalaR;
	private JLabel lbl_numAsiemtosR;
	private JLabel lbl_numBoletasR;
	private JLabel lbl_numTotalR;
	private JPanel panel;
	private CustomButton btn_cancelar;
	private CustomButton btn_comprar;
	
	private JLabel lbl_tituloPeliculaR;
	private ControladorSala ctrSala;
	private ControladorView ctrView;
	private Sala sala;
	private ControladorProyeccion ctrPro;
	private ArrayList<Asiento> salaPre;
	private boolean [][]salaAct;
	private String letras[] = {"A","B","C","D","E","F","G","H"};
	private String puesto="";
	private Cliente cliente;
	private ControladorBoleto ctrBoleto;

	public ResumenCompra(int width,int height, ControladorSala ctrSala, ControladorProyeccion ctrPro, ControladorBoleto ctrBoleto, ControladorView ctrView) {
		this.ctrSala = ctrSala;
		this.ctrView = ctrView;
		this.ctrPro= ctrPro;
		this.ctrBoleto= ctrBoleto;
		setLayout(null);
		setBounds(0, 0, width, height);

		File workingDirectory = new File(System.getProperty("user.dir"));
				String[] paths = { workingDirectory + "//src//resources//compraPrincipal_3.png",
						workingDirectory + "//src//resources//compraPrincipal_2.png"};

		ImageAdaptable img1=new ImageAdaptable(paths[0]);
		
		add(img1);

		
		GridBagLayout gbl_pn_resumenCompra = new GridBagLayout();
		gbl_pn_resumenCompra.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_pn_resumenCompra.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_pn_resumenCompra.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_pn_resumenCompra.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		

		lbl_peliculaR = new JLabel("PEL\u00CDCULA:");
		lbl_peliculaR.setFont(new Font("Verdana", Font.BOLD, 30));
		GridBagConstraints gbc_lbl_peliculaR = new GridBagConstraints();
		gbc_lbl_peliculaR.anchor = GridBagConstraints.WEST;
		gbc_lbl_peliculaR.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_peliculaR.gridx = 1;
		gbc_lbl_peliculaR.gridy = 1;
	

		lbl_tituloPeliculaR = new JLabel("t\u00EDtulo de la pel\u00EDcula");
		lbl_tituloPeliculaR.setFont(new Font("Verdana", Font.PLAIN, 30));
		GridBagConstraints gbc_lbl_tituloPeliculaR = new GridBagConstraints();
		gbc_lbl_tituloPeliculaR.insets = new Insets(0, 0, 5, 0);
		gbc_lbl_tituloPeliculaR.gridx = 2;
		gbc_lbl_tituloPeliculaR.gridy = 1;
		

		lbl_salaR = new JLabel("SALA:");
		lbl_salaR.setFont(new Font("Verdana", Font.BOLD, 30));
		GridBagConstraints gbc_lbl_salaR = new GridBagConstraints();
		gbc_lbl_salaR.anchor = GridBagConstraints.WEST;
		gbc_lbl_salaR.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_salaR.gridx = 1;
		gbc_lbl_salaR.gridy = 2;
	

		lbl_numSalaR = new JLabel("1");
		lbl_numSalaR.setFont(new Font("Verdana", Font.PLAIN, 30));
		GridBagConstraints gbc_lbl_numSalaR = new GridBagConstraints();
		gbc_lbl_numSalaR.anchor = GridBagConstraints.WEST;
		gbc_lbl_numSalaR.insets = new Insets(0, 0, 5, 0);
		gbc_lbl_numSalaR.gridx = 2;
		gbc_lbl_numSalaR.gridy = 2;
	

		lbl_boletosR = new JLabel("BOLETOS:");
		lbl_boletosR.setFont(new Font("Verdana", Font.BOLD, 30));
		GridBagConstraints gbc_lbl_boletosR = new GridBagConstraints();
		gbc_lbl_boletosR.anchor = GridBagConstraints.WEST;
		gbc_lbl_boletosR.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_boletosR.gridx = 1;
		gbc_lbl_boletosR.gridy = 3;
	

		lbl_numBoletasR = new JLabel("1");
		lbl_numBoletasR.setFont(new Font("Verdana", Font.PLAIN, 30));
		GridBagConstraints gbc_lbl_numBoletasR = new GridBagConstraints();
		gbc_lbl_numBoletasR.anchor = GridBagConstraints.WEST;
		gbc_lbl_numBoletasR.insets = new Insets(0, 0, 5, 0);
		gbc_lbl_numBoletasR.gridx = 2;
		gbc_lbl_numBoletasR.gridy = 3;
		

		lbl_asientosR = new JLabel("ASIENTOS:");
		lbl_asientosR.setFont(new Font("Verdana", Font.BOLD, 30));
		GridBagConstraints gbc_lbl_asientosR = new GridBagConstraints();
		gbc_lbl_asientosR.anchor = GridBagConstraints.WEST;
		gbc_lbl_asientosR.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_asientosR.gridx = 1;
		gbc_lbl_asientosR.gridy = 4;
	

		lbl_numAsiemtosR = new JLabel("{ A3 - B5 -B6 }");
		lbl_numAsiemtosR.setFont(new Font("Verdana", Font.PLAIN, 30));
		GridBagConstraints gbc_lbl_numAsiemtosR = new GridBagConstraints();
		gbc_lbl_numAsiemtosR.anchor = GridBagConstraints.WEST;
		gbc_lbl_numAsiemtosR.insets = new Insets(0, 0, 5, 0);
		gbc_lbl_numAsiemtosR.gridx = 2;
		gbc_lbl_numAsiemtosR.gridy = 4;
		
		

		lbl_totalR = new JLabel("TOTAL:");
		lbl_totalR.setFont(new Font("Verdana", Font.BOLD, 30));
		GridBagConstraints gbc_lbl_totalR = new GridBagConstraints();
		gbc_lbl_totalR.anchor = GridBagConstraints.WEST;
		gbc_lbl_totalR.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_totalR.gridx = 1;
		gbc_lbl_totalR.gridy = 5;
		

		lbl_numTotalR = new JLabel("1");
		lbl_numTotalR.setFont(new Font("Verdana", Font.PLAIN, 30));
		GridBagConstraints gbc_lbl_numTotalR = new GridBagConstraints();
		gbc_lbl_numTotalR.anchor = GridBagConstraints.WEST;
		gbc_lbl_numTotalR.insets = new Insets(0, 0, 5, 0);
		gbc_lbl_numTotalR.gridx = 2;
		gbc_lbl_numTotalR.gridy = 5;
	

		panel = new JPanel();
		panel.setBounds(57, 204, 250, 40);
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		add(lbl_salaR);
		add(lbl_peliculaR);
		add(lbl_totalR);
		add(lbl_boletosR);
		add(lbl_asientosR);
		add(lbl_numSalaR);
		add(lbl_numAsiemtosR);
		add(lbl_numBoletasR);
		add(lbl_numTotalR);
		add(lbl_tituloPeliculaR);
		
		this.lbl_peliculaR.setBounds(250, 200, 300, 50);
		this.lbl_tituloPeliculaR.setBounds(453, 200, 300, 50);
		lbl_tituloPeliculaR.setFont(new Font("Verdana", Font.PLAIN, 30));
		this.lbl_salaR.setBounds(330, 235, 300, 50);
		this.lbl_numSalaR.setBounds(450, 235, 300, 50);
		lbl_numSalaR.setFont(new Font("Verdana", Font.PLAIN, 30));
		this.lbl_asientosR.setBounds(241, 270, 300, 50);
		this.lbl_numAsiemtosR.setBounds(445, 270, 1000, 50);
		lbl_numAsiemtosR.setFont(new Font("Verdana", Font.PLAIN, 30));
		this.lbl_boletosR.setBounds(259, 305, 300, 50);
		this.lbl_numBoletasR.setBounds(449, 305, 300, 50);
		lbl_numBoletasR.setFont(new Font("Verdana", Font.PLAIN, 30));
		this.lbl_totalR.setBounds(303, 340, 300, 50);
		this.lbl_numTotalR.setBounds(450, 340, 300, 50);
		lbl_numTotalR.setFont(new Font("Verdana", Font.PLAIN, 30));
	
		img1.setLocation(600, 300);

		btn_cancelar = new CustomButton("CANCELAR");
		btn_cancelar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				ctrView.setActivador4(false);
				cliente= ctrBoleto.getCliente();
				cliente.setCedula("");
				cliente.setNombre("");
				cliente.setTelefono("");
				cliente.setDireccion("");
				ctrBoleto.setPuestos("0");
				ctrBoleto.setTotal("0");
				ctrBoleto.setIva("0");
				ctrBoleto.setSubtotal("0");
				puesto="";
				ctrView.setCliente("");
				ctrView.setActivador(false);
				ctrView.setActivador2(false);
				ctrSala.vaciarTodos();
				ctrView.changeCartelera();
			}

		});
		btn_cancelar.setFont(new Font("Verdana", Font.BOLD, 20));
		panel.add(btn_cancelar);

		btn_comprar = new CustomButton("COMPRAR");
		btn_comprar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				puesto="";
				ctrBoleto.setPuestos("0");
				ctrBoleto.setTotal("0");
				ctrBoleto.setIva("0");
				ctrBoleto.setSubtotal("0");
				setAsientos();
				ctrSala.vaciarTodos();
				ctrView.setActivador(false);
				ctrView.setActivador2(false);
				ctrView.changeAgradecimiento();
			}

		});
		btn_comprar.setFont(new Font("Verdana", Font.BOLD, 20));
		panel.add(btn_comprar);
		add(btn_cancelar);
		add(btn_comprar);
		
		this.btn_cancelar.setBounds(290, 400, 150, 25);
		this.btn_comprar.setBounds(450, 400, 150, 25);
		showcomponet(false);
		
	}

	public void descargardata() {
		
		puesto="";
		showcomponet(false);
		
	}
	public void cargardata() {
		ctrView.toString();
		sala = ctrSala.getSala(0);
		salaAct =  sala.getAsientos();
		salaPre = ctrSala.getSalaPre();
		this.lbl_numAsiemtosR.setText("{ " + setPuesto() + " } ");
		this.lbl_tituloPeliculaR.setText( ctrPro.getActProyeccion().getTitulo());
		this.lbl_numSalaR.setText((sala.getId()+1) +"");
		this.lbl_numBoletasR.setText(ctrBoleto.getPuestos());
		this.lbl_numTotalR.setText(ctrBoleto.getTotal());
		showcomponet(true);
		
	}
	public void showcomponet(boolean visible){
		
		lbl_salaR.setVisible(visible);
		lbl_peliculaR.setVisible(visible);
		lbl_boletosR.setVisible(visible);
		lbl_totalR.setVisible(visible);
		lbl_asientosR.setVisible(visible);
		lbl_numSalaR.setVisible(visible);
		lbl_numAsiemtosR.setVisible(visible);
		lbl_numBoletasR.setVisible(visible);
		lbl_numTotalR.setVisible(visible);
		panel.setVisible(visible);
		btn_cancelar.setVisible(visible);
		btn_comprar.setVisible(visible);
		lbl_tituloPeliculaR.setVisible(visible);
	}
	public void setAsientos() {
		for (Asiento asiento: salaPre) {
			salaAct[asiento.getFila()][asiento.getColumna()]=true;	
		}
	}
	public String setPuesto() {
		for (Asiento asiento: salaPre) {
			puesto = puesto + " " + letras[asiento.getFila()]+ "" + (asiento.getColumna()+1);
		}
		return puesto;
	}
	
}