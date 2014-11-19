package com.procrastmenotapp.lkumar.procrastmenot;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by lkumar on 11/9/14.
 */

public class AlarmSetter {
    public static void setAlarm(Context context)
    {

        Log.i("AlarmSetter", "Setting the alarm");

        Intent intent = new Intent(context, AlarmReceiver.class);
        PendingIntent sender = PendingIntent.getBroadcast(context, 2, intent, 0);

        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        am.setExact(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+10000, sender);

    }

    public static void cancelAlarm(Context context)
    {
        Log.i("AlarmSetter", "Cancelling the alarm");

        Intent intent = new Intent(context, AlarmReceiver.class);
        PendingIntent sender = PendingIntent.getBroadcast(context, 2, intent, 0);

        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        am.cancel(sender);


    }
}