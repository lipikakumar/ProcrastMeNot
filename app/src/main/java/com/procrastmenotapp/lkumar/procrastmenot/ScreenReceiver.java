package com.procrastmenotapp.lkumar.procrastmenot;


import android.content.BroadcastReceiver;;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.support.v4.content.WakefulBroadcastReceiver;



/**
 * Created by lkumar on 9/30/14.
 */
public class ScreenReceiver extends WakefulBroadcastReceiver {

    public static boolean wasScreenOn;

    @Override
    public void onReceive(Context context, Intent intent) {
        this.wasScreenOn = true;

        Log.i("ScreenReceiver", "Screen is off");

        if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
            wasScreenOn = false;
            Log.i("ScreenReceiver", "Screen is off");

        } else if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
            wasScreenOn = true;
            Log.i("ScreenReceiver", "Screen is on");
        }


        // Send service an update if the screen has been turned off
        Intent i = new Intent(context, UpdateService.class);
        i.putExtra("screen_state", wasScreenOn);

        Log.i("ScreenReceiver", "Starting wakeful service");

//        context.startService(i);

        startWakefulService(context, i);
    }

}
