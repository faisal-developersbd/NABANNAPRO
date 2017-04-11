package com.developersbd.nabannapro;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.developersbd.nabannapro.database.dbfile;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FirstClass extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Spinner category,crop,soilType;
    dbfile db;
    Cursor cursor;
    Button result;
    TextView stn,stp,sts,stb,stzn,stmg,stk;

    int[] cropsid;
    int[] categoryid;
    int[] soilid;

    int selectedCrop=0;
    int selectedSoil=0;

    int tracker=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstlayout);

        categoryid=new int[10000];
        soilid=new int[10000];
        cropsid=new int[10000];
        category=(Spinner)findViewById(R.id.spinner);
        crop=(Spinner) findViewById(R.id.spinner2);
        soilType=(Spinner) findViewById(R.id.spinner3);
        result=(Button)findViewById(R.id.btn_reslt);
        stn=(TextView) findViewById(R.id.inp_stn);
        stp=(TextView) findViewById(R.id.inp_stp);
        stb=(TextView) findViewById(R.id.inp_stb);
        stk=(TextView) findViewById(R.id.inp_stk);
        sts=(TextView) findViewById(R.id.inp_sts);
        stzn=(TextView) findViewById(R.id.inp_stzn);
        testFunc();

        db=new dbfile(this);
        addCategories();
//        addCrops();
//        addSoilType();

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{

                    String vstn=stn.getText().toString();
//                    Float fstn=Float.parseFloat(vstn);
//                    Float fstp=Float.parseFloat(stp.getText().toString());
//                    Float fstk=Float.parseFloat(stk.getText().toString());
//                    Float fsts=Float.parseFloat(sts.getText().toString());
//                    Float fszn=Float.parseFloat(stzn.getText().toString());
//                    Float fstb=Float.parseFloat(stb.getText().toString());

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

                    String[] limits=new String[4];
                    Float cs=0.0f;
                    Float ls=0.0f;
                    int a=0;
                    String[] nut={"ni","ph","ka","sa","zn","bo"};
                    for(int j=0;a<6;j++) {

                        Cursor res = db.getSt(nut[j], 1);
                        if (res.getCount() > 0) {
                            float[] rangels=new float[4];
                            float[] rangecs=new float[4];
                            int k=0;
                            while (res.moveToNext()) {
                                limits[k] = res.getString(0).toString();
                                cs = (Float) Float.parseFloat(res.getString(1).toString());
                                ls = (Float) Float.parseFloat(res.getString(2).toString());
                                Log.d("checkValue", "Other ls " + ls);
                                // Float f=(Float) Float.parseFloat(ls);
//                                if (st[j] >= ls) {
//                                    break;
//                                }
                                rangecs[k]=cs;
                                rangels[k]=ls;
                                k++;


                            }
                            for(int m=0;m<4;m++)
                            {
                                for(int n=0;n<3;n++)
                                {
                                    if(rangels[n]>rangels[n+1])
                                    {
                                        float temp=rangels[n+1];
                                        rangels[n+1]=rangels[n];
                                        String templ=limits[n+1];
                                        limits[n+1]=limits[n];
                                        limits[n]=templ;

                                        rangels[n]=temp;
                                    }
                                }
                            }

                            for(float fl:rangels)
                                Log.d("checkValue", "Sorted Other ls " + fl);

                            Log.d("checkValue", "Check 0 index " + rangels[0]);
                            String limitsf="";
                            if(st[j]>=rangels[3])
                            {
                                ls=rangels[3];
                                limitsf=limits[3];
                            }

                            else  if(st[j]>=rangels[2])
                            {
                                ls=rangels[2];
                                limitsf=limits[2];
                            }
                            else if(st[j]>=rangels[1])
                            {
                                ls=rangels[1];
                                limitsf=limits[1];
                            }
                            else
                            {
                                ls=rangels[0];
                                limitsf=limits[0];
                            }
//                            if(rangecs[k])
                            Float uf = 0.0f;
                            Float ci = 0.0f;
                            res=null;
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

                                    Log.d("checkValue", "Calculation "+nut[j]+" : " + resn + " kg/ha");
                            double finalresult=0.0;
                            if(nut[j].equals("ni"))
                            {
                                resn=resn*(100.0f/46.0f);
                            }
                            else  if(nut[j].equals("ph"))
                            {
                                resn=resn*(100f/20f);
                            }
                            else  if(nut[j].equals("ka"))
                            {
                                resn=resn*(100.0f/50.0f);
                            }
                            else  if(nut[j].equals("sa"))
                            {
                                resn=resn*(100.0f/16.0f);
                            }
                            else  if(nut[j].equals("zn"))
                            {
                                resn=resn*(100.0f/36.0f);
                            }
                            else  if(nut[j].equals("bo"))
                            {
                                resn=resn*(100.0f/17.0f);
                            }
                            Log.d("checkValue", "st: " + st[j]);
                            res=null;

                            Log.d("result", "Final Result "+nut[j]+" : " + resn + " kg/ha");

                        }
                    }


                }catch (Exception e)
                {
                    Log.d("checkValue","Error: "+e);
                }



            }
        });

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
        List<String> categories = new ArrayList<String>();
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

        ArrayAdapter<String> myadapter=new ArrayAdapter<String>(FirstClass.this,android.R.layout.simple_list_item_1,categories);
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category.setAdapter(myadapter);
        category.setOnItemSelectedListener(this);
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

        ArrayAdapter<String> myadapter=new ArrayAdapter<String>(FirstClass.this,android.R.layout.simple_list_item_1,crops);
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        crop.setAdapter(myadapter);
        crop.setOnItemSelectedListener(this);
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

        ArrayAdapter<String> myadapter=new ArrayAdapter<String>(FirstClass.this,android.R.layout.simple_list_item_1,soils);
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        soilType.setAdapter(myadapter);
        soilType.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
       // position=position-1;
        int pos=position-1;
        String it=parent.getItemAtPosition(position).toString();
        if(it.equals("CATEGORY")||it.equals("CROPS")||it.equals("SOIL TYPE"))
        {

        }
        else
        {
            if(!it.equals("CATEGORY")&&tracker==0) {
                addCrops(categoryid[pos]);
                tracker=1;
                Toast.makeText(getBaseContext(), "Position: " + position  + " id: " + categoryid[pos], Toast.LENGTH_LONG).show();
            }
            else if(!it.equals("CROPS")&&tracker==1) {
                addSoilType();
                tracker=2;
                selectedCrop=cropsid[pos];
                Toast.makeText(getBaseContext(), "Position: " + position + " id: " + cropsid[pos], Toast.LENGTH_LONG).show();

            }
            else  {
                selectedSoil=soilid[pos];
                Toast.makeText(getBaseContext(), "Position: " + position + " item: " + it, Toast.LENGTH_LONG).show();
            }

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
