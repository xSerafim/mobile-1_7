package com.example.ex07.model;

public class ContaPoupanca extends ContaBancaria {

    private int diaRendimento;

    public ContaPoupanca(String cliente, int num_conta, float saldoInicial, int diaRendimento) {
        super(cliente, num_conta, saldoInicial);
        this.diaRendimento = diaRendimento;
    }

    public void setDiaRendimento(int diaRendimento) {
        this.diaRendimento = diaRendimento;
    }
    public int getDiaRendimento() {
        return diaRendimento;
    }

    public void calcularNovoSaldo(float taxaRendimento) {
        float rendimento = getSaldo() * taxaRendimento;
        depositar(rendimento);
        System.out.println("Rendimento de R$" + rendimento + " aplicado à conta poupança.");
    }
}
