package com.example.tomek.kalkulatory;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Kalkulator2Activity extends Activity {

    private EditText ekran;
    private float pierwsza_liczba;
    private String operator;
    private ButtonClickListeaner klawisz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator2);

        ekran = (EditText) findViewById(R.id.ekran);
        ekran.setEnabled(false);
        klawisz = new ButtonClickListeaner();

        int listaIdKlawiszy[] = {R.id.klawiszC, R.id.klawiszOdejmuj, R.id.klawiszDodaj, R.id.klawiszDziel, R.id.klawiszMnoz, R.id.klawiszWynik, R.id.klawisz1, R.id.klawisz2, R.id.klawisz3, R.id.klawisz4, R.id.klawisz5, R.id.klawisz6, R.id.klawisz7, R.id.klawisz8, R.id.klawisz9, R.id.klawisz0, R.id.klawiszKropka
        };
        for(int id : listaIdKlawiszy) {
            View v = findViewById(id);
            v.setOnClickListener(klawisz);}
    }

    public void dzialanie(String str){
        pierwsza_liczba = Float.parseFloat(ekran.getText().toString());
        operator = str;
        ekran.setText("");
    }

    public void odczytaj(String str){
        String biezaca_wartosc = ekran.getText().toString();
        if(biezaca_wartosc.equals("0"))
            biezaca_wartosc="";
        biezaca_wartosc+=str;
        ekran.setText(biezaca_wartosc);
    }

    //obsluga typu operacji
    private void podaj_rozwiazanie(){
        float druga_liczba = Float.parseFloat(ekran.getText().toString());
        float wynik_dzialania = 0;

        switch (operator){
            case("+"): wynik_dzialania = pierwsza_liczba + druga_liczba;
                ekran.setText(String.valueOf(wynik_dzialania));
                break;
            case("-"): wynik_dzialania = pierwsza_liczba - druga_liczba;
                ekran.setText(String.valueOf(wynik_dzialania));
                break;
            case("/"): wynik_dzialania = pierwsza_liczba / druga_liczba;
                ekran.setText(String.valueOf(wynik_dzialania));
                break;
            case("*"): wynik_dzialania = pierwsza_liczba * druga_liczba;
                ekran.setText(String.valueOf(wynik_dzialania));
                break;
        }
    }

    //obsluga klikniecia przyciskow
    private class ButtonClickListeaner implements View.OnClickListener{
        public void onClick(View v){
            switch (v.getId()){
                case R.id.klawiszC:
                    ekran.setText("");
                    operator="";
                    break;
                case R.id.klawiszDodaj:
                    dzialanie("+");
                    break;
                case R.id.klawiszOdejmuj:
                    dzialanie("-");
                    break;
                case R.id.klawiszDziel:
                    dzialanie("/");
                    break;
                case R.id.klawiszMnoz:
                    dzialanie("*");
                    break;
                case R.id.klawiszWynik:
                    podaj_rozwiazanie();
                    break;
                default:
                    String cyfra = ((Button)v).getText().toString();
                    odczytaj(cyfra);
                    break;
            }
        }
    }


}
