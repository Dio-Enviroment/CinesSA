package controlador;

import java.util.ArrayList;

import modelo.Conferencia;
import modelo.Pelicula;
import modelo.Proyeccion;
import modelo.Sala;
import data.*;

public class ControladorProyeccion {
    private ArrayList<Proyeccion> proyecciones=new ArrayList<Proyeccion>();
    private Proyeccion actProyeccion;
    private Proyeccion preProyeccion;
    private Proyeccion selectProyeccion;


    public ControladorProyeccion() {
        int cont=0;
        for (Peliculas pelicula : Peliculas.values()) {
            String horas=pelicula.getHorario();
            ArrayList<Sala> salas=new ArrayList<Sala>();
            for (int i = 0; i < horas.length(); i++) {
                salas.add(new Sala(cont, pelicula.getSalaTipo(), calcDimencion(5, 8), calcDimencion(5, 8)));
                cont++;
            }
            proyecciones.add(new Pelicula(pelicula.getBoleteria_back(),pelicula.getBoleteria_front(),pelicula.getBoleteria_title(),pelicula.getCartelera_back(),pelicula.getCartelera_front(),pelicula.getCartelera_title(),pelicula.getLeyenda(),pelicula.getMin(),pelicula.getMax(),pelicula.getXfront(),pelicula.getYfront(),pelicula.getXtitulo(),pelicula.getYtitulo(),pelicula.getXleyenda(),pelicula.getYleyenda(),pelicula.getTitulo(), pelicula.getDuracion(), pelicula.getHorario(),pelicula.getGenero(),pelicula.getEdad(),pelicula.getSinapsis(),pelicula.getSalaTipo(),salas));
        }
        
        for (Conferencias conferencia : Conferencias.values()) {
            Sala sala=new Sala(cont, conferencia.getSalaTipo(), calcDimencion(5, 8), calcDimencion(5, 8));
            cont++;
            proyecciones.add(new Conferencia(conferencia.getBoleteria_back(),conferencia.getBoleteria_front(),conferencia.getBoleteria_title(),conferencia.getCartelera_back(),conferencia.getCartelera_front(),conferencia.getCartelera_title(),conferencia.getLeyenda(),conferencia.getMin(),conferencia.getMax(),conferencia.getXfront(),conferencia.getYfront(),conferencia.getXtitulo(),conferencia.getYtitulo(),conferencia.getXleyenda(),conferencia.getYleyenda(),conferencia.getTitulo(), conferencia.getDuracion(), conferencia.getHorario(),conferencia.getPresentador(),conferencia.getTematica(),conferencia.getSalaTipo(),sala));
        }
    }

    private int calcDimencion(int min, int max) {
		return (int) Math.floor(Math.random() * (max - min) + min);
	}

    public ArrayList<Proyeccion> getProyeccions() {
        return proyecciones;
    }

    public void setActProyeccion(int num) {
        this.actProyeccion=proyecciones.get(num);
    }

    public void setActProyeccion(Proyeccion proyeccion) {
        this.actProyeccion=proyeccion;
    }

    public Proyeccion getActProyeccion() {
        return actProyeccion;
    }

    public void setPreproyeccion(Proyeccion proyeccion){
        this.preProyeccion=proyeccion;
    }

    public Proyeccion getPreproyeccion(){
        return preProyeccion;
    }

    public void setSelectProyeccion(Proyeccion proyeccion){
        this.selectProyeccion=proyeccion;
    }

    public Proyeccion getSelectProyeccion(){
        return selectProyeccion;
    }
}