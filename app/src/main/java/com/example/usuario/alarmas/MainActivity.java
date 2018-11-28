package com.example.usuario.alarmas;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button lanzar;
Button parar;
final static int codigo=111;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lanzar=findViewById(R.id.lanzar);
        parar=findViewById(R.id.parar);
        lanzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlarmManager alarmManager=(AlarmManager) getSystemService(Context.ALARM_SERVICE);
                Intent intent=new Intent(getApplicationContext(), Alarma.class);
                PendingIntent pendingIntent=PendingIntent.getBroadcast(getApplicationContext(), codigo, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 60*1000, pendingIntent);
            }
        });

        parar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlarmManager alarmManager=(AlarmManager) getSystemService(Context.ALARM_SERVICE);
                Intent intent=new Intent(getApplicationContext(), Alarma.class);
                PendingIntent pendingIntent=PendingIntent.getBroadcast(getApplicationContext(), codigo, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                alarmManager.cancel(pendingIntent);
            }
        });
    }
}
