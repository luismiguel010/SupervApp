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
import co.com.luis.supervapp.builders.TipoElementoBuilder;
import co.com.luis.supervapp.domain.models.TipoDeElemento;

public class AdapterTipoElementos extends RecyclerView.Adapter<AdapterTipoElementos.ViewHolderTipoElementos> {

    ArrayList<TipoDeElemento> tipoDeElementos;
    private Context context;

    public AdapterTipoElementos(ArrayList<TipoDeElemento> tipoDeElementos, Context context) {
        this.tipoDeElementos = tipoDeElementos;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterTipoElementos.ViewHolderTipoElementos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_tipo_elemento, null, false);
        return new AdapterTipoElementos.ViewHolderTipoElementos(view);
    }


    public void onBindViewHolder(@NonNull AdapterTipoElementos.ViewHolderTipoElementos holder, final int position) {
        holder.tipoElemento.setText(context.getResources()
        .getStringArray(R.array.string_array_elementos)[new TipoElementoBuilder().convertirEnumAInteger(tipoDeElementos.get(position).getElementosEnum())]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ElementosActivity.class);
                intent.putExtra("id_tipoelemento", new TipoElementoBuilder().convertirEnumAInteger(tipoDeElementos.get(position).getElementosEnum()));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return tipoDeElementos.size();
    }

    public class ViewHolderTipoElementos extends RecyclerView.ViewHolder {

        TextView tipoElemento;

        public ViewHolderTipoElementos(@NonNull View itemView) {
            super(itemView);
            tipoElemento = (TextView) itemView.findViewById(R.id.tipoelemento);
            context = itemView.getContext();
        }
    }
}
