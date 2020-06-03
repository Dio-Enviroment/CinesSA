package controlador;

import java.util.ArrayList;

import modelo.Asiento;
import modelo.Sala;
import data.*;

public class ControladorSala {

	//private ArrayList<Sala> salas = new ArrayList<Sala>();
	// private Conferencias[] conferencias = Conferencias.values();
	// private Peliculas[] peliculas = Peliculas.values();
	// private int numSalasPelicula = conferencias.length;
	// private int numSalasConferencia = peliculas.length;
	private Sala actSala;
	private ArrayList<Asiento> salaPre = new ArrayList<Asiento>();

	//public ControladorSala() {
		//generarSalas();
		//setSala(0);
	//}

	public Sala getSala(int id) {
		return actSala;
		//return salas.get(id);
	}

	public void setSala(Sala sala) {
		//this.actSala = getSala(id);
		this.actSala =sala;
	}

	public int getLimiteBoletos() {
		return actSala.getAsientosDisponibles();
	}

	public void restarAsientosDisponibles() {
		actSala.restarAsientosDisponibles();
	}

	// public void generarSalas() {
	// 	int cont = 0;

	// 	for (int i = 0; i < numSalasPelicula; i++) {
	// 		Peliculas pelicula = peliculas[i];
	// 		String[] horas=pelicula.getHorario().split("-");
	// 		for (int j = 0; j < horas.length; j++) {
	// 			salas.add(new Sala(cont, pelicula.getSalaTipo(), calcDimencion(5, 8), calcDimencion(5, 8)));
	// 		}
	// 		cont++;
	// 	}

	// 	for (int i = 0; i < numSalasConferencia; i++) {
	// 		Conferencias conferencia = conferencias[i];
	// 		salas.add(new Sala(cont, conferencia.getSalaTipo(), calcDimencion(5, 8), calcDimencion(5, 8)));
	// 		cont++;
	// 	}
	// 	cont--;
	// }

	public void anadirSalaPre(int valorx, int valory) {
		salaPre.add(new Asiento(valorx,valory));
	}
	public ArrayList<Asiento> getSalaPre() {
		return salaPre;
	}

	public void vaciarSeleccionados(int valorx, int valory) {
		//salaPre[valorx][valory]=false;
		
		for (Asiento asiento : salaPre) {
			if (asiento.getFila()==valorx && asiento.getColumna()==valory) {
				salaPre.remove(asiento);
				break;
			}
		}
	}

	public void vaciarTodos(){
		salaPre.clear();
	}

	public void ocuparAsiento(int id, int numFil, int numCol) {
		actSala.ocuparAsiento(numFil, numCol);
		//salas.get(id).ocuparAsiento(numFil, numCol);
	}

	public void vaciarAsiento(int id, int numFil, int numCol) {
		actSala.vaciarAsiento(numFil, numCol);
		//salas.get(id).vaciarAsiento(numFil, numCol);
	}

	// private int calcDimencion(int min, int max) {
	// 	return (int) Math.floor(Math.random() * (max - min) + min);
	// }
	// getNumSala () numero de la sala de la pelicula

}