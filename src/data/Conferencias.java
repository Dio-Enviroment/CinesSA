package data;

public enum Conferencias {
	Conf_0("//src//img//peli_0_boleteria_back.png","//src//img//peli_0_boleteria_front.png","//src//img//peli_0_boleteria_titulo.png","EL DIA DEL MEDIO AMBIENTE Y EL DIA DEL METEOROLOGO",duracion(120),horarios(),"JIM CANTORES","CLIMATOLOGIA","imax"),
	Conf_1("//src//img//peli_0_boleteria_back.png","//src//img//peli_0_boleteria_front.png","//src//img//peli_0_boleteria_titulo.png","LIDERES DETERMINADOS",duracion(180),horarios(),"JHON C. MAXWELL","LIDERAZGO","normal"),
	Conf_2("//src//img//peli_0_boleteria_back.png","//src//img//peli_0_boleteria_front.png","//src//img//peli_0_boleteria_titulo.png","CONGRESO PSICOLOGIA EDUCATIVA NEUROCIENCIAS Y EMOCION",duracion(150),horarios(),"NATALIE PORTMAN","PSICOLOGIA","imax"),
	Conf_3("//src//img//peli_0_boleteria_back.png","//src//img//peli_0_boleteria_front.png","//src//img//peli_0_boleteria_titulo.png","CONGRESO",duracion(196),horarios(),"ISMAEL PASCUAL","POLITICA","normal"),
	Conf_4("//src//img//peli_0_boleteria_back.png","//src//img//peli_0_boleteria_front.png","//src//img//peli_0_boleteria_titulo.png","EDICACION CONTEPORANEA",duracion(175),horarios(),"MARIA DOLORES","CULTURA","imax"),
	Conf_5("//src//img//peli_0_boleteria_back.png","//src//img//peli_0_boleteria_front.png","//src//img//peli_0_boleteria_titulo.png","SEMANA DE INFORMATICA & SISTEMAS",duracion(230),horarios(),"PEDRO GOMEZ","TECNOLOGIA","normal"),
	Conf_6("//src//img//peli_0_boleteria_back.png","//src//img//peli_0_boleteria_front.png","//src//img//peli_0_boleteria_titulo.png","AUTOESTIMA Y PROYECTO DE VIDA",duracion(160),horarios(),"JAVIER GONZALES","PSICOLOGIA","imax"),
	Conf_7("//src//img//peli_0_boleteria_back.png","//src//img//peli_0_boleteria_front.png","//src//img//peli_0_boleteria_titulo.png","ARTES DE LA VIDA",duracion(293),horarios(),"LUCIA MUNOZ","ARTE","normal");

	private String titulo,duracion,horario,presentador,tematica,salaTipo;
	private String boleteria_back,boleteria_front,boleteria_title;
	
	Conferencias(String boleteria_back,String boleteria_front,String boleteria_title,String titulo, String duracion, String horario, String presentador, String tematica,String salaTipo) {
		this.boleteria_back=boleteria_back;
		this.boleteria_front=boleteria_front;
		this.boleteria_title=boleteria_title;
		this.titulo = titulo;
		this.duracion = duracion;
		this.horario = horario;
		this.presentador = presentador;
		this.tematica = tematica;
		this.salaTipo=salaTipo;
	}

	static String duracion(int min) { 
		String hora;
		int HH,MM;
		HH=min/60;
		MM=min%60;
		if (HH>=10) {
			if (MM==0) {
				hora=(HH+":"+MM+"0");
			}else {
				hora=(HH+":"+MM);
			}
			
		} else {
			if (MM==0) {
				hora=("0"+HH+":"+MM+"0");
			}else {
				hora=(HH+":"+MM);
			}
		}
		return hora;
	}

	final static String horarios() {
		final String [] horas = { "09:30","12:00","14:00","15:30","16:20","17:00","18:00","19:00","20:00"};
		int in=0;String d="Sin Horario";
		in=(int)(Math.random()*horas.length-1);
		d=horas[in];
		return d;
	}
	
	public String getBoleteria_back() {
		return boleteria_back;
	}

	public String getBoleteria_front() {
		return boleteria_front;
	}

	public String getBoleteria_title() {
		return boleteria_title;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDuracion() {
		return duracion;
	}

	public String getHorario() {
		return horario;
	}

	public String getPresentador() {
		return presentador;
	}

	public String getTematica() {
		return tematica;
	}

	public String getSalaTipo() {
		return salaTipo;
	}
	
}