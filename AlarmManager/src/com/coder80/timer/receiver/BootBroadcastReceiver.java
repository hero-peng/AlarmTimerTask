package com.coder80.timer.receiver;

import com.coder80.timer.utils.Constants;
import com.coder80.timer.utils.ServiceUtil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;


/**
 * Created by coder80 on 2014/11/3.
 */
public class BootBroadcastReceiver extends BroadcastReceiver {
    private Context mContext;
    @Override
    public void onReceive(Context context, Intent intent) {
        mContext = context;
        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED) ||
                intent.getAction().equals(Intent.ACTION_USER_PRESENT)) {
            Log.i("BootBroadcastReceiver", "BroadcastReceiver onReceive here.... ");
            Handler handler = new Handler(Looper.getMainLooper());
            //after reboot the device,about 2 minutes later,upload the POI info to server
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(!ServiceUtil.isServiceRunning(mContext,Constants.POI_SERVICE)){
                        ServiceUtil.invokeTimerPOIService(mContext);
                    }
                }
            }, Constants.BROADCAST_ELAPSED_TIME_DELAY);
        }
    }
}

