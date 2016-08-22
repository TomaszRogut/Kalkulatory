package com.example.tomek.kalkulatory;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Kalkulator1Activity extends Activity implements View.OnClickListener {

    //dekalracja przyciskow i pol tekstowych
    EditText liczba1_pole;
    EditText liczba2_pole;
    Button button_suma;
    Button button_roznica;
    Button button_iloczyn;
    Button button_iloraz;
    TextView wynik_pole;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator1);

        liczba1_pole = (EditText) findViewById(R.id.liczba1_pole);
        liczba2_pole = (EditText) findViewById(R.id.liczba2_pole);
        button_suma = (Button) findViewById(R.id.button_suma);
        button_roznica = (Button) findViewById(R.id.button_roznica);
        button_iloczyn = (Button) findViewById(R.id.button_iloczyn);
        button_iloraz = (Button) findViewById(R.id.button_iloraz);
        wynik_pole = (TextView) findViewById(R.id.wynik_pole);

        //przypisanie nasłuchu do przycisków operacji matematycznych
        button_suma.setOnClickListener(this);
        button_roznica.setOnClickListener(this);
        button_iloczyn.setOnClickListener(this);
        button_iloraz.setOnClickListener(this);
    }

    //@Override
    public void onClick(View v) {
        float liczba1=0;
        float liczba2=0;
        float wynik=0;

        //sprawdzanie czy uzupełniono liczby do operacji matematycznych
        //w przeciwnym razie wywala program
        if (TextUtils.isEmpty(liczba1_pole.getText().toString())||TextUtils.isEmpty(liczba2_pole.getText().toString())){
            return;
        }

        //konwersja wpisanych liczb (ze stringa na float) i przypisanie ich do zmiennych
        liczba1 = Float.parseFloat(liczba1_pole.getText().toString());
        liczba2 = Float.parseFloat(liczba2_pole.getText().toString());

        //wybór typu operacji matematycznej
        switch (v.getId()) {
            case R.id.button_suma:
                wynik=liczba1+liczba2;
                break;
            case R.id.button_roznica:
                wynik=liczba1-liczba2;
                break;
            case R.id.button_iloczyn:
                wynik=liczba1*liczba2;
                break;
            case R.id.button_iloraz:
                wynik=liczba1/liczba2;
                break;
        }
        //wyświetlenie wyniku operacji w polu tekstowym
        wynik_pole.setText("wynik działania: " + wynik);

    }
    //osobny przycisk do wyjścia z obecnej aktywności
    //zachowanie takie jak sprzętowy przycisk powrotu
    public void closeActivity(View view) {
        finish();
    }
}