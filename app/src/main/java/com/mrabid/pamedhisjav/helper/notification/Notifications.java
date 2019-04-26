package com.mrabid.pamedhisjav.helper.notification;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.RemoteViews;

import com.google.gson.Gson;
import com.mrabid.pamedhisjav.activity.NotificationActivity;
import com.mrabid.pamedhisjav.R;
import com.mrabid.pamedhisjav.model.Dokter;
import com.mrabid.pamedhisjav.model.User;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import static android.content.Context.MODE_NO_LOCALIZED_COLLATORS;

public class Notifications {
    private static final String CHANNEL_ID = "Notification";

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void displayNotification(Context context, String idUser, String title){
        int unique_code = new Random().nextInt(9999-1000)+1000;
        Log.e("idUser",idUser);
        String channel_id = "my_channel_01";
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.request_notification);

        // Set Notification Title
        @SuppressLint("WrongConstant") SharedPreferences sharedPreferences = context.getSharedPreferences("data",MODE_NO_LOCALIZED_COLLATORS);
        User user = new Gson().fromJson(sharedPreferences.getString("user",""),User.class);
        String strtitle = title;
        // Set Notification Text
        String strtext = "Hai "+user.getNama()+ ", kami meninjau bahwa dokter .....";

        Intent intent = new Intent(context, NotificationActivity.class);
        intent.putExtra("idUser", idUser);
        intent.putExtra("user", user);
        intent.putExtra("id_notif",unique_code+"");
        PendingIntent pIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.img_logo)
                .setChannelId(channel_id)
                .setAutoCancel(true)
                .setOngoing(true)
                .setContentIntent(pIntent)
                .setContent(remoteViews);

        remoteViews.setImageViewResource(R.id.notif_ivDokter,R.drawable.ic_1556099272_patient);
        remoteViews.setTextViewText(R.id.notif_tvContent,strtext);
        remoteViews.setTextViewText(R.id.notif_tvTitle,strtitle);
        remoteViews.setTextViewText(R.id.notif_tvTime, new SimpleDateFormat("HH:mm").format(new Date()));

        CharSequence name = strtitle;
        String description = strtext;
        int importance = NotificationManager.IMPORTANCE_DEFAULT;
        NotificationChannel channel = new NotificationChannel(channel_id, name, importance);
        channel.setDescription(description);

        NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);



        notificationManager.notify(unique_code, builder.build());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void displayNotificationTry(Context context, String x,String title){
        int unique_code = new Random().nextInt(9999-1000)+1000;
        String channel_id = "my_channel_01";
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.request_notification);

        // Set Notification Title
        String strtitle = title;
        // Set Notification Text
        String strtext = x;

        Intent intent = new Intent(context, NotificationActivity.class);
        /*intent.putExtra("dokter", dokter);
        intent.putExtra("user", user);*/
        intent.putExtra("id_notif",unique_code+"");
        PendingIntent pIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.img_logo)
                .setChannelId(channel_id)
                .setAutoCancel(true)
                .setOngoing(true)
                .setContentIntent(pIntent)
                .setContent(remoteViews);

        remoteViews.setImageViewResource(R.id.notif_ivDokter,R.drawable.ic_1556099272_patient);
        remoteViews.setTextViewText(R.id.notif_tvContent,strtext);
        remoteViews.setTextViewText(R.id.notif_tvTitle,strtitle);
        remoteViews.setTextViewText(R.id.notif_tvTime, new SimpleDateFormat("HH:mm").format(new Date()));

        CharSequence name = strtitle;
        String description = strtext;
        int importance = NotificationManager.IMPORTANCE_DEFAULT;
        NotificationChannel channel = new NotificationChannel(channel_id, name, importance);
        channel.setDescription(description);

        NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);



        notificationManager.notify(unique_code, builder.build());
    }

}
