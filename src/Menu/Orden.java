package Menu;

import EstructurasDeDatos.ListaDoble;
import Usuario.Cliente;

public class Orden {
	private Cliente cliente = new Cliente();
	private Platillo platillo = new Platillo();
	private Integer monto;
	private String estado;
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
	
	public ListaDoble<Pasos> getListaPasos() {
		return listaPasos;
	}


	public void setListaPasos(ListaDoble<Pasos> listaPasos) {
		this.listaPasos = listaPasos;
	}
}
