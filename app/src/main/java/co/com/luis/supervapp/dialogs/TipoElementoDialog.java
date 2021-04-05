package co.com.luis.supervapp.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AlertDialog;

import co.com.luis.supervapp.R;
import co.com.luis.supervapp.domain.models.Elemento;
import co.com.luis.supervapp.enums.ElementosEnum;
import co.com.luis.supervapp.infraestructures.DBHelper;
import co.com.luis.supervapp.infraestructures.queries.ElementoQuery;

public class TipoElementoDialog {

    ElementosEnum tipoElemento;

    public void onCreateDialog(final Context context, final DBHelper dbHelper, final Integer idEstructura) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getString(R.string.tipoElemento));
        builder.setItems(context.getResources().getStringArray(R.array.string_array_elementos), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tipoElemento = ElementosEnum.values()[which];
                NombreElementoDialog nombreElementoDialog = new NombreElementoDialog();
                nombreElementoDialog.showTextDialog(context, dbHelper, idEstructura, tipoElemento);
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
