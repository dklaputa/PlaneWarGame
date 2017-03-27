package com.myGame.thunder;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class ScoreView extends View {
    Alphabet alphabet = new Alphabet();
    Paint paint = new Paint();
    int width = SmallPixel.size * 15 + SmallPixel.d * 14;
    int height = SmallPixel.size * 5 + SmallPixel.d * 4;

    public ScoreView(Context context) {
        super(context);
    }

    public ScoreView(Context context, AttributeSet a) {
        super(context, a);
    }

    public ScoreView(Context context, AttributeSet a, int b) {
        super(context, a, b);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //	canvas.drawColor(Color.rgb(249,240,177));
        paint.setColor(Color.DKGRAY);
        drawScore(paint, canvas);
    }

    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(width + 1, height + 1);
    }

    public void drawScore(Paint paint, Canvas canvas) {
        int a = MainActivity.score / 1000;
        int b = (MainActivity.score % 1000) / 100;
        int c = ((MainActivity.score % 1000) % 100) / 10;
        int d = ((MainActivity.score % 1000) % 100) % 10;
        if (MainActivity.score > 9999) a = b = c = d = 9;
        if (a != 0) {
            for (int i = 0; i < alphabet.getNumPixel(0, 0, a).length; i++) {
                canvas.drawRect(alphabet.getNumPixel(0, 0, a)[i].getRect(), paint);
            }
        }
        if (a != 0 || b != 0) {
            for (int i = 0; i < alphabet.getNumPixel(4, 0, b).length; i++) {
                canvas.drawRect(alphabet.getNumPixel(4, 0, b)[i].getRect(), paint);
            }
        }
        if (!(a == 0 && b == 0 && c == 0)) {
            for (int i = 0; i < alphabet.getNumPixel(8, 0, c).length; i++) {
                canvas.drawRect(alphabet.getNumPixel(8, 0, c)[i].getRect(), paint);
            }
        }
        for (int i = 0; i < alphabet.getNumPixel(12, 0, d).length; i++) {
            canvas.drawRect(alphabet.getNumPixel(12, 0, d)[i].getRect(), paint);
        }
    }
}
