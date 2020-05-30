package vista;
import modelo.*;
import controlador.*;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ComponentListener;
import java.text.DecimalFormat;

import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicArrowButton;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.JSpinner.NumberEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.border.MatteBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CompraPrincipal extends JPanel{
	public JTextField txt_cedula;
	public JTextField txt_nombre;
	public JTextField txt_fono;
	public JTextField txt_direccion;
	private JLabel lbl_pelicula;
	public JLabel lbl_tituloPelicula;
	private JLabel lbl_boletos;
	private JLabel lbl_ninios;
	public JSpinner sp_ninios = new JSpinner();;
	private JLabel lbl_adultos;

	public JSpinner sp_adultos = new JSpinner();
	public JButton btn_selecionAsiento;
	public JLabel lbl_contador;
	private JLabel lbl_subtotal;
	private JLabel lbl_valor_Subtotal;
	private JLabel lbl_iva;
	private JLabel lbl_valor_iva;
	private JLabel lbl_total;
	public JLabel lbl_valor_total;
	private JPanel pn_datoBoleto;
	private JPanel pn_datoPersona;
	private JLabel lbl_cedula;
	private JLabel lbl_nombre;
	private JLabel lbl_telefono;
	private JLabel lbl_direccion;
	private JButton btn_anterior;
	public JButton btn_siguiente;
	private JPanel pn_controlBotones;
	public JLabel lbl_tiiposala;
	private JLabel lbl_sp;
	private ControladorProyeccion ctrProyeccion;
	private ControladorView ctrView;
	private ControladorSala ctrSala;
	private ControladorBoleto ctrBoleto;
	private Precio pr;

	/**
	 * Create the panel.
	 */

	

	public CompraPrincipal(int width, int height, ControladorProyeccion ctrProyeccion, ControladorView ctrView,ControladorSala ctrSala, ControladorBoleto ctrBoleto) {
		
		this.ctrProyeccion = ctrProyeccion;
		this.ctrView= ctrView;
		this.ctrSala=ctrSala;
		this.ctrBoleto=ctrBoleto;
		setLayout(null);

		pn_compra = new JPanel();
		pn_compra.setBounds(12, 13, 513, 526);
		add(pn_compra);
		pn_compra.setLayout(null);

		pn_datoPersona = new JPanel();
		pn_datoPersona.setBounds(12, 23, 494, 182);
		pn_compra.add(pn_datoPersona);
		pn_datoPersona.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true),
				"INFORMACI\u00D3N DEL CLIENTE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagLayout gbl_pn_datoPersona = new GridBagLayout();
		gbl_pn_datoPersona.columnWidths = new int[] { 0, 0, 197, 0 };
		gbl_pn_datoPersona.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_pn_datoPersona.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_pn_datoPersona.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		pn_datoPersona.setLayout(gbl_pn_datoPersona);

		lbl_cedula = new JLabel("C\u00C9DULA:");
		lbl_cedula.setForeground(new Color(102, 0, 102));
		lbl_cedula.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lbl_cedula = new GridBagConstraints();
		gbc_lbl_cedula.anchor = GridBagConstraints.EAST;
		gbc_lbl_cedula.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_cedula.gridx = 1;
		gbc_lbl_cedula.gridy = 1;
		pn_datoPersona.add(lbl_cedula, gbc_lbl_cedula);

		txt_cedula = new JTextField();

		GridBagConstraints gbc_txt_cedula = new GridBagConstraints();
		gbc_txt_cedula.anchor = GridBagConstraints.WEST;
		gbc_txt_cedula.insets = new Insets(0, 0, 5, 0);
		gbc_txt_cedula.gridx = 2;
		gbc_txt_cedula.gridy = 1;
		pn_datoPersona.add(txt_cedula, gbc_txt_cedula);
		txt_cedula.setColumns(10);

		lbl_nombre = new JLabel("NOMBRE:");
		lbl_nombre.setForeground(new Color(102, 0, 102));
		lbl_nombre.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lbl_nombre = new GridBagConstraints();
		gbc_lbl_nombre.anchor = GridBagConstraints.EAST;
		gbc_lbl_nombre.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_nombre.gridx = 1;
		gbc_lbl_nombre.gridy = 2;
		pn_datoPersona.add(lbl_nombre, gbc_lbl_nombre);

		txt_nombre = new JTextField();
		GridBagConstraints gbc_txt_nombre = new GridBagConstraints();
		gbc_txt_nombre.insets = new Insets(0, 0, 5, 0);
		gbc_txt_nombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_nombre.gridx = 2;
		gbc_txt_nombre.gridy = 2;
		pn_datoPersona.add(txt_nombre, gbc_txt_nombre);
		txt_nombre.setColumns(10);

		lbl_telefono = new JLabel("TELEFONO:");
		lbl_telefono.setForeground(new Color(102, 0, 102));
		lbl_telefono.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lbl_telefono = new GridBagConstraints();
		gbc_lbl_telefono.anchor = GridBagConstraints.EAST;
		gbc_lbl_telefono.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_telefono.gridx = 1;
		gbc_lbl_telefono.gridy = 3;
		pn_datoPersona.add(lbl_telefono, gbc_lbl_telefono);

		txt_fono = new JTextField();
		GridBagConstraints gbc_txt_fono = new GridBagConstraints();
		gbc_txt_fono.anchor = GridBagConstraints.NORTHWEST;
		gbc_txt_fono.insets = new Insets(0, 0, 5, 0);
		gbc_txt_fono.gridx = 2;
		gbc_txt_fono.gridy = 3;
		pn_datoPersona.add(txt_fono, gbc_txt_fono);
		txt_fono.setColumns(10);

		lbl_direccion = new JLabel("DIRECCION:");
		lbl_direccion.setForeground(new Color(102, 0, 102));
		lbl_direccion.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lbl_direccion = new GridBagConstraints();
		gbc_lbl_direccion.anchor = GridBagConstraints.EAST;
		gbc_lbl_direccion.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_direccion.gridx = 1;
		gbc_lbl_direccion.gridy = 4;
		pn_datoPersona.add(lbl_direccion, gbc_lbl_direccion);

		txt_direccion = new JTextField();
		txt_direccion.setText("");
		GridBagConstraints gbc_txt_direccion = new GridBagConstraints();
		gbc_txt_direccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_direccion.gridx = 2;
		gbc_txt_direccion.gridy = 4;
		pn_datoPersona.add(txt_direccion, gbc_txt_direccion);
		txt_direccion.setColumns(10);

		pn_datoBoleto = new JPanel();
		pn_datoBoleto.setBounds(12, 205, 494, 270);
		pn_compra.add(pn_datoBoleto);
		pn_datoBoleto.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "DATOS DEL BOLETO",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gbl_pn_datoBoleto = new GridBagLayout();
		gbl_pn_datoBoleto.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_pn_datoBoleto.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_pn_datoBoleto.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_pn_datoBoleto.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		pn_datoBoleto.setLayout(gbl_pn_datoBoleto);

		lbl_pelicula = new JLabel("PEL\u00CDCULA:");
		lbl_pelicula.setForeground(new Color(102, 0, 102));
		lbl_pelicula.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lbl_pelicula = new GridBagConstraints();
		gbc_lbl_pelicula.anchor = GridBagConstraints.EAST;
		gbc_lbl_pelicula.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_pelicula.gridx = 1;
		gbc_lbl_pelicula.gridy = 1;
		pn_datoBoleto.add(lbl_pelicula, gbc_lbl_pelicula);

		lbl_tituloPelicula = new JLabel("titulo de la pelicula");
		lbl_tituloPelicula.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lbl_tituloPelicula = new GridBagConstraints();
		gbc_lbl_tituloPelicula.anchor = GridBagConstraints.WEST;
		gbc_lbl_tituloPelicula.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_tituloPelicula.gridx = 2;
		gbc_lbl_tituloPelicula.gridy = 1;
		pn_datoBoleto.add(lbl_tituloPelicula, gbc_lbl_tituloPelicula);

		lbl_tiiposala = new JLabel("tipo de sala");
		lbl_tiiposala.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_tiiposala.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lbl_tiiposala = new GridBagConstraints();
		gbc_lbl_tiiposala.insets = new Insets(0, 0, 5, 0);
		gbc_lbl_tiiposala.gridx = 4;
		gbc_lbl_tiiposala.gridy = 1;
		pn_datoBoleto.add(lbl_tiiposala, gbc_lbl_tiiposala);

		lbl_boletos = new JLabel("BOLETOS");
		lbl_boletos.setForeground(new Color(102, 0, 102));
		lbl_boletos.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lbl_boletos = new GridBagConstraints();
		gbc_lbl_boletos.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_boletos.gridx = 2;
		gbc_lbl_boletos.gridy = 2;
		pn_datoBoleto.add(lbl_boletos, gbc_lbl_boletos);

		lbl_sp = new JLabel("");
		GridBagConstraints gbc_lbl_sp = new GridBagConstraints();
		gbc_lbl_sp.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_sp.gridx = 0;
		gbc_lbl_sp.gridy = 3;
		pn_datoBoleto.add(lbl_sp, gbc_lbl_sp);

		lbl_ninios = new JLabel("NI\u00D1OS:");
		lbl_ninios.setForeground(new Color(102, 0, 102));
		lbl_ninios.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lbl_ninios = new GridBagConstraints();
		gbc_lbl_ninios.anchor = GridBagConstraints.EAST;
		gbc_lbl_ninios.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_ninios.gridx = 1;
		gbc_lbl_ninios.gridy = 3;
		pn_datoBoleto.add(lbl_ninios, gbc_lbl_ninios);
		GridBagConstraints gbc_sp_ninios = new GridBagConstraints();
		gbc_sp_ninios.anchor = GridBagConstraints.WEST;
		gbc_sp_ninios.insets = new Insets(0, 0, 5, 5);
		gbc_sp_ninios.gridx = 2;
		gbc_sp_ninios.gridy = 3;
		pn_datoBoleto.add(sp_ninios, gbc_sp_ninios);

		lbl_adultos = new JLabel("ADULTOS:");

		lbl_adultos.setForeground(new Color(102, 0, 102));
		lbl_adultos.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lbl_adultos = new GridBagConstraints();
		gbc_lbl_adultos.anchor = GridBagConstraints.EAST;
		gbc_lbl_adultos.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_adultos.gridx = 1;
		gbc_lbl_adultos.gridy = 4;
		pn_datoBoleto.add(lbl_adultos, gbc_lbl_adultos);
		GridBagConstraints gbc_sp_adultos = new GridBagConstraints();
		gbc_sp_adultos.anchor = GridBagConstraints.WEST;
		gbc_sp_adultos.insets = new Insets(0, 0, 5, 5);
		gbc_sp_adultos.gridx = 2;
		gbc_sp_adultos.gridy = 4;
		pn_datoBoleto.add(sp_adultos, gbc_sp_adultos);

		btn_selecionAsiento = new JButton("SELECCIONAR ASIENTOS");
		btn_selecionAsiento.setFont(new Font("Verdana", Font.BOLD, 13));
		btn_selecionAsiento.setForeground(new Color(102, 0, 102));
		GridBagConstraints gbc_btn_selecionAsiento = new GridBagConstraints();
		gbc_btn_selecionAsiento.insets = new Insets(0, 0, 5, 5);
		gbc_btn_selecionAsiento.gridx = 2;
		gbc_btn_selecionAsiento.gridy = 5;
		pn_datoBoleto.add(btn_selecionAsiento, gbc_btn_selecionAsiento);

		lbl_contador = new JLabel("0");
		lbl_contador.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lbl_contador = new GridBagConstraints();
		gbc_lbl_contador.anchor = GridBagConstraints.WEST;
		gbc_lbl_contador.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_contador.gridx = 3;
		gbc_lbl_contador.gridy = 5;
		pn_datoBoleto.add(lbl_contador, gbc_lbl_contador);

		lbl_subtotal = new JLabel("SUBTOTAL:");
		lbl_subtotal.setForeground(new Color(102, 0, 102));
		lbl_subtotal.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lbl_subtotal = new GridBagConstraints();
		gbc_lbl_subtotal.anchor = GridBagConstraints.EAST;
		gbc_lbl_subtotal.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_subtotal.gridx = 1;
		gbc_lbl_subtotal.gridy = 6;
		pn_datoBoleto.add(lbl_subtotal, gbc_lbl_subtotal);

		lbl_valor_Subtotal = new JLabel("0");
		lbl_valor_Subtotal.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lbl_valor_Subtotal = new GridBagConstraints();
		gbc_lbl_valor_Subtotal.anchor = GridBagConstraints.WEST;
		gbc_lbl_valor_Subtotal.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_valor_Subtotal.gridx = 2;
		gbc_lbl_valor_Subtotal.gridy = 6;
		pn_datoBoleto.add(lbl_valor_Subtotal, gbc_lbl_valor_Subtotal);

		lbl_iva = new JLabel("IVA:");
		lbl_iva.setForeground(new Color(102, 0, 102));
		lbl_iva.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lbl_iva = new GridBagConstraints();
		gbc_lbl_iva.anchor = GridBagConstraints.EAST;
		gbc_lbl_iva.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_iva.gridx = 1;
		gbc_lbl_iva.gridy = 7;
		pn_datoBoleto.add(lbl_iva, gbc_lbl_iva);

		lbl_valor_iva = new JLabel("0");
		lbl_valor_iva.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lbl_valor_iva = new GridBagConstraints();
		gbc_lbl_valor_iva.anchor = GridBagConstraints.WEST;
		gbc_lbl_valor_iva.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_valor_iva.gridx = 2;
		gbc_lbl_valor_iva.gridy = 7;
		pn_datoBoleto.add(lbl_valor_iva, gbc_lbl_valor_iva);

		lbl_total = new JLabel("TOTAL:");
		lbl_total.setForeground(new Color(102, 0, 102));
		lbl_total.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lbl_total = new GridBagConstraints();
		gbc_lbl_total.anchor = GridBagConstraints.EAST;
		gbc_lbl_total.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_total.gridx = 1;
		gbc_lbl_total.gridy = 8;
		pn_datoBoleto.add(lbl_total, gbc_lbl_total);

		lbl_valor_total = new JLabel("0");
		lbl_valor_total.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lbl_valor_total = new GridBagConstraints();
		gbc_lbl_valor_total.anchor = GridBagConstraints.WEST;
		gbc_lbl_valor_total.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_valor_total.gridx = 2;
		gbc_lbl_valor_total.gridy = 8;
		pn_datoBoleto.add(lbl_valor_total, gbc_lbl_valor_total);
		this.btn_selecionAsiento.setEnabled(false);

		pn_controlBotones = new JPanel();
		pn_controlBotones.setBounds(293, 473, 213, 40);
		pn_compra.add(pn_controlBotones);
		pn_controlBotones.setBorder(new EmptyBorder(0, 0, 0, 0));
		pn_controlBotones.setLayout(new BoxLayout(pn_controlBotones, BoxLayout.X_AXIS));

		btn_anterior = new JButton("ANTERIOR");
		btn_anterior.setForeground(new Color(102, 0, 102));
		btn_anterior.setFont(new Font("Verdana", Font.BOLD, 13));
		pn_controlBotones.add(btn_anterior);

		btn_siguiente = new JButton("SIGUIENTE");
		btn_siguiente.setForeground(new Color(102, 0, 102));
		btn_siguiente.setFont(new Font("Verdana", Font.PLAIN, 13));
		pn_controlBotones.add(btn_siguiente);
		this.btn_siguiente.setEnabled(false);
		//ra.a�adirSalas();

		// ************** NEcesito Numero sala ***////////////////////
		limitarValoresJpinner(10);
		// ****************************////////////////////////
		maxA = Integer.parseInt(ad.getMaximum().toString());
		// SiguienteToolTip();
		
		Proyeccion actProyeccion= ctrProyeccion.getActProyeccion();
		this.lbl_tituloPelicula.setText(actProyeccion.getTitulo());
		this.lbl_tiiposala.setText(actProyeccion.getSalaTipo());
		this.sp_ninios.setEnabled(false);
		censura();
		init();

	}

	//Registro_asiento ra = new Registro_asiento();

	public void limitarValoresJpinner() {
		ad.setMaximum(ctrlBoleto.getBoletos(ctrlSala));
		ad.setMinimum(0);
		ad.setStepSize(1);
		nn.setMaximum(ctrlBoleto.getBoletos(ctrlSala));
		nn.setMinimum(0);
		nn.setStepSize(1);
		this.sp_adultos.setModel(ad);
		this.sp_ninios.setModel(nn);
	}
	
	SpinnerNumberModel ad = new SpinnerNumberModel();
	SpinnerNumberModel nn = new SpinnerNumberModel();
	BasicArrowButton arribaA = (BasicArrowButton) sp_adultos.getComponent(0);
	BasicArrowButton arribaN = (BasicArrowButton) sp_ninios.getComponent(0);
	private int maxA;
	private int aux;

	public void init() {

		txt_cedula.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
				if ((car < '0' || car > '9'))
					e.consume();
			}
		});
		txt_fono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
				if ((car < '0' || car > '9'))
					e.consume();
			}
		});
		txt_nombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (!Character.isLetter(e.getKeyChar()) && !(e.getKeyChar() == KeyEvent.VK_SPACE)
						&& !(e.getKeyChar() == KeyEvent.VK_BACK_SPACE))
					e.consume();
			}
		});

		/************** NEcesito Numero sala ***////////////////////

		sp_adultos.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				aux = Integer.parseInt(sp_adultos.getValue().toString())
						+ Integer.parseInt(sp_ninios.getValue().toString());
				if (aux == maxA) {
					arribaA.setEnabled(false);
					arribaN.setEnabled(false);
				} else {
					arribaA.setEnabled(true);
					arribaN.setEnabled(true);
				}
				
				lbl_contador.setText(aux + "");
				
				// lbl_valor_Subtotal.setText((Math.round(pr.calculoS(Integer.parseInt(sp_adultos.getValue().toString()),Integer.parseInt(sp_ninios.getValue().toString()), 1, "Pelicula") * 100) / 100d) + "");
				// lbl_valor_iva.setText((Math.round(pr.calculoI(Double.parseDouble(lbl_valor_Subtotal.getText())) * 100) / 100d) + "");
				// lbl_valor_total.setText((Math.round(pr.calculoT(Double.parseDouble(lbl_valor_Subtotal.getText()),Double.parseDouble(lbl_valor_iva.getText())) * 100) / 100d) + "");
				lbl_valor_Subtotal.setText((Math.round(pr.calculoS(Integer.parseInt(sp_adultos.getValue().toString()), Integer.parseInt(sp_ninios.getValue().toString()), ctrProyeccion)*100)/100d)+"");
				lbl_valor_iva.setText((Math.round(pr.calculoI(Double.parseDouble(lbl_valor_Subtotal.getText()))*100)/100d)+"");
				lbl_valor_total.setText((Math.round(pr.calculoT(Double.parseDouble(lbl_valor_Subtotal.getText()),Double.parseDouble(lbl_valor_iva.getText()))*100)/100d)+"");
				lbl_valor_Subtotal.setText(lbl_valor_Subtotal.getText() + " $");
				lbl_valor_iva.setText(lbl_valor_iva.getText() + " $");
				lbl_valor_total.setText(lbl_valor_total.getText() + " $");
				activadorSeleccion();
			}

		});
		sp_ninios.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				aux = Integer.parseInt(sp_adultos.getValue().toString())
						+ Integer.parseInt(sp_ninios.getValue().toString());
				if (aux == maxA) {
					arribaA.setEnabled(false);
					arribaN.setEnabled(false);
				} else {
					arribaA.setEnabled(true);
					arribaN.setEnabled(true);
				}
				
				lbl_contador.setText(aux + "");
				
				// lbl_valor_Subtotal.setText((Math.round(pr.calculoS(Integer.parseInt(sp_adultos.getValue().toString()),Integer.parseInt(sp_ninios.getValue().toString()), 1, "Pelicula") * 100) / 100d) + "");
				// lbl_valor_iva.setText((Math.round(pr.calculoI(Double.parseDouble(lbl_valor_Subtotal.getText())) * 100) / 100d) + "");
				// lbl_valor_total.setText((Math.round(pr.calculoT(Double.parseDouble(lbl_valor_Subtotal.getText()),Double.parseDouble(lbl_valor_iva.getText())) * 100) / 100d) + "");
				lbl_valor_Subtotal.setText((Math.round(pr.calculoS(Integer.parseInt(sp_adultos.getValue().toString()), Integer.parseInt(sp_ninios.getValue().toString()), ctrProyeccion)*100)/100d)+"");
				lbl_valor_iva.setText((Math.round(pr.calculoI(Double.parseDouble(lbl_valor_Subtotal.getText()))*100)/100d)+"");
				lbl_valor_total.setText((Math.round(pr.calculoT(Double.parseDouble(lbl_valor_Subtotal.getText()),Double.parseDouble(lbl_valor_iva.getText()))*100)/100d)+"");
				lbl_valor_Subtotal.setText(lbl_valor_Subtotal.getText() + " $");
				lbl_valor_iva.setText(lbl_valor_iva.getText() + " $");
				lbl_valor_total.setText(lbl_valor_total.getText() + " $");
				activadorSeleccion();
			}

		});

		
		

	}

	public void activadorSeleccion() {
		if (Integer.parseInt(lbl_contador.getText()) == 0) {
			this.btn_selecionAsiento.setEnabled(false);
		} else {
			this.btn_selecionAsiento.setEnabled(true);
		}
	}

	public void SiguienteToolTip() {

	}

	boolean estado;
	public JPanel pn_compra;
	
	public String getContador() {
		return this.lbl_contador.toString();
	}
	
	public boolean exp() {
		//DatosCliente dc = new DatosCliente();
		Object[] d = { this.lbl_tituloPelicula.getText(), this.lbl_tiiposala.getText(), this.lbl_contador.getText(),
				null, this.lbl_valor_total.getText(), this.txt_cedula.getText(), this.txt_nombre.getText(),
				this.txt_fono.getText(), this.txt_direccion.getText() };
		// try {
		// 	estado = dc.ValidarCampos(d);
		// 	dc.ValidarCampos(d);
		// } catch (Excepcion le) {
		// 	print(le.getMessage());
		// }
		return estado;
	}

	public void censura() {
		Proyeccion actProyeccion = ctrProyeccion.getActProyeccion();
		if (actProyeccion instanceof Pelicula) {
			if (actProyeccion.getEdad()<12) {
				this.sp_ninios.setEnabled(false);
			}
			else {
				this.sp_ninios.setEnabled(true);
			}
		}
		else {
			this.sp_adultos.setEnabled(true);
		}
		
	}
	
	
}
