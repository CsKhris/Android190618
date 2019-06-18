package com.cs.notification;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.Toast;

public class SoundActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound);

        Button vib = (Button)findViewById(R.id.vib);
        Button syssound = (Button)findViewById(R.id.syssound);
        Button ressound = (Button)findViewById(R.id.ressound);

        vib.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                // 진동 객체 생성
                Vibrator vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);
                // 진동
                vibrator.vibrate(10000);
            }
        });

        syssound.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                // System Sound의 경로 가져오기(실제 Sound가 아닙니다.)
                Uri noti = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALL);
                // 재생 가능한 Sound 만들기
                Ringtone ringtone = RingtoneManager.getRingtone(getApplicationContext(), noti);
                // 재생
                ringtone.play();
            }
        });

        ressound.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                MediaPlayer player = MediaPlayer.create(getApplicationContext(), R.raw.buttoneffect);

                player.start();
            }
        });

        Button toast = findViewById(R.id.toast);
        toast.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(getApplicationContext(),
                        "Toast String", Toast.LENGTH_LONG).
                        show();
            }
        });

    }
}
