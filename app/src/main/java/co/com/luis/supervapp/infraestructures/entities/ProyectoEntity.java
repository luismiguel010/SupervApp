package co.com.luis.supervapp.infraestructures.entities;


import java.io.Serializable;

public class ProyectoEntity implements Serializable {

    private Integer id;
    private String nombre;
    private String constructura;

    public ProyectoEntity() {
    }

    public ProyectoEntity(Integer id, String nombre, String constructura) {
        this.id = id;
        this.nombre = nombre;
        this.constructura = constructura;
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

    public String getConstructura() {
        return constructura;
    }

    public void setConstructura(String constructura) {
        this.constructura = constructura;
    }

}
