package Algoritmos;
import EstructurasDeDatos.*;
import Ingredients.*;


public class Ordenador {

	public static void main(String[] args) {
		Carnes v1 = new Carnes();
		Carnes v2 = new Carnes();
		Carnes v3 = new Carnes();
		Carnes v4 = new Carnes();
		Carnes v5 = new Carnes();
		Carnes v6 = new Carnes();
		v1.setName("Fer");
		v2.setName("Juan");
		v3.setName("Tiff");
		v4.setName("Erick");
		v5.setName("Aymaru");
		v6.setName("Ana");
		ListaDoble<Carnes> lista = new ListaDoble<Carnes>();
		lista.addLast(v1);
		lista.addLast(v2);
		lista.addLast(v3);
		lista.addLast(v4);
		lista.addLast(v5);
		lista.addLast(v6);
		
		ordenarCarnes(lista);
		
		for(int i = 0; i < lista.size(); i++){
			System.out.println(lista.get(i).getDato().getNombre());
		}
	}
	
	//ShellSort
	public static void ordenarVegetales(ListaDoble<Vegetales> lista){
		int gap = lista.size() / 2;
		while (gap > 0) {
			for (int i = 0; i < lista.size() - gap; i++) {
				
				int j = i + gap;
				NodoDoble<Vegetales> tmp = new NodoDoble<Vegetales>();
				tmp.setDato(lista.get(j).getDato());
				
				while ((j >= gap) && (tmp.getDato().getNombre().compareToIgnoreCase(lista.get(j - gap).getDato().getNombre()) < 0)) {
					lista.get(j).setDato(lista.get(j - gap).getDato());
					
					j -= gap;
				}
				lista.get(j).setDato(tmp.getDato());
			}
			
		    if (gap == 2){ 
		    	gap = 1;} 
			else {
				gap /= 2.2;
			}
        }
	}
	
	//se inician en 0 y len - 1
	//QuickSort
	public static void ordenarFrutas(ListaDoble<Frutas> lista, int indiceInicial, int indiceFinal){
		if (indiceInicial < indiceFinal) { 
	        int pivote = indiceInicial;
	        for (int i = indiceInicial + 1; i < indiceFinal; i++) { 
	            if ((lista.get(i).getDato().getNombre()).compareToIgnoreCase(lista.get(pivote).getDato().getNombre()) < 0) { 
	            	lista.insertarAntes(lista.get(i), lista.get(pivote));
	            	++pivote;
	            }
	        }
	        ordenarFrutas(lista, indiceInicial, pivote);
	        ordenarFrutas(lista, pivote + 1, indiceFinal);
	    } 
    }
	
	//BubbleSort
	public static void ordenarLacteos(ListaDoble<Lacteos> lista){
		int indice = 0;
		boolean cambios = true;
		
		while((cambios) || (indice + 1 < lista.size()) ){
			if (indice + 1 == lista.size()){
				indice = 0;
				cambios = false;
			}
			if((lista.get(indice).getDato().getNombre().compareToIgnoreCase(lista.get(indice + 1).getDato().getNombre())) > 0){
				lista.intercambiar(lista.get(indice), lista.get(indice + 1));
				cambios = true;
			}
			++indice;
		}
	
	}
	
	//InsertionSort
	public static void ordenarCarnes(ListaDoble<Carnes> lista){	
	    for (int ordenando = 0; ordenando < lista.size; ordenando++) {
	    	int posMenor = ordenando;
	        for (int sonda = ordenando + 1; (sonda < lista.size); sonda++){
	        	if (lista.get(sonda).getDato().getNombre().compareToIgnoreCase(lista.get(posMenor).getDato().getNombre()) < 0 ){
	        		posMenor = sonda;
	        	}
	        }
	        lista.insertarAntes(lista.get(posMenor), lista.get(ordenando));
	    }
	}
	
	//RadixSort
	public static void ordenarGranos(ListaDoble<Granos> lista){
		for(int i = lista.size - 1; i >= 0 ; i--){
			ordenamientoSeleccion(lista)
	        ; //order strings by characters at their i-th position
	    }
	}
	
	private static void ordenamientoSeleccion(ListaDoble<Granos> lista){
		int posMenor = 0, actual = 0, porOrdenar = 0;
		while(porOrdenar < lista.size()){
			if (actual == lista.size()){
				lista.intercambiar(lista.get(posMenor), lista.get(porOrdenar));
				++porOrdenar;
				posMenor = actual = porOrdenar;			
			}
			else if((lista.get(actual).getDato().getNombre().compareToIgnoreCase(lista.get(posMenor).getDato().getNombre())) < 0){
				posMenor = actual;
				++actual;
			}
			else
				++actual;
		}
	}
}
