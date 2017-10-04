package com.kevin.pmc_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Intent popUp = new Intent(MainActivity.this, Pop.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(popUp);
    }
}
