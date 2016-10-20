package EstructurasDeDatos;

import Menu.Orden;

public class ColaDeOrdenes {
	NodoDoble primero;
	NodoDoble ultimo;
	int size;

	public Cola() {
		primero = ultimo = null;
		size = 0;
	}
	//Implementar prioridad
	public void agregarACola(Orden orden) {
		NodoDoble nuevaOrden = new NodoDoble(orden);
		if (primero == null) {
			primero = nuevaOrden;
			ultimo = nuevaOrden;
		} else {
			ultimo.setSiguiente(nuevaOrden);;
			ultimo = nuevaOrden;
		}
		size++;
	}; // inserts an object onto the queue

	public Orden sacarDeCola() {
		if (primero == null)
			return null;
		;
		Orden orden = primero.getDato();
		primero = primero.getSiguiente();
		size--;
		return orden;
	} // gets the object from the queue

	public boolean isEmpty() {
		return (size == 0);
	}

	public int size() {
		return size;
	}

} // class LinkedQueue

