package com.example.ex4;

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

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText editTextDia, editTextMes, editTextAno;
    private Button btnCalcular;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextDia = findViewById(R.id.editTextDia);
        editTextMes = findViewById(R.id.editTextMes);
        editTextAno = findViewById(R.id.editTextAno);
        btnCalcular = findViewById(R.id.btnCalcular);
        textViewResultado = findViewById(R.id.textViewResultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularIdade();
            }
        });
    }

    private void calcularIdade() {
        try {
            int diaNascimento = Integer.parseInt(editTextDia.getText().toString());
            int mesNascimento = Integer.parseInt(editTextMes.getText().toString());
            int anoNascimento = Integer.parseInt(editTextAno.getText().toString());

            Calendar dataNascimento = Calendar.getInstance();
            dataNascimento.set(anoNascimento, mesNascimento - 1, diaNascimento);

            Calendar hoje = Calendar.getInstance();

            int anos = hoje.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR);

            int meses = hoje.get(Calendar.MONTH) - dataNascimento.get(Calendar.MONTH);
            if (meses < 0) {
                anos--;
                meses += 12;
            }

            int dias = hoje.get(Calendar.DAY_OF_MONTH) - dataNascimento.get(Calendar.DAY_OF_MONTH);
            if (dias < 0) {
                meses--;
                if (meses < 0) {
                    anos--;
                    meses = 11;
                }
                int ultimoDiaMesAnterior = dataNascimento.getActualMaximum(Calendar.DAY_OF_MONTH);
                dias = ultimoDiaMesAnterior + dias;
            }

            String resultado = "Idade: " + anos + " anos, " + meses + " meses e " + dias + " dias.";
            textViewResultado.setText(resultado);

        } catch (NumberFormatException e) {
            textViewResultado.setText("Preencha os campos corretamente.");
        }
    }
}