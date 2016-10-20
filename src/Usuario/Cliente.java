package Usuario;

public class Cliente {
	//hacer lista clientes

	@GET
	@Path("/getOrdenTerminada")
	@Produces(MediaType.APPLICATION_JSON)
	public Orden notificarOrdenTerminada(Orden orden){
		return orden;
	}
	
	//hacer que se vesn todas la ordenes del cliente
	
}
