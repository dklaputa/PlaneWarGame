package com.myGame.thunder;


public class Alphabet {
    public Pixel[] A() {
        return new Pixel[]{
                new Pixel(2, 0), new Pixel(1, 1), new Pixel(3, 1), new Pixel(0, 2),
                new Pixel(4, 2), new Pixel(0, 3), new Pixel(4, 3), new Pixel(0, 4),
                new Pixel(1, 4), new Pixel(2, 4), new Pixel(3, 4), new Pixel(4, 4),
                new Pixel(0, 5), new Pixel(4, 5), new Pixel(0, 6), new Pixel(4, 6)
        };
    }

    public Pixel[] E() {
        return new Pixel[]{
                new Pixel(0, 0), new Pixel(1, 0), new Pixel(2, 0), new Pixel(3, 0),
                new Pixel(4, 0), new Pixel(0, 1), new Pixel(0, 2), new Pixel(0, 3),
                new Pixel(1, 3), new Pixel(2, 3), new Pixel(3, 3), new Pixel(4, 3),
                new Pixel(0, 4), new Pixel(0, 5), new Pixel(0, 6), new Pixel(1, 6),
                new Pixel(2, 6), new Pixel(3, 6), new Pixel(4, 6)
        };
    }

    public Pixel[] G() {
        return new Pixel[]{
                new Pixel(1, 0), new Pixel(2, 0), new Pixel(3, 0), new Pixel(4, 0),
                new Pixel(0, 1), new Pixel(0, 2), new Pixel(0, 3), new Pixel(2, 3),
                new Pixel(3, 3), new Pixel(4, 3), new Pixel(0, 4), new Pixel(4, 4),
                new Pixel(0, 5), new Pixel(4, 5), new Pixel(1, 6), new Pixel(2, 6),
                new Pixel(3, 6), new Pixel(4, 6)
        };
    }

    public Pixel[] M() {
        return new Pixel[]{
                new Pixel(0, 0), new Pixel(4, 0), new Pixel(0, 1), new Pixel(1, 1),
                new Pixel(3, 1), new Pixel(4, 1), new Pixel(0, 2), new Pixel(2, 2),
                new Pixel(4, 2), new Pixel(0, 3), new Pixel(2, 3), new Pixel(4, 3),
                new Pixel(0, 4), new Pixel(4, 4), new Pixel(0, 5), new Pixel(4, 5),
                new Pixel(0, 6), new Pixel(4, 6)
        };
    }

    public Pixel[] O() {
        return new Pixel[]{
                new Pixel(1, 0), new Pixel(2, 0), new Pixel(3, 0), new Pixel(0, 1),
                new Pixel(4, 1), new Pixel(0, 2), new Pixel(4, 2), new Pixel(0, 3),
                new Pixel(4, 3), new Pixel(0, 4), new Pixel(4, 4), new Pixel(0, 5),
                new Pixel(4, 5), new Pixel(1, 6), new Pixel(2, 6), new Pixel(3, 6)
        };
    }

    public Pixel[] R() {
        return new Pixel[]{
                new Pixel(0, 0), new Pixel(1, 0), new Pixel(2, 0), new Pixel(3, 0),
                new Pixel(4, 1), new Pixel(0, 1), new Pixel(0, 2), new Pixel(0, 3),
                new Pixel(1, 3), new Pixel(2, 3), new Pixel(3, 3), new Pixel(4, 2),
                new Pixel(0, 4), new Pixel(0, 5), new Pixel(0, 6), new Pixel(2, 4),
                new Pixel(3, 5), new Pixel(4, 6)
        };
    }

    public Pixel[] V() {
        return new Pixel[]{
                new Pixel(0, 0), new Pixel(4, 0), new Pixel(0, 1), new Pixel(4, 1),
                new Pixel(0, 2), new Pixel(4, 2), new Pixel(0, 3), new Pixel(4, 3),
                new Pixel(0, 4), new Pixel(4, 4), new Pixel(1, 5), new Pixel(3, 5),
                new Pixel(2, 6)
        };
    }

    public Pixel[] exclamation() {
        return new Pixel[]{
                new Pixel(1, 0), new Pixel(1, 1), new Pixel(1, 2), new Pixel(1, 3),
                new Pixel(1, 4), new Pixel(1, 6)
        };
    }

    public SmallPixel[] Num0(int x, int y) {
        return new SmallPixel[]{
                new SmallPixel(0 + x, 0 + y), new SmallPixel(1 + x, 0 + y), new SmallPixel(2 + x, 0 + y), new
                SmallPixel(0 + x, 1 + y),
                new SmallPixel(2 + x, 1 + y), new SmallPixel(0 + x, 2 + y), new SmallPixel(2 + x, 2 + y), new
                SmallPixel(0 + x, 3 + y),
                new SmallPixel(2 + x, 3 + y), new SmallPixel(0 + x, 4 + y), new SmallPixel(1 + x, 4 + y), new
                SmallPixel(2 + x, 4 + y)
        };
    }

    public SmallPixel[] Num1(int x, int y) {
        return new SmallPixel[]{
        /*	new SmallPixel(1+x,0+y),new SmallPixel(0+x,1+y),new SmallPixel(1+x,1+y),new SmallPixel(1+x,2+y),
			new SmallPixel(1+x,3+y),new SmallPixel(0+x,4+y),new SmallPixel(1+x,4+y),new SmallPixel(2+x,4+y)*/
                new SmallPixel(1 + x, 0 + y), new SmallPixel(1 + x, 1 + y), new SmallPixel(1 + x, 2 + y), new
                SmallPixel(1 + x, 3 + y),
                new SmallPixel(1 + x, 4 + y)
        };
    }

