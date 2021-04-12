package co.com.luis.supervapp.infraestructures;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import co.com.luis.supervapp.utilidades.Utilidades;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_PROYECTO);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_ESTRUCTURA);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_TIPO_ELEMENTO);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_ELEMENTO);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_PILA_CHECKING);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_PROYECTOS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_ESTRUCTURAS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_TIPO_ELEMENTOS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_ELEMENTOS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_PILA_CHECKING);
        onCreate(sqLiteDatabase);
    }
}
