package org.myself.servicelockscreenprcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MediaPlayer mediaPlayer;

    Button btn_play, btn_stop, btn_startService, btn_stopService;

    String TAG = "checkClicked";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.a);

        btn_play = findViewById(R.id.btn_play);
        btn_stop = findViewById(R.id.btn_stop);
        btn_startService = findViewById(R.id.btn_startService);
        btn_stopService = findViewById(R.id.btn_stopService);

        btn_play.setOnClickListener(this);
        btn_stop.setOnClickListener(this);
        btn_startService.setOnClickListener(this);
        btn_stopService.setOnClickListener(this);
    }

    public void onClick(View view) {
        //Intent intent = new Intent(this, MyService.class);
        switch (view.getId()) {
            case R.id.btn_play:
                mediaPlayer.start();
                Toast.makeText(this, "Play Button Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_stop:
                mediaPlayer.pause();
                Toast.makeText(this, "Pause Button Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_startService:
                Intent intent = new Intent(this, MyService.class);
                Toast.makeText(this, "Service Start clicked", Toast.LENGTH_LONG).show();
                startService(intent);
                break;
            case R.id.btn_stopService:
                Intent intent2 = new Intent(this, MyService.class);
                Toast.makeText(this, "Service Stop clicked", Toast.LENGTH_LONG).show();
                stopService(intent2);
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
            Log.d(TAG, "Volume Up Button Clicked: " + keyCode);
        } else if (keyCode == KeyEvent.KEYCODE_BACK) {
            Log.d(TAG, "Back Button Clicked:" + keyCode);
        }
        return false;
    }

    @Override
    protected void onDestroy() {
        stopService(new Intent(this, MyService.class));
        super.onDestroy();
    }
}
