package co.com.luis.supervapp.infraestructures.queries;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.com.luis.supervapp.builders.ProyectoBuilder;
import co.com.luis.supervapp.domain.models.Proyecto;
import co.com.luis.supervapp.infraestructures.DBHelper;
import co.com.luis.supervapp.infraestructures.entities.ProyectoEntity;
import co.com.luis.supervapp.utilidades.Utilidades;

public class ProyectoQuery {

    public void insertProyecto(Context context, Proyecto proyecto, DBHelper dbHelper){
        ProyectoBuilder proyectoBuilder = new ProyectoBuilder();
        ProyectoEntity proyectoEntity = proyectoBuilder.convertirAEntity(proyecto);
        dbHelper = new DBHelper(context, "db_proyecto", null, 1);
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        if(sqLiteDatabase != null){
            ContentValues contentValues = new ContentValues();
            contentValues.put(Utilidades.CAMPO_ID, UUID.randomUUID().toString());
            contentValues.put(Utilidades.CAMPO_NOMBRE, proyectoEntity.getNombre());
            contentValues.put(Utilidades.CAMPO_CONSTRUCTORA, proyectoEntity.getConstructura());
            Long idResultante = sqLiteDatabase.insert(Utilidades.TABLA_PROYECTOS, Utilidades.CAMPO_ID,contentValues);
            Toast.makeText(context, "Id Registro: "+idResultante, Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }
    }

    public ArrayList<Proyecto> getAllProyectos(DBHelper dbHelper){
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        ProyectoEntity proyectoEntity = null;
        ArrayList<Proyecto> proyectos = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+Utilidades.TABLA_PROYECTOS, null);
        while (cursor.moveToNext()){
            proyectoEntity = new ProyectoEntity();
            proyectoEntity.setId(cursor.getInt(0));
            proyectoEntity.setNombre(cursor.getString(1));
            proyectoEntity.setConstructura(cursor.getString(2));
            ProyectoBuilder proyectoBuilder = new ProyectoBuilder();
            Proyecto proyecto = proyectoBuilder.convertirAModel(proyectoEntity);
            proyectos.add(proyecto);
        }
        return proyectos;
    }
}
