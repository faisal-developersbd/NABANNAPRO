package com.developersbd.nabannapro;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
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

public class FirstFragement extends Fragment implements View.OnClickListener {
    View myview;
    Spinner category,crop,soilType;
    dbfile db;
    Cursor cursor;
    Button result;
    TextView stn,stp,sts,stb,stzn,stmg,stk;
    Context context;




    int[] cropsid;
    int[] categoryid;
    int[] soilid;

    int selectedCrop=0;
    int selectedSoil=0;

    int tracker=0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myview= inflater.inflate(R.layout.firstlayout,container,false);
        context=getActivity().getBaseContext();
        categoryid=new int[10000];
        soilid=new int[10000];
        cropsid=new int[10000];
        category=(Spinner)myview.findViewById(R.id.spinner);
        crop=(Spinner)myview. findViewById(R.id.spinner2);
        soilType=(Spinner) myview.findViewById(R.id.spinner3);
        result=(Button)myview.findViewById(R.id.btn_reslt);
        stn=(TextView) myview.findViewById(R.id.inp_stn);
        stp=(TextView) myview.findViewById(R.id.inp_stp);
        stb=(TextView) myview.findViewById(R.id.inp_stb);
        stk=(TextView) myview.findViewById(R.id.inp_stk);
        sts=(TextView) myview.findViewById(R.id.inp_sts);
        stzn=(TextView) myview.findViewById(R.id.inp_stzn);
        testFunc();

        db=new dbfile(context);
        try {
            addCategories();

        }catch (Exception e)
        {
            Log.d("fragement1","Error: "+e);
        }
        return myview;

    }

   // @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);

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

   // }
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

    void testFunc()
    {
        stn.setText("0.1");
        stp.setText("18");
        stk.setText("0.15");
        sts.setText("10");
        stzn.setText("1.0");
        stb.setText("0.2");

    }
    void addCategories()
    {
        cursor=db.getCategory();
        List<String> categories;  categories = new ArrayList<String>();
        categories.add("CATEGORY");
        if(cursor.getCount()>0)
        {
            Log.d("dbfile","Data found");
            int i=0;
            while(cursor.moveToNext())
            {
                try{
                    String value=cursor.getString(1);

                    categories.add(value);
                    categoryid[i]=Integer.parseInt(""+cursor.getString(0));
                    i++;
                }catch (Exception e)
                {
                    Log.d("dbfile","Error Category: "+e);
                }

            }
        }
        else
        {
            Log.d("dbfile","data not found");
        }

       /* categories.add("Automobile");
        categories.add("Business Services");
        categories.add("Computers");
        categories.add("Education");
        categories.add("Personal");
        categories.add("Travel");*/

        ArrayAdapter<String> myadapter=new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,categories);
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category.setAdapter(myadapter);
        category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position,
                                       long id) {
                //do something here
                int pos=position-1;
                String it=parent.getItemAtPosition(position).toString();
                if(!it.equals("CATEGORY")) {
                    addCrops(categoryid[pos]);

//                    Toast.makeText(context, "Position: " + position  + " Selected Item: " + parent, Toast.LENGTH_LONG).show();
              }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                //optionally do something here
            }
        });
//        category.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) context);
//        category.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//        });

    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
    }
    void addCrops(int id)
    {
        id=id;
        cursor=db.geAllCrops(id);
        List<String> crops = new ArrayList<String>();
        crops.add("CROPS");
        if(cursor.getCount()>0)
        {
            int i=0;
            while(cursor.moveToNext())
            {
                String value=cursor.getString(2);
                try
                {
                    String s=cursor.getString(2);
                    Log.d("dbfile",s);
                    cropsid[i]=Integer.parseInt(""+cursor.getString(0));
                    i++;
                }catch (Exception e)
                {
                    Log.d("dbfile","Error crops "+e);
                }

                crops.add(value);
            }
        }

       /* categories.add("Automobile");
        categories.add("Business Services");
        categories.add("Computers");
        categories.add("Education");
        categories.add("Personal");
        categories.add("Travel");*/

        ArrayAdapter<String> myadapter=new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,crops);
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        crop.setAdapter(myadapter);
        crop.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                int pos=position-1;
//                String it=parent.getItemAtPosition(position).toString();
//                if(!it.equals("CROPS")&&tracker==1)
//                {
                    addSoilType();
//                    tracker=2;
//                    selectedCrop=cropsid[pos];
//                    Toast.makeText(context, "Position: " + position + " Selected Item " + parent, Toast.LENGTH_LONG).show();

//                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    void addSoilType()
    {
        cursor=db.getAllSoilType();
        List<String> soils = new ArrayList<String>();
        soils.add("SOIL TYPE");
        if(cursor.getCount()>0)
        {
            int i=0;
            while(cursor.moveToNext())
            {
                try{
                    String value=cursor.getString(1);

                    soils.add(value);
                    soilid[i]=Integer.parseInt(""+cursor.getString(0));
                    i++;
                }catch (Exception e)
                {
                    Log.d("dbfile","Error Soil: "+e);
                }

            }
        }

       /* categories.add("Automobile");
        categories.add("Business Services");
        categories.add("Computers");
        categories.add("Education");
        categories.add("Personal");
        categories.add("Travel");*/

        ArrayAdapter<String> myadapter=new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,soils);
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        soilType.setAdapter(myadapter);
        soilType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                int pos=position-1;
//                String it=parent.getItemAtPosition(position).toString();
//                selectedSoil=soilid[pos];
            //    Toast.makeText(context, "Position: " + position + " item: " + it, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    @Override
    public void onClick(View v) {
       if(v.getId()==result.getId())
       {
           Toast.makeText(getActivity().getBaseContext(),"Hi there",Toast.LENGTH_LONG).show();
       }

    }
}
