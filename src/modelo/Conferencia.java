package modelo;

public class Conferencia extends Proyeccion {
	private String presentador;
	private String tematica;
	private String salaTipo;

	public Conferencia(String boleteria_back,String boleteria_front,String boleteria_title,String cartelera_back,String cartelera_front,String cartelera_title,String leyenda,String min,String max,int xfront,int yfront,int xtitulo,int ytitulo,int xleyenda,int yleyenda, String titulo, String duracion, String horario, String presentador,String tematica,String salaTipo) {
		super(boleteria_back, boleteria_front, boleteria_title,cartelera_back,cartelera_front,cartelera_title,leyenda,min,max,xfront,yfront,xtitulo,ytitulo,xleyenda,yleyenda, titulo, duracion, horario, salaTipo);
		this.presentador = presentador;
		this.tematica = tematica;
		this.salaTipo=salaTipo;
	}

	public String getPresentador() {
		return presentador;
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
