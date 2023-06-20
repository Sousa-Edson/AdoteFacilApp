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
import com.fieb.adotefacil.DetailsEventFragment;
import com.fieb.adotefacil.R;
import com.fieb.adotefacil.model.Evento;
import com.fieb.adotefacil.view.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class AdapterEvento extends RecyclerView.Adapter<AdapterEvento.EventoViewHolder> {
    private List<Evento> eventos;
    private ArrayList<Uri> fotos;
//    public View.OnClickListener listener;
    public AdapterEvento(HomeFragment mainActivity, List<Evento> eventos) {
       this.eventos = eventos;
//        this.listener = listener;
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

//        String imagemUrl = "https://res.cloudinary.com/duatdkkb3/image/upload/v1686005245/postagem/a71c4a6e-42aa-42eb-8ef2-ba46c07b5891.jpg"; // Substitua pela sua URL
//        Glide.with(holder.itemView.getContext())
//                .load(imagemUrl)
//                .into(holder.foto);

        holder.nome.setText(eventos.get(position).getNomeEvento());
        holder.descricao.setText(eventos.get(position).getDescricaoEvento());
        holder.data.setText(eventos.get(position).getDataEvento());

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
                    Evento evento = eventos.get(holder.getAdapterPosition());

                    // Inicia uma nova atividade para exibir os detalhes do evento
//                    Context context = AdapterEvento.this;
//                    Intent intent = new Intent(v.getContext(), DetailsEventFragment.class);
//                    intent.putExtra("EVENTO_DESCRICAO",  evento.getDescricaoEvento());
//                    v.getContext().startActivity(intent);
//                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
//                    ClipData.Item item = eventos.get(holder.getAdapterPosition());

//                    Item item = itemList.get(position);

                    // Cria uma instância do novo Fragment
                    DetailsEventFragment detailsEventFragment =  new DetailsEventFragment(evento);
//                    novoFragment.recebe(evento.getDescricaoEvento());

                    Bundle args = new Bundle();
                    args.putString("txtEvento", evento.getNomeEvento());
                    args.putString("txtDescricao", evento.getDescricaoEvento()); // Substitua "chave" pelo nome da chave desejada e "valor" pelo valor real que você deseja passar
                    args.putString("txtFoto", evento.getCamingoFotoEvento());
//                    MeuFragmentoDestino fragmentoDestino = new MeuFragmentoDestino();
                    detailsEventFragment.setArguments(args);


                    // Obtém o FragmentManager da Activity
                    FragmentManager fragmentManager = ((AppCompatActivity) v.getContext()).getSupportFragmentManager();

                    // Inicia uma transação de Fragment e substitui o Fragment atual pelo novo Fragment
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, detailsEventFragment)
                            .addToBackStack(null)
                            .commit();
                    Toast.makeText(v.getContext(), "Clicou em: " +evento.getIdEvento(), Toast.LENGTH_SHORT).show();
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
        TextView data = itemView.findViewById(R.id.dataEvento);
        public EventoViewHolder(@NonNull View itemView) {
            super(itemView);
        }


    }
}
