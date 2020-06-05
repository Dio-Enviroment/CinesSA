package controlador;

import java.util.ArrayList;

import javax.swing.JTextField;

import modelo.Asiento;
import modelo.Boleto;
import modelo.Proyeccion;
import modelo.Cliente;

public class ControladorBoleto {
    private ArrayList<Boleto> boletos=new ArrayList<Boleto>();
    private Cliente cliente= new Cliente();
    

    public ControladorBoleto() {
        
    }
    public Cliente getCliente() {
    	return cliente;
    }



    public void addBoleto(Cliente cliente,Proyeccion proyeccion, Asiento asiento){
        boletos.add(new Boleto(cliente,proyeccion, asiento));
        
    }

    public ArrayList<Boleto> getBoletos() {
        return boletos;
    }
    //getBoletos () numero totales de bolestos de cada sala
   
	
    

}