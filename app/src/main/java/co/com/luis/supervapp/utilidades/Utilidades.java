package co.com.luis.supervapp.utilidades;

public class Utilidades {

    public static final String NOMBRE_BASEDEDATOS = "db_supervapp";
    //Constantes campos tabla proyecto
    public static final String TABLA_PROYECTOS = "proyecto";
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_CONSTRUCTORA = "constructora";
    //Constantes campos tabla estructuras
    public static final String TABLA_ESTRUCTURAS = "estructura";
    public static final String CAMPO_ID_PROYECTO = "id_proyecto";


    public static final String CREAR_TABLA_PROYECTO="CREATE TABLE " +
            ""+TABLA_PROYECTOS+" ("+CAMPO_ID+" "+
            "INTEGER, "+CAMPO_NOMBRE+" TEXT,"+CAMPO_CONSTRUCTORA+" TEXT)";

    public static final String CREAR_TABLA_ESTRUCTURA="CREATE TABLE " +
            ""+TABLA_ESTRUCTURAS+" ("+CAMPO_ID+" "+
            "INTEGER, "+CAMPO_NOMBRE+" TEXT,"+CAMPO_ID_PROYECTO+" INTEGER)";


}
