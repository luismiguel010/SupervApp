package co.com.luis.supervapp.dialogs;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import co.com.luis.supervapp.R;
import co.com.luis.supervapp.domain.models.Proyecto;

public class ProyectoDialog {

    Proyecto proyecto;
    String nombreProyecto;
    String constructora;

    public void showTextDialog(final Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);
        final EditText inputNombre = new EditText(context);
        inputNombre.setHint(context.getString(R.string.nombreproyecto));
        layout.addView(inputNombre);
        final EditText inputConstructora = new EditText(context);
        inputConstructora.setHint(context.getString(R.string.nombreconstructora));
        layout.addView(inputConstructora);
        builder.setTitle(context.getString(R.string.ingresedatosdelproyecto));
        builder.setView(layout);
        builder.setPositiveButton(context.getString(R.string.crear), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                nombreProyecto = inputNombre.getText().toString();
                constructora = inputConstructora.getText().toString();
                proyecto = new Proyecto(nombreProyecto, constructora);
                //Aquí guardad en database
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
