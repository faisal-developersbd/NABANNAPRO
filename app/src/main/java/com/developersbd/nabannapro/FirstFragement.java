package com.developersbd.nabannapro;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
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
    FloatingActionButton fab;
    TextView stn,stp,sts,stb,stzn,stmg,stk;
    Context context;
    ArrayList<listItem> element;




    int[] cropsid;
    int[] categoryid;
    int[] soilid;

    String[] limits;
    String[] nut;
    float[] rangels;
    float[] rangecs;

    int selectedCrop=0;
    int selectedSoil=0;

    String[] resultset;
    String select="";



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
       result.setOnClickListener(this);
        select=getString(R.string.select);

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


    void load()
    {
        String vstn=stn.getText().toString();
        resultset=new String[50];

        Float[] st=new Float[10];
        for(int j=0;j<6;j++)
        {
            if(j==0) st[j]=Float.parseFloat(stn.getText().toString());
            else  if(j==1) st[j]=Float.parseFloat(stp.getText().toString());
            else  if(j==2) st[j]=Float.parseFloat(stk.getText().toString());
            else  if(j==3) st[j]=Float.parseFloat(sts.getText().toString());
            else  if(j==4) st[j]=Float.parseFloat(stzn.getText().toString());
            else  if(j==5) st[j]=Float.parseFloat(stb.getText().toString());

        }

        limits=new String[4];
        Float cs=0.0f;
        Float ls=0.0f;
        int a=0;
         nut=new String[]{"ni","ph","ka","sa","zn","bo"};
        for(int j=0;j<6;j++) {

            Cursor res = db.getSt(nut[j], 1);
            if (res.getCount() > 0) {
                 rangels = new float[4];
                rangecs = new float[4];
                int k = 0;
                while (res.moveToNext()) {
                    limits[k] = res.getString(0).toString();
                    cs = (Float) Float.parseFloat(res.getString(1).toString());
                    ls = (Float) Float.parseFloat(res.getString(2).toString());
                    Log.d("checkValue", "Other ls " + ls);
                    // Float f=(Float) Float.parseFloat(ls);
//                                if (st[j] >= ls) {
//                                    break;
//                                }
                    rangecs[k] = cs;
                    rangels[k] = ls;
                    k++;


                }
                for (int m = 0; m < 4; m++) {
                    for (int n = 0; n < 3; n++) {
                        if (rangels[n] > rangels[n + 1]) {
                            float temp = rangels[n + 1];
                            rangels[n + 1] = rangels[n];
                            String templ = limits[n + 1];
                            limits[n + 1] = limits[n];
                            limits[n] = templ;

                            rangels[n] = temp;
                        }
                    }
                }

                for (float fl : rangels)
                    Log.d("checkValue", "Sorted Other ls " + fl);

                Log.d("checkValue", "Check 0 index " + rangels[0]);
                String limitsf = "";
                if (st[j] >= rangels[3]) {
                    ls = rangels[3];
                    limitsf = limits[3];
                } else if (st[j] >= rangels[2]) {
                    ls = rangels[2];
                    limitsf = limits[2];
                } else if (st[j] >= rangels[1]) {
                    ls = rangels[1];
                    limitsf = limits[1];
                } else {
                    ls = rangels[0];
                    limitsf = limits[0];
                }
//                            if(rangecs[k])
                Float uf = 0.0f;
                Float ci = 0.0f;
                res = null;
                Log.d("checkValue", "nut: " + nut[j] + " Crop: " + selectedCrop + " limits:" + limitsf);
                res = db.getUfCi(nut[j], selectedCrop, limitsf);


                while (res.moveToNext()) {
                    uf = (Float) Float.parseFloat(res.getString(0).toString());
                    ci = (Float) Float.parseFloat(res.getString(1).toString());

                }
                Log.d("checkValue", "uf: " + uf);
                Log.d("checkValue", "ci: " + ci);
                Log.d("checkValue", "ls: " + ls);
                Log.d("checkValue", "cs: " + cs);
                Log.d("checkValue", "limits: " + limitsf);

                Float resn = uf - (ci / cs) * (st[j] - ls);

                Log.d("checkValue", "Calculation " + nut[j] + " : " + resn + " kg/ha");
                double finalresult = 0.0;
                if (nut[j].equals("ni")) {
                    resn = resn * (100.0f / 46.0f);
                } else if (nut[j].equals("ph")) {
                    resn = resn * (100f / 20f);
                } else if (nut[j].equals("ka")) {
                    resn = resn * (100.0f / 50.0f);
                } else if (nut[j].equals("sa")) {
                    resn = resn * (100.0f / 16.0f);
                } else if (nut[j].equals("zn")) {
                    resn = resn * (100.0f / 36.0f);
                } else if (nut[j].equals("bo")) {
                    resn = resn * (100.0f / 17.0f);
                }
                Log.d("checkValue", "st: " + st[j]);
                res = null;
                resultset[j]=""+resn;
                Log.d("result", "Final Result " + nut[j] + " : " + resn + " kg/ha");

            }
        }
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
        categories.add(select);
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
                if(!it.equals(select)) {
                    addCrops(categoryid[pos]);

                   // Toast.makeText(context, "Position: " + position  + " Selected Item: " + it, Toast.LENGTH_LONG).show();
              }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                //optionally do something here
            }
        });


    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

    }
    void addCrops(int id)
    {

        cursor=db.geAllCrops(id);
        List<String> crops = new ArrayList<String>();
        crops.add(select);
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



        ArrayAdapter<String> myadapter=new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,crops);
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        crop.setAdapter(myadapter);
        crop.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               int pos=position-1;
                String it=parent.getItemAtPosition(position).toString();
                if(!it.equals(select))
                {
                    addSoilType();
//                    tracker=2;
                    selectedCrop=cropsid[pos];

                    //Toast.makeText(context, "Position: " + position + " Selected Item " + it, Toast.LENGTH_LONG).show();

                }

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
        soils.add(select);
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



        ArrayAdapter<String> myadapter=new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,soils);
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        soilType.setAdapter(myadapter);
        soilType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int pos=position-1;
               String it=parent.getItemAtPosition(position).toString();
                if(!it.equals(select))
                {
                    selectedSoil=soilid[pos];
                      // Toast.makeText(context, "Position: " + position + " item: " + it, Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    ArrayList<listItem> getItemList()
    {
        load();
        element=new ArrayList<listItem>();
        String method="not initialized !!";
     //   Cursor res=db.getAppMethod(selectedCrop);
//        if(res.getCount()>0)
//        {
//            method=res.getString(0).toString();
//        }
        String unit=getString(R.string.unit);
        listItem items =null;
        String[] number=getResources().getStringArray(R.array.number);
        String header=getString(R.string.tbl_header);
        String[] fertilizer=getResources().getStringArray(R.array.fertilizer);
        for (int i=0;i<6;i++)
        {
            int j=i+1;
            items=new listItem(header+" "+number[j],fertilizer[i],resultset[i]+" "+unit);
            element.add(items);
            Log.d("debugAdapter","FirstFragement.java: nut- "+fertilizer[i]+" result- "+resultset[i]+" method- ");
        }



        return element;
    }
    @Override
    public void onClick(View v) {
       if(v.getId()==result.getId())
       {
          load();
       }


    }
}
