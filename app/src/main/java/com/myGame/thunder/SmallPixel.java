package com.myGame.thunder;

import android.graphics.RectF;

public class SmallPixel {
    int x;
    int y;
    static int size;
    static int d;
    static RectF[][] rectTable = new RectF[15][5];

    public SmallPixel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void setSize(float alpha) {
        size = (int) (2 * alpha);
        d = Math.max((int) alpha, 1);
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                int posX = (size + d) * i;
                int posY = (size + d) * j;
                rectTable[i][j] = new RectF(posX, posY, posX + size, posY + size);
            }
        }
    }

    public RectF getRect() {
        return rectTable[x][y];
    }
}
