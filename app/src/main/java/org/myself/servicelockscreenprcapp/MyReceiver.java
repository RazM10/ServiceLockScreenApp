package org.myself.servicelockscreenprcapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {

    String TAG="Inservice";
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Log.d(TAG,"In BroadcastReceiver: ");
//        context.startService(new Intent(context,MyService.class));
    }
}
