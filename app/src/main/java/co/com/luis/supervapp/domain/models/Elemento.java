package co.com.luis.supervapp.domain.models;

import co.com.luis.supervapp.enums.ElementosEnum;

public class Elemento {

    String nombre;
    ElementosEnum elementosEnum;
    Integer idEstructura;

    public Elemento(String nombre, ElementosEnum elementosEnum, Integer idEstructura) {
        this.nombre = nombre;
        this.elementosEnum = elementosEnum;
        this.idEstructura = idEstructura;
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

    public ElementosEnum getElementosEnum() {
        return elementosEnum;
    }

    public void setElementosEnum(ElementosEnum elementosEnum) {
        this.elementosEnum = elementosEnum;
    }
}
