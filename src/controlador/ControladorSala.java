package controlador;

import java.util.ArrayList;
import java.util.Stack;

import modelo.Asiento;
import modelo.Boleto;
import modelo.Proyeccion;
import modelo.Sala;
import data.*;

public class ControladorSala {

	private ArrayList<Sala> salas = new ArrayList<Sala>();
	private Conferencias[] conferencias = Conferencias.values();
	private Peliculas[] peliculas = Peliculas.values();
	private int numSalasPelicula = conferencias.length;
	private int numSalasConferencia = peliculas.length;
	private Sala actSala;
	private ArrayList<Asiento> salaPre = new ArrayList<Asiento>();

	public ControladorSala() {
		generarSalas();
		setSala(0);
	}

	public Sala getSala(int id) {
		return salas.get(id);
	}

	public void setSala(int id) {
		this.actSala = getSala(id);
	}

	public int getLimiteBoletos() {
		return actSala.getAsientosDisponibles();
	}

	public void restarAsientosDisponibles() {
		actSala.restarAsientosDisponibles();
	}

	public void generarSalas() {
		int cont = 0;

		for (int i = 0; i < numSalasPelicula; i++) {
			Peliculas pelicula = peliculas[i];
			// for (int j = 0; j < peliculas.horario; j++) {
			salas.add(new Sala(cont, pelicula.getSalaTipo(), calcDimencion(5, 8), calcDimencion(5, 8)));
			// }
			cont++;
		}

		for (int i = 0; i < numSalasConferencia; i++) {
			Conferencias conferencia = conferencias[i];
			salas.add(new Sala(cont, conferencia.getSalaTipo(), calcDimencion(5, 8), calcDimencion(5, 8)));
			cont++;
		}
		cont--;
	}

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
		System.out.println(salaPre.size());
	}

	public void ocuparAsiento(int id, int numFil, int numCol) {
		salas.get(id).ocuparAsiento(numFil, numCol);
	}

	public void vaciarAsiento(int id, int numFil, int numCol) {
		salas.get(id).vaciarAsiento(numFil, numCol);
	}

	private int calcDimencion(int min, int max) {
		return (int) Math.floor(Math.random() * (max - min) + min);
	}
	// getNumSala () numero de la sala de la pelicula

}