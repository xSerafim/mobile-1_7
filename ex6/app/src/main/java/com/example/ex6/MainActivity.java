package com.example.ex6;

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

import com.example.ex6.model.Professor;
import com.example.ex6.model.ProfessorHorista;
import com.example.ex6.model.ProfessorTitular;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroupTipoProfessor;
    private RadioButton radioButtonTitular, radioButtonHorista;
    private EditText editTextNome, editTextMatricula, editTextIdade, editTextAnoInstituicao, editTextSalarioBase, editTextHorasAula, editTextValorHoraAula;
    private Button btnCalcular;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroupTipoProfessor = findViewById(R.id.radioGroupTipoProfessor);
        radioButtonTitular = findViewById(R.id.radioButtonTitular);
        radioButtonHorista = findViewById(R.id.radioButtonHorista);
        editTextNome = findViewById(R.id.editTextNome);
        editTextMatricula = findViewById(R.id.editTextMatricula);
        editTextIdade = findViewById(R.id.editTextIdade);
        editTextAnoInstituicao = findViewById(R.id.editTextAnoInstituicao);
        editTextSalarioBase = findViewById(R.id.editTextSalarioBase);
        editTextHorasAula = findViewById(R.id.editTextHorasAula);
        editTextValorHoraAula = findViewById(R.id.editTextValorHoraAula);
        btnCalcular = findViewById(R.id.btnCalcular);
        textViewResultado = findViewById(R.id.textViewResultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularSalario();
            }
        });
    }

    private void calcularSalario() {
        String nome = editTextNome.getText().toString();
        int matricula = Integer.parseInt(editTextMatricula.getText().toString());
        int idade = Integer.parseInt(editTextIdade.getText().toString());

        Professor professor;
        if (radioButtonTitular.isChecked()) {
            int anoInstituicao = Integer.parseInt(editTextAnoInstituicao.getText().toString());
            double salarioBase = Double.parseDouble(editTextSalarioBase.getText().toString());
            professor = new ProfessorTitular(nome, matricula, idade, anoInstituicao, salarioBase);
        } else {
            int horasAula = Integer.parseInt(editTextHorasAula.getText().toString());
            double valorHoraAula = Double.parseDouble(editTextValorHoraAula.getText().toString());
            professor = new ProfessorHorista(nome, matricula, idade, horasAula, valorHoraAula);
        }

        double salario = professor.calcSalario();
        textViewResultado.setText("Salário: R$ " + String.format("%.2f", salario));
    }
}