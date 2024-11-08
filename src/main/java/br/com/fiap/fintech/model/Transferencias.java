package br.com.fiap.fintech.model;

public class Transferencias {
    int id_transfe;
    double receitas;
    double despesas;
    int cliente_id_cliente;

    public Transferencias(int id_transfe, double receitas, double despesas, int cliente_id_cliente) {
        this.id_transfe = id_transfe;
        this.receitas = receitas;
        this.despesas = despesas;
        this.cliente_id_cliente = cliente_id_cliente;
    }

    public int getId_transfe() {
        return id_transfe;
    }

    public void setId_transfe(int id_transfe) {
        this.id_transfe = id_transfe;
    }

    public double getReceitas() {
        return receitas;
    }

    public void setReceitas(double receitas) {
        this.receitas = receitas;
    }

    public double getDespesas() {
        return despesas;
    }

    public void setDespesas(double despesas) {
        this.despesas = despesas;
    }

    public int getCliente_id_cliente() {
        return cliente_id_cliente;
    }

    public void setCliente_id_cliente(int cliente_id_cliente) {
        this.cliente_id_cliente = cliente_id_cliente;
    }
}


