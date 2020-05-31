package modelo;

public class Boleto {
	Cliente cliente;
	Proyeccion proyeccion;
	Asiento asiento;

	public Boleto(Cliente cliente,Proyeccion proyeccion,Asiento asiento){
		this.cliente=cliente;
		this.proyeccion=proyeccion;
		this.asiento=asiento;
	}
	
}
