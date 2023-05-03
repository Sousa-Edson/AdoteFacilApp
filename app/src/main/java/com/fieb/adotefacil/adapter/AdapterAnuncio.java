package com.fieb.adotefacil.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fieb.adotefacil.R;
import com.fieb.adotefacil.model.Anuncio;
import com.fieb.adotefacil.view.principal.Principal;

import java.util.List;

public class AdapterAnuncio extends RecyclerView.Adapter<AdapterAnuncio.AnuncioViewHolder> {
    private List<Anuncio> anuncios;
    public AdapterAnuncio(Principal mainActivity, List<Anuncio> anuncios) {
        this.anuncios = anuncios;
    }
    @NonNull
    @Override
    public AdapterAnuncio.AnuncioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.anuncio_item,parent,false);
        return new AnuncioViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterAnuncio.AnuncioViewHolder holder, int position) {
        holder.foto.setImageResource(anuncios.get(position).getFotoAnuncio());
        holder.nome.setText(anuncios.get(position).getNomeAnuncio());
        holder.descricao.setText(anuncios.get(position).getDescricaoAnuncio());
        holder.preco.setText(anuncios.get(position).getDataAnuncio());
    }

    @Override
    public int getItemCount() {
        return anuncios.size();
    }
    public static class AnuncioViewHolder extends RecyclerView.ViewHolder {
        ImageView foto = itemView.findViewById(R.id.fotoEvento);
        TextView nome = itemView.findViewById(R.id.nomeEvento);
        TextView descricao = itemView.findViewById(R.id.descricaoEvento);
        TextView preco = itemView.findViewById(R.id.dataEvento);
        public AnuncioViewHolder(@NonNull View itemView) {
            super(itemView);
        }


    }
}
