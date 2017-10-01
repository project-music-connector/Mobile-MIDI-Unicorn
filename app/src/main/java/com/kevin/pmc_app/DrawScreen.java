package com.kevin.pmc_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by kchoi on 9/29/2017.
 */

public class DrawScreen extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawing_screen);

        Button b = (Button) findViewById(R.id.btn_palette); // button to toggle palette

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DrawScreen.this, Palette.class));
            }
        });
    }
}
