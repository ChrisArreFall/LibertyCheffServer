package Objetos;

import EstructurasDeDatos.ListaDoble;
import Menu.Orden;
import PatronesDeDiseno.Observador;
import Usuario.Cheff;

public class Restaurante implements Observador {
	private static ListaDoble<Integer> listaCalificaciones = new ListaDoble<Integer>();
	private static ListaDoble<Cheff> listaCheffs = new ListaDoble<Cheff>();
	
	public Restaurante(){
		listaCalificaciones = null;
	}

	public static ListaDoble<Integer> getListaCalificaciones() {
		//promedio calificaciones
		return listaCalificaciones;
	}

	public void addCalificacion(Integer calificacion) {
		listaCalificaciones.addFirst(calificacion);
	}
	
	public void actualizar(Orden orden){
		if (orden.getEstadoPreparacion() == "Nueva")
			for(int i = 0; i < listaCheffs.size(); i++){
				listaCheffs.get(i).getDato().notificarOrdenNueva(orden);
			}
		else if (orden.getEstadoPreparacion() == "Terminada")
			orden.getCliente().notificarOrdenTerminada(orden);
			}
	}
	
}
