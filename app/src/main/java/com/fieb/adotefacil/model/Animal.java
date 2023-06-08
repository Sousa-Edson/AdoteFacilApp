package com.fieb.adotefacil.model;

import com.fieb.adotefacil.enums.Especie;
import com.fieb.adotefacil.enums.Porte;

import java.sql.Date;
import java.util.List;

public class Animal {
    private  int id;
    private  int sexo;
    private  int raca;
    private  int cor;
    private String nome;
    private String resumo;
    private String observacao;
    private String fotoAnimal;
    private Date nascimento;
    private Porte porte;
    private Especie especie;
    private int vacina;
    private boolean disponivel;


    private List <PetImagem> caminhoFotoAnimal;

    public Animal() {
    }

    public Animal(int id, int sexo, String nome, String resumo, String observacao) {
        this.id = id;
        this.sexo = sexo;
        this.nome = nome;
        this.resumo = resumo;
        this.observacao = observacao;
    }

    public Animal(int id, int sexo, String nome, String resumo, String observacao, List<PetImagem> caminhoFotoAnimal) {
        this.id = id;
        this.sexo = sexo;
        this.nome = nome;
        this.resumo = resumo;
        this.observacao = observacao;
        this.caminhoFotoAnimal = caminhoFotoAnimal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public List<PetImagem> getCaminhoFotoAnimal() {
        return caminhoFotoAnimal;
    }

    public void setCaminhoFotoAnimal(List<PetImagem> caminhoFotoAnimal) {
        this.caminhoFotoAnimal = caminhoFotoAnimal;
    }

    public int getRaca() {
        return raca;
    }

    public void setRaca(int raca) {
        this.raca = raca;
    }

    public int getCor() {
        return cor;
    }

    public void setCor(int cor) {
        this.cor = cor;
    }

    public String getFotoAnimal() {
        return fotoAnimal;
    }

    public void setFotoAnimal(String fotoAnimal) {
        this.fotoAnimal = fotoAnimal;
    }

    public Porte getPorte() {
        return porte;
    }

    public void setPorte(Porte porte) {
        this.porte = porte;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public int getVacina() {
        return vacina;
    }

    public void setVacina(int vacina) {
        this.vacina = vacina;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    @Override
    public String toString() {
        return   nome  ;
    }
}
