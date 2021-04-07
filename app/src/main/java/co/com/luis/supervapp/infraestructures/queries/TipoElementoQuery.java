package co.com.luis.supervapp.infraestructures.queries;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.UUID;

import co.com.luis.supervapp.builders.TipoElementoBuilder;
import co.com.luis.supervapp.domain.models.TipoDeElemento;
import co.com.luis.supervapp.infraestructures.DBHelper;
import co.com.luis.supervapp.infraestructures.entities.TipoElementoEntity;
import co.com.luis.supervapp.utilidades.Utilidades;

public class TipoElementoQuery {

    public void instertTipoElemento(Context context, TipoDeElemento tipoDeElemento, DBHelper dbHelper){
        TipoElementoBuilder tipoElementoBuilder = new TipoElementoBuilder();
        TipoElementoEntity tipoElementoEntity = tipoElementoBuilder.convertirAEntity(tipoDeElemento);
        dbHelper = new DBHelper(context, Utilidades.NOMBRE_BASEDEDATOS, null, Utilidades.VERSION_BASE_DE_DATOS);
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        if(sqLiteDatabase != null){
            ContentValues contentValues = new ContentValues();
            contentValues.put(Utilidades.CAMPO_TIPO_ELEMENTO, tipoElementoEntity.getTipoElemento());
            contentValues.put(Utilidades.CAMPO_ID_ESTRUCTURA, tipoElementoEntity.getIdEstructura());
            Long idResultante = sqLiteDatabase.insert(Utilidades.TABLA_TIPO_ELEMENTOS, Utilidades.CAMPO_TIPO_ELEMENTO,contentValues);
            Toast.makeText(context, "Id Registro: "+idResultante, Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }
    }


    public ArrayList<TipoDeElemento> obtenerTipoElementosPorIdEstructura(DBHelper dbHelper, Integer idEstructura){
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        TipoElementoEntity tipoElementoEntity = null;
        ArrayList<TipoDeElemento> tipoDeElementos = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+Utilidades.TABLA_TIPO_ELEMENTOS+" WHERE "+Utilidades.CAMPO_ID_ESTRUCTURA+"=?", new String[]{idEstructura.toString()});
        while (cursor.moveToNext()){
            tipoElementoEntity.setTipoElemento(cursor.getInt(0));
            //Falla acá, null pointer al setear ese valor
            tipoElementoEntity.setIdEstructura(cursor.getInt(1));
            TipoDeElemento tipoDeElemento = new TipoElementoBuilder().convertirAModelo(tipoElementoEntity);
            tipoDeElementos.add(tipoDeElemento);
        }
        return tipoDeElementos;
    }
}
