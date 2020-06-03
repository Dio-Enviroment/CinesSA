package modelo;
import java.io.File;
public class Proyeccion {
	
	
	// " Postters,titulo,duracion,horario(hh,mm);
	protected String [] atributos;
	protected String boleteria_back;
	protected String boleteria_front;
	protected String boleteria_title;
	protected String cartelera_back;
	protected String cartelera_front;
	protected String cartelera_title;
	protected String duracion;
	protected String[] horario;
	protected String hora;
	protected String titulo;
	protected String salaTipo;
	protected String tipoEvento;
	protected String min,max;
	private String leyenda;
	protected int xfront,yfront;
	protected int xtitulo,ytitulo;
	protected int xleyenda,yleyenda;
	protected File workingDirectory = new File(System.getProperty("user.dir"));
	public Proyeccion(String boleteria_back,String boleteria_front,String boleteria_title,String cartelera_back,String cartelera_front,String cartelera_title,String leyenda,String min,String max,int xfront,int yfront,int xtitulo,int ytitulo,int xleyenda,int yleyenda,String titulo,String duracion, String horario,String salaTipo) {
		this.boleteria_back=workingDirectory+boleteria_back;
		this.boleteria_front=workingDirectory+boleteria_front;
		this.boleteria_title=workingDirectory+boleteria_title;
		this.cartelera_back=workingDirectory+cartelera_back;
		this.cartelera_front=workingDirectory+cartelera_front;
		this.cartelera_title=workingDirectory+cartelera_title;
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
		this.leyenda=workingDirectory+leyenda;
		this.min=workingDirectory+min;
		this.max=workingDirectory+max;
	}

	public String getCarteleraBack() {
		return this.cartelera_back;
	}

	public String getCarteleraFront() {
		return this.cartelera_front;
	}

	public String getCarteleraTitle() {
		return this.cartelera_title;
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

	public String getLeyenda() {
		return leyenda;
	}

	public String getMin() {
		return min;
	}

	public String getMax() {
		return max;
	}
}
