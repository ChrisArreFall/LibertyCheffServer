package Pruebas;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class Prueba {
@GET
@Produces(MediaType.TEXT_HTML)
public String helloHtml(){
	return "<html>" + "<title>" + "Hello, World!" + "</title>" + "<body><h1>" + "Hello, World!" + "</body></h1>" + "</html>";
}
}
