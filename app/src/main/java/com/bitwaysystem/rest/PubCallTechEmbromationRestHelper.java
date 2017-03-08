package com.bitwaysystem.rest;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Fernando on 21/02/2017.
 */

public class PubCallTechEmbromationRestHelper {

    private static final String TAG = PubCallTechEmbromationRestHelper.class.getSimpleName();

    public static void callWaiterApi(Context context) {
        Log.d(TAG, "Sending Call Waiter.");
        Intent i = new Intent(context, PubCallTechEmbromationRestService.class);
        i.setAction("start");
        context.startService(i);
    }
}
