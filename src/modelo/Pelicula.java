package modelo;

import java.util.ArrayList;

public class Pelicula extends Proyeccion{
	private String genero;
	private int edad;
	private String sinapsis;
	private ArrayList<Sala> salas;
	public Pelicula(String boleteria_back,String boleteria_front,String boleteria_title,String cartelera_back,String cartelera_front,String cartelera_title,String leyenda,String min,String max,int xfront,int yfront,int xtitulo,int ytitulo,int xleyenda,int yleyenda,String titulo,String duracion,String horario, String genero, int edad, String sinapsis,String salaTipo,ArrayList<Sala> salas) {
		super(boleteria_back,boleteria_front,boleteria_title,cartelera_back,cartelera_front,cartelera_title,leyenda,min,max,xfront,yfront,xtitulo,ytitulo,xleyenda,yleyenda,titulo,duracion,horario,salaTipo);
		this.genero = genero;
		this.edad = edad;
		this.sinapsis = sinapsis;
		this.salas=salas;
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

	public ArrayList<Sala> getSalas(){
		return salas;
	}
}
