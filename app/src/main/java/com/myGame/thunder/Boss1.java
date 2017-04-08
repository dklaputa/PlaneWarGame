package com.myGame.thunder;


public class Boss1 extends Boss {

    public Boss1(int x, int y) {
        super(x, y);
        dead = false;
        guns = new Pixel[2][];
        plane = new Pixel[2][];
        refreshPixels();
        statusNumMax = 1;
        life = new int[]{40, 40};
        totalLife = new int[]{40, 40};
        ImmuneTime = 10;
        status = 0;
    }

    @Override
    public void next() {
        // TODO Auto-generated method stub
        if (ImmuneTime > 0) {
            ImmuneTime--;
            move(Orientation.DOWN);
        } else if (status == 1) {
            if (x > 8 && x != 17 && y != 17) move(Orientation.LEFT);
            else if (x == 8 && y != 17) move(Orientation.DOWN);
            else if (x != 17 && y == 17) move(Orientation.RIGHT);
            else if (x == 17 && y != 8) move(Orientation.UP);
            else if (x == 17) move(Orientation.LEFT);
            if (count > 3) shoot();
            if (count > 15) count = 0;
            else count++;
        } else {
            if (count < 16) shoot();
            if (count > 20) count = 0;
            else count++;
        }
    }

    @Override
    public void shoot() {
        // TODO Auto-generated method stub
        if (status == 0) {
            for (int i = 0; i < guns[status].length; i++) {
                MainActivity.enemy_bullets.add(new Bullet(guns[status][i].x, guns[status][i].y,
                        Bullet.TYPE_AIM_ENEMY));
            }
        }
        if (status == 1) {
            for (int i = 0; i < guns[status].length; i++) {
                MainActivity.enemy_bullets.add(new Bullet(guns[status][i].x, guns[status][i].y, 0));
                MainActivity.enemy_bullets.add(new Bullet(guns[status][i].x, guns[status][i].y, 1));
                MainActivity.enemy_bullets.add(new Bullet(guns[status][i].x, guns[status][i].y, 2));
                MainActivity.enemy_bullets.add(new Bullet(guns[status][i].x, guns[status][i].y, 3));
                MainActivity.enemy_bullets.add(new Bullet(guns[status][i].x, guns[status][i].y, 4));
                MainActivity.enemy_bullets.add(new Bullet(guns[status][i].x, guns[status][i].y, 5));
                MainActivity.enemy_bullets.add(new Bullet(guns[status][i].x, guns[status][i].y, 6));
                MainActivity.enemy_bullets.add(new Bullet(guns[status][i].x, guns[status][i].y, 7));
            }
        }
    }

    @Override
    public void refreshPixels() {
        // TODO Auto-generated method stub
        guns[0] = new Pixel[]{new Pixel(x - 2, y - 2), new Pixel(x - 2, y + 2), new Pixel(x + 2,
                y - 2), new Pixel(x
                + 2, y + 2)};
        guns[1] = new Pixel[]{new Pixel(x, y)};
        plane[0] = new Pixel[]{new Pixel(x - 2, y - 2), new Pixel(x - 2, y + 2), new Pixel(x + 2,
                y - 2), new Pixel(x + 2, y + 2),
                new Pixel(x - 1, y - 3), new Pixel(x - 1, y + 3), new Pixel(x, y - 3), new Pixel
                (x, y + 3), new Pixel(x + 1, y - 3),
                new Pixel(x + 1, y + 3), new Pixel(x + 3, y - 1), new Pixel(x + 3, y + 1), new
                Pixel(x - 3, y - 1), new Pixel(x - 3, y + 1),
                new Pixel(x, y - 1), new Pixel(x, y + 1), new Pixel(x - 3, y), new Pixel(x + 3,
                y), new Pixel(x - 1, y),
                new Pixel(x + 1, y), new Pixel(x, y)};
        plane[1] = new Pixel[]{new Pixel(x, y - 1), new Pixel(x, y + 1), new Pixel(x - 1, y), new
                Pixel(x + 1, y), new Pixel(x, y)};
    }

}
