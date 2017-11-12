package com.a2cs2tron.youreawake;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
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

        final Spinner sp = findViewById(R.id.spinner);
        final Button button = findViewById(R.id.alarm_button);
        final ImageView img= findViewById(R.id.imageView);
        final MediaPlayer alarmMP = MediaPlayer.create(this, R.raw.alarm);
        final MediaPlayer centuryMP = MediaPlayer.create(this, R.raw.century);
        final MediaPlayer toxicMP = MediaPlayer.create(this, R.raw.toxic);


        String CHANNEL_ID = "my_channel_01";
        final NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this, CHANNEL_ID)
                        .setSmallIcon(R.mipmap.alarm1)
                        .setContentTitle("YOU'RE AWAKE")
                        .setContentText("YOU'RE AWAKE!")
                        .setDefaults(Notification.DEFAULT_ALL)
                        .setPriority(NotificationManager.IMPORTANCE_HIGH);
        Intent resultIntent = new Intent(this, ResultActivity.class);
        PendingIntent resultPendingIntent =
                PendingIntent.getActivity(
                        this,
                        0,
                        resultIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setAutoCancel(true);
        mBuilder.setContentIntent(resultPendingIntent);

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                MediaPlayer mp;
                String songTitle = sp.getSelectedItem().toString();

                //select song
                if (songTitle.equals("alarm")) {
                    mp = alarmMP;
                }
                else if (songTitle.equals("toxic")){
                    mp = toxicMP;
                }
                else {
                    mp = centuryMP;
                }

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

                if(button.getText() == "OK"){
                    int mNotificationId = 001;
                    // Gets an instance of the NotificationManager service
                    NotificationManager mNotifyMgr =
                            (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                    // Builds the notification and issues it.
                    mNotifyMgr.notify(mNotificationId, mBuilder.build());
                }
            }
        });
    }

}
