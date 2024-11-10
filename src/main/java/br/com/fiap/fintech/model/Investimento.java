package br.com.fiap.fintech.model;

import java.time.LocalDate;
import java.sql.Date;

public class Investimento {
    private int idInvest;
    private double valor;
    private LocalDate dataInicio;
    private String nomeInvestimento;
    private LocalDate dataFim;

    public Investimento(int codigoRetornado, double cdi, double valor) {}

    public Investimento(int idInvest, double valor, LocalDate dataInicio, String nomeInvestimento, LocalDate dataFim) {
        this.idInvest = idInvest;
        this.valor = valor;
        this.dataInicio = dataInicio;
        this.nomeInvestimento = nomeInvestimento;
        this.dataFim = dataFim;
    }

    public int getIdInvest() {
        return idInvest;
    }

    public void setIdInvest(int idInvest) {
        this.idInvest = idInvest;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getDataInicio() {
        return Date.valueOf(dataInicio);
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getNomeInvestimento() {
        return nomeInvestimento;
    }

    public void setNomeInvestimento(String nomeInvestimento) {
        this.nomeInvestimento = nomeInvestimento;
    }

    public Date getDataFim() {
        return Date.valueOf(dataFim);
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }
}
