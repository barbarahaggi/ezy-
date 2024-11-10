package br.com.fiap.fintech.model;

import java.time.LocalDate;

public class Emprestimo {
    private int id_empre;
    private double valor;
    private LocalDate data_inicio;
    private LocalDate data_vencimento;
    private double taxa_juros;
    private int cliente_id_cliente;

    public Emprestimo(int id_empre, double valor, LocalDate data_inicio, LocalDate data_vencimento, double taxa_juros, int cliente_id_cliente) {
        this.id_empre = id_empre;
        this.valor = valor;
        this.data_inicio = data_inicio;
        this.data_vencimento = data_vencimento;
        this.taxa_juros = taxa_juros;
        this.cliente_id_cliente = cliente_id_cliente;
    }

    public int getId_empre() {
        return id_empre;
    }

    public void setId_empre(int id_empre) {
        this.id_empre = id_empre;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(LocalDate data_inicio) {
        this.data_inicio = data_inicio;
    }

    public LocalDate getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(LocalDate data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public double getTaxa_juros() {
        return taxa_juros;
    }

    public void setTaxa_juros(double taxa_juros) {
        this.taxa_juros = taxa_juros;
    }

    public int getCliente_id_cliente() {
        return cliente_id_cliente;
    }

    public void setCliente_id_cliente(int cliente_id_cliente) {
        this.cliente_id_cliente = cliente_id_cliente;
    }
}