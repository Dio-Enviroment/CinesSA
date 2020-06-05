package controlador;

import javax.swing.JFrame;
import javax.swing.JPanel;

import componentes.CustomPanel;

import java.awt.BorderLayout;
import vista.*;

public class ControladorView {
    private JPanel container;
    private CustomPanel actPanel;
    private CustomPanel cartelera;
    private CustomPanel boleteria;
    private CustomPanel selectPelicula;
    private CustomPanel detallePelicula;
    private CustomPanel compraPrincipal;
    private CustomPanel seleccionarAsientos;
    private CustomPanel resumenCompra;
    private CustomPanel agradecimiento;
    private String contador;
    private boolean activador;
    private boolean activador2;
    private boolean inicompraPrincipal=true;
    private String nombre ;
	private String total="0";
	private String subtotal="0";
	private String iva="0";
	private String puestos="0";
    private String cliente="";
    public ControladorView(JPanel container,ControladorSala ctrSala,ControladorProyeccion ctrProyeccion, ControladorBoleto ctrBoleto){
        this.container=container;
        this.cartelera=new Cartelera(1008,729,ctrProyeccion,this);
        this.selectPelicula=new SelectPelicula(1008, 729,ctrProyeccion,this);
        this.boleteria=new Boleteria(1008, 729,ctrProyeccion,ctrSala,this);
        this.detallePelicula=new DetallePelicula(1008, 729,ctrProyeccion,this);
        this.compraPrincipal=new CompraPrincipal(1008, 729,ctrProyeccion, ctrSala,ctrBoleto, this);
        this.seleccionarAsientos=new SeleccionarAsientos(1008, 729,ctrSala,this);
        this.resumenCompra=new ResumenCompra(1008, 729,ctrSala,ctrProyeccion,ctrBoleto,this);
        this.agradecimiento=new Agradecimiento(1008, 729,ctrSala,ctrBoleto,this);

        this.container.add(detallePelicula);
        this.container.add(cartelera);
        this.container.add(selectPelicula);
        this.container.add(boleteria);
        this.container.add(compraPrincipal);
        this.container.add(seleccionarAsientos);
        this.container.add(resumenCompra);
        this.container.add(agradecimiento);
    }
    
   
    public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getPuestos() {
		return puestos;
	}

	public void setPuestos(String puestos) {
		this.puestos = puestos;
	}

	public String getTotal() {
		return total;
	}


	public void setTotal(String total) {
		this.total = total;
	}


	public String getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}

	public String getIva() {
		return iva;
	}

	public void setIva(String iva) {
		this.iva = iva;
	}

	public boolean getActivador2() {
		return activador2;
	}

	public void setActivador2(boolean activador2) {
		this.activador2 = activador2;
	}

	public boolean getActivador() {
		return activador;
	}

	public void setActivador(boolean activador) {
		this.activador = activador;
	}

    public void changeCartelera() {
        cargarPanel(this.cartelera);
    }

    public void changeBoleteria() {
        cargarPanel(this.boleteria);
    }

    public void changeSelectPelicula() {
        cargarPanel(this.selectPelicula);
    }

    public void changeDetallePelicula() {
        cargarPanel(this.detallePelicula);
    }

    private void cargarPanel(CustomPanel customPanel){
        if(this.actPanel!=null){
            this.actPanel.setVisible(false);
            this.actPanel.descargadata();
        }

        this.actPanel=customPanel;
        this.actPanel.setVisible(true);
        this.actPanel.cargardata();

    }

    public void changeCompraPrincipal() {
        cargarPanel(this.compraPrincipal);
    }

    public void changeSeleccionarAsientos() {
        cargarPanel(this.seleccionarAsientos);
    }

    public String getContador() {
        return contador;
    }

    public void setContador(String contador) {
        this.contador = contador;
    }


    public void changeResumenCompra() {
        cargarPanel(this.resumenCompra);
    }


    public void changeAgradecimiento() {
        cargarPanel(this.agradecimiento);
    }

    public String getNombre () {
    	return this.nombre;
    }
    public void setNombre(String nombre) {
    	this.nombre=nombre;
    	
    }
    

}