package modelo;
import java.io.File;
public class Proyeccion {
	
	
	// " Postters,titulo,duracion,horario(hh,mm);
	protected String [] atributos;
	protected String boleteria_back;
	protected String boleteria_front;
	protected String boleteria_title;
	protected String duracion;
	protected String[] horario;
	private String hora;
	protected String titulo;
	protected String salaTipo;
	private String tipoEvento;
	private File workingDirectory = new File(System.getProperty("user.dir"));
	public Proyeccion(String boleteria_back,String boleteria_front,String boleteria_title,String titulo,String duracion, String horario,String salaTipo) {
		this.boleteria_back=workingDirectory+boleteria_back;
		this.boleteria_front=workingDirectory+boleteria_front;
		this.boleteria_title=workingDirectory+boleteria_title;
		this.duracion=duracion;
		if (this instanceof Pelicula) {
			this.horario=horario.split("-");
		}
		else{
			this.horario=new String[1];
			this.horario[0]=horario;
		}
		this.titulo=titulo;
		this.salaTipo=salaTipo;
	}

	public String getBoleteriaBack() {
		return this.boleteria_back;
	}

	public String getBoleteriaFront() {
		return this.boleteria_front;
	}

	public String getBoleteriaTitle() {
		return this.boleteria_title;
	}

	public String getTitulo() {
		return this.titulo;
	}

	// public void setTitulo(String titulo) {
	// 	this.titulo = titulo;
	// }

	public String[] getAtributos() {
		return this.atributos;
	}

	// public void setAtributos(String[] atributos) {
	// 	this.atributos = atributos;
	// }

	public String getDuracion() {
		return this.duracion;
	}

	// public void setDuracion(String duracion) {
	// 	this.duracion = duracion;
	// }

	public String[] getHorario() {
		return horario;
	}

	
	public String getSalaTipo() {
		return salaTipo;
	}

	// public void setSalaTipo(String salaTipo) {
	// 	this.salaTipo = salaTipo;
	// }

	public void setHora(String hora) {
		this.hora=hora;
	}

	public String getHora() {
		return this.hora;
	}

	public void setTipoEvent(String tipoEvento) {
		this.tipoEvento=tipoEvento;
	}

	public String getTipoEvent() {
		return this.tipoEvento;
	}
}
