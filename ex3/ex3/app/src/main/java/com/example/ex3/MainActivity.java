package com.example.ex3;

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

    private EditText editTextGasolina, editTextEtanol;
    private Button btnCalcular;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextGasolina = findViewById(R.id.editTextGasolina);
        editTextEtanol = findViewById(R.id.editTextEtanol);
        btnCalcular = findViewById(R.id.btnCalcular);
        textViewResultado = findViewById(R.id.textViewResultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularVantagem();
            }
        });
    }

    private void calcularVantagem() {
        try {
            double precoGasolina = Double.parseDouble(editTextGasolina.getText().toString());
            double precoEtanol = Double.parseDouble(editTextEtanol.getText().toString());

            double razao = precoEtanol / precoGasolina;
            String resultado = razao <= 0.7 ? "Abasteça com etanol!" : "Abasteça com gasolina!";

            textViewResultado.setText(resultado);
        } catch (NumberFormatException e) {
            textViewResultado.setText("Preencha os preços corretamente.");
        }
    }
}