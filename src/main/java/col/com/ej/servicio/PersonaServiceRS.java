package col.com.ej.servicio;

import col.com.ej.data.PersonaDao;
import col.com.ej.domain.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;

@Stateless
//Path to communicate with this web service 
@Path("/personas")
public class PersonaServiceRS {

    @Inject
    private PersonaDao personaDao;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON) //TO return the response in JSON
    public List<Persona> listarPersonas() {
        //return personaDao.encontrarTodasPersonas();
        List<Persona> personas = personaDao.encontrarTodasPersonas();
        System.out.println("Personas encontradas" + personas);
        return personas;
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON) //TO return the response in JSON
    @Path("{id}") //It refers to the path /personas/{id}

    public Persona encontrarPersona(@PathParam("id") int id) {
        Persona persona = personaDao.encontrarPersona(new Persona(id));
        System.out.println("Personas encontrada" + persona);
        return persona;
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON) //TO return the response in JSON
    @Produces(value = MediaType.APPLICATION_JSON) //TO return the response in JSON
    public Persona InsertarPersona(Persona persona) {
        personaDao.insertarPersona(persona);
        System.out.println("Personas agregrada" + persona);
        return persona;
    }

    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON) //TO return the response in JSON
    @Produces(value = MediaType.APPLICATION_JSON) //TO return the response in JSON
    @Path("{id}") //It refers to the path /personas/{id}
    public Response modificarPersona(@PathParam("id") int id, Persona personaModificada) {
        Persona persona = personaDao.encontrarPersona(new Persona(id));
        if (persona != null) {
            personaDao.actualizarPersona(personaModificada);
            System.out.println("Personas modificada" + personaModificada);
            return Response.ok().entity(personaModificada).build();
        } else {
            return Response.status(Status.NOT_FOUND).build();
        }

    }

    @DELETE
    @Produces(value = MediaType.APPLICATION_JSON) //TO return the response in JSON
    @Path("{id}") //It refers to the path /personas/{id}
    public Response eliminarPersona(@PathParam("id") int id) {
        personaDao.eliminarPersona(new Persona(id));
        System.out.println("Personas eliminada" + id);
        return Response.ok().build();
    }

}
