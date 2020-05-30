package controlador;

import modelo.*;
import java.text.DecimalFormat;

public class Precio {
	public  double pelicula=5.60;
	public final  double conferencia=9.30;
	public final  double desN = 0.50;
	public final double PreImax = 0.20;
	public final double Iva = 0.12;
	DecimalFormat df = new DecimalFormat("#.00");
	
	public double  calculoT(double subtotal, double iva) {
		Total t = new Total();
		return  t.total(subtotal, iva);
	}
	public double  calculoI(double subtotal) {
		Iva t = new Iva();
		return  t.IVA(subtotal);
	}
	public double calculoS(int num_boletoA, int num_boletoN, ControladorProyeccion ctrProyeccion) {
		Subtotal t = new Subtotal();
		return t.subtotal(num_boletoA, num_boletoN, ctrProyeccion );
	}
	
	public class Total {
		public double total (double subtotal, double iva) {
			return subtotal+iva;
		}
		
		
	}
	public  class Iva{
		public double IVA(double subtotal) {
			return Iva *subtotal;
		}
	}
	public class Subtotal{
		
		public double subtotal(int num_boletoA, int num_boletoN, ControladorProyeccion ctrProyeccion) {
			Proyeccion actProyeccion= ctrProyeccion.getActProyeccion();
			if(actProyeccion instanceof Pelicula) {
				if(((Pelicula) actProyeccion).getSalaTipo().equals("normal")) 
				return (num_boletoA*pelicula)+(num_boletoN*(pelicula*desN));
				
						
				else {
					pelicula = (pelicula*PreImax)+pelicula;
					return (num_boletoA*pelicula)+(num_boletoN*(pelicula*desN));
					}
			}
			else {
				
				return(num_boletoA*conferencia)+(num_boletoN*(conferencia*desN));
			}
			
		}
	}
	
	
}
