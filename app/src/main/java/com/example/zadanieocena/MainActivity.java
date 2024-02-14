package com.example.zadanieocena;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        EditText waga = findViewById(R.id.waga);
        EditText wzrost = findViewById(R.id.wzrost);

        try {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    double waga1 = Double.parseDouble(waga.getText().toString());
                    Double wzrost1 = Double.parseDouble(wzrost.getText().toString());
                    wzrost1 /=100;
                    Double BMI = waga1 / (wzrost1*wzrost1) ;
                    TextView bmi = findViewById(R.id.textView);
                    String opis = "";
                    BMI = Math.floor(BMI*100) / 100;
                    if (BMI < 18.5) opis = "niedowaga";
                    else if (BMI >= 18.5 && BMI <=24.99) opis=" waga prawidlowa";
                    else opis="nadwaga";
                    bmi.setText("twoje Bmi wynosi: " + BMI.toString() + " masz: "+ opis);
                }
            });
        }
        catch (Exception e){

            Toast.makeText(getBaseContext(), String.format(e.getMessage()), Toast.LENGTH_SHORT).show();

        }

    }
}