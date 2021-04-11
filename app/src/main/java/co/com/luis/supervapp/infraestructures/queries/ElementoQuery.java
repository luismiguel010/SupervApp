package co.com.luis.supervapp.infraestructures.queries;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

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
            contentValues.put(Utilidades.CAMPO_TIPO_ELEMENTO, elementoEntity.getIdElemento());
            Long idResultante = sqLiteDatabase.insert(Utilidades.TABLA_ELEMENTOS, Utilidades.CAMPO_ID,contentValues);
            Toast.makeText(context, "Id Registro: "+idResultante, Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }
    }

    public ArrayList<Elemento> getAllElemento(DBHelper dbHelper, Integer idTipoElemento){
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        ElementoEntity elementoEntity = null;
        ArrayList<Elemento> elementos = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+Utilidades.TABLA_ELEMENTOS+
                " WHERE "+Utilidades.CAMPO_TIPO_ELEMENTO+"=?", new String[]{String.valueOf(idTipoElemento)});
        while (cursor.moveToNext()){
            elementoEntity = new ElementoEntity();
            elementoEntity.setId(cursor.getInt(0));
            elementoEntity.setNombre(cursor.getString(1));
            elementoEntity.setIdElemento(cursor.getInt(2));
            ElementoBuilder elementoBuilder = new ElementoBuilder();
            Elemento elemento = elementoBuilder.convertirAModel(elementoEntity);
            elementos.add(elemento);
        }
        return elementos;
    }
}
