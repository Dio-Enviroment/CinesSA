package controlador;

import java.util.ArrayList;

import modelo.Asiento;
import modelo.Boleto;
import modelo.Proyeccion;
import modelo.Cliente;

public class ControladorBoleto {
    private ArrayList<Boleto> boletos=new ArrayList<Boleto>();

    public void addBoleto(Cliente cliente,Proyeccion proyeccion, Asiento asiento){
        boletos.add(new Boleto(cliente,proyeccion, asiento));
    }
    //getBoletos () numero totales de bolestos de cada sala
}