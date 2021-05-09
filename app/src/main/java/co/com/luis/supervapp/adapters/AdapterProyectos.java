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

import co.com.luis.supervapp.MainActivity;
import co.com.luis.supervapp.R;
import co.com.luis.supervapp.activities.EstructurasActivity;
import co.com.luis.supervapp.domain.models.Proyecto;

public class AdapterProyectos extends RecyclerView.Adapter<AdapterProyectos.ViewHolderProyecto> {

    ArrayList<Proyecto> proyectolist;
    private Context context;

    public AdapterProyectos(ArrayList<Proyecto> proyectolist, Context context){
        this.proyectolist = proyectolist;
        this.context = context;
    }

    public ArrayList<Proyecto> getProyectolist() {
        return proyectolist;
    }

    public Context getContext() {
        return context;
    }

    @NonNull
    @Override
    public ViewHolderProyecto onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_proyecto,null, false);
        return new ViewHolderProyecto(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolderProyecto holder, final int position) {
        holder.nombre.setText(proyectolist.get(position).getNombre());
        holder.constructora.setText(proyectolist.get(position).getConstructura());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, EstructurasActivity.class);
                intent.putExtra("nombre_proyecto", proyectolist.get(position).getNombre());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return proyectolist.size();
    }

    public class ViewHolderProyecto extends RecyclerView.ViewHolder {

        TextView nombre, constructora;

        public ViewHolderProyecto(@NonNull View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.nombre);
            constructora = (TextView) itemView.findViewById(R.id.contructora);
            context = itemView.getContext();
        }
    }

    public Context update(){
        ArrayList<Proyecto> proyectosListNew = new ArrayList<>(this.proyectolist);
        proyectolist.clear();
        proyectolist.addAll(proyectosListNew);
        notifyDataSetChanged();
        return context;
    }
}
