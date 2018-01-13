package com.itm.mobile.itmbase;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Calendar;

import static android.content.Context.ALARM_SERVICE;


public class CondoBootStartReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        boolean sincAtivo = (PendingIntent.getBroadcast(context, 0, new Intent("com.itm.mobile.voto.CONDO_CHECK_DB"), PendingIntent.FLAG_NO_CREATE) == null);
        if(sincAtivo) {
            Intent intentAlarm = new Intent("com.itm.mobile.voto.CONDO_CHECK_DB");
            PendingIntent p = PendingIntent.getBroadcast(context, 0, intentAlarm, 0);

            Calendar c = Calendar.getInstance();
            c.setTimeInMillis(System.currentTimeMillis());
            c.add(Calendar.SECOND, 3);
            AlarmManager sincAlarme = (AlarmManager) context.getSystemService(ALARM_SERVICE);
            sincAlarme.setRepeating(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), 30000, p);
            Log.e("CondoBootStartReceiver", "Executado" + Calendar.DATE);
        }
    }
}
