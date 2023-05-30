package com.fieb.adotefacil.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fieb.adotefacil.R;
import com.fieb.adotefacil.adapter.AdapterEvento;
import com.fieb.adotefacil.adapter.AdapterGaleria;
import com.fieb.adotefacil.controller.AnimalController;
import com.fieb.adotefacil.controller.EventoController;
import com.fieb.adotefacil.databinding.FragmentGalleryBinding;
import com.fieb.adotefacil.databinding.FragmentHomeBinding;
import com.fieb.adotefacil.model.Animal;
import com.fieb.adotefacil.model.Evento;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {
    private FragmentGalleryBinding  binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_gallery, container, false);
        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        preencheTela();
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false);
        return root;
    }

    public void preencheTela() {
// configurar o recyclerView
        RecyclerView recyclerView_Animais = binding.recyclerView;
        recyclerView_Animais.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView_Animais.setHasFixedSize(true);
//configurar o adapter
        List<Animal> listaAnimais = new ArrayList<>();
        AnimalController animalController = new AnimalController();
        listaAnimais = animalController.apresentarAnimal(getContext());
        AdapterGaleria adapterGaleria = new AdapterGaleria(GalleryFragment.this, listaAnimais);
        recyclerView_Animais.setAdapter(adapterGaleria);


        System.out.println("EXIBINDO "+listaAnimais.size());
    }
}