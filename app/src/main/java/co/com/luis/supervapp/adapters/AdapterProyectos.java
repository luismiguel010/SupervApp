package co.com.luis.supervapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import co.com.luis.supervapp.R;
import co.com.luis.supervapp.domain.models.Proyecto;

public class AdapterProyectos extends RecyclerView.Adapter<AdapterProyectos.ViewHolderProyecto> {

    ArrayList<Proyecto> proyectolist;

    public AdapterProyectos(ArrayList<Proyecto> proyectolist){
        this.proyectolist = proyectolist;
    }

    @NonNull
    @Override
    public ViewHolderProyecto onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_proyecto,null, false);
        return new ViewHolderProyecto(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderProyecto holder, int position) {
        holder.asignarProyectos(proyectolist.get(position));

    }

    @Override
    public int getItemCount() {
        return proyectolist.size();
    }

    public class ViewHolderProyecto extends RecyclerView.ViewHolder {

        TextView nombre;
        TextView constructora;

        public ViewHolderProyecto(@NonNull View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.nombre);
            constructora = (TextView) itemView.findViewById(R.id.contructora);
        }

        public void asignarProyectos(Proyecto proyecto) {
            nombre.setText(proyecto.getNombre());
            constructora.setText(proyecto.getConstructura());
        }
    }
}
