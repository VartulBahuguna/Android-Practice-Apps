package com.codingblocks.broadcastrecivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class LocaleChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d("RSCV", "LOCALE");
        Toast.makeText(context, "Languaged Changed",Toast.LENGTH_SHORT).show();
        context.startActivity(new Intent(context, MainActivity.class));
    }
}
