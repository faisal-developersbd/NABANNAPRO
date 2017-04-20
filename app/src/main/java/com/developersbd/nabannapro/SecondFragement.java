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

public class SecondFragement extends Fragment {
    ImageButton btn1;
    ImageButton btn2;
    ImageButton btn3;
    View myview;
    @Nullable
    @Override


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myview= inflater.inflate(R.layout.secondlayout,container,false);
        btn1= (ImageButton) myview.findViewById(R.id.frBtn1);
        btn2= (ImageButton) myview.findViewById(R.id.frBtn2);
        btn3= (ImageButton) myview.findViewById(R.id.frBtn3);
        btn1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction())
                {
                    case MotionEvent.ACTION_UP:
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
                        FragmentManager fragmentManager=getFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.content_main,
                                new ThirdFragement()).commit();
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