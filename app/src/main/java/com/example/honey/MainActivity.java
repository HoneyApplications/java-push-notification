package com.example.honey;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("Hello world");
        //gerekli sürümler için bildirim kanalı oluşturuyoruz
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("myChannel", "my_channel", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        //bildirimimizi oluşturuyoruz
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, "myChannel");
        builder
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("HoneyApplications")
                .setContentText("Merhaba Dünya");
        //ve gönderiyoruz...
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);
        managerCompat.notify(1, builder.build());

    }

}