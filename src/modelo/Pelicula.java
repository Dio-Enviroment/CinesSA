package modelo;

public class Pelicula extends Proyeccion{
	private String genero;
	private String censura;
	private String sinapsis;
	public Pelicula(String boleteria_back,String boleteria_front,String boleteria_title,String titulo,String duracion,String horario, String genero, String censura, String sinapsis) {
		super(boleteria_back,boleteria_front,boleteria_title,titulo,duracion,horario);
		this.genero = genero;
		this.censura = censura;
		this.sinapsis = sinapsis;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getCensura() {
		return censura;
	}
	public void setCensura(String censura) {
		this.censura = censura;
	}
	public String getSinapsis() {
		return sinapsis;
	}
	public void setSinapsis(String sinapsis) {
		this.sinapsis = sinapsis;
	}
}
