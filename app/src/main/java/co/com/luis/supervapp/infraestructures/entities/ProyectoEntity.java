package co.com.luis.supervapp.infraestructures.entities;


public class ProyectoEntity {

    String nombre;
    String constructura;

    public ProyectoEntity() {
    }

    public ProyectoEntity(String nombre, String constructura) {
        this.nombre = nombre;
        this.constructura = constructura;
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
