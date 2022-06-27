package com.pecas.n2_auto_pecas_urielguimaraes.model;

import java.util.ArrayList;
import java.util.List;

public class OperadorEstoque {
    private int id;
    private String nome;
    private List<Endereco> enderecos = new ArrayList();
    private List<Numero> numeros = new ArrayList();

    public OperadorEstoque (){
        this.id = this.hashCode();
    }

    public OperadorEstoque (int id ){
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "OperadorEstoque{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
