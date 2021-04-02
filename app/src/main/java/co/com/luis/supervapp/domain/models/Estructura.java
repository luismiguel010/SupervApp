package co.com.luis.supervapp.domain.models;

public class Estructura {

    String nombre;
    Integer idProyecto;

    public Estructura(String nombre, Integer idProyecto) {
        this.nombre = nombre;
        this.idProyecto = idProyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }
}
