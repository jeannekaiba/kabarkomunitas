package com.example.ervin.kabarkomunitas;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
 ImageView iv;
Button sub;
    Animation frombottom, fromtop;
    Typeface tf3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();

        iv = (ImageView) findViewById(R.id.iv);
        sub = (Button) findViewById(R.id.sub);
        tf3 = Typeface.createFromAsset(getAssets(), "fonts/FredokaOne-Regular.ttf");
        Animation frombottom = AnimationUtils.loadAnimation(this,R.anim.frombottom);
        Animation fromtop = AnimationUtils.loadAnimation(this,R.anim.fromtop);
        sub.setAnimation(frombottom);
        iv.setAnimation(fromtop);
        sub.setTypeface(tf3);
        final Intent i = new Intent(this,LoginActivity.class);
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();
    }
}
