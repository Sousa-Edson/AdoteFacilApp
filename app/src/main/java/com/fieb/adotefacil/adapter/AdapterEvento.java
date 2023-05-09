package com.fieb.adotefacil.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fieb.adotefacil.R;
import com.fieb.adotefacil.model.Evento;
import com.fieb.adotefacil.view.principal.Principal;

import java.util.List;

public class AdapterEvento extends RecyclerView.Adapter<AdapterEvento.EventoViewHolder> {
    private List<Evento> eventos;
    public AdapterEvento(Principal mainActivity, List<Evento> eventos) {
        this.eventos = eventos;
    }
    @NonNull
    @Override
    public AdapterEvento.EventoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.Evento_item,parent,false);
        return new EventoViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterEvento.EventoViewHolder holder, int position) {
        holder.foto.setImageResource(eventos.get(position).getFotoEvento());
        holder.nome.setText(eventos.get(position).getNomeEvento());
        holder.descricao.setText(eventos.get(position).getDescricaoEvento());
        holder.preco.setText(eventos.get(position).getDataEvento());
    }

    @Override
    public int getItemCount() {
        return eventos.size();
    }
    public static class EventoViewHolder extends RecyclerView.ViewHolder {
        ImageView foto = itemView.findViewById(R.id.fotoEvento);
        TextView nome = itemView.findViewById(R.id.nomeEvento);
        TextView descricao = itemView.findViewById(R.id.descricaoEvento);
        TextView preco = itemView.findViewById(R.id.dataEvento);
        public EventoViewHolder(@NonNull View itemView) {
            super(itemView);
        }


    }
}
