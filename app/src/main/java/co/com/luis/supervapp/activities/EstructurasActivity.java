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
import co.com.luis.supervapp.adapters.AdapterEstructuras;
import co.com.luis.supervapp.adapters.AdapterProyectos;
import co.com.luis.supervapp.dialogs.EstructuraDialog;
import co.com.luis.supervapp.dialogs.ProyectoDialog;
import co.com.luis.supervapp.domain.models.Estructura;
import co.com.luis.supervapp.domain.models.Proyecto;
import co.com.luis.supervapp.infraestructures.DBHelper;
import co.com.luis.supervapp.infraestructures.entities.ProyectoEntity;
import co.com.luis.supervapp.infraestructures.queries.EstructuraQuery;
import co.com.luis.supervapp.infraestructures.queries.ProyectoQuery;
import co.com.luis.supervapp.utilidades.Utilidades;

public class EstructurasActivity extends AppCompatActivity {

    FloatingActionButton mAddFab, mAddAlarmFab;
    TextView addAlarmActionText;
    Boolean isAllFabsVisible;
    ArrayList<Estructura> estructurasList;
    RecyclerView recyclerView;
    DBHelper dbHelper;
    Context context;
    ProyectoEntity proyectoEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estructuras);
        setTitle(getIntent().getStringExtra("nombre_proyecto"));
        mAddFab = findViewById(R.id.add_fab);
        mAddAlarmFab = findViewById(R.id.add_alarm_fab);
        addAlarmActionText = findViewById(R.id.add_alarm_action_text);
        mAddAlarmFab.setVisibility(View.GONE);
        addAlarmActionText.setVisibility(View.GONE);
        estructurasList = new ArrayList<>();
        dbHelper = new DBHelper(getApplicationContext(), Utilidades.NOMBRE_BASEDEDATOS, null, 1);
        isAllFabsVisible = false;
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_estructuras);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        context = getApplicationContext();
        
        estructurasList = obtenerTodasLasEstructuras();
        proyectoEntity = obtenerProyecto(getIntent().getStringExtra("nombre_proyecto"));

        AdapterEstructuras adapterEstructuras = new AdapterEstructuras(estructurasList, context);
        recyclerView.setAdapter(adapterEstructuras);

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

    private ProyectoEntity obtenerProyecto(String nombre_proyecto) {
        ProyectoQuery proyectoQuery = new ProyectoQuery();
        return proyectoQuery.getProyectoByNombre(dbHelper, nombre_proyecto);
    }

    private void showProyectoDialog() {
        Context context = this;
        EstructuraDialog estructuraDialog = new EstructuraDialog();
        estructuraDialog.showTextDialog(context, dbHelper, proyectoEntity.getId());
    }

    private ArrayList<Estructura> obtenerTodasLasEstructuras() {
        EstructuraQuery estructuraQuery = new EstructuraQuery();
        return estructuraQuery.getAllEstructura(dbHelper);
    }
}