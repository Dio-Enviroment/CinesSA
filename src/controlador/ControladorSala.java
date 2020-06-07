package controlador;

import java.util.ArrayList;

import modelo.Asiento;
import modelo.Sala;

public class ControladorSala {

	private Sala actSala;
	private ArrayList<Asiento> salaPre = new ArrayList<Asiento>();

	public Sala getSala(int id) {
		return actSala;
	}

	public void setSala(Sala sala) {
		this.actSala =sala;
	}

	public int getLimiteBoletos() {
		return actSala.getAsientosDisponibles();
	}

	public void restarAsientosDisponibles() {
		actSala.restarAsientosDisponibles();
	}

	public void anadirSalaPre(int valorx, int valory) {
		salaPre.add(new Asiento(valorx,valory));
	}
	public ArrayList<Asiento> getSalaPre() {
		return salaPre;
	}

	public void vaciarSeleccionados(int valorx, int valory) {
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
	}

	public void vaciarAsiento(int id, int numFil, int numCol) {
		actSala.vaciarAsiento(numFil, numCol);
	}
}