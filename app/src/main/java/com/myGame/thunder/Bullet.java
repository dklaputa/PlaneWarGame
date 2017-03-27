package com.myGame.thunder;


public class Bullet extends Pixel {
    int type;
    int count = 0;
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
            case 0://left
            case 1://right
            case 2://up
            case 3://down
            case 4://upleft
            case 5://upright
            case 6://downleft
            case 7://downright
                move(type);
                break;
            case 8:
                if (count < 7) {
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
            case 9:
                //	if (count<21) {
                if (MainActivity.enemy.size() > 0) {
                    if (MainActivity.enemy.get(0).x != x) {
                        xInc = (int) Math.signum(MainActivity.enemy.get(0).x - x);
                        yInc = (int) Math.signum(MainActivity.enemy.get(0).y - y);
                        b = (float) (MainActivity.enemy.get(0).y - y) / (MainActivity.enemy.get(0).x - x);
                    } else if (MainActivity.enemy.get(0).y > y) {
                        b = 999;
                        xInc = 0;
                        yInc = 1;
                    } else {
                        b = 999;
                        xInc = 0;
                        yInc = -1;
                    }
                } else if (MainActivity.boss.size() > 0) {
                    if (MainActivity.boss.get(0).x != x) {
                        xInc = (int) Math.signum(MainActivity.boss.get(0).x - x);
                        yInc = (int) Math.signum(MainActivity.boss.get(0).y - y);
                        b = (float) (MainActivity.boss.get(0).y - y) / (MainActivity.boss.get(0).x - x);
                    } else if (MainActivity.boss.get(0).y > y) {
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
            case 10:
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
                    //		System.out.println(b+" "+xInc+" "+yInc);
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
            case 0://left
                x--;
                break;
            case 1://right
                x++;
                break;
            case 2://up
                y--;
                break;
            case 3://down
                y++;
                break;
            case 4://upleft
                x--;
                y--;
                break;
            case 5://upright
                x++;
                y--;
                break;
            case 6://downright
                x++;
                y++;
                break;
            case 7://downleft
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