    public SmallPixel[] Num2(int x, int y) {
        return new SmallPixel[]{
                new SmallPixel(0 + x, 0 + y), new SmallPixel(1 + x, 0 + y), new SmallPixel(2 + x, 0 + y), new
                SmallPixel(1 + x, 2 + y),
                new SmallPixel(2 + x, 1 + y), new SmallPixel(0 + x, 2 + y), new SmallPixel(2 + x, 2 + y), new
                SmallPixel(0 + x, 3 + y),
                new SmallPixel(0 + x, 4 + y), new SmallPixel(1 + x, 4 + y), new SmallPixel(2 + x, 4 + y)
        };
    }

    public SmallPixel[] Num3(int x, int y) {
        return new SmallPixel[]{
                new SmallPixel(0 + x, 0 + y), new SmallPixel(1 + x, 0 + y), new SmallPixel(2 + x, 0 + y), new
                SmallPixel(1 + x, 2 + y),
                new SmallPixel(2 + x, 1 + y), new SmallPixel(0 + x, 2 + y), new SmallPixel(2 + x, 2 + y), new
                SmallPixel(2 + x, 3 + y),
                new SmallPixel(0 + x, 4 + y), new SmallPixel(1 + x, 4 + y), new SmallPixel(2 + x, 4 + y)
        };
    }

    public SmallPixel[] Num4(int x, int y) {
        return new SmallPixel[]{
                new SmallPixel(0 + x, 0 + y), new SmallPixel(1 + x, 2 + y), new SmallPixel(2 + x, 0 + y), new
                SmallPixel(0 + x, 1 + y),
                new SmallPixel(2 + x, 1 + y), new SmallPixel(0 + x, 2 + y), new SmallPixel(2 + x, 2 + y), new
                SmallPixel(2 + x, 3 + y),
                new SmallPixel(2 + x, 4 + y)
        };
    }

    public SmallPixel[] Num5(int x, int y) {
        return new SmallPixel[]{
                new SmallPixel(0 + x, 0 + y), new SmallPixel(1 + x, 0 + y), new SmallPixel(2 + x, 0 + y), new
                SmallPixel(1 + x, 2 + y),
                new SmallPixel(0 + x, 1 + y), new SmallPixel(0 + x, 2 + y), new SmallPixel(2 + x, 2 + y), new
                SmallPixel(2 + x, 3 + y),
                new SmallPixel(0 + x, 4 + y), new SmallPixel(1 + x, 4 + y), new SmallPixel(2 + x, 4 + y)
        };
    }

    public SmallPixel[] Num6(int x, int y) {
        return new SmallPixel[]{
                new SmallPixel(0 + x, 0 + y), new SmallPixel(1 + x, 0 + y), new SmallPixel(2 + x, 0 + y), new
                SmallPixel(1 + x, 2 + y),
                new SmallPixel(0 + x, 1 + y), new SmallPixel(0 + x, 2 + y), new SmallPixel(2 + x, 2 + y), new
                SmallPixel(2 + x, 3 + y),
                new SmallPixel(0 + x, 4 + y), new SmallPixel(1 + x, 4 + y), new SmallPixel(2 + x, 4 + y), new
                SmallPixel(0 + x, 3 + y)
        };
    }

    public SmallPixel[] Num7(int x, int y) {
        return new SmallPixel[]{
                new SmallPixel(0 + x, 0 + y), new SmallPixel(1 + x, 0 + y), new SmallPixel(2 + x, 0 + y), new
                SmallPixel(2 + x, 1 + y),
                new SmallPixel(2 + x, 2 + y), new SmallPixel(2 + x, 3 + y), new SmallPixel(2 + x, 4 + y)
        };
    }

    public SmallPixel[] Num8(int x, int y) {
        return new SmallPixel[]{
                new SmallPixel(0 + x, 0 + y), new SmallPixel(1 + x, 0 + y), new SmallPixel(2 + x, 0 + y), new
                SmallPixel(0 + x, 1 + y),
                new SmallPixel(2 + x, 1 + y), new SmallPixel(0 + x, 2 + y), new SmallPixel(2 + x, 2 + y), new
                SmallPixel(0 + x, 3 + y),
                new SmallPixel(2 + x, 3 + y), new SmallPixel(0 + x, 4 + y), new SmallPixel(1 + x, 4 + y), new
                SmallPixel(2 + x, 4 + y),
                new SmallPixel(1 + x, 2 + y)
        };
    }

    public SmallPixel[] Num9(int x, int y) {
        return new SmallPixel[]{
                new SmallPixel(0 + x, 0 + y), new SmallPixel(1 + x, 0 + y), new SmallPixel(2 + x, 0 + y), new
                SmallPixel(0 + x, 1 + y),
                new SmallPixel(2 + x, 1 + y), new SmallPixel(0 + x, 2 + y), new SmallPixel(2 + x, 2 + y), new
                SmallPixel(2 + x, 3 + y),
                new SmallPixel(0 + x, 4 + y), new SmallPixel(1 + x, 4 + y), new SmallPixel(2 + x, 4 + y), new
                SmallPixel(1 + x, 2 + y)
        };
    }

    public SmallPixel[] getNumPixel(int x, int y, int i) {
        switch (i) {
            case 0:
                return Num0(x, y);
            case 1:
                return Num1(x, y);
            case 2:
                return Num2(x, y);
            case 3:
                return Num3(x, y);
            case 4:
                return Num4(x, y);
            case 5:
                return Num5(x, y);
            case 6:
                return Num6(x, y);
            case 7:
                return Num7(x, y);
            case 8:
                return Num8(x, y);
            case 9:
                return Num9(x, y);
            default:
                return null;
        }
    }
}
