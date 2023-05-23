package com.fieb.adotefacil.view.principal.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fieb.adotefacil.MainActivity;
import com.fieb.adotefacil.R;
import com.fieb.adotefacil.adapter.AdapterEvento;
import com.fieb.adotefacil.controller.EventoController;
import com.fieb.adotefacil.databinding.FragmentHomeBinding;
import com.fieb.adotefacil.model.Evento;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textHome;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        preencheTela();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
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

