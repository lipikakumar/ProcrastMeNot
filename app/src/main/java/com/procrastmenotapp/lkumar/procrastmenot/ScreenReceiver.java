package com.procrastmenotapp.lkumar.procrastmenot;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.support.v4.content.WakefulBroadcastReceiver;

/**
 * Created by lkumar on 9/30/14.
 */
public class ScreenReceiver extends WakefulBroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent != null){
            if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {

                Log.i("ScreenReceiver", "Screen is off");
                AlarmSetter.cancelAlarm(context);

            } else if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {

                Log.i("ScreenReceiver", "Screen is on");

                AlarmSetter.setAlarm(context);
            }
        }
    }
}
