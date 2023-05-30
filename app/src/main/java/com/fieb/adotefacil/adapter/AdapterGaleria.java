package com.fieb.adotefacil.adapter;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fieb.adotefacil.DetailsGalleryFragment;
import com.fieb.adotefacil.R;
import com.fieb.adotefacil.model.Animal;
import com.fieb.adotefacil.view.GalleryFragment;

import java.util.ArrayList;
import java.util.List;

public class AdapterGaleria extends RecyclerView.Adapter<AdapterGaleria.EventoViewHolder> {
    private List<Animal> animais;
    private ArrayList<Uri> fotos;
    public AdapterGaleria(GalleryFragment mainActivity, List<Animal> animais) {
       this.animais = animais;
   }
    @NonNull
    @Override
    public AdapterGaleria.EventoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.galeria_item,parent,false);
        return new EventoViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterGaleria.EventoViewHolder holder, int position) {
        Animal fotos = animais.get(position);
//        String imageUrl= fotos.getCaminhoFotoAnimal().get(0).toString();
        String imageUrl= fotos.getFotoAnimal().toString();
        Glide.with(holder.itemView.getContext()).load(imageUrl).into(holder.foto);

        holder.nome.setText(animais.get(position).getNome());
        holder.descricao.setText(animais.get(position).getResumo());
        holder.sexo.setText(animais.get(position).getSexo() ==2 ?"Macho":animais.get(position).getSexo() ==1 ?"Femea":"Indefinido");

//        holder.foto.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(v.getContext(), "Clicou em: "+holder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
//            }
//        });

            // Define o listener de clique para o item
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Obtém o evento selecionado com base na posição
                    Animal animal = animais.get(holder.getAdapterPosition());

                    // Inicia uma nova atividade para exibir os detalhes do evento
//                    Context context = AdapterEvento.this;
//                    Intent intent = new Intent(v.getContext(), DetailsEventFragment.class);
//                    intent.putExtra("EVENTO_DESCRICAO",  evento.getDescricaoEvento());
//                    v.getContext().startActivity(intent);
//                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
//                    ClipData.Item item = eventos.get(holder.getAdapterPosition());

//                    Item item = itemList.get(position);

                    // Cria uma instância do novo Fragment
                    DetailsGalleryFragment detailsEventFragment =  new DetailsGalleryFragment(animal);
//                    novoFragment.recebe(evento.getDescricaoEvento());

                    Bundle args = new Bundle();
                    args.putString("txtAnimal", animal.getNome());
                    args.putString("txtResumo", animal.getResumo());
//                    args.putString("txtFoto", animal.getCaminhoFotoAnimal());
                    detailsEventFragment.setArguments(args);


                    // Obtém o FragmentManager da Activity
                    FragmentManager fragmentManager = ((AppCompatActivity) v.getContext()).getSupportFragmentManager();

                    // Inicia uma transação de Fragment e substitui o Fragment atual pelo novo Fragment
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, detailsEventFragment)
                            .addToBackStack(null)
                            .commit();
                    Toast.makeText(v.getContext(), "Clicou em: " +animal.getId(), Toast.LENGTH_SHORT).show();
                }
            });
        }


    @Override
    public int getItemCount() {
        return animais.size();
    }
    public static class EventoViewHolder extends RecyclerView.ViewHolder {
        ImageView foto = itemView.findViewById(R.id.fotoAnimal);
        TextView nome = itemView.findViewById(R.id.nomeAnimal);
        TextView descricao = itemView.findViewById(R.id.descricaoAnimal);
        TextView sexo = itemView.findViewById(R.id.sexoAnimal);
        public EventoViewHolder(@NonNull View itemView) {
            super(itemView);
        }


    }
}
