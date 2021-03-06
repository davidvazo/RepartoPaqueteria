package mx.trillas.ControlEnvio.persistence.pojos;
// Generated 19/04/2016 10:31:08 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Origen generated by hbm2java
 */
public class Origen  implements java.io.Serializable {


     private Integer id;
     private String nombre;
     private Set guias = new HashSet(0);

    public Origen() {
    }

	
    public Origen(String nombre) {
        this.nombre = nombre;
    }
    public Origen(String nombre, Set guias) {
       this.nombre = nombre;
       this.guias = guias;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Set getGuias() {
        return this.guias;
    }
    
    public void setGuias(Set guias) {
        this.guias = guias;
    }




}


