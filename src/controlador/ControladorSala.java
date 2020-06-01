package controlador;

import java.util.ArrayList;
import java.util.Stack;

import modelo.Boleto;
import modelo.Sala;
import data.*;

public class ControladorSala {
    

    private ArrayList<Sala> salas=new ArrayList<Sala>();
    private Conferencias[] conferencias= Conferencias.values();
    private Peliculas[] peliculas= Peliculas.values();
    int numSalasPelicula=conferencias.length;
    int numSalasConferencia=peliculas.length;
    private Sala actSala;
    private Stack <Integer> salaPreview = new Stack <Integer>();
    public ControladorSala(){
        generarSalas();
        setSala(0);
    }

    public Sala getSala(int id){
        return salas.get(id);
    }

    public void setSala(int id){
        this.actSala=getSala(id);
    }

    public int getLimiteBoletos() {
        return actSala.getAsientosDisponibles();
    }

    public void restarAsientosDisponibles(){
        actSala.restarAsientosDisponibles();
    }

    public void generarSalas() {
        int cont=0;

        for (int i = 0; i < numSalasPelicula; i++) {
            Peliculas pelicula= peliculas[i];
            //for (int j = 0; j < peliculas.horario; j++) {
                salas.add(new Sala(cont, pelicula.getSalaTipo(),calcDimencion(5,8),calcDimencion(5,8)));
            //}
            cont++;
        }

        for (int i = 0; i < numSalasConferencia; i++) {
            Conferencias conferencia= conferencias[i];
            salas.add(new Sala(cont, conferencia.getSalaTipo(),calcDimencion(5,8),calcDimencion(5,8)));
            cont++;
        }
        cont--;
    }
    
    public void añadirSalaPre(int valor) {
    	salaPreview.push(valor);
    }
    
    
    
    
    public void vaciarSeleccionados() {
    	
    	boolean salaPre [][] = actSala.getAsientos();
    	for (int i = 0; i < salaPre.length; i++) {
			for (int j = 0; j < salaPre[i].length; j++) {
				if(salaPre[i][j] == true) {
					int fila = salaPreview.pop();
			    	int columna = salaPreview.pop();
			    	salaPre[fila][columna]=false;
				}
			}
		}
    }
    
    public void ocuparAsiento(int id,int numFil,int numCol){
        salas.get(id).ocuparAsiento(numFil,numCol);
    }

    public void vaciarAsiento(int id,int numFil,int numCol){
        salas.get(id).vaciarAsiento(numFil,numCol);
    }

    private int calcDimencion(int min, int max){
		return (int)Math.floor(Math.random() * (max - min) + min);
    }
    //getNumSala () numero de la sala de la pelicula

}