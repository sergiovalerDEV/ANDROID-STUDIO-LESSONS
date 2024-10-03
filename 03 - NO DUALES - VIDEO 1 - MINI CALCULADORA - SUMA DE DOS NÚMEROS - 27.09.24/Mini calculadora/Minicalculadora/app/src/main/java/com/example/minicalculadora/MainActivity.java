package com.example.minicalculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    /* Objetos visuales que tengo que recuperar */
    private EditText edtNumero1;
    private EditText edtNumero2;
    private Button btnSumar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNumero1 = (EditText) findViewById(R.id.edtNumero1);
        edtNumero2 = (EditText) findViewById(R.id.edtNumero2); // Corregido: debe ser edtNumero2
        btnSumar = (Button) findViewById(R.id.btnSumar);

        btnSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener los valores de los EditText
                String cadena1 = edtNumero1.getText().toString();
                String cadena2 = edtNumero2.getText().toString(); // Corregido: debe ser edtNumero2
                int numero1 = Integer.parseInt(cadena1);
                int numero2 = Integer.parseInt(cadena2);
                int resultado = numero1 + numero2; // Calcular la suma

                // Mostrar el resultado en un Toast
                Toast.makeText(MainActivity.this, "El resultado de la suma es: " + resultado, Toast.LENGTH_SHORT).show(); // Corregido: se añadió el método show()
            }
        });
    }
}

//Los programas se hacen con Java y Groovy