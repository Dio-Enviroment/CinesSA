package modelo;

public class Pelicula extends Proyeccion{
	private String genero;
	private int edad;
	private String sinapsis;
	public Pelicula(String boleteria_back,String boleteria_front,String boleteria_title,String titulo,String duracion,String horario, String genero, int edad, String sinapsis,String salaTipo) {
		super(boleteria_back,boleteria_front,boleteria_title,titulo,duracion,horario,salaTipo);
		this.genero = genero;
		this.edad = edad;
		this.sinapsis = sinapsis;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getEdad() {
		return edad;
	}
	public void setCensura(int edad) {
		this.edad = edad;
	}
	public String getSinapsis() {
		return sinapsis;
	}
	public void setSinapsis(String sinapsis) {
		this.sinapsis = sinapsis;
	}
}
