package com.developersbd.nabannapro;

import android.app.AlertDialog;
import android.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.developersbd.nabannapro.database.dbfile;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by TC on 3/30/2017.
 */

public class FirstFragement extends Fragment {
    View myview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myview= inflater.inflate(R.layout.firstlayout,container,false);
        return myview;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Button btn=(Button)getActivity().findViewById(R.id.btnSubmit);
       // Toast.makeText(getActivity().getBaseContext(),"test",Toast.LENGTH_LONG).show();
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Toast.makeText(getActivity().getBaseContext(),"test",Toast.LENGTH_LONG).show();
//                load();
//            }
//        });

//        Spinner category=(Spinner) getActivity().findViewById(R.id.spinner);
//        Spinner crop=(Spinner) getActivity().findViewById(R.id.spinner2);
//        Spinner soilType=(Spinner) getActivity().findViewById(R.id.spinner3);
//
//        category.setOnClickListener((View.OnClickListener) getActivity().getBaseContext());
//        List<String> categories = new ArrayList<String>();
//        categories.add("Automobile");
//        categories.add("Business Services");
//        categories.add("Computers");
//        categories.add("Education");
//        categories.add("Personal");
//        categories.add("Travel");

        // Creating adapter for spinner
//        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,categories,android.R.layout.simple_spinner_item);
//
//        // Drop down layout style - list view with radio button
//        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//        // attaching data adapter to spinner
//        category.setAdapter(dataAdapter);

    }
    void load()
    {
//        dbfile db=new dbfile(getActivity().getBaseContext());
//        try {
//            Cursor cursor = db.getCategory();
//            if(cursor.getCount()==0)
//            {
//                Toast.makeText(getActivity().getBaseContext(),"No data",Toast.LENGTH_LONG).show();
//            }
//            else
//            {
//                TextView viewT;
//                viewT=(TextView)getActivity().findViewById(R.id.textView2);
//
//                StringBuffer stringBuffer=new StringBuffer();
//                while (cursor.moveToNext())
//                {
//
//                    stringBuffer.append("data: "+cursor.getString(0)+"\t");
//                    stringBuffer.append("data: "+cursor.getString(1)+"\n");
//
//                }
//                viewT.setText(stringBuffer.toString());
////                AlertDialog.Builder builder=new AlertDialog.Builder(getActivity().getBaseContext());
////                builder.setCancelable(true);
////                builder.setTitle("Data");
////                builder.setMessage(stringBuffer.toString());
////                builder.show();
//              //  Log.d("dbfile","Data: "+stringBuffer.toString());
//                Toast.makeText(getActivity().getBaseContext(),"All Category Ids:"+stringBuffer,Toast.LENGTH_LONG).show();
//            }
//
//
//        }catch (Exception e)
//        {
//            Log.d("dbfile","error: "+e);
//        }
    }


}
