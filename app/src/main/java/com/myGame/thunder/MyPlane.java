package com.myGame.thunder;

import java.util.ArrayList;


public class MyPlane extends Plane {
    boolean superSkill1;
    boolean superSkill2;
    int count = 0;
    int status = 0;
    Pixel plane[][];

    public MyPlane() {
        x = 12;
        y = 22;
        plane = new Pixel[2][0];
        refreshPixels();
    }

    public void shoot() {
        if (superSkill1) {
            status = 1;
    /*		MainActivity.bullets.add(new Bullet(x,y,4));
			MainActivity.bullets.add(new Bullet(x,y,5));
			MainActivity.bullets.add(new Bullet(x,y,0));
			MainActivity.bullets.add(new Bullet(x,y,1));*/
            MainActivity.bullets.add(new Bullet(x, y, 2));
            if (count % 4 == 0) MainActivity.bullets.add(new Bullet(x + 4, y + 1, Bullet.TYPE_MISSILE_PLAYER));
            if (count % 4 == 2) MainActivity.bullets.add(new Bullet(x - 4, y + 1, Bullet.TYPE_MISSILE_PLAYER));
            if (count == 100) {
                superSkill1 = false;
                status = 0;
                count = 0;
            } else count++;
        } else if (superSkill2) {
            status = 1;
            MainActivity.bullets.add(new Bullet(x + 4, y + 1, Orientation.LEFTUP));
            MainActivity.bullets.add(new Bullet(x + 4, y + 1, Orientation.RIGHTUP));
            MainActivity.bullets.add(new Bullet(x + 4, y + 1, Orientation.RIGHT));
            MainActivity.bullets.add(new Bullet(x + 4, y + 1, Orientation.UP));
            MainActivity.bullets.add(new Bullet(x - 4, y + 1, Orientation.LEFTUP));
            MainActivity.bullets.add(new Bullet(x - 4, y + 1, Orientation.RIGHTUP));
            MainActivity.bullets.add(new Bullet(x - 4, y + 1, Orientation.LEFT));
            MainActivity.bullets.add(new Bullet(x - 4, y + 1, Orientation.UP));
            MainActivity.bullets.add(new Bullet(x, y, Orientation.UP));
            if (count == 100) {
                superSkill2 = false;
                status = 0;
                count = 0;
            } else count++;
        } else MainActivity.bullets.add(new Bullet(x, y, Orientation.UP));
    }

    public void superSkill1() {
        if (!superSkill1 && !superSkill2 && MainActivity.score >= 100) {
            superSkill1 = true;
            MainActivity.score -= 100;
        }
    }

    public void superSkill2() {
        if (!superSkill1 && !superSkill2 && MainActivity.score >= 100) {
            superSkill2 = true;
            MainActivity.score -= 100;
        }
    }

    @Override
    public void refreshPixels() {
        // TODO Auto-generated method stub
        plane[0] = new Pixel[]{new Pixel(x - 1, y + 1), new Pixel(x, y + 1), new Pixel(x + 1, y + 1), new Pixel(x, y)};//һ��̬
        plane[1] = new Pixel[]{new Pixel(x - 1, y + 1), new Pixel(x, y + 1), new Pixel(x + 1, y + 1), new Pixel(x, y), new Pixel(x - 4, y + 1), new Pixel(x + 4, y + 1)};//����̬ ��������
    }

    public Pixel[] getPixel() {
        return plane[status];
    }

    public int isShot(ArrayList<Bullet> bullets) {
        for (int i = 0; i < plane[0].length; i++) {
            for (int j = 0; j < bullets.size(); j++) {
                if ((bullets.get(j).x == plane[0][i].x) && (bullets.get(j).y == plane[0][i].y)) {
                    return j;
                }
            }
        }
        return -1;
    }
}
