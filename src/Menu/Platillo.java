package Menu;
import EstructurasDeDatos.ListaDoble;
import Ingredients.IngredienteSolo;

public class Platillo {

	private Integer tiempoDePreparacion;
	private String informacionNutricional;
	//private InformacionNutricional informacionNutricional;
	private Integer precio;
	private Integer cantidadDeIngredientes;
	private Receta receta;
	private String datoExtra;
	private ListaDoble<IngredienteSolo> listaIngredientes;
	
	
	/**
	 * Para cada platillo se registran los ingredientes que lo
	 * componen (incluye la cantidad), información nutricional, precio, tiempo de preparación, recetas
	 * y cualquier otro dato necesario
	 */
	public Platillo(){
		tiempoDePreparacion = null;
		informacionNutricional = null;
		precio =  null;
		cantidadDeIngredientes = null;
		receta = null;
		datoExtra = null;
		listaIngredientes = null;
	}


	public ListaDoble<IngredienteSolo> getListaIngredientes() {
		return listaIngredientes;
	}


	public void setListaIngredientes(ListaDoble<IngredienteSolo> listaIngredientes) {
		this.listaIngredientes = listaIngredientes;
	}


	public Integer getTiempoDePreparacion() {
		return tiempoDePreparacion;
	}


	public void setTiempoDePreparacion(Integer tiempoDePreparacion) {
		this.tiempoDePreparacion = tiempoDePreparacion;
	}


	public String getInformacionNutricional() {
		return informacionNutricional;
	}


	public void setInformacionNutricional(String informacionNutricional) {
		this.informacionNutricional = informacionNutricional;
	}


	public Integer getPrecio() {
		return precio;
	}


	public void setPrecio(Integer precio) {
		this.precio = precio;
	}


	public Integer getCantidadDeIngredientes() {
		return cantidadDeIngredientes;
	}


	public void setCantidadDeIngredientes(Integer cantidadDeIngredientes) {
		this.cantidadDeIngredientes = cantidadDeIngredientes;
	}


	public Receta getReceta() {
		return receta;
	}


	public void setReceta(Receta receta) {
		this.receta = receta;
	}


	public String getDatoExtra() {
		return datoExtra;
	}


	public void setDatoExtra(String datoExtra) {
		this.datoExtra = datoExtra;
	}
}
