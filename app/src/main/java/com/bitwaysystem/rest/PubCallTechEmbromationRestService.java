package com.bitwaysystem.rest;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;


/**
 * Created by Fernando on 21/02/2017.
 */

public class PubCallTechEmbromationRestService extends Service {

    public static final String TAG = PubCallTechEmbromationRestService.class.getSimpleName();
    private final IBinder mBinder = new MyBinder();

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d(TAG, "onStartCommand: Start rest Service.");
        PubCallTechEmbromationRequestTask pubCallTechEmbromationRequestTask = new PubCallTechEmbromationRequestTask(getApplicationContext());

        pubCallTechEmbromationRequestTask.execute();
        Log.d(TAG, "onStartCommand: rest Service finish.");

        return Service.START_NOT_STICKY;
    }

    public class MyBinder extends Binder {
        PubCallTechEmbromationRestService getService() {
            return PubCallTechEmbromationRestService.this;
        }
    }
}
