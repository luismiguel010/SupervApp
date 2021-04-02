package co.com.luis.supervapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.List;

import co.com.luis.supervapp.R;

public class CheckBoxElementosActivity extends AppCompatActivity {

    private Button buttonAnadir, buttonCancelar;
    List<String> elementosList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box_elementos);
        buttonAnadir = findViewById(R.id.button_add_elementos);
        buttonCancelar = findViewById(R.id.button_cancelar_elementos);

        buttonAnadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_pilas:
                if (checked){
                    elementosList.add(getResources().getString(R.string.elemento_pilas));
                }
                break;
            case R.id.checkbox_zapatas:
                if (checked){
                    elementosList.add(getResources().getString(R.string.elemento_zapatas));
                }
                break;
            case R.id.checkbox_micropilotes:
                if (checked){
                    elementosList.add(getResources().getString(R.string.elemento_micropilotes));
                }
                break;
            case R.id.checkbox_vigasdefundacion:
                if (checked){
                    elementosList.add(getResources().getString(R.string.elemento_vigas_de_fundacion));
                }
                break;
            case R.id.checkbox_losasdefundacion:
                if (checked){
                    elementosList.add(getResources().getString(R.string.elemento_losas_de_fundacion));
                }
                break;
            case R.id.checkbox_murosdecontencion:
                if (checked){
                    elementosList.add(getResources().getString(R.string.elemento_muros_de_contencion));
                }
                break;
            case R.id.checkbox_murosestructurales:
                if (checked){
                    elementosList.add(getResources().getString(R.string.elemento_muros_estructurales));
                }
                break;
            case R.id.checkbox_columnas:
                if (checked){
                    elementosList.add(getResources().getString(R.string.elemento_columnas));
                }
                break;
            case R.id.checkbox_losas:
                if (checked){
                    elementosList.add(getResources().getString(R.string.elemento_losas));
                }
                break;
            case R.id.checkbox_mamposterianoestructural:
                if (checked){
                    elementosList.add(getResources().getString(R.string.elemento_mamposteria_no_estructural));
                }
                break;
            case R.id.checkbox_mamposteriaestructural:
                if (checked){
                    elementosList.add(getResources().getString(R.string.elemento_mamposteria_estructural));
                }
                break;
        }
    }
}