package com.myGame.thunder;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

public class MainView extends View {
    Alphabet alphabet = new Alphabet();
    boolean ani = true;
    Paint paint = new Paint();
    int[] color = new int[]{Color.rgb(130, 80, 80), Color.DKGRAY};
    //	Bitmap filter=null;
    int size = Pixel.getSize() * 25 + Pixel.getDistance() * 24;

    //	int a;
    public MainView(Context context) {
        super(context);
/*		try {
            filter=Bitmap.createScaledBitmap(BitmapFactory.decodeStream(getAssets().open("Filter
            .png")), size, size,
			true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    }

    public MainView(Context context, AttributeSet a) {
        super(context, a);
    }

    public MainView(Context context, AttributeSet a, int b) {
        super(context, a, b);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //	canvas.drawColor(Color.rgb(249,240,177));
        paint.setColor(Color.DKGRAY);
        if (MainActivity.begin && ani) {
            drawGameBegin(paint, canvas);
            ani = false;
        } else if (MainActivity.begin && !ani) ani = true;
        else if (!MainActivity.gameover) {
            drawPlane(paint, canvas, MainActivity.myplane);
            drawBullet(paint, canvas, MainActivity.bullets);
            for (int m = 0; m < MainActivity.enemy.size(); m++) {
                drawPlane(paint, canvas, MainActivity.enemy.get(m));
            }
            if (MainActivity.boss != null) drawBoss(paint, canvas, MainActivity.boss);
            paint.setColor(Color.rgb(130, 80, 80));
            drawBullet(paint, canvas, MainActivity.enemy_bullets);
            paint.setColor(Color.DKGRAY);
        } else {
            drawGameOver(paint, canvas);
        }
        //-----------------------------------------
//		canvas.drawBitmap(filter, 0, 0, paint);

    }
/*	public boolean onTouchEvent(MotionEvent event){
        switch(event.getAction()){
		case MotionEvent.ACTION_MOVE:
	//		System.out.println("move");
			if(!paused){
				touchX=event.getX();
				touchY=event.getY();
				TouchEnable=true;
			}
			break;
		case MotionEvent.ACTION_UP:
	//		System.out.println("up");

			task.cancel();
			
			paused=true;
			TouchEnable=false;
			break;
		case MotionEvent.ACTION_DOWN:
	//		System.out.println("down");
			if(gameover){
				startGame();
			}
			else if(paused){
				int i=task.i;
				int j=task.j;
			//	timer=new Timer();
				task=new RefreshThread(i,j);
				timer.scheduleAtFixedRate(task, 0, 40);
				paused=false;
			}
			
			break;
		}
		return true;
		
	}*/

    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(size + 1, size + 1);
    }

    public void drawPlane(Paint paint, Canvas canvas, Plane plane) {
        for (int i = 0; i < plane.getPixel().length; i++) {
            if (!plane.getPixel()[i].isOutOfFrame()) {
                canvas.drawRect(plane.getPixel()[i].getRect(), paint);
            }
        }
    }

    public void drawBullet(Paint paint, Canvas canvas, ArrayList<Bullet> bullets) {
        for (int i = 0; i < bullets.size(); i++) {
            RectF rectF = bullets.get(i).getRect();
            if (rectF != null) canvas.drawRect(rectF, paint);
        }
    }

    public void drawBoss(Paint paint, Canvas canvas, Boss boss) {
        if (!boss.dead) {
            for (int i = 0; i < boss.getPixel().length; i++) {
                if (!boss.getPixel()[i].isOutOfFrame()) {
                    canvas.drawRect(boss.getPixel()[i].getRect(), paint);
                }
            }
            if (boss.ImmuneTime == 0) {
                for (int n = boss.statusNumMax; n >= 0; n--) {
                    paint.setColor(color[n % 2]);
                    for (int i = 0; i < 25f * boss.life[n] / boss.totalLife[n]; i++) {
                        canvas.drawRect(new Pixel(i, 0).getRect(), paint);
                    }
                }
            }

        }
    }

    public void drawGameOver(Paint paint, Canvas canvas) {

        for (int i = 0; i < alphabet.G().length; i++) {
            canvas.drawRect(new Pixel(alphabet.G()[i].x + 1, alphabet.G()[i].y + 5).getRect(),
                    paint);
        }
        for (int i = 0; i < alphabet.A().length; i++) {
            canvas.drawRect(new Pixel(alphabet.A()[i].x + 7, alphabet.A()[i].y + 5).getRect(),
                    paint);
        }
        for (int i = 0; i < alphabet.M().length; i++) {
            canvas.drawRect(new Pixel(alphabet.M()[i].x + 13, alphabet.M()[i].y + 5).getRect(),
                    paint);
        }
        for (int i = 0; i < alphabet.E().length; i++) {
            canvas.drawRect(new Pixel(alphabet.E()[i].x + 19, alphabet.E()[i].y + 5).getRect(),
                    paint);
        }
        for (int i = 0; i < alphabet.O().length; i++) {
            canvas.drawRect(new Pixel(alphabet.O()[i].x + 1, alphabet.O()[i].y + 13).getRect(),
                    paint);
        }
        for (int i = 0; i < alphabet.V().length; i++) {
            canvas.drawRect(new Pixel(alphabet.V()[i].x + 7, alphabet.V()[i].y + 13).getRect(),
                    paint);
        }
        for (int i = 0; i < alphabet.E().length; i++) {
            canvas.drawRect(new Pixel(alphabet.E()[i].x + 13, alphabet.E()[i].y + 13).getRect(),
                    paint);
        }
        for (int i = 0; i < alphabet.R().length; i++) {
            canvas.drawRect(new Pixel(alphabet.R()[i].x + 19, alphabet.R()[i].y + 13).getRect(),
                    paint);
        }
    }

    public void drawGameBegin(Paint paint, Canvas canvas) {

        for (int i = 0; i < alphabet.G().length; i++) {
            canvas.drawRect(new Pixel(alphabet.G()[i].x + 6, alphabet.G()[i].y + 9).getRect(),
                    paint);
        }

        for (int i = 0; i < alphabet.O().length; i++) {
            canvas.drawRect(new Pixel(alphabet.O()[i].x + 12, alphabet.O()[i].y + 9).getRect(),
                    paint);
        }
        for (int i = 0; i < alphabet.exclamation().length; i++) {
            canvas.drawRect(new Pixel(alphabet.exclamation()[i].x + 17, alphabet.exclamation()[i]
                    .y + 9).getRect(), paint);
        }
        for (int i = 0; i < alphabet.exclamation().length; i++) {
            canvas.drawRect(new Pixel(alphabet.exclamation()[i].x + 19, alphabet.exclamation()[i]
                    .y + 9).getRect(), paint);
        }
    }
}