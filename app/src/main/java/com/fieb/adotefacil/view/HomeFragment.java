package com.fieb.adotefacil.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fieb.adotefacil.adapter.AdapterEvento;
import com.fieb.adotefacil.controller.EventoController;
import com.fieb.adotefacil.databinding.FragmentHomeBinding;
import com.fieb.adotefacil.model.Evento;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        preencheTela();
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false);
        return root;
    }

    public void preencheTela() {
// configurar o recyclerView
        RecyclerView recyclerView_Eventos = binding.recyclerView;
        recyclerView_Eventos.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView_Eventos.setHasFixedSize(true);
//configurar o adapter
        List<Evento> listaEventos = new ArrayList<>();
        EventoController eventoController = new EventoController();
        listaEventos = eventoController.apresentarEvento(getContext());
        AdapterEvento adapterEvento = new AdapterEvento(HomeFragment.this, listaEventos);
        recyclerView_Eventos.setAdapter(adapterEvento);


        System.out.println("EXIBINDO ");
    }
}