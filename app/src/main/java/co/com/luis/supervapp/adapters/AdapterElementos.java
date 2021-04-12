package co.com.luis.supervapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import co.com.luis.supervapp.R;
import co.com.luis.supervapp.activities.ElementosActivity;
import co.com.luis.supervapp.builders.ElementoBuilder;
import co.com.luis.supervapp.dialogs.checkings.PilaCheckDialog;
import co.com.luis.supervapp.domain.models.Elemento;
import co.com.luis.supervapp.infraestructures.DBHelper;
import co.com.luis.supervapp.infraestructures.entities.ElementoEntity;
import co.com.luis.supervapp.infraestructures.entities.checks.PilaCheckEntity;
import co.com.luis.supervapp.infraestructures.queries.ElementoQuery;
import co.com.luis.supervapp.infraestructures.queries.checks.PilaCheckQuery;

public class AdapterElementos extends RecyclerView.Adapter<AdapterElementos.ViewHolderElemento> {

    ArrayList<Elemento> elementosList;
    private Context context;
    DBHelper dbHelper;

    public AdapterElementos(ArrayList<Elemento> elementosList, Context context, DBHelper dbHelper) {
        this.elementosList = elementosList;
        this.context = context;
        this.dbHelper = dbHelper;
    }

    @NonNull
    @Override
    public AdapterElementos.ViewHolderElemento onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_elemento,null, false);
        return new AdapterElementos.ViewHolderElemento(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterElementos.ViewHolderElemento holder, final int position) {
        holder.nombre.setText(elementosList.get(position).getNombre());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ElementoEntity elementoEntity = new ElementoEntity();
                elementoEntity = new ElementoQuery().getElementoPorId(dbHelper, elementosList.get(position));
                new PilaCheckDialog().onCreateDialog(context, dbHelper, elementoEntity.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return elementosList.size();
    }

    public class ViewHolderElemento extends RecyclerView.ViewHolder {

        TextView nombre;

        public ViewHolderElemento(@NonNull View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.nombre);
            context = itemView.getContext();
        }
    }
}
