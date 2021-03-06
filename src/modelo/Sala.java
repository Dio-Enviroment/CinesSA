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
		for (int i = 0; i < asientos.length; i++) {
			for (int j = 0; j < asientos[i].length; j++) {
				asientos[i][j] = false;
			}
		}
	}

	public void vaciarAsiento(int numFil, int numCol){
		asientos[numFil][numCol]=false;
	}

	public void ocuparAsiento(int numFil, int numCol){
		asientos[numFil][numCol]=true;
	}

	public boolean getAsiento(int numFil, int numCol) {
		return asientos[numFil][numCol];
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

	public int verificarNumAsiento(){
		int num=0;
		for (int i = 0; i < asientos.length; i++) {
			for (int j = 0; j < asientos[i].length; j++) {
				if (!asientos[i][j]) {
					num++;
				}
			}
		}
		return num;
	}
	
}
