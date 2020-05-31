package modelo;
public class Sala {
	private int id;
	private String tipo;
	private boolean[][] asientos;
	private int asientosDisponibles;

	public Sala(int id, String tipo,int numFil,int numCol) {
		this.id = id;
		this.tipo = tipo;
		this.asientos=new boolean[numFil][numCol];
		this.asientosDisponibles=numFil*numCol;
		generarAsientos();
	}

	public int getAsientosDisponibles() {
		return asientosDisponibles;
	}

	public void restarAsientosDisponibles() {
		this.asientosDisponibles--;
	}

	public boolean[][] getAsientos() {
		return asientos;
	}

	private void generarAsientos(){
		for (int j = 0; j < asientos.length; j++) {
			for (int j2 = 0; j2 < asientos[j].length; j2++) {
				asientos[j][j2] = false;
			}
		}
	}

	public void vaciarAsiento(int numFil, int numCol){
		asientos[numCol][numFil]=false;
	}

	public void ocuparAsiento(int numFil, int numCol){
		asientos[numCol][numFil]=true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
}
