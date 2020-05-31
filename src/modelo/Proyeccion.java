package modelo;

public class Proyeccion {
	
	
	// " Postters,titulo,duracion,horario(hh,mm);
	protected String [] atributos;
	protected String boleteria_back;
	protected String boleteria_front;
	protected String boleteria_title;
	protected String duracion;
	protected String horario;
	protected String titulo;
	protected String salaTipo;
	public Proyeccion(String boleteria_back,String boleteria_front,String boleteria_title,String titulo,String duracion, String horario,String salaTipo) {
		this.boleteria_back=boleteria_back;
		this.boleteria_front=boleteria_front;
		this.boleteria_title=boleteria_title;
		this.duracion=duracion;
		this.horario=horario;
		this.titulo=titulo;
		this.salaTipo=salaTipo;
	}
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String[] getAtributos() {
		return this.atributos;
	}

	public void setAtributos(String[] atributos) {
		this.atributos = atributos;
	}

	public int getDuracion() {
		return this.duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	public String getSalaTipo() {
		return salaTipo;
	}

	public void setSalaTipo(String salaTipo) {
		this.salaTipo = salaTipo;
	}
}
