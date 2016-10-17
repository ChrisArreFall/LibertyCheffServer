package EstructurasDeDatos;

import java.util.NoSuchElementException;


public class ListaDoble<T> {

	public NodoDoble<T> inicio;
	private NodoDoble<T> ultimo;
	public int size;
	
	public ListaDoble() {
		//size = 0;
	}
	public int size() { 
		return size; 
	}	
	public boolean isEmpty() { 
		return size == 0; 
	}
	
	public void addLast(T dato) {
		
		NodoDoble<T> temporal = new NodoDoble<T>(dato, null, ultimo);
		if(ultimo != null) {
			ultimo.setSiguiente(temporal);
			}
		ultimo = temporal;
		if(inicio == null) {
			inicio = temporal;}
		size++;
		System.out.println("adding: "+dato);
	}
	public void addFirst(T dato) {
		NodoDoble<T> temporal = new NodoDoble<T>(dato, inicio, null);
		if(inicio != null ) {
			inicio.setAnterior(temporal);
			}
		inicio = temporal;
		if(ultimo == null) { ultimo = temporal;}
		size++;
		System.out.println("adding: " + dato.getClass().getName());
	}
	public void addAt(T dato , int pos)
	{
		NodoDoble<T> temporal = new NodoDoble<T>(dato, null, null);    
		if (pos == 1)
		{
			addFirst(dato);
			return;
		}            
		NodoDoble<T> ptr = inicio;
		for (int i = 2; i <= size; i++)
		{
			if (i == pos)
			{
				NodoDoble<T> tmp = ptr.getSiguiente();
				ptr.setSiguiente(temporal);
				temporal.setAnterior(ptr);
				temporal.setSiguiente(tmp);
				tmp.setAnterior(temporal);
			}
			ptr = ptr.getSiguiente();            
		}
		size++ ;
	}
	public T deleteFirst() {
		if (size == 0) throw new NoSuchElementException();
		NodoDoble<T> temporal = inicio;
		inicio = inicio.getSiguiente();
		inicio.setAnterior(null);
		size--;
		return temporal.getDato();
	}
	public T deleteLast() {
		if (size == 0) throw new NoSuchElementException();
		NodoDoble<T> temporal = ultimo;
		ultimo = ultimo.getAnterior();
		ultimo.setSiguiente(null);
		size--;
		return temporal.getDato();
	}
	public void deleteAt(int index){    
        if (size == 1 && index == 1){
            inicio = null;
            ultimo = null;
            size = 0;
            return ;
        }        
        if (index == 1){
            inicio = inicio.getSiguiente();
            ultimo.setSiguiente(inicio);
            size--; 
            return ;
        }
        if (index == size){
            NodoDoble<T> s = inicio;
            NodoDoble<T> t = inicio;
            while (s != ultimo){
                t = s;
                s = s.getSiguiente();
            }
            ultimo = t;
            ultimo.setSiguiente(inicio);
            size --;
            return;
        }
        NodoDoble<T> ptr = inicio;
        index = index - 1 ;
        for (int i = 1; i < size - 1; i++){
            if (i == index){
                NodoDoble<T> tmp = ptr.getSiguiente();
                tmp = tmp.getSiguiente();
                ptr.setSiguiente(tmp);
                break;
            }
            ptr = ptr.getSiguiente();
        }
        size-- ;
    }
	public Boolean search(T dato){
		NodoDoble<T> temporal = new NodoDoble<T>();
		temporal = inicio;
		int contador = 0;
		while(!temporal.getDato().equals(dato)){
			if(contador==size-1){
				return false;
			}
			else{
				temporal = temporal.getSiguiente();
			}
		}
		return true;
	}
	
	public void print(){
		NodoDoble<T> temporal = new NodoDoble<T>();
		temporal = inicio;
		for(int i = 0;i < size; i ++){
			System.out.println(temporal.print());
			temporal = temporal.getSiguiente();
		}
		
	}
	}
	
	
	
