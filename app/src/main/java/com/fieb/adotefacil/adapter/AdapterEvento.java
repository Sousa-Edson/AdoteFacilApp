package com.fieb.adotefacil.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fieb.adotefacil.MainActivity;
import com.fieb.adotefacil.R;
import com.fieb.adotefacil.model.Evento;
import com.fieb.adotefacil.view.principal.Principal;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AdapterEvento extends RecyclerView.Adapter<AdapterEvento.EventoViewHolder> {
    private List<Evento> eventos;
    private ArrayList<Uri> fotos;
    public View.OnClickListener listener;
    public AdapterEvento(Principal mainActivity, List<Evento> eventos) {
        this.eventos = eventos;
        this.listener = listener;
    }
    @NonNull
    @Override
    public AdapterEvento.EventoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.evento_item,parent,false);
        return new EventoViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterEvento.EventoViewHolder holder, int position) {
        Evento fotos = eventos.get(position);
        String imageUrl= fotos.getCamingoFotoEvento();
        Glide.with(holder.itemView.getContext()).load(imageUrl).into(holder.foto);

        holder.nome.setText(eventos.get(position).getNomeEvento());
        holder.descricao.setText(eventos.get(position).getDescricaoEvento());
        holder.preco.setText(eventos.get(position).getDataEvento());

        holder.foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Clicou em: "+holder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
            }
        });
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
