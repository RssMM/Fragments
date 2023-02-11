package com.example.fragments;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AdaptadorCorreos extends RecyclerView.Adapter<AdaptadorCorreos.ViewHolder> {
    private final List<Correo> correos;
    CorreoListener listener;
    public AdaptadorCorreos(List<Correo> correos) {
        this.correos = correos;
    }
    public AdaptadorCorreos(List<Correo> correos, CorreoListener listener){
        this.correos = correos;
        this.listener = listener;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView de;
        TextView asunto;

        public ViewHolder(View view) {
            super(view);
            de = (TextView) view.findViewById(R.id.lblDe);
            asunto = (TextView) view.findViewById(R.id.lblAsunto);
        }

        public void bindCorreo(Correo correo){
            de.setText(correo.getDe());
            asunto.setText(correo.getAsunto());
        }

        public TextView getDeLbl() {
            return de;
        }
        public TextView getAsuntoLbl() {
            return asunto;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_correo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, @SuppressLint("RecyclerView") int position) {
        Correo correo = correos.get(position);
        viewHolder.bindCorreo(correo);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onCorreoSeleccionado(correo);
            }
        });
    }

    @Override
    public int getItemCount() {
        return correos.size();
    }

}