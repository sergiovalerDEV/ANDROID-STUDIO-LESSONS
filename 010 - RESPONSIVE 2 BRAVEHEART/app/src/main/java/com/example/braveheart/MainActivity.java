package com.example.braveheart;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button miBotonA;
    private Button miBotonB;
    private Button miBotonC;
    private Button miBotonD;
    private Button miBotonE;
    private Button miBotonF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Así optimizamos el getElementById con una llamada a la función que cubre todos
        InicializarComponentes();

        List<Button> botones = Arrays.asList(miBotonA, miBotonB, miBotonC, miBotonD, miBotonE, miBotonF);

        for (Button boton : botones) {
            boton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, "Botón " + boton.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void InicializarComponentes() {
        miBotonA = (Button) findViewById(R.id.btnA);
        miBotonB = (Button) findViewById(R.id.btnB);
        miBotonC = (Button) findViewById(R.id.btnC);
        miBotonD = (Button) findViewById(R.id.btnD);
        miBotonE = (Button) findViewById(R.id.btnE);
        miBotonF = (Button) findViewById(R.id.btnF);
    }
}
