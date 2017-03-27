package com.myGame.thunder;


public abstract class Enemy extends Plane {
    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int orientation) {
        switch (orientation) {
            case 0:
                x--;
                refreshPixels();
                break;
            case 1:
                x++;
                refreshPixels();
                break;
            case 2:
                y--;
                refreshPixels();
                break;
            case 3:
                y++;
                refreshPixels();
                break;
            case 4:
                x--;
                y--;
                refreshPixels();
                break;
            case 5:
                x++;
                y--;
                refreshPixels();
                break;
            case 6:
                x++;
                y++;
                refreshPixels();
                break;
            case 7:
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
