package com.example.ex6.model;

public class ProfessorTitular extends Professor {

    private int anoInstituicao;
    private double salario;

    public ProfessorTitular(String nome, int matricula, int idade, int anoInstituicao, double salario) {
        super(nome, matricula, idade);
        this.anoInstituicao = anoInstituicao;
        this.salario = salario;
    }

    public int getAnoInstituicao() {
        return anoInstituicao;
    }

    public void setAnoInstituicao(int anoInstituicao) {
        this.anoInstituicao = anoInstituicao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public double calcSalario() {
        double salarioCalculado = this.salario;
        int incrementos = this.anoInstituicao / 5;

        for (int i = 0; i < incrementos; i++) {
            salarioCalculado *= 1.05;
        }

        return salarioCalculado;
    }
}
