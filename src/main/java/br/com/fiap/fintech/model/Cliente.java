package br.com.fiap.fintech.model;

import br.com.fiap.fintech.util.Criptografia;

import java.time.LocalDate;

public class Cliente {
    private int id_cliente;
    private String nome;
    private String cpf;
    private String rg;
    private LocalDate data_nascimento;
    private String telefone;

    public Cliente(int id_cliente, String nome, String cpf, String rg, String telefone, LocalDate data_nascimento) {
        this.id_cliente = id_cliente;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.data_nascimento = data_nascimento;
        this.telefone = telefone;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
