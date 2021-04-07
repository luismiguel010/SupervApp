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
import co.com.luis.supervapp.adapters.AdapterTipoElementos;
import co.com.luis.supervapp.dialogs.TipoElementoDialog;
import co.com.luis.supervapp.domain.models.TipoDeElemento;
import co.com.luis.supervapp.infraestructures.DBHelper;
import co.com.luis.supervapp.infraestructures.entities.EstructuraEntity;
import co.com.luis.supervapp.infraestructures.queries.EstructuraQuery;
import co.com.luis.supervapp.infraestructures.queries.TipoElementoQuery;
import co.com.luis.supervapp.utilidades.Utilidades;

public class TipoElementosActivity extends AppCompatActivity {

    FloatingActionButton mAddFab, mAddAlarmFab;
    TextView addAlarmActionText;
    Boolean isAllFabsVisible;
    ArrayList<TipoDeElemento> tipoDeElementosList;
    RecyclerView recyclerView;
    DBHelper dbHelper;
    Context context;
    EstructuraEntity estructuraEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_elementos);
        setTitle(getIntent().getStringExtra("nombre_estructura"));
        mAddFab = findViewById(R.id.add_fab);
        mAddAlarmFab = findViewById(R.id.add_alarm_fab);
        addAlarmActionText = findViewById(R.id.add_alarm_action_text);
        mAddAlarmFab.setVisibility(View.GONE);
        addAlarmActionText.setVisibility(View.GONE);
        tipoDeElementosList = new ArrayList<>();
        dbHelper = new DBHelper(getApplicationContext(), Utilidades.NOMBRE_BASEDEDATOS, null, Utilidades.VERSION_BASE_DE_DATOS);
        isAllFabsVisible = false;
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_tipo_elementos);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        context = getApplicationContext();

        estructuraEntity = obtenerEstructura(getIntent().getStringExtra("nombre_estructura"));
        tipoDeElementosList = obtenerTipoElementosPorIdEstructura(estructuraEntity.getId());

        AdapterTipoElementos adapterTipoElementos = new AdapterTipoElementos(tipoDeElementosList, context);
        recyclerView.setAdapter(adapterTipoElementos);

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
        new TipoElementoDialog().onCreateDialog(context, dbHelper, estructuraEntity.getId());
    }

    private EstructuraEntity obtenerEstructura(String nombreEstructura) {
        return new EstructuraQuery().getEstructuraByNombre(dbHelper, nombreEstructura);
    }

    private ArrayList<TipoDeElemento> obtenerTipoElementosPorIdEstructura(Integer idEstructura){
        return new TipoElementoQuery().obtenerTipoElementosPorIdEstructura(dbHelper, idEstructura);
    }
}