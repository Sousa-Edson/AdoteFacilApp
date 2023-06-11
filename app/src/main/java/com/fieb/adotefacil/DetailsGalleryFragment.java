package com.fieb.adotefacil;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
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
import com.fieb.adotefacil.util.ConverteData;
import com.fieb.adotefacil.view.HomeFragment;

import java.util.ArrayList;
import java.util.List;


public class DetailsGalleryFragment extends Fragment {
    private FragmentDetailsAnimalBinding binding;
    TextView txtAnimal, txtSexo, txtDescricao, txtObservacao,txtIdade;
    ImageView txtCaminhoFoto;
    RecyclerView recyclerView_Foto  ;
    Animal animal = new Animal();

    public DetailsGalleryFragment(Animal animal) {
        this.animal = animal;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentDetailsAnimalBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        txtAnimal=binding.nomeAnimal;
        txtDescricao=binding.descricaoAnimal;
        txtObservacao=binding.observacaoAnimal;
        txtCaminhoFoto=binding.fotoAnimalPrincipal;
        txtSexo=binding.sexoAnimal;
        txtIdade=binding.idadeAnimal;
        recyclerView_Foto = binding.recyclerViewFoto;
        carregaTela();
//        recebe();
//        preencheTela();
        return root;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void carregaTela (){
int idAnimal=0;
        if (animal != null) {
            txtAnimal.setText(animal.getNome().toString());
            txtDescricao.setText(animal.getResumo().toString());
            txtObservacao.setText(animal.getObservacao().toString());
            txtSexo.setText(animal.getSexo()==2 ?"Macho":animal.getSexo() ==1 ?"Femea":"Sexo Indefinido");
            ConverteData converteData = new ConverteData();
            txtIdade.setText( converteData.calculaIdade(animal.getNascimento()));
            idAnimal= animal.getId();
            String imageUrl=null;
            try {
                imageUrl= animal.getCaminhoFotoAnimal().get(0).getCaminhoImagem().toString();
            }catch (Exception e){
                System.out.println("ERRO AO CARREGAR IMAGEM: "+e.getMessage());
                imageUrl="https://res.cloudinary.com/daieys39b/image/upload/v1686251907/postagem/sem-imagem_owc6zt.jpg";
            }

            Glide.with(this.getContext()).load(imageUrl).into(this.txtCaminhoFoto);

            // configurar o recyclerView
            recyclerView_Foto.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            recyclerView_Foto.setHasFixedSize(true);
            //configurar o adapter
            List<PetImagem> listaImagem = new ArrayList<>();
            AnimalController animalController = new AnimalController();
            listaImagem = animalController.listaImagem(DetailsGalleryFragment.this.getContext(),String.valueOf(idAnimal));

            AdapterAnimalFoto adapterAnimalFoto = new AdapterAnimalFoto(DetailsGalleryFragment.this, listaImagem);
            recyclerView_Foto.setAdapter(adapterAnimalFoto);


            System.out.println("EXIBINDO EM DETAILSGALLERYFRAGMENT _-_ "+listaImagem.get(0).getCaminhoImagem());
        }
    }


}