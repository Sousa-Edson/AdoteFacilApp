package com.fieb.adotefacil.view;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.fieb.adotefacil.R;
import com.fieb.adotefacil.controller.RacaController;
import com.fieb.adotefacil.databinding.FragmentHomeBinding;
import com.fieb.adotefacil.databinding.FragmentShareBinding;
import com.fieb.adotefacil.model.Animal;
import com.fieb.adotefacil.model.Raca;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class ShareFragment extends Fragment {
    private FragmentShareBinding binding;
    private Spinner spinner;
    private ArrayAdapter<Raca> spinnerAdapter;
    private EditText nome;

    List<Raca> listaRaca = new ArrayList<>();
    Animal animal = new Animal();
    Raca raca = new Raca();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_share, container, false);
        binding = FragmentShareBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        preencheComboboxRaca();

        binding.btnSalvar.setOnClickListener(view -> {
            System.out.println("AQUI: "+binding.editNomeAnimal.getText());
            nome = binding.editNomeAnimal;
            if(nome.getText().length() < 1){
                nome.requestFocus();
//                Toast.makeText(getContext(),"Nome é obrigatório!",Toast.LENGTH_SHORT).show();
                Snackbar snackBar = Snackbar.make(view, "Nome é obrigatório!", Snackbar.LENGTH_SHORT);
                snackBar.setBackgroundTint(Color.RED);
                snackBar.show();
            }else{
            animal.setNome(nome.getText().toString());
            animal.setRaca(raca.getId());
            Toast.makeText(getContext(),"COR: "+binding.editCorAnimal.getText().toString()+" NOME:"+animal.getNome(),Toast.LENGTH_LONG).show();
            System.out.println("MOBO: "+animal.getNome());}
        });
        return root;

    }
    public void preencheComboboxRaca(){

        spinner = binding.spinnerRacaAnimal;
//        spinner = spinner.findViewById(R.id.spinnerRacaAnimal);


        RacaController racaController = new RacaController();
        listaRaca=racaController.listarRaca(getContext());
        spinnerAdapter = new ArrayAdapter<Raca>(getContext().getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,listaRaca);

        // Adicione itens à ComboBox
//        spinnerAdapter.add("Item 1");
//        spinnerAdapter.add("Item 2");
//        spinnerAdapter.add("Item 3");
//        spinnerAdapter.add(listaRaca.get(0).getRaca());

        // Configure o adaptador para a ComboBox
        spinner.setAdapter(spinnerAdapter);
//        spinner.setAdapter((SpinnerAdapter) listaRaca);

        // Configurar um ouvinte para a seleção da ComboBox
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();

                raca.setRaca(listaRaca.get(position).getRaca());
                raca.setId(listaRaca.get(position).getId());
                // Faça algo com o item selecionado
                Toast.makeText(getContext(),"EXIBE: "+raca.getId(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Nenhuma ação necessária neste caso
            }
        });
    }
}