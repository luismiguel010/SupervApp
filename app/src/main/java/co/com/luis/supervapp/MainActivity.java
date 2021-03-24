package co.com.luis.supervapp;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import co.com.luis.supervapp.adapters.AdapterProyectos;
import co.com.luis.supervapp.dialogs.ProyectoDialog;
import co.com.luis.supervapp.domain.models.Proyecto;
import co.com.luis.supervapp.infraestructures.DBHelper;
import co.com.luis.supervapp.infraestructures.queries.ProyectoQuery;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton mAddFab, mAddAlarmFab;
    TextView addAlarmActionText;
    Boolean isAllFabsVisible;
    ArrayList<Proyecto> proyectolist;
    RecyclerView recyclerView;
    DBHelper dbHelper;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAddFab = findViewById(R.id.add_fab);
        mAddAlarmFab = findViewById(R.id.add_alarm_fab);
        addAlarmActionText = findViewById(R.id.add_alarm_action_text);
        mAddAlarmFab.setVisibility(View.GONE);
        addAlarmActionText.setVisibility(View.GONE);
        proyectolist= new ArrayList<>();
        dbHelper = new DBHelper(getApplicationContext(), "db_proyecto", null, 1);
        isAllFabsVisible = false;
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        context = getApplicationContext();

        proyectolist = obtenerTodosLosProyectos();

        AdapterProyectos adapterProyectos = new AdapterProyectos(proyectolist);
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

    public void actualizarLista(){
        proyectolist = obtenerTodosLosProyectos();
        AdapterProyectos adapterProyectos = new AdapterProyectos(proyectolist);
        recyclerView.setAdapter(adapterProyectos);
        recyclerView.invalidate();
    }

    private void showProyectoDialog() {
        Context context = this;
        ProyectoDialog proyectoDialog = new ProyectoDialog();
        proyectoDialog.showTextDialog(context, dbHelper);
    }


}
