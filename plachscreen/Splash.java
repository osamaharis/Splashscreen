package com.example.plachscreen;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.support.animation.SpringForce;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {

    private static final long SPLASH_DISPLAY_LENGTH = 0;
    ProgressBar bar;
    Timer time;
    int i=0;
    TextView text;
    ImageView imag;

   // private final int SPLASH_DISPLAY_LENGTH = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

    bar = findViewById(R.id.progrss);
        bar.setProgress(0);

        text= findViewById(R.id.txt);
        text.setText(" ");

        final long period=100;
        time= new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {
            if(i<100)
                {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            text.setText(String.valueOf(i)+"%");

                        }
                    });
                    bar.setProgress(i);
                    i++;

                }else
            {

time.cancel();
Intent in= new Intent(getApplication(),MainActivity.class);
startActivity(in);
finish();
            }


               }

        },0,period);


//this is correct i just comment beacise i apply different methods so dont worry about it



        imag = findViewById(R.id.image);
        final Animation animation_1 = AnimationUtils.loadAnimation(getBaseContext(),R.transition.rotate);
       final Animation animation_2 = AnimationUtils.loadAnimation(getBaseContext(),R.transition.antirotate);
       final Animation animation_3 = AnimationUtils.loadAnimation(getBaseContext(),R.anim.abc_fade_out);

       // imag.startAnimation(animation_1);

       // click function for 2
        animation_2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

               imag.startAnimation(animation_1);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

                //imag.startAnimation(animation_2);
            }
        });


        //clockwise
         //move
        imag.startAnimation(animation_1);
        animation_1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

                //imag.startAnimation(animation_1);
//                Intent in = new Intent(Splash.this,MainActivity.class);
//                startActivity(in);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imag.startAnimation(animation_2);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
               imag.startAnimation(animation_1);
              // imag.startAnimation(animation_2);
            }
        });

    }
}






//
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//          Intent in= new Intent(Splash.this,MainActivity.class);
//          Splash.this.startActivity(in);
//          Splash.this.finish();
//            }
//        },SPLASH_DISPLAY_LENGTH);

//
//final ImageView imageView= (ImageView)findViewById(R.id.imageView);
// @SuppressLint("ResourceType") final Animation animation1= AnimationUtils.loadAnimation(getBaseContext(),R.drawable.rotation);
//@SuppressLint("ResourceType") final Animation animation2= AnimationUtils.loadAnimation(getBaseContext(),R.drawable.intirotation);
//        final Animation animation_3 = AnimationUtils.loadAnimation(getBaseContext(),R.drawable.);
//imageView.startAnimation(animation2);
//
//    animation2.setAnimationListener(new Animation.AnimationListener() {
//        @Override
//        public void onAnimationStart(Animation animation) {
//            imageView.startAnimation(animation1);
//        }
//
//        @Override
//        public void onAnimationEnd(Animation animation) {
//
//        }
//
//        @Override
//        public void onAnimationRepeat(Animation animation) {
//
//        }
//    });
//
//    animation1.setAnimationListener(new Animation.AnimationListener() {
//        @Override
//        public void onAnimationStart(Animation animation) {
//
//            imageView.startAnimation(animation_3);
//            finish();
//            Intent i = new Intent(getBaseContext(),MainActivity.class);
//            startActivity(i);
//        }
//
//        @Override
//        public void onAnimationEnd(Animation animation) {
//
//        }
//
//        @Override
//        public void onAnimationRepeat(Animation animation) {
//
//        }
//    });


