
package com.calculadora.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText numero1, numero2;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero1 = (EditText) findViewById(R.id.numero1);
        numero2 = (EditText) findViewById(R.id.numero2);
        txtResultado = (TextView) findViewById(R.id.txtResultado);

        configurarBoton(R.id.btnSumar, "+");
        configurarBoton(R.id.btnRestar, "-");
        configurarBoton(R.id.btnMultiplicar, "*");
        configurarBoton(R.id.btnDividir, "/");

        Button limpiar = (Button) findViewById(R.id.btnLimpiar);

        limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numero1.setText("");
                numero2.setText("");
                txtResultado.setText("Resultado:");
            }
        });
    }

    private void configurarBoton(int id, final String operacion) {
        Button boton = (Button) findViewById(id);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular(operacion);
            }
        });
    }

    private void calcular(String operacion) {

        String valor1 = numero1.getText().toString();
        String valor2 = numero2.getText().toString();

        if (valor1.isEmpty() || valor2.isEmpty()) {
            Toast.makeText(this, "Ingrese los dos números",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        double n1 = Double.parseDouble(valor1);
        double n2 = Double.parseDouble(valor2);
        double resultado = 0;

        switch (operacion) {
            case "+":
                resultado = n1 + n2;
                break;
            case "-":
                resultado = n1 - n2;
                break;
            case "*":
                resultado = n1 * n2;
                break;
            case "/":
                if (n2 == 0) {
                    Toast.makeText(this,
                            "No se puede dividir entre cero",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                resultado = n1 / n2;
                break;
        }

        txtResultado.setText("Resultado: " + resultado);
    }
}

