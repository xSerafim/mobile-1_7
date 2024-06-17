package com.example.ex07;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ex07.model.ContaBancaria;
import com.example.ex07.model.ContaEspecial;
import com.example.ex07.model.ContaPoupanca;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroupTipoConta;
    private RadioButton radioButtonPoupanca, radioButtonEspecial;
    private EditText editTextValorOperacao;
    private Button btnSacar, btnDepositar, btnCalcularRendimento, btnMostrarDados;
    private TextView textViewResultado;

    private ContaPoupanca contaPoupanca;
    private ContaEspecial contaEspecial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializa elementos da interface
        radioGroupTipoConta = findViewById(R.id.radioGroupTipoConta);
        radioButtonPoupanca = findViewById(R.id.radioButtonPoupanca);
        radioButtonEspecial = findViewById(R.id.radioButtonEspecial);
        editTextValorOperacao = findViewById(R.id.editTextValorOperacao);
        btnSacar = findViewById(R.id.btnSacar);
        btnDepositar = findViewById(R.id.btnDepositar);
        btnCalcularRendimento = findViewById(R.id.btnCalcularRendimento);
        btnMostrarDados = findViewById(R.id.btnMostrarDados);
        textViewResultado = findViewById(R.id.textViewResultado);

        // Cria as contas pré-definidas
        contaPoupanca = new ContaPoupanca("Maria", 1234, 1000.0f, 10);
        contaEspecial = new ContaEspecial("João", 5678, 2000.0f, 1000.0f);

        // Configura listeners para os botões
        btnSacar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sacar();
            }
        });

        btnDepositar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                depositar();
            }
        });

        btnCalcularRendimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularRendimento();
            }
        });

        btnMostrarDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDados();
            }
        });
    }

    private void sacar() {
        float valor = Float.parseFloat(editTextValorOperacao.getText().toString());
        if (radioButtonPoupanca.isChecked()) {
            contaPoupanca.sacar(valor);
            mostrarResultado(contaPoupanca);
        } else {
            contaEspecial.sacar(valor);
            mostrarResultado(contaEspecial);
        }
    }

    private void depositar() {
        float valor = Float.parseFloat(editTextValorOperacao.getText().toString());
        if (radioButtonPoupanca.isChecked()) {
            contaPoupanca.depositar(valor);
            mostrarResultado(contaPoupanca);
        } else {
            contaEspecial.depositar(valor);
            mostrarResultado(contaEspecial);
        }
    }

    private void calcularRendimento() {
        if (radioButtonPoupanca.isChecked()) {
            contaPoupanca.calcularNovoSaldo(0.005f); // Substitua pela taxa desejada
            mostrarResultado(contaPoupanca);
        } else {
            textViewResultado.setText("Operação inválida para Conta Especial.");
        }
    }

    private void mostrarDados() {
        if (radioButtonPoupanca.isChecked()) {
            mostrarResultado(contaPoupanca);
        } else {
            mostrarResultado(contaEspecial);
        }
    }

    private void mostrarResultado(ContaBancaria conta) {
        StringBuilder resultado = new StringBuilder();
        resultado.append("Cliente: ").append(conta.getCliente()).append("\n");
        resultado.append("Número da Conta: ").append(conta.getNumConta()).append("\n");
        resultado.append("Saldo: R$ ").append(String.format("%.2f", conta.getSaldo())).append("\n");

        if (conta instanceof ContaPoupanca) {
            ContaPoupanca cp = (ContaPoupanca) conta;
            resultado.append("Dia do Rendimento: ").append(cp.getDiaRendimento()).append("\n");
        } else if (conta instanceof ContaEspecial) {
            ContaEspecial ce = (ContaEspecial) conta;
            resultado.append("Limite: R$ ").append(String.format("%.2f", ce.getLimite())).append("\n");
        }

        textViewResultado.setText(resultado.toString());
    }
}