package com.myGame.thunder;


public class Enemy1 extends Enemy {
    int count = 0;

    public Enemy1(int x, int y) {
        super(x, y);
        // TODO Auto-generated constructor stub
        refreshPixels();
    }

    public void shoot() {
        MainActivity.enemy_bullets.add(new Bullet(x, y, Bullet.TYPE_AIM_ENEMY));
    }

    @Override
    public void next() {
        // TODO Auto-generated method stub
        move(Orientation.DOWN);
        if (count == 2) {
            shoot();
            count = 0;
        } else count++;
    }

    @Override
    public void refreshPixels() {
        // TODO Auto-generated method stub
        plane = new Pixel[]{new Pixel(x - 1, y - 1), new Pixel(x, y - 1), new Pixel(x + 1, y - 1), new Pixel(x, y)};
    }

}
