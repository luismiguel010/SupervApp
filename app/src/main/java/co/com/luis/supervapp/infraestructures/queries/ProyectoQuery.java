package co.com.luis.supervapp.infraestructures.queries;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import co.com.luis.supervapp.builders.ProyectoBuilder;
import co.com.luis.supervapp.domain.models.Proyecto;
import co.com.luis.supervapp.infraestructures.DBHelper;
import co.com.luis.supervapp.infraestructures.entities.ProyectoEntity;

public class ProyectoQuery {

    public void insertProyecto(Context context, Proyecto proyecto){
        ProyectoBuilder proyectoBuilder = new ProyectoBuilder();
        ProyectoEntity proyectoEntity = proyectoBuilder.convertirAEntity(proyecto);
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        if(sqLiteDatabase != null){
            ContentValues contentValues = new ContentValues();
            contentValues.put("nombre", proyectoEntity.getNombre());
            contentValues.put("constructora", proyectoEntity.getConstructura());
        }
    }

    public void getAllProyectos(Context context){
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
    }
}
