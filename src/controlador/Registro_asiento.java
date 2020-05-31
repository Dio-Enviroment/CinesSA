package Controlador;

import java.util.ArrayList;

public class Registro_asiento {

	private ArrayList<Integer[][]> salas = new ArrayList<Integer[][]>();

	public Registro_asiento() {
		salas = new ArrayList<Integer[][]>();
	}

	private Integer[][] sala1 = new Integer[8][7];
	private Integer[][] sala2 = new Integer[7][8];
	private Integer[][] sala3 = new Integer[6][7];
	private Integer[][] sala4 = new Integer[6][6];
	private Integer[][] sala5 = new Integer[5][7];
	private Integer[][] sala6 = new Integer[8][8];
	private Integer[][] sala7 = new Integer[7][5];
	private Integer[][] sala8 = new Integer[5][5];
	private Integer[][] sala9 = new Integer[7][5];
	private Integer[][] sala10 = new Integer[8][7];

	public void añadirSalas() {
		salas.add(llenar(sala1));
		salas.add(llenar(sala2));
		salas.add(llenar(sala3));
		salas.add(llenar(sala4));
		salas.add(llenar(sala5));
		salas.add(llenar(sala6));
		salas.add(llenar(sala7));
		salas.add(llenar(sala8));
		salas.add(llenar(sala9));
		salas.add(llenar(sala10));
	}

	// ********** Metodo provisional para imprimir y verificar *****************
	public void imprimir(int num_sala) {
		ArrayList<Integer[][]> sala = new ArrayList<Integer[][]>();
		sala = getSala();
		for (int i = 0; i < sala.size(); i++) {
			if( i+1 == num_sala) {
				for (int j = 0; j < sala.get(i).length; j++) {
					for (int j2 = 0; j2 < sala.get(i)[j].length; j2++) {
						System.out.print(sala.get(i)[j][j2]);
					}
					System.out.println();
				}
				System.out.println();
			}
		}
	}

	public ArrayList<Integer[][]> getSala() {
		return salas;
	}

	// ********** LLenar las salas con elementos vacios ***************
	

	/*public static Integer[][] ocuparLl(Integer sala[][]) {
		for (int j = 0; j < sala.length; j++) {
			for (int j2 = 0; j2 < sala[j].length; j2++) {
				sala[j][j2] = 1;
			}
		}
		return sala;
	}*/
	
	
	public static Integer[][] llenar(Integer sala[][]) {
		for (int j = 0; j < sala.length; j++) {
			for (int j2 = 0; j2 < sala[j].length; j2++) {
				sala[j][j2] = 0;
			}
		}
		return sala;
	}
	// ************ Metodo para ocupar asientos *******************
	// n == fila {A,B,C ----- } m == columna{1,2,3 ....}

	public void OcuparAsiento(int num_sala, int n, int m) {
		ArrayList<Integer[][]> sala = new ArrayList<Integer[][]>();
		sala = getSala();
		for (int i = 0; i < sala.size(); i++) {
			if (i + 1 == num_sala) {
				if (sala.get(i)[m][n] != 1) {
					sala.get(i)[m][n] = 1;
				}
			}
		}
	}

	public void VaciarAsiento(int num_sala, int n, int m) {
		ArrayList<Integer[][]> sala = new ArrayList<Integer[][]>();
		sala = getSala();
		for (int i = 0; i < sala.size(); i++) {
			if (i + 1 == num_sala) {
				if (sala.get(i)[m][n] == 1) {
					sala.get(i)[m][n] = 0;
				}
			}
		}

	}

	public boolean VerificarSala(int num_sala) {
		ArrayList<Integer[][]> sala = new ArrayList<Integer[][]>();
		sala = getSala();
		for (int i = 0; i < sala.size(); i++) {
			if (num_sala == i + 1) {
				for (int j = 0; j < sala.get(i).length; j++) {
					for (int j2 = 0; j2 < sala.get(i)[j].length; j2++) {
						if (sala.get(i)[j][j2] == 0) {
							return true;
						}
					}
				}
			}

		}
		return false;
	}

	public int tamanioColumnas(int num_sala) {
		ArrayList<Integer[][]> sala = new ArrayList<Integer[][]>();
		sala = getSala();
		int n = 0;
		for (int i = 0; i < sala.size(); i++) {
			if (i + 1 == num_sala) {
				for (int j = 0; j < sala.get(i).length; j++) {
					n++;
				}
			}
		}
		return n;
	}

	public int tamanioFilas(int num_sala) {
		int m = 0;
		ArrayList<Integer[][]> sala = new ArrayList<Integer[][]>();
		sala = getSala();
		for (int i = 0; i < sala.size(); i++) {
			if (i + 1 == num_sala) {
				for (int j = 0; j < 1; j++) {
					for (int j2 = 0; j2 < sala.get(i)[j].length; j2++) {
						m++;
					}
				}
			}
		}

		return m;
	}
	
	public int boletosDisponibles(int num_sala) {
		int cont = 0;
		ArrayList<Integer[][]> sala = new ArrayList<Integer[][]>();
		sala = getSala();
		for (int i = 0; i < sala.size(); i++) {
			if (i + 1 == num_sala) {
				for (int j = 0; j < sala.get(i).length; j++) {
					for (int j2 = 0; j2 < sala.get(i)[j].length; j2++) {
						if(sala.get(i)[j][j2] != 1) {
							cont++;
						}
					}
				}
			}
		}
		return cont;
	}
	public int boletosTotales(int num_sala) {
		int m = tamanioFilas(num_sala);
		int n = tamanioColumnas(num_sala);
		
		return m*n;
	}
}