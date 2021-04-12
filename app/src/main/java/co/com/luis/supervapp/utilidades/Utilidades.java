package co.com.luis.supervapp.utilidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utilidades {

    //----------------------------------------------------------
    //Constantes generales
    //----------------------------------------------------------
    public static final String NOMBRE_BASEDEDATOS = "db_supervapp";
    public static final int VERSION_BASE_DE_DATOS = 10;
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
    //Constantes campos tabla pila checking
    //----------------------------------------------------------
    public static final String TABLA_PILA_CHECKING = "pilachecking";
    public static final List<String> CHECK_LIST_PILAS = Collections.unmodifiableList(
            new ArrayList<String>(){{
                add("is_diametro");
                add("is_profundidad");
                add("is_altura_campana");
                add("is_altura_pila");
                add("is_material");
                add("is_acero_refuerzo");
            }});
    public static final String IS_DIAMETRO = "is_diametro";
    public static final String IS_PROFUNDIDAD = "is_profundidad";
    public static final String IS_ALTURA_CAMPANA = "is_altura_campana";
    public static final String IS_ALTURA_PILA = "is_altura_pila";
    public static final String IS_MATERIAL = "is_material";
    public static final String IS_ACERO_REFUERZO = "is_acero_refuerzo";
    //----------------------------------------------------------
    //Constantes creación de tablas
    //----------------------------------------------------------
    public static final String CREAR_TABLA_PROYECTO="CREATE TABLE " +
            ""+TABLA_PROYECTOS+" ("+CAMPO_ID+" "+
            "TEXT, "+CAMPO_NOMBRE+" TEXT,"+CAMPO_CONSTRUCTORA+" TEXT)";

    public static final String CREAR_TABLA_ESTRUCTURA="CREATE TABLE " +
            ""+TABLA_ESTRUCTURAS+" ("+CAMPO_ID+" "+
            "TEXT, "+CAMPO_NOMBRE+" TEXT,"+CAMPO_ID_PROYECTO+" INTEGER)";

    public static final String CREAR_TABLA_TIPO_ELEMENTO="CREATE TABLE " +
            ""+TABLA_TIPO_ELEMENTOS+" ("+CAMPO_TIPO_ELEMENTO+" "+
            "TEXT, "+CAMPO_ID_ESTRUCTURA+" INTEGER)";

    public static final String CREAR_TABLA_ELEMENTO="CREATE TABLE " +
            ""+TABLA_ELEMENTOS+" ("+CAMPO_ID+" "+
            "TEXT, "+CAMPO_NOMBRE+" TEXT, "+ CAMPO_TIPO_ELEMENTO +" INTEGER)";

    public static final String CREAR_TABLA_PILA_CHECKING="CREATE TABLE " +
            ""+TABLA_PILA_CHECKING+" ("+CAMPO_ID+" "+
            "TEXT, "+IS_DIAMETRO+" INTEGER, "+IS_PROFUNDIDAD+" INTEGER, "+
            IS_ALTURA_CAMPANA+" INTEGER, "+ IS_ALTURA_PILA+" INTEGER, "+
            IS_MATERIAL+" INTEGER, "+IS_ACERO_REFUERZO+" INTEGER)";
}
