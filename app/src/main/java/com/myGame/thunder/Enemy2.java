package com.myGame.thunder;

import java.util.ArrayList;


public class Enemy2 extends Enemy {
    int count = 0;
    int status = 0;
    Pixel[][] plane;

    public Enemy2(int x, int y) {
        super(x, y);
        // TODO Auto-generated constructor stub
        plane = new Pixel[2][];
        refreshPixels();
    }

    public void shoot() {
        MainActivity.enemy_bullets.add(new Bullet(x, y, Bullet.TYPE_LEFT));
        MainActivity.enemy_bullets.add(new Bullet(x, y, Bullet.TYPE_RIGHT));
        MainActivity.enemy_bullets.add(new Bullet(x, y, Bullet.TYPE_UP));
        MainActivity.enemy_bullets.add(new Bullet(x, y, Bullet.TYPE_DOWN));
        MainActivity.enemy_bullets.add(new Bullet(x, y, Bullet.TYPE_LEFTUP));
        MainActivity.enemy_bullets.add(new Bullet(x, y, Bullet.TYPE_RIGHTUP));
        MainActivity.enemy_bullets.add(new Bullet(x, y, Bullet.TYPE_RIGHTDOWN));
        MainActivity.enemy_bullets.add(new Bullet(x, y, Bullet.TYPE_LEFTDOWN));
    }

    @Override
    public void next() {
        // TODO Auto-generated method stub
        if (count < 10) {
            move(Orientation.DOWN);
            if (count == 5) shoot();
        } else if (count == 10) {
            shoot();
            status = 1;
        } else {
            move(Orientation.UP);
        }
        count++;
    }

    public boolean isAlive() {
        if (x < 1 || x > 23 || y < -1 || y > 24) return false;
        else return true;
    }

    @Override
    public void refreshPixels() {
        // TODO Auto-generated method stub
        plane[0] = new Pixel[]{new Pixel(x - 1, y - 1), new Pixel(x, y - 1), new Pixel(x + 1, y -
                1), new Pixel(x, y)};
        plane[1] = new Pixel[]{new Pixel(x - 1, y + 1), new Pixel(x, y + 1), new Pixel(x + 1, y +
                1), new Pixel(x, y)};
    }

    public Pixel[] getPixel() {//��дgetPixel����
        return plane[status];
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
