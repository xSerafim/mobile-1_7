package com.example.ex07.model;

public abstract class ContaBancaria {

    private String cliente;
    private int num_conta;
    private float saldo;

    public ContaBancaria(String cliente, int num_conta, float saldoInicial) {
        this.cliente = cliente;
        this.num_conta = num_conta;
        this.saldo = saldoInicial;
    }

    // Getters
    public String getCliente() {
        return cliente;
    }

    public int getNumConta() {
        return num_conta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setNumConta(int num_conta) {
        this.num_conta = num_conta;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public void sacar(float valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para saque.");
        }
    }

    public void depositar(float valor) {
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
    }
}
