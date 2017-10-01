package com.kevin.pmc_app;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

/**
 * Created by Kevin on 9/29/2017.
 * Opening window
 */

public class Pop extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popwindow);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x; // get screen dimensions
        int height = size.y;

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.x = 0; // set window coordinate
        params.y = 0;
        params.height = (int) (height * 0.6); // set window dimensions
        params.width = (int) (width * 0.6);
        params.dimAmount = 0.75f;
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        this.getWindow().setAttributes(params); // re-sizes window and dims other activities
        Button b = (Button) findViewById(R.id.btn_select_file);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  TODO: Load a file
            }
        });
        this.setFinishOnTouchOutside(true); // close file when outside is touched
    }

}
