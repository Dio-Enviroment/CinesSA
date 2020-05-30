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
	public String getPoster() {
		return proyeccion.getPoster();
	}
	public String getTitulo() {
		return proyeccion.getTitulo();
	}
	public int getDuracion() {
		return proyeccion.getDuracion();
	}

	public Asiento getAsiento() {
		return asiento;
	}
}
