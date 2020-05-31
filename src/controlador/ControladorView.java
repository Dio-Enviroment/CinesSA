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
    private DetallePelicula detallePelicula;
    private CustomPanel compraPrincipal;
    private CustomPanel seleccionarAsientos;
    private ResumenCompra resumenCompra;
    private Agradecimiento agradecimiento;
    private String contador;
    private boolean activador;
    private boolean activador2;
    private boolean inicompraPrincipal=true;
    
    
    public ControladorView(JPanel container,ControladorSala ctrSala,ControladorProyeccion ctrProyeccion, ControladorBoleto ctrBoleto){
        this.container=container;
        this.cartelera=new Cartelera(1008,729,ctrProyeccion,this);
        this.selectPelicula=new SelectPelicula(1008, 729,ctrProyeccion,this);
        this.boleteria=new Boleteria(1008, 729,ctrProyeccion,this);
        this.compraPrincipal=new CompraPrincipal(1008, 729,ctrProyeccion, ctrSala, this);
        // this.detallePelicula=new DetallePelicula(1008, 729,ctrProyeccion,this);
        this.seleccionarAsientos=new SeleccionarAsientos(1008, 729,ctrSala,this);
        // this.resumenCompra=new ResumenCompra(1008, 729,ctrBoleto,this);
        // this.agradecimiento=new Agradecimiento(1008, 729,ctrBoleto,this);

        this.container.add(cartelera);
        this.container.add(selectPelicula);
        this.container.add(boleteria);
        this.container.add(compraPrincipal);
        this.container.add(seleccionarAsientos);
    }

    //a
    
    
    
    private void clean(){
        if (this.actPanel!=null) {
            this.actPanel.removeAll();
            this.container.remove(this.actPanel);
        }
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

	private void repaint(){
        
    }


    public void changeCartelera() {
        //clean();
        // if (this.actPanel!=null) {
        //     this.actPanel.showcomponet(false);
        //     this.actPanel.descargadata();
        // }
        // this.actPanel=this.cartelera;
        // this.actPanel.cargardata();
        // this.actPanel.showcomponet(true);
        // repaint();

        cargarPanel(this.cartelera);
    }

    public void changeBoleteria() {
        //clean();
        // this.actPanel.showcomponet(false);
        // this.actPanel.descargadata();

        cargarPanel(this.boleteria);
        // this.actPanel=this.boleteria;
        // this.actPanel.cargardata();
        // this.actPanel.showcomponet(true);
        // this.actPanel.showcomponet(true);
        // repaint();
    }

    public void changeSelectPelicula() {
        //clean();

        cargarPanel(this.selectPelicula);
        // this.actPanel.showcomponet(false);
        // this.actPanel.descargadata();

        // this.actPanel=this.selectPelicula;
        // this.actPanel.cargardata();
        // this.actPanel.showcomponet(true);
        // this.actPanel.showcomponet(true);
        // repaint();
    }

    // public void changeDetallePelicula() {
        // clean();
        // this.actPanel=this.detallePelicula;
        // repaint();
    // }

    private void cargarPanel(CustomPanel customPanel){
        if(this.actPanel!=null){
            this.actPanel.descargadata();
            //this.container.remove(this.actPanel);
            //this.actPanel.removeAll();
            //this.container.validate();
            this.actPanel.setVisible(false);
        }

        this.actPanel=customPanel;
        //this.actPanel.showcomponet(true);
        this.actPanel.setVisible(true);
        this.actPanel.cargardata();
        //this.actPanel.showcomponet(true);ss
        //this.container.add(this.actPanel);
        //this.container.getContentPane().add(this.actPanel);
        //this.container.validate();
    }

    public void changeCompraPrincipal() {
        //clean();
        // this.actPanel.showcomponet(false);
        // this.actPanel.descargadata();

        cargarPanel(this.compraPrincipal);
        // this.actPanel=
        // this.actPanel.cargardata();
        // this.actPanel.showcomponet(true);
        // this.actPanel.showcomponet(true);
        // repaint();
        //CompraPrincipal c=(CompraPrincipal)this.actPanel;
        //c.init();
    }

    public void changeSeleccionarAsientos() {
        //clean();

        cargarPanel(this.seleccionarAsientos);
        // this.actPanel.setVisible(false);
        // this.actPanel=this.seleccionarAsientos;
        // this.seleccionarAsientos.cargarData();
        // repaint();
    }

    public String getContador() {
        return contador;
    }

    public void setContador(String contador) {
        this.contador = contador;
    }


    // public void changeResumenCompra() {
        // clean();
        // this.actPanel=this.resumenCompra;
        // repaint();
    // }


    // public void changeAgradecimiento() {
        // clean();
        // this.actPanel=this.agradecimiento;
        // repaint();
    // }
}