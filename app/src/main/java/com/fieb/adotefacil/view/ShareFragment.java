package com.fieb.adotefacil.view;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.fieb.adotefacil.R;
import com.fieb.adotefacil.controller.AnimalController;
import com.fieb.adotefacil.controller.CorController;
import com.fieb.adotefacil.controller.RacaController;
import com.fieb.adotefacil.databinding.FragmentShareBinding;
import com.fieb.adotefacil.enums.Especie;
import com.fieb.adotefacil.enums.Porte;
import com.fieb.adotefacil.model.Animal;
import com.fieb.adotefacil.model.Cor;
import com.fieb.adotefacil.model.Raca;
import com.fieb.adotefacil.util.ConverteData;
import com.fieb.adotefacil.view.login_cadastro.Cadastro;
import com.google.android.material.snackbar.Snackbar;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShareFragment extends Fragment {
    private FragmentShareBinding binding;
    private Spinner spinnerRaca;
    private Spinner spinnerEspecie;
    private Spinner spinnerPorte;
    private Spinner spinnerCor;
    private EditText txtNome;
    private EditText txtDataNascimento;
    private ArrayAdapter<Raca> spinnerAdapterRaca;
    private ArrayAdapter<Especie> spinnerAdapterEspecie;
    private ArrayAdapter<Porte> spinnerAdapterPorte;
    private ArrayAdapter<Cor> spinnerAdapterCor;

    List<Raca> listaRaca = new ArrayList<>();
    List<Cor> listaCor = new ArrayList<>();
    // Crie um novo ArrayList para armazenar apenas as raças
    List<String> listaEspecieApenas = new ArrayList<>();
    Animal animal = new Animal();
    Raca raca = new Raca();
    Cor cor = new Cor();
    private int sexo=0,vacinado=0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_share, container, false);
        binding = FragmentShareBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        preencheComboboxRaca();
        preencheComboboxCor();
        preencheComboboxEspecie();
        preencheComboboxPorte();

        binding.btnSalvar.setOnClickListener(view -> {
//            System.out.println("AQUI: "+binding.editNomeAnimal.getText());
//            nome = binding.editNomeAnimal;
            if(binding.editNomeAnimal.getText().length() < 1){
                Snackbar snackBar = Snackbar.make(view, "Campo é obrigatório!", Snackbar.LENGTH_SHORT);
                snackBar.setBackgroundTint(Color.RED);
                snackBar.show();
            }else {


                Animal animal = new Animal();
                animal.setNome(binding.editNomeAnimal.getText().toString());
                animal.setPorte((Porte) binding.spinnerPorteAnimal.getSelectedItem());
                animal.setEspecie((Especie) binding.spinnerEspecieAnimal.getSelectedItem());

                int selectedRadioButtonSexo = binding.radioGroupSexo.getCheckedRadioButtonId();
                if (selectedRadioButtonSexo == binding.radioButtonFemea.getId()) {
                    sexo = 1;
                } else if (selectedRadioButtonSexo == binding.radioButtonMacho.getId()) {
                    sexo = 2;
                } else {
                    sexo = 0;
                }
                animal.setSexo(sexo);

                int selectedRadioButtonVacina = binding.radioGroupVacina.getCheckedRadioButtonId();
                if (selectedRadioButtonVacina == binding.radioButtonVacinadoSim.getId()) {
                    vacinado = 2;
                } else if (selectedRadioButtonVacina == binding.radioButtonVacinadoNao.getId()) {
                    vacinado = 1;
                } else {
                    vacinado = 0;
                }
                animal.setVacina(vacinado);

                ConverteData converteData = new ConverteData();
                Date dataBanco = converteData.dataBanco(binding.editDataNascimentoAnimal.getText().toString());
                animal.setNascimento((java.sql.Date) dataBanco);

                animal.setDisponivel(true);

                animal.setRaca(raca.getId());
                animal.setCor(cor.getId());

                animal.setResumo(binding.editTextResumoMultiLine.getText().toString());
                animal.setObservacao(binding.editTextObservacaoMultiLine.getText().toString());

                //  Toast.makeText(getContext(), " RACA:"+animal.getRaca(),Toast.LENGTH_LONG).show();

                AnimalController animalController = new AnimalController();
                int resposta = animalController.criarAnimal(animal, getContext());
                if (resposta > 0) {
                    Toast.makeText(getContext(), "Cadastro realizado com Sucesso!", Toast.LENGTH_LONG).show();
                    GalleryFragment galleryFragment = new GalleryFragment();
                    // Obtém o FragmentManager da Activity
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    //((AppCompatActivity)view.getContext()).getSupportFragmentManager();

                    // Inicia uma transação de Fragment e substitui o Fragment atual pelo novo Fragment
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, galleryFragment)
                            .addToBackStack(null)
                            .commit();

                } else {
                    Toast.makeText(getContext(), "Error no Cadastro!", Toast.LENGTH_LONG).show();
                }
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
        RacaController racaController = new RacaController();
        listaRaca=racaController.listarRaca(getContext());
        spinnerAdapterRaca = new ArrayAdapter<Raca>(getContext().getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,listaRaca);
        // Configure o adaptador para a ComboBox
        spinnerRaca.setAdapter(spinnerAdapterRaca);
        // Configurar um ouvinte para a seleção da ComboBox
        spinnerRaca.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                raca.setRaca(listaRaca.get(position).getRaca());
                raca.setId(listaRaca.get(position).getId());
                // Faça algo com o item selecionado
               // Toast.makeText(getContext(),"EXIBE: "+raca.getId(),Toast.LENGTH_LONG).show();
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
              //  Toast.makeText(getContext(),"EXIBE: "+cor.getId(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Nenhuma ação necessária neste caso
            }
        });
    }

    public void preencheComboboxEspecie(){

        spinnerEspecie = binding.spinnerEspecieAnimal;
        spinnerAdapterEspecie = new ArrayAdapter<Especie>(getContext().getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,Especie.values());
        spinnerEspecie.setAdapter(spinnerAdapterEspecie);
        spinnerEspecie.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                // Faça algo com o item selecionado
                //Toast.makeText(getContext(),"EXIBE: "+spinnerEspecie.getSelectedItem().toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Nenhuma ação necessária neste caso
            }
        });
    }
    public void preencheComboboxPorte(){

        spinnerPorte = binding.spinnerPorteAnimal;
        spinnerAdapterPorte = new ArrayAdapter<Porte>(getContext().getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, Porte.values());
        spinnerPorte.setAdapter(spinnerAdapterPorte);
        spinnerPorte.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                // Faça algo com o item selecionado
               // Toast.makeText(getContext(),"EXIBE: "+spinnerPorte.getSelectedItem().toString(),Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Nenhuma ação necessária neste caso
            }
        });
    }
}