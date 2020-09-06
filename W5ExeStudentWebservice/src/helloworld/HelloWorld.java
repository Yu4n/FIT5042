package helloworld;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

@Path("greeting")
public class HelloWorld {
    @SuppressWarnings("unused")
    @Context
    private UriInfo context;

    @EJB
    private NameStorageBean nameStorage;
    
    /**
     * Default constructor. 
     */
    public HelloWorld() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Retrieves representation of an instance of HelloWorld
     * @return an instance of String
     */
    @GET
    @Produces("text/html")
    public String getHtml() {
        // TODO return proper representation object
        return "<html><body><h1>Hello " + nameStorage.getName() + "!</h1></body></html>";
    }
    
    @POST
    @Consumes("application/x-www-form-urlencoded")
    public void setPostName(@FormParam("name") String content) {
    	nameStorage.setName(content);
    }

    /**
     * PUT method for updating or creating an instance of HelloWorld
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void putHtml(String content) {
    }

}