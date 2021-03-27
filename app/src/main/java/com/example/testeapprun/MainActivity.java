package com.example.testeapprun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView resultadoConversao = findViewById(R.id.resultadoConversao);
        TextView resultadoAritmetrica = findViewById(R.id.resultadoAritmetrica);

        EditText num1 = findViewById(R.id.num1);
        EditText num2 = findViewById(R.id.num2);
        EditText converter = findViewById(R.id.editTextConverter);

        RadioButton rb_decimal1 = findViewById(R.id.radioDecimal1);
        RadioButton rb_romano1 = findViewById(R.id.radioRomano1);
        RadioButton rb_decimal2 = findViewById(R.id.radioDecimal2);
        RadioButton rb_romano2= findViewById(R.id.radioRomano2);

        Button btnSomar = findViewById(R.id.somar);
        Button btnSubtrair = findViewById(R.id.subtrair);
        Button btnConverter = findViewById(R.id.btnConverter);

        RadioGroup radioGroup1 = findViewById(R.id.radioGroup1);

        RadioGroup radioGroup2 = findViewById(R.id.radioGroup2);

        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.radioDecimal1){
                    Toast.makeText(getApplicationContext(),"Decimal checked",Toast.LENGTH_SHORT).show();
                }
                if(checkedId==R.id.radioRomano1){
                    Toast.makeText(getApplicationContext(),"Romano checked",Toast.LENGTH_SHORT).show();
                }
            }
        });

        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.radioDecimal2){
                    Toast.makeText(getApplicationContext(),"Decimal checked",Toast.LENGTH_SHORT).show();
                }
                if(checkedId==R.id.radioRomano2){
                    Toast.makeText(getApplicationContext(),"Romano checked",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rb_decimal1.isChecked()){
                    try{
                        resultadoConversao.setText(decimalToRomano(Integer.parseInt(converter.getText().toString())));
                    }catch (Exception e){
                       Toast.makeText(getApplicationContext(),"O parametro inserido é invalido",Toast.LENGTH_SHORT).show();
                    }
                }else if(rb_romano1.isChecked()){
                    try{
                        resultadoConversao.setText(String.valueOf(romanoToDecimal(converter.getText().toString().toUpperCase())));
                        if(resultadoConversao.getText() == "" || resultadoConversao.getText() == String.valueOf(0) ){
                            Toast.makeText(getApplicationContext(),"O parametro inserido é invalido",Toast.LENGTH_SHORT).show();
                        }
                    }catch (Exception e){
                        Toast.makeText(getApplicationContext(),"O parametro inserido é invalido",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"O parametro inserido é invalido",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSomar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rb_decimal2.isChecked()){
                    try{
                        double a = Double.parseDouble(num1.getText().toString());
                        double b = Double.parseDouble(num2.getText().toString());
                        resultadoAritmetrica.setText(String.valueOf(a + b));
                    }catch (Exception e){
                        Toast.makeText(getApplicationContext(), "O parametro inserido é invalido", Toast.LENGTH_SHORT).show();
                    }

                }else if(rb_romano2.isChecked()){
                    try{

                        int a = Integer.parseInt(String.valueOf(romanoToDecimal(num1.getText().toString().toUpperCase())));
                        int b = Integer.parseInt((String.valueOf(romanoToDecimal(num2.getText().toString().toUpperCase()))));
                        int soma = a+b;
                        if (a!=0 && b!=0){
                            resultadoAritmetrica.setText(decimalToRomano(soma));
                        }else{
                            Toast.makeText(getApplicationContext(),"O parametro inserido é invalido",Toast.LENGTH_SHORT).show();
                        }
                        if(resultadoAritmetrica.getText() == "" || resultadoAritmetrica.getText() == String.valueOf(0) ){
                            Toast.makeText(getApplicationContext(),"O parametro inserido é invalido",Toast.LENGTH_SHORT).show();
                        }
                    }catch (Exception e){
                        Toast.makeText(getApplicationContext(), "O parametro inserido é invalido", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(getApplicationContext(), "O parametro inserido é invalido", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSubtrair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rb_decimal2.isChecked()){
                    try{
                        double a = Double.parseDouble(num1.getText().toString());
                        double b = Double.parseDouble(num2.getText().toString());
                        resultadoAritmetrica.setText(String.valueOf(a - b));
                    }catch (Exception e){
                        Toast.makeText(getApplicationContext(), "O parametro inserido é invalido", Toast.LENGTH_SHORT).show();
                    }

                }if(rb_romano2.isChecked()){
                    try{
                        int a = Integer.parseInt(String.valueOf(romanoToDecimal(num1.getText().toString().toUpperCase())));
                        int b = Integer.parseInt((String.valueOf(romanoToDecimal(num2.getText().toString().toUpperCase()))));
                        int diferenca = a-b;
                        if (a!=0 && b!=0){
                            resultadoAritmetrica.setText(decimalToRomano(diferenca));
                        }else{
                            Toast.makeText(getApplicationContext(),"O parametro inserido é invalido",Toast.LENGTH_SHORT).show();
                        }
                        if(resultadoAritmetrica.getText() == "" || resultadoAritmetrica.getText() == String.valueOf(0) ){
                            Toast.makeText(getApplicationContext(),"O parametro inserido é invalido",Toast.LENGTH_SHORT).show();
                        }
                    }catch (Exception e){
                        Toast.makeText(getApplicationContext(), "O parametro inserido é invalido", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(getApplicationContext(), "O parametro inserido é invalido", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private String decimalToRomano(int numero){
        int[] decimal = {1000, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romano = {"M", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        String valor ="";
        while (true) {
            if (numero == 0) break;
            System.out.printf("%-4d ", numero);
            int i = 0;
            while (numero > 0) {
                if (numero >= decimal[i]) {
                    System.out.print(romano[i]);
                    valor = valor.concat(romano[i]);
                    numero -= decimal[i];
                } else {
                    i++;
                }
            }
            System.out.println();
            break;
        }
        return valor;
    }



    private int romanoToDecimal(String texto) {
        int n = 0;
        int numeralDaDireita = 0;
        for (int i = texto.length() - 1; i >= 0; i--) {
            int valor = (int) romanoToDecimal(texto.charAt(i));
            n += valor * Math.signum(valor + 0.5 - numeralDaDireita);
            numeralDaDireita = valor;
        }
        return n;
    }

    private double romanoToDecimal(char caractere) {
        return Math.floor(Math.pow(10, "IXCM".indexOf(caractere))) + 5 * Math.floor(Math.pow(10, "VLD".indexOf(caractere)));
    }

}