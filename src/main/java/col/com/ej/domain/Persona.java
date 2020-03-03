package col.com.ej.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


//To convert this class to entiry class

@Entity
@NamedQueries({
    @NamedQuery(name = "Persona.encontrarTodasPersonas", query = " SELECT P FROM Persona p ORDER BY p.idPersona ")
})

public class Persona implements Serializable{
    
    //to indicate which the database will generate the id 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    //To indicate the name of the column of the database
    @Column(name = "id_persona")
    
    private int idPersona;
    private String nombre;
    
    public Persona(){
        
    }
    
    //A constractor which receives an param
    public Persona (int idPersona){
        this.idPersona = idPersona;
        
    }
    
    public Persona(int idPersona, String nombre){
        this.idPersona = idPersona;
        this.nombre = nombre;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombre=" + nombre + '}';
    }
    
    
}
