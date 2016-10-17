package Menu;

import EstructurasDeDatos.ListaDoble;

public class Menu {
	private ListaDoble<Platillo> listaPlatillos = new ListaDoble<Platillo>();

	
	/**
	 * Para cada platillo se registran los ingredientes que lo
	 * componen (incluye la cantidad), información nutricional, precio, tiempo de preparación, recetas
	 * y cualquier otro dato necesario
	 */
	public Menu(){
		listaPlatillos = null;
	}

	public ListaDoble<Platillo> getListaPlatillos() {
		return listaPlatillos;
	}
	public void setListaPlatillos(ListaDoble<Platillo> listaPlatillos) {
		this.listaPlatillos = listaPlatillos;
	}


}
