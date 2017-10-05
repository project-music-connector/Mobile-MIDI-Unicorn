package com.kevin.pmc_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by kchoi on 9/29/2017.
 * Screen for hand-drawing picture
 */

public class DrawActivity extends Activity {
    private DrawView drawView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);

        Button b = (Button) findViewById(R.id.btn_palette); // button to toggle palette
        drawView = (DrawView) findViewById(R.id.drawing);
        drawView.setThickness(10);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DrawActivity.this, Palette.class));
            }
        });
    }
}
