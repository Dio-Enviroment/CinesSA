package controlador;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ControladorPrincipal {
    private ControladorSala ctrSala;
    private ControladorProyeccion ctrProyeccion;
    private ControladorBoleto ctrBoleto;
    private ControladorView ctrView;

    public ControladorPrincipal(JFrame container) {
        this.ctrSala = new ControladorSala();
        this.ctrProyeccion = new ControladorProyeccion();
        this.ctrBoleto = new ControladorBoleto();
        this.ctrView=new ControladorView(container,this.ctrSala,this.ctrProyeccion,this.ctrBoleto);
    }

    public ControladorSala getCtlSala() {
        return ctrSala;
    }

    public ControladorProyeccion getCtlProyeccion() {
        return ctrProyeccion;
    }

    public ControladorBoleto getCtlBoleto() {
        return ctrBoleto;
    }

    public ControladorView getCtrView() {
        return ctrView;
    }
}