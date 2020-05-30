package modelo;


//import Controlador.Excepcion;

public class Cliente {

	public String tituloPelicula;
	public String sala;
	public String boletos;
	public String asientos;
	public String total;
	public String cedula;
	public String nombre;
	public String telefono;
	public String direccion;

	

	private Object[] datos = {tituloPelicula,sala,boletos,asientos,total,cedula, nombre,telefono,direccion};
	
	public void llenarDatos(Object[]  new_datos) {
		this.datos=new_datos;
	}
	public Object getDatos(int pos) {
		return datos[pos];
	}
	public Object[] getDatosCliente() {
		return datos;
	}

	// public boolean ValidarCampos(Object[] campos) throws Excepcion {
	// 	boolean estado=true;
	// 	for (int i = 5; i < campos.length; i++) {
	// 		if (campos[i].toString().equals("")) {
	// 			estado=false;
	// 			throw new Excepcion("Todos los campos deben ser Ingresados");
	// 		}
			
	// 	}
	// 	if(campos[5].toString().length()<10 || campos[5].toString().length()>10) {
	// 		estado=false;
	// 		throw new Excepcion("Ingrese correctamente la cedula");
	// 	}
	// 	if(campos[7].toString().length()<10 || campos[7].toString().length()>10) {
	// 		estado=false;
	// 		throw new Excepcion("Ingrese correctamente su numero de celular");
	// 	}
	// 	return estado;
	// }
	
	
	
}