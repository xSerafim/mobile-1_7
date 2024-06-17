package com.example.ex32;

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

    private EditText editTextConsumo, editTextLitros;
    private Button btnCalcular;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextConsumo = findViewById(R.id.editTextConsumo);
        editTextLitros = findViewById(R.id.editTextLitros);
        btnCalcular = findViewById(R.id.btnCalcular);
        textViewResultado = findViewById(R.id.textViewResultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularAutonomia();
            }
        });
    }

    private void calcularAutonomia() {
        try {
            double consumo = Double.parseDouble(editTextConsumo.getText().toString());
            double litros = Double.parseDouble(editTextLitros.getText().toString());

            double autonomiaKm = consumo * litros;
            double autonomiaMetros = autonomiaKm * 1000;

            textViewResultado.setText("Autonomia: " + autonomiaMetros + " metros");
        } catch (NumberFormatException e) {
            textViewResultado.setText("Preencha os campos corretamente.");
        }
    }
}