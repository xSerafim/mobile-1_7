package com.example.ex07.model;

public class ContaEspecial extends ContaBancaria {

    private float limite;

    public ContaEspecial(String cliente, int num_conta, float saldoInicial, float limite) {
        super(cliente, num_conta, saldoInicial);
        this.limite = limite;
    }

    public float getLimite() {
        return limite;
    }

    @Override
    public void sacar(float valor) {
        if (valor <= getSaldo() + limite) {
            float saldo = getSaldo();
            setSaldo(saldo - valor);
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para saque.");
        }
    }
}
