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
import co.com.luis.supervapp.activities.CheckBoxElementosActivity;
import co.com.luis.supervapp.activities.EstructurasActivity;
import co.com.luis.supervapp.domain.models.Estructura;

public class AdapterEstructuras extends RecyclerView.Adapter<AdapterEstructuras.ViewHolderEstructura> {

    ArrayList<Estructura> estructurasList;
    private Context context;

    public AdapterEstructuras(ArrayList<Estructura> estructurasList, Context context) {
        this.estructurasList = estructurasList;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterEstructuras.ViewHolderEstructura onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_estructura,null, false);
        return new AdapterEstructuras.ViewHolderEstructura(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterEstructuras.ViewHolderEstructura holder, final int position) {
        holder.nombre.setText(estructurasList.get(position).getNombre());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CheckBoxElementosActivity.class);
                intent.putExtra("nombre_estructura", estructurasList.get(position).getNombre());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return estructurasList.size();
    }

    public class ViewHolderEstructura extends RecyclerView.ViewHolder {

        TextView nombre;

        public ViewHolderEstructura(@NonNull View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.nombre);
            context = itemView.getContext();
        }
    }
}
