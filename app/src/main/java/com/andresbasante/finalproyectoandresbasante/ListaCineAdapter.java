package com.andresbasante.finalproyectoandresbasante;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andresbasante.finalproyectoandresbasante.models.Cine;

import java.util.ArrayList;

public class ListaCineAdapter extends RecyclerView.Adapter<ListaCineAdapter.ViewHolder> {
        private ArrayList<Cine> dataset;

    private Context context;

    public ListaCineAdapter(Context context) {
        this.context = context;
        dataset = new ArrayList<>();

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_lista_cine_adapter, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Cine c = dataset.get(position);
        holder.ciu.setText(c.getCiudad());
        holder.dep.setText(c.getDepartamento());
        holder.dir.setText(c.getDireccionDeLaSala());
        holder.exh.setText(c.getExhibidor());
        holder.nom.setText(c.getNombreDelComplejo());
        holder.tot.setText(c.getTotalSalas().toString());
    }
    @Override
    public int getItemCount() {

        return dataset.size();
    }
    public void adicionarListaCine(ArrayList<Cine> listaCine) {
        dataset.addAll(listaCine);
        notifyDataSetChanged();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView ciu;
        private TextView dep;
        private TextView dir;
        private TextView exh;
        private TextView nom;
        private TextView tot;

        public ViewHolder(View itemView) {
            super(itemView);
            ciu = (TextView) itemView.findViewById(R.id.ciu);
            dep= (TextView) itemView.findViewById(R.id.dep);
            dir=(TextView) itemView.findViewById(R.id.dir);
            exh=(TextView) itemView.findViewById(R.id.exh);
            nom=(TextView) itemView.findViewById(R.id.nom);
            tot=(TextView) itemView.findViewById(R.id.tot);
        }
    }
}
