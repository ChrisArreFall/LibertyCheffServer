package PatronesDeDiseno;

import EstructurasDeDatos.ListaDoble;

public interface Sujeto {
	
	ListaDoble<Observador> listaObservadores = new ListaDoble<Observador>();
	
	public void agregarObservador();
	
	public void eliminarObservador();
	
	public void notificar();
}
