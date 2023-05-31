package com.fieb.adotefacil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.fieb.adotefacil.databinding.FragmentDetailsAnimalBinding;
import com.fieb.adotefacil.databinding.FragmentDetailsEventBinding;
import com.fieb.adotefacil.model.Animal;


public class DetailsGalleryFragment extends Fragment {
    private FragmentDetailsAnimalBinding binding;
    String teste="Edson";
    TextView txtAnimal;
    TextView txtSexo;
    TextView txtDescricao;
    ImageView txtCaminhoFoto;
    public DetailsGalleryFragment(Animal animal) {
        Bundle args = getArguments();
        if (args != null) {
            String valor = args.getString(animal.getNome());
            System.out.println("AQUI :::: DetailsGalleryFragment ::: "+valor.toString());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentDetailsAnimalBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recebe();

        return root;
    }

    public void recebe(){
        txtAnimal=binding.nomeAnimal;
        txtDescricao=binding.descricaoAnimal;
        txtCaminhoFoto=binding.fotoAnimalPrincipal;
        txtSexo=binding.sexoAnimal;
        Bundle args = getArguments();
        if (args != null) {
//            String valor = args.getString("txtDescricao"); // Substitua "chave" pelo nome da chave usada anteriormente
            // Use o valor recebido conforme necessário
//            System.out.println("AQUI "+valor.toString());
            txtAnimal.setText(args.getString("txtAnimal"));
            txtDescricao.setText(args.getString("txtResumo"));
            txtSexo.setText(args.getString("txtSexo"));
            String imageUrl=args.getString("txtFoto");
            Glide.with(this.getContext()).load(imageUrl).into(this.txtCaminhoFoto);
//            txtCaminhoFoto.setImageURI(Uri.parse(args.getString("txtFoto")));
        }


//        texto.setText("AQUI"+teste);
    }
}