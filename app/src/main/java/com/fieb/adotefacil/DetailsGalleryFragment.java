package com.fieb.adotefacil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fieb.adotefacil.adapter.AdapterAnimalFoto;
import com.fieb.adotefacil.adapter.AdapterEvento;
import com.fieb.adotefacil.controller.AnimalController;
import com.fieb.adotefacil.controller.EventoController;
import com.fieb.adotefacil.databinding.FragmentDetailsAnimalBinding;
import com.fieb.adotefacil.databinding.FragmentDetailsEventBinding;
import com.fieb.adotefacil.model.Animal;
import com.fieb.adotefacil.model.Evento;
import com.fieb.adotefacil.model.PetImagem;
import com.fieb.adotefacil.view.HomeFragment;

import java.util.ArrayList;
import java.util.List;


public class DetailsGalleryFragment extends Fragment {
    private FragmentDetailsAnimalBinding binding;
    String teste="Edson";
    TextView txtAnimal, txtSexo, txtDescricao, txtObservacao,txtIdade;
    ImageView txtCaminhoFoto;
    RecyclerView recyclerView_Foto  ;
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
//        recebe();
        preencheTela();
        return root;
    }

    public void recebe(){
        txtAnimal=binding.nomeAnimal;
        txtDescricao=binding.descricaoAnimal;
        txtObservacao=binding.observacaoAnimal;
        txtCaminhoFoto=binding.fotoAnimalPrincipal;
        txtSexo=binding.sexoAnimal;
        txtIdade=binding.idadeAnimal;
        Bundle args = getArguments();
        if (args != null) {
            txtAnimal.setText(args.getString("txtAnimal"));
            txtDescricao.setText(args.getString("txtResumo"));
            txtObservacao.setText(args.getString("txtObservacao"));
            txtSexo.setText(args.getString("txtSexo"));
            txtIdade.setText(args.getString("txtIdade"));
            String imageUrl=args.getString("txtFoto");
            Glide.with(this.getContext()).load(imageUrl).into(this.txtCaminhoFoto);
        }
    }
    public void preencheTela() {
// configurar o recyclerView
//        RecyclerView recyclerView_Foto = binding.recyclerViewFoto;
          recyclerView_Foto = binding.recyclerViewFoto;
        recyclerView_Foto.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView_Foto.setHasFixedSize(true);
//configurar o adapter
        List<PetImagem> listaImagem = new ArrayList<>();
        AnimalController animalController = new AnimalController();
        listaImagem = animalController.listaImagem(DetailsGalleryFragment.this.getContext(),"1");

        AdapterAnimalFoto adapterAnimalFoto = new AdapterAnimalFoto(DetailsGalleryFragment.this, listaImagem);
        recyclerView_Foto.setAdapter(adapterAnimalFoto);


        System.out.println("EXIBINDO EM DETAILSGALLERYFRAGMENT _-_ "+listaImagem.get(0).getCaminhoImagem());
    }
}