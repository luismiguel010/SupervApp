package co.com.luis.supervapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import co.com.luis.supervapp.adapters.AdapterProyectos;
import co.com.luis.supervapp.dialogs.ProyectoDialog;
import co.com.luis.supervapp.domain.models.Proyecto;
import co.com.luis.supervapp.infraestructures.DBHelper;
import co.com.luis.supervapp.infraestructures.queries.ProyectoQuery;
import co.com.luis.supervapp.utilidades.Utilidades;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton mAddFab, mAddAlarmFab;
    TextView addAlarmActionText;
    Boolean isAllFabsVisible;
    ArrayList<Proyecto> proyectolist;
    RecyclerView recyclerView;
    DBHelper dbHelper;
    Context context;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Proyectos");
        mAddFab = findViewById(R.id.add_fab);
        mAddAlarmFab = findViewById(R.id.add_alarm_fab);
        addAlarmActionText = findViewById(R.id.add_alarm_action_text);
        mAddAlarmFab.setVisibility(View.GONE);
        addAlarmActionText.setVisibility(View.GONE);
        proyectolist= new ArrayList<>();
        dbHelper = new DBHelper(getApplicationContext(), Utilidades.NOMBRE_BASEDEDATOS, null, Utilidades.VERSION_BASE_DE_DATOS);
        isAllFabsVisible = false;
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        context = getApplicationContext();

        proyectolist = obtenerTodosLosProyectos();

        AdapterProyectos adapterProyectos = new AdapterProyectos(proyectolist, context);
        recyclerView.setAdapter(adapterProyectos);

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

    public ArrayList<Proyecto> obtenerTodosLosProyectos(){
        ProyectoQuery proyectoQuery = new ProyectoQuery();
        return proyectoQuery.getAllProyectos(dbHelper);
    }

    private void showProyectoDialog() {
        Context context = this;
        ProyectoDialog proyectoDialog = new ProyectoDialog();
        proyectoDialog.showTextDialog(context, dbHelper);
    }


    public void refreshList(Context context) {
        ProyectoQuery proyectoQuery = new ProyectoQuery();
        dbHelper = new DBHelper(context, Utilidades.NOMBRE_BASEDEDATOS, null, Utilidades.VERSION_BASE_DE_DATOS);
        proyectolist = proyectoQuery.getAllProyectos(dbHelper);
        AdapterProyectos adapterProyectos = new AdapterProyectos(proyectolist, context);
        context = adapterProyectos.update();
        intent = new Intent(context, MainActivity.class);
        finish();
        overridePendingTransition(0, 0);
        context.startActivity(intent);
        overridePendingTransition(0, 0);
    }
}
