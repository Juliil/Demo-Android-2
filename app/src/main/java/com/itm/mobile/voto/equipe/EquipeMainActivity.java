package com.itm.mobile.voto.equipe;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.itm.mobile.voto.R;

public class EquipeMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_equipe);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_equipe, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_menu_equipe_monitoramento:
                return true;
            case R.id.action_menu_equipe_checkin:
//                                intent = new Intent(MainActivity.this, AdmCrudCardapioListActivity.class);
//                                startActivity(intent);
                return true;
            case R.id.action_menu_equipe_troca_fiscal:
                return true;
            case R.id.action_menu_equipe_ausencia_temp:
                return true;
            case R.id.action_menu_equipe_alimentacao:
                return true;
            case R.id.action_menu_equipe_runoff:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
