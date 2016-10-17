package Main;

import java.io.FileNotFoundException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Contenedores.Contenedor;
import Menu.Orden;
import TiposDeDatos.XML;

@Path("/MainCliente")
public class MainCliente {

	
	public static Contenedor contenedor = new Contenedor();
	
	public static void main(String[] args) throws FileNotFoundException {
		contenedor = XML.read("Contenedor.xml");

	}
	/**
	 * Navegar por el menú. Se debe mostrar para cada platillo: los ingredientes, valor nutricional, tiempo de preparación, precio, entre otros.
	 */
	@GET
	@Path("/getMenu")
	@Produces(MediaType.APPLICATION_JSON)
	public Contenedor getMenu(){
		return contenedor;
	}
	
	/**
	 * Progreso de las órdenes
	 */
	@GET
	@Path("/getProgresoOrdenes")
	@Produces(MediaType.APPLICATION_JSON)
	public Contenedor getProgresoOrdenes(){
		return contenedor;
	}
	
	/**
	 * Pagar la cuenta: El app permite a los clientes dividir la factura y enviar el pago. Para esto se debe
	 * crear un botón que simula el pago una vez que se ha dividido la cuenta, no deben incluirse datos de tarjetas por ejemplo. Una vez que se realiza el pago se debe enviar un recibo como comprobante del pago.
	 */
	@POST
	@Path("/setPagoCuenta")
	@Consumes(MediaType.APPLICATION_JSON)
	public void setPagar(Orden orden, Integer monto){
		orden.Pagar(monto);
	}
	
	/**
	 * Selección de platillos por voz.
	 */
	@POST
	@Path("/addOrden")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addOrden(Orden orden){
		contenedor.getListaOrdenes().addFirst(orden);
	}
	
	/**
	 * Calificar el restaurante y comentar sobre las órdenes
	 */
	@POST
	@Path("/setCalificarRestaurante")
	@Consumes(MediaType.APPLICATION_JSON)
	public void setCalificarRestaurante(Integer calificacion){
		contenedor.getRestaurante().addCalificacion(calificacion);
	}
}
