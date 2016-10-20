package Usuario;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import Menu.Orden;

public class Cheff {
	
	@GET
	@Path("/getOrdenNueva")
	@Produces(MediaType.APPLICATION_JSON)
	public Orden notificarOrdenNueva(Orden orden){
		return orden;
	}
}
