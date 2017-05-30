package com.developersbd.nabannapro;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
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
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.developersbd.nabannapro.database.dbfile;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FirstFragement firstFragement;
    SecondFragement secondFragement;
    ThirdFragement thirdFragement;
    ResultViewClass resultViewFragement;
    dbfile db;
    int trackFragement=0;
    ArrayList<listItem> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        db=new dbfile(getBaseContext());
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                FragmentManager fragmentManager=getFragmentManager();
             if(trackFragement==1)
             {
                 firstFragement.load();
                 try {

                 arrayList = new ArrayList<listItem>();
                arrayList = firstFragement.getItemList();
                    int cropid= firstFragement.getCropId();
                   Cursor result=  db.getAppMethod(cropid);
                     String method="";
                     if(result.getCount()>0)
                     {
                         while (result.moveToNext())
                         {
                             method=result.getString(0);
                             Log.d("dbfile","method: "+method);
                         }

                     }
                 resultViewFragement = new ResultViewClass();
                     resultViewFragement.setMethod(method);
                resultViewFragement.setArrayList(arrayList);

             }catch (Exception e)
                 {
                     Log.d("debugAdapter","MainActivity.java: "+e);
                 }
                 fragmentManager.beginTransaction().replace(R.id.content_main,
                         resultViewFragement).commit();
                 Log.e("tracfragement", "CurrentFragement:  " + "First Fragment");
             }
             else  if(trackFragement==2)
             {
                 Log.e("tracfragement", "CurrentFragement:  " + "Second Fragment");

             }
             else  if(trackFragement==3)
             {
                 Log.e("tracfragement", "CurrentFragement:  " + "Third Fragment");
             }



            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);




        FragmentManager fragmentManager=getFragmentManager();
        firstFragement=new FirstFragement();
        fragmentManager.beginTransaction().replace(R.id.content_main,
                firstFragement).commit();
        trackFragement=1;


    }
    void sendResultToResultView()
    {
        resultViewFragement.setArrayList(arrayList);
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if(trackFragement==1)
        {
            FragmentManager fragmentManager=getFragmentManager();
            firstFragement=new FirstFragement();
            fragmentManager.beginTransaction().replace(R.id.content_main,
                    firstFragement).commit();
//            trackFragement=1;
        }else  {
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
            firstFragement=new FirstFragement();
            fragmentManager.beginTransaction().replace(R.id.content_main,
                    firstFragement).commit();
            trackFragement=1;
        } else if (id == R.id.second_fragement) {
            secondFragement=new SecondFragement();
            fragmentManager.beginTransaction().replace(R.id.content_main,
                     secondFragement).commit();
            trackFragement=2;
        } else if (id == R.id.third_fragement) {
            thirdFragement=new ThirdFragement();
            fragmentManager.beginTransaction().replace(R.id.content_main,
                   thirdFragement).commit();
            trackFragement=3;
        }
        else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
