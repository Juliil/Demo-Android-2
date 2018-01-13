package com.itm.mobile.util;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.NotificationCompat;
import android.util.Base64;

import com.itm.mobile.voto.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Tools {

    public static String OpenImageInAssets(Context context, String imageName){
        String encodedImageBase64 = "";
        AssetManager assetManager = context.getAssets();
        InputStream fileStream = null;
        try {
            fileStream = assetManager.open(imageName);
            if(fileStream != null){

                Bitmap bitmap = BitmapFactory.decodeStream(fileStream);
                // Convert bitmap to Base64 encoded image for web
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

                // to get image extension file name split the received
                int fileExtensionPosition = imageName.lastIndexOf('.');
                String fileExtension = imageName.substring(fileExtensionPosition+1);
                //                  Log.d(IConstants.TAG,"fileExtension: " + fileExtension);

                if(fileExtension.equalsIgnoreCase("png")){
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    //                      Log.d(IConstants.TAG,"fileExtension is PNG");
                }else if(fileExtension.equalsIgnoreCase("jpg") || fileExtension.equalsIgnoreCase("jpeg")){
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                    //                      Log.d(TAG,"fileExtension is JPG");
                }

                byte[] byteArray = byteArrayOutputStream.toByteArray();
                String imgageBase64 = Base64.encodeToString(byteArray, Base64.DEFAULT);
                encodedImageBase64 = "data:image/png;base64," + imgageBase64;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return encodedImageBase64="";
        }
        finally {
            //Always clear and close
            try {
                if(fileStream != null) {
                    fileStream.close();
                    fileStream = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//      Log.d(TAG,"encodedImageBase64: " + encodedImageBase64);
        return encodedImageBase64;
    }

    public static void alertMessageOK(Context context, int title, int message) {
        new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setNeutralButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setIcon(R.drawable.ic_dialog_alert_64dp)
                .show();
    }

    public static void alertMessageSN(final Context context, int title, int message) {
        new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    public static void addNotification(Context context, Class classe, String titulo, String text, int imagem) {
        android.support.v4.app.NotificationCompat.Builder builder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(imagem)
                        .setContentTitle(titulo)
                        .setContentText(text)
                        .setAutoCancel(true);

        Intent notificationIntent = new Intent(context, classe);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }
}