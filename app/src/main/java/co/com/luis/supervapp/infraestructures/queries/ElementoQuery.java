package co.com.luis.supervapp.infraestructures.queries;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.UUID;

import co.com.luis.supervapp.builders.ElementoBuilder;
import co.com.luis.supervapp.domain.models.Elemento;
import co.com.luis.supervapp.infraestructures.DBHelper;
import co.com.luis.supervapp.infraestructures.entities.ElementoEntity;
import co.com.luis.supervapp.utilidades.Utilidades;

public class ElementoQuery {

    public void insertElemento(Context context, Elemento elemento, DBHelper dbHelper){
        ElementoBuilder elementoBuilder = new ElementoBuilder();
        ElementoEntity elementoEntity = elementoBuilder.convertirAEntity(elemento);
        dbHelper = new DBHelper(context, Utilidades.NOMBRE_BASEDEDATOS, null, Utilidades.VERSION_BASE_DE_DATOS);
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        if(sqLiteDatabase != null){
            ContentValues contentValues = new ContentValues();
            contentValues.put(Utilidades.CAMPO_ID, UUID.randomUUID().toString());
            contentValues.put(Utilidades.CAMPO_NOMBRE, elementoEntity.getNombre());
            contentValues.put(Utilidades.CAMPO_ID_ESTRUCTURA, elementoEntity.getIdEstructura());
            sqLiteDatabase.close();
        }
    }

    public ArrayList<Elemento> getAllElemento(DBHelper dbHelper){
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        ElementoEntity elementoEntity = null;
        ArrayList<Elemento> elementos = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+Utilidades.TABLA_ELEMENTOS, null);
        while (cursor.moveToNext()){
            elementoEntity = new ElementoEntity();
            elementoEntity.setId(cursor.getInt(0));
            elementoEntity.setNombre(cursor.getString(1));
            elementoEntity.setIdEstructura(cursor.getInt(2));
            ElementoBuilder elementoBuilder = new ElementoBuilder();
            Elemento elemento = elementoBuilder.convertirAModel(elementoEntity);
            elementos.add(elemento);
        }
        return elementos;
    }
}
