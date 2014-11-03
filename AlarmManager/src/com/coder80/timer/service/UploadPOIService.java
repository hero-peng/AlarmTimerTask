package com.coder80.timer.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;


/**
 * Created by coder80 on 2014/10/31.
 */
public class UploadPOIService extends Service implements Runnable{
    private String TAG = UploadPOIService.class.getSimpleName();
    @Override
    public void onCreate() {
        super.onCreate();
        uploadPOIInfo();
    }
    
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "UploadPOIService onDestroy here.... ");
    }

    private void uploadPOIInfo() {
    	//simulation HTTP request to server 
    	new Thread(this).start();
    }
    
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Log.i(TAG, "UploadPOIService beign to upload POI to server ");
			Thread.sleep(5*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stopSelf();
	}

}
