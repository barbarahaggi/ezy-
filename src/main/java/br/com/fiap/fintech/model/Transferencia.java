package br.com.fiap.fintech.model;

public class Transferencia {
    double despesas;
    double receita;
    int id_user;
    int id_conta;

    public Transferencia(double despesas, double receita, int id_user, int id_conta) {
        this.despesas = despesas;
        this.receita = receita;
        this.id_user = id_user;
        this.id_conta = id_conta;
    }

    public double getDespesas() {
        return despesas;
    }

    public void setDespesas(double despesas) {
        this.despesas = despesas;
    }

    public double getReceita() {
        return receita;
    }

    public void setReceita(double receita) {
        this.receita = receita;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_conta() {
        return id_conta;
    }

    public void setId_conta(int id_conta) {
        this.id_conta = id_conta;
    }
}


