package com.itm.mobile.services.sync;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

public class SincCheckService extends IntentService {

    public SincCheckService() {
        super("SincCheckServiceThread");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }
}
