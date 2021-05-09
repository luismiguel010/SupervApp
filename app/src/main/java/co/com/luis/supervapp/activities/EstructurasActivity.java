package co.com.luis.supervapp.activities;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import co.com.luis.supervapp.MainActivity;
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
    Intent intent;

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
        dbHelper = new DBHelper(getApplicationContext(), Utilidades.NOMBRE_BASEDEDATOS, null, Utilidades.VERSION_BASE_DE_DATOS);
        isAllFabsVisible = false;
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_estructuras);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        context = getApplicationContext();

        proyectoEntity = obtenerProyecto(getIntent().getStringExtra("nombre_proyecto"), dbHelper, context);
        estructurasList = obtenerTodasLasEstructuras();

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

        private ProyectoEntity obtenerProyecto(String nombre_proyecto, DBHelper dbHelper, Context context) {
        ProyectoQuery proyectoQuery = new ProyectoQuery();
        return proyectoQuery.getProyectoByNombre(dbHelper, nombre_proyecto, context);
    }

    private void showProyectoDialog() {
        Context context = this;
        EstructuraDialog estructuraDialog = new EstructuraDialog();
        estructuraDialog.showTextDialog(context, dbHelper, proyectoEntity.getId());
    }

    private ArrayList<Estructura> obtenerTodasLasEstructuras() {
        EstructuraQuery estructuraQuery = new EstructuraQuery();
        return estructuraQuery.getAllEstructura(dbHelper, proyectoEntity.getId());
    }

    public void refreshList(Context context) {
        EstructuraQuery estructuraQuery = new EstructuraQuery();
        dbHelper = new DBHelper(context, Utilidades.NOMBRE_BASEDEDATOS, null, Utilidades.VERSION_BASE_DE_DATOS);
        Intent intent = new Intent(context, EstructurasActivity.class);
        proyectoEntity = obtenerProyecto(intent.getStringExtra("nombre_proyecto"), dbHelper, context);
        estructurasList = estructuraQuery.getAllEstructura(dbHelper, proyectoEntity.getId());
        AdapterEstructuras adapterEstructuras = new AdapterEstructuras(estructurasList, context);
        context = adapterEstructuras.update();
        finish();
        overridePendingTransition(0, 0);
        context.startActivity(intent);
        overridePendingTransition(0, 0);
    }
}