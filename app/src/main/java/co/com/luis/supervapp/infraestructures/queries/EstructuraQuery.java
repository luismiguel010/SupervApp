package co.com.luis.supervapp.infraestructures.queries;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.UUID;

import co.com.luis.supervapp.builders.EstructuraBuilder;
import co.com.luis.supervapp.domain.models.Estructura;
import co.com.luis.supervapp.infraestructures.DBHelper;
import co.com.luis.supervapp.infraestructures.entities.EstructuraEntity;
import co.com.luis.supervapp.infraestructures.entities.ProyectoEntity;
import co.com.luis.supervapp.utilidades.Utilidades;

public class EstructuraQuery {

    public void insertEstructura(Context context, Estructura estructura, DBHelper dbHelper){
        EstructuraBuilder estructuraBuilder = new EstructuraBuilder();
        EstructuraEntity estructuraEntity = estructuraBuilder.convertirAEntity(estructura);
        dbHelper = new DBHelper(context, Utilidades.NOMBRE_BASEDEDATOS, null, Utilidades.VERSION_BASE_DE_DATOS);
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        if(sqLiteDatabase != null){
            ContentValues contentValues = new ContentValues();
            contentValues.put(Utilidades.CAMPO_ID, UUID.randomUUID().toString());
            contentValues.put(Utilidades.CAMPO_NOMBRE, estructuraEntity.getNombre());
            contentValues.put(Utilidades.CAMPO_ID_PROYECTO, estructuraEntity.getId_proyecto());
            Long idResultante = sqLiteDatabase.insert(Utilidades.TABLA_ESTRUCTURAS, Utilidades.CAMPO_ID,contentValues);
            Toast.makeText(context, "Id Registro: "+idResultante, Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }
    }

    public ArrayList<Estructura> getAllEstructura(DBHelper dbHelper){
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        EstructuraEntity estructuraEntity = null;
        ArrayList<Estructura> estructuras = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+Utilidades.TABLA_ESTRUCTURAS, null);
        while (cursor.moveToNext()){
            estructuraEntity = new EstructuraEntity();
            estructuraEntity.setId(cursor.getInt(0));
            estructuraEntity.setNombre(cursor.getString(1));
            estructuraEntity.setId_proyecto(cursor.getInt(2));
            EstructuraBuilder estructuraBuilder = new EstructuraBuilder();
            Estructura estructura = estructuraBuilder.convertirAModel(estructuraEntity);
            estructuras.add(estructura);
        }
        return estructuras;
    }

    public EstructuraEntity getEstructuraByNombre(DBHelper dbHelper, String nombreEstructura){
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        EstructuraEntity estructuraEntity = null;
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+Utilidades.TABLA_ESTRUCTURAS+" WHERE "+Utilidades.CAMPO_NOMBRE+"=?", new String[]{nombreEstructura});
        while (cursor.moveToNext()){
            estructuraEntity = new EstructuraEntity();
            estructuraEntity.setId(cursor.getInt(0));
            estructuraEntity.setNombre(cursor.getString(1));
            estructuraEntity.setId_proyecto(cursor.getInt(2));
        }
        return estructuraEntity;
    }
}
