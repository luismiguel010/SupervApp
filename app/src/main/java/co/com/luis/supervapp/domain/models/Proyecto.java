package co.com.luis.supervapp.domain.models;

public class Proyecto {

    String nombre;
    String constructura;

    public Proyecto(String nombre, String constructura) {
        this.nombre = nombre;
        this.constructura = constructura;
    }

    public String getNombre() {
        return nombre;
    }

    public String getConstructura() {
        return constructura;
    }
}
