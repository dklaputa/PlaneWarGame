package com.myGame.thunder;

import java.util.ArrayList;


public abstract class Plane {
    int x;
    int y;
    int orientation;
    Pixel[] plane;

    public abstract void refreshPixels();

    public void move(int orientation) {
        switch (orientation) {
            case 0:
                if (x > 1) {
                    x--;
                    refreshPixels();
                }
                break;
            case 1:
                if (x < 23) {
                    x++;
                    refreshPixels();
                }
                break;
            case 2:
                if (y > 0) {
                    y--;
                    refreshPixels();
                }
                break;
            case 3:
                if (y < 23) {
                    y++;
                    refreshPixels();
                }
                break;
            case 4:
                if (x > 1 && y > 0) {
                    x--;
                    y--;
                    refreshPixels();
                } else if (x > 1) {
                    x--;
                    refreshPixels();
                } else if (y > 0) {
                    y--;
                    refreshPixels();
                }
                break;
            case 5:
                if (x < 23 && y > 0) {
                    x++;
                    y--;
                    refreshPixels();
                } else if (x < 23) {
                    x++;
                    refreshPixels();
                } else if (y > 0) {
                    y--;
                    refreshPixels();
                }
                break;
            case 6:
                if (x < 23 && y < 23) {
                    x++;
                    y++;
                    refreshPixels();
                } else if (x < 23) {
                    x++;
                    refreshPixels();
                } else if (y < 23) {
                    y++;
                    refreshPixels();
                }
                break;
            case 7:
                if (x > 1 && y < 23) {
                    x--;
                    y++;
                    refreshPixels();
                } else if (x > 1) {
                    x--;
                    refreshPixels();
                } else if (y < 23) {
                    y++;
                    refreshPixels();
                }
                break;
        }
    }

    public Pixel[] getPixel() {//�������򷵻��Լ���״���������꣩
        return plane;
    }

    public int isShot(ArrayList<Bullet> bullets) {
        for (int i = 0; i < plane.length; i++) {
            for (int j = 0; j < bullets.size(); j++) {

                if ((bullets.get(j).x == plane[i].x) && (bullets.get(j).y == plane[i].y)) {
                    //		System.out.println(bullets.get(j).x+" "+plane[i].x);
                    return j;
                }
            }

        }
        return -1;
    }

    abstract public void shoot();
}
