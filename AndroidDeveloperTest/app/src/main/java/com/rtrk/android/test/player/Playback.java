package com.rtrk.android.test.player;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.rtrk.android.test.R;
import com.rtrk.android.test.sdk.BackendEmulator;

public class Playback extends Activity {

    VideoView videoView;

    private BackendEmulator backend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playback);
        //Get backend reference
        backend = BackendEmulator.getInstance();
        Uri uri = Uri.parse("http://abrademos-cdn.cellnextelecom.net/Content/HLS/Live/Channel(abrademo3)/index.m3u8");

        videoView = (VideoView) findViewById(R.id.vv_playback);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();






        //TODO DO STUFF

        //Try to implement splash screen    ****  done
        //Try to play some video      *** done
        //Try to play actual channel   *** done
        //Try to implement info banner for current channel
        //Try to implement next/previous channel
        //Try to implement channel list
        //Try to implement time out on info banner
        //Try to implement favorite list
        //Try to change application icon    ***  done
        //Try to remember last watched channel
        //Try to remember favorite list

    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
