package com.myGame.thunder;

import java.util.ArrayList;

import static com.myGame.thunder.Orientation.*;


public abstract class Plane {
    int x;
    int y;
    int orientation;
    Pixel[] plane;

    public abstract void refreshPixels();

    public void move(int orientation) {
        switch (orientation) {
            case LEFT:
                if (x > 1) {
                    x--;
                    refreshPixels();
                }
                break;
            case RIGHT:
                if (x < 23) {
                    x++;
                    refreshPixels();
                }
                break;
            case UP:
                if (y > 0) {
                    y--;
                    refreshPixels();
                }
                break;
            case DOWN:
                if (y < 23) {
                    y++;
                    refreshPixels();
                }
                break;
            case LEFTUP:
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
            case RIGHTUP:
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
            case RIGHTDOWN:
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
            case LEFTDOWN:
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
