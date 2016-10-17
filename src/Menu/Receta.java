package Menu;

import EstructurasDeDatos.ListaDoble;

public class Receta {
	ListaDoble<Pasos> listaPasos = new ListaDoble<Pasos>();
	
	

	public Receta(){
		listaPasos = null;
	}
	
	public ListaDoble<Pasos> getListaPasos() {
		return listaPasos;
	}

	public void setListaPasos(ListaDoble<Pasos> listaPasos) {
		this.listaPasos = listaPasos;
	}

}
