package com.a2cs2tron.youreawake;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.media.MediaPlayer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.alarm_button);
        final ImageView img= findViewById(R.id.imageView);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.century);
        final Spinner sp = findViewById(R.id.spinner);

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //Toggle Button stuff
                if(mp.isPlaying()) {
                    //Pause music
                    mp.pause();

                    //Move/Switch image
                    img.setImageResource(R.mipmap.alarm1);
                    button.setText("I AM AWAKE");
                } else {
                    //Play music
                    mp.start();

                    //Move/Switch image
                    img.setImageResource(R.mipmap.alarm2);
                    button.setText("OK");
                }
            }
        });
    }

}
