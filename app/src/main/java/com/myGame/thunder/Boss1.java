package com.myGame.thunder;


public class Boss1 extends Boss {
    int count;

    public Boss1(int x, int y) {
        super(x, y);
        dead = false;
        guns = new Pixel[2][];
        plane = new Pixel[2][];
        refreshPixels();
        statusNumMax = 1;
        life = new int[]{20, 20};
        totalLife = new int[]{20, 20};
        ImmuneTime = 10;
        status = 0;
    }

    @Override
    public void next() {
        // TODO Auto-generated method stub
        if (ImmuneTime > 0) {
            ImmuneTime--;
        }
        if (count < 10) {
            move(3);
        } else if (status == 1) {
            if (x > 8 && x != 17 && y != 17) move(0);
            else if (x == 8 && y != 17) move(3);
            else if (x != 17 && y == 17) move(1);
            else if (x == 17 && y != 8) move(2);
            else if (x == 17 && y == 8) move(0);
            if (count % 12 > 2) shoot();
        } else if ((count - 10) % 20 < 12) {
            shoot();
        }
        count++;
    }

    @Override
    public void shoot() {
        // TODO Auto-generated method stub
        if (status == 0) {
            for (int i = 0; i < guns[status].length; i++) {
                MainActivity.enemy_bullets.add(new Bullet(guns[status][i].x, guns[status][i].y, 10));//�Զ���׼�ӵ�
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
        guns[0] = new Pixel[]{new Pixel(x - 2, y - 2), new Pixel(x - 2, y + 2), new Pixel(x + 2, y - 2), new Pixel(x
                + 2, y + 2)};
        guns[1] = new Pixel[]{new Pixel(x, y)};
        plane[0] = new Pixel[]{new Pixel(x - 2, y - 2), new Pixel(x - 2, y + 2), new Pixel(x + 2, y - 2), new Pixel(x + 2, y + 2),
                new Pixel(x - 1, y - 3), new Pixel(x - 1, y + 3), new Pixel(x, y - 3), new Pixel(x, y + 3), new Pixel(x + 1, y - 3),
                new Pixel(x + 1, y + 3), new Pixel(x + 3, y - 1), new Pixel(x + 3, y + 1), new Pixel(x - 3, y - 1), new Pixel(x - 3, y + 1),
                new Pixel(x, y - 1), new Pixel(x, y + 1), new Pixel(x - 3, y), new Pixel(x + 3, y), new Pixel(x - 1, y),
                new Pixel(x + 1, y), new Pixel(x, y)};
        plane[1] = new Pixel[]{new Pixel(x, y - 1), new Pixel(x, y + 1), new Pixel(x - 1, y), new Pixel(x + 1, y), new Pixel(x, y)};
    }

}
