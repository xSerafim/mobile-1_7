package com.exercise_mobile;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextA, editTextB, editTextC;
    private TextView textViewDelta, textViewX1, textViewX2, textViewMensagem;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextA = findViewById(R.id.editTextA);
        editTextB = findViewById(R.id.editTextB);
        editTextC = findViewById(R.id.editTextC);
        textViewDelta = findViewById(R.id.textViewDelta);
        textViewX1 = findViewById(R.id.textViewX1);
        textViewX2 = findViewById(R.id.textViewX2);
        textViewMensagem = findViewById(R.id.textViewMensagem);
        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularEquacao();
            }
        });
    }

    private void calcularEquacao() {
        try {
            double a = Double.parseDouble(editTextA.getText().toString());
            double b = Double.parseDouble(editTextB.getText().toString());
            double c = Double.parseDouble(editTextC.getText().toString());

            if (a == 0) {
                textViewMensagem.setText("Não é uma equação de 2º grau.");
                limparResultados();
            } else {
                double delta = (b * b) - (4 * a * c);
                textViewDelta.setText("Delta: " + delta);

                if (delta < 0) {
                    textViewMensagem.setText("Não possui raízes reais.");
                    limparResultados();
                } else {
                    double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                    double x2 = (-b - Math.sqrt(delta)) / (2 * a);

                    textViewX1.setText("X1: " + x1);
                    textViewX2.setText("X2: " + x2);
                    textViewMensagem.setText("");
                }
            }
        } catch (NumberFormatException e) {
            textViewMensagem.setText("Entrada inválida.");
            limparResultados();
        }
    }

    private void limparResultados() {
        textViewX1.setText("X1: ");
        textViewX2.setText("X2: ");
    }
}