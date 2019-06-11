package com.example.beat;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener {

    MediaPlayer mediaPlayer, mediaPlayer2;
    SoundPool soundPool;
    int explode = 0;
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        View view = new View(this);
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
        view.setOnTouchListener(this);

        setContentView(view);

        mediaPlayer = MediaPlayer.create(this,R.raw.backgroundmusic);
        mediaPlayer.start();
        mediaPlayer2 = MediaPlayer.create(this,R.raw.soundtrack);
        soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        explode = soundPool.load(this,R.raw.explosion,1);

        view.setBackgroundColor(Color.rgb(random.nextInt(256),random.nextInt(256),random.nextInt(2566)));
    }

    @Override
    public void onClick(View view) {
        if(explode != 0)
            soundPool.play(explode,1,1,0,0,1);
    }

    @Override
    public boolean onLongClick(View view) {
        mediaPlayer.stop();
        return false;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        view.setBackgroundColor(Color.rgb(random.nextInt(256),random.nextInt(256),random.nextInt(2566)));
        mediaPlayer2.start();
        return false;
    }
}
