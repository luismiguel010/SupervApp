package co.com.luis.supervapp.domain.models;

public class Elemento {

    String nombre;
    Integer idEstructura;

    public Elemento(String nombre, Integer idEstructura) {
        this.nombre = nombre;
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
}
