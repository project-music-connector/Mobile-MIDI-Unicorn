package com.kevin.pmc_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent popUp = new Intent(MainActivity.this, Pop.class);
        Intent drawScreen = new Intent(MainActivity.this, DrawActivity.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(drawScreen);
        startActivity(popUp);
    }
}
