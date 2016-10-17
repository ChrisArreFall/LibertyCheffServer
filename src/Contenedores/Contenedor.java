package Contenedores;
import EstructurasDeDatos.ListaDoble;
import Ingredients.Carnes;
import Ingredients.Frutas;
import Ingredients.Granos;
import Ingredients.Lacteos;
import Ingredients.Vegetales;
import Menu.Orden;
import Menu.Platillo;
import Objetos.Restaurante;



public class Contenedor {
	
	private static ListaDoble<Carnes> ListaCarnes = new ListaDoble<Carnes>();
	private static ListaDoble<Frutas> ListaFrutas = new ListaDoble<Frutas>();
	private static ListaDoble<Granos> ListaGranos = new ListaDoble<Granos>();
	private static ListaDoble<Lacteos> ListaLacteos = new ListaDoble<Lacteos>();
	private static ListaDoble<Vegetales> ListaVegetales = new ListaDoble<Vegetales>();
	private static ListaDoble<Platillo> listaPlatillos = new ListaDoble<Platillo>();
	private static ListaDoble<Orden> ListaOrdenes = new ListaDoble<Orden>();
	private static Restaurante restaurante = new Restaurante();

	public Contenedor(){
		ListaCarnes = null;
		ListaFrutas = null;
		ListaFrutas = null;
		ListaGranos = null;
		ListaLacteos = null;
		ListaVegetales = null;
		listaPlatillos = null;
		ListaOrdenes = null;
		restaurante = null;
		
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}


	public ListaDoble<Carnes> getListaCarnes() {
		return ListaCarnes;
	}

	public void setListaCarnes(ListaDoble<Carnes> listaCarnes) {
		ListaCarnes = listaCarnes;
	}

	public ListaDoble<Frutas> getListaFrutas() {
		return ListaFrutas;
	}

	public void setListaFrutas(ListaDoble<Frutas> listaFrutas) {
		ListaFrutas = listaFrutas;
	}

	public ListaDoble<Granos> getListaGranos() {
		return ListaGranos;
	}

	public void setListaGranos(ListaDoble<Granos> listaGranos) {
		ListaGranos = listaGranos;
	}

	public ListaDoble<Lacteos> getListaLacteos() {
		return ListaLacteos;
	}

	public void setListaLacteos(ListaDoble<Lacteos> listaLacteos) {
		ListaLacteos = listaLacteos;
	}

	public ListaDoble<Vegetales> getListaVegetales() {
		return ListaVegetales;
	}

	public void setListaVegetales(ListaDoble<Vegetales> listaVegetales) {
		ListaVegetales = listaVegetales;
	}
	
	public ListaDoble<Platillo> getListaPlatillos() {
		return listaPlatillos;
	}

	public void setListaPlatillos(ListaDoble<Platillo> ListaPlatillos) {
		listaPlatillos = ListaPlatillos;
	}
	
	public ListaDoble<Orden> getListaOrdenes() {
		return ListaOrdenes;
	}

	public static void setListaOrdenes(ListaDoble<Orden> listaOrdenes) {
		ListaOrdenes = listaOrdenes;
	}
	
	

}
