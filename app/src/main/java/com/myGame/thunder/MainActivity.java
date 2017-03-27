package com.myGame.thunder;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {
    int maxSize;
    static float alpha;
    static MyPlane myplane = new MyPlane();
    static ArrayList<Boss> boss = new ArrayList<>();
    static ArrayList<Bullet> bullets = new ArrayList<>();
    static ArrayList<Enemy> enemy = new ArrayList<>();
    static ArrayList<Bullet> enemy_bullets = new ArrayList<>();
    //	boolean TouchEnable=false;
    int touchX;
    int touchY;
    static boolean begin = true;
    static boolean gameover = false;
    boolean paused = false;
    boolean bossIsOn;
    Timer timer = new Timer();
    RefreshThread task;
    BeginAni beginAni;
    int orientation = 8;
    static int score = 0;
    static int round = 1;
    int topScore;
    String name;
    DBUtils dbu;
    MainView mainView;
    ScoreView scoreView;
    RoundView roundView;
    RefreshHandler handler = new RefreshHandler(this);

    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        dbu = new DBUtils(this, "data.db3", 1);
        Cursor c = dbu.getReadableDatabase().rawQuery("select top_score,name from data", null);//.getInt(0);
        c.moveToNext();
        topScore = c.getInt(0);
        name = c.getString(1);
        c.close();
        //	requestWindowFeature(Window.FEATURE_NO_TITLE);
        //	getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams
        // .FLAG_FULLSCREEN);
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        maxSize = Math.min(metrics.widthPixels, metrics.heightPixels);
        alpha = (float) (maxSize / 338.0);//measured by ps, allowing for margin
        Pixel.setSize(alpha);
        SmallPixel.setSize(alpha);

        setContentView(R.layout.main_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_highest_score:
                        if (name != null) {
                            new AlertDialog.Builder(MainActivity.this).setMessage("Highest score : " + topScore + " " +
                                    "by " + name)//
                                    // .setNegativeButton(null, null)
                                    .create().show();
                        } else {
                            new AlertDialog.Builder(MainActivity.this).setMessage("No highest score!")//
                                    // .setNegativeButton(null, null)
                                    .create().show();
                        }
                        break;
                    case R.id.menu_about:
                        //		System.out.println("1");
                        String version = "Unknown";
                        try {
                            version = MainActivity.this.getPackageManager().getPackageInfo(
                                    MainActivity.this.getPackageName(), 0).versionName;
                        } catch (PackageManager.NameNotFoundException e) {
                            e.printStackTrace();
                        }
                        new AlertDialog.Builder(MainActivity.this).setMessage("Built by DK ZHOU\n2014/2/7 Ver: " +
                                version + "\nHave fun ;)")
                                // .setNegativeButton(null, null)
                                .create().show();
                        break;
                    case R.id.menu_exit:
                        MainActivity.this.finish();
                        break;
                }
                return true;
            }
        });
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.relativeLayout);
        LayoutParams gp = rl.getLayoutParams();
        gp.width = maxSize;
        gp.height = maxSize;
        rl.setLayoutParams(gp);
        mainView = (MainView) findViewById(R.id.mainView);
        scoreView = (ScoreView) findViewById(R.id.scoreView);
        roundView = (RoundView) findViewById(R.id.roundView);
        rl.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        if (!gameover) {
                            //		System.out.println("move");
                            touchX = (int) (event.getX() - (maxSize - mainView.getWidth()) / 2);
                            touchY = (int) (event.getY() - (maxSize - mainView.getHeight()) / 2);
                            //				TouchEnable = true;
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        //		System.out.println("up");

                        task.cancel();

                        paused = true;
                        //			TouchEnable=false;
                        break;
                    case MotionEvent.ACTION_DOWN:
                        //		System.out.println("down");
                        if (begin) {
                            beginAni.cancel();
                            begin = false;
                            startGame();
                        } else if (gameover) startGame();
                        else if (paused) {
                            int i = task.i;
                            int j = task.j;
                            //	timer=new Timer();
                            task = new RefreshThread(i, j);
                            timer.scheduleAtFixedRate(task, 0, 40);
                            paused = false;

                        }
                        touchX = (int) (event.getX() - (maxSize - mainView.getWidth()) / 2);
                        touchY = (int) (event.getY() - (maxSize - mainView.getHeight()) / 2);
                        //		TouchEnable = true;
                        break;
                }
                return true;
            }
        });
        AppCompatButton skillBtn1 = (AppCompatButton) findViewById(R.id.skillBtn1);
        skillBtn1.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                myplane.superSkill1();
            }
        });
        AppCompatButton skillBtn2 = (AppCompatButton) findViewById(R.id.skillBtn2);
        skillBtn2.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                myplane.superSkill2();
            }
        });
        skillBtn1.setSupportBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#329c8f")));
        skillBtn2.setSupportBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#329c8f")));
        ImageView filter = (ImageView) findViewById(R.id.imageView);
        gp = filter.getLayoutParams();
        gp.width = maxSize;
        gp.height = maxSize;
        filter.setLayoutParams(gp);
