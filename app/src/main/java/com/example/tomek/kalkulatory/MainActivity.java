package com.example.tomek.kalkulatory;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void openKalkulator1Activity(View view) {

        Intent intent = new Intent(this, Kalkulator1Activity.class);
        startActivity(intent);
    }
    public void openKalkulator2Activity(View view) {

        Intent intent = new Intent(this, Kalkulator2Activity.class);
        startActivity(intent);
    }
    public void openAutorActivity(View view) {

        Intent intent = new Intent(this, AutorActivity.class);
        startActivity(intent);
    }
    public void closeActivity (View view){
        finish();
    }
}
