package Main;

import javax.ws.rs.Produces;

import java.io.FileNotFoundException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import Contenedores.Contenedor;
import Ingredients.IngredienteSolo;
import Menu.Orden;
import Menu.Pasos;
import Menu.Platillo;
import TiposDeDatos.XML;


@Path("/MainCheff")
public class MainCheff {
	public static Contenedor contenedor = new Contenedor();
	
	public static void main(String[] args) throws FileNotFoundException {
		contenedor = XML.read("Contenedor.xml");

	}
	/**
	 * Registrar el inventario de ingredientes. Se debe permitir registrar ingredientes para las 
	 * categorías más importantes (frutas, granos, vegetales, lácteos, carnes). Los ingredientes 
	 * se guardan sin ningún orden en particular.
	 * @return 
	 */
	@POST
	@Path("/setIngredientes")
	@Consumes(MediaType.APPLICATION_JSON)
	public void setIngredientes(IngredienteSolo ingrediente){
		if(!ingrediente.getCarne().equals(null)){
			contenedor.getListaCarnes().addFirst(ingrediente.getCarne());
		}
		else if(!ingrediente.getFruta().equals(null)){
			contenedor.getListaFrutas().addFirst(ingrediente.getFruta());
		}
		else if(!ingrediente.getGrano().equals(null)){
			contenedor.getListaGranos().addFirst(ingrediente.getGrano());
		}
		else if(!ingrediente.getLacteo().equals(null)){
			contenedor.getListaLacteos().addFirst(ingrediente.getLacteo());
		}
		else if(!ingrediente.getVegetal().equals(null)){
			contenedor.getListaVegetales().addFirst(ingrediente.getVegetal());
		}
		
	}
	
	
	/**
	 * Permite registrar el menú del restaurante. Para cada platillo se registran los ingredientes que lo
	 * componen (incluye la cantidad), información nutricional, precio, tiempo de preparación, recetas
	 * y cualquier otro dato necesario
	 */
	@POST
	@Path("/setRegistrarMenu")
	@Consumes(MediaType.APPLICATION_JSON)
	public void setRegistrarMenu(Platillo platillo){
		contenedor.getListaPlatillos().addFirst(platillo);
		
	}
	
	
	/**
	 * Cuando una orden es registrada, se ingresa en una cola de prioridad según la categoría del
	 * cliente (bronce, oro, platino). Cuando una orden está lista para ser atendida, los chefs reciben
	 * una notificación.
	 */
	@GET
	@Path("/getOrden")
	@Produces(MediaType.APPLICATION_JSON)
	public Contenedor getOrden(){
		return contenedor;
		
	}
	
	/**
	 * Cuando la orden va a ser preparada, el sistema buscará la receta de la orden y cada uno de los
	 * ingredientes, utilizando Binary Search (asumimos que los ingredientes no se acaban del
	 * inventario).
	 */
	@GET
	@Path("/getReceta")
	@Produces(MediaType.APPLICATION_JSON)
	public Platillo getReceta(Orden orden){
		//falta implementar el binary search
		//return contenedor.getListaPlatillos().BinarySearch(orden.getPlatillo());
		return null;
	}
	
	
	
	/**
	 * Cada chef marca el paso asignado cuando lo termine y el sistema registra el tiempo real de cada
	 * paso.
	 */
	@POST
	@Path("/setPasosOrden")
	@Consumes(MediaType.APPLICATION_JSON)
	public void setPasosOrden(Pasos paso,Orden orden){
		//orden.getListaPasos().remove(paso);
	}
	
	
	/**
	 * Cuando la receta se completa, se envía una notificación al cliente. El cliente en cualquier
	 * momento puede ver el estado de la orden
	 */
	@POST
	@Path("/setCompletarOrden")
	@Consumes(MediaType.APPLICATION_JSON)
	public void setCompletarOrden(Orden orden){
		//aqui tengo que enviar la notifivacion al cliente
		//contenedor.getListaOrdenes().remove(orden);
	}
	
	@POST
	@Path("/setTerminarDia")
	@Consumes(MediaType.APPLICATION_JSON)
	public void setTerminarDia() throws FileNotFoundException{
		XML.write(contenedor, "Contenedor.xml");
	}
}
