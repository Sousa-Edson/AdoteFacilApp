package com.fieb.adotefacil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.fieb.adotefacil.databinding.FragmentDetailsEventBinding;
import com.fieb.adotefacil.model.Animal;
import com.fieb.adotefacil.model.Evento;


public class DetailsGalleryFragment extends Fragment {
    private FragmentDetailsEventBinding binding;
    String teste="Edson";
    TextView txtEvento;
    TextView txtDescricao;
    ImageView txtCaminhoFoto;
    public DetailsGalleryFragment(Animal animal) {
//        DetailsEventFragment fragment = new DetailsEventFragment();
//        Bundle args = new Bundle();
//        args.putParcelable("ITEM_EXTRA", evento.getDescricaoEvento());

        Bundle args = getArguments();
        if (args != null) {
            String valor = args.getString(animal.getNome());
            System.out.println("AQUI "+valor.toString());
            teste=valor;
        }


//        fragment.setArguments(args);
        // return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the layout for this fragment
//        texto = binding.getRoot();

//        return inflater.inflate(R.layout.fragment_details_event, container, false);
        binding = FragmentDetailsEventBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recebe();

        return root;
    }

    public void recebe(){
        txtEvento=binding.nomeEvento;
        txtDescricao=binding.descricaoEvento;
        txtCaminhoFoto=binding.fotoEvento;
        Bundle args = getArguments();
        if (args != null) {
            String valor = args.getString("txtDescricao"); // Substitua "chave" pelo nome da chave usada anteriormente
            // Use o valor recebido conforme necessário
            System.out.println("AQUI "+valor.toString());
            txtEvento.setText(args.getString("txtEvento"));
            txtDescricao.setText(args.getString("txtDescricao"));
            String imageUrl=args.getString("txtFoto");
            Glide.with(this.getContext()).load(imageUrl).into(this.txtCaminhoFoto);
//            txtCaminhoFoto.setImageURI(Uri.parse(args.getString("txtFoto")));
        }


//        texto.setText("AQUI"+teste);
    }
}