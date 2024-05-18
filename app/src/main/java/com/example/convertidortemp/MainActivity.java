package com.example.convertidortemp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Spinner spin1, spin2;
    EditText cajaRes, cajaNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spin1 = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.spinner,
                android.R.layout.simple_spinner_item
        );
        spin1.setAdapter(adapter);

        spin2 = findViewById(R.id.spinner2);
        spin2.setAdapter(adapter);

        cajaNum = findViewById(R.id.caja_Num);
        cajaRes = findViewById(R.id.caja_Res);
    }

    public void btn_calc(View v){
        conversion();
    }

    public void conversion(){
        String sp1 = spin1.getSelectedItem().toString();
        String sp2 = spin2.getSelectedItem().toString();
        double grados = Double.parseDouble(cajaNum.getText().toString());
        if (sp1.equals("Centigrados")){
            if (sp1.equals("Centigrados") && sp2.equals("Centigrados")){
                cajaRes.setText(""+grados);
            }else if (sp1.equals("Centigrados") && sp2.equals("Fahrenheit")){
                cajaRes.setText(""+(((grados* 9)/5) + 32));
            }else if (sp1.equals("Centigrados") && sp2.equals("Kelvin")){
                cajaRes.setText((grados+273.15)+"");
            }else if (sp1.equals("Centigrados") && sp2.equals("Rankine")){
                cajaRes.setText(""+((grados*9)/5 + 491.67));
            }
        }else if (sp1.equals("Fahrenheit")){
            if (sp1.equals("Fahrenheit") && sp2.equals("Fahrenheit")){
                cajaRes.setText(""+grados);
            }else if (sp1.equals("Fahrenheit") && sp2.equals("Centigrados")){
                cajaRes.setText(""+(((grados-32) * 5)/9));
            }else if (sp1.equals("Fahrenheit") && sp2.equals("Kelvin")){
                cajaRes.setText(""+((((grados-32) * 5)/9)+273.15));
            }else if (sp1.equals("Fahrenheit") && sp2.equals("Rankine")){
                cajaRes.setText(""+(grados+ 459.67));
            }
        }else if (sp1.equals("Kelvin")){
            if (sp1.equals("Kelvin") && sp2.equals("Kelvin")){
                cajaRes.setText(""+grados);
            }else if (sp1.equals("Kelvin") && sp2.equals("Centigrados")){
                cajaRes.setText(""+(grados- 273.15));
            }else if (sp1.equals("Kelvin") && sp2.equals("Fahrenheit")){
                cajaRes.setText(""+(((grados-273.18)* 9/5 + 32)));
            }else if (sp1.equals("Kelvin") && sp2.equals("Rankine")){
                cajaRes.setText(""+(((9*(grados-273.15))/9)+491.67));
            }
        }else if (sp1.equals("Rankine")){
            if (sp1.equals("Rankine") && sp2.equals("Rankine")){
                cajaRes.setText(""+grados);
            }else if (sp1.equals("Rankine") && sp2.equals("Centigrados")){
                cajaRes.setText(""+((grados-491.67)*5/9));
            }else if (sp1.equals("Rankine") && sp2.equals("Fahrenheit")){
                cajaRes.setText(""+(grados-459.67));
            }else if (sp1.equals("Rankine") && sp2.equals("Kelvin")){
                cajaRes.setText(""+(((5*(grados-491.67))/9)+273.15));
            }
        }
    }
}