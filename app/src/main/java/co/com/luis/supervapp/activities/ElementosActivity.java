package co.com.luis.supervapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import co.com.luis.supervapp.R;
import co.com.luis.supervapp.adapters.AdapterElementos;
import co.com.luis.supervapp.builders.TipoElementoBuilder;
import co.com.luis.supervapp.dialogs.NombreElementoDialog;
import co.com.luis.supervapp.dialogs.TipoElementoDialog;
import co.com.luis.supervapp.domain.models.Elemento;
import co.com.luis.supervapp.enums.ElementosEnum;
import co.com.luis.supervapp.infraestructures.DBHelper;
import co.com.luis.supervapp.infraestructures.entities.EstructuraEntity;
import co.com.luis.supervapp.infraestructures.entities.TipoElementoEntity;
import co.com.luis.supervapp.infraestructures.queries.ElementoQuery;
import co.com.luis.supervapp.infraestructures.queries.EstructuraQuery;
import co.com.luis.supervapp.infraestructures.queries.TipoElementoQuery;
import co.com.luis.supervapp.utilidades.Utilidades;

public class ElementosActivity extends AppCompatActivity {

    FloatingActionButton mAddFab, mAddAlarmFab;
    TextView addAlarmActionText;
    Boolean isAllFabsVisible;
    ArrayList<Elemento> elementosList;
    RecyclerView recyclerView;
    DBHelper dbHelper;
    Context context;
    TipoElementoEntity tipoElementoEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elementos);
        setTitle(getResources()
                .getStringArray(R.array.string_array_elementos)[getIntent().getIntExtra("id_tipoelemento",0)]);
        mAddFab = findViewById(R.id.add_fab);
        mAddAlarmFab = findViewById(R.id.add_alarm_fab);
        addAlarmActionText = findViewById(R.id.add_alarm_action_text);
        mAddAlarmFab.setVisibility(View.GONE);
        addAlarmActionText.setVisibility(View.GONE);
        elementosList = new ArrayList<>();
        dbHelper = new DBHelper(getApplicationContext(), Utilidades.NOMBRE_BASEDEDATOS, null, Utilidades.VERSION_BASE_DE_DATOS);
        isAllFabsVisible = false;
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_elementos);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        context = getApplicationContext();

        elementosList = obtenerTodosLosElementos();

        AdapterElementos adapterElementos = new AdapterElementos(elementosList, context);
        recyclerView.setAdapter(adapterElementos);

        mAddFab.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!isAllFabsVisible) {
                            mAddAlarmFab.show();
                            addAlarmActionText.setVisibility(View.VISIBLE);
                            isAllFabsVisible = true;
                        } else {
                            mAddAlarmFab.hide();
                            addAlarmActionText.setVisibility(View.GONE);
                            isAllFabsVisible = false;
                        }
                    }
                });

        mAddAlarmFab.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showProyectoDialog();
                    }
                });
    }

    private void showProyectoDialog() {
        Context context = this;
        new NombreElementoDialog().showTextDialog(context, dbHelper, getIntent().getIntExtra("id_tipoelemento",0));
    }

    private ArrayList<Elemento> obtenerTodosLosElementos() {
        ElementoQuery elementoQuery = new ElementoQuery();
        return elementoQuery.getAllElemento(dbHelper);
    }
}