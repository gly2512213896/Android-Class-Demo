package cn.edu.sit.todayapplication.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class StaticReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("StaticReceiver", "onReceive: ");
        Toast.makeText(context,"From Static",Toast.LENGTH_LONG).show();
    }

}