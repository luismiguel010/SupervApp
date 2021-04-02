package co.com.luis.supervapp.infraestructures.entities;

import java.io.Serializable;

public class EstructuraEntity implements Serializable {

    private Integer id;
    private String nombre;
    private Integer id_proyecto;

    public EstructuraEntity() {
    }

    public EstructuraEntity(Integer id, String nombre, Integer id_proyecto) {
        this.id = id;
        this.nombre = nombre;
        this.id_proyecto = id_proyecto;
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

    public Integer getId_proyecto() {
        return id_proyecto;
    }

    public void setId_proyecto(Integer id_proyecto) {
        this.id_proyecto = id_proyecto;
    }
}
