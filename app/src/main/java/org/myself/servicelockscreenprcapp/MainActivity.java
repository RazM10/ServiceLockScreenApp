package org.myself.servicelockscreenprcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MediaPlayer mediaPlayer;

    Button btn_play, btn_stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.a);

        btn_play = findViewById(R.id.btn_play);
        btn_stop = findViewById(R.id.btn_stop);

        btn_play.setOnClickListener(this);
        btn_stop.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_play:
                mediaPlayer.start();
                Toast.makeText(this, "Play Button Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_stop:
                mediaPlayer.pause();
                Toast.makeText(this, "Pause Button Clicked", Toast.LENGTH_SHORT).show();
                break;
        }
//        if(view==btn_play){
//            mediaPlayer.start();
//            Toast.makeText(this, "Play Button Clicked", Toast.LENGTH_SHORT).show();
//        }
//        else if(view==btn_stop){
//            mediaPlayer.pause();
//            Toast.makeText(this, "Stop Button Clicked", Toast.LENGTH_SHORT).show();
//        }
    }
}
