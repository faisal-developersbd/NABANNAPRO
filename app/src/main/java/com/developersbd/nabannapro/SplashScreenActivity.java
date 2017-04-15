package com.developersbd.nabannapro;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.developersbd.nabannapro.database.dbfile;

/**
 * Created by navneet on 12/11/16.
 */

public class SplashScreenActivity extends Activity {
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String DATA = "data";
    dbfile db;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreenmaker);

        final ImageView imageView = (ImageView) findViewById(R.id.imageView);
        final Animation animation_1 = AnimationUtils.loadAnimation(getBaseContext(),R.anim.rotate);
        final Animation animation_2 = AnimationUtils.loadAnimation(getBaseContext(),R.anim.antirotate);
        final Animation animation_3 = AnimationUtils.loadAnimation(getBaseContext(),R.anim.abc_fade_out);

        imageView.startAnimation(animation_2);
        animation_2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedpreferences.edit();
                db = new dbfile(getBaseContext());
                String restoredText=sharedpreferences.getString(DATA,"empty");
                if(restoredText=="empty") {


                    db.init_limit();
                    db.init_sai();
                    db.init_crops();
                    db.init_category();
                    db.init_method();
                    db.init_landType();
                    db.init_nutritionStatus();

                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString(DATA,"initiated");
                    editor.commit();
                }
                else
                {
                    Log.d("dbfile","Database Initiated !!");



                }
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.startAnimation(animation_1);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        animation_1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.startAnimation(animation_3);
                finish();
                Intent i = new Intent(getBaseContext(),MainActivity.class);
                startActivity(i);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
