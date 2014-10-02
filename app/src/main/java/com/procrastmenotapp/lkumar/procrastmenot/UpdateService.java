package com.procrastmenotapp.lkumar.procrastmenot;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.app.Service;
import android.content.IntentFilter;
import android.os.IBinder;

import android.util.Log;

public class UpdateService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        // REGISTER RECEIVER THAT HANDLES SCREEN ON AND SCREEN OFF LOGIC
        IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        BroadcastReceiver mReceiver = new ScreenReceiver();
        registerReceiver(mReceiver, filter);
    }



    public IBinder onBind(Intent intent){
        return null;
    }

}

