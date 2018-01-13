package com.itm.mobile.services.sync;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;

import com.itm.mobile.voto.R;
import com.itm.mobile.dados.retrofit.models.SyncDb;
import com.itm.mobile.dados.retrofit.restclients.SyncRestClient;
import com.itm.mobile.util.UserSessionManager;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class SyncCheckReceiver extends BroadcastReceiver {

    SyncDb syncDb;

    SyncRestClient restClient = SyncRestClient.getInstance();

    private NotificationManager mNotifyManager;
    private NotificationCompat.Builder mBuilder;

    Context _context;

    SyncRestClient.ResultCallback restCallBack = new SyncRestClient.ResultCallback() {
        @Override
        public void resultReady(List<SyncDb> syncDb) {
            String tit_msg, msg;
            int img;
            Class dest;

            Log.e("SyncCheckReceiver", "SyncDB Size: " + syncDb.size());
            if (syncDb.size() > 0){
                for (SyncDb element: syncDb){
                    switch (element.tipo_atualiz) {
                        case 0:
                           /* img = R.drawable.ic_notification_portaria_visitante_32dp;
                            tit_msg = _context.getString(R.string.notif_seguranca);
                            msg = _context.getString(R.string.notif_seguranca_chegada);
                            dest = PortariaVisitanteTabActivity.class;
                            addNotification(tit_msg, msg, img, dest);*/

                            break;
                        case 1:
                            /*img = R.drawable.ic_notification_mensagem_32dp;
                            tit_msg = _context.getString(R.string.notif_mensagem);
                            msg = _context.getString(R.string.notif_mensagem_texto);
                            dest = PortariaVisitanteTabActivity.class; // mensagem
                            addNotification(tit_msg, msg, img, dest);*/

                            break;
                        case 2:
                           /* img = R.drawable.ic_notification_broadcast_32dp;
                            tit_msg = _context.getString(R.string.notif_broadcast);
                            msg = _context.getString(R.string.notif_broadcast_texto);
                            dest = PortariaVisitanteTabActivity.class; // mensagem
                            addNotification(tit_msg, msg, img, dest);*/

                            break;
                        case 3:
                            /*img = R.drawable.ic_notification_broadcast_32dp;
                            tit_msg = _context.getString(R.string.notif_correspondencia);
                            msg = _context.getString(R.string.notif_correspondencia_texto);
                            dest = PortariaVisitanteTabActivity.class; // mensagem
                            addNotification(tit_msg, msg, img, dest);*/

                            break;
                    }
                };
            }
        }
    };

    @Override
    public void onReceive(Context context, Intent intent) {
        _context = context;

        UserSessionManager userSession = new UserSessionManager(context.getApplicationContext());
        HashMap<String, String> user = userSession.getUserDetails();

        restClient.setCallback(restCallBack);
        restClient.checkSinc(user.get(UserSessionManager.KEY_UNIDADE_ID));
        Log.e("SyncCheckReceiver", "Executado" + Calendar.DATE);
    }

    private void addNotification(String titulo, String mensagem, int imagem, Class destino) {
        Intent resultintent;
        TaskStackBuilder stackBuilder;
        PendingIntent resultPendingIntent;
        mBuilder = new NotificationCompat.Builder(_context.getApplicationContext())
                .setSmallIcon(imagem)
                .setContentTitle(titulo)
                .setContentText(mensagem)
                .setAutoCancel(true);
        resultintent = new Intent(_context, destino);

        stackBuilder = TaskStackBuilder.create(_context.getApplicationContext());
        //stackBuilder.addParentStack(PortariaVisitanteTabActivity.class);
        stackBuilder.addNextIntent(resultintent);
        resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        mNotifyManager =
                (NotificationManager) _context.getSystemService(Context.NOTIFICATION_SERVICE);

        mNotifyManager.notify(0, mBuilder.build());
        // Vibrate the mobile phone
        Vibrator vibrator = (Vibrator) _context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(2000);
    }
}
