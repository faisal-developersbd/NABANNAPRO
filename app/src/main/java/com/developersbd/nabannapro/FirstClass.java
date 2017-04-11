package com.developersbd.nabannapro;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.developersbd.nabannapro.database.dbfile;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FirstClass extends AppCompatActivity {
    Spinner category,crop,soilType;
    dbfile db;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstlayout);

        category=(Spinner)findViewById(R.id.spinner);
        crop=(Spinner) findViewById(R.id.spinner2);
        soilType=(Spinner) findViewById(R.id.spinner3);

        db=new dbfile(this);
        addCategories();
        addCrops();
        addSoilType();

    }
    void addCategories()
    {
        cursor=db.getCategory();
        List<String> categories = new ArrayList<String>();
        if(cursor.getCount()>0)
        {
            Log.d("dbfile","Data found");
            while(cursor.moveToNext())
            {
                String value=cursor.getString(1);

                categories.add(value);
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
    }
    void addCrops()
    {
        cursor=db.geAllCrops();
        List<String> crops = new ArrayList<String>();
        if(cursor.getCount()>0)
        {
            while(cursor.moveToNext())
            {
                String value=cursor.getString(2);
                try
                {
                    String s=cursor.getString(2);
                    Log.d("dbfile",s);
                }catch (Exception e)
                {
                    Log.d("dbfile","Third column crop not found");
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
    }
    void addSoilType()
    {
        cursor=db.getAllSoilType();
        List<String> crops = new ArrayList<String>();
        if(cursor.getCount()>0)
        {
            while(cursor.moveToNext())
            {
                String value=cursor.getString(1);

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
        soilType.setAdapter(myadapter);
    }
}
