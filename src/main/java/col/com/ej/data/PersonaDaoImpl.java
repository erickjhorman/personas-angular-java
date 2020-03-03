
package col.com.ej.data;

import col.com.ej.domain.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import javax.persistence.PersistenceContext;

//To turn this class to a JBL

@Stateless
public class PersonaDaoImpl implements PersonaDao {

    @PersistenceContext (unitName = "PersonaPU")

        //This variable receavis the persistance to comunicat wit hthe database
      EntityManager em; 
    
    
    @Override
    public List<Persona> encontrarTodasPersonas() {
        return em.createNamedQuery("Persona.encontrarTodasPersonas").getResultList();
    }

    @Override
    public Persona encontrarPersona(Persona persona) {
      return em.find(Persona.class, persona.getIdPersona());
    }

    @Override
    public void insertarPersona(Persona persona) {
        em.persist(persona);
        em.flush();  //To get back the id of the user stored
    }

    @Override
    public void actualizarPersona(Persona persona) {
        em.merge(persona);
    }

    @Override
    public void eliminarPersona(Persona persona) {
        em.remove(em.merge(persona));
    }
    
}
