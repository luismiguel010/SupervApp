package co.com.luis.supervapp.infraestructures.queries.checks;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;
import co.com.luis.supervapp.builders.checks.PilaCheckBuilder;
import co.com.luis.supervapp.domain.models.cheks.PilaCheck;
import co.com.luis.supervapp.infraestructures.DBHelper;
import co.com.luis.supervapp.infraestructures.entities.checks.PilaCheckEntity;
import co.com.luis.supervapp.utilidades.Utilidades;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PilaCheckQuery {

    public void insertarPilaCheck(Context context, PilaCheck pilaCheck, DBHelper dbHelper){
        PilaCheckEntity pilaCheckEntity = new PilaCheckBuilder().convertirAEntity(pilaCheck);
        dbHelper = new DBHelper(context, Utilidades.NOMBRE_BASEDEDATOS, null, Utilidades.VERSION_BASE_DE_DATOS);
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        if(sqLiteDatabase != null){
            ContentValues contentValues = new ContentValues();
            contentValues.put(Utilidades.CAMPO_ID, pilaCheck.getIdElemento().toString());
            for(int i = 0; i < pilaCheckEntity.getChecks().size(); i++){
                contentValues.put(Utilidades.CHECK_LIST_PILAS.get(i), pilaCheckEntity.getChecks().get(i));
            }
            Long idResultante = sqLiteDatabase.insert(Utilidades.TABLA_PILA_CHECKING, Utilidades.CAMPO_ID,contentValues);
            Toast.makeText(context, "Id Registro: "+idResultante, Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }
    }

    public PilaCheck getPilaCheck(DBHelper dbHelper, UUID idElemento){
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        PilaCheckEntity pilaCheckEntity = new PilaCheckEntity();
        PilaCheck pilaCheck = null;
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+Utilidades.TABLA_PILA_CHECKING+
                " WHERE "+Utilidades.CAMPO_ID+"=?", new String[]{String.valueOf(idElemento)});
        while (cursor.moveToNext()){
            pilaCheckEntity.setIdElemento(UUID.fromString(cursor.getString(0)));
            List<Integer> checkList = new ArrayList<>();
            for(int i = 1; i <= Utilidades.CHECK_LIST_PILAS.size(); i++){
                checkList.add(cursor.getInt(i));
            }
            pilaCheckEntity.setChecks(checkList);
            pilaCheck = new PilaCheckBuilder().convertirADomain(pilaCheckEntity);
        }
        sqLiteDatabase.close();
        return pilaCheck;

    }

    public void updatePilaCheck(Context context, PilaCheck pilaCheck, DBHelper dbHelper, UUID idElemento) {
        PilaCheckEntity pilaCheckEntity = new PilaCheckBuilder().convertirAEntity(pilaCheck);
        dbHelper = new DBHelper(context, Utilidades.NOMBRE_BASEDEDATOS, null, Utilidades.VERSION_BASE_DE_DATOS);
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        if(sqLiteDatabase != null){
            ContentValues contentValues = new ContentValues();
            for(int i = 0; i < pilaCheckEntity.getChecks().size(); i++){
                contentValues.put(Utilidades.CHECK_LIST_PILAS.get(i), pilaCheckEntity.getChecks().get(i));
            }
            int idResultante = sqLiteDatabase.update(Utilidades.TABLA_PILA_CHECKING, contentValues, Utilidades.CAMPO_ID+"=?", new String[]{String.valueOf(idElemento)});
            Toast.makeText(context, "Id Registro: "+idResultante, Toast.LENGTH_SHORT).show();
            sqLiteDatabase.close();
        }
    }
}
