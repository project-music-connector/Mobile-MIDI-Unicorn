package com.kevin.pmc_app;

import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.content.Context;
import android.graphics.Path;
import android.graphics.Canvas;

import java.util.Stack;

/**
 * Created by Mihir on 10/4/17.
 */

public class DrawView extends View {

    private Path drawPath; // keeps track of current path being drawn
    private Stack<Path> stackPath; // a stack data structure of all paths
    private Paint paint;
    private int thickness;
    private int color; // TODO
    private Bitmap bitmap; // TODO

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);

        //get attributes defined in the attrs.xml
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.DrawView, 0, 0);
        thickness = a.getDimensionPixelSize(0, -1);


        drawPath = new Path();
        stackPath = new Stack<>();

        paint = new Paint();
    }
    private void setPaint() {
        paint.setAntiAlias(true);
        paint.setStrokeWidth(thickness);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(drawPath, paint);   //draws current path
        for (Path path : stackPath) {        //draws all previous paths
            canvas.drawPath(path, paint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                drawPath.moveTo(x, y);
                break;
            case MotionEvent.ACTION_MOVE:
                drawPath.lineTo(x, y);
                break;
            case MotionEvent.ACTION_UP:
                stackPath.push(new Path(drawPath));
                drawPath.reset();
                break;
            default:
                return false;
        }
        invalidate(); // forces canvas to redraw
        return true;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
        setPaint();
    }

    public void clear() {
        stackPath.clear();
        invalidate();
    }

    public void undo() {
        if (!stackPath.isEmpty()) {
            stackPath.pop();
            invalidate();
        }
    }
}
