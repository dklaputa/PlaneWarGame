package com.myGame.thunder;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class ScoreViewBg extends View {
    Paint paint = new Paint();
    int width = SmallPixel.size * 15 + SmallPixel.d * 14;
    int height = SmallPixel.size * 5 + SmallPixel.d * 4;

    public ScoreViewBg(Context context) {
        super(context);
    }

    public ScoreViewBg(Context context, AttributeSet a) {
        super(context, a);
    }

    public ScoreViewBg(Context context, AttributeSet a, int b) {
        super(context, a, b);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //	canvas.drawColor(Color.rgb(249,240,177));
        paint.setColor(Color.rgb(232, 222, 165));
        drawBackground(paint, canvas);
    }

    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(width + 1, height + 1);
    }

    public void drawBackground(Paint paint, Canvas canvas) {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                SmallPixel sp = new SmallPixel(i, j);
                canvas.drawRect(sp.getRect(), paint);
            }
        }
    }

}
