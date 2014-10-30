package com.procrastmenotapp.lkumar.procrastmenot;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.app.Service;
import android.content.IntentFilter;
import android.os.IBinder;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.app.IntentService;
import android.os.SystemClock;

import android.util.Log;

    public class UpdateService extends IntentService {

        public UpdateService() {
            super("UpdateService");
        }


        @Override
    public void onCreate() {
        super.onCreate();
    }

//    @Override
//    public int onStartCommand(Intent intent, int flag, int startId) {
//
//        Intent i = new Intent();
//        boolean screenOn = intent.getBooleanExtra("screen_state", false);
//
//        // Start Activity is alarm needs to be created
//
////        Intent dialogIntent = new Intent(getBaseContext(), AlertActivity.class);
////        dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
////        i.putExtra("screen_state", screenOn);
////
////
////        Log.i("UpdateService", "Starting AlertActivity");
////        getApplication().startActivity(dialogIntent);
//
//        return 1;
////        return super.onStartCommand(intent, flag, startId);
//
//    }



    @Override
    protected void onHandleIntent(Intent intent) {
        // At this point SimpleWakefulReceiver is still holding a wake lock
        // for us.  We can do whatever we need to here and then tell it that
        // it can release the wakelock.  This sample just does some slow work,
        // but more complicated implementations could take their own wake
        // lock here before releasing the receiver's.
        //
        // Note that when using this approach you should be aware that if your
        // service gets killed and restarted while in the middle of such work
        // (so the Intent gets re-delivered to perform the work again), it will
        // at that point no longer be holding a wake lock since we are depending
        // on SimpleWakefulReceiver to that for us.  If this is a concern, you can
        // acquire a separate wake lock here.
        for (int i=0; i<5; i++) {
            Log.i("SimpleWakefulReceiver", "Running service " + (i+1)
                    + "/5 @ " + SystemClock.elapsedRealtime());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
            }
        }
        Log.i("SimpleWakefulReceiver", "Completed service @ " + SystemClock.elapsedRealtime());
        ScreenReceiver.completeWakefulIntent(intent);
    }


    public IBinder onBind(Intent intent){
        return null;
    }

}

