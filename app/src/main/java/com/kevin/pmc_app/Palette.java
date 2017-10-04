package com.kevin.pmc_app;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import android.widget.SeekBar;

/**
 * Created by kchoi on 9/29/2017.
 * Small pop-up window for choosing brush sizes and color
 */

public class Palette extends Activity {
    private SeekBar thicknessBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.palette);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x; // get screen dimensions
        int height = size.y;

        thicknessBar = (SeekBar) findViewById(R.id.thickness);
        //TODO: add an OnSeekBarChangeListener


        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.x = 0; // set window coordinate
        params.y = 0;
        params.height = (int) (height * 0.6); // set window dimensions
        params.width = (int) (width * 0.6);
        params.dimAmount = 0.75f;
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        this.getWindow().setAttributes(params); // re-sizes window and dims other activities
        this.setFinishOnTouchOutside(true); // closes activity when touched outside
    }
}
