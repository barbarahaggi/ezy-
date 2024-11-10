package br.com.fiap.fintech.model;

import java.sql.Date;

public class Transferencias {
    private int IdTransf;
    private double valor;
    private java.sql.Date data;  // Alterado para java.sql.Date
    private String tipo;

    public Transferencias(int IdTransf, double valor, Date data, String tipo) {
        this.IdTransf = IdTransf;
        this.valor = valor;
        this.data = data;
        this.tipo = tipo;
    }

    // Getters e setters
    public int getIdTransf() {
        return IdTransf;
    }

    public void setIdTransf(int IdTransf) {
        this.IdTransf = IdTransf;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public java.sql.Date getData() {
        return data;
    }

    public void setData(java.sql.Date data) {
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Transferencia{" +
                "IdTransf=" + IdTransf +
                ", valor=" + valor +
                ", data=" + data +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
