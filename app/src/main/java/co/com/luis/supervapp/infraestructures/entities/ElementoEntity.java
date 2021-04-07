package co.com.luis.supervapp.infraestructures.entities;

import java.io.Serializable;

public class ElementoEntity implements Serializable {

    private Integer id;
    private String nombre;
    private Integer idElemento;

    public ElementoEntity() {
    }

    public ElementoEntity(Integer id, String nombre, Integer idElemento) {
        this.id = id;
        this.nombre = nombre;
        this.idElemento = idElemento;
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

    public Integer getIdElemento() {
        return idElemento;
    }

    public void setIdElemento(Integer idElemento) {
        this.idElemento = idElemento;
    }
}
