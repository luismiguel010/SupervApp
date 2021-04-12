package co.com.luis.supervapp.dialogs;

import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

import co.com.luis.supervapp.R;
import co.com.luis.supervapp.domain.models.TipoDeElemento;
import co.com.luis.supervapp.enums.ElementosEnum;
import co.com.luis.supervapp.infraestructures.DBHelper;
import co.com.luis.supervapp.infraestructures.queries.TipoElementoQuery;

import java.util.UUID;

public class TipoElementoDialog {

    ElementosEnum elementoEnum;
    TipoDeElemento tipoDeElemento;

    public void onCreateDialog(final Context context, final DBHelper dbHelper, final UUID idEstructura) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getString(R.string.tipoElemento));
        builder.setItems(context.getResources().getStringArray(R.array.string_array_elementos), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                elementoEnum = ElementosEnum.values()[which];
                tipoDeElemento = new TipoDeElemento(elementoEnum, idEstructura);
                new TipoElementoQuery().instertTipoElemento(context, tipoDeElemento, dbHelper);
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
