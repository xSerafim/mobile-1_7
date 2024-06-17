package com.example.ex5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroupNumDados;
    private RadioButton radioButton1Dado, radioButton2Dados, radioButton3Dados;
    private Spinner spinnerTipoDado;
    private Button btnRolar;
    private TextView textViewResultado;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroupNumDados = findViewById(R.id.radioGroupNumDados);
        radioButton1Dado = findViewById(R.id.radioButton1Dado);
        radioButton2Dados = findViewById(R.id.radioButton2Dados);
        radioButton3Dados = findViewById(R.id.radioButton3Dados);
        spinnerTipoDado = findViewById(R.id.spinnerTipoDado);
        btnRolar = findViewById(R.id.btnRolar);
        textViewResultado = findViewById(R.id.textViewResultado);

        btnRolar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rolarDados();
            }
        });
    }

    private void rolarDados() {
        int numDados = 1;
        if (radioButton2Dados.isChecked()) {
            numDados = 2;
        } else if (radioButton3Dados.isChecked()) {
            numDados = 3;
        }

        String tipoDado = spinnerTipoDado.getSelectedItem().toString();
        int numFaces = Integer.parseInt(tipoDado.substring(1)); // Extrai o número de faces do texto "Dxx"

        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < numDados; i++) {
            int valor = random.nextInt(numFaces) + 1;
            resultado.append("Dado ").append(i + 1).append(": ").append(valor).append("\n");
        }

        textViewResultado.setText(resultado.toString());
    }
}