package com.itm.mobile.itmbase;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.itm.mobile.voto.MainActivity;
import com.itm.mobile.voto.R;
import com.itm.mobile.dados.ormlite.controller.TabelasRepo;
import com.itm.mobile.dados.ormlite.controller.UsuarioRepo;
import com.itm.mobile.dados.ormlite.model.Tabelas;
import com.itm.mobile.dados.ormlite.model.Usuario;
import com.itm.mobile.login.LoginActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class SplashActivity extends AppCompatActivity implements Runnable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Iniciar AlarmManager para Sinc Process
        //iniciaSincProcess();
        cancelSincProcess();

        // Temporary Populating Database
        populatingDatabase();

        ImageView mSplashButton = (ImageView) findViewById(R.id.ivSplash);
        mSplashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Intent intent = new Intent(SplashActivity.this, CondoMainActivity.class);
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();

            }
        });

        Handler handler = new Handler();
        handler.postDelayed(this, 3000);

    }

    public void run(){

        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
        //Intent intent = new Intent(SplashActivity.this, CondoMainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
        finish();
    }

    private void iniciaSincProcess() {

        boolean sincAtivo = (PendingIntent.getBroadcast(SplashActivity.this, 0, new Intent("com.itm.mobile.voto.CONDO_CHECK_DB"), PendingIntent.FLAG_NO_CREATE) == null);
        Log.e("SplashActivity", "sincAtivo..." + sincAtivo);
        if(sincAtivo) {
            Intent intent = new Intent("com.itm.mobile.voto.CONDO_CHECK_DB");
            PendingIntent p = PendingIntent.getBroadcast(SplashActivity.this, 0, intent, 0);

            Calendar c = Calendar.getInstance();
            c.setTimeInMillis(System.currentTimeMillis());
            c.add(Calendar.SECOND, 3);
            AlarmManager sincAlarme = (AlarmManager) getSystemService(ALARM_SERVICE);
            sincAlarme.setRepeating(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), 30000, p);
        }
    }

    private void cancelSincProcess() {

        boolean sincAtivo = (PendingIntent.getBroadcast(SplashActivity.this, 0, new Intent("com.itm.mobile.voto.CONDO_CHECK_DB"), PendingIntent.FLAG_NO_CREATE) == null);
        Log.e("SplashActivity", "sincAtivo..." + sincAtivo);
        if(sincAtivo) {
            Intent intent = new Intent("com.itm.mobile.voto.CONDO_CHECK_DB");
            PendingIntent p = PendingIntent.getBroadcast(SplashActivity.this, 0, intent, 0);
            AlarmManager sincAlarme = (AlarmManager) getSystemService(ALARM_SERVICE);
            sincAlarme.cancel(p);
        }
    }


    private void populatingDatabase() {

        TabelasRepo tabelasRepo = new TabelasRepo(this);

        if (tabelasRepo.findAll().size() == 0) {
            UsuarioRepo usuarioRepo = new UsuarioRepo(this);

            // Populating ServicosCategoria ListView
            Usuario usuario = new Usuario();
            ArrayList<Usuario> listUsuario = (ArrayList<Usuario>) usuario.populateCateg();
            for (Usuario elemento : listUsuario) {
                usuarioRepo.create(elemento);
            }

            // Populating tabelas ListView
            Tabelas tabelas = new Tabelas();
            tabelas = new Tabelas("TABELAS", 1);
            tabelasRepo.create(tabelas);

        }
    }

}
