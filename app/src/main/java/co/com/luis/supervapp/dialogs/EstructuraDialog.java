package co.com.luis.supervapp.dialogs;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import co.com.luis.supervapp.R;
import co.com.luis.supervapp.adapters.AdapterProyectos;
import co.com.luis.supervapp.domain.models.Estructura;
import co.com.luis.supervapp.domain.models.Proyecto;
import co.com.luis.supervapp.infraestructures.DBHelper;
import co.com.luis.supervapp.infraestructures.queries.EstructuraQuery;
import co.com.luis.supervapp.infraestructures.queries.ProyectoQuery;

public class EstructuraDialog {

    Estructura estructura;
    String nombreEstructura;
    RecyclerView recyclerView;
    AdapterProyectos adapterProyectos;

    public void showTextDialog(final Context context, final DBHelper dbHelper, final Integer idProyecto){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);
        final EditText inputNombre = new EditText(context);
        inputNombre.setHint(context.getString(R.string.nombreestructura));
        layout.addView(inputNombre);
        builder.setTitle(context.getString(R.string.ingresedatosdelaestructura));
        builder.setView(layout);
        builder.setPositiveButton(context.getString(R.string.crear), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                nombreEstructura = inputNombre.getText().toString();
                estructura = new Estructura(nombreEstructura, idProyecto);
                EstructuraQuery estructuraQuery = new EstructuraQuery();
                estructuraQuery.insertEstructura(context, estructura, dbHelper);
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
