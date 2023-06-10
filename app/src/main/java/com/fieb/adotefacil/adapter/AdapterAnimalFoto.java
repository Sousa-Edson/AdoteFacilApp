package com.fieb.adotefacil.adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fieb.adotefacil.DetailsGalleryFragment;
import com.fieb.adotefacil.R;
import com.fieb.adotefacil.model.PetImagem;

import java.util.ArrayList;
import java.util.List;

public class AdapterAnimalFoto extends RecyclerView.Adapter<AdapterAnimalFoto.FotoViewHolder> {
    private List<PetImagem> petImagems;
    private ArrayList<Uri> fotos;
//    public View.OnClickListener listener;
    public AdapterAnimalFoto(DetailsGalleryFragment detailsGalleryFragment, List<PetImagem> petImagems) {
        System.out.println("AQUI EM ADAPTER : "+petImagems.get(0).getCaminhoImagem());

       this.petImagems = petImagems;
   }
    @NonNull
    @Override
    public AdapterAnimalFoto.FotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_foto_item,parent,false);
        System.out.println("AQUIIIIIIIIIIIIIIIIIIIIIIIII");
        return new FotoViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterAnimalFoto.FotoViewHolder holder, int position) {
        System.out.println("ADAPTER HOLDER : ::");
//        PetImagem fotos = animais.get(position);
        String imageUrl= petImagems.get(position).getCaminhoImagem().toString();
        System.out.println("ADAPTER HOLDER : "+imageUrl);
        Glide.with(holder.itemView.getContext()).load(imageUrl).into(holder.foto);

            // Define o listener de clique para o item
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(v.getContext(), "Clicou em: ALGUMA COISA " , Toast.LENGTH_SHORT).show();
                }
            });
        }


    @Override
    public int getItemCount() {
        return petImagems.size();
    }
    public static class FotoViewHolder extends RecyclerView.ViewHolder {
        ImageView foto = itemView.findViewById(R.id.fotoAnimalBloco);

        public FotoViewHolder(@NonNull View itemView) {
            super(itemView);
        }


    }
}
