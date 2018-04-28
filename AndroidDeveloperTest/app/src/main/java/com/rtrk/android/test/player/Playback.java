package com.rtrk.android.test.player;

import android.app.Activity;
import android.media.tv.TvContract;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.rtrk.android.test.R;
import com.rtrk.android.test.sdk.BackendEmulator;

public class Playback extends Activity{

    VideoView videoView;
    Uri uri;
    private BackendEmulator backend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playback);
        //Get backend reference
        backend = BackendEmulator.getInstance();
        uri = Uri.parse(backend.getActiveChannel().getUrl());   // get first channel

        videoView = (VideoView) findViewById(R.id.vv_playback);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();

        Toast.makeText(this, "You are watching " + backend.getActiveChannel().getName(),Toast.LENGTH_LONG).show();


        //TODO DO STUFF

        //Try to implement splash screen    ****  done
        //Try to play some video      *** done
        //Try to play actual channel   *** done
        //Try to implement info banner for current channel  *** only toast!
        //Try to implement next/previous channel
        //Try to implement channel list
        //Try to implement time out on info banner
        //Try to implement favorite list
        //Try to change application icon    ***  done
        //Try to remember last watched channel
        //Try to remember favorite list

    }


    @Override
    public void onBackPressed() {
        uri = Uri.parse(backend.getActiveChannel().getUrl());
        finish();
    }

}
