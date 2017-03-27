package com.myGame.thunder;


public class Enemy3 extends Enemy {
    int count = 0;

    public Enemy3(int x, int y) {
        super(x, y);
        // TODO Auto-generated constructor stub
        refreshPixels();
    }

    public void shoot() {
        MainActivity.enemy_bullets.add(new Bullet(x, y, 3));
    }

    @Override
    public void next() {
        // TODO Auto-generated method stub
        if (MainActivity.myplane.x < x) move(7);
        else if (MainActivity.myplane.x > x) move(6);
        else if (MainActivity.myplane.x == x) move(3);
        if (count == 3) {
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
