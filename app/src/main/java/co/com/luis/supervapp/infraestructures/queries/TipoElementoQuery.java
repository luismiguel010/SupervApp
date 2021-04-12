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
            contentValues.put(Utilidades.CAMPO_ID_ESTRUCTURA, tipoElementoEntity.getIdEstructura().toString());
            Long idResultante = sqLiteDatabase.insert(Utilidades.TABLA_TIPO_ELEMENTOS, Utilidades.CAMPO_TIPO_ELEMENTO,contentValues);
            Toast.makeText(context, "Id Registro: "+idResultante, Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }
    }


    public ArrayList<TipoDeElemento> obtenerTipoElementosPorIdEstructura(DBHelper dbHelper, UUID idEstructura){
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        TipoElementoEntity tipoElementoEntity = null;
        ArrayList<TipoDeElemento> tipoDeElementos = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+Utilidades.TABLA_TIPO_ELEMENTOS+" WHERE id_estructura=?", new String[]{String.valueOf(idEstructura)});
        while (cursor.moveToNext()){
            tipoElementoEntity = new TipoElementoEntity();
            tipoElementoEntity.setTipoElemento(cursor.getInt(0));
            tipoElementoEntity.setIdEstructura(UUID.fromString(cursor.getString(1)));
            TipoDeElemento tipoDeElemento = new TipoElementoBuilder().convertirAModelo(tipoElementoEntity);
            tipoDeElementos.add(tipoDeElemento);
        }
        return tipoDeElementos;
    }
}
