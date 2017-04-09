package com.developersbd.nabannapro;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by TC on 3/30/2017.
 */

public class ThirdFragement extends Fragment {
    View myview;
    @Nullable
    @Override


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myview= inflater.inflate(R.layout.thirdlayout,container,false);
        return myview;
    }
}