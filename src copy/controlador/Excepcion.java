package controlador;

public class Excepcion extends Exception {
	public static final long serialVersionUID = 7000L;
	public Excepcion(String msg) {
		super(msg);
	}
}
