package com.myGame.thunder;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MainViewBg extends View {
    Paint paint = new Paint();
    //	Bitmap filter=null;
    int size = Pixel.getSize() * 25 + Pixel.getDistance() * 24;

    //	int a;
    public MainViewBg(Context context) {
        super(context);
    }

    public MainViewBg(Context context, AttributeSet a) {
        super(context, a);
    }

    public MainViewBg(Context context, AttributeSet a, int b) {
        super(context, a, b);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //	canvas.drawColor(Color.rgb(249,240,177));
        paint.setColor(Color.rgb(232, 222, 165));
        drawBackground(paint, canvas);

    }

    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(size + 1, size + 1);
    }

    public void drawBackground(Paint paint, Canvas canvas) {
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                Pixel p = new Pixel(i, j);
                canvas.drawRect(p.getRect(), paint);
            }
        }
    }


}