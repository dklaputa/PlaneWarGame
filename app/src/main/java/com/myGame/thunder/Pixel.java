package com.myGame.thunder;

import android.graphics.RectF;


public class Pixel {
    int x;
    int y;
    static int size;
    static int d;
    static RectF[][] rectTable = new RectF[25][25];

    public Pixel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void setSize(float alpha) {
        size = (int) (10 * alpha);
        d = Math.max((int) alpha, 1);

        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                int posX = (size + d) * i;
                int posY = (size + d) * j;
                rectTable[i][j] = new RectF(posX, posY, posX + size, posY + size);
            }
        }
    }

    public static int getSize() {
        return size;
    }

    public static int getDistance() {
        return d;
    }

    public boolean isOutOfFrame() {
        if (x < 0 || x > 24 || y < 0 || y > 24) return true;
        else return false;
    }

    public RectF getRect() {

        return rectTable[x][y];
    }

    public void xInc() {
        x++;
    }

    public void xDec() {
        x--;
    }

    public void yInc() {
        y++;
    }

    public void yDec() {
        y--;
    }
}
