package co.com.luis.supervapp.dialogs.checkings;

import android.content.Context;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import co.com.luis.supervapp.R;
import co.com.luis.supervapp.domain.models.cheks.PilaCheck;
import co.com.luis.supervapp.infraestructures.DBHelper;
import co.com.luis.supervapp.infraestructures.entities.checks.PilaCheckEntity;
import co.com.luis.supervapp.infraestructures.queries.checks.PilaCheckQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PilaCheckDialog {

    public void onCreateDialog(final Context context, final DBHelper dbHelper, final UUID idElemento){
        final PilaCheck pilaCheck = new PilaCheckQuery().getPilaCheck(dbHelper, idElemento);
        final List<Integer> checkListTruePosition = new ArrayList<>();
        boolean[] checkedValues = new boolean[pilaCheck.getChecks().size()];
        for(int i = 0; i < pilaCheck.getChecks().size(); i++){
            checkedValues[i] = pilaCheck.getChecks().get(i);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getString(R.string.seleccionelasopcionesquecumple));
        builder.setMultiChoiceItems(context.getResources().getStringArray(R.array.string_array_pilacheck), checkedValues,
                new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which,
                                        boolean isChecked) {
                        if (isChecked) {
                            checkListTruePosition.add(which);
                        } else if (checkListTruePosition.contains(which)) {
                            checkListTruePosition.remove(Integer.valueOf(which));
                        }
                    }
                })
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        List<Boolean> checkList = new ArrayList<>();
                        for(int i = 0; i < checkListTruePosition.size(); i++){
                            checkList = pilaCheck.getChecks();
                            checkList.set(checkListTruePosition.get(i), true);
                        }
                        pilaCheck.setChecks(checkList);
                        new PilaCheckQuery().updatePilaCheck(context, pilaCheck, dbHelper, idElemento);
                    }
                })
                .setNegativeButton(R.string.cancelar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        builder.show();
    }
}
