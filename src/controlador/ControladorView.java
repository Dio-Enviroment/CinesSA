package controlador;

import javax.swing.JFrame;
import javax.swing.JPanel;



import java.awt.BorderLayout;
import vista.*;

public class ControladorView {
    private JFrame container;
    private JPanel actPanel;
    private Cartelera cartelera;
    private Boleteria boleteria;
    private SelectPelicula selectPelicula;
    private DetallePelicula detallePelicula;
    private CompraPrincipal compraPrincipal;
    private SeleccionarAsientos seleccionarAsientos;
    private ResumenCompra resumenCompra;
    private Agradecimiento agradecimiento;
    private String contador;
    
    
    public ControladorView(JFrame container,ControladorSala ctrSala,ControladorProyeccion ctrProyeccion, ControladorBoleto ctrBoleto){
        this.container=container;
        this.cartelera=new Cartelera(1008,729,ctrProyeccion,this);
        this.selectPelicula=new SelectPelicula(1008, 729,ctrProyeccion,this);
        this.selectPelicula.setBounds(10, 10, 500, 500);
        this.boleteria=new Boleteria(1008, 729,ctrProyeccion,this);
        this.compraPrincipal=new CompraPrincipal(1008, 729,ctrProyeccion, ctrSala, this);
        // this.detallePelicula=new DetallePelicula(1008, 729,ctrProyeccion,this);
        this.seleccionarAsientos=new SeleccionarAsientos(1008, 729,ctrSala,this);
        // this.resumenCompra=new ResumenCompra(1008, 729,ctrBoleto,this);
        // this.agradecimiento=new Agradecimiento(1008, 729,ctrBoleto,this);
    }

    //a
    private void clean(){
        if (this.actPanel!=null) {
            this.actPanel.removeAll();
            this.container.remove(this.actPanel);
        }
    }

    private void repaint(){
        this.container.getContentPane().add(this.actPanel);
        this.container.validate();
    }


    public void changeCartelera() {
        //clean();
        if (this.actPanel!=null) {
            this.actPanel.setVisible(false);
        }
        this.actPanel=this.cartelera;
        this.actPanel.setVisible(true);
        repaint();
    }

    public void changeBoleteria() {
        //clean();
        this.actPanel.setVisible(false);
        this.actPanel=this.boleteria;
        this.actPanel.setVisible(true);
        repaint();
    }

    public void changeSelectPelicula() {
        //clean();
        this.actPanel=this.selectPelicula;
        //repaint();
    }

    // public void changeDetallePelicula() {
        // clean();
        // this.actPanel=this.detallePelicula;
        // repaint();
    // }

    public void changeCompraPrincipal() {
        //clean();
        this.actPanel=this.compraPrincipal;
        this.compraPrincipal.init();;
        //repaint();
        //CompraPrincipal c=(CompraPrincipal)this.actPanel;
        //c.init();
    }

    public void changeSeleccionarAsientos() {
        //clean();
        this.actPanel=this.seleccionarAsientos;
        //repaint();
        this.seleccionarAsientos.ini();
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