package com.rtrk.android.test.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.rtrk.android.test.R;
import com.rtrk.android.test.player.Playback;
import com.rtrk.android.test.sdk.BackendEmulator;

import static java.lang.Thread.sleep;

/**
 * Main activity
 *
 * @author ADD AUTHOR
 */
public class MainActivity extends Activity {

    private TextView tv;
    private ImageView iv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        tv = (TextView) findViewById(R.id.tv_splash);
        iv = (ImageView) findViewById(R.id.iv_splash);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.transition);
        tv.startAnimation(animation);
        iv.startAnimation(animation);
        final Intent play = new Intent(this, Playback.class);
        Thread splash = new Thread(){
            public void run(){
                try {
                    sleep (5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(play);
                    finish();
                }
            }
        };
            splash.start();
    }
}