//        View decorView = getWindow().getDecorView();
//        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
//                | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
//                | View.SYSTEM_UI_FLAG_IMMERSIVE);
//        try {
//            //	getWindow().addFlags(WindowManager.LayoutParams.class.getField("FLAG_FULLSCREEN").getInt(null));
//            getWindow().addFlags(WindowManager.LayoutParams.class.getField("FLAG_NEEDS_MENU_KEY").getInt(null));
//        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        //	updateHighScore();
        //	startGame();
        beginAni = new BeginAni();
        timer.scheduleAtFixedRate(beginAni, 0, 400);
    }

//    public boolean onCreateOptionsMenu(Menu menu) {
//        menu.addSubMenu(0, 0, 0, "Highest score");
//        menu.addSubMenu(0, 1, 0, "About...");
//        menu.addSubMenu(0, 2, 0, "Exit");
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    public boolean onOptionsItemSelected(MenuItem mi) {
//        //	System.out.println(mi.getItemId());
//        switch (mi.getItemId()) {
//            case 0:
//                if (name != null) {
//                    new AlertDialog.Builder(this).setMessage("Highest score : " + topScore + " by " + name)//
//							// .setNegativeButton(null, null)
//                            .create().show();
//                } else {
//                    new AlertDialog.Builder(this).setMessage("No highest score!")//.setNegativeButton(null, null)
//                            .create().show();
//                }
//                break;
//            case 1:
//                //		System.out.println("1");
//                new AlertDialog.Builder(this).setMessage("Author : DK zhou\n2014/2/7 Ver : 1.2\nJust for fun :)")//
//						// .setNegativeButton(null, null)
//                        .create().show();
//                break;
//            case 2:
//                System.exit(0);
//                break;
//        }
//        return true;
//    }

    public void startGame() {
        myplane = new MyPlane();
        bullets = new ArrayList<>();
        enemy = new ArrayList<>();
        enemy_bullets = new ArrayList<>();
        boss = new ArrayList<>();
        paused = false;
        gameover = false;
        bossIsOn = false;
        score = 0;
        round = 1;
        //	TouchEnable=false;

        task = new RefreshThread(0, 1);
        timer.scheduleAtFixedRate(task, 0, 40);

    }

    public void updateHighScore() {
        final LinearLayout l = (LinearLayout) getLayoutInflater().inflate(R.layout.update_score, null);
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setView(l)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        String yourName = ((EditText) l.findViewById(R.id.nameText)).getText().toString();
                        if (yourName.length() == 0) yourName = "Anonymity";
                        dbu.getReadableDatabase().execSQL("update data set top_score = ?,name=?", new String[]{score
                                + "", yourName});
                        topScore = score;
                        name = yourName;
                    }
                })
                .create();
        dialog.setCancelable(false);
        dialog.show();
    }

    public void onDestroy() {
        super.onDestroy();
        if (dbu != null) dbu.close();
        timer.cancel();
        timer.purge();
    }

    static class RefreshHandler extends Handler {
        WeakReference<MainActivity> activity;

        RefreshHandler(MainActivity activity) {
            this.activity = new WeakReference<>(activity);
        }

        public void handleMessage(Message msg) {
            if (msg.what == 0x000) {
                MainActivity theActivity = activity.get();
                theActivity.mainView.invalidate();
                theActivity.scoreView.invalidate();
                theActivity.roundView.invalidate();
            }
            if (msg.what == 0x001) {
                MainActivity theActivity = activity.get();
                theActivity.updateHighScore();
            }
        }
    }

    class BeginAni extends TimerTask {
        public void run() {
            handler.sendEmptyMessage(0x000);
        }
    }

    class RefreshThread extends TimerTask {
        int i;
        int j;

        public RefreshThread(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public void run() {
            //	if(TouchEnable){
            if ((touchX / (Pixel.d + Pixel.size) < myplane.x) && (touchY / (Pixel.d + Pixel.size) - 1 < myplane.y))
                orientation = 4;
            else if ((touchX / (Pixel.d + Pixel.size) < myplane.x) && (touchY / (Pixel.d + Pixel.size) - 1 > myplane.y))
                orientation = 7;
            else if ((touchX / (Pixel.d + Pixel.size) > myplane.x) && (touchY / (Pixel.d + Pixel.size) - 1 < myplane.y))
                orientation = 5;
            else if ((touchX / (Pixel.d + Pixel.size) > myplane.x) && (touchY / (Pixel.d + Pixel.size) - 1 > myplane.y))
                orientation = 6;
            else if ((touchX / (Pixel.d + Pixel.size) < myplane.x) && (touchY / (Pixel.d + Pixel.size) - 1 == myplane
                    .y))
                orientation = 0;
            else if ((touchX / (Pixel.d + Pixel.size) == myplane.x) && (touchY / (Pixel.d + Pixel.size) - 1 < myplane
                    .y))
                orientation = 2;
            else if ((touchX / (Pixel.d + Pixel.size) > myplane.x) && (touchY / (Pixel.d + Pixel.size) - 1 == myplane
                    .y))
                orientation = 1;
            else if ((touchX / (Pixel.d + Pixel.size) == myplane.x) && (touchY / (Pixel.d + Pixel.size) - 1 > myplane
                    .y))
                orientation = 3;
            else orientation = 8;
            //	System.out.println(orientation+","+myplane.x+","+myplane.y+","+(touchX/alpha-32)/11+","+
            // (touchY/alpha-32)/11);
            //		}

            if (j % 500 == 0) {
                boss.add(new Boss1(12, -3));
                bossIsOn = true;
                j++;
            }
            if (i % 20 == 0 && !bossIsOn) {
                i = 0;
                if (new Random().nextInt(10) > 5) enemy.add(new Enemy1(new Random().nextInt(23) + 1, -1));
                else if (new Random().nextInt(10) > 2) enemy.add(new Enemy3(new Random().nextInt(23) + 1, -1));
                else {
                    enemy.add(new Enemy2(8, -1));
                    enemy.add(new Enemy2(16, -1));
                }
            }
            //		if(i%1==0){
            if (orientation != 8) {
                myplane.move(orientation);
                orientation = 8;
            }
            //	}
            if (i % 5 == 0) {
                myplane.shoot();
                for (int i = 0; i < boss.size(); i++) {
                    boss.get(0).next();
                }
            }


            for (int m = 0; m < bullets.size(); m++) {
                bullets.get(m).next();
                if (!bullets.get(m).isAlive()) {
                    bullets.remove(m);
                    m--;
                }
            }
            for (int m = 0; m < enemy_bullets.size(); m++) {
                if (i % 2 == 0) {
                    enemy_bullets.get(m).next();
                }
                if (!enemy_bullets.get(m).isAlive()) {
                    enemy_bullets.remove(m);
                    m--;
                }
            }
            for (int m = 0; m < enemy.size(); m++) {
                if (i % 5 == 0) {
                    enemy.get(m).next();
                }
                if (!enemy.get(m).isAlive()) {
                    enemy.remove(m);
                    m--;
                    continue;
                }
                int n = enemy.get(m).isShot(bullets);
                if (n != -1) {
                    bullets.remove(n);
                    score += 5;
                    enemy.remove(m);
                    m--;
                }
            }

            i++;
            if (bossIsOn) {
                if (boss.get(0).dead) {
                    bossIsOn = false;
                    boss.remove(0);
                    j++;
                } else {
                    int n = boss.get(0).isShot(bullets);
                    if (n != -1) {
                        bullets.remove(n);
                        boss.get(0).getHurt();
                    }
                }
            } else j++;
            if (myplane.isShot(enemy_bullets) != -1) {
                gameover = true;
                //		status=2;
                if (score > topScore) {
                    handler.sendEmptyMessage(0x001);
                }
            }
            handler.sendEmptyMessage(0x000);
            if (gameover) this.cancel();
        }
    }

}