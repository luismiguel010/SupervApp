package co.com.luis.supervapp.utilidades;

public class Utilidades {

    //Constantes campos tabla proyecto
    public static final String TABLA_PROYECTOS = "proyecto";
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_CONSTRUCTORA = "constructora";

    public static final String CREAR_TABLA_PROYECTO="CREATE TABLE " +
            ""+TABLA_PROYECTOS+" ("+CAMPO_ID+" "+
            "INTEGER, "+CAMPO_NOMBRE+" TEXT,"+CAMPO_CONSTRUCTORA+" TEXT)";
}
