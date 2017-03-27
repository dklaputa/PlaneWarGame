package com.myGame.thunder;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class RoundView extends View {
    Alphabet alphabet = new Alphabet();
    Paint paint = new Paint();
    int width = SmallPixel.size * 15 + SmallPixel.d * 14;
    int height = SmallPixel.size * 5 + SmallPixel.d * 4;

    public RoundView(Context context) {
        super(context);
    }

    public RoundView(Context context, AttributeSet a) {
        super(context, a);
    }

    public RoundView(Context context, AttributeSet a, int b) {
        super(context, a, b);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //	canvas.drawColor(Color.rgb(249,240,177));
        paint.setColor(Color.rgb(232, 222, 165));
        //	drawBackground(paint,canvas);
        paint.setColor(Color.DKGRAY);
        drawRound(paint, canvas);
    }

    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(width + 1, height + 1);
    }

    public void drawRound(Paint paint, Canvas canvas) {//��ʾ�ؿ�
        int a = MainActivity.round / 10;
        int b = MainActivity.round % 10;
        if (MainActivity.round > 99) a = b = 9;
        if (a != 0) {
            for (int i = 0; i < alphabet.getNumPixel(0, 0, a).length; i++) {
                canvas.drawRect(alphabet.getNumPixel(8, 0, a)[i].getRect(), paint);
            }
        }
        for (int i = 0; i < alphabet.getNumPixel(4, 0, b).length; i++) {
            canvas.drawRect(alphabet.getNumPixel(12, 0, b)[i].getRect(), paint);
        }
    }
}
