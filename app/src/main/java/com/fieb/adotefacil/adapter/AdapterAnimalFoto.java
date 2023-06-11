package com.fieb.adotefacil.adapter;

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
import com.fieb.adotefacil.DetailsGalleryFragment;
import com.fieb.adotefacil.R;
import com.fieb.adotefacil.model.Evento;
import com.fieb.adotefacil.model.PetImagem;
import com.fieb.adotefacil.view.GalleryFragment;
import com.fieb.adotefacil.view.login_cadastro.Cadastro;

import java.util.ArrayList;
import java.util.List;

public class AdapterAnimalFoto extends RecyclerView.Adapter<AdapterAnimalFoto.FotoViewHolder> {
    private List<PetImagem> petImagems;
    private ArrayList<Uri> fotos;
    public AdapterAnimalFoto(DetailsGalleryFragment detailsGalleryFragment, List<PetImagem> petImagems) {
        System.out.println("AQUI EM ADAPTER : "+petImagems.get(0).getCaminhoImagem());
        this.petImagems = petImagems;
    }


    @NonNull
    @Override
    public AdapterAnimalFoto.FotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        System.out.println("AQUI EM ADAPTER 2: "+petImagems.get(0).getCaminhoImagem());
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_foto_item,parent,false);
        return new FotoViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterAnimalFoto.FotoViewHolder holder, int position) {
        System.out.println("AQUI EM ADAPTER 3 : "+petImagems.get(position).getCaminhoImagem());
        System.out.println("VENDO O TAMANHO DE UMA FORMA: "+petImagems.size());

        PetImagem fotos = petImagems.get(position);
        String imageUrl= fotos.getCaminhoImagem();
//        imageUrl="https://res.cloudinary.com/daieys39b/image/upload/v1686251907/postagem/sem-imagem_owc6zt.jpg";
        Glide.with(holder.itemView.getContext()).load(imageUrl).into(holder.foto);
        holder.texto.setText("-_-");
    }

    @Override
    public int getItemCount() {
        System.out.println("TAMANHO: "+petImagems.size());
        return petImagems.size();
    }

    public static class FotoViewHolder extends RecyclerView.ViewHolder {
        ImageView foto = itemView.findViewById(R.id.fotoAnimalBloco);
        TextView texto = itemView.findViewById(R.id.textoAnimalBloco);

        public FotoViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
