package EstructurasDeDatos;

import java.util.NoSuchElementException;


public class ListaDoble<T> {

	public NodoDoble<T> inicio;
	private NodoDoble<T> ultimo;
	public int size;
	
	public ListaDoble() {
    	this.size = 0;
    	this.inicio = null;
    	this.ultimo = this.inicio;
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

	}
	public void addFirst(T dato) {
		NodoDoble<T> temporal = new NodoDoble<T>(dato, inicio, null);
		if(inicio != null ) {
			inicio.setAnterior(temporal);
			}
		inicio = temporal;
		if(ultimo == null) { ultimo = temporal;}
		size++;

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
        }        
        else if (index == 1){
        	this.inicio.getSiguiente().setAnterior(null);
            this.inicio = this.inicio.getSiguiente();
            size--; 
        }
        else if (index == size){
            this.ultimo.getAnterior().setSiguiente(null);
            this.ultimo = this.ultimo.getAnterior();
            size--; 
        }
        else if((1 < index) &&(index < size)){
        	NodoDoble<T> temp = this.inicio.getSiguiente();
            index = index - 1 ;
            for (int i = 1; i < size - 1; i++){
                if (i == index){
                	temp.getAnterior().setSiguiente(temp.getSiguiente());
                	temp.getSiguiente().setAnterior(temp.getAnterior());    	
                    break;
                }
                else{
                	temp = temp.getSiguiente();
                }
            }
            size-- ;
        }
       
    }
	public boolean search(T dato){
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
	 public void intercambiar(NodoDoble<T> nodo1, NodoDoble<T> nodo2){

			T datoNodo1 = nodo1.getDato();
			T datoNodo2 = nodo2.getDato();
			
			nodo1.setDato(datoNodo2);
			nodo2.setDato(datoNodo1);
	    }
	    
	    public void insertarAntes(NodoDoble<T> nodoAInsertar, NodoDoble<T> nodoDelantero){
	    	if(nodoAInsertar != nodoDelantero){
		    	//Se elimina el nodo
		    	if (nodoAInsertar == this.inicio){
		    		this.inicio = nodoAInsertar.getSiguiente();
			    	nodoAInsertar.getSiguiente().setAnterior(null);
		    	}
		    	else if(nodoAInsertar == this.ultimo){
		    		this.ultimo = nodoAInsertar.getAnterior();
		    		nodoAInsertar.getAnterior().setSiguiente(null);
		    	}
		    	else{
		    		nodoAInsertar.getAnterior().setSiguiente(nodoAInsertar.getSiguiente());
			    	nodoAInsertar.getSiguiente().setAnterior(nodoAInsertar.getAnterior());
		    	}
		    	
		    	
		    	
		    	
		    	//Se agrega y se corrigen punteros delos nodos adyacentes
		    	if (nodoDelantero == this.inicio){
		    		this.inicio = nodoAInsertar;
		    		nodoDelantero.setAnterior(nodoAInsertar);
		    		nodoAInsertar.setAnterior(null);
		    	}
		    	else{
			    	NodoDoble<T> anterior = nodoDelantero.getAnterior();
			    	
			    	anterior.setSiguiente(nodoAInsertar);
			    	nodoDelantero.setAnterior(nodoAInsertar);
			    	
			    	nodoAInsertar.setAnterior(anterior);
		    	}
		    	
		    	nodoAInsertar.setSiguiente(nodoDelantero);  
	    	}
	    	
	    }
	    
	    public void insertarNuevoAntes(NodoDoble<T> nodoAInsertar, NodoDoble<T> nodoDelantero){
	    	//Se agrega y se corrigen punteros delos nodos adyacentes
	    	if (nodoDelantero == this.inicio){
	    		this.inicio = nodoAInsertar;
	    		nodoDelantero.setAnterior(nodoAInsertar);
	    		nodoAInsertar.setAnterior(null);
	    	}
	    	else{
		    	NodoDoble<T> anterior = nodoDelantero.getAnterior();
		    	
		    	anterior.setSiguiente(nodoAInsertar);
		    	nodoDelantero.setAnterior(nodoAInsertar);
		    	
		    	nodoAInsertar.setAnterior(anterior);
	    	}
	    	
	    	nodoAInsertar.setSiguiente(nodoDelantero);
	    }
	    
	    public NodoDoble<T> get(int index){
	    	
	    	NodoDoble<T> temp = this.inicio;
	    	
	    	for (int i = 0; i < index; i++){
	    		temp = temp.getSiguiente();
	    	}
	    	
			return temp;
	    }
}
	
	
	
