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

    }



    public IBinder onBind(Intent intent){
        return null;
    }

}

