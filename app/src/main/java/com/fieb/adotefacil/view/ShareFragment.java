package com.fieb.adotefacil.view;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.fieb.adotefacil.controller.CorController;
import com.fieb.adotefacil.controller.RacaController;
import com.fieb.adotefacil.databinding.FragmentShareBinding;
import com.fieb.adotefacil.model.Animal;
import com.fieb.adotefacil.model.Cor;
import com.fieb.adotefacil.model.Raca;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.List;

public class ShareFragment extends Fragment {
    private FragmentShareBinding binding;
    private Spinner spinnerRaca;
    private Spinner spinnerEspecie;
    private Spinner spinnerCor;
    private EditText txtNome;
    private EditText txtDataNascimento;
    private ArrayAdapter<Raca> spinnerAdapterRaca;
    private ArrayAdapter<String> spinnerAdapterEspecie;
    private ArrayAdapter<Cor> spinnerAdapterCor;

    List<Raca> listaRaca = new ArrayList<>();
    List<Cor> listaCor = new ArrayList<>();
    // Crie um novo ArrayList para armazenar apenas as raças
    List<String> listaEspecieApenas = new ArrayList<>();
    Animal animal = new Animal();
    Raca raca = new Raca();
    Cor cor = new Cor();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_share, container, false);
        binding = FragmentShareBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        preencheComboboxRaca();
        preencheComboboxCor();

        binding.btnSalvar.setOnClickListener(view -> {
//            System.out.println("AQUI: "+binding.editNomeAnimal.getText());
//            nome = binding.editNomeAnimal;
//            if(nome.getText().length() < 1){
//                nome.requestFocus();
//                Snackbar snackBar = Snackbar.make(view, "Nome é obrigatório!", Snackbar.LENGTH_SHORT);
//                snackBar.setBackgroundTint(Color.RED);
//                snackBar.show();
//            }else{
//            animal.setNome(nome.getText().toString());
//            animal.setRaca(raca.getId());
//            Toast.makeText(getContext(), " NOME:"+animal.getNome(),Toast.LENGTH_LONG).show();
//            System.out.println("MOBO: "+animal.getNome());}
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                eventoValidarCampos();
            }
        });
        return root;

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public boolean eventoValidarCampos(){
        txtDataNascimento = binding.editDataNascimentoAnimal;
        txtNome = binding.editNomeAnimal;

        String dateFormat = "dd/MM/uuuu";
        DateTimeFormatter dateTimeFormatter = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            dateTimeFormatter = DateTimeFormatter
                    .ofPattern(dateFormat)
                    .withResolverStyle(ResolverStyle.STRICT);
        }
        try {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                LocalDate date = LocalDate.parse(txtDataNascimento.getText().toString(), dateTimeFormatter);
            }
        } catch (DateTimeParseException e) {
            System.out.println("ERRO: "+e);
            txtDataNascimento.requestFocus();
            Toast.makeText(getContext(),"Data invalida!",Toast.LENGTH_SHORT).show();
        }
        if(txtNome.getText().toString().isEmpty()){
            txtNome.requestFocus();
            Toast.makeText(getContext(),"Campo vazio!",Toast.LENGTH_SHORT).show();

        }
        return false;
    }
    public void preencheComboboxRaca(){



        spinnerRaca = binding.spinnerRacaAnimal;
        spinnerEspecie = binding.spinnerEspecieAnimal;
        RacaController racaController = new RacaController();
        listaRaca=racaController.listarRaca(getContext());

        for (Raca racaAnimal : listaRaca) {
            listaEspecieApenas.add(racaAnimal.getEspecie());
            System.out.println("PERCORRER: "+racaAnimal.getEspecie());
        }
        System.out.println("LISTA: "+listaEspecieApenas);

        spinnerAdapterRaca = new ArrayAdapter<Raca>(getContext().getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,listaRaca);
        spinnerAdapterEspecie = new ArrayAdapter<String>(getContext().getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,listaEspecieApenas);
        ArrayAdapter<String> especieAdapter = new ArrayAdapter<>(getContext().getApplicationContext(), android.R.layout.simple_spinner_item,listaEspecieApenas);
        especieAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Configure o adaptador para a ComboBox
        spinnerRaca.setAdapter(spinnerAdapterRaca);
        spinnerEspecie.setAdapter(spinnerAdapterEspecie);
        // Configurar um ouvinte para a seleção da ComboBox
        spinnerRaca.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
    public void preencheComboboxCor(){
        spinnerRaca = binding.spinnerCorAnimal;
        CorController corController = new CorController();
        listaCor=corController.listarCor(getContext());
        spinnerAdapterCor = new ArrayAdapter<Cor>(getContext().getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,listaCor);
        // Configure o adaptador para a ComboBox
        spinnerRaca.setAdapter(spinnerAdapterCor);
        // Configurar um ouvinte para a seleção da ComboBox
        spinnerRaca.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                cor.setCor(listaCor.get(position).getCor());
                cor.setId(listaCor.get(position).getId());
                // Faça algo com o item selecionado
                Toast.makeText(getContext(),"EXIBE: "+cor.getId(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Nenhuma ação necessária neste caso
            }
        });
    }
}