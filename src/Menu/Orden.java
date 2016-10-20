package Menu;

import EstructurasDeDatos.ListaDoble;
import Objetos.Restaurante;
import PatronesDeDiseno.Sujeto;
import Usuario.Cliente;

public class Orden implements Sujeto {
	private Cliente cliente = new Cliente();
	private Platillo platillo = new Platillo();
	private Integer monto;
	private String estado;
	private String estadoPreparacion = "Nueva";
	private ListaDoble<Pasos> listaPasos = new ListaDoble<Pasos>();


	public Orden(){
		cliente = null;
		platillo = null;
		monto = null;
		listaPasos = null;
		estado = "Debe";
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Platillo getPlatillo() {
		return platillo;
	}


	public void setPlatillo(Platillo platillo) {
		listaPasos = platillo.getReceta().getListaPasos();
		this.platillo = platillo;
	}


	public Integer getPagado() {
		return monto;
	}


	public void setPagado(Integer monto) {
		this.monto = monto;
	}
	
	public void Pagar(Integer monto) {
		if(this.monto - monto<=0){
			this.monto-=monto;
			estado = "Pagado";
		}
		else{
			this.monto-=monto;
		}
	}
	
	public String getEstado(){
		return estado;
	}
	
	public String getEstadoPreparacion(){
		return this.estadoPreparacion;
	}
	
	public String setEstadoPreparacion(String nuevoEstado){
		this.estado = nuevoEstado;
	}
	
	public ListaDoble<Pasos> getListaPasos() {
		return listaPasos;
	}


	public void setListaPasos(ListaDoble<Pasos> listaPasos) {
		this.listaPasos = listaPasos;
	}
	
	public void notificar(){
		if (listaObservadores.size() > 0){
			for(int i = 0; i < listaObservadores.size(); i++){
				listaObservadores.get(i).getDato().notificarOrdenNueva(this);
			}
		}
	}
	
	public void agregarObservador(Restaurante restaurante){
		listaObservadores.addFirst(restaurante);
	}
	public void eliminarObservador(Restaurante restaurante){
		//hacer metodo de borrar con dato en la lista enlazada
	}
}
