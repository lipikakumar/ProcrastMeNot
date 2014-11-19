package com.procrastmenotapp.lkumar.procrastmenot;

import android.content.Context;
import android.content.Intent;
import android.content.BroadcastReceiver;
import android.widget.Toast;

/**
 * Created by lkumar on 9/30/14.
 */
public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
       Toast.makeText(context, "Procrastmenot my dear!", Toast.LENGTH_LONG).show();
    }

}
