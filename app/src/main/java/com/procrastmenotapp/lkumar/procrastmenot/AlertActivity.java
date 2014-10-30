package com.procrastmenotapp.lkumar.procrastmenot;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;
import java.util.GregorianCalendar;


public class AlertActivity extends Activity {

    private static Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Log.i("AlertActivity", "Starting alert activity");
        setAlarm(getBaseContext());
    }

    public static void setAlarm(Context context)
    {

        Intent intent = new Intent(context, AlarmReceiver.class);
        PendingIntent sender = PendingIntent.getBroadcast(context, 2, intent, 0);

        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        am.setRepeating(AlarmManager.RTC_WAKEUP, 5 * 1000, 5 * 1000, sender);

        Log.i("AlertActivity", "ALARM HAS BEEN SET");

    }

    public static void cancelAlarm(Context context)
    {

        Intent intent = new Intent(context, AlarmReceiver.class);
        PendingIntent sender = PendingIntent.getBroadcast(context, 2, intent, 0);

        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        am.cancel(sender);
    }





}
