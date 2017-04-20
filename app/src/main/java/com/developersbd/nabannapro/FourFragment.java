package com.developersbd.nabannapro;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * Created by TC on 4/15/2017.
 */

public class FourFragment extends Fragment {
    ImageButton btn1;
    ImageButton btn2;
    ImageButton btn3;
    View myview;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myview=inflater.inflate(R.layout.fourthlayout,container,false);
        btn1= (ImageButton) myview.findViewById(R.id.frBtn7);
        btn2= (ImageButton) myview.findViewById(R.id.frBtn8);
        btn3= (ImageButton) myview.findViewById(R.id.frBtn9);
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
