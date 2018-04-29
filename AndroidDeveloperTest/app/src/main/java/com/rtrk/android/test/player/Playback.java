package com.rtrk.android.test.player;

import android.app.Activity;
import android.media.tv.TvContract;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.rtrk.android.test.R;
import com.rtrk.android.test.sdk.BackendEmulator;
import com.rtrk.android.test.sdk.models.ChannelEntity;

import java.util.List;

public class Playback extends Activity {

    VideoView videoView;
    Uri uri;
    private BackendEmulator backend;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_video);
        videoView = (VideoView) findViewById(R.id.vv_play);

        //Get backend reference
        backend = BackendEmulator.getInstance();
        uri = Uri.parse(backend.getActiveChannel().getUrl());   // get active channel (first channel)
        play(uri);

        String nameToast = backend.getActiveChannel().getName(); // get channel name
        Toast.makeText(Playback.this, "You are watching " + nameToast, Toast.LENGTH_LONG).show();  // show channel name

        final List<ChannelEntity> channelEntityList = backend.getChannels();  // create list of all channels from BackendEmulator

        final String[] data = new String[channelEntityList.size()];

        for (int i=0; i<channelEntityList.size();i++){
            data[i] = channelEntityList.get(i).getName();  // create list of names to display
        }

        ListView listView = (ListView) findViewById(R.id.lv_play);
        adapter = new ArrayAdapter<String>(Playback.this, R.layout.list_item, data);
        listView.setAdapter(adapter);   // populate list of channels in list view

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {   // change channel on click
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                uri = Uri.parse(channelEntityList.get(position).getUrl());
                play(uri);

                String nameToast = channelEntityList.get(position).getName();
                Toast.makeText(Playback.this, "You are watching " + nameToast,Toast.LENGTH_LONG).show();  // show channel name
            }
        });

        //TODO DO STUFF

        //Try to implement splash screen    ****  done
        //Try to play some video      *** done
        //Try to play actual channel   *** done
        //Try to implement info banner for current channel  *** only by toast
        //Try to implement next/previous channel   *** only by click on item in the list!
        //Try to implement channel list  *** done by listView
        //Try to implement time out on info banner   *** only by toast
        //Try to implement favorite list
        //Try to change application icon    ***  done
        //Try to remember last watched channel
        //Try to remember favorite list

    }
    // method for playing channel
    private void play(Uri uri){
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(this.uri);
        videoView.requestFocus();
        videoView.start();
    }


    @Override
    public void onBackPressed() {
        finish();
    }

}
