package Objetos;

import EstructurasDeDatos.ListaDoble;

public class Restaurante {
	private static ListaDoble<Integer> listaCalificaciones = new ListaDoble<Integer>();
	
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
	
	
	
}
