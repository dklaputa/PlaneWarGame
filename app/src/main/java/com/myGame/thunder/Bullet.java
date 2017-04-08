package com.myGame.thunder;


import static com.myGame.thunder.Orientation.*;

public class Bullet extends Pixel {
    static final int TYPE_LEFT = 0;
    static final int TYPE_RIGHT = 1;
    static final int TYPE_UP = 2;
    static final int TYPE_DOWN = 3;
    static final int TYPE_LEFTUP = 4;
    static final int TYPE_RIGHTUP = 5;
    static final int TYPE_RIGHTDOWN = 6;
    static final int TYPE_LEFTDOWN = 7;
    static final int TYPE_MISSILE_BOSS = 8;
    static final int TYPE_MISSILE_PLAYER = 9;
    static final int TYPE_AIM_ENEMY = 10;

    int type;
    int count = 0;
    int speedCon = 0;
    //	boolean fixed=false;
    float b = 999;
    int xInc = 0;
    int yInc = -1;
    int last = 0;

    public Bullet(int x, int y, int type) {
        super(x, y);
        this.type = type;
        // TODO Auto-generated constructor stub
    }

    public void next() {
        switch (type) {
            case TYPE_LEFT://left
            case TYPE_RIGHT://right
            case TYPE_UP://up
            case TYPE_DOWN://down
            case TYPE_LEFTUP://upleft
            case TYPE_RIGHTUP://upright
            case TYPE_RIGHTDOWN://downleft
            case TYPE_LEFTDOWN://downright
                move(type);
                break;
            case TYPE_MISSILE_PLAYER:
                if (count < 6 && (speedCon = (speedCon + 1) % 5) != 1) {
                    break;
                }
                if (MainActivity.enemy.size() > 0) {
                    if (MainActivity.enemy.get(0).x != x) {
                        xInc = (int) Math.signum(MainActivity.enemy.get(0).x - x);
                        yInc = (int) Math.signum(MainActivity.enemy.get(0).y - y);
                        b = (float) (MainActivity.enemy.get(0).y - y) / (MainActivity.enemy.get
                                (0).x - x);
                    } else if (MainActivity.enemy.get(0).y > y) {
                        b = 999;
                        xInc = 0;
                        yInc = 1;
                    } else {
                        b = 999;
                        xInc = 0;
                        yInc = -1;
                    }
                } else if (MainActivity.boss!=null) {
                    if (MainActivity.boss.x != x) {
                        xInc = (int) Math.signum(MainActivity.boss.x - x);
                        yInc = (int) Math.signum(MainActivity.boss.y - y);
                        b = (float) (MainActivity.boss.y - y) / (MainActivity.boss
                                .x - x);
                    } else if (MainActivity.boss.y > y) {
                        b = 999;
                        xInc = 0;
                        yInc = 1;
                    } else {
                        b = 999;
                        xInc = 0;
                        yInc = -1;
                    }
                }

                //	}
                if (Math.abs(b) > 1) {
                    if ((int) (count / b) != last) {
                        last = (int) (count / b);
                        x += xInc;
                    }
                    y += yInc;
                } else {
                    if ((int) (b * count) != last) {
                        last = (int) (b / count);
                        y += yInc;
                    }
                    x += xInc;
                }
                count++;
                break;
            case TYPE_AIM_ENEMY:
                if (count == 0) {
                    if (MainActivity.myplane.x != x) {
                        xInc = (int) Math.signum(MainActivity.myplane.x - x);
                        yInc = (int) Math.signum(MainActivity.myplane.y - y);
                        b = (float) (MainActivity.myplane.y - y) / (MainActivity.myplane.x - x);
                    } else if (MainActivity.myplane.y > y) {
                        b = 999;
                        xInc = 0;
                        yInc = 1;
                    } else {
                        b = 999;
                        xInc = 0;
                        yInc = -1;
                    }
                }
                if (Math.abs(b) > 1) {
                    if ((int) (count / b) != last) {
                        last = (int) (count / b);
                        x += xInc;
                    }
                    y += yInc;
                } else {
                    if ((int) (b * count) != last) {
                        last = (int) (b / count);
                        y += yInc;
                    }
                    x += xInc;
                }
                count++;
                break;
        }
    }

    public void move(int orientation) {
        switch (orientation) {
            case LEFT://left
                x--;
                break;
            case RIGHT://right
                x++;
                break;
            case UP://up
                y--;
                break;
            case DOWN://down
                y++;
                break;
            case LEFTUP://upleft
                x--;
                y--;
                break;
            case RIGHTUP://upright
                x++;
                y--;
                break;
            case RIGHTDOWN://downright
                x++;
                y++;
                break;
            case LEFTDOWN://downleft
                x--;
                y++;
                break;
        }
    }

    public boolean isAlive() {
        if (x < 0 || x > 24 || y < 0 || y > 24) return false;
        else return true;
    }
}
