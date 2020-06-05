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
    private String total="0";
	private String subtotal="0";
	private String iva="0";
	private String puestos="0";
	private String contador;

    public String getContador() {
		return contador;
	}
	public void setContador(String contador) {
		this.contador = contador;
	}
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
	public String getPuestos() {
		return puestos;
	}
	public void setPuestos(String puestos) {
		this.puestos = puestos;
	}
   
	
    

}