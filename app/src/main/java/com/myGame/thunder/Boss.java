package com.myGame.thunder;

import java.util.ArrayList;

import static com.myGame.thunder.Orientation.*;

public abstract class Boss {
    int x;
    int y;
    Pixel[][] guns;
    Pixel[][] plane;
    int[] life;
    int[] totalLife;
    int count;
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

    public void getHurt() {
        if (ImmuneTime == 0) {
            life[status]--;
        }
        if (life[status] <= 0 && status < statusNumMax) {
            status++;
            count = 0;
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
                if ((bullets.get(j).x == plane[status][i].x) && (bullets.get(j).y ==
                        plane[status][i].y)) {
                    return j;
                }
            }
        }
        return -1;
    }


}
