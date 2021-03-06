package com.developersbd.nabannapro;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * Created by TC on 3/30/2017.
 */

public class ThirdFragement extends Fragment {
    View myview;
    ImageButton btn1;
    ImageButton btn2;
    ImageButton btn3;
    @Nullable
    @Override


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myview= inflater.inflate(R.layout.thirdlayout,container,false);
        btn1= (ImageButton) myview.findViewById(R.id.frBtn4);
        btn2= (ImageButton) myview.findViewById(R.id.frBtn5);
        btn3= (ImageButton) myview.findViewById(R.id.frBtn6);
        btn1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction())
                {
                    case MotionEvent.ACTION_UP:
                        FragmentManager fragmentManager=getFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.content_main,
                                new SecondFragement()).commit();
                        btn1.setAlpha(255);
                        break;
                    case MotionEvent.ACTION_DOWN:
                        btn1.setAlpha(100);break;
                    case MotionEvent.ACTION_MOVE:break;
                }
                return false;
            }
        });
        btn2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction())
                {
                    case MotionEvent.ACTION_UP:
                       btn2.setAlpha(255);
                        break;
                    case MotionEvent.ACTION_DOWN:
                        btn2.setAlpha(100);break;
                    case MotionEvent.ACTION_MOVE:break;
                }
                return false;
            }
        });
        btn3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction())
                {
                    case MotionEvent.ACTION_UP:
                        FragmentManager fragmentManager=getFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.content_main,
                                new FourFragment()).commit();
                        btn3.setAlpha(255);
                        break;
                    case MotionEvent.ACTION_DOWN:
                        btn3.setAlpha(100);break;
                    case MotionEvent.ACTION_MOVE:break;
                }
                return false;
            }
        });
        return myview;
    }
}