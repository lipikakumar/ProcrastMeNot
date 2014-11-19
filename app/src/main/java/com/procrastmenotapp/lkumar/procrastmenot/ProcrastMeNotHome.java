package com.procrastmenotapp.lkumar.procrastmenot;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;
import android.content.BroadcastReceiver;
import android.content.Intent;

public class ProcrastMeNotHome extends Activity {

    public BroadcastReceiver mReceiver;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_procrast_me_not_home);

        // Create intent to discover screen on and off action
        // http://thinkandroid.wordpress.com/2010/01/24/handling-screen-off-and-screen-on-intents/#respond
        IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);

        //Create broadcast receiver to listen to screen on and off events
        this.mReceiver = new ScreenReceiver();
        registerReceiver(this.mReceiver, filter);
    }

    protected void onResume() {
        super.onResume();
    }

}
