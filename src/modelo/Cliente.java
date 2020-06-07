package modelo;

import controlador.Excepcion;

public class Cliente {

	
	private String cedula= "";
	private String nombre= "";
	private String telefono= "";
	private String direccion= "";

	

	private Object[] datos = {cedula, nombre,telefono,direccion};
	
	public void llenarDatos(Object[]  new_datos) {
		this.datos=new_datos;
	}
	public Object getDatos(int pos) {
		return datos[pos];
	}
	public Object[] getDatosCliente() {
		return datos;
	}

	 public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public boolean ValidarCampos(Object[] campos) throws Excepcion {
	 	boolean estado=true;
	 	for (int i = 0; i < campos.length; i++) {
	 		if (campos[i].toString().equals("")) {
				estado=false;
 			throw new Excepcion("Campo Requerido");
	 		}
			
	 	}
	 	if(campos[0].toString().length()<10 || campos[0].toString().length()>10) {
	 		estado=false;
	 		throw new Excepcion("Cedula Incorrecta");
	 	}
	 	if(campos[2].toString().length()<10 || campos[2].toString().length()>10) {
	 		estado=false;
	 		throw new Excepcion("Telefono Incorrecto");
	 	}
		return estado;
	 }
	 
	
	
}