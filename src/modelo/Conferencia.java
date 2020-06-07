package modelo;

public class Conferencia extends Proyeccion {
	private String presentador;
	private String tematica;
	private String salaTipo;
	private Sala sala;
	private String descripcion;

	public Conferencia(String boleteria_back,String boleteria_front,String boleteria_title,String cartelera_back,String descripcion_blur,String min,String max, String titulo, String duracion, String horario, String presentador,String tematica,String salaTipo,Sala sala, String descripcion) {
		super(boleteria_back, boleteria_front, boleteria_title,cartelera_back,descripcion_blur,min,max, titulo, duracion, horario, salaTipo);
		this.presentador = presentador;
		this.tematica = tematica;
		this.salaTipo=salaTipo;
		this.sala=sala;
		this.descripcion=descripcion;
	}

	
	public void setDescripcion(String descripcion) {
		this.descripcion=descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getPresentador() {
		return presentador;
	}

	public Sala getSala() {
		return sala;
	}

	public void setPresentador(String presentador) {
		this.presentador = presentador;
	}

	public String getTematica() {
		return tematica;
	}

	public void setTematica(String tematica) {
		this.tematica = tematica;
	}
	public String getSalaTipo() {
		return salaTipo;
	}

	public void setSalaTipo(String salaTipo) {
		this.salaTipo = salaTipo;
	}
}
