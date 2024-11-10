package br.com.fiap.fintech.model;

public class Investimento {
    private int id_invest;
    private double cdi;
    private double valor;
    private int cliente_id_cliente;

    public Investimento(int codigoRetornado, double cdi, double valor) {}

    public Investimento(int id_invest, double cdi, double valor, int cliente_id_cliente) {
        this.id_invest = id_invest;
        this.cdi = cdi;
        this.valor = valor;
        this.cliente_id_cliente = cliente_id_cliente;
    }

    public int getId_invest() {
        return id_invest;
    }

    public void setId_invest(int id_invest) {
        this.id_invest = id_invest;
    }

    public double getCdi() {
        return cdi;
    }

    public void setCdi(double cdi) {
        this.cdi = cdi;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getCliente_id_cliente() {
        return cliente_id_cliente;
    }

    public void setCliente_id_cliente(int cliente_id_cliente) {
        this.cliente_id_cliente = cliente_id_cliente;
    }
}
