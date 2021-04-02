package co.com.luis.supervapp.infraestructures.entities;

import java.io.Serializable;

public class ElementoEntity implements Serializable {

    private Integer id;
    private String nombre;
    private Integer idEstructura;

    public ElementoEntity() {
    }

    public ElementoEntity(Integer id, String nombre, Integer idEstructura) {
        this.id = id;
        this.nombre = nombre;
        this.idEstructura = idEstructura;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdEstructura() {
        return idEstructura;
    }

    public void setIdEstructura(Integer idEstructura) {
        this.idEstructura = idEstructura;
    }
}
