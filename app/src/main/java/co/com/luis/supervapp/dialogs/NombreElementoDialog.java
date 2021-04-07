package co.com.luis.supervapp.dialogs;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AlertDialog;

import co.com.luis.supervapp.R;
import co.com.luis.supervapp.builders.ElementoBuilder;
import co.com.luis.supervapp.domain.models.Elemento;
import co.com.luis.supervapp.enums.ElementosEnum;
import co.com.luis.supervapp.infraestructures.DBHelper;
import co.com.luis.supervapp.infraestructures.queries.ElementoQuery;

public class NombreElementoDialog {

    String nombreElemento;

    public void showTextDialog(final Context context, final DBHelper dbHelper, final Integer idElemento){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);
        final EditText inputNombre = new EditText(context);
        inputNombre.setHint(context.getString(R.string.nombreelemento));
        layout.addView(inputNombre);
        builder.setTitle("Ingrese el nombre del elemento "+context.getResources().getStringArray(R.array.string_array_elementos)[idElemento]);
        builder.setView(layout);
        builder.setPositiveButton(context.getString(R.string.crear), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                nombreElemento = inputNombre.getText().toString();
                Elemento elemento = new Elemento(nombreElemento, idElemento);
                ElementoQuery elementoQuery = new ElementoQuery();
                elementoQuery.insertElemento(context, elemento, dbHelper);
            }
        });
        builder.setNegativeButton(context.getString(R.string.cancelar), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }
}
