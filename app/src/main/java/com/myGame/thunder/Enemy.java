package com.myGame.thunder;


import static com.myGame.thunder.Orientation.*;

public abstract class Enemy extends Plane {
    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int orientation) {
        switch (orientation) {
            case LEFT:
                x--;
                refreshPixels();
                break;
            case RIGHT:
                x++;
                refreshPixels();
                break;
            case UP:
                y--;
                refreshPixels();
                break;
            case DOWN:
                y++;
                refreshPixels();
                break;
            case LEFTUP:
                x--;
                y--;
                refreshPixels();
                break;
            case RIGHTUP:
                x++;
                y--;
                refreshPixels();
                break;
            case RIGHTDOWN:
                x++;
                y++;
                refreshPixels();
                break;
            case LEFTDOWN:
                x--;
                y++;
                refreshPixels();
                break;
        }
    }

    public abstract void next();

    public boolean isAlive() {
        if (x < 1 || x > 23 || y < -1 || y > 25) return false;
        else return true;
    }
}
