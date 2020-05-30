package controlador;

import java.util.ArrayList;

import modelo.Conferencia;
import modelo.Pelicula;
import modelo.Proyeccion;
import data.*;

public class ControladorProyeccion {
    private ArrayList<Proyeccion> proyecciones=new ArrayList<Proyeccion>();
    private Proyeccion actProyeccion;

    public ControladorProyeccion() {
        for (Peliculas pelicula : Peliculas.values()) {
            proyecciones.add(new Pelicula(pelicula.getBoleteria_back(),pelicula.getBoleteria_front(),pelicula.getBoleteria_title(),pelicula.getTitulo(), pelicula.getDuracion(), pelicula.getHorario(),pelicula.getGenero(),pelicula.getCensura(),pelicula.getSinapsis(),pelicula.getSalaTipo()));
        }
        
        for (Conferencias conferencia : Conferencias.values()) {
            proyecciones.add(new Conferencia(conferencia.getBoleteria_back(),conferencia.getBoleteria_front(),conferencia.getBoleteria_title(),conferencia.getTitulo(), conferencia.getDuracion(), conferencia.getHorario(),conferencia.getPresentador(),conferencia.getTematica(),conferencia.getSalaTipo()));
        }
    }

    public void setActProyeccion(int num) {
        this.actProyeccion=proyecciones.get(num);
    }

    public Proyeccion getActProyeccion() {
        return actProyeccion;
    }
}