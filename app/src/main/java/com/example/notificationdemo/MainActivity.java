package com.example.notificationdemo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyTag";
    public static final String NOTIFICATION_ID = "1";
    public static final String NOTIFICATION_NAME = "Example";
    private NotificationManager nm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {

            Log.d(TAG, "Over O");

            createNotificationChannel();
            
        }else {

            Log.d(TAG, "Not Over O");

        }




    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createNotificationChannel() {

        NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_ID, NOTIFICATION_NAME, NotificationManager.IMPORTANCE_DEFAULT);

        notificationChannel.enableVibration(true);

        nm.createNotificationChannel(notificationChannel);
    }

    public void buttonSandNotification(View view) {

        NotificationCompat.Builder notBuilder = new NotificationCompat.Builder(MainActivity.this, NOTIFICATION_ID);

        notBuilder.setContentTitle("My Notification Title");
        notBuilder.setContentText("My Text");
        notBuilder.setSmallIcon(R.drawable.ic_android_black_24dp);

        nm.notify(1, notBuilder.build());
    }
}