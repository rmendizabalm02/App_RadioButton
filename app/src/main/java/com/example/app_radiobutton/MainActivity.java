package com.example.app_radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    EditText et2;
    RadioButton rb1;
    RadioButton rb2;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Numeros que pide
        et1 = (EditText) findViewById(R.id.txt_num1);
        et2 = (EditText) findViewById(R.id.txt_num2);

        //Operaciones
        rb1 = (RadioButton) findViewById(R.id.rb_sumar);
        rb2 = (RadioButton) findViewById(R.id.rb_restar);

        //Resultado
        tv = (TextView) findViewById(R.id.tv_resultado);

    }

    //Boton calcular
    public void calcular(View view){
        String valor1 = et1.getText().toString();
        String valor2 = et2.getText().toString();

        //comprobamos si algun valor esta vacio para que muestre un aviso
        if ((valor1.isEmpty() && valor2.isEmpty()) | valor1.isEmpty() | valor2.isEmpty()) {
            Toast.makeText(this, "escribe los dos valores", Toast.LENGTH_LONG).show();

        }else {

            int num1 = Integer.parseInt(valor1);
            int num2 = Integer.parseInt(valor2);

            if (rb1.isChecked()) {

                int resultado = sumar(num1, num2);
                tv.setText(String.valueOf(resultado));

            } else if (rb2.isChecked()) {

                int resultado = restar(num1, num2);
                tv.setText(String.valueOf(resultado));

            } else {
                Toast.makeText(this, "selecciona una opcion", Toast.LENGTH_LONG).show();

            }
        }
    }

    //SUMA
    public int sumar(int valor1, int valor2){
        return valor1 + valor2;
    }

    //RESTA
    public int restar(int valor1, int valor2){
        return valor1 - valor2;
    }


}