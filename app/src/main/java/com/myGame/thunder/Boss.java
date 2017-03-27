package com.myGame.thunder;

import java.util.ArrayList;

public abstract class Boss {
    int x;
    int y;
    Pixel[][] guns;
    Pixel[][] plane;
    int[] life;
    int[] totalLife;
    int ImmuneTime;
    int statusNumMax;
    int status = 0;
    boolean dead;

    public Boss(int x, int y) {
        this.x = x;
        this.y = y;
        // TODO Auto-generated constructor stub
    }

    public Pixel[] getPixel() {
        return plane[status];
    }

    public abstract void refreshPixels();

    public abstract void next();

    public abstract void shoot();

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

    public void getHurt() {
        if (ImmuneTime == 0) {
            life[status]--;
        }
        if (life[status] <= 0 && status < statusNumMax) {
            status++;
            MainActivity.score += 50;
        } else if (life[status] <= 0 && status == statusNumMax) {
            dead = true;
            MainActivity.score += 100;
            MainActivity.round++;
        }
    }

    public int isShot(ArrayList<Bullet> bullets) {
        for (int i = 0; i < plane[status].length; i++) {
            for (int j = 0; j < bullets.size(); j++) {
                if ((bullets.get(j).x == plane[status][i].x) && (bullets.get(j).y == plane[status][i].y)) {
                    return j;
                }
            }
        }
        return -1;
    }


}
