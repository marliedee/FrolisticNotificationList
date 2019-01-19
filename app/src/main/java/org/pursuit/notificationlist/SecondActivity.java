
package org.pursuit.notificationlist;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.pursuit.notificationlist.controller.ImageAdapter;
import org.w3c.dom.Text;

import static org.pursuit.notificationlist.MainActivity.imagesDisplay;
import static org.pursuit.notificationlist.MainActivity.intentGo;
import static org.pursuit.notificationlist.view.ImageViewHolder.froView;
import static org.pursuit.notificationlist.view.ImageViewHolder.intent2;
import static org.pursuit.notificationlist.view.ImageViewHolder.sharedPreferences;


public class SecondActivity extends AppCompatActivity {
    private Button button_update;
    private NotificationReceiver mReceiver = new NotificationReceiver();
    private static final String PRIMARY_CHANNEL_ID = "primary_notification_channel";
    private NotificationManager mNotifyManager;
    private static final int NOTIFICATION_ID = 0;
    private static final String ACTION_UPDATE_NOTIFICATION = "";
    public static SharedPreferences sp2;

    public void updateNotification() {

        Bitmap androidImage = BitmapFactory
                .decodeResource(getResources(), R.drawable.firstfroicon);
        NotificationCompat.Builder notifyBuilder = getNotificationBuilder();
        notifyBuilder.setStyle(new NotificationCompat.BigPictureStyle()
                .bigPicture(androidImage)
                .setBigContentTitle("Notification Updated!"));
        mNotifyManager.notify(NOTIFICATION_ID, notifyBuilder.build());


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        button_update = (Button) findViewById(R.id.update);
        sp2 = froView.getContext().getApplicationContext().getSharedPreferences("", Context.MODE_PRIVATE);

        Intent intent = new Intent(this, SecondActivity.class);
        int requestID = (int) System.currentTimeMillis();
        int flags = PendingIntent.FLAG_CANCEL_CURRENT;

        PendingIntent pendingIntent = PendingIntent.getActivity(this, requestID, intent, flags);
        Notification notification = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.firstfroicon)
                .setContentTitle("Notifications")
                .setContentText("Your Notes")
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build();

        registerReceiver(mReceiver, new IntentFilter(ACTION_UPDATE_NOTIFICATION));

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(NOTIFICATION_ID, notification);
//        intentGo = getIntent();

    }

    public void createNotificationChannel() {
        mNotifyManager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >=
                android.os.Build.VERSION_CODES.O) {

            NotificationChannel notificationChannel = new NotificationChannel(PRIMARY_CHANNEL_ID,
                    "THE Notification", NotificationManager
                    .IMPORTANCE_HIGH);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.BLACK);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription("Notification from Frolistic");
            mNotifyManager.createNotificationChannel(notificationChannel);
        }
    }

    private NotificationCompat.Builder getNotificationBuilder() {
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent notificationPendingIntent = PendingIntent.getActivity(this,
                NOTIFICATION_ID, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder notifyBuilder = new NotificationCompat.Builder(this, PRIMARY_CHANNEL_ID)
                .setContentTitle("You've been notified!")
                .setContentText("Black is Beautiful")
                .setSmallIcon(R.drawable.firstfroicon)
                .setContentIntent(notificationPendingIntent)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setAutoCancel(true);
        return notifyBuilder;

    }

    public void Click_Back(View view) {
        Intent intentTwo = new Intent(this, MainActivity.class);
        createNotificationChannel();
        updateNotification();
        startActivity(intentTwo);
    }


    public class NotificationReceiver extends BroadcastReceiver {

        public NotificationReceiver() {
        }

        @Override
        public void onReceive(Context context, Intent intent) {
            updateNotification();
        }
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(mReceiver);
        super.onDestroy();
    }
}
