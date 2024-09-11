package com.example.kalkulatorsederhana;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etNumber1, etNumber2;
    TextView tvResult;
    Button btnMultiply, btnDivide, btnSubtract, btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi komponen
        etNumber1 = findViewById(R.id.etNumber1);
        etNumber2 = findViewById(R.id.etNumber2);
        tvResult = findViewById(R.id.tvResult);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnAdd = findViewById(R.id.btnAdd);

        // Aksi tombol kali
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('*');
            }
        });

        // Aksi tombol bagi
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('/');
            }
        });

        // Aksi tombol kurang
        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('-');
            }
        });

        // Aksi tombol tambah
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('+');
            }
        });
    }

    // Fungsi kalkulasi
    private void calculate(char operator) {
        String num1Str = etNumber1.getText().toString();
        String num2Str = etNumber2.getText().toString();

        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            Toast.makeText(this, "Masukkan kedua angka!", Toast.LENGTH_SHORT).show();
            return;
        }

        double num1 = Double.parseDouble(num1Str);
        double num2 = Double.parseDouble(num2Str);
        double result = 0;

        switch (operator) {
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    Toast.makeText(this, "Tidak dapat membagi dengan nol!", Toast.LENGTH_SHORT).show();
                    return;
                }
                result = num1 / num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '+':
                result = num1 + num2;
                break;
        }

        tvResult.setText(String.valueOf(result));
    }
}
