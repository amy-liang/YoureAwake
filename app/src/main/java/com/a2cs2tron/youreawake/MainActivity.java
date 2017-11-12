package com.a2cs2tron.youreawake;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.alarm_button);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //Toggle Button stuff
                if(button.getText() == "I AM AWAKE") {
                    //Music stuff?
                    //Move/Switch image
                    button.setText("OK");
                } else {
                    //Stop music?
                    button.setText("I AM AWAKE");
                }
            }
        });
    }

}
