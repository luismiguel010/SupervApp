package co.com.luis.supervapp.utilidades;

public class Utilidades {

    //----------------------------------------------------------
    //Constantes generales
    //----------------------------------------------------------
    public static final String NOMBRE_BASEDEDATOS = "db_supervapp";
    public static final int VERSION_BASE_DE_DATOS = 6;
    //----------------------------------------------------------
    //Constantes campos tabla proyecto
    //----------------------------------------------------------
    public static final String TABLA_PROYECTOS = "proyecto";
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_CONSTRUCTORA = "constructora";
    //----------------------------------------------------------
    //Constantes campos tabla estructuras
    //----------------------------------------------------------
    public static final String TABLA_ESTRUCTURAS = "estructura";
    public static final String CAMPO_ID_PROYECTO = "id_proyecto";
    //----------------------------------------------------------
    //Constantes campos tabla tipo de elementos
    //----------------------------------------------------------
    public static final String TABLA_TIPO_ELEMENTOS = "tipoelemento";
    public static final String CAMPO_TIPO_ELEMENTO = "tipo_elemento";
    public static final String CAMPO_ID_ESTRUCTURA = "id_estructura";
    //----------------------------------------------------------
    //Constantes campos tabla elementos
    //----------------------------------------------------------
    public static final String TABLA_ELEMENTOS = "elemento";
    //----------------------------------------------------------
    //Constantes creación de tablas
    //----------------------------------------------------------
    public static final String CREAR_TABLA_PROYECTO="CREATE TABLE " +
            ""+TABLA_PROYECTOS+" ("+CAMPO_ID+" "+
            "INTEGER, "+CAMPO_NOMBRE+" TEXT,"+CAMPO_CONSTRUCTORA+" TEXT)";

    public static final String CREAR_TABLA_ESTRUCTURA="CREATE TABLE " +
            ""+TABLA_ESTRUCTURAS+" ("+CAMPO_ID+" "+
            "INTEGER, "+CAMPO_NOMBRE+" TEXT,"+CAMPO_ID_PROYECTO+" INTEGER)";

    public static final String CREAR_TABLA_TIPO_ELEMENTO="CREATE TABLE " +
            ""+TABLA_TIPO_ELEMENTOS+" ("+CAMPO_TIPO_ELEMENTO+" "+
            "INTEGER, "+CAMPO_ID_ESTRUCTURA+" INTEGER)";

    public static final String CREAR_TABLA_ELEMENTO="CREATE TABLE " +
            ""+TABLA_ELEMENTOS+" ("+CAMPO_ID+" "+
            "INTEGER, "+CAMPO_NOMBRE+" TEXT, "+ CAMPO_TIPO_ELEMENTO +" INTEGER)";




}
