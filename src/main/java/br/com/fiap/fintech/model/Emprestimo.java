package br.com.fiap.fintech.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class Emprestimo {
    private int id_emprestimo;
    private int id_user;
    private double valor;
    private LocalDate data_inicio;
    private LocalDate data_vencimento;
    private double taxa_juros;

    public Emprestimo(int id_emprestimo, int id_user, double valor, LocalDate data_inicio, LocalDate data_vencimento, double taxa_juros) {
        this.id_emprestimo = id_emprestimo;
        this.id_user = id_user;
        this.valor = valor;
        this.data_inicio = data_inicio;
        this.data_vencimento = data_vencimento;
        this.taxa_juros = taxa_juros;
    }

    public int getId_emprestimo() {
        return id_emprestimo;
    }

    public void setId_emprestimo(int id_emprestimo) {
        this.id_emprestimo = id_emprestimo;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
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
}

