package com.developersbd.nabannapro;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;

import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.app.FragmentManager;
import android.widget.Toast;

import com.developersbd.nabannapro.database.dbfile;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String DATA = "data";
    dbfile db;

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedpreferences.edit();
        db = new dbfile(this);
        String restoredText=sharedpreferences.getString(DATA,"empty");
        if(restoredText=="empty") {


            db.init_limit();
            db.init_sai();
            db.init_crops();
            db.init_category();
            db.init_method();
            db.init_landType();

            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(DATA,"initiated");
            editor.commit();
        }
        else
        {
            Log.d("dbfile","Database Initiated !!");

            try {
               Cursor cursor = db.getAllData();
                if(cursor.getCount()==0)
                {
                    Toast.makeText(getBaseContext(),"No data",Toast.LENGTH_LONG).show();
                }
                else
                {
                    StringBuffer stringBuffer=new StringBuffer();
                    while (cursor.moveToNext())
                    {
                        stringBuffer.append("Id: "+cursor.getString(0));

                    }
                    Log.d("dbfile","Data: "+stringBuffer.toString());
                }


            }catch (Exception e)
            {
                Log.d("dbfile","error: "+e);
            }

        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


//        FragmentManager fragmentManager=getFragmentManager();
//        fragmentManager.beginTransaction().replace(R.id.content_main,
//                new FirstFragement()).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
       FragmentManager fragmentManager=getFragmentManager();

        if (id == R.id.first_frament) {
            // Handle the camera action
            fragmentManager.beginTransaction().replace(R.id.content_main,
                    new FirstFragement()).commit();
        } else if (id == R.id.second_fragement) {
            fragmentManager.beginTransaction().replace(R.id.content_main,
                    new SecondFragement()).commit();
        } else if (id == R.id.third_fragement) {
            fragmentManager.beginTransaction().replace(R.id.content_main,
                    new ThirdFragement()).commit();
        }
        else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
