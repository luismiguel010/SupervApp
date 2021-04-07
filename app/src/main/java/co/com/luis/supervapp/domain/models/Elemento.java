package co.com.luis.supervapp.domain.models;

import co.com.luis.supervapp.enums.ElementosEnum;

public class Elemento {

    String nombre;
    Integer idTipoElemento;

    public Elemento(String nombre, Integer idTipoElemento) {
        this.nombre = nombre;
        this.idTipoElemento = idTipoElemento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdTipoElemento() {
        return idTipoElemento;
    }

    public void setIdTipoElemento(Integer idTipoElemento) {
        this.idTipoElemento = idTipoElemento;
    }

}
