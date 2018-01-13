package com.itm.mobile.voto;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.itm.mobile.dados.ormlite.model.Usuario;
import com.itm.mobile.util.Session;
import com.itm.mobile.util.UserSessionManager;
import com.itm.mobile.voto.apuracao.ApuracaoMainActivity;
import com.itm.mobile.voto.equipe.EquipeMainActivity;
import com.itm.mobile.voto.ocorrencias.OcorrenciaCategoriaMainActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String LOG_TAG = MainActivity.class.getSimpleName();

    private UserSessionManager userSession;

    private DrawerLayout mDrawerLayout;

    private Toolbar toolbar;

    Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        //getSupportActionBar().setIcon(R.drawable.ic_action_logo_filedochef_36dp);

        usuario = (Usuario) getIntent().getSerializableExtra("USUARIO");

        // Session class instance
        userSession = new UserSessionManager(getApplicationContext());

       /* // Check user login
        // If User is not logged in , This will redirect user to LoginActivity.
        if(userSession.checkLogin())
            finish();

        // get user data from userSession
        HashMap<String, String> user = userSession.getUserDetails();

        // get name
        String name = user.get(UserSessionManager.KEY_NAME);

        // get email
        String email = user.get(UserSessionManager.KEY_EMAIL);*/

        setupDrawer();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setupDrawer() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        if (navigationView != null) {
            ImageView iv_perfil =  (ImageView) navigationView.getHeaderView(0).findViewById(R.id.iv_perfil);
            TextView tv_perfil_nome = (TextView) navigationView.getHeaderView(0).findViewById(R.id.tv_perfil_nome);
            TextView tv_perfil_username = (TextView) navigationView.getHeaderView(0).findViewById(R.id.tv_perfil_username);

            String strFile = "file:///android_asset/img/" + usuario.getAvatar();

            Picasso.with(this)
                    .load(strFile)
                    .fit()
                    .error(R.drawable.ic_person_add_white_48dp)
                    .tag(this)
                    .into(iv_perfil);

            tv_perfil_nome.setText(usuario.getNome());
            tv_perfil_username.setText(usuario.getLogin());
            setupDrawerContent(navigationView);
        }
    }

    private void setupDrawerContent(NavigationView navigationView) {

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        Intent intent;
                        switch (menuItem.getItemId()) {
                            case R.id.nav_config:
                                break;
                            case R.id.nav_equipe:
                                intent = new Intent(MainActivity.this, EquipeMainActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.nav_ocorrencias:
                                intent = new Intent(MainActivity.this, OcorrenciaCategoriaMainActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.nav_bocadeurna:
                                intent = new Intent(MainActivity.this, ApuracaoMainActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.nav_crud_perfil:
//                                intent = new Intent(MainActivity.this, AdmCrudCardapioListActivity.class);
//                                startActivity(intent);
                                break;
                        }
                        return true;
                    }
                });
    }

    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this)
                .setTitle(R.string.app_name)
                .setMessage(R.string.lbl_sair_app)
                .setCancelable(false)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        closeApplication(); // Close Application method called
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

    private void closeApplication() {
        this.finish();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
