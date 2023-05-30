package com.fieb.adotefacil.model;

import java.util.List;

public class Animal {
  private  int id;
  private  int sexo;
  private String nome;
  private String resumo;
  private String observacao;

  private List caminhoFotoAnimal;

    public Animal() {
    }

    public Animal(int id, int sexo, String nome, String resumo, String observacao) {
        this.id = id;
        this.sexo = sexo;
        this.nome = nome;
        this.resumo = resumo;
        this.observacao = observacao;
    }

    public Animal(int id, int sexo, String nome, String resumo, String observacao, List foto) {
        this.id = id;
        this.sexo = sexo;
        this.nome = nome;
        this.resumo = resumo;
        this.observacao = observacao;
        this.caminhoFotoAnimal = foto;
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

    public List getCaminhoFotoAnimal() {
        return caminhoFotoAnimal;
    }

    public void setCaminhoFotoAnimal(List caminhoFotoAnimal) {
        this.caminhoFotoAnimal = caminhoFotoAnimal;
    }
}
